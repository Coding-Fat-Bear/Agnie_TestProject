
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnie.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author agnie
 */
public class Delivery
{
     private JdbcTemplate jdbcTemplate;

    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private String deliveryCode;
    private String deliveryName;
    
    static List<Delivery> listAllDelivery() 
        throws SQLException, ClassNotFoundException, ServletException, IOException{
        
        List<Delivery> listAllDelivery = new ArrayList<>();
        //Here we load the driver’s class file into memory at the runtime. No need of using new or creation of object. 
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        //DriverManager: This class is used to register driver for a specific database type (e.g. Oracle Database) and 
        //to establish a database connection with the server via its getConnection() method.
        try(Connection con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");)
        {
        //Connection: This interface represents an established database connection (session) from which we can create statements 
       // to execute queries and retrieve results, get metadata about the database, close connection, etc. 
            Statement st = con.createStatement();
            String sqllst = "select * from Delivery_Place";
            st.executeQuery(sqllst);
            ResultSet rs = st.getResultSet();
            while (rs.next()) {

                String dlcId = rs.getString("DELLOCID");
                String dlcName = rs.getString("DELLOC");
                System.out.println("dlcName:" + dlcName);

                Delivery delivery = new Delivery();
                delivery.setDeliveryCode(rs.getString("DELLOCID"));

                System.out.println(delivery);
                listAllDelivery.add(delivery);
            
            }            
            
        }
        
        return listAllDelivery;        
    
    
    }
    
    /// delet from department where depid=+depId+

    /**
     * @return the departmentCode
     */
    public String getDeliveryCode() {
        return deliveryCode;
    }

    /**
     * @param departmentCode the departmentCode to set
     */
    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }
   

}

