<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Login Javatos Garage</title>

</head>
<body onload='document.loginForm.username.focus();'>

<style>
  
  body {
  background: url("https://cdn.motor1.com/images/mgl/jAVWR/s3/porsche-concession.jpg");
  background-repeat: no-repeat, repeat;
  background-position: center;
  background-size: cover;
}
</style>

    <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            
            <h5 class="card-title text-center">JAVATOS LOGIN PAGE</h5>
            <h5 class="card-title text-center">Veuillez vous connecter</h5>
            <c:if test="${not empty error}">
            <div class="error">${error}</div>
            </c:if>
        	<c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        	</c:if>
            
            <form name="loginForm" action="login" method="POST" class="form-signin">
              <div class="form-label-group">
                <input type="text" name="username" class="form-control" required autofocus>
                <label>User</label>
              </div>

              <div class="form-label-group">
                <input type="password" name="password" class="form-control" required>
                <label>Password</label>
              </div>

              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Connecter</button>
              
               <input class="btn btn-lg btn-primary btn-block text-uppercase" type="hidden" name="${__csrf.parameterName}" value="${__csrf.token}"></input>
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>
</html>