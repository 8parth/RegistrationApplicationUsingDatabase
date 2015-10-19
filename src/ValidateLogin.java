

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

import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class ValidateLogin
 */
@WebServlet("/ValidateLogin")
public class ValidateLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("un");
		String passwd = request.getParameter("passwd");
		
		// Database conntection
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c;
			c = DriverManager.getConnection(
					"jdbc:mysql://localhost/tab_emp", "root", "root");

			Statement s = c.createStatement();

			ResultSet rs = (ResultSet) s.executeQuery("select * from customer where un =" +uname );
			
			while (rs.next()) {
				HttpSession session = request.getSession();
				
				String table_uname = rs.getString("un");
				String table_fname = rs.getString("fn");
				String table_lname = rs.getString("ln");
				String table_pass = rs.getString("pass");
				
				session.setAttribute("fn", table_fname);
				session.setAttribute("ln", table_lname);
				session.setAttribute("un", table_uname);
				session.setAttribute("passwd", table_pass);
				
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Class.forName("com.mysql.jdbc.Driver");
 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
