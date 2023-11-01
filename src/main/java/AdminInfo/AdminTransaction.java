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
import com.user.admin.FetchTransaction;

/**
 * Servlet implementation class AdminTransaction
 */
@WebServlet("/AdminTransaction")
public class AdminTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public AdminTransaction() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Connection conn = MyConnection.getConnection();
		HttpSession session = request.getSession();
		List<FetchTransaction> trans = new ArrayList<>();
		try {
			
			PreparedStatement ps = conn.prepareStatement(" select id,from_id,to_id,amount,c_date from history");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				trans.add(new FetchTransaction(rs.getInt("id"),rs.getInt("from_id"),rs.getInt("to_id"),rs.getFloat("amount"),rs.getString("c_date").substring(0,10)));
			}
			
			session.setAttribute("admintrans", trans);
			response.sendRedirect("adminTrancation.jsp");
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
