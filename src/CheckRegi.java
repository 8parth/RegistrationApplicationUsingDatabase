

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckRegi
 */
@WebServlet("/CheckRegi")
public class CheckRegi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckRegi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		String fname = request.getParameter("fn");
		String lname = request.getParameter("ln");
		String uname = request.getParameter("un");
		String passwd = request.getParameter("passwd");
		String c_passwd = request.getParameter("c_passwd");
		
		
		if(passwd.equals(c_passwd)){
/*			session.setAttribute("fn", fname);
			session.setAttribute("ln", lname);
			session.setAttribute("un", uname);
			session.setAttribute("passwd", passwd);
			session.setAttribute("c_passwd", c_passwd);
*/			
			try {
				// Database conntection
				Class.forName("com.mysql.jdbc.Driver");
				// Class.forName("com.mysql.jdbc.Driver");
				Connection c;
				c = DriverManager.getConnection(
						"jdbc:mysql://localhost/tab_emp", "root", "root");

				Statement s = c.createStatement();

				s.executeUpdate("insert into customer (fn,ln,un,passwd,c_passwd) values ('"
						+ fname
						+ "','"
						+ lname
						+ "','"
						+ uname
						+ "','"
						+ passwd
						+ "','" 
						+ c_passwd 
						+ "');");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("sql exception");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("class not found exception");
			} finally {

			}


	
			response.sendRedirect("Login_user.jsp");
		}else{
			response.sendRedirect("Register.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
