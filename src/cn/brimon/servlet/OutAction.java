package cn.brimon.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.brimon.model.*;
import cn.brimon.service.LocationService;
import cn.brimon.service.OrderService;

/**
 * Servlet implementation class OutAction
 */
@WebServlet("/OutAction")
public class OutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutAction() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		OrderService os = new OrderService();
		LocationService ls = new LocationService();
		//Get the order by order_id
		String order_id = request.getParameter("order_id");
		Order order = os.getOrderById(Integer.valueOf(order_id));
		//Create the location
		String repository = request.getParameter("repository");
		Location location = new Location();
		location.setLocationName(repository);
		location.setHandleUser((User)session.getAttribute("user"));
		location.setDistance(0.0);
		location.setTimestamps(new Date());
		//Bind the order and the location
		os.OutOrderService(order,location);
		response.sendRedirect(request.getContextPath() + "/panel/panel.jsp?nav=my_order");
	}

}
