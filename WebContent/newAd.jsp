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
					<form action="newAd" method="post">
					<label>Naslov oglasa: </label>
					<input type="text" name="title" id="title" onblur="checkTitle();" required="required"/><br><br>
					
					<label>Detalji oglasa </label><br>
					<textarea cols="20" rows="5" name="detail" id="detail" required="required"></textarea><br><br>
					
					<label>Kategorija</label>
					<select name="categoryId" id="categoryId">
					<c:forEach items="${cat}" var="cat">
						<option value="${cat.id}">${cat.categoryName}</option>
					</c:forEach>
					</select><br><br>			
						
					<label>Cijena: </label>
					<input type="text" name="price" id="price" required="required"/><br><br>
					
					<label>Tip oglasa</label><br>
					<label>proizvod </label>
					<input type="radio" name="type" id="type" value="product" checked/><br>
					<label>Usluga </label>
					<input type="radio" name="type" id="type" value="service"/><br><br>
					
					<label>Stanje</label><br>
					<label>Novo </label>
					<input type="radio" name="condition" id="condition" value="new" checked/><br>
					<label>Polovno </label>
					<input type="radio" name="condition" id="condition" value="used"/><br><br>
					
					<input type="submit" value="Postavi oglas"/>
				
				</form>
				<p>${message}</p>
				</div>
			</div>
			<div style="clear:both; "></div>
			
			<%@ include file = "snippets/footer.jsp" %>	

		</div>
		
		
	</body>
</html>