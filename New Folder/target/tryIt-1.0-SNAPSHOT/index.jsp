<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.wecashup.tryIt.HelloAppEngine" %>
<html>
<head>
  <link href='//fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
  <title>Hello App Engine Standard Java 8</title>
</head>
<body>
    <h1>Hello App Engine -- Java 8!</h1>

    <form action="/try" method="post">
			<p>
				<label> First name : <input type="text" name="firstname" /></label>
      </p>
      <p>
				<label>Last name : <input type="text" name="lastname" /></label>
      </p>
      <p>
				<label>Email address : <input type="text" name="email" /></label>
      </p>
      <p>
				<label>Password : <input type="password" name="password" /></label>
			</p>
			<p>

			</p>
			<p>
				<input type="submit" />
			</p>
		</form>

</body>
</html>
