package hnu.mn.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class UrlFilter implements Filter{
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterchain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		String uri = request.getRequestURI();
		System.out.println("url    "+uri);
		if(uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".html")||uri.endsWith(".jpg")||uri.endsWith(".png")||uri.endsWith(".gif")){
			System.out.println("if");
			filterchain.doFilter(req, res);
		}else {
			System.out.println("else");
			filterchain.doFilter(req, res);
		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	
	
}