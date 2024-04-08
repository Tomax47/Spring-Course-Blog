<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Services</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/ServicesStyle.css">
</head>
<body>

<!-- ADDING A SERVICE -->
<h1>Add Services</h1>
<div class="form-container">
    <label><b>Name</b></label>
    <input
            type="text"
            id="name"
            placeholder="Name">

    <label><b>Cost</b></label>
    <input
            type="text"
           id="cost"
           placeholder="Cost">

    <label><b>Time</b></label>
    <input
            type="text"
            id="date"
            placeholder="Time">
    <button class="button" id="addServiceBtn">Add Service</button>
</div>


<#-- TABLE RENDERING THE SERVICES -->
<div>
    <table id="servicesTable">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>cost</th>
            <th>date</th>
        </tr>
        <#list servicesList as services>
            <tr>
                <td>${services.id}</td>
                <td>${services.name}</td>
                <td>${services.cost}</td>
                <td>${services.date}</td>
            </tr>
        </#list>
    </table>
</div>

<script src="/js/services.js"></script>
<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>
</body>

</html>