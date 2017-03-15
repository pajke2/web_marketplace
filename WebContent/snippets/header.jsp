		<div style="margin-left:100px; margin-right:100px;">
			<div>
			<a href = "index.jsp"><img src="images/logo.png" width="250px"/></a>
			</div>
			<div style="background-color: gray ; padding:15px;">
				<a href="index.jsp" style="color:white">POCETNA</a> <span style="color:white">|</span> 
				
				<c:if test="${user == null}">
				<a href="registration" style="color:white">REGISTRACIJA</a> <span style="color:white">|</span> 
				<a href="logIn" style="color:white">LOGOVANJE</a> <span style="color:white">|</span> 
				</c:if>
				<a href="allCategories" style="color:white">KATEGORIJE</a> 
				<span style="color:white">|</span> <form action="search" method="get"> <input type="text" name="searchParameter"/><input type="submit" value="pretraga"/></form>
			</div>