<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title><fmt:message key="title"/></title>
    <style>
        .error { color: red; }
    </style>
    <script src="js/jquery-3.1.1.min.js" type="application/javascript" rel="script"></script>
</head>
<body>
<a href="<c:url value="hello.htm"/>">Home</a><br/>
<a href="<c:url value="listado.htm"/>">Volver al Listado</a><br/>

<h1><fmt:message key="showproduct.heading"/> ${product.id}</h1>
<form:form method="post"
           commandName="product">
    <table >
        <tr>
            <td align="right"
                width="20%">Description:</td>
            <td width="20%">
                <form:input path="description" disabled="true"/>
            </td>
            <td width="60%">
                <form:errors path="description" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td align="right"
                width="20%">Price:</td>
            <td width="20%">
                <form:input path="price" disabled="true"/>
            </td>
            <td width="60%">
                <form:errors path="price" cssClass="error"/>
            </td>
        </tr>
    </table>
    <br>
    <!--input id="submit" type="submit" disabled="disabled" value="Save"-->
</form:form>
<script type="application/javascript">
    $(document).ready(function(){
        //$("#submit").removeAttr("disabled");
    });

</script>
</body>
</html>