package Regesteration;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.MyConnection;

import java.sql.Statement;



/**
 * Servlet implementation class RegestrationServlet
 */
@WebServlet("/register")
public class RegestrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out  = response.getWriter();
//		out.print("working");
		String uname =  request.getParameter("name");
		String pass =  request.getParameter("pass");
		String email = request.getParameter("email");
		int r1 = 1;
		
//		RequestDispatcher dispatcher = null;
		Connection conn = MyConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into users(uname,password,email,user_type) values(?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, pass);
			ps.setString(3, email);
			ps.setInt(4, r1);
			int count = ps.executeUpdate();
			Statement s = conn.createStatement();
			s.execute("insert into trans(balance) values(0)");
//			dispatcher = request.getRequestDispatcher("registration.jsp");
			response.sendRedirect("login.jsp");	
			if(count>0) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "failed");
			}
//			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		
		
		
	}

}
