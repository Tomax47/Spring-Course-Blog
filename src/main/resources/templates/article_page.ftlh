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
    <img src="${article.getImageUrl()}">
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

    <form action="/users/${.vars['user-id']}/articles/${article.id}/like" method="post">
        <input type="submit" value="Like">
    </form>
</div>

<div>
    <a href="/users/${userId}/articles">Back to Your Articles</a>
    <a href="/users/articles">Discover Others' Articles</a>
</div>

<script src="/js/filesUpload.js"></script>
</body>
</html>