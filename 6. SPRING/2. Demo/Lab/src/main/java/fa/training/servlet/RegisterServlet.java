package fa.training.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import fa.training.dao.UserDao;
import fa.training.entities.User;
import fa.training.utils.Constants;
import fa.training.utils.LogFactory;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// Get data from the request using request.getParameter()
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String email = request.getParameter("email");
//		String userName = request.getParameter("userName");
//		String password = request.getParameter("password");
//		String msgEmail = "Invalid email";
//		// Set data for the user
//		User user = new User(firstName, lastName, email, userName, password);
//		try {
//			UserDao userDao = new UserDao();
//			// Call registerUser() method to insert user into DB
//			if (userDao.registerUser(user)) {
//				// Send a attribute name as "userRegister" to register-user-process.jsp page
//				request.setAttribute("userRegister", user);
//				// Forward to register-user-process.jsp page
//				request.getRequestDispatcher("/view/register-user.jsp").forward(request, response);
//			} else {
//				// send a attribute name as "message" to register-user.jsp page
//				request.setAttribute("message", msgEmail);
//				// forward to register-user.jsp page
//				request.getRequestDispatcher("/view/register-user.jsp").forward(request, response);
//			}
//		} catch (SQLException e) {
//			// log error if exception occurs
////			LogFactory.getLogger().error("An exception occurs while register user");
//			e.printStackTrace();
//		}
//	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get data from the request using request.getParameter()
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		// Set data for the user
		
		User user = null;
		if(!password.equals(confirmPassword)) {
			System.out.println("Not the same pass");
			user = null;
		}else {
			user = new User(firstName, lastName, email, userName, password);
		}
		try {
			UserDao userDao = new UserDao();
        // Call registerUser() method to insert user into DB
			if (userDao.registerUser(user)) {
				// Send a attribute name as "userRegister"
				// to register-user-process.jsp page
				request.setAttribute("userRegister", user);
				// Forward to register-user-process.jsp page
				request.getRequestDispatcher("/view/login.jsp").forward(request, response);
			} else {
				// send a attribute name as "message" to register-user.jsp page
				request.setAttribute("message", Constants.REGISTER_FAIL_MSG);
				// forward to register-user.jsp page
				request.getRequestDispatcher("/view/register-user.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// log error if exception occurs
//			LogFactory.getLogger().error("An exception occurs while register user");
			e.printStackTrace();
			System.out.println("An exception occurs while register user");
		}
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/view/register-user.jsp").forward(req, resp);
	}

}
