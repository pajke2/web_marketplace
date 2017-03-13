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
				</c:if><br><br>
				
				<br/>
				<br/>
				
				
				<div style="padding-left:200px;">
				
					<a href ="editAd?adId=${adId}">nazad</a>
					
					<br/>
					<p style="color: red">${message}</p>
					<br/>
					
					<form action="image" method="post" enctype="multipart/form-data">
						<label>Izaberite sliku</label><br/>
						<input type="file" name="image"/><br/>
						<input type="hidden" value="${adId}" name="adId"/>
						<input type="submit" value="Upload"/>
					</form>
					<center>
					<br/>
					<br/>
					<div>
						<c:forEach items="${images}" var="img">
							<div style="float: left; margin: 10px">
								<div>
									<img src="ad_images/${img.path}" width="150px"/>
								</div>
								<div>
									<a href="deleteImage?imgId=${img.id}&adId=${adId}">Delete</a>
								</div>
							</div>
						
						</c:forEach>
					</div>
				</div>
				
				</center>
				</div>
			</div>
			<div style="clear:both; "></div>
			
			<%@ include file = "snippets/footer.jsp" %>	

		</div>
		
		
	</body>
</html>