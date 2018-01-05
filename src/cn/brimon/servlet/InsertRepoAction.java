package cn.brimon.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.brimon.dao.CargoDao;
import cn.brimon.model.Cargo;
import cn.brimon.model.Repo;
import cn.brimon.service.CargoService;
import cn.brimon.service.RepositoryService;

/**
 * Servlet implementation class InsertRepoAction
 */
@WebServlet("/InsertRepoAction")
public class InsertRepoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRepoAction() {
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
		RepositoryService rs = new RepositoryService();
		CargoService cs = new CargoService();
		String cargoId = request.getParameter("cargo_id");
		String repoId = request.getParameter("repo_id");
		String quantity = request.getParameter("quantity");
		Cargo cargo = cs.getCargoById(cargoId);
		Repo repo = rs.getRepoById(repoId);
		rs.insertRepository(cargo, repo, Integer.valueOf(quantity));
		response.sendRedirect(request.getContextPath() + "/panel/panel.jsp?nav=repository_manage");
	}

}
