<!docktype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SignIn</title>
</head>
<body>
<form action="/signIn" method="post">
    <input name="email" type="email" placeholder="EMAIL">
    <input name="password" type="password" placeholder="PASSWORD">
    <input type="submit" value="Sing In">
</form>
<div class="sign-up-redirection">
    <p>Don't have an account? <a href="/signUp">Register</a></p>
</div>
</body>
</html>