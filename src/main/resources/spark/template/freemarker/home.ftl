<!DOCTYPE html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
  <meta http-equiv="refresh" content="10">
  <title>Web Checkers | ${title}</title>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>
<div class="page">

  <h1>Web Checkers | ${title}</h1>

  <!-- Provide a navigation bar -->
  <#include "nav-bar.ftl" />

  <div class="body">

    <!-- Provide a message to the user, if supplied. -->
    <#include "message.ftl" />

    <p>
      ${statMessage}
    </p>
    <#if currentUser??>
      <ol>
        <#list lobby as player>
          <#if player.equals(currentUser) == false>
            <li>
              <form action = /game method="get">
                <input name = "opponent" type = submit value="${player.getName()}"/>
              </form>
            </li>
          </#if>
        </#list>
      </ol>
    </#if>


    <!-- TODO: future content on the Home:
            to start games,
            spectating active games,
            or replay archived games
    -->

  </div>

</div>
</body>

</html>
