package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Departamento;
import repositories.Repository01Departamentos;

public class Controller01Departamentos {

    Repository01Departamentos repo;

    public Controller01Departamentos() {
        this.repo = new Repository01Departamentos();
    }

//estas clases son para los bibujos
    //dibujo para los depertamentos
    public String getTablaDepartamentos() throws SQLException {
        ArrayList<Departamento> lista = repo.getDepartamentos();
        //ahora mismo , nos inventamos los datos
        //de donde saco los datos para dibujar
        //los datos son varios departamentos

        //Nos centramos en el bibujo , una tabla
        String html = "";
        for (Departamento d : lista) {
            html += "<tr>";
            html += "<td>" + d.getNumero() + "</td>";
            html += "<td>" + d.getNombre() + "</td>";
            html += "<td>" + d.getLocalidad() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getSelectDepartamentos() throws SQLException {
        ArrayList<Departamento> lista = repo.getDepartamentos();
        String html = "";
        for (Departamento d : lista) {

            html += "<option value='" + d.getNumero() + "'>";
            html += d.getNombre() + "</option>";
        }
        return html;
    }

    public String getDetallesDepartamento(int deptno) throws SQLException {
        Departamento dept = repo.buscarDepartamento(deptno);
        String html = "<h1>Numero: " + dept.getNumero() + "</h1>";
        html += "<h1> Nombre:" + dept.getNombre() + "</h1>";
        html += "<h1> localidad " + dept.getLocalidad() + "</h1>";
        return html;
    }

    public void EliminarDepartamento(int deptno) throws SQLException {
        this.repo.EliminarDepartamento(deptno);
    }

    public void InsertarDepartamento(int deptno, String nombre, String localidad)
            throws SQLException {
        this.repo.InsertarDepartamento(deptno, nombre, localidad);
    }

    public void ModificarDepartamento(int deptno, String nombre, String localidad)
            throws SQLException {
        this.repo.ModificarDepartamento(deptno, nombre, localidad);

    }

    public String getFormularioDepartamentos(int deptno) throws SQLException {
        Departamento dept = this.repo.buscarDepartamento(deptno);
        String html = "<label>Número: </label>"
                + "<input type='number' name='cajanumero' value='"
                + dept.getNumero() + "' readonly/><br/>";
        html += "<label>Nombre</label>"
                + "<input type='text' name='cajanombre' value='"
                + dept.getNombre() + "' required/><br/>";
        html += "<label>Localidad</label>"
                + "<input type='text' name='cajalocalidad' value='"
                + dept.getLocalidad() + "' required/>";
        return html;
    }

    public String getTablaEdicionDepartamentos() throws SQLException {
        ArrayList<Departamento> departamentos = this.repo.getDepartamentos();
        String html = "";
        for (Departamento dept : departamentos) {
            html += "<tr>";
            html += "<td>" + dept.getNumero() + "</td>";
            html += "<td>" + dept.getNombre() + "</td>";
            html += "<td>" + dept.getLocalidad() + "</td>";
            html += "<td>";
            html += "<button type='button'> editar</button>";
            html += "</td>";
            html += "</tr>";
        }
        return html;
    }
}
