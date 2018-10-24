package oxygenfactory.com.sasit.base.security.interceptors;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thetransactioncompany.cors.CORSFilter;

import oxygenfactory.com.sasit.module.oxygen.xAuthToken.entity.AuthTokenInfo;
import oxygenfactory.com.sasit.module.oxygen.xAuthToken.service.AuthTokenService;

@Component
public class ExpressCORSFilter extends CORSFilter {
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,DELETE,HEAD");
		response.setHeader("X-Powered-By","sasit"); 
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}