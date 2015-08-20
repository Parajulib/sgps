<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<jsp:include page="../header.jsp" />
<div class="container">


	<h1>Add New Teacher</h1>

	<div class="row">
		<div class="col-md-6">

			<form:form method="post" modelAttribute="teacher" action="teacher/save" class="form-horizontal">

				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail3">First
						Name :</label>
					<div class="col-sm-9">
						<form:input type="text" path="firstName" placeholder="First Name"
							class="form-control"/>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail3">Last
						Name :</label>
					<div class="col-sm-9">
						<form:input type="text" path="lastName" placeholder="Last Name"
							class="form-control"/>
					</div>
				</div>
					<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail3">Date of Birth
						 :</label>
					<div class="col-sm-9">
						<form:input type="text" path="dateOfBirth" placeholder="Date of Birth"
							class="form-control date"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label" for="inputEmail3">
						 </label>
					<div class="col-sm-9">
						<input type="submit" value ="Submit"
							class="btn btn-primary">
					</div>
					
				</div>
			</form:form>

		</div>


	</div>
</div>

<jsp:include page="../footer.jsp" />