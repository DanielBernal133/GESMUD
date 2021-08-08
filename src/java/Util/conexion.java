/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class conexion {

    private String driver, user, password, nombredb, urlBd;
    private Connection conexion;
    //2. Darle el valor a los pbjetos 
    public conexion() {   //Constructor

        driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        user ="root";
        password ="123";
        nombredb ="Mas_M3tros5";
        urlBd ="jdbc:sqlserver://LAPTOP-K2HV1MVR:1433;databaseName="+nombredb;
//        driver ="com.mysql.jdbc.Driver";
//        user ="root";
//        password ="";
//        nombredb ="mas_m3tros";
//        urlBd ="jdbc:mysql://localhost:3306/"+nombredb;
//        
        //3. se crea en try y conecto  
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBd,user,password);//conexión a base de datos
            System.out.println("Conexion OK!!");//Para enviar un mensaje de confirmación 
            
        } catch (Exception e) {
            
            System.out.println("ERROR!!" + e.toString());
            
        }

    }

    //metodo de conectar 
    public Connection obtenerConexion() {

        return conexion;

    }

    //metodo cerrar conexion
    public Connection cerrarConexion() throws SQLException {

        conexion.close();
        conexion = null;
        return conexion;

    }

    public static void main(String[] args) {

        new conexion();

    }

}
