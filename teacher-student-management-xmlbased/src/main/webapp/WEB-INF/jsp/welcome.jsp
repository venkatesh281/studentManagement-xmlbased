 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
   <%@page isELIgnored ="false" %> 
  
  <% 
String name=(String)session.getAttribute("user"); 
out.print("Hello User: You have entered the name: "+name );

if(name!=null)  {%>
	
welcome ${user}
    <h3><a href = "viewteacher">Teacher details</a> <br><br>
    
    <a href = "viewstudent">Student details</a><br><br>
    <a href = "logout">LogOut</a><br><br></h3>
<% } else {%>
<a href = "login">LogIn</a>

<%} %>

<%--  <c:choose>
<c:when test="${name}!=null">
</c:when>
<c:otherwise>
<p>login failed</p>

</c:otherwise>
</c:choose> --%>


