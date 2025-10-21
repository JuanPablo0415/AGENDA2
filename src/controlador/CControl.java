/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.util.ArrayList;
import vista.*;
import modelo.*;

/**
 *
 * @author juanp
 */
public class CControl {

    CConexion con = new CConexion();
    Connection conecta;
    CConsultas consulta = new CConsultas();

    public CControl() {

    }

    public boolean insertar(String nombres, String apellidos, String direccion, String telefono, String email) {
        conecta = con.conectar();
        boolean bandera = consulta.ingresar(conecta, nombres, apellidos, direccion, telefono, email);
        con.desconectar(conecta);
        return bandera;
    }

    public ArrayList<CContacto> consultar() {
        ArrayList<CContacto> lista = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            lista = consulta.consultar(conecta);
            con.desconectar(conecta);
            return lista;
        } else {
            return null;
        }
    }

    public boolean borrar(String telefono) {
        conecta = con.conectar();
        boolean bandera = consulta.borrar(conecta, telefono);
        con.desconectar(conecta);
        return bandera;
    }
    
    public boolean editar(String nombres, String apellidos, String telefono, String direccion, String email){
        conecta= con.conectar();
        boolean bandera = consulta.editar(conecta, nombres, apellidos, telefono, direccion, email);
        con.desconectar(conecta);
        return bandera;
    }
    
     public ArrayList<CContacto> listarporciudad(String direccion) {
        ArrayList<CContacto> listaciudad = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaciudad = consulta.listarporciudad(conecta,direccion);
            con.desconectar(conecta);
            return listaciudad;
        } else {
            return null;
        }
    }
   
}//fin de la clase
