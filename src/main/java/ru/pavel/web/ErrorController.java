package ru.pavel.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import static jakarta.servlet.RequestDispatcher.*;

@WebServlet(urlPatterns = "/errorHandler")
public class ErrorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<html><head><title>PhoneBook</title></head><body>");
            writer.write("<h2>Ошибка</h2>");
            writer.write("<ul>");
            Arrays.asList(
                            ERROR_SERVLET_NAME,
                            ERROR_STATUS_CODE,
                            ERROR_EXCEPTION_TYPE,
                            ERROR_MESSAGE)
                    .forEach(e ->
                            writer.write("<li>" + e + ": " + req.getAttribute(e) + " </li>")
                    );
            writer.write("</ul>");
            writer.write("</html></body>");
        }

    }
}
