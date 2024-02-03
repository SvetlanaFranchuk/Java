package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
public class HeaderController {

    @GetMapping("/headers")
    public ResponseEntity<?> headerReturn(HttpServletRequest request,
                                              HttpServletResponse response) throws IOException {
        Map<String, String> headers = new HashMap<>();
        Iterator<String> iter = request.getHeaderNames().asIterator();
        iter.forEachRemaining(hm -> headers.put(hm, request.getHeader(hm)));
        if (headers.size() < 3) {
            return ResponseEntity.badRequest().body("need more headers");
        }
        if ("true".equals(headers.get("x-error-result"))) {
            return ResponseEntity.badRequest().body("get your error");
        }
        String redirectPath = headers.get("x-forward-path");
        if (redirectPath != null && !redirectPath.isBlank()){
            response.sendRedirect(redirectPath);
            return null;
        }
        return ResponseEntity.ok(headers.toString());

    }
}
//Создайте контроллер, который анализирует заголовки GET-запроса. Если
// заголовков меньше 3, то возвращает код 400. Если присутствует заголовок
// X-Error-Result, равный true, то возвращает код 500. Если указан заголовок
// X-Forward-Path, то делает редирект на указанный путь. В остальных случаях
// возвращает все заголовки в виде строки.
