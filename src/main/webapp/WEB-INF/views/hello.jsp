<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title>Hello :: Spring Application</title></head>
  <body>
    <h1>Hello - Spring Application</h1>
    <p>Greetings, it is now <c:out value="${now}"/></p>
    <a href="/listado.htm">Ir al listado</a>
  </body>
</html>