package com.mindworx.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mindworx.dao.PickupDetailsDao;
import com.mindworx.dao.PickupDetailsDaoImpl;
import com.mindworx.validator.PickupDetailsValidator;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mindworx")
@PropertySources({
	@PropertySource("classpath:config.properties"),
	@PropertySource("classpath:messages.properties")
})
public class AppConfiguration extends WebMvcConfigurerAdapter{
	
	@Autowired
	private Environment env;
	private static final Logger log = Logger.getLogger(AppConfiguration.class);
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");		
		return viewResolver;		
	}
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
    public DataSource getDataSource() {
		log.info("url:"+env.getProperty("url")+" user:"+env.getProperty("user")+" password:"+env.getProperty("password"));
		OracleDataSource dataSource = null;
		try {
			dataSource = new OracleDataSource();
			dataSource.setURL(env.getProperty("url"));
	        dataSource.setUser(env.getProperty("user"));
	        dataSource.setPassword(env.getProperty("password"));	        
	        dataSource.setImplicitCachingEnabled(true);
	        dataSource.setFastConnectionFailoverEnabled(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return dataSource;
        
    }
	
	@Autowired
    @Bean
    public PickupDetailsDao getPickupDetailsDao() {
        return new PickupDetailsDaoImpl(getDataSource());
    }
    
    @Bean
    public PickupDetailsValidator pickupDetailsValidator() {
        return new PickupDetailsValidator();
    }
           
    /*@Bean
    public MessageSource messageSource(){
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    	messageSource.setBasename("classpath:messages");
    	messageSource.setDefaultEncoding("UTF-8");
    	return messageSource;
    }*/
        
}
