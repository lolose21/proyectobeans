
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beantablaempleados" 
             class="beans.bean03TablaEmpleados"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/fondo02.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         
        <h1>Tabla Empleados</h1>
        <form method="post">
            <label>Incremento Salarial</label>
            <input type="number" name="cajaincremento" required/>
            <button type="submit">
                Incremento salarios
            </button>
        </form>
        <%
        String dato = request.getParameter("cajaincremento");
        if(dato != null){
        int incremento = Integer.parseInt(dato);
        //para incrementar , tenemos que pintar algo+//al llamar al metodo??
        beantablaempleados.incrementarSalarios(incremento);
        }
        %>
        <%=beantablaempleados.getTablaEmpleados()%>
    </body>
</html>
