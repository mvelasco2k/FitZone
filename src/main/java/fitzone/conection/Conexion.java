/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitzone.conection;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Mateo Velasco
 */
public class Conexion {
    public static Connection getConnection(){
         Connection connection = null;
         var dataBase = "zone_fit_db";
         var url = "jdbc:mysql://localhost:3306/"+dataBase;
         var user = "root";
         var password = "P220spd3";
         
         try{
             Class.forName("com.mysql.cj.jdbc.Driver"); //Charge the database in memory
             connection = DriverManager.getConnection(url, user, password);
             
         }catch(Exception e){
             e.printStackTrace();
         }
         return connection;
    }
    public static void main(String[] args) {
        var conexion = Conexion.getConnection();
        if(conexion != null){
            System.out.println("Conexion exitosa: "+conexion);
        }else{
            System.out.println("Error al conectarse");
        }
    }
}
