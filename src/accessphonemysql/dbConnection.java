/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accessphonemysql;
import java.sql.*;
/**
 *
 * @author usuario
 */
public class dbConnection {
    static String url = "jdbc:mysql://localhost:3306/db_accessphone";
    static String user = "root";
    static String pass = "2215";

    public static Connection conectar() 
    {
          Connection con = null;
          try 
          {
          con = DriverManager.getConnection(url, user, pass);
                System.out.println("Conexión exitosa");
          }catch (SQLException e)
          {
          e.printStackTrace();
          } 
          return con;
    }
}
