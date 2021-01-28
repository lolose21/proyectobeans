<%-- 
webcontroller05modificardepartamento
Versiones
1) Tabla departamentos y cajas para modificar un nuevo departamento.
2) Desplegable para modificar los departamentos.
Cuando pulsemos sobre el botón "Mostrar detalles", mostramos un formulario con los datos del departamento y un botón para modificar.
Cuando pulsemos en modificar.
Mostramos la tabla departamentos todo el tiempo.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerinsertar"
             class="controllers.Controller01Departamentos"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/fondo02.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar</h1>
        <form method="post">
          
            <label>deptno</label>
                <input type="number" id="cajanumero" name="cajanumero"/><br/>
            <label>Nombre</label>
                <input type="text" id="cajanombre" name="cajanombre"/><br/>
            <label>localidad</label>
                <input type="text" id="cajalocalidad" name="cajalocalidad"/><br/>
       
            <button type="submit">
                <span class="navbar-toggler-icon"></span>
                    <svg  width="16" height="16" fill="currentColor" class="bi bi-github" viewBox="0 0 16 16">
                    <path d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z"/>
                </svg> 
                MODIFICAR
            </button>
        </form>
        <%
        String dato = request.getParameter("cajanumero");
        if (dato != null){
         int deptno = Integer.parseInt(dato);
         String nombre = request.getParameter("cajanombre");
         String localidad = request.getParameter("cajalocalidad");
         controllerinsertar.ModificarDepartamento(deptno, nombre, localidad);
         }
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Numero</th>
                    <th>Nombre</th>
                    <th>Localidad</th>
                </tr>
            </thead>
            <tbody>
                <%=controllerinsertar.getTablaDepartamentos()%>
            </tbody>
        </table>
             
    </body>
</html>
