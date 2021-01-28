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

}
