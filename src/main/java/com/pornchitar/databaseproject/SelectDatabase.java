/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pornchitar.databaseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class SelectDatabase {

    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:sqlite:dcoffee.db";
        
        ////connect
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been establish.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return; 
        } 
        
        ////selection
        String sql = "SELECT * FROM category";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt("category_id")+ " "+ rs.getString("category_name"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        ////close
        if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
    }
}
