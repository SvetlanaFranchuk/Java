package org.example.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.example.filter.Log;
import org.example.filter.RequestBlockFilter;
import org.example.filter.ResponseBlockFilter;
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
        registerHiddenFieldFilter(myServletContext); // добавляем в сервлет нужный фильтр
        registerRequestBlockFilter(myServletContext);
        registerResponseBlockFilter(myServletContext);
        registerLogFilter(myServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext myServletContext) {
        myServletContext.addFilter(
                "hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter() // такой фильтр уже есть в Spring, поэтому его не нужно писать нам
        ).addMappingForUrlPatterns(
                null, // показывает, для каких случаев используется фильтр. null == REQUEST
                true, // добавить последним в цепочку ранее объявленных фильтров
                "/*" // показывает, на каких url будет срабатывать фильтр (на всех)
        );
    }

    private void registerRequestBlockFilter(ServletContext myServletContext) {
        myServletContext.addFilter(
                "RequestBlockFilter",
                new RequestBlockFilter() // такой фильтр уже есть в Spring, поэтому его не нужно писать нам
        ).addMappingForUrlPatterns(null, true, "/*");
    }

    private void registerResponseBlockFilter(ServletContext myServletContext) {
        myServletContext.addFilter(
                "ResponseBlockFilter",
                new ResponseBlockFilter() // такой фильтр уже есть в Spring, поэтому его не нужно писать нам
        ).addMappingForUrlPatterns(null, true, "/*");
    }

    private void registerLogFilter(ServletContext myServletContext) {
        myServletContext.addFilter(
                "logFilter",
                new Log()
        ).addMappingForUrlPatterns(null, true, "/*");
    }
}
