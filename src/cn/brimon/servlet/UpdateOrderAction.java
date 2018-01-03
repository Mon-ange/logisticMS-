package cn.brimon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.brimon.model.Location;
import cn.brimon.model.Order;
import cn.brimon.model.User;
import cn.brimon.service.LocationService;
import cn.brimon.service.OrderService;

/**
 * Servlet implementation class UpdateOrderAction
 */
@WebServlet("/UpdateOrderAction")
public class UpdateOrderAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateOrderAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User handleUser = (User) session.getAttribute("user");
		request.setCharacterEncoding("UTF-8");
		String location_name = request.getParameter("location_name");
		String order_id = request.getParameter("order_id");
		String cost = request.getParameter("cost");
		String distance = request.getParameter("distance");
		Location location = new Location();
		LocationService ls = new LocationService();
		OrderService os = new OrderService();
		Order order = os.getOrderById(new Integer(order_id));
		location.setDistance(new Double(distance));
		location.setHandleUser(handleUser);
		location.setLocationName(location_name);
		os.OrderAddCost(order, new Double(cost));
		os.RunOrderService(order);
		ls.setOrderLocation(order, location);
		response.sendRedirect(request.getContextPath() + "/panel/panel.jsp?nav=my_order");
	}

}
