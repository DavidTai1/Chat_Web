package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
//@WebServlet("/firstAction")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public FirstServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().log("*****************FirstServlet has been initialised");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.append("<html><head><title>First Page Servlet Response</title></head><body>")
				.append("<h1>First Page Servlet Response</h1>").append("Served at: ").append(request.getContextPath())
				.append("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter out = resp.getWriter();
		String s = req.getParameter("userText");

		if(s.isEmpty()){
			resp.sendRedirect("");
			return;
		}
		
		List<String> list = new ArrayList<>();
		for(String str : s.split(" "))
			list.add(str);
		
		req.setAttribute("stringList", list);
		
		req.getRequestDispatcher("messageOutput.jsp").forward(req, resp);		
	}

	// @Override
	// protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
	// throws ServletException, IOException {
	// // TODO Auto-generated method stub
	// super.service(arg0, arg1);
	// }

}
