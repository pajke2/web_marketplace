<!--Naredne tri linije koda nam omogucavaju da HTML stranica bude dinamicka (JSP)-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>web oglasnik - Error page</title>
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
				<br><br>
				<h3>ERROR</h3>
				<p>${message}</p>
			</div>
			</div>
			<div style="clear:both; "></div>
			
			
			<%@ include file = "snippets/footer.jsp" %>	

		</div>
		
		
	</body>
</html>