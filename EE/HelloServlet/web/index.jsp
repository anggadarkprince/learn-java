<%--
  Created by IntelliJ IDEA.
  User: angga
  Date: 04/12/16
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="hello">
    <button type="submit">SUBMIT</button>
  </form>
  <p>To invoke the java servlet click <a href="helloworld">here</a></p>
  <p>To invoke hidden route <a href="/hiddenservlets/helloworld.do">here</a></p>
  <p>Simple redirection <a href="StartServlet">here</a></p>
  <p>Simple container redirection (dispatch) <a href="StartServlet2">here</a></p>
  </body>
</html>
