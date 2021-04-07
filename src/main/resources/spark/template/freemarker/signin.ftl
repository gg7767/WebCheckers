<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/style.css">
    <title>Signin Page</title>
</head>
<body>
    <h1>
        Sign In
    </h1>
    <#include "message.ftl" />

    <form  action = "/signin" method=post>Enter your name:
        <br />
        <input name = "myName" />
        <br/><br/>
        <button type="submit">Ok</button>
    </form>


</body>
</html>