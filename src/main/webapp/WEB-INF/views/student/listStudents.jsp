<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../header.jsp" />

<div class="container">

	<h1>List Students</h1>
	
	<div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Fist Name</th>
                  <th>Last Name</th>
                  <th>Date Of Birth</th>
                  <th>Father Name</th>
                  <th>Mother Name</th>
                  <th>Address</th>
                  <th>Edit / Delete</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${students}" var="student">
                <tr>
                  <td>${student.id}</td>
                  <td>${student.firstName}</td>
                  <td>${student.lastName}</td>
                  <td>${student.dateOfBirth}</td>
                  <td>${student.fatherName}</td>
                  <td>${student.motherName}</td>
                  <td>${student.address}</td>
                  <td><a class="btn" href="student/edit/${student.id}"><i class="glyphicon glyphicon-pencil"></i></a> <a onClick="return confirm('Are you sure?');" class="btn" href="student/delete/${student.id}"><i class="glyphicon glyphicon-trash"></i></a></td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
	
</div>

<jsp:include page="../footer.jsp" />