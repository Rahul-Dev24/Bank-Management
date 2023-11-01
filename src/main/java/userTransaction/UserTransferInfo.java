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
//import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class UserTransferInfo
 */
@WebServlet("/transferInfo")
public class UserTransferInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public UserTransferInfo() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String r1 = request.getParameter("trans_email");
		String value = request.getParameter("transfer");
		Connection conn = MyConnection.getConnection();
		HttpSession session = request.getSession();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			int count = 0;
			PreparedStatement ps5 = conn.prepareStatement("select balance,tid from trans where tid = (select id from users where email = ?)");
			ps5.setString(1, r1);
			ResultSet rs1 = ps5.executeQuery();
			
			PreparedStatement ps4 = conn.prepareStatement("select balance from trans where tid = ?");
			ps4.setInt(1, User.getId());
			ResultSet rs2 = ps4.executeQuery();
			while(rs1.next() && rs2.next() ) {
					if(rs2.getInt("balance") > 0) {
						PreparedStatement ps2 = conn.prepareStatement("update trans set balance = ? where tid = ?");
						ps2.setInt(1,rs2.getInt(1) - Integer.parseInt(value));
						ps2.setInt(2, User.getId());
						count = ps2.executeUpdate();
						User.setBalance(rs2.getInt(1) - Integer.parseInt(value));
						if(count > 0) {
							PreparedStatement ps1 = conn.prepareStatement("update trans set balance = ? where tid = ?");
							ps1.setInt(1,rs1.getInt(1) + Integer.parseInt(value));
							ps1.setInt(2, rs1.getInt(2));
							ps1.executeUpdate();
						}
					}
					
					PreparedStatement insert_from = conn.prepareStatement("insert into history(from_id,amount,from_type,c_date,type,to_id,to_type) values(?,?,'sent',now(),?,?,'receive')");
					insert_from.setInt(1, User.getId());
					insert_from.setInt(2, Integer.parseInt(value));
					insert_from.setString(3, "online transfer");
					insert_from.setInt(4, rs1.getInt(2));
					insert_from.executeUpdate();	
					
			}
			
			if(count >0) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "error");
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

}
