 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
   <%@page isELIgnored ="false" %> 
  
<h1> Registered Successfully</h1> 
<h2> Staff Details </h2> 
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Email</th><th>MaritalStatus</th><th>Gender</th><th>Age</th><th>State</th>
                               <th>District</th><th>Password</th><th>Edit</th> </tr>  
                               
   <c:forEach var="teacher" items="${teacherInfo}">   
   <tr>  
   <td>${teacher.id}</td>  
   <td>${teacher.name}</td>  
   <td>${teacher.email}</td>  
   <td>${teacher.maritalStatus}</td>  
   <td>${teacher.gender}</td>  
   <td>${teacher.age}</td>  
   <td>${teacher.state}</td>  
   <td>${teacher.district}</td>  
   <td>${teacher.password}</td>  
    <td><a href="editteacher/${teacher.id}">Edit</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br></br>
   
  <h2> <a href ="login"> Logout</a></h2>
   <br/>  
   
   
   
   
   <h2> Now Login </h2>
   <a href="login">Teacher Login</a>  
   
   