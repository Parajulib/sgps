<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<base href='<c:url value="/" />' />

<title>Log in Page</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/jquery-ui.min.css" rel="stylesheet">
<link href="resources/css/styles.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="container">

		<div class="row">

			<div class="col-md-4"></div>
			<div class="col-md-4">

				<form class="form-signin" method="post"
					action="j_spring_security_check">
					<h2 class="form-signin-heading">Please sign in</h2>
					<label for="inputEmail" class="sr-only">User Name:</label> 
					<input
						type="text" id="inputEmail" class="form-control"
						placeholder="Email address" name="username" required autofocus /> 
						<label
						for="inputPassword" class="sr-only">Password :</label> 
						<input
						type="password" name="password" id="inputPassword" class="form-control"
						placeholder="Password" required>
					<div class="checkbox">
						<label> Don't have an account ? 
						<a href="signup">Sign Up</a> 
							Here.
						</label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						in</button>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<!-- /.container -->

</body>
</html>