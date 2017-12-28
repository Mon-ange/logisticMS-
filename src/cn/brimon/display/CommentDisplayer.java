package cn.brimon.display;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentDisplayer implements ToolBarDisplayer {

	@Override
	public void display(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		try {
			String toolBarStr = (String)req.getAttribute("toolbarstr");
			if(toolBarStr == null) toolBarStr = "";
			toolBarStr = toolBarStr + "<li><a href=\"#\" onclick=\"setActive(this)\">订单评价 <span class=\"sr-only\">(current)</span></a></li>";
			req.setAttribute("toolbarstr", toolBarStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
