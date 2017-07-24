package com.tecforce.theater.config.core;

import com.tecforce.theater.config.AppConfig;
import com.tecforce.theater.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
//        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
//        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }


}
