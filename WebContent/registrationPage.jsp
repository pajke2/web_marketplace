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
				<form action="registration" method="post"  onsubmit="return checkForm();">
				<p>${message}</p>
				
				<label>Ime: </label> <br>
				<input type="text" id="firstName" name="firstName" onblur="checkName();" required="required"/><br><br>
				<label>Prezime: </label> <br>
				<input type="text" id="lastName" name="lastName" onblur="checkLastName()" required="required"/><br><br>
				<label>Korisnicko ime: </label> <br>
				<input type="text" id="username" name="username" required="required"/><br><br>
				<label>Sifra: </label> <br>
				<input type="password" id="password" name="password" required="required"/><br><br>
				<label>Ponovo ukucajte sifru: </label> <br>
				<input type="password" id="password1" name="password1" required="required" onblur="checkPassword();"/><br><br>
				<label>Email: </label> <br>
				<input type="text" id="email" name="email" required="required"/><br><br>
				<label>Datum rodjenja: </label> <br>
				<input type="date" id="birthday" name="birthday" required="required"/><br><br>
				
				<label>Pol: </label><br>
				<input type="checkbox" name="sex" id="sex" value="m" checked/> m
				<br>
				<input type="checkbox" name="sex" id="sex" value="z"/> z 
				<br><br>
				<label>Grad</label><br>
				<input type="text" name="city" id="city"/><br><br>
				<input type="submit" value="registruj se" id="mySubmit"/><br><br>

				</form>
				</div>
			</div>
			<div style="clear:both; "></div>
			
			<%@ include file = "snippets/footer.jsp" %>	

		</div>
		
		
	</body>
</html>