/*
Model: Hospital
Repo: RepositoryHospital
Controller: ControllerHospital
HOSPITAL
Mostrar una tabla de Hospitales utilizando el patrón MVC
    Modelos
    Controladores
    Vistas
    Repositorios.
 */
package controllers;

//<editor-fold defaultstate="collapsed" desc="import">
import java.sql.SQLException;
import java.util.ArrayList;
import models.Hospital;
import repositories.Repository02Hospital;
//</editor-fold>

public class Controller02Hospital {

    Repository02Hospital repo;

    public Controller02Hospital() {
        this.repo = new Repository02Hospital();
    }

    public String getTablaHospital() throws SQLException {
//<editor-fold defaultstate="collapsed" desc="getTablaHospital()">

        ArrayList<Hospital> lista = repo.getHospital();
        String html = "";
        for (Hospital H : lista) {
            html += "<tr>";

            html += "<td>" + H.getNombre() + "</td>";
            html += "<td>" + H.getDireccion() + "</td>";
            html += "<td>" + H.getTelefono() + "</td>";
            html += "<td>" + H.getCamas() + "</td>";
            html += "</tr>";
        }
        return html;
    }
//</editor-fold>

    public String getTablaEliminarHospital() throws SQLException {
//<editor-fold defaultstate="collapsed" desc="getTablaEliminarHospital">
        ArrayList<Hospital> hospital = this.repo.getHospital();
        String html = "";
        for (Hospital hospi : hospital) {
            html += "<tr>";

            html += "<td>" + hospi.getHospitalcod() + "</td>";
            html += "<td>" + hospi.getNombre() + "</td>";
            html += "<td>" + hospi.getDireccion() + "</td>";
            html += "<td>" + hospi.getTelefono() + "</td>";
            html += "<td>" + hospi.getCamas() + "</td>";
            html += "<td>";
            html += "<button type='submit' name='eliminar' value'" + hospi.getHospitalcod()
                    + "'> Eliminar </button >";
            html += "</td>";

            html += "</<tr>";
        }
        return html;
    }
//</editor-fold>

    public String getFormularioHospital(int hospitalcod) throws SQLException {
        //<editor-fold defaultstate="collapsed" desc="getFormularioHospital">
        Hospital hospi = this.repo.buscarhospital(hospitalcod);
        String html = "<label> Hospital </label>"
                + "<input type='number' name='cajanumero' value='"
                + hospi.getHospitalcod() + "' readonly/><br/>";
        html += "<label>Nombre</label>"
                + "<input type='text' name='cajanombre' value='"
                + hospi.getNombre() + "' requiered/><br/>";
        html += "<label>Direccion</label> "
                + "<input type='text' name='cajadireccion' value='"
                + hospi.getDireccion() + "' requierd/><br/>";
        html += "<label>Telefono</label>"
                + "<input type='text' name='cajatelefono' value='"
                + hospi.getTelefono() + "' requiered/><br/>";
        html += "<label>Camas</label>"
                + "<input type='number' name='cajacama' value='"
                + hospi.getCamas() + "' requied/><br/>";
        return html;
    }
//</editor-fold>

    public void InsertarHospital(String nombre, String direc, String tel,
            int cama) throws SQLException {
        this.repo.InsertarHospital(nombre, direc, tel, cama);
    }

}
