<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Welcome to the World Manager</title>
</head>
<body>
<%@ include file="header.jsp" %>
<table style="width: 100%">
    <tr>
        <td style="width: 25%; height: 80%" valign="top">
            <%@ include file="navbar.jsp" %>
        </td>
        <td style="width: 75%; height: 80%">
            <h1>Content goes here</h1>
        </td>
    </tr>
</table>
<!-- include using JSP standard action -->
<jsp:include page="footer.jsp"/>
<%-- Note: this comment does not render! --%>
</body>
</html>
