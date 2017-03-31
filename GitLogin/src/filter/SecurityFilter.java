package filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



public class SecurityFilter implements javax.servlet.Filter {

	private Set<String> ignoredURLs = new HashSet<String>();
	
	public SecurityFilter() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		try
		{
			HttpServletRequest httpRequest;

			if (request instanceof HttpServletRequest)
			{
				httpRequest = (HttpServletRequest) request;
			}
			else
			{
				throw new Exception("");
			}

			String url = httpRequest.getServletPath();
			System.out.println(url);

			if(authenticate(url))
			{
				chain.doFilter(request, response);
			}
			else
			{
						request.getRequestDispatcher("/login.jsp")
							.forward(request, response);
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	private boolean authenticate(String url)
	{
		for (String ignoredURL : ignoredURLs)
		{
			if(url.matches(ignoredURL))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
		Enumeration<String> initParameterNames = fConfig.getInitParameterNames();
		
		while(initParameterNames.hasMoreElements())
		{
			String initParameterName = initParameterNames.nextElement();
			
			String param = fConfig.getInitParameter(initParameterName);
			
			
			ignoredURLs.add(param);
		}
		
	}

}
