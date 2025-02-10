package com.electricityboard.electricityboard.configuration;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;







@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
    basePackages = "com.electricityboard.electricityboard.adminrepo", 
    entityManagerFactoryRef = "productEntityManager", 
    transactionManagerRef = "adminTransactionManager"
)
@Primary
public class PersistenceAdminConfiguration {
	
	@Autowired
    private Environment env;
    
    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean productEntityManager() {
        LocalContainerEntityManagerFactoryBean em
          = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(adminDataSource());
        em.setPackagesToScan(
          new String[] { "com.electricityboard.electricityboard.admin" });

        HibernateJpaVendorAdapter vendorAdapter
          = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto",
          env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect",
          env.getProperty("hibernate.dialect"));
       
        em.setJpaPropertyMap(properties);
        System.out.println("bean created for productEntityManager ");
        return em;
    }
    
    
   
    @Bean
    @Primary
    public DataSource adminDataSource() {
 
        DriverManagerDataSource dataSource
          = new DriverManagerDataSource();
        dataSource.setDriverClassName(
          env.getProperty("app.datasource.product.driver-class-name"));
        dataSource.setUrl(env.getProperty("app.datasource.product.url"));
        dataSource.setUsername(env.getProperty("app.datasource.product.username"));
        dataSource.setPassword(env.getProperty("app.datasource.product.password"));
        System.out.println("bean created for admin ");
        return dataSource;
    }
	
    
    @Bean
    @Primary
    public PlatformTransactionManager adminTransactionManager() {
 
        JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
        		productEntityManager().getObject());
        System.out.println(transactionManager.getEntityManagerFactory());
        return transactionManager;
    }

}
