/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class conect {
     
    
    
    public conect() throws SQLException{
    
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/pesel","karol", "karol");
        System.out.println("connection sucesfull");
    }
}
