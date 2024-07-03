<!DOCTYPE html>
<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>PhoneBook</title>
</head>

<body>
<%
    @SuppressWarnings("unchecked")
    List<String> names = (List<String>) request.getAttribute("names");
%>
<div class="container-sm">
    <div class="pb-4"></div>
    <div class="pb-4"></div>
    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand">Записная книжка</a>
            <form action="search" class="d-flex" method="post">
                <input class="form-control me-2" type="search" placeholder="Введите имя" name="search" aria-label="Search">
                <button class="btn btn-primary" type="submit">Поиск</button>
            </form>
        </div>
    </nav>


    <table class="table table-sm table-striped">
        <thead>
        <tr>
            <th scope="col">Контакты</th>
        </tr>
        </thead>
        <tbody>
        <% for (String name : names) {%>
        <tr>
            <td><%= name %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <div class="pb-4"></div>
    <!-- <a class="btn btn-primary" href="<%=request.getContextPath()%>/new" role="button">Новый</a>  -->
</div>
</body>
</html>
