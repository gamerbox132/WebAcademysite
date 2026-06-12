package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Diz ao Java para buscar o seu arquivo HTML dentro da pasta webapp
        // Se o seu arquivo chamar 'index.html', coloque "/index.html"
        request.getRequestDispatcher("/index.html").forward(request, response);
        
    }
}