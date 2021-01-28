/*
Bean05EmpleadosDepartamento
Web05EmpleadosDepartamento
Al iniciar la página, dibujamos un desplegable <select> con los departamentos.
Cuando seleccionemos un departamento, mostramos sus empleados.
select * from emp where dept_no = 30;
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

public class bean05EmpleadosDepartamento {

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena
                = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        Connection cn
                = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    public String MostrarDept() throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from dept";
        Statement ps = cn.createStatement();
        ResultSet rs = ps.executeQuery(sql);

        String html = "";
        while (rs.next()) {
            String numero = rs.getString("dept_no");
            String nombre = rs.getString("DNOMBRE");
            html += "<option value='" + numero + "'>" + nombre + "</option>";

        }

        cn.close();
        rs.close();
        return html;
    }

    public String getEmpleadosTabla(int iddepartamento) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "select * from emp where dept_no =?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, iddepartamento);
        ResultSet rs = pst.executeQuery();
        String html = "";
        while (rs.next()) {
            String apellido = rs.getString("APELLIDO");
            String oficio = rs.getString("OFICIO");
            String salario = rs.getString("SALARIO");
            html += "<tr>";
            html += "<td>" + apellido + "</td>";
            html += "<td>" + oficio + "</td>";
            html += "<td>" + salario + "</td>";
            html += "</tr>";
        }
        rs.close();
        cn.close();
        return html;
    }
}
