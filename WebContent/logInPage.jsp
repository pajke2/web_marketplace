<!--Naredne tri linije koda nam omogucavaju da HTML stranica bude dinamicka (JSP)-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>web oglasnik - Home Page</title>
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
				<center>
				
				<form action="logIn" method="post">
				<br>
				<input type="text" name="username" id="username"/><br>
				<label>Korisnicko ime</label><br><br>
				<input type="password" name="password" id="password"/><br>
				<label>Sifra</label><br><br>
				
				<input type="submit" value="Log in"/>		
								
				</form>
				
				<p>${message}</p>
					
				</center>
				</div>
			</div>
			<div style="clear:both; "></div>
			
			<%@ include file = "snippets/footer.jsp" %>	

		</div>
		
		
	</body>
</html>