import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exhalia.CScentDiffusionContext;

public class DiffuseServlet extends HttpServlet {
	/**
	 *  
	 */
	CScentDiffusionContext diffusionContext = new CScentDiffusionContext("","","","","","","");
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.getRequestDispatcher("/WEB-INF/views/diffuse.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String conf = request.getParameter("conf");
		try {
			diffusionContext.DiffuseCommand(conf);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/views/diffuse.html").forward(request, response);
	}
}