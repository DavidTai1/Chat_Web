package springConfig;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInit implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext webContext) throws ServletException {
		AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
		springContext.register(SpringBeans.class, MVCConfig.class);
		
		webContext.addListener(new ContextLoaderListener(springContext));
		
		Dynamic dynamic = webContext.addServlet("dispatcher",new DispatcherServlet(springContext));
		
		
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);
		
	}

}
