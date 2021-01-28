<%-- 
  Bean05EmpleadosDepartamento
Web05EmpleadosDepartamento
Al iniciar la página, dibujamos un desplegable <select> con los departamentos.
Cuando seleccionemos un departamento, mostramos sus empleados.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="beandept"
             class="beans.bean05EmpleadosDepartamento"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dept</title>
    </head>
    <body>
        <h1>Departamentos </h1>
        <form method="post">
            <label>SELECT</label>
            <select name="dept">
                 <%= beandept.MostrarDept()%>
            </select>
            
           
            <button type="submit" >
                Enter
            </button>
            
        </form>
        <%
         String dato = request.getParameter("dept");
         if(dato != null){
         int iddepartamento = Integer.parseInt(dato);
         %>
         <table border="1">
             <thead>
                 <tr>
                     <th>Apellido</th>
                     <th>Oficio</th>
                     <th>Salario</th>
                 </tr>
             </thead>
         
    <tbody>
         <%=beandept.getEmpleadosTabla(iddepartamento)%>
    </tbody>
         </table>
        <%
         }
        %>

    </body>
</html>
