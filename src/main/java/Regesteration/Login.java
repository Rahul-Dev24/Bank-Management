package Regesteration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.servlet.RequestDispatcher;	
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.MyConnection;
import com.user.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String email = request.getParameter("username");
		String pass =  request.getParameter("password");
		HttpSession session = request.getSession();
		
//		RequestDispatcher dispatcher = null;
		Connection conn = MyConnection.getConnection();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement ps = conn.prepareStatement("select id,uname,password,email,user_type from users where email = ? or uname = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, email);		
			ps.setString(3, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(Integer.parseInt(rs.getString("user_type")) == 2002) {
					session.setAttribute("name", rs.getString("uname"));
					response.sendRedirect("AdminPage");	 	      
				}else if(Integer.parseInt(rs.getString("user_type")) == 1) {
					session.setAttribute("name", rs.getString("uname"));
//					dispatcher = request.getRequestDispatcher("index.jsp");
					User user = new User();
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setEmail(rs.getString(4));
					
					PreparedStatement trans1 = conn.prepareStatement("select balance from trans where tid = ?");
					trans1.setInt(1, User.getId());
					ResultSet transRs = trans1.executeQuery();
					if(transRs.next()) {
						User.setBalance(transRs.getInt("balance"));
					}
					session.setAttribute("uname", User.getName().toUpperCase());
					session.setAttribute("balance", User.getBalance());
					response.sendRedirect("index.jsp");
					
				}
			}else {
				request.setAttribute("status", "failed");
//				dispatcher = request.getRequestDispatcher("login.jsp");
				response.sendRedirect("login.jsp");
			}
			session.setAttribute("upi", User.getEmail());
//			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		
		
	}

}
