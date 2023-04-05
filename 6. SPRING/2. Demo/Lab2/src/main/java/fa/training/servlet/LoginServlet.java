package fa.training.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.UserDao;
import fa.training.entities.User;
import fa.training.utils.Log4J;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static UserDao userDao = new UserDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Log4J.getLogger().info("Running on doPost method of LoginServlet");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User(userName, password);
		try {
			if (userDao.login(userName, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("userLogin", user);
				response.sendRedirect(request.getContextPath() + "/home");
			} else {
				request.setAttribute("userRegister", user);
				request.setAttribute("loginFail", "User name or password is incorrect");
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			}
		}catch (SQLException e) {
			Log4J.getLogger().error("SQL exception in method doPost of LoginServlet");
		} 
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Log4J.getLogger().info("Running on doGet method of LoginServlet");
		request.getRequestDispatcher("views/login.jsp").forward(request, response);
	}

}
