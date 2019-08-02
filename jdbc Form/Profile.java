		
	/* NAME : AASHIRBAD MAHARANA
	REDG NO	: 170301120116  */


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/profileAction")
public class Profile extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Profile_Bean profile = new Profile_Bean();
	profile.setId(request.getParameter("id"));
	profile.setName(request.getParameter("name"));
	profile.setMail(request.getParameter("email"));
	profile.setMob(request.getParameter("mob"));
	
	//System.out.println(request.getParameter("name"));
	
	// save All 
	int res = new Profile_Save().save(profile);
	
	System.out.println(res);
	request.setAttribute("RES", res);
	request.getRequestDispatcher("/profile_ViewControl").forward(request, response);
	}
}
