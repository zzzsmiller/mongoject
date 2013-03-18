<html>
<head>
    <title>Favourite fruit</title>
</head>
<body>
<h2>Choose your favourite fruit.</h2>
<form action="/favourite_fruit" method="POST">
    <#list fruits as fruit>
        <p>
            <input type="radio" name="fruit" value="${fruit}">${fruit} </input>
        </p>
    </#list>

    <input type="submit" value="Choose">
</form>

</body>
</html>