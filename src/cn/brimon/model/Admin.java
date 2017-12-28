package cn.brimon.model;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.brimon.display.CommentDisplayer;
import cn.brimon.display.NewOrderDisplayer;
import cn.brimon.display.OrderDisplayer;
import cn.brimon.display.RepositoryDisplayer;
import cn.brimon.display.ToolBarDisplayer;

public class Admin extends User {

	@Override
	public String navBarDisplay() {
		// TODO Auto-generated method stub
		String ret = "<li><a>欢迎您，尊敬的管理员" + getUserName() + "</a></li>";
		return ret;
	}

	@Override
	public void toolBarDisplay(HttpServletRequest req,HttpServletResponse res) {
		// TODO Auto-generated method stub
		List<ToolBarDisplayer> toolList = Arrays.asList(new NewOrderDisplayer(),
														new OrderDisplayer(),
														new RepositoryDisplayer(),
														new CommentDisplayer());
		for(ToolBarDisplayer tool : toolList) {
			tool.display(req, res);
		}
	}

}
