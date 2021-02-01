/*

create or replace procedure insertarhospital
(p_nombre hospital.nombre%type
, p_direccion hospital.direccion%type
, p_telefono hospital.telefono%type
, p_camas hospital.num_cama%type
)
as
v_maximo hospital.hospital_cod%type;
begin
  select max(hospital_cod) + 1 into v_maximo
  from hospital;
  insert into hospital values (v_maximo, p_nombre
  , p_direccion , p_telefono , p_camas);
  commit;
  end;
 */
package repositories;
//<editor-fold defaultstate="collapsed" desc="import">

import java.sql.CallableStatement;
import models.Hospital;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;
//</editor-fold>

public class Repository02Hospital {

    private Connection getConnection() throws SQLException {
        //<editor-fold defaultstate="collapsed" desc="connectionDRIVER">
        DriverManager.registerDriver(new OracleDriver());
        String cadena = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        Connection cn
                = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }
//</editor-fold>
//necesitamos un array para que el  controller  dibuje parametros

    public ArrayList<Hospital> getHospital() throws SQLException {
        ArrayList<Hospital> lista = new ArrayList<>();
        Connection cn = this.getConnection();
        //realizamos consulta para meter los datos en el array
        String sql = "select * from hospital";
        //no tiene parametros Statement
        Statement st = cn.createStatement();
        //recuperamos la consulta
        ResultSet rs = st.executeQuery(sql);
        //hacemos un wile para recorrer los datos
        while (rs.next()) {
            Hospital hospital = new Hospital();
            int hospitalcod = rs.getInt("hospital_cod");
            String nombre = rs.getString("nombre");
            String direccion = rs.getString("direccion");
            String telefono = rs.getString("telefono");
            int camas = rs.getInt("num_cama");
            hospital.setHospitalcod(hospitalcod);
            hospital.setNombre(nombre);
            hospital.setDireccion(direccion);
            hospital.setTelefono(telefono);
            hospital.setCamas(camas);
            lista.add(hospital);
        }
        rs.close();
        cn.close();
        return lista;
    }
//<editor-fold defaultstate="collapsed" desc="buscarhospital">

    public Hospital buscarhospital(int hospitalcod) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from hospital where hospital_cod =?";
        //tenemos parametros usaremos PreparedStatement y recuperamos la consulta
        PreparedStatement pst = cn.prepareStatement(sql);

        pst.setInt(1, hospitalcod);
        ResultSet rs = pst.executeQuery();
        rs.next();
        int numero = rs.getInt("hospital_cod");
        String nombre = rs.getString("NOMBRE");
        String dir = rs.getString("direccion");
        String tel = rs.getString("telefono");
        int cama = rs.getInt("num_cama");
        Hospital hospital = new Hospital();
        hospital.setHospitalcod(hospitalcod);
        hospital.setNombre(nombre);
        hospital.setDireccion(dir);
        hospital.setTelefono(tel);
        hospital.setCamas(cama);
        cn.close();
        rs.close();
        return hospital;
    }
//</editor-fold>

    public void EliminarHospital(int hospitalcod) throws SQLException {
        //<editor-fold defaultstate="collapsed" desc="eliminar Hospital">
        Connection cn = this.getConnection();
        String sql = " delete hospital where hospital_cod = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, hospitalcod);
        pst.executeUpdate();
        cn.close();
    }

//</editor-fold>
    public void InsertarHospital(String nombre, String direc, String tel,
            int cama) throws SQLException {
        //<editor-fold defaultstate="collapsed" desc="InsertarHospital">
        Connection cn = this.getConnection();
        String sql = "{ call insertarhospital(?,?,?,?) }";
        CallableStatement cst = cn.prepareCall(sql);

        cst.setString(1, nombre);
        cst.setString(2, direc);
        cst.setString(3, tel);
        cst.setInt(4, cama);
        cst.executeUpdate();
        cn.close();
    }
//</editor-fold>

    private int getMaxIdHospital() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select max(hospital_cod) + 1 as MAXIMO from hospital";
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        int maximo = rs.getInt("MAXIMO");
        rs.close();;
        cn.close();
        return maximo;
    }

}
