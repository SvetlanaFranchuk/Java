package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Logger;

public class Log implements Filter {

    private final Logger logger = Logger.getLogger("RequestInfo");

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // Преобразуем объекты запроса и ответа к HTTP-запросу и HTTP-ответу
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        logger.info("Request details: URL: " + request.getRequestURL() +
                         "; method: " + request.getMethod() +
                         "; headers:" + getHeaderRequestToString(request) +
                         "; parameters: " + request.getParameterMap() +
                         "; request body: " + requestBody);

        filterChain.doFilter(request, response);

        logger.info("Response details: status code: " + response.getStatus()  +
                "; headers:" + getHeaderResponseToString(response) +
                "; parameters: " + request.getParameterMap() );

    }


    private String getHeaderRequestToString(HttpServletRequest request){
        StringBuilder headers = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                headers.append("Header: " + request.getHeader(headerNames.nextElement()));
            }
        }
        return headers.toString();
    }

    private String getHeaderResponseToString(HttpServletResponse response){
        StringBuilder headers = new StringBuilder();
        for (String headerName : response.getHeaderNames()) {
            headers.append(headerName + ": " + response.getHeader(headerName));
        }
        return headers.toString();
    }

}
