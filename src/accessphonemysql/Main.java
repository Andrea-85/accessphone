/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accessphonemysql;

import accessphonemysql.controller.AccesorioController;
import accessphonemysql.model.Accesorio;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del accesorio:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese la descripción:");
        String descripcion = sc.nextLine();

        System.out.println("Ingrese el precio:");
        double precio = sc.nextDouble();
        sc.nextLine(); // Limpiar el buffer

        // Crear el objeto Accesorio con los datos
        Accesorio nuevoAccesorio = new Accesorio(0, nombre, descripcion, precio);

        // Crear el controlador
        AccesorioController controlador = new AccesorioController();

        // Llamar al método para insertar
        controlador.insertarAccesorio(nuevoAccesorio);

        // Llamada al método de consulta
        controlador.consultarAccesorios();
        
        System.out.println("¿Desea actualizar un accesorio existente? (s/n)");
String respuesta = sc.nextLine();

if (respuesta.equalsIgnoreCase("s")) {
    System.out.println("Ingrese el ID del accesorio a actualizar:");
    int id = sc.nextInt();
    sc.nextLine();

    System.out.println("Ingrese el nuevo nombre:");
    String nuevoNombre = sc.nextLine();

    System.out.println("Ingrese la nueva descripción:");
    String nuevaDescripcion = sc.nextLine();

    System.out.println("Ingrese el nuevo precio:");
    double nuevoPrecio = sc.nextDouble();
    sc.nextLine();

    Accesorio actualizado = new Accesorio(id, nuevoNombre, nuevaDescripcion, nuevoPrecio);
    controlador.actualizarAccesorio(actualizado);
}
    
    System.out.println("¿Desea eliminar un accesorio existente? (s/n)");
String eliminar = sc.nextLine();

if (eliminar.equalsIgnoreCase("s")) {
    System.out.println("Ingrese el ID del accesorio a eliminar:");
    int idEliminar = sc.nextInt();
    sc.nextLine();

    controlador.eliminarAccesorio(idEliminar);
    }
}
}
