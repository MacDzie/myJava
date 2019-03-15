<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta  http-equiv="Content-Type" contentType="text/html; charset=UTF-8">
</head>
<body>
    <form action="repayment" method="POST">
        <label>Wnioskowana kwota kredytu:<input type="text" id="creditSum" name="creditSum"/></label><br/>
        <label>Ilość rat:<select id="repaymentCount" name="repaymentCount">
            <option>3</option>
            <option>6</option>
            <option>12</option>
            <option>24</option>
            <option>36</option>
            <option>48</option>
            <option>60</option>
            <option>72</option>
            <option>84</option>
            <option>96</option>
            <option>108</option>
            <option>120</option>
        </select></label><br/>
        <label>Oprocentowanie:<input type="text" id="lendingRate" name="lendingRate"/>%</label><br/>
        <label>Opłata stała:<input type="text" id="flatCharge" name="flatCharge"/></label><br/>
        <label>Rodzaj rat:<input type="radio" id="firstRepayment" name="kindRepayment" value="fallRepayment"/>Rata malejąca
            <input type="radio" id="secondRepayment" name="kindRepayment" value="constantRepayment"/>Rata stała</label><br/>
        <label>Wybierz opcję:<select id="action" name="action">
            <option value="display">Wyświetl harmonogram spłat</option>
            <option value="createPdf">Wygeneruj plik PDF</option>
        </select></label></br>
        <input type="submit" value="Oblicz raty"/>
    </form>
</body>
</html>
