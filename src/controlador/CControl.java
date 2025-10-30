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

    public boolean editar(String nombres, String apellidos, String telefono, String direccion, String email) {
        conecta = con.conectar();
        boolean bandera = consulta.editar(conecta, nombres, apellidos, telefono, direccion, email);
        con.desconectar(conecta);
        return bandera;
    }

    public ArrayList<CContacto> listarporciudad(String direccion) {
        ArrayList<CContacto> listaciudad = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaciudad = consulta.listarporciudad(conecta, direccion);
            con.desconectar(conecta);
            return listaciudad;
        } else {
            return null;
        }
    }

    public ArrayList<CContacto> listarrangoid(int idInicioVal, int idFinVal) {
        ArrayList<CContacto> listaid = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaid = consulta.listarrangoid(conecta, idInicioVal, idFinVal);
            con.desconectar(conecta);
            return listaid;
        } else {
            return null;
        }
    }

    public ArrayList<CContacto> buscarpornombres(String nombres) {
        ArrayList<CContacto> listanombres = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listanombres = consulta.buscarpornombre(conecta, nombres);
            con.desconectar(conecta);
            return listanombres;
        } else {
            return null;
        }
    }

    public ArrayList<CContacto> buscarporapellidos(String apellidos) {
        ArrayList<CContacto> listaapellidos = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaapellidos = consulta.buscarporapellido(conecta, apellidos);
            con.desconectar(conecta);
            return listaapellidos;
        } else {
            return null;
        }
    }

    public ArrayList<CContacto> buscarporid(String id) {
        ArrayList<CContacto> listaid2 = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaid2 = consulta.buscarporid(conecta, id);
            con.desconectar(conecta);
            return listaid2;
        } else {
            return null;
        }
    }

    public ArrayList<CContacto> listarporCL() {
        ArrayList<CContacto> listaCL = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaCL = consulta.listarporcalle(conecta);
            con.desconectar(conecta);
            return listaCL;
        } else {
            return null;
        }
    }

    public ArrayList<CContacto> listarporCra() {
        ArrayList<CContacto> listaCra = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaCra = consulta.listarporcarrera(conecta);
            con.desconectar(conecta);
            return listaCra;
        } else {
            return null;
        }
    }

    public ArrayList<CContacto> listarporprefijo(String telefono) {
        ArrayList<CContacto> listaprefijo = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaprefijo = consulta.listarporprefijo(conecta, telefono);
            con.desconectar(conecta);
            return listaprefijo;
        } else {
            return null;
        }
    }

    public ArrayList<CContacto> listarporalfa() {
        ArrayList<CContacto> listaalfa = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaalfa = consulta.listarporalfa(conecta);
            con.desconectar(conecta);
            return listaalfa;
        } else {
            return null;
        }
    }
    
    
    public ArrayList<CContacto> listarporidpar() {
        ArrayList<CContacto> listaidpar = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaidpar = consulta.listarporidpar(conecta);
            con.desconectar(conecta);
            return listaidpar;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> listarporidimpar() {
        ArrayList<CContacto> listaidimpar = new ArrayList<>();
        conecta = con.conectar();
        if (conecta != null) {
            listaidimpar = consulta.listarporidimpar(conecta);
            con.desconectar(conecta);
            return listaidimpar;
        } else {
            return null;
        }
    }
    
    public ArrayList<CContacto> listarporuncampo (String seleccion){
        ArrayList<CContacto> listauncampo=new ArrayList<>();
        conecta=con.conectar();
        if(conecta != null){
            listauncampo=consulta.listaruncampo(conecta, seleccion);
            con.desconectar(conecta);
            return listauncampo;
        }else{
            return null;
        }
    }

}//fin de la clase
