<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../header.jsp" />

<div class="container">

	<h1>List Teachers</h1>
	
	<div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Fist Name</th>
                  <th>Last Name</th>
                  <th>Date Of Birth</th>
                  <th>Edit / Delete</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${teacher}" var="teacher">
                <tr>
                  <td>${teacher.id}</td>
                  <td>${teacher.firstName}</td>
                  <td>${teacher.lastName}</td>
                  <td>${teacher.dateOfBirth}</td>
                  <td><a class="btn" href="teacher/edit/${teacher.id}"><i class="glyphicon glyphicon-pencil"></i></a> <a onClick="return confirm('Are you sure?');" class="btn" href="teacher/delete/${teacher.id}"><i class="glyphicon glyphicon-trash"></i></a></td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
	
</div>

<jsp:include page="../footer.jsp" />