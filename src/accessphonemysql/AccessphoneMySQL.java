/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package accessphonemysql;

/**
 *
 * @author usuario
 */
public class AccessphoneMySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        dbConnection dbc=new dbConnection();
        dbc.conectar();
    }
    
}
