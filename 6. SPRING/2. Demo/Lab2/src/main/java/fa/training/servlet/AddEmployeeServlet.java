package fa.training.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.DepartmentDao;
import fa.training.dao.EmployeeDao;
import fa.training.entities.Department;
import fa.training.entities.Employee;
import fa.training.utils.DateUtils;
import fa.training.utils.Log4J;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/add-emp")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DepartmentDao departmentDao = new DepartmentDao();
	private EmployeeDao employeeDao = new EmployeeDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Department> listOfDepartment = departmentDao.findAllDepartment();
			request.setAttribute("listOfDepartment", listOfDepartment);
			request.getRequestDispatcher("/views/add-employee.jsp").forward(request, response);

		} catch (SQLException e) {
			Log4J.getLogger().error(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String employeeName = request.getParameter("employeeName");
		byte gender = Byte.parseByte(request.getParameter("gender"));
		Date dateOfBirth = null;
		try {
			dateOfBirth = DateUtils.convertStringToDate(request.getParameter("dateOfBirth"));
		} catch (ParseException e) {
			Log4J.getLogger().error("Parse Exception when convert string to date");
		}
		Employee employee = new Employee(employeeName, gender, dateOfBirth, deptId);
		try {
			employeeDao.addEmployee(employee);
			List<Department> listOfDepartment = departmentDao.findAllDepartment();
			request.setAttribute("listOfDepartment", listOfDepartment);
			request.setAttribute("employee", employee);
			request.setAttribute("message", "Add new employee successfully");

			request.getRequestDispatcher("/views/add-employee.jsp").forward(request, response);

		} catch (SQLException e) {
			Log4J.getLogger().error("An exception occurs");
		}
	}
}
