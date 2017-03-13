<!--Naredne tri linije koda nam omogucavaju da HTML stranica bude dinamicka (JSP)-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${ad.title} detaljno</title>
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
						<p>${message}</p>
						

							<h3>${ad.title}</h3>
							Cena: ${ad.price}<br><br>
							Kategorija: <a href="category?catId=${ad.category.id}">${ad.category.categoryName}</a>
							<br>
							<br>							
							<c:if test="${ad.images!=null && ad.images.size()>0}">
								<c:forEach var="i" begin="0" end="${ad.images.size()-1}">
									<img src ="ad_images/${ad.images.get(i)}" width="250px"/>
								</c:forEach>
								
							</c:if>
							<c:if test="${ad.images==null || ad.images.size()==0 }">
								<img src ="ad_images/default.jpg" width="150px"/>
							</c:if>
							<br>
							Detaljno: <p id="detail">${ad.detail}</p>
							<br>
							<br/>
							<a href="comments?adId=${ad.id}">komentari</a>
							Datum postavljanja: ${ad.postingDateFormated}
							<br/>
							
						</p>
				</center>
				</div>
			</div>
			<div style="clear:both; "></div>
			
			<%@ include file = "snippets/footer.jsp" %>	

		</div>
		
		
	</body>
</html>