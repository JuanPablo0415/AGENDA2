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

    public ArrayList<CContacto> buscarpornombre(Connection con, String nombres) {
        this.con = con;
        String query = "SELECT *  FROM datos WHERE  nombres LIKE '" + nombres + "%';";
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

    public ArrayList<CContacto> buscarporapellido(Connection con, String apellidos) {
        this.con = con;
        String query = "SELECT *  FROM datos WHERE  apellidos LIKE '" + apellidos + "%';";
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

    public ArrayList<CContacto> buscarporid(Connection con, String id) {
        this.con = con;
        String query = "SELECT * FROM DATOS WHERE id LIKE'" + id + "';";
        ArrayList<CContacto> listaid1 = new ArrayList<>();

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
                listaid1.add(c);

            }
            System.out.println("Consulta correcta");
            return listaid1;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }//fin de la funcion buscar por id

    public ArrayList<CContacto> listarporcalle(Connection con) {
        this.con = con;
        query = "SELECT * FROM DATOS WHERE direccion LIKE 'CL%';";
        ArrayList<CContacto> listaCL = new ArrayList<>();

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
                listaCL.add(c);

            }
            System.out.println("Consulta correcta");
            return listaCL;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }//fin de la funcion listar por calle

    public ArrayList<CContacto> listarporcarrera(Connection con) {
        this.con = con;
        query = "SELECT * FROM DATOS WHERE direccion LIKE 'Cra%';";
        ArrayList<CContacto> listaCra = new ArrayList<>();

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
                listaCra.add(c);

            }
            System.out.println("Consulta correcta");
            return listaCra;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }//fin de la funcion listar por carerra

    public ArrayList<CContacto> listarporprefijo(Connection con, String telefono) {
        this.con = con;
        query = "SELECT * FROM datos WHERE telefono LIKE '" + telefono + "%';";
        ArrayList<CContacto> listaprefijo = new ArrayList<>();

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
                listaprefijo.add(c);

            }
            System.out.println("Consulta correcta");
            return listaprefijo;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }//fin de la funcion listar por prefijo

    public ArrayList<CContacto> listarporalfa(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos ORDER BY nombres;";
        ArrayList<CContacto> listaalfa = new ArrayList<>();

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
                listaalfa.add(c);

            }
            System.out.println("Consulta correcta");
            return listaalfa;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }//fin de la funcion listar por por orden alfabetico

    public ArrayList<CContacto> listarporidpar(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos WHERE id %2=0";
        ArrayList<CContacto> listaidpar = new ArrayList<>();

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
                listaidpar.add(c);

            }
            System.out.println("Consulta correcta");
            return listaidpar;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }//fin de la funcion listar por id par

    public ArrayList<CContacto> listarporidimpar(Connection con) {
        this.con = con;
        query = "SELECT * FROM datos WHERE id %2!=0";
        ArrayList<CContacto> listaidimpar = new ArrayList<>();

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
                listaidimpar.add(c);

            }
            System.out.println("Consulta correcta");
            return listaidimpar;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }//fin de la funcion listar por por id impar

    public ArrayList<CContacto> listaruncampo(Connection con, String seleccion) {
        this.con = con;
        query = "SELECT " + seleccion + " FROM datos;";
        ArrayList<CContacto> listauncampo = new ArrayList<>();
        boolean bandera = false;

        try {

            PreparedStatement preparar = con.prepareStatement(query);
            ResultSet resultado = preparar.executeQuery();

            if (seleccion.equals("id")) {
                bandera = true;
                while (resultado.next()) {
                    CContacto c = new CContacto(
                            resultado.getInt("id"),
                            "",
                            "",
                            "",
                            "",
                            ""
                    );
                    listauncampo.add(c);
                }
            }
            if (seleccion.equals("nombres")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(
                            (0),
                            resultado.getString("nombres"),
                            (""),
                            (""),
                            (""),
                            ("")
                    );
                    listauncampo.add(c);
                }
            }
            if (seleccion.equals("apellidos")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(
                            (0),
                            (""),
                            resultado.getString("apellidos"),
                            (""),
                            (""),
                            ("")
                    );
                    listauncampo.add(c);
                }
            }
            if (seleccion.equals("telefono")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(
                            (0),
                            (""),
                            (""),
                            resultado.getString("telefono"),
                            (""),
                            ("")
                    );
                    listauncampo.add(c);
                }
            }
            if (seleccion.equals("direccion")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(
                            (0),
                            (""),
                            (""),
                            (""),
                            resultado.getString("direccion"),
                            ("")
                    );
                    listauncampo.add(c);
                }
            }
            if (seleccion.equals("email")) {
                while (resultado.next()) {
                    CContacto c = new CContacto(
                            (0),
                            (""),
                            (""),
                            (""),
                            (""),
                            resultado.getString("email")
                    );
                    listauncampo.add(c);
                }
            }

            System.out.println("Consulta correcta");
            return listauncampo;

        } catch (SQLException ex) {
            System.out.println("Error en el sql");
            return null;
        }
    }//fin de la funcion listar por por id impar

}//fin de la clase
