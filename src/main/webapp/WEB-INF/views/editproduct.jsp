<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title><fmt:message key="title"/></title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
<h1><fmt:message key="addproduct.heading"/></h1>
<form:form method="post"
           commandName="product">
    <table >
        <tr>
            <td align="right"
                width="20%">Id:</td>
            <td width="20%">
                <form:input path="id" disabled="true"/>
            </td>
            <td width="60%">
                <form:errors path="id" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td align="right"
                width="20%">Description:</td>
            <td width="20%">
                <form:input path="description"/>
            </td>
            <td width="60%">
                <form:errors path="description" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td align="right"
                width="20%">Price:</td>
            <td width="20%">
                <form:input path="price"/>
            </td>
            <td width="60%">
                <form:errors path="price" cssClass="error"/>
            </td>
        </tr>
    </table>
    <br>
    <input type="submit" value="Save">
</form:form>
<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>