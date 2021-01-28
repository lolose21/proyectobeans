

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beantabla"
             class="beans.Bean02TablaMultiplicar"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tabla Multiplicar</h1>
        <form method="post">
            <label>Introduzca un numero</label>
            <input type="number" name="cajanumero"/>
            <button type="submit">
                Mostrar Tabla
            </button>
        </form>
        <%
        String dato = request.getParameter("cajanumero");
        if(dato != null){
        int numero = Integer.parseInt(dato);
        %>
        <%=beantabla.getTablaMultiplicar(numero)%>
        <% 
        }
        %>
    </body>
</html>
