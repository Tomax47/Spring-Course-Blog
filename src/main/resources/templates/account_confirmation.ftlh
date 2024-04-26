<!docktype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Confirm Account</title>
</head>
<body>
<h1>Confirm Your Account</h1>
<p>We have sent the confirmation code to your number, please check your messages!</p>
<form action="/sms/confirm" method="post">
    <input type="hidden" value="${vCode}" name="code">
    <input type="hidden" value="${email}" name="email">
    <input name="vCode" id="verificationCode" placeholder="Enter the verification code">
    <input type="submit" value="Confirm Account">
</form>
</body>
</html>