/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Slobish;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Franco
 */
public class DriverSQL {
    
    Connection conexion;
    String DATABASEDIRECTION;
    String USERNAME;
    String PASSWORD;
    
    DriverSQL (String DB,String UN, String PW)
    {
        this.DATABASEDIRECTION=DB;
        this.USERNAME=UN;
        this.PASSWORD=PW;
    }
    DriverSQL()
    {
        
    }
    public final boolean crearConexion()
    {     
       try {          
          conexion= DriverManager.getConnection(this.DATABASEDIRECTION,this.USERNAME,this.PASSWORD);          
           } 
       catch (SQLException ex) {
          System.err.println(ex);
          return false;
       } 
       return true;
    }
    
     public boolean ejecutarSQL(String sql)
    {
       try {
          Statement sentencia = conexion.createStatement();
          sentencia.executeUpdate(sql);
       } catch (SQLException ex) {
          ex.printStackTrace();
       return false;
       }

       return true;
    }
     
    public ResultSet ejecutarSQLSelect(String sql)
    {
       ResultSet resultado;
       try {
          Statement sentencia = conexion.createStatement();
          resultado = sentencia.executeQuery(sql);
       } catch (SQLException ex) {
          ex.printStackTrace();
          return null;
       }

       return resultado;
    }
}
