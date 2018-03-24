package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Broker;
import classes.Portfolio;
import classes.Stock;
import classes.User;

/**
 * Servlet implementation class UserPortfolioDemoServlet
 */
@WebServlet("/genUserPortfolioData")
public class UserPortfolioDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPortfolioDemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Broker bob=new Broker().setName("Bob");
		Stock ba = new Stock().setCompanyName("British Airways").setSymbol("BAA");
		Stock fdm = new Stock().setCompanyName("FDM Group").setSymbol("FDM");
		Portfolio pf=new Portfolio().setBroker(bob);
		pf.addStock(ba);
		pf.addStock(fdm);
		User u = new User().setUsername("Bill").setPortfolio(pf);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("loggedInUser", u);
		request.getRequestDispatcher("UserPages/userData.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
