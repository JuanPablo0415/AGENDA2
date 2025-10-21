/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author juanp
 */
public class CConsultas {

    //de la librería sql usamos como atributo un objeto de tipo conexión, que es necesario para ejecutar las consultas
    Connection con;
    String query;

    public CConsultas() {

    }

    //para ejecutar el método recibimos por parámetro una conexión activa
    public boolean ingresar(Connection con, String nombres, String apellidos, String telefono, String direccion, String email) {
        this.con = con;
        query = "INSERT INTO datos(id,nombres,apellidos,telefono,direccion,email) VALUES (null,'" + nombres + "','" + apellidos + "','" + telefono + "','" + direccion + "','" + email + "');";
        try {
            //preparo la consulta
            PreparedStatement preparar = con.prepareStatement(query);
            //ejecuto la consulta luego de prepararla
            preparar.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return false;
        }
    }//fin metodo ingresar

    //para ejecutar el método recibimos por parámetro una conexión activa
    public ArrayList<CContacto> consultar(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos";
        ArrayList<CContacto> lista = new ArrayList<>();
        try {
            //preparo la consulta
            PreparedStatement preparar = con.prepareStatement(query);
            //ejecuto la consulta luego de prepararla
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono"),
                        resultado.getString("email")
                );
                lista.add(c);
            }
            System.out.println("Consulta correcta");
            return lista;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }//fin del metodo consultar

    public boolean borrar(Connection con, String telefono) {
        this.con = con;
        String query = "DELETE FROM datos WHERE telefono = '" + telefono + "';";
        try {
            //preparo la consulta
            PreparedStatement preparar = con.prepareStatement(query);
            //ejecuto la consulta luego de prepararla
            int v = preparar.executeUpdate();
            if (v > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return false;
        }
    }//fin de la funcion borrar

    public boolean editar(Connection con, String nombres, String apellidos, String telefono, String direccion, String email) {
        this.con = con;
        String query = "UPDATE datos SET nombres='" + nombres
                + "', apellidos='" + apellidos
                + "', telefono='" + telefono
                + "', direccion='" + direccion
                + "' WHERE email='" + email + "';";
        try {
            //preparo la consulta
            PreparedStatement preparar = con.prepareStatement(query);
            //ejecuto la consulta luego de prepararla
            int v = preparar.executeUpdate();
            if (v > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return false;
        }

    }//fin de la funcion editar

    public ArrayList<CContacto> listarporciudad(Connection con, String direccion) {
        this.con = con;
        String query = "SELECT * FROM datos WHERE direccion LIKE '%" + direccion + "%'";
        ArrayList<CContacto> listaciudad = new ArrayList<>();
        try {

            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono"),
                        resultado.getString("email")
                );
                listaciudad.add(c);

            }
            System.out.println("Consulta correcta");
            return listaciudad;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }

    }//fin de la funcion listar por ciudad

    public ArrayList<CContacto> listarrangoid(Connection con, int idInicioVal, int idFinVal) {
        this.con = con;
        String query = "SELECT * FROM datos WHERE id BETWEEN " + idInicioVal + " AND " + idFinVal;
        ArrayList<CContacto> listaid = new ArrayList<>();

        try {

            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono"),
                        resultado.getString("email")
                );
                listaid.add(c);

            }
            System.out.println("Consulta correcta");
            return listaid;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }

    }//fin de la funcion listar rango id

    
    public ArrayList<CContacto> buscarpornombre (Connection con, String nombres){
        this.con=con;
        String query= "SELECT *  FROM datos WHERE  nombres LIKE '" + nombres + "%';";
        ArrayList<CContacto> listanombres = new ArrayList<>();

        try {

            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono"),
                        resultado.getString("email")
                );
                listanombres.add(c);

            }
            System.out.println("Consulta correcta");
            return listanombres;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }// fin de la funcion listar por nombres
    
    
       public ArrayList<CContacto> buscarporapellido (Connection con, String apellidos){
        this.con=con;
        String query= "SELECT *  FROM datos WHERE  apellidos LIKE '" + apellidos + "%';";
        ArrayList<CContacto> listaapellidos = new ArrayList<>();

        try {

            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            while (resultado.next()) {
                CContacto c = new CContacto(
                        resultado.getInt("id"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("direccion"),
                        resultado.getString("telefono"),
                        resultado.getString("email")
                );
                listaapellidos.add(c);

            }
            System.out.println("Consulta correcta");
            return listaapellidos;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }// fin de la funcion listar por apellido
    
}//fin de la clase
