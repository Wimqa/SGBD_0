<%--
  Created by IntelliJ IDEA.
  User: Code
  Date: 16-08-20
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>

<div class="mySmallContainer">
	<div class="mySmallContainer">
		<span class="title1"> School UX </span>
	</div>


	<div class="mySmallContainer">
		<div class="title2"> Confirmation d'inscription  </div>

		<div class="title3">C'est un plaisir de t'accueillir ${sessionScope.signedUser.firstName} ${sessionScope.signedUser.lastName} !</div>

		<p> 	  Username : ${sessionScope.signedUser.username}
			<br/> Role : ${sessionScope.signedUser.rolesByIdRole.label}
		</p>

	</div>

	<div class ="mySmallContainer">
		<a href="${pageContext.request.contextPath}/home" id="signUpButton" class="btn btn-sm btn-outline-primary" name="" >
				Accéder sans plus attendre à cette magnifique application
		</a>
	</div>

	<!--
    <div class="mySmallContainer">
        <a class=" btn btn-sm btn-outline-primary"  href="${pageContext.request.contextPath}/home">
            Accéder sans plus attendre à cette magnifique application
        </a>
    </div>
    -->

</div>