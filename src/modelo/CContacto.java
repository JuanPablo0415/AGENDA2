/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juanp
 */
public class CContacto {

    int id;
    String nombres;
    String apellidos;
    String telefono;
    String direccion;
    String email;

    public CContacto() {

    }//fin constructor lleno

    public CContacto(int id, String nombres, String apellidos, String telefono, String direccion, String email) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }//fin constructor lleno

    //--------METODOS GET----------\\
    
    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    
    
}//fin de la clase
