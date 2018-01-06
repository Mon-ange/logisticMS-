package cn.brimon.model;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.brimon.display.AddPolicyDisplayer;
import cn.brimon.display.MyOrderDisplayer;
import cn.brimon.display.NewOrderDisplayer;
import cn.brimon.display.PolicyDisplayer;
import cn.brimon.display.ToolBarDisplayer;

public class Policy extends User {

	@Override
	public void myOrdersDisplay(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub

	}

	@Override
	public String navBarDisplay() {
		// TODO Auto-generated method stub
		String ret = "<li><a href=\"/LogisticMS/panel/panel.jsp\">欢迎您，尊敬的用户" + getUserName() + "</a></li>";
		return ret;
	}

	@Override
	public void toolBarDisplay(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<ToolBarDisplayer> toolList = Arrays.asList(new AddPolicyDisplayer(),
														new PolicyDisplayer()
														
														);
		for (ToolBarDisplayer tool : toolList) {
			tool.display(request, response);
		}
	}
	
	

}
