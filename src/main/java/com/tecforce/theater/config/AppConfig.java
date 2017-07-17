//package com.tecforce.theater.config;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import java.util.Properties;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan({"com.tecforce.theater.*"})
//@EnableTransactionManagement
//public class AppConfig {
//
//    @Bean
//    public SessionFactory sessionFactory() {
//        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
//        builder
//                .scanPackages("com/tecforce/theater/data/entities")
//                .addProperties(getHibernateProperties());
//
//        return builder.buildSessionFactory();
//    }
//
//    private Properties getHibernateProperties() {
//        Properties prop = new Properties();
//        prop.put("hibernate.format_sql", "true");
//        prop.put("hibernate.show_sql", "true");
//        prop.put("hibernate.hbm2ddl.auto", "update");
//        prop.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL81Dialect");
//        prop.put("hibernate.pool_size", "1");
//        prop.put("current_session_context_class", "thread");
//        prop.put("hibernate.connection.charSet", "UTF-8");
//        return prop;
//    }
//
//    @Bean(name = "dataSource")
//    public BasicDataSource dataSource() {
//
//        BasicDataSource ds = new BasicDataSource ();
//        ds.setDriverClassName("org.postgresql.Driver");
//        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
//        ds.setUsername("postgres");
//        ds.setPassword("postgres");
//        return ds;
//    }
//
//    @Bean
//    public HibernateTransactionManager txManager() {
//        return new HibernateTransactionManager(sessionFactory());
//    }
//
////    @Bean
////    public InternalResourceViewResolver viewResolver() {
////        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
////        viewResolver.setViewClass(JstlView.class);
////
////        viewResolver.setPrefix("");
////        viewResolver.setSuffix("");
//////        viewResolver.setPrefix("/");
//////        viewResolver.setPrefix("/WEB-INF/views/ss//sss/");
//////        viewResolver.setSuffix(".html");
//////        viewResolver.setSuffix(".jsp");
////        return viewResolver;
////    }
//
//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource(){
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:messages");
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }
//
//}
