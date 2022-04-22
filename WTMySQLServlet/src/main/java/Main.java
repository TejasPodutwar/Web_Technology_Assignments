

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqlservlet","root","Tejasgp85");
					
					Statement stmt = con.createStatement();
					
					String query = "SELECT bookid,bookName,bookPrice FROM books";
					
					ResultSet rs = stmt.executeQuery(query);
					
					while(rs.next()){
			            //Retrieve by column name
			            int id  = rs.getInt("bookid");
			            String name = rs.getString("bookName");
			            int price = rs.getInt("bookPrice");
			            

			            //Display values
			            out.println("ID: " + id + "<br>");
			            out.println(", Name: " + name + "<br>");
			            out.println(", Price: " + price + "<br>");
			            
			         }
					
					rs.close();
		            stmt.close();
		            con.close();
					
				}catch(Exception e) {
					System.out.println(e);
					out.println("Error Occured");
				}
				
				
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}








