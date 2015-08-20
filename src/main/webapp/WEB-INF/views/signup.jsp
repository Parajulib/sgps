<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<base href='<c:url value="/" />' />
<title>Sign Up</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/jquery-ui.min.css" rel="stylesheet">
<link href="resources/css/styles.css" rel="stylesheet">
<script src="resources/js/jquery-1.11.3.min.js"></script>
<script src="resources/js/jquery-ui.min.js"></script>

<script type="text/javascript">
$(document)
.ready(
  function() {
    $(".date").datepicker({
      dateFormat: "yy-mm-dd",
      changeYear: true,
      changeMonth: true,
      yearRange: "1975:2020"
    });

    $("#password")
      .blur(
        function() {
          var password = $(this).val();
          if (password.length > 0) {
            if (password.length < 6) {
              $(".passwordresult")
                .html(
                  "Password must be atleast 6 character or more.");
            } else {
              $(".passwordresult").html("");
            }
          }
        });

    $("#retype_password")
      .blur(
        function() {
          var retype = $(this).val();

          var password = $("#password").val();

          if (password === retype) {
            $(".retype_password_result")
              .html("");
          } else {
            $(".retype_password_result")
              .html(
                "Retype Password didn't match.");
          }

        });
       
    
    $("#username").blur(function() {
          var username = $("#username").val();
          if (username.length > 0) {
            if (!username.match(/[^-a-z]/g)) {
              if (username.length < 6) {
                $(".usernameresult").html("Username must be atleast 6 character or more");
              } else {
                $(".usernameresult").html("");

                $.post("checkusername", {
                      'username': username
                    },function(data) {
                      if (data === 'invalid') {
                        $(".usernameresult").html("Username already exist.");
                      }
                    });
              	}

            } else {
              	$(".usernameresult").html("Invalid Characters ! username should be lower cased characters only.");
            }
          }
        });

  });
</script>
</head>
<body>
	<div class="container">

		<div class="row">

			<div class="col-md-4"></div>
			<div class="col-md-4">
				${notification}
				<form action="signup" class="form-signin" method="post">
					<h2 class="form-singin-heading">Creat User Login</h2>
					<select name="user_type" class="form-control" style="width: 50%"
						required autofocus>
						<option value="">Select User Type</option>
						<option value="student"
							<c:if test="${param.user_type == 'student'}">selected</c:if>>Student</option>
						<option value="teacher"
							<c:if test="${param.user_type == 'teacher'}">selected</c:if>>
							Teacher</option>
					</select> <label for="inputEmail" class="sr-only">User Name:</label><br />
					<input type="text" class="form-control" placeholder="User Name"
						id="username" name="username" value="${param.username}" required />
						<div class="usernameresult error">${username_error}</div>
					<label for="inputPassword" class="sr-only">Password :</label> <br />
					<input type="password" id="password" name="password"
						value="${param.password}" class="form-control"
						placeholder="Password" required />
					<div class="passwordresult error">${password_error}</div>
					<br />
					<input type="password" id="retype_password"
						value="${param.retype_password}" name="retype_password"
						class="form-control" placeholder="Retype Password" required /> 
					<div class="retype_password_result error">${retype_password_error}</div>
					<br />
					<input type="number" name="regNumber" class="form-control"
						placeholder="Registration Number" value="${param.regNumber}"
						required />
					<div class="regNumber_result error">${regNumber_error}</div><br />
					<input type="date"
						pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
						name="dateOfBirth" class="form-control date"
						placeholder="Date of Birth : yyyy-mm-dd"
						value="${param.dateOfBirth}" required /> 
					<div class="dateOfBirth_result error">${dateOfBirth_error}</div><br />
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
						up</button>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<!-- /.container -->
</body>
</html>