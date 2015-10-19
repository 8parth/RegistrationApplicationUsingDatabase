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


/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c;
			c = DriverManager.getConnection("jdbc:mysql://localhost/tab_emp",
					"root", "root");

			Statement s = c.createStatement();

			ResultSet rs =s.executeQuery("select * from customer where id = " +id);
			String tab_uname="", tab_fname="",tab_lname="",tab_pass="";
			int tab_id=99;
			if(rs.next()){
				tab_uname = rs.getString("un");
				tab_fname = rs.getString("fn");
				tab_lname = rs.getString("ln");
				tab_pass = rs.getString("passwd");
				tab_id = rs.getInt("id");
			}
			PrintWriter out = response.getWriter();

			out.print("<form action='updated_successfully' method='post'>"
					+"<table>"
					+ "<tr>"
					+ "<td>First Name :</td>"
					+ "<td><input type='text' name='fn' value='"+tab_fname+"' />"
					+ "</td>"
					+ "</tr>"
					+ "<tr>"
					+ "<td>Last Name :</td><td><input type='text' name='ln' value='"+tab_lname+"'/> </td>"
					+ "</tr>"
					+ "<tr><td><input type='submit' name='sub' value='Sign up!'/></td>"
					+ "<td><input type='hidden' name='id' value='"+tab_id+"'></td>"
					+ "</tr>"
					+ "</table>"
					+ "</form>");
			
			
			
			//out.print("user updated successfully !");
		} catch (SQLException e) {
			System.out.println("SQLEXcepetion at edit user query");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

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
