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
 * @author Agnie
 */
class Employee {

    private JdbcTemplate jdbcTemplate;

    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    private String empid1;
    private String ecod1;
    private String enam1;
    private String quil1;

    

    
    
//    Connection con = null;
    
//    PreparedStatement pst = null;
//    Statement cst = null;
//    ResultSet rs = null;
//    ResultSet ss = null;

    static List<Employee> listAllEmployee() 
        throws SQLException, ClassNotFoundException, ServletException, IOException{
        
        List<Employee> listEmployee = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");){
            Statement st = con.createStatement();
            String sqllst = "select * from Employee_Master";
            st.executeQuery(sqllst);
            ResultSet rs = st.getResultSet();
            while(rs.next()){
    
               String empid = rs.getString("EMPCOD");
                String ecod = rs.getString("CCOD");
                String enam = rs.getString("EMPNAM");
                String quli = rs.getString("QUALI");
            
                 
                Employee employee = new Employee();
                employee.setEmpid(rs.getString("EMPCOD"));
                
                System.out.println(employee);
               
                listEmployee.add(employee);
                
            
            }
            
            
        }
        
        return listEmployee;
        
    
    
    }
    
     public String getEmpid()
    {
        
        return empid1;
    }
    private void setEmpid(String empid) {
        this.empid1 = empid;
    }

    

    
    
}
