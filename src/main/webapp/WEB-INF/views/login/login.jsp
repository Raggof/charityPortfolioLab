<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../register/registerHeader.jsp" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<section class="login-page">
    <h2>Zaloguj się</h2>

    <form method="POST" action="${contextPath}/login" class="form-signin">

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <div class="form-group">
                <label>
                    <input name="name" type="email" placeholder="Email"/>
                </label>
            </div>
            <div class="form-group">
                <label>
                    <input name="password" type="password" placeholder="Password"/>
                </label>
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
            </div>

            <div class="form-group form-group--buttons">
                <a href="registration" class="btn btn--without-border">Załóż konto</a>
                <button class="btn" type="submit">Zaloguj się</button>
            </div>
        </div>
    </form>
</section>

<%@ include file="../footer.jsp" %>