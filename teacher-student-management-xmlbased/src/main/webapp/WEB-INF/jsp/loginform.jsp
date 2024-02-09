<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@page isELIgnored="false"%>





<html>  
<head>  
<style>  
.error{color:red}  
</style>  
</head>  
<body>  
<h1>Login Page</h1>
<h3>${message}</h3>
<form action="logincheck" >  
<p>Enter Your Correct Id and Password</p>
Id: <input type="text" name="id"/> <br><br>   
Password : <input type="text" name="password"/> <br><br>   
<form:errors path="password" cssClass="error"/><br><br>  
<input type="submit" value="submit">  
</form>  





<h3>If you don't have an account! Please Register... </h3>
<h4><a href = "register">Register</a></h4>
</body>  
</html>  