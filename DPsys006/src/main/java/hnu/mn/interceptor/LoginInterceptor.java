package hnu.mn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//拦截器  拦截登陆请求 jsp页面放置于/Page下
public class LoginInterceptor implements HandlerInterceptor {

	// 在进控制器之前先拦截
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		//下面三行测试
		// System.out.println("真实地址 "+req.getRealPath("/"));
			//StringBuffer requestURL = req.getRequestURL();
		String uri = req.getRequestURI();
	//	System.out.println("uri " + uri +"URL"+requestURL);
		//System.out.println("拦截器获得到的session数据"+req.getSession().getAttribute("user"));
		if (uri.equals("/login")||uri.equals("/regist")||uri.equals("/regist2")||uri.equals("/checkRegistUserAccount")) {
			//System.out.println("第一个IF放行");
			return true;
		} else {
			Object obj = req.getSession().getAttribute("user");
			if (obj != null) {
				//System.out.println("第二个IF放行");
				return true;
			}
			//System.out.println("第二个IF不放行");
			resp.sendRedirect("/login.jsp");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
