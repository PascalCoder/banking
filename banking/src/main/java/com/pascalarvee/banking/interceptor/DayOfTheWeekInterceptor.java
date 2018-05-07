/**
 * 
 */
package com.pascalarvee.banking.interceptor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author PASCAL
 *
 */
public class DayOfTheWeekInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			                 HttpServletResponse response, Object handler) throws Exception {
		
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		
		Date now = new Date();
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
		String today = simpleDateformat.format(now);
		
		if(dayOfWeek == 8){
			response.getWriter().write("The site is not available on " + today +"s." +  "\n"
					+ "Please try accessing it on any other day of the week. \n"
					+ "Thank you for your understanding! :)");
			
			return false;
		}
								
		return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		System.out.println("HandlerInterceptorAdaptor: Spring MVC called postHandle method for "
				+ request.getRequestURI().toString());
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex){
		
		System.out.println("HandlerInterceptorAdaptor: Spring MVC called afterCompletion method for "
				+ request.getRequestURI().toString());
	}
}
