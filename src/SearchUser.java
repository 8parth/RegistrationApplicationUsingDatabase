import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("search_fname");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c;
			c = DriverManager.getConnection("jdbc:mysql://localhost/tab_emp",
					"root", "root");

			Statement s = c.createStatement();

			ResultSet rs = s.executeQuery("select * from customer where fn ='"+fname+"'");
			PrintWriter out = response.getWriter();
			out.print("<table border='1'>");
			
			out.print("<tr>");
			out.print("<td> ID</td>");
			out.print("<td> FN</td>");
			out.print("<td> LN</td>");
			out.print("<td> UN</td>");
			out.print("<td> PASSWORD</td>");
			out.print("<td> UPDATE/DELETE </td>");
			out.print("</tr>");
			
			while (rs.next()) {
				//HttpSession session = request.getSession();

				String table_uname = rs.getString("un");
				String table_fname = rs.getString("fn");
				String table_lname = rs.getString("ln");
				String table_pass = rs.getString("passwd");
				int table_id = rs.getInt("id");
				
				out.print("<tr>");
				out.print("<td>"+table_id +" </td>");
				out.print("<td>"+table_fname +"</td>");
				out.print("<td>"+table_lname +"</td>");
				out.print("<td> "+table_uname +"</td>");
				out.print("<td> "+table_pass +"</td>");
				out.print("<td>");
				out.print("<a href='DeleteUser?id="+table_id+"'>delete</a>");
				out.print("<a href='EditUser?id="+table_id+"'>edit</a>");
				out.print("</td>");
				out.print("</tr>");
				
				
				
				
				
				
/*				session.setAttribute("fn", table_fname);
				session.setAttribute("ln", table_lname);
				session.setAttribute("un", table_uname);
				session.setAttribute("passwd", table_pass);
				session.setAttribute("id", table_id);

				System.out.println("Customer data: " + "\n" + "FN:"
						+ table_fname + "\n" + "LN:" + table_lname + "\n"
						+ "UN:" + table_uname + "\n" + "PASSWORD:" + table_pass
						+ "\n" + "ID:" + table_id);
				
				*/
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
