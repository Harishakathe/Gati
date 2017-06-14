package com.mindworx.configuration;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mindworx.dao.PickupDetailsDao;
import com.mindworx.dao.PickupDetailsDaoImpl;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mindworx")
@PropertySource("classpath:config.properties")
public class AppConfiguration extends WebMvcConfigurerAdapter{
	
	@Value("${url}")
	private String url;
	
	@Value("${user}")
	private String user;
	
	@Value("${password}")
	private String password;
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");		
		return viewResolver;		
	}
	
	@Bean
    public DataSource getDataSource() {
		OracleDataSource dataSource = null;
		try {
			dataSource = new OracleDataSource();		
	        dataSource.setUser(user);
	        dataSource.setPassword(password);
	        dataSource.setURL(url);
	        dataSource.setImplicitCachingEnabled(true);
	        dataSource.setFastConnectionFailoverEnabled(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return dataSource;
        
    }
 
    @Bean
    public PickupDetailsDao getPickupDetailsDao() {
        return new PickupDetailsDaoImpl(getDataSource());
    }
}
