package cn.brimon.display;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RepositoryDisplayer implements ToolBarDisplayer {

	@Override
	public void display(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		try {
			String toolBarStr = (String)req.getAttribute("toolbarstr");
			if(toolBarStr == null) toolBarStr = "";
			toolBarStr = toolBarStr + "<li><a href=\"javascript:PanelShow(\'repository_manage\')\" onclick=\"setActive(this)\">仓库管理 <span class=\"sr-only\">(current)</span></a></li>";
			req.setAttribute("toolbarstr", toolBarStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
