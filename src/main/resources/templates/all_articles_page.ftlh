<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
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

        <form action="/users/${.vars['userId']}/articles/${article.id}/like" method="post">
            <input type="submit" value="Like">
        </form>
    </#list>
</div>

<a href="/users/${userId}/articles">Make New Publication</a>
</body>
</html>