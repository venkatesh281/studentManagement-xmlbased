<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
   <%@page isELIgnored ="false" %> 
  
<h1>Student details  </h1> 
<h3>${message}</h3>
<table border="2" width="70%" cellpadding="2">  
<tr><th>RollNum</th><th>Name</th><th>Mobile</th><th>Age</th><th>Std</th><th>Gender</th><th>Place</th>
                             <th>Edit</th><th>Delete</th></tr>  </tr>  
                               
   <c:forEach var="stud" items="${studentInfo}">   
   <tr>  
   <td>${stud.rollnum}</td>  
   <td>${stud.name}</td>  
   <td>${stud.mobile}</td>  
   <td>${stud.age}</td>  
   <td>${stud.std}</td>  
   <td>${stud.gender}</td>  
   <td>${stud.place}</td>  
   
   <td><a href="editstudent/${stud.rollnum}">Edit</a></td>  
   <td><a href="deletestudent/${stud.rollnum}">Delete</a></td>  
    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   
   
  <h4>   <a href="addAnotherStud">Add Student</a></h4><br>
  
  <h4>   <a href="viewteacher">Teacher Details</a></h4>
  
   