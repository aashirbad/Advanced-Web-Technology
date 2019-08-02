

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Profile_View
 */
@WebServlet("/profile_ViewControl")
public class Profile_View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile_View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int res = (int) request.getAttribute("RES");
		PrintWriter out = response.getWriter();
		if (res == 0)
			out.println("There is some problem ;  Try again .");
		else
			out.println("Data Successfully inserted");
		out.print(" <br/> The Datas are");
		List<Profile_Bean> list = new Profile_Save().fetchAll();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Profile_Bean profile = (Profile_Bean) iterator.next();
			out.println("Name : "+ profile.getName() +" Userid : "+ profile.getId()+ "mobile "+ profile.getMob());
		}
		

	}	
	

}
