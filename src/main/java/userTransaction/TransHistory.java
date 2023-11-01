package userTransaction;

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

import com.user.History;
import com.user.MyConnection;
import com.user.User;


/**
 * Servlet implementation class TransHistory
 */
@WebServlet("/TransHistory")
public class TransHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public TransHistory() {
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
		List<History> history = new ArrayList<>();
		
		
		try {
				
			PreparedStatement trans = conn.prepareStatement("select u.uname,h.* from users u join history h on u.id = h.to_id and from_id = ? order by c_date desc");
			trans.setInt(1, User.getId());
			ResultSet trans_data = trans.executeQuery();
			
//			PreparedStatement trans1 = conn.prepareStatement("select u.uname,h.* from users u join history h on u.id = h.from_id and to_id = ? order by c_date desc");
//			trans1.setInt(1, User.getId());
//			ResultSet trans_data1 = trans1.executeQuery();
			
			
			
			while(trans_data.next()) {
				
				history.add(new History(trans_data.getString("uname").toUpperCase(),trans_data.getString("c_date").substring(0,10),
						trans_data.getString("from_type").toUpperCase(),trans_data.getDouble("amount"),trans_data.getString("c_date").substring(10)));
			}
			
//			while(trans_data1.next()) {
//				
//				history2.add(new RecDetails(trans_data1.getString("uname"),trans_data1.getDouble("amount"),trans_data1.getString("to_type"),trans_data1.getString("c_date").substring(0,10)));
//				
//			}
			
//			System.out.println(history);
			session.setAttribute("list", history);
//			session.setAttribute("list2", history2);
		
			
//			Iterator<History> itr = history.iterator();
//			while(itr.hasNext()) {
//				History history1 = itr.next();
//			
//			}
		
			
			
			
			
//			while(trans_data1.next()) {
//				System.out.println(trans_data1.getString("uname"));
//			}
			
//			PreparedStatement trans = conn.prepareStatement(" select uname,id,h.* from history h join users u on h.from_id = u.id and h.from_id = ? ");
//			trans.setInt(1, User.getId());
//			ResultSet trans_data = trans.executeQuery();
//
//			
//			while(trans_data.next()) {
//			PreparedStatement trans1 = conn.prepareStatement(" select uname,h.* from history h join users u on h.from_id = u.id and h.to_id = ? ");
//			trans1.setInt(1, trans_data.getInt("id"));
////			ResultSet trans_data1 = trans.executeQuery();
////			
//			}
//			ResultSet trans_data1 = trans.executeQuery();
//			
//			while(trans_data1.next()) {
//				System.out.println(trans_data1.getString("uname")+" "+trans_data1.getString("c_date")+" "+trans_data1.getInt("amount"));
//
//			}
//			
//			System.out.println();
//			while(trans_data.next()) {
//				System.out.println(trans_data.getString("uname")+" "+trans_data.getString("c_date")+" "+trans_data.getInt("amount")+" "+trans_data.getInt("to_id"));
//			}
			session.setAttribute("upi", User.getEmail());
			response.sendRedirect("transaction.jsp");
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




//<% List<History> r1 = (session.getAttribute("list"); %>
//
//
//<h1>rahul</h1>
//<% out.print(session.getAttribute("list")); %>
//
//<% Iterator<History> itr = r1.iterator();
//	while(itr.hasNext()) {
//		History history1 = itr.next();
//		
//	
//	} %>


//<% int c = (Integer) session.getAttribute("count");
//int a = c; %>
//<% while( a > 0) 
//{ %>
//   <div class="mini_card">
//       <div class="name">
//           <p class="title">ravi</p>
//           <p class="balance">${count}</p>
//       </div>
//       <div class="type">
//           <p class="pay_type">Rahul Singh</p>
//       </div>
//       <div class="amount">
//           <p class="title">Rahul Singh</p>
//           <p class="balance">24-10-2023</p>
//       </div>
//   </div>
//
//<% a = a - 1; } %>

