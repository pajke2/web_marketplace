<!--Naredne tri linije koda nam omogucavaju da HTML stranica bude dinamicka (JSP)-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>web oglasnik - Home Page</title>
		<script src="js/myScript.js"></script>
	</head>
	<body>
	
		<%@ include file = "snippets/header.jsp" %>
			
			<div style="margin-top:15px;">

		<%@ include file = "snippets/userPanel.jsp" %>	
			
				<c:if test="${user != null }">
					<div style="padding-left:200px;">
				</c:if>
				<c:if test="${user != null }">
					<div>
				</c:if>
				<br/>
				<br/>
				<form action="editUser" method="post"  onsubmit="return checkForm();">
				
				<input type="hidden" name="userId" id="userId" value="${user.id}"/>
				
				<label>Ime: </label> <br>
				<input type="text" id="firstName" name="firstName" value="${user.firstName}" onblur="checkName();" required="required"/><br><br>
				<label>Prezime: </label> <br>
				<input type="text" id="lastName" name="lastName" value="${user.lastName}" onblur="checkLastName();" required="required"/><br><br>
				<label>Korisnicko ime: </label> <br>
				<input type="text" id="username" name="username" value="${user.username}" required="required"/><br><br>
				
				<label>Email: </label> <br>
				<input type="text" id="email" name="email" value="${user.email}" required="required"/><br><br>
				<label>Datum rodjenja: </label> <br>
				<input type="date" id="birthday" name="birthday" value="${user.birthdayFormated}" required="required"/><br><br>
				
				<label>Pol: </label><br>
				<c:if test="${user.sex == true}">
					<label>m </label>
					<input type="radio" name="sex" id="sex" value="true" checked/><br>
					<label>z </label>
					<input type="radio" name="sex" id="sex" value="false"/><br><br>
				</c:if>

				<c:if test="${user.sex == false}">
					<label>m </label>
					<input type="radio" name="sex" id="sex" value="true"/><br>
					<label>z </label>
					<input type="radio" name="sex" id="sex" value="false" checked/><br><br>
				</c:if>
				
				<label>Grad</label><br>
				<input type="text" name="city" id="city" value="${user.city}"/><br><br>
				
				<label>Ukucajte sifru da potvrdite izmjene: </label> <br>
				<input type="hidden" id="password" name="password" value="${user.password}"/>
				<input type="password" id="password1" name="password1" onblur="checkPassword2();"/><br><br>
				<input type="submit" value="Izmjeni profil" id="mySubmit"/><br><br>
				<p>${message}</p>
				</form>
				</div>
			</div>
			<div style="clear:both; "></div>
			
			<%@ include file = "snippets/footer.jsp" %>	

		</div>
		
		
	</body>
</html>