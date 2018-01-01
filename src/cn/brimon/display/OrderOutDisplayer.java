package cn.brimon.display;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderOutDisplayer implements ToolBarDisplayer {

	@Override
	public void display(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		try {
			String toolBarStr = (String)req.getAttribute("toolbarstr");
			if(toolBarStr == null) toolBarStr = "";
			toolBarStr = toolBarStr + "<li><a href=\"javascript:PanelShow(\'order_out\')\" onclick=\"setActive(this)\" id=\"order_out\">订单出库<span class=\"sr-only\">(current)</span></a></li>";
			req.setAttribute("toolbarstr", toolBarStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
