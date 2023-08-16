/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author rodri
 */
public class Contacto {
    
    
      private String nombre;
    private String dni;
    private long telefono;
    private char tipo;

    public Contacto() {
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
    }

    
    public Contacto(long telefono) {
        this.telefono = telefono;
    }

    public Contacto(char tipo) {
        this.tipo = tipo;
    }

    
    
    
    
    
    
    public Contacto(String nombre, String dni, long telefono, char tipo) {
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono + ", tipo=" + tipo + '}';
    }
    
    
    
    
    
    
    
    
}
