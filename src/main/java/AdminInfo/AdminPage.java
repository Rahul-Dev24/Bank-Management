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
import com.user.admin.FetchUser;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPage() {
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
		List<FetchUser> userdb = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			PreparedStatement ps = conn.prepareStatement("select id,uname,password,email from users");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userdb.add(new FetchUser(rs.getInt("id"),rs.getString("uname"),rs.getString("password"),rs.getString("email")));
			}
			
			session.setAttribute("adminUsers", userdb);
			response.sendRedirect("adminPage.jsp");
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
