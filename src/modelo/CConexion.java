/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

//descargar librerías de https://www.mysql.com/products/connector/
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author juanp
 */
public class CConexion {

    
    //---------CONEXION LOCAL-----------\\
    
    String usuario = "root";
    String contrasena = "";
    String url = "jdbc:mysql://localhost:3306/agenda";
    
    /*
    //----------CONEXION ONLINE-----------\\
     String usuario = "programacion";
    String contrasena = "#3Programacion3";
    String url = "jdbc:mysql://72.167.84.254/agenda";
*/

    public Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("conexion correcta");
            return con;
        } catch (Exception e) {
            System.out.println("conexion incorrecta");
            return null;
        }
    }//fin metodo conectar

    public void desconectar(Connection con) {
        try {
            con.close();
            System.out.println("se cerró la conexión");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//fin del metodo desconectar
}//fin de la clase
