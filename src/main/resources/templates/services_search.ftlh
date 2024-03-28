<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Services List</title>
</head>
<body>

<!-- SEARCH FOR SERVICE -->
<h1>Search Services</h1>
<div class="form-container">
    <form action="/paper/service/search" method="post">
        <input type="number" name="page" placeholder="Page">
        <input type="number" name="size" placeholder="Search Size">
        <input type="text" name="q" placeholder="Search query here">

        <button id="searchBtn">Search</button>
    </form>
</div>

<h1>Services</h1>
<ul id="serviceList"></ul>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/js/services.js"></script>
</body>
</html>