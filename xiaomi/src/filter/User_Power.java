package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class User_Power implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest)req;
			HttpServletResponse response = (HttpServletResponse)res;
			HttpSession session = request.getSession();
			PrintWriter out = response.getWriter();
			String uri= request.getRequestURI();
			@SuppressWarnings("unchecked")
			List<String> user_power = (List<String>) session.getAttribute("user_power");
			int powerflag=0;
			for (int i = 0; i < user_power.size(); i++) {
				if (uri.startsWith(user_power.get(i))) {
					powerflag=1;
				}
			}
			if (powerflag==0) {
				response.setContentType("text/html;charset=GBK");
				out.print("<script>alert('Œﬁ»®∑√Œ £°'); window.location='/xiaomi/index.jsp' </script>");
				return;
			}else{
				chain.doFilter(req, res);
			}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
