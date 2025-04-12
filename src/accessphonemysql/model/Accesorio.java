/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accessphonemysql.model;
import accessphonemysql.model.Accesorio;
/**
 *
 * @author usuario
 */

public class Accesorio {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;

    public Accesorio(int id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public Accesorio(String nombre, String descripcion, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Métodos getter y setter
    public int getId() { return id;}
    public void setId(int id) { this.id = id;}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() {return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio;  }
    public void setPrecio(double precio) { this.precio = precio;  }
}
