<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE htm>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="_css/file.css"/>
<title>Insert title here</title>
</head>
<body>

	 
 
<section id="des" class="grid clearfix">
  <header>
    <i class="icon-rocket"></i>
    <h1>Cadastro de Produto</h1>
  </header>
 
  <form action="#" method="post">
    <div class="field-container">
      <label>Name</label>
      <input type="text" placeholder="Enter Full Name" pattern=".{4,}" required />
      <i class="icon-user"></i>
    </div>
	
	 <div class="field-container">
      <label>Username</label>
      <input type="text" placeholder="Enter Username" pattern=".{4,}" required />
      <i class="icon-user"></i>
    </div>
	

    <div class="field-container">
      <label>Email:</label>
      <input type="email" placeholder="Enter Email" required />
      <i class="icon-envelope-alt"></i>
    </div>
         
		 <div class="field-container">
      <label>Password:</label>
      <input type="text" placeholder="Enter Password" pattern=".{4,}" required />
      <i class="icon-user"></i>
    </div>
	
    <div class="controls-container">
      <input type="submit" value="Signup" />
    </div>
  </form>
   
</section>
</body>
</html>