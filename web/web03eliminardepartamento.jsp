<%-- 
   1) Mostramos una tabla con los departamentos.
2) Tendremos una caja para escribir el número y eliminar el departamento.
Para dibujar los detalles de un departamento, que nos tiene que devolver el Repository? Departamento
Para dibujar la tabla, que nos tiene que devolver el Repository???  ArrayList
Para eliminar un departamento, que nos tiene que devolver el Repository? NADA  void
--%>

<%@page import="org.apache.catalina.startup.ClassLoaderFactory.Repository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beaneliminar"
             class="controllers.Controller01Departamentos"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminar Departamento</h1>
        <form method="post>">
            <label>NUMERO</label>
            <input type="number" name="cajaeliminar" id="cajaeliminar"
                   class="alert-danger"/>
            <button type="submit">
                ELIMINAR
            </button>
        </form>
         <%
       String dato = request.getParameter("cajaeliminar");
       if(dato != null){
       int eliminar = Integer.parseInt(dato);
      
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
               
            </tbody>
        </table>
      
       }
       
      
        
    </body>
</html>
