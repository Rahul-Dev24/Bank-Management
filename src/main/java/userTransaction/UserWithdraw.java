package userTransaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.MyConnection;
import com.user.User;

/**
 * Servlet implementation class UserWithdraw
 */
@WebServlet("/userWithdraw")
public class UserWithdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public UserWithdraw() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String r1 = request.getParameter("withdraw");
		Connection conn = MyConnection.getConnection();
		HttpSession session = request.getSession();
		try {
			int count = 0;
			if(User.getBalance() > 0) {
				PreparedStatement ps = conn.prepareStatement("update trans set balance = ? where tid = ?");
				ps.setDouble(1, User.getBalance() - Double.parseDouble(r1));
				ps.setInt(2, User.getId());
				count = ps.executeUpdate();
			}
		
			PreparedStatement trans1 = conn.prepareStatement("select balance from trans where tid = ?");
			trans1.setInt(1, User.getId());
			ResultSet transRs = trans1.executeQuery();
			if(transRs.next()) {
				User.setBalance(transRs.getInt("balance"));
			}
			
			
			if(count >0) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "failed");
			}

			
			session.setAttribute("balance", User.getBalance());
			response.sendRedirect("index.jsp");
			
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
