<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/articles.css">
    <title>User's Articles</title>
</head>
<body>
<div>
    <form action="/users/${.vars['user-id']}/articles" method="post" enctype="multipart/form-data">
        <input name="name" placeholder="Article's title">
        <input name="type" placeholder="Type">
        <input name="text" type="text" placeholder="Content">
        <input type="file" name="file" accept=".jpg, .jpeg, .png" placeholder="Choose an image">
        <input type="submit" value="Post" id="articleSubmitBtn">
    </form>
</div>
<div>
    <#list articles as article>
        <p>
            Article-Id.${article.id} <strong> By </strong>${article.authorName}
        </p>
        <label><strong>Content :</strong></label>
        <p>
            ${article.text}
        </p>
        <p>
            ${article.likesCount}<strong> Likes</strong>
        </p>

        <form action="/users/${.vars['user-id']}/articles/${article.id}" method="get">
            <input type="submit" value="Show Article">
        </form>
    </#list>
</div>

<script src="/js/filesUpload.js"></script>
</body>
</html>