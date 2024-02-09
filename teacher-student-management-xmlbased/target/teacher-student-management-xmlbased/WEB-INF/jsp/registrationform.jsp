<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<%@page isELIgnored="false"%>



<html>
<head>
<title>Registration Form</title>
</head>
<h3>Teacher Registration Form</h3>
<body>
	<form:form  action="saveteacher" modelAttribute="Teacher" method ="post">

Id :  <form:input path="id" /><br></br>
		

Name :<form:input path="name" /><br></br>
		

Email :<form:input path="email" /><br></br>
		

Marital Status :
Married<form:radiobutton path="maritalStatus" value="Married" />  
Single<form:radiobutton path="maritalStatus" value="Single" />
		<br></br>

Gender :
Male<form:radiobutton path="gender" value="Male" />  
Female<form:radiobutton path="gender" value="Female" /> 
<br></br>


Age :<form:input path="age" /><br></br>
		

		

		
State :<form:select path="state">
			<form:option value="TamilNadu" label="TamilNadu" />
			<form:option value="Karnataka" label="karnataka" />
			<form:option value="Goa" label="Goa" />
<br></br>
			</form:select>
		
		<br>
		<br>  
  


District :<form:select path="district" > 
			<br>
			<form:option value="Sivaganagi" label="Sivaganagi" />
			<form:option value="Rmd" label="Rmd" />
			<form:option value="Madurai" label="Madurai" />
			<form:option value="Viruthunagar" label="Viruthunagar" />
			<form:option value="Chennai" label="Chennai" />
			</form:select>
			<br></br>

<p>Password must be length 5</p>			
Password :<form:input path="password" /> 
		<br></br>
		
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>
