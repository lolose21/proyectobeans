<%-- 
 Bean07EmpleadosDepartamentoUpdate
web07EmpleadosDepartamentoUpdate
Recuperar de cada Bean (anterior) un dibujo.
En el nuevo Bean, creamos un método para incrementar el salario de los empleados por un número de departamento.
Queremos dibujar un desplegable con los departamentos.
Una caja para el incremento.
Al pulsar el botón, vemos los empleados del departamento con su incremento.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean07"
             class="beans.bean07EmpleadosDepartamentoUpdate"
             scope="request"/>
<jsp:useBean id="bean05"
             class="beans.bean05EmpleadosDepartamento"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Incremento Departamento</h1>
        <form method="post">
            <label> Incremento</label> 
            <select name="selectdepartamento">
            <%=bean05.MostrarDept()%>
            </select>
            <input type="number" name="cajaincremento" />
            
            <button type="submit">
                ENTER
            </button>
            
        </form>
        <%
          
        String dato = request.getParameter("selectdepartamento");
        
        if (dato !=null){
        int deptno = Integer.parseInt(dato);
        String datoincremento =request.getParameter("cajaincremento");
        int incremento = Integer.parseInt(datoincremento);
        bean07.updateSalarios(deptno , incremento);
       %>
        <table border="1" class="azul">
                <thead>
                    <tr>
                        <th>APELLIDO</th>
                        <th>OFICIO</th>
                        <th>SALARIO</th>
                    </tr>
                </thead>
                <tbody>
                    <%=bean05.getEmpleadosTabla(deptno)%>
                </tbody>
            </table>
        <%
        }
      
        %>
        
    
  
    </body>
</html>
