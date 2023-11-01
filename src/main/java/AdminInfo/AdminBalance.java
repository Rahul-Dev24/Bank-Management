package AdminInfo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.MyConnection;
import com.user.admin.FetchBalance;

/**
 * Servlet implementation class AdminBalance
 */
@WebServlet("/AdminBalance")
public class AdminBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection conn = MyConnection.getConnection();
		HttpSession session = request.getSession();
		List<FetchBalance> balance = new ArrayList<>();
		try {
			
			PreparedStatement ps = conn.prepareStatement("select u.id,u.uname,t.tid,t.balance from users u join trans t on t.tid = u.id");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				balance.add(new FetchBalance(rs.getInt("id"),rs.getString("uname"),rs.getInt("tid"),rs.getDouble("balance")));
			}
			
			
			session.setAttribute("adminbalance", balance);
			response.sendRedirect("adminBalance.jsp");
		}catch(Exception e){
			e.getStackTrace();
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
