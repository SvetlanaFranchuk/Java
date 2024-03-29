package org.example.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // Переопределяем метод, который запускается при старте web-приллжения
    @Override
    public void onStartup(ServletContext myServletContext) throws ServletException {
        super.onStartup(myServletContext);
        registerHiddenFieldFilter(myServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext myServletContext) {
        myServletContext.addFilter(
                "hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()
        ).addMappingForUrlPatterns(null, true, "/*");
    }

}
