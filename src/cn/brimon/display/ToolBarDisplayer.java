package cn.brimon.display;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ToolBarDisplayer {
	public abstract void display(HttpServletRequest req,HttpServletResponse res);
}
