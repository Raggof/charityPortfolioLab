<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../header.jsp" %>


<form:form modelAttribute="donation">
    Kategorie:<br/>
    <form:checkboxes path="categories" items="${categories}"/><br/>
    Instytucje:<br/>
    <form:select path="institution" items="${institutions}"/><br/>
    Kod pocztowy:<br/>
    <form:input path="zipCode"/><br/>
    Ulica:<br/>
    <form:input path="street"/><br/>
    Misto:<br/>
    <form:input path="city"/><br/>
    Ilość worków:<br/>
    <form:input path="quantity"/><br/>
    Komentarz:<br/>
    <form:textarea path="pickUpComment"/><br/>
    Dzień odebrania:<br/>
    <form:input type="date" path="pickUpDate"/><br/>
    Godzina odebrania:<br/>
    <form:input type="time" path="pickUpTime"/><br/>
</form:form>


<%@ include file="../footer.jsp" %>
