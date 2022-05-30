
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		HttpSession session = request.getSession(false);
		if (session != null) {
			String name = (String) session.getAttribute("username");

			out.print("Hello, " + name + " Welcome to logic");
			request.getRequestDispatcher("multiply.html").include(request, response);
			int a = Integer.parseInt(request.getParameter("number1"));
			int b = Integer.parseInt(request.getParameter("number2"));
			int c = a*b;
			out.println("Hello " + name + " multiply of the number is:" + c);

		} else {
			out.print("Please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}
}
