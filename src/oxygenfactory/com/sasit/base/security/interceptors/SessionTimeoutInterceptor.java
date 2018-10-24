package oxygenfactory.com.sasit.base.security.interceptors;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import oxygenfactory.com.sasit.module.oxygen.xAuthToken.entity.AuthTokenInfo;
import oxygenfactory.com.sasit.module.oxygen.xAuthToken.service.AuthTokenService;
public class SessionTimeoutInterceptor implements HandlerInterceptor {

	@Autowired(required = true)
	public AuthTokenService authTokenService;
	
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object obj, Exception e)throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,Object obj, ModelAndView mv) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,DELETE,HEAD");
		response.setHeader("X-Powered-By","sasit"); 
//		if(request.getMethod().toString().equalsIgnoreCase("get")) {
////			String postUrl = request.getContextPath();
//			String postUri = request.getRequestURI();
//			if(postUri.lastIndexOf("/isExist") == -1) {
//				String xAuthToken = request.getHeader("x-auth-token");
//				if(xAuthToken == null || xAuthToken.trim().length() == 0)
//				return false;
//			}
//		}
//		if(request.getMethod().toString().equalsIgnoreCase("post")) {
////			String getUrl = request.getContextPath();
//			String getUri = request.getRequestURI();
//			if(getUri.lastIndexOf("/customers") == -1) {
//				String xAuthToken = request.getHeader("x-auth-token");
//				if(xAuthToken == null || xAuthToken.trim().length() == 0)
//				return false;
//			}
//		}
		return true;
		
	}

}
