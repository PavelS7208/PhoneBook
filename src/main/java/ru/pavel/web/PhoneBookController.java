package ru.pavel.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.pavel.model.PhoneBook;
import ru.pavel.model.PhoneNumber;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/search", "/list", "/close"})
public class PhoneBookController extends HttpServlet {

    private PhoneBook phoneBook;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        phoneBook = new PhoneBook();

        phoneBook.addPhoneContact("Сидоров Иван", new PhoneNumber("+78761186622"));
        phoneBook.addPhoneContact("Иванов Петр", new PhoneNumber("+79263453322"));
        phoneBook.addPhoneContact("Маша Петрова", List.of(new PhoneNumber("+79244071124"),new PhoneNumber("+79161815060")) );
        phoneBook.addPhoneContact("Сергей Петрович авто", List.of(new PhoneNumber("+79241196222"),new PhoneNumber("+79144039898")) );
        phoneBook.addPhoneContact("Алина Г", new PhoneNumber("+79290889697"));
        phoneBook.addPhoneContact("Кузнецов Дмитрий", new PhoneNumber("+71112223456"));
        phoneBook.addPhoneContact("Магазин", new PhoneNumber("88002000600"));
        phoneBook.addPhoneContact("Новый контакт", new PhoneNumber("88002000600"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String action = req.getServletPath();
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        if (action == null ) action = "/list";

        switch (action) {
            case "/list" -> displayPhoneBookList(req, resp);
            case "/search" -> searchPhoneBook(req, resp);
            case "/close" -> closeSearchForm(req, resp);
        }


    }

    protected void displayPhoneBookList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> names = phoneBook.getNames();
        names.sort(String::compareToIgnoreCase);
        req.setAttribute("names", names);
        getServletContext().getRequestDispatcher("/phoneList.jsp").forward(req, resp);
    }

    protected void searchPhoneBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String searchString = req.getParameter("search");
        List<PhoneNumber> phoneNumberlist = phoneBook.getPhoneNumberList(searchString);
        req.setAttribute("searchName", searchString);
        req.setAttribute("phoneNumbers", phoneNumberlist);
        getServletContext().getRequestDispatcher("/phoneSearch.jsp").forward(req, resp);

    }

    protected void closeSearchForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("list");
    }

}
