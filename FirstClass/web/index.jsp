
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Student" %>
<%@page import="daw.StudentDao" %>
<%@page import="java.util.*" %>

<%@include file="header.jsp" %>

<% 

List<Student> list = StudentDao.getAllStudent();
request.setAttribute("list",list);


%>

<div class="container">

    <div class="bg-primary">
    <h1 class="text-warning text-center">All Student</h1>
    </div>
    <table class="table table-striped   ">

        <thead>

            <tr>

                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Contact Number</th>
                <th>Subject</th>
                <th>Gender</th>
                <th>Action</th>               

            </tr>

        </thead>

        <tbody>
            <c:forEach items="${list}" var="s">

                <tr>
                    <td>${s.getId()}</td>
                    <td>${s.getName()}</td>
                    <td>${s.getEmail()}</td>
                    <td>${s.getContactNo()}</td>
                    <td>${s.getSubject()}</td>
                    <td>${s.getGender()}</td>
                    

                    <td>
                        <a href="editstudentform.jsp?id=${s.id}" class="btn btn-primary">Edit</button>
                        <a href="deletestudent.jsp?id=${s.id}" class="btn btn-warning"
                           onclick="return confirm('Alert!! your are deleting this Student details');">Delete</a>

                    </td>

                </tr>

            </c:forEach>


    </table>



</div>

<%@include file="footer.jsp" %>
