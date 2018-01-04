package cn.brimon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.brimon.model.Order;
import cn.brimon.service.OrderService;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddCommentAction")
public class AddCommentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentAction() {
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
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		OrderService os = new OrderService();
		Integer score = Integer.valueOf(req.getParameter("score"));
		String comments = req.getParameter("comments");
		Integer order_id = Integer.valueOf(req.getParameter("order_id"));
		Order order = os.getOrderById(order_id);
		order.setComments(comments);
		order.setScore(score);
		os.AddComment(order);
		os.receipt(order);
		res.sendRedirect(req.getContextPath() + "/panel/panel.jsp?nav=my_order");
	}
}
