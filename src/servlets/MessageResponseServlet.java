package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageResponseServlet
 */
//@WebServlet("/messageResponse")
public class MessageResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageResponseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		getServletContext().log("*****************MessageResponseServlet has been initialised");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().log("*****************MessageResponseServlet.doPost");
		response.getWriter().append("<html><head><title>First Page Servlet Response</title></head><body>")
		.append("<h1>Message Response</h1>");
//		.append("Thanks for stating <br/><h4>" + request.getParameter("userText") + "</h4>Have a nice day!")
		response.getWriter().append("<ul>");
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>)request.getAttribute("stringList");
		
		for(String str : list)
			response.getWriter().append("<li>" + str + "</li>");
		response.getWriter().append("</ul>");
		response.getWriter().append("</body></html>");
	}

}
