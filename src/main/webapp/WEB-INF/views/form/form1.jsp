<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="headerForm.jsp" %>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form modelAttribute="donation">

            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>


                <c:forEach items="${categories}" var="category">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:checkbox path="categories" value="${category.id}"/>
                            <span class="checkbox" id="categCheck"></span>
                            <span class="description" id="categVal">${category.name}</span>
                        </label>
                    </div>
                </c:forEach>
                <form:errors path="categories"/>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step" id="summ1">Dalej</button>
                </div>
            </div>


            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <span id="quanVal"><form:input type="number" min="1" path="quantity"/></span>
                        <form:errors path="quantity"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step" id="summ2">Dalej</button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>
                <c:forEach items="${institutions}" var="institution">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:radiobutton path="institution" value="${institution.id}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                                <div class="title">Fundacja “<span id="institVal">${institution.name}</span>”</div>
                  <div class="subtitle">
                    Cel i misja: ${institution.description}.
                  </div>
                </span>
                        </label>
                    </div>
                </c:forEach>
                <form:errors path="institution"/>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step" id="summ3">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzeczy przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica&nbsp;<span id="streetVal"><form:input path="street"/></span></label>
                            <form:errors path="street"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>Miasto&nbsp;<span id="cityVal"><form:input path="city"/></span></label>
                            <form:errors path="city"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy&nbsp;<span id="zipCodeVal"><form:input path="zipCode"/></span>
                            </label>
                            <form:errors path="zipCode"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu&nbsp;<span id="phoneVal"><form:input path="phoneNumber"/></span>
                            </label>
                            <form:errors path="phoneNumber"/>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data<form:input type="date" path="pickUpDate"/></label>
                            <form:errors path="pickUpDate"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina<form:input type="time" path="pickUpTime"/></label>
                            <form:errors path="pickUpTime"/>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera&nbsp;
                                <form:textarea path="pickUpComment"/>
                            </label>
                            <form:errors path="pickUpComment"/>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step" id="summ4">Dalej</button>
                </div>
            </div>

            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text" id="formQuanSum"
                                ></span>&nbsp;worek/worki z kategorii:&nbsp;<span class="summary--text" id="formCatSum"></span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text"
                                >Dla fundacji "</span><span class="summary--text" id="formInstitSum"></span>" w&nbsp;<span class="summary--text" id="formCitySum">Warszawie</span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="formStreetSum">Prosta 51</li>
                                <li id="formCitySum2">Warszawa</li>
                                <li id="formZipCodeSum">99-098</li>
                                <li id="formPhoneNumberSum">123 456 789</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li id="formDataSum">13/12/2018</li>
                                <li id="formTimeSum">15:40</li>
                                <li id="formCommForCourierSum">Brak uwag</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
    </div>
</section>


<%@ include file="../footer.jsp" %>
