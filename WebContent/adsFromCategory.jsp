<!--Naredne tri linije koda nam omogucavaju da HTML stranica bude dinamicka (JSP)-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>${ad.category.categoryName}</title>
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
				<center>

						<c:forEach items="${ads}" var="ad">
							<h3>${ad.title}</h3>
							<br>
														
							<c:if test="${ad.images!=null && ad.images.size()>0}">
								<img src ="ad_images/${ad.images.get(0)}" width="150px"/>
							</c:if>
							<c:if test="${ad.images==null || ad.images.size()==0 }">
								<img src ="ad_images/default.jpg" width="150px"/>
							</c:if>
							<br>
							<a href="details?adId=${ad.id}">detaljno...</a>
					
							<br/>
							Datum postavljanja: ${ad.postingDateFormated}
							<br/>
							Cena: ${ad.price}
						</p>
					</c:forEach>
				</center>
				</div>
			</div>
			<div style="clear:both; "></div>
			
			<%@ include file = "snippets/footer.jsp" %>	

		</div>
		
		
	</body>
</html>