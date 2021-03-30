<html>
<head>
    <title>Register</title>
</head>
<body>

<form method="post" action="register"><!-- within doPost() in servlet-->
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    Date of Birth :<input type="text" name="birthDate"/><br/>
    <input type="submit" value="Register"/>
</form>

</body>
</html>
