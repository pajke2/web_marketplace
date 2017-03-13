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
					<a href="image?adId=${ad.id}">Slike oglasa</a><br><br>
					<form action="editAd" method="post">
					<label>Naslov oglasa: </label>
					<input type="text" name="title" id="title" value="${ad.title}" onblur="checkTitle()" required="required" /><br><br>
					
					<label>Detalji oglasa </label><br>
					<textarea cols="20" rows="5" name="detail" id="detail" required="required">${ad.detail}</textarea><br><br>
					
					<label>Kategorija</label>
					<select name="categoryId" id="categoryId">
						<c:forEach items="${category}" var="cat">
							<c:if test="${cat.id == ad.categoryId}">
								<option value="${cat.id}" selected="selected">${cat.categoryName}</option>
							</c:if>
							
							<c:if test="${cat.id != ad.categoryId}">
								<option value="${cat.id}">${cat.categoryName}</option>
							</c:if>
						</c:forEach>
					</select><br><br>			
						
					<label>Cijena: </label>
					<input type="text" name="price" id="price" value="${ad.price}" required="required"/><br><br>
					
					<label>Tip oglasa</label><br>
					
					<c:if test="${ad.saleSubjectType == true}">
					<label>proizvod </label>
					<input type="radio" name="type" id="type" value="true" checked/><br>
					<label>Usluga </label>
					<input type="radio" name="type" id="type" value="false"/><br><br>
					</c:if>
					
					<c:if test="${ad.saleSubjectType == false}">
					<label>proizvod </label>
					<input type="radio" name="type" id="type" value="true"/><br><br>
					<label>Usluga </label>
					<input type="radio" name="type" id="type" value="false" checked/><br><br>
					</c:if>
					
					<label>Stanje</label><br>
					<c:if test="${ad.saleSubjectCondition == true}">
					<label>Novo </label>
					<input type="radio" name="condition" id="condition" value="true" checked/><br>
					<label>Polovno </label>
					<input type="radio" name="condition" id="condition" value="false"/><br><br>
					</c:if>
					
					<c:if test="${ad.saleSubjectCondition == false}">
					<label>Novo </label>
					<input type="radio" name="condition" id="condition" value="true"/><br>
					<label>Polovno </label>
					<input type="radio" name="condition" id="condition" value="false" checked/><br><br>
					</c:if>
					
					<input type="hidden" id="postingDate" name="postingDate" value="${ad.postingDateFormated2}"/>
					<input type="hidden" id="userId" name="userId" value="${ad.userId}"/>
					<input type="hidden" id="adId" name="adId" value="${ad.id}"/>
					
					<input type="submit" value="Edituj oglas" id="mySubmit"/>
				
				</form>
				
					<br><br>
					<a href="deleteAd?adId=${ad.id}">Obrisi oglas</a>
					
				<p>${message}</p>
				</div>
			</div>
			<div style="clear:both; "></div>
			
			<%@ include file = "snippets/footer.jsp" %>	

		</div>
		
		
	</body>
</html>