<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/filesStyle.css">
    <title>Upload A File</title>
</head>
<body>

<h1>Upload A New File</h1>
<div class="form-div">
    <input class="file-input" type="file" id="file" name="file" accept="image/*" placeholder="File here"/>
    <input type="hidden" id="file_hidden">
    <button onclick="sendFile()">
        Upload
    </button>
    <div class="filename"></div>
</div>
<div class="img-div">
    <img id="photo" src="#">
</div>

<script src="/js/filesUpload.js"></script>
<script
        src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>
</body>
</html>