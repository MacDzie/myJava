<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="add" method="get">
    <label>Imię:<input type="text" id="name" name="name"/></label><br/>
    <label>Nazwisko:<input type="text" id="surname" name="surname"/></label><br/>
    <label>Pracodawca:<input type="text" id="employment" name="employment"/></label><br/>
    <label>Adres email:<input type="text" id="email" name="email"/></label><br/>
    <label>Potwierdź adres email:<input type="text" id="email" name="confirmemail"/></label><br/>
    <label>Skąd się dowiedziałeś o konferencji:</label><br/>
    <label>Ogłoszenie w pracy<input type="radio" name="info" value="work"/></label><br/>
    <label>Ogłoszenie w uczelni<input type="radio" name="info" value="school"/></label><br/>
    <label>Facebook<input type="radio" name="info" value="facebook"/></label><br/>
    <label>Znajomi<input type="radio" name="info" value="friends"/></label><br/>
    <input type="submit" value="Wyslij"/>
</form>
</body>
</html>
