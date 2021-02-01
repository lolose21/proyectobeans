<%-- 
  Model: Hospital
Repo: RepositoryHospital
Controller: ControllerHospital
HOSPITAL
Mostrar una tabla de Hospitales utilizando el patrón MVC
    Modelos
    Controladores
    Vistas
    Repositorios.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="TablaHospital"
             class="controllers.Controller02Hospital"
             scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="css/fondo02.css" rel="stylesheet" type="text/css"/>
    
    <body>
        <h1>Tabla Hospital</h1>
        <form method="post">
            <label>Tabla</label>
            <button type="submit" class="picture w3-circle w3-button " style="color: red">
            <img src="imagen/gato.jpg" alt=""
                 width="20px" height="20px"/>
            Mostrar
        </button>
        </form> 
        <table border="1">
            <thead style="color: green">
                <tr>
                    
                    <th>NOMBRE</th>
                    <th>DIRECCION</th>
                    <th>TELEFONO</th>
                    <th>CAMAS</th>
                </tr>
            </thead>
            <tbody >
                <%=TablaHospital.getTablaHospital()%>
            </tbody>
        </table>
    </body>
</html>
