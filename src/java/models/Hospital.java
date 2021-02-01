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
package models;

public class Hospital {

    private int hospitalcod;
    private String nombre;
    private String direccion;
    private String telefono;
    private int camas;

    public Hospital() {

    }

    public Hospital(int id, String nombre, String dir,
            String tlf, int camas) {
        this.hospitalcod = id;
        this.nombre = nombre;
        this.direccion = dir;
        this.telefono = tlf;
        this.camas = camas;
    }

//<editor-fold defaultstate="collapsed" desc="getter and setter">
    public int getHospitalcod() {
        return hospitalcod;
    }

    public void setHospitalcod(int hospitalcod) {
        this.hospitalcod = hospitalcod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

//</editor-fold>
}
