/*
web04eliminarenfermos.jsp
Bean04EliminarEnfermos.java
Dibujar todos los enfermos al iniciar la página.
Una caja para escribir la inscripción.
Si pulsamos sobre un botón eliminar, borramos al enfermo..
 */
package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;

public class bean04EliminarEnfermos {
    //que funcionalidad de la dddd necesitamos?
    //dibujar enfermos(string)
    //eliminar enfermos (void)

    private Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        String cadena
                = "jdbc:oracle:thin:@LOCALHOST:1521:XE";
        Connection cn
                = DriverManager.getConnection(cadena, "system", "oracle");
        return cn;
    }

    //todos los metodos llamaran a throws por que getConnection tiene una excepcion
    public String getTablaEnfermo() throws SQLException {
        Connection cn = this.getConnection();
        Statement st = cn.createStatement();
        String sql = "select * from enfermo";
        ResultSet rs = st.executeQuery(sql);

        String html = "<table border='1'>";
        html += "<thead>";
        html += "<tr>";
        html += "<th>" + "Inscripcion" + "</th>";
        html += "<th>" + "Apellido" + "</th>";
        html += "<th>" + "direccion" + "</th>";
        html += "<th>" + "fecha NC" + "</th>";
        html += "<th>" + "SEXO" + "</th>";
        html += "<th>" + "NSS" + "</th>";
        html += "</tr>";
        html += "</thead>";
        while (rs.next()) {
            html += "<tbody>";
            html += "<tr>";
            html += "<td>" + rs.getString("inscripcion") + "</td>";
            html += "<td>" + rs.getString("apellido") + "</td>";
            html += "<td>" + rs.getString("direccion") + "</td>";
            html += "<td>" + rs.getString("fecha_nac") + "</td>";
            html += "<td>" + rs.getString("sexo") + "</td>";
            html += "<td>" + rs.getString("nss") + "</td>";
            html += "</tr>";
            html += "</tbody>";
        }

        html += "</table>";
        cn.close();
        rs.close();
        return html;
    }

    public void EliminarEnfermo(int eliminar) throws SQLException {
        Connection cn = this.getConnection();
        String sql = "delete from enfermo where inscripcion = ?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, eliminar);
        pst.executeUpdate();
        cn.close();
    }

}
