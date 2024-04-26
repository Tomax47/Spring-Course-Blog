<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
</head>
<body>
<h1>
    <h1>Sign Up Page!</h1>
</h1>

<form action="/signUp" method="post">
    <label>Email : </label>
    <input name="email">

    <label>Password : </label>
    <input name="password">

    <div>
        <label>
            <input type="checkbox" id="confirmBySMS">
            Confirm by SMS
        </label>
    </div>

    <div id="phoneNumberInput" style="display: none;">
        <label>Phone Number : </label>
        <input name="phoneNumber">
    </div>

    <input type="submit" value="Register">
</form>

<script src="/js/signUp.js"></script>
</body>
</html>