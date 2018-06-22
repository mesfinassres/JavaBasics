import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class VibrateServlet extends HttpServlet {
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		response.setContentType("text/html");
		String filename = "C:/ProgramData/SteelSeries/SteelSeries Engine 3/coreProps.json";
		response.setHeader("Access-Control-Allow-Origin", "*");
        //ServletContext context = getServletContext();

        // First get the file InputStream using ServletContext.getResourceAsStream()
        // method.
        //InputStream is = context.getResourceAsStream(filename);
		InputStream is = new FileInputStream(filename);
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
			response.getWriter().write(reader.readLine());
            //PrintWriter writer = response.getWriter();
            //String text;

            // We read the file line by line and later will be displayed on the
            // browser page.
            //while ((text = reader.readLine()) != null) {
                //writer.println(text + "</br>");
			//	writer.print(text);
            //}
        }
	}
}