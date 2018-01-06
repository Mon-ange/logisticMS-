package cn.brimon.display;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddPolicyDisplayer implements ToolBarDisplayer {

	@Override
	public void display(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		try {
			String toolBarStr = (String)req.getAttribute("toolbarstr");
			if(toolBarStr == null) toolBarStr = "";
			toolBarStr = toolBarStr + "<li><a href=\"javascript:PanelShow(\'add_policy\')\" onclick=\"setActive(this)\" id=\"add_policy\">添加法规<span class=\"sr-only\">(current)</span></a></li>";
			req.setAttribute("toolbarstr", toolBarStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
