/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Agnie
 */
@Controller
public class login2 {
    private DataSource datasource;
    

    
    public void setDatasource(DataSource datasource){
        this.datasource=datasource;
    }
    
    Connection con = null;
    PreparedStatement pst = null;
    Statement cst = null;
    ResultSet rs = null;
    ResultSet ss = null;
    
    /**
     *
     * @param request
     * @param response
     * @return
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @RequestMapping(value="/login2",method = RequestMethod.POST)
    public ModelAndView showLogin(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String weblng = request.getParameter("weblng");
        Integer emnum = null;
        String dbunm = "";
        String dbpwd = "";
        String sql = "select * from Login_Master where USERNAME='"+uname+"' and PASSWORD='"+pass+"'";
        ModelAndView mav = null;
//        mav = new ModelAndView("log");
        try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            pst = con.prepareStatement(sql);
//            pst.setString(1,uname);
//            pst.setString(2,pass);
            
            rs=pst.executeQuery();
            if(rs.next()){
            dbunm = rs.getString("USERNAME");
            dbpwd = rs.getString("PASSWORD");
            emnum = rs.getInt("EMPCOD");
                }
                if(uname.equals(dbunm) && pass.equals(dbpwd))
                {
                System.out.println("hai how are you");
                String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                System.out.println(EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                  String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }  
                  
                 /**
                 * Department Details
                 */
                String sql6= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DEP = rs6.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                  }
             /** 
              * Language Details
              */   
                String sql7= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String LAN = rs7.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }    
               /* Programming_Language Details*/
                String sql8= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String PGM = rs8.getString("FLDTXT");
                request.setAttribute("PGM",PGM); 
                  }
                /* Module Details*/
                String sql9= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String MOD = rs9.getString("FLDTXT");
                request.setAttribute("MOD",MOD); 
                  }
                 /* Payment terms Details*/
                String sql10= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PAY = rs10.getString("FLDTXT");
                request.setAttribute("PAY",PAY); 
                  }
                  /* Gender Details Details*/
                String sql11= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String GEN = rs11.getString("FLDTXT");
                request.setAttribute("GEN",GEN); 
                  }
                   /* Rank Details Details*/
                String sql12= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String RAN = rs12.getString("FLDTXT");
                request.setAttribute("RAN",RAN); 
                  }
                  /* Country Details Details*/
                String sql13= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CON = rs13.getString("FLDTXT");
                request.setAttribute("CON",CON); 
                  }
                  /* Phase Details Details*/
                String sql14= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PHA = rs14.getString("FLDTXT");
                request.setAttribute("PHA",PHA); 
                  }
                   /* Bank Details Details*/
                String sql15= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BAN = rs15.getString("FLDTXT");
                request.setAttribute("BAN",BAN); 
                  }
                  /* Deliverables Details Details*/
                String sql16= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String DBL = rs16.getString("FLDTXT");
                request.setAttribute("DBL",DBL); 
                  }
                 /* Delivery Place  Details Details*/
                String sql17= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String DLC = rs17.getString("FLDTXT");
                request.setAttribute("DLC",DLC); 
                  }
                 /* Business Line  Details */
                String sql18= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BIZ = rs18.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ); 
                  }
                 /* Employee Type Details */
                String sql19= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EMT = rs19.getString("FLDTXT");
                request.setAttribute("EMT",EMT); 
                  }
                /* Role Master Details */
                String sql20= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ROL = rs20.getString("FLDTXT");
                request.setAttribute("ROL",ROL); 
                  }
                /* Company Code Details */
                String sql21= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String COM = rs21.getString("FLDTXT");
                request.setAttribute("COM",COM); 
                  }
                /* Currency Details */
                String sql22= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CUR = rs22.getString("FLDTXT");
                request.setAttribute("CUR",CUR); 
                  }
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
                
            }
            else{
            request.setAttribute("appnm","1");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            System.out.println("user and pass is worng");
            }
        }
        catch(IOException | SQLException | ServletException ex){
                JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
                System.out.println("Error"+ex.getMessage());
        }
       con.close();
        return mav;
        
        
    }
    
    /**
     *
     * @param request
     * @param response
     * @return
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @RequestMapping(value="/usrcre")
    public ModelAndView user(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        
        String uname = request.getParameter("crenam");
        String pass = request.getParameter("crepas");
        String sql = "INSERT INTO Login (USERNAME,PASSWORD) VALUES ('"+uname+"','"+pass+"');";
        ModelAndView mav = null;
//        mav = new ModelAndView("log");
        try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            cst = con.createStatement();
//            pst.setString(1,uname);
//            pst.setString(2,pass);
            
            int n1 = cst.executeUpdate(sql);
            if(n1 > 0){
                System.out.println("hai how are you");
                mav = new ModelAndView("index");
                
//        mav.addObject("log",new log());
//            return mav;
            }
            else{
            request.setAttribute("appnm","1");
            RequestDispatcher rd = request.getRequestDispatcher("usercre.jsp");
            rd.forward(request, response);
            System.out.println("user and pass is worng");
//            mav = new ModelAndView("index");
            }
        }
        catch(IOException | SQLException | ServletException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
            System.out.println(ex.getMessage());
//                alert(null, ex);
        }
       
//        System.out.println("hai how are you");
//        ModelAndView mav = new ModelAndView("log");
////        mav.addObject("log",new log());
        return mav;
        
    }
    
    @RequestMapping(value="/insert")
    public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String empid = request.getParameter("empid");
            String ccod = request.getParameter("ccod");
            String actst = request.getParameter("actst");
            String cdat = request.getParameter("cdat");
            String empnm = request.getParameter("empnm");
            String dob = request.getParameter("dob");
            String gnd = request.getParameter("gnd");
            String lang = request.getParameter("lang");
            String actstrt = request.getParameter("actstrt");
            String actend = request.getParameter("actend");
            String str1 = request.getParameter("str1");
            String str2 = request.getParameter("str2");
            String str3 = request.getParameter("str3");
            String city = request.getParameter("city");
            String stat = request.getParameter("stat");
            String cntry = request.getParameter("cntry");
            String pstl = request.getParameter("pstl");
            String phn1 = request.getParameter("phn1");
            String phn2 = request.getParameter("phn2");
            String fax = request.getParameter("fax");
            String emil = request.getParameter("emil");
            String bnk = request.getParameter("bnk");
            String bsal = request.getParameter("bsal");
            String incnt = request.getParameter("incnt");
            String bons = request.getParameter("bons");
            String sclins = request.getParameter("sclins");
            String helins = request.getParameter("helins");
            String epf = request.getParameter("epf");
            String sttben = request.getParameter("sttben");
            String hrawl = request.getParameter("hrawl");
            String conawl = request.getParameter("conawl");
            String advnc = request.getParameter("advnc");
            String tax = request.getParameter("tax");
            String bilrat = request.getParameter("bilrat");
            String bslin = request.getParameter("bslin");
            String dept = request.getParameter("dept");
            String emptyp = request.getParameter("emptyp");
            String rank = request.getParameter("rank");
            String modexp = request.getParameter("modexp");
            String pmglnex = request.getParameter("pmglnex");
            String exsap = request.getParameter("exsap");
            String exit = request.getParameter("exit");
            String resv = request.getParameter("resv");
            String splnex = request.getParameter("splnex");
            String quli = request.getParameter("quli");
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlad = "INSERT INTO Address (STREET1, STREET2, STREET3, CITY, STATE, CNTRY, PINCODE, PHONE1, PHONE2, FAXNO, EMAIL, LNGID, CREDT, CRETIM) VALUES ('"+str1+"', '"+str2+"', '"+str3+"', '"+city+"', '"+stat+"', '"+cntry+"', '"+pstl+"', '"+phn1+"', '"+phn2+"', '"+fax+"', '"+emil+"', '"+lang+"', CURDATE(), CURTIME());";
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sqlad);
            if(n1 > 0){
            try{
                con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                Class.forName("com.mysql.cj.jdbc.Driver");
                String sqladno = "SELECT max(ADDNO) as adno FROM Address;";
                pst = con.prepareStatement(sqladno);
                rs=pst.executeQuery();
                while(rs.next()){
                    
                    String addno = rs.getString("adno");
                    System.out.println(addno);
                    
                    try{
                    con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    
                    String sqlemp = "INSERT INTO Employee_Master (CCOD, EMPNAM, EMPDOB, GENDER, ADDNO, BIZID, DPTCOD, EMPTYP, QUALI, BANCOD, RANKCOD, MODUL, SPLNGID, PGMLANG, EXSAP, EXPIT, RESERV, ACTFLG, BASSAL, INCNT, BONUS, SOCINS, HELINS, STATBEN, CONALW, HRALW, TAX, PENSION, LOAN, BILRATE, CREDT, ACTSTRDT, ACTENDT) VALUES ('"+ccod+"', '"+empnm+"', '"+dob+"', '"+gnd+"', '"+addno+"', '"+bslin+"', '"+dept+"', '"+emptyp+"', '"+quli+"', '"+bnk+"','"+rank+"','"+modexp+"', '"+splnex+"', '"+pmglnex+"', '"+exsap+"', '"+exit+"', '"+resv+"', '"+actst+"', '"+bsal+"', '"+incnt+"', '"+bons+"', '"+sclins+"', '"+helins+"', '"+sttben+"', '"+conawl+"', '"+hrawl+"', '"+tax+"', '"+epf+"', '"+advnc+"', '"+bilrat+"', CURDATE(), '"+actstrt+"', '"+actend+"');";
                    
                    cst = con.createStatement();
                    int e1 = cst.executeUpdate(sqlemp);
                    if(e1 > 0){
                        System.out.println("Successfully created employee");
                        try{
                            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String sqlempno = "SELECT max(EMPCOD) as empcd FROM Employee_Master;";
                            pst = con.prepareStatement(sqlempno);
                            ss=pst.executeQuery();
                            while(ss.next()){
                                
                                String empno = ss.getString("empcd");
                                JOptionPane.showMessageDialog(null,"Successfully created employee "+empno);
                                request.setAttribute("appnm","1");
                                request.setAttribute("empno",empno);
                                request.setAttribute("addno",addno);
                                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
                                rd.forward(request, response);
//                                login2 call = new login2();
                                
                                System.out.println("Successfully created employee "+empno);
                               
                            }
                        
                        }
                        catch(SQLException hx){
                          JOptionPane.showMessageDialog(null,"Error: "+hx.getMessage());
                            System.out.println(hx.getMessage());
//                        request.setAttribute("err","ERR");
//                        request.setAttribute("mes",hx.getMessage());
//                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//                        rd.forward(request, response);
                            mav = new ModelAndView("log");
                    }
                                            
                    }
                    
                    }
                    catch(SQLException gx){
                        JOptionPane.showMessageDialog(null,"Error: "+gx.getMessage());
//                        request.setAttribute("err","ERR");
//                        request.setAttribute("mes",gx.getMessage());
//                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//                        rd.forward(request, response);
                    System.out.println(gx.getMessage());
                    mav = new ModelAndView("log");
                    }
                    
                }
                
            }
            catch(SQLException fx){
                JOptionPane.showMessageDialog(null,"Error: "+fx.getMessage());
//                request.setAttribute("err","ERR");
//                request.setAttribute("mes",fx.getMessage());
//                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//                rd.forward(request, response);
                System.out.println(fx.getMessage());
                mav = new ModelAndView("log");
            }
            
            }
            
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
//                request.setAttribute("err","ERR");
//                        request.setAttribute("mes",ex.getMessage());
//                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//                        rd.forward(request, response);
                System.out.println(ex.getMessage());
                mav = new ModelAndView("log");
            }
            
        return mav;
    }
    
    @RequestMapping(value="/getemp")
    public ModelAndView getemp(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String empid = request.getParameter("empid");
        String scrn = request.getParameter("scrn");
        System.out.println("get is working fine"+empid);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
//        String sqlget = "SELECT * FROM Employee_Master where EMPCOD = '"+empid+"';";
        String sqlget = "SELECT * FROM agnieportal.Employee_Master em inner join agnieportal.Address am on em.ADDNO = am.ADDNO where EMPCOD = '"+empid+"' ;";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
        while(ss.next()){
            
           String empid1 = ss.getString("EMPCOD");
            String ccod = ss.getString("CCOD");
            String actst = ss.getString("ACTFLG");
            String cdat = ss.getString("CREDT");
            String empnm = ss.getString("EMPNAM");
            String dob = ss.getString("EMPDOB");
            String gnd = ss.getString("GENDER");
            String splnex = ss.getString("SPLNGID");            
            String actstrt = ss.getString("ACTSTRDT");
            String actend = ss.getString("ACTENDT");
            String str1 = ss.getString("STREET1");
            String str2 = ss.getString("STREET2");
            String str3 = ss.getString("STREET3");
            String city = ss.getString("CITY");
            String stat = ss.getString("STATE");
            String cntry = ss.getString("CNTRY");
            String lang = ss.getString("LNGID");
            String pstl = ss.getString("PINCODE");
            String phn1 = ss.getString("PHONE1");
            String phn2 = ss.getString("PHONE2");
            String fax = ss.getString("FAXNO");
            String emil = ss.getString("EMAIL");
            String bnk = ss.getString("BANCOD");
            String bsal = ss.getString("BASSAL");
            String incnt = ss.getString("INCNT");
            String bons = ss.getString("BONUS");
            String sclins = ss.getString("SOCINS");
            String helins = ss.getString("HELINS");
            String sttben = ss.getString("STATBEN");
            String epf = ss.getString("PENSION");
            String hrawl = ss.getString("HRALW");
            String conawl = ss.getString("CONALW");
            String advnc = ss.getString("LOAN");
            String tax = ss.getString("TAX");
            String bilrat = ss.getString("BILRATE");
            String bslin = ss.getString("BIZID");
            String dept = ss.getString("DPTCOD");
            String emptyp = ss.getString("DPTCOD");
            String rank = ss.getString("RANKCOD");
            String modexp = ss.getString("MODUL");
            String pmglnex = ss.getString("PGMLANG");
            String exsap = ss.getString("EXSAP");
            String exit = ss.getString("EXPIT");
            String resv = ss.getString("RESERV");
            String quli = ss.getString("QUALI");
            
          request.setAttribute("getnm","2");
          request.setAttribute("empid1", empid1);
          request.setAttribute("ccod", ccod);
          request.setAttribute("actst", actst);          
          request.setAttribute("cdat", cdat);          
          request.setAttribute("empnm", empnm);                    
          request.setAttribute("dob", dob);
          request.setAttribute("gnd", gnd);
          request.setAttribute("splnex", splnex);
          request.setAttribute("actstrt", actstrt);
          request.setAttribute("actend", actend);
          request.setAttribute("str1", str1);
          request.setAttribute("str2", str2);
          request.setAttribute("str3", str3);
          request.setAttribute("city", city);
          request.setAttribute("stat", stat);
          request.setAttribute("cntry", cntry);
          request.setAttribute("lang", lang);
          request.setAttribute("pstl", pstl);
          request.setAttribute("phn1", phn1);
          request.setAttribute("phn2", phn2);
          request.setAttribute("fax", fax);
          request.setAttribute("emil", emil);
          request.setAttribute("bnk", bnk);
          request.setAttribute("bsal", bsal);
          request.setAttribute("incnt", incnt);
          request.setAttribute("bons", bons);
          request.setAttribute("sclins", sclins);
          request.setAttribute("helins", helins);
          request.setAttribute("sttben", sttben);
          request.setAttribute("epf", epf);
          request.setAttribute("hrawl", hrawl);
          request.setAttribute("conawl", conawl);
          request.setAttribute("advnc", advnc);
          request.setAttribute("tax", tax);
          request.setAttribute("bilrat", bilrat);
          request.setAttribute("bslin", bslin);
          request.setAttribute("dept", dept);
          request.setAttribute("emptyp", emptyp);
          request.setAttribute("rank", rank);
          request.setAttribute("modexp", modexp);
          request.setAttribute("pmglnex", pmglnex);
          request.setAttribute("exsap", exsap);
          request.setAttribute("exit", exit);
          request.setAttribute("resv", resv);
          request.setAttribute("quli", quli);
          request.setAttribute("scrn", scrn);          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
          rd.forward(request, response);   
        
        }
        
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
//            request.setAttribute("err","ERR");
//            request.setAttribute("mes",ex.getMessage());
//            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//            rd.forward(request, response);
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;    
    }
    
    
   @RequestMapping(value="/delemp")
    public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String empid = request.getParameter("empid");
    
        try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqldel = "Delete from Employee_Master, Address using Employee_Master inner join Address on Employee_Master.ADDNO = Address.ADDNO where EMPCOD = '"+empid+"';";
            cst = con.createStatement();
            int d1 = cst.executeUpdate(sqldel);
            
            if(d1 > 0){
            
                 JOptionPane.showMessageDialog(null,"Record Deleted Successfully");
//                login2.this.showLogin(request, response);
                request.setAttribute("delet","DEL");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
                rd.forward(request, response);
            
            }
            
            
        }
        catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
//            request.setAttribute("err","ERR");
//            request.setAttribute("mes",ex.getMessage());
//            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//            rd.forward(request, response);
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        
        }
            
            
            
        return mav;
        
    } 
    
    @RequestMapping(value="/updt")
    public ModelAndView update(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String empid = request.getParameter("empid");
            String ccod = request.getParameter("ccod");
            String actst = request.getParameter("actst");
            String cdat = request.getParameter("cdat");
            String empnm = request.getParameter("empnm");
            String dob = request.getParameter("dob");
            String gnd = request.getParameter("gnd");
            String lang = request.getParameter("lang");
            String actstrt = request.getParameter("actstrt");
            String actend = request.getParameter("actend");
            String str1 = request.getParameter("str1");
            String str2 = request.getParameter("str2");
            String str3 = request.getParameter("str3");
            String city = request.getParameter("city");
            String stat = request.getParameter("stat");
            String cntry = request.getParameter("cntry");
            String pstl = request.getParameter("pstl");
            String phn1 = request.getParameter("phn1");
            String phn2 = request.getParameter("phn2");
            String fax = request.getParameter("fax");
            String emil = request.getParameter("emil");
            String bnk = request.getParameter("bnk");
            String bsal = request.getParameter("bsal");
            String incnt = request.getParameter("incnt");
            String bons = request.getParameter("bons");
            String sclins = request.getParameter("sclins");
            String helins = request.getParameter("helins");
            String epf = request.getParameter("epf");
            String sttben = request.getParameter("sttben");
            String hrawl = request.getParameter("hrawl");
            String conawl = request.getParameter("conawl");
            String advnc = request.getParameter("advnc");
            String tax = request.getParameter("tax");
            String bilrat = request.getParameter("bilrat");
            String bslin = request.getParameter("bslin");
            String dept = request.getParameter("dept");
            String emptyp = request.getParameter("emptyp");
            String rank = request.getParameter("rank");
            String modexp = request.getParameter("modexp");
            String pmglnex = request.getParameter("pmglnex");
            String exsap = request.getParameter("exsap");
            String exit = request.getParameter("exit");
            String resv = request.getParameter("resv");
            String splnex = request.getParameter("splnex");
            String quli = request.getParameter("quli");
        
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlupd = "update agnieportal.Employee_Master em inner join agnieportal.Address am on em.ADDNO = am.ADDNO "+
                            "set em.CCOD = '"+ccod+"', em.EMPNAM = '"+empnm+"', em.EMPDOB = '"+dob+"', em.GENDER = '"+gnd+"', em.BIZID = '"+bslin+"', "+
                            "em.DPTCOD = '"+dept+"', em.EMPTYP = '"+emptyp+"', em.QUALI = '"+quli+"', em.BANCOD = '"+bnk+"', em.RANKCOD = '"+rank+"', em.MODUL = '"+modexp+"', "+
                            "em.SPLNGID = '"+splnex+"', em.PGMLANG = '"+pmglnex+"', em.EXSAP = '"+exsap+"', em.EXPIT = '"+exit+"', em.RESERV = '"+resv+"', em.ACTFLG = '"+actst+"', "+
                            "em.BASSAL = '"+bsal+"', em.INCNT = '"+incnt+"', em.BONUS = '"+bons+"', em.SOCINS = '"+sclins+"', em.HELINS = '"+helins+"', em.STATBEN = '"+sttben+"', "+
                            "em.CONALW = '"+conawl+"', em.HRALW = '"+hrawl+"', em.TAX = '"+tax+"', em.PENSION = '"+epf+"', em.LOAN = '"+advnc+"', em.BILRATE = '"+bilrat+"', "+
                            "em.ACTSTRDT = '"+actstrt+"', em.ACTENDT = '"+actend+"', am.STREET1 = '"+str1+"', am.STREET2 = '"+str2+"', am.STREET3 = '"+str3+"', "+
                            "am.CITY = '"+city+"', am.STATE = '"+stat+"', am.CNTRY = '"+cntry+"', am.PINCODE = '"+pstl+"', am.PHONE1 = '"+phn1+"', am.PHONE2 = '"+phn2+"', "+
                            "am.FAXNO = '"+fax+"', am.EMAIL = '"+emil+"',am.LNGID = '"+lang+"' where em.EMPCOD = '"+empid+"';";
            
             cst = con.createStatement();
            int u1 = cst.executeUpdate(sqlupd);
            
            if(u1 > 0){
            
                JOptionPane.showMessageDialog(null,"Record "+empid+" Updated Successfully");
                
//                login2.this.employee(request, response);
                request.setAttribute("updt","UPD");
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
                rd.forward(request, response);
                 mav = login2.this.employee(request,response);
            
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
//            request.setAttribute("err","ERR");
//            request.setAttribute("mes",ex.getMessage());
//            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//            rd.forward(request, response);
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        
        }
        
        
        return mav;
    
    
    }
    
    /**
     *
     * @param request
     * @param response
     * @return
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @RequestMapping(value="/employee")
    public ModelAndView employee(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/empcre")
    public ModelAndView empcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMLST = rs5.getString("FLDTXT");
                request.setAttribute("EMLST",EMLST);
                  }
                  
                  String sql6= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BSDT = rs6.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                  String sql7= "select * from Field_Text where FLDID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String SALDT = rs7.getString("FLDTXT");
                request.setAttribute("SALDT",SALDT);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String ORGDT = rs8.getString("FLDTXT");
                request.setAttribute("ORGDT",ORGDT);
                  }
                  
                  String sql9= "select * from Field_Text where FLDID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String EXPR = rs9.getString("FLDTXT");
                request.setAttribute("EXPR",EXPR);
                  }
                  
                  String sql10= "select * from Field_Text where FLDID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String EMPLNO = rs10.getString("FLDTXT");
                request.setAttribute("EMPLNO",EMPLNO);
                  }
                  
                   String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='14' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String ATST = rs12.getString("FLDTXT");
                request.setAttribute("ATST",ATST);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='15' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String EMPLNAM = rs13.getString("FLDTXT");
                request.setAttribute("EMPLNAM",EMPLNAM);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='16' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String DOBRT = rs14.getString("FLDTXT");
                request.setAttribute("DOBRT",DOBRT);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String GNDR = rs15.getString("FLDTXT");
                request.setAttribute("GNDR",GNDR);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='18' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String AGE = rs16.getString("FLDTXT");
                request.setAttribute("AGE",AGE);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='19' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String SPLNEX = rs17.getString("FLDTXT");
                request.setAttribute("SPLNEX",SPLNEX);
                  }
                  
                String sql18= "select * from Field_Text where FLDID ='20' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String ATSTDT = rs18.getString("FLDTXT");
                request.setAttribute("ATSTDT",ATSTDT);
                  }
                  
                String sql19= "select * from Field_Text where FLDID ='21' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String ATENDT = rs19.getString("FLDTXT");
                request.setAttribute("ATENDT",ATENDT);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='22' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String STRT = rs20.getString("FLDTXT");
                request.setAttribute("STRT",STRT);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='23' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CITY = rs21.getString("FLDTXT");
                request.setAttribute("CITY",CITY);
                  }
                  
                String sql22= "select * from Field_Text where FLDID ='24' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String STATE = rs22.getString("FLDTXT");
                request.setAttribute("STATE",STATE);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CONTR = rs23.getString("FLDTXT");
                request.setAttribute("CONTR",CONTR);
                  }
                  
                String sql24= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String LANGU = rs24.getString("FLDTXT");
                request.setAttribute("LANGU",LANGU);
                  }
                  
                String sql25= "select * from Field_Text where FLDID ='27' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String PSTLCOD = rs25.getString("FLDTXT");
                request.setAttribute("PSTLCOD",PSTLCOD);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='28' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String PHON = rs26.getString("FLDTXT");
                request.setAttribute("PHON",PHON);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='29' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String FAKUSU = rs27.getString("FLDTXT");
                request.setAttribute("FAKUSU",FAKUSU);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='30' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String MERU = rs28.getString("FLDTXT");
                request.setAttribute("MERU",MERU);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String GINKO = rs29.getString("FLDTXT");
                request.setAttribute("GINKO",GINKO);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='32' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String BSLRY = rs30.getString("FLDTXT");
                request.setAttribute("BSLRY",BSLRY);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='33' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String HRAL = rs31.getString("FLDTXT");
                request.setAttribute("HRAL",HRAL);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='34' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String CONAL = rs32.getString("FLDTXT");
                request.setAttribute("CONAL",CONAL);
                  }
                
                String sql33= "select * from Field_Text where FLDID ='35' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String STTBN = rs33.getString("FLDTXT");
                request.setAttribute("STTBN",STTBN);
                  }
                
                String sql34= "select * from Field_Text where FLDID ='36' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String INCENT = rs34.getString("FLDTXT");
                request.setAttribute("INCENT",INCENT);
                  }
                 
                String sql35= "select * from Field_Text where FLDID ='37' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String BOUNS = rs35.getString("FLDTXT");
                request.setAttribute("BOUNS",BOUNS);
                  }
                  
                String sql36= "select * from Field_Text where FLDID ='38' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String SOIN = rs36.getString("FLDTXT");
                request.setAttribute("SOIN",SOIN);
                  }
                  
                String sql37= "select * from Field_Text where FLDID ='39' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String HELIN = rs37.getString("FLDTXT");
                request.setAttribute("HELIN",HELIN);
                  }
                  
                String sql38= "select * from Field_Text where FLDID ='40' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String ADVNC = rs38.getString("FLDTXT");
                request.setAttribute("ADVNC",ADVNC);
                  }
                  
                String sql39= "select * from Field_Text where FLDID ='41' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String EMPF = rs39.getString("FLDTXT");
                request.setAttribute("EMPF",EMPF);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='42' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String ZEITAX = rs40.getString("FLDTXT");
                request.setAttribute("ZEITAX",ZEITAX);
                  }
                  
                String sql41= "select * from Field_Text where FLDID ='43' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String TOTDED = rs41.getString("FLDTXT");
                request.setAttribute("TOTDED",TOTDED);
                  }
                  
                String sql42= "select * from Field_Text where FLDID ='44' and LNGID ='"+weblng+"'";
                PreparedStatement pst42 = con.prepareStatement(sql42);
                ResultSet rs42 = pst42.executeQuery();
                  while(rs42.next()){
                String BILRATE = rs42.getString("FLDTXT");
                request.setAttribute("BILRATE",BILRATE);
                  }
                  
                String sql43= "select * from Field_Text where FLDID ='45' and LNGID ='"+weblng+"'";
                PreparedStatement pst43 = con.prepareStatement(sql43);
                ResultSet rs43 = pst43.executeQuery();
                  while(rs43.next()){
                String GRSSAL = rs43.getString("FLDTXT");
                request.setAttribute("GRSSAL",GRSSAL);
                  }
                  
                String sql44= "select * from Field_Text where FLDID ='46' and LNGID ='"+weblng+"'";
                PreparedStatement pst44 = con.prepareStatement(sql44);
                ResultSet rs44 = pst44.executeQuery();
                  while(rs44.next()){
                String NETSL = rs44.getString("FLDTXT");
                request.setAttribute("NETSL",NETSL);
                  }
                  
                String sql45= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst45 = con.prepareStatement(sql45);
                ResultSet rs45 = pst45.executeQuery();
                  while(rs45.next()){
                String BUSILN = rs45.getString("FLDTXT");
                request.setAttribute("BUSILN",BUSILN);
                  }
                  
                String sql46= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst46 = con.prepareStatement(sql46);
                ResultSet rs46 = pst46.executeQuery();
                  while(rs46.next()){
                String DEPMNT = rs46.getString("FLDTXT");
                request.setAttribute("DEPMNT",DEPMNT);
                  }
                  
                String sql47= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst47 = con.prepareStatement(sql47);
                ResultSet rs47 = pst47.executeQuery();
                  while(rs47.next()){
                String EMTYP = rs47.getString("FLDTXT");
                request.setAttribute("EMTYP",EMTYP);
                  }
                  
                String sql48= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst48 = con.prepareStatement(sql48);
                ResultSet rs48 = pst48.executeQuery();
                  while(rs48.next()){
                String EMRNK = rs48.getString("FLDTXT");
                request.setAttribute("EMRNK",EMRNK);
                  }
                  
                String sql49= "select * from Field_Text where FLDID ='51' and LNGID ='"+weblng+"'";
                PreparedStatement pst49 = con.prepareStatement(sql49);
                ResultSet rs49 = pst49.executeQuery();
                  while(rs49.next()){
                String RESVE = rs49.getString("FLDTXT");
                request.setAttribute("RESVE",RESVE);
                  }
                  
                String sql50= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst50 = con.prepareStatement(sql50);
                ResultSet rs50 = pst50.executeQuery();
                  while(rs50.next()){
                String MODEXPR = rs50.getString("FLDTXT");
                request.setAttribute("MODEXPR",MODEXPR);
                  }
                  
                String sql51= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst51 = con.prepareStatement(sql51);
                ResultSet rs51 = pst51.executeQuery();
                  while(rs51.next()){
                String PROLNEX = rs51.getString("FLDTXT");
                request.setAttribute("PROLNEX",PROLNEX);
                  }
                  
                String sql52= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst52 = con.prepareStatement(sql52);
                ResultSet rs52 = pst52.executeQuery();
                  while(rs52.next()){
                String EXPRSAP = rs52.getString("FLDTXT");
                request.setAttribute("EXPRSAP",EXPRSAP);
                  }
                  
                String sql53= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst53 = con.prepareStatement(sql53);
                ResultSet rs53 = pst53.executeQuery();
                  while(rs53.next()){
                String EXPRIT = rs53.getString("FLDTXT");
                request.setAttribute("EXPRIT",EXPRIT);
                  }
                  
                String sql54= "select * from Field_Text where FLDID ='56' and LNGID ='"+weblng+"'";
                PreparedStatement pst54 = con.prepareStatement(sql54);
                ResultSet rs54 = pst54.executeQuery();
                  while(rs54.next()){
                String QALIFI = rs54.getString("FLDTXT");
                request.setAttribute("QALIFI",QALIFI);
                  }
                  
                String sql55= "select * from Field_Text where FLDID ='57' and LNGID ='"+weblng+"'";
                PreparedStatement pst55 = con.prepareStatement(sql55);
                ResultSet rs55 = pst55.executeQuery();
                  while(rs55.next()){
                String EMROLE = rs55.getString("FLDTXT");
                request.setAttribute("EMROLE",EMROLE);
                  }  
                  
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/empcha")
    public ModelAndView empcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMLST = rs5.getString("FLDTXT");
                request.setAttribute("EMLST",EMLST);
                  }
                  
                  String sql6= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BSDT = rs6.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                  String sql7= "select * from Field_Text where FLDID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String SALDT = rs7.getString("FLDTXT");
                request.setAttribute("SALDT",SALDT);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String ORGDT = rs8.getString("FLDTXT");
                request.setAttribute("ORGDT",ORGDT);
                  }
                  
                  String sql9= "select * from Field_Text where FLDID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String EXPR = rs9.getString("FLDTXT");
                request.setAttribute("EXPR",EXPR);
                  }
                  
                  String sql10= "select * from Field_Text where FLDID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String EMPLNO = rs10.getString("FLDTXT");
                request.setAttribute("EMPLNO",EMPLNO);
                  }
                  
                   String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='14' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String ATST = rs12.getString("FLDTXT");
                request.setAttribute("ATST",ATST);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='15' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String EMPLNAM = rs13.getString("FLDTXT");
                request.setAttribute("EMPLNAM",EMPLNAM);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='16' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String DOBRT = rs14.getString("FLDTXT");
                request.setAttribute("DOBRT",DOBRT);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String GNDR = rs15.getString("FLDTXT");
                request.setAttribute("GNDR",GNDR);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='18' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String AGE = rs16.getString("FLDTXT");
                request.setAttribute("AGE",AGE);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='19' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String SPLNEX = rs17.getString("FLDTXT");
                request.setAttribute("SPLNEX",SPLNEX);
                  }
                  
                String sql18= "select * from Field_Text where FLDID ='20' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String ATSTDT = rs18.getString("FLDTXT");
                request.setAttribute("ATSTDT",ATSTDT);
                  }
                  
                String sql19= "select * from Field_Text where FLDID ='21' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String ATENDT = rs19.getString("FLDTXT");
                request.setAttribute("ATENDT",ATENDT);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='22' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String STRT = rs20.getString("FLDTXT");
                request.setAttribute("STRT",STRT);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='23' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CITY = rs21.getString("FLDTXT");
                request.setAttribute("CITY",CITY);
                  }
                  
                String sql22= "select * from Field_Text where FLDID ='24' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String STATE = rs22.getString("FLDTXT");
                request.setAttribute("STATE",STATE);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CONTR = rs23.getString("FLDTXT");
                request.setAttribute("CONTR",CONTR);
                  }
                  
                String sql24= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String LANGU = rs24.getString("FLDTXT");
                request.setAttribute("LANGU",LANGU);
                  }
                  
                String sql25= "select * from Field_Text where FLDID ='27' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String PSTLCOD = rs25.getString("FLDTXT");
                request.setAttribute("PSTLCOD",PSTLCOD);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='28' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String PHON = rs26.getString("FLDTXT");
                request.setAttribute("PHON",PHON);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='29' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String FAKUSU = rs27.getString("FLDTXT");
                request.setAttribute("FAKUSU",FAKUSU);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='30' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String MERU = rs28.getString("FLDTXT");
                request.setAttribute("MERU",MERU);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String GINKO = rs29.getString("FLDTXT");
                request.setAttribute("GINKO",GINKO);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='32' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String BSLRY = rs30.getString("FLDTXT");
                request.setAttribute("BSLRY",BSLRY);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='33' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String HRAL = rs31.getString("FLDTXT");
                request.setAttribute("HRAL",HRAL);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='34' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String CONAL = rs32.getString("FLDTXT");
                request.setAttribute("CONAL",CONAL);
                  }
                
                String sql33= "select * from Field_Text where FLDID ='35' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String STTBN = rs33.getString("FLDTXT");
                request.setAttribute("STTBN",STTBN);
                  }
                
                String sql34= "select * from Field_Text where FLDID ='36' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String INCENT = rs34.getString("FLDTXT");
                request.setAttribute("INCENT",INCENT);
                  }
                 
                String sql35= "select * from Field_Text where FLDID ='37' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String BOUNS = rs35.getString("FLDTXT");
                request.setAttribute("BOUNS",BOUNS);
                  }
                  
                String sql36= "select * from Field_Text where FLDID ='38' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String SOIN = rs36.getString("FLDTXT");
                request.setAttribute("SOIN",SOIN);
                  }
                  
                String sql37= "select * from Field_Text where FLDID ='39' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String HELIN = rs37.getString("FLDTXT");
                request.setAttribute("HELIN",HELIN);
                  }
                  
                String sql38= "select * from Field_Text where FLDID ='40' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String ADVNC = rs38.getString("FLDTXT");
                request.setAttribute("ADVNC",ADVNC);
                  }
                  
                String sql39= "select * from Field_Text where FLDID ='41' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String EMPF = rs39.getString("FLDTXT");
                request.setAttribute("EMPF",EMPF);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='42' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String ZEITAX = rs40.getString("FLDTXT");
                request.setAttribute("ZEITAX",ZEITAX);
                  }
                  
                String sql41= "select * from Field_Text where FLDID ='43' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String TOTDED = rs41.getString("FLDTXT");
                request.setAttribute("TOTDED",TOTDED);
                  }
                  
                String sql42= "select * from Field_Text where FLDID ='44' and LNGID ='"+weblng+"'";
                PreparedStatement pst42 = con.prepareStatement(sql42);
                ResultSet rs42 = pst42.executeQuery();
                  while(rs42.next()){
                String BILRATE = rs42.getString("FLDTXT");
                request.setAttribute("BILRATE",BILRATE);
                  }
                  
                String sql43= "select * from Field_Text where FLDID ='45' and LNGID ='"+weblng+"'";
                PreparedStatement pst43 = con.prepareStatement(sql43);
                ResultSet rs43 = pst43.executeQuery();
                  while(rs43.next()){
                String GRSSAL = rs43.getString("FLDTXT");
                request.setAttribute("GRSSAL",GRSSAL);
                  }
                  
                String sql44= "select * from Field_Text where FLDID ='46' and LNGID ='"+weblng+"'";
                PreparedStatement pst44 = con.prepareStatement(sql44);
                ResultSet rs44 = pst44.executeQuery();
                  while(rs44.next()){
                String NETSL = rs44.getString("FLDTXT");
                request.setAttribute("NETSL",NETSL);
                  }
                  
                String sql45= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst45 = con.prepareStatement(sql45);
                ResultSet rs45 = pst45.executeQuery();
                  while(rs45.next()){
                String BUSILN = rs45.getString("FLDTXT");
                request.setAttribute("BUSILN",BUSILN);
                  }
                  
                String sql46= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst46 = con.prepareStatement(sql46);
                ResultSet rs46 = pst46.executeQuery();
                  while(rs46.next()){
                String DEPMNT = rs46.getString("FLDTXT");
                request.setAttribute("DEPMNT",DEPMNT);
                  }
                  
                String sql47= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst47 = con.prepareStatement(sql47);
                ResultSet rs47 = pst47.executeQuery();
                  while(rs47.next()){
                String EMTYP = rs47.getString("FLDTXT");
                request.setAttribute("EMTYP",EMTYP);
                  }
                  
                String sql48= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst48 = con.prepareStatement(sql48);
                ResultSet rs48 = pst48.executeQuery();
                  while(rs48.next()){
                String EMRNK = rs48.getString("FLDTXT");
                request.setAttribute("EMRNK",EMRNK);
                  }
                  
                String sql49= "select * from Field_Text where FLDID ='51' and LNGID ='"+weblng+"'";
                PreparedStatement pst49 = con.prepareStatement(sql49);
                ResultSet rs49 = pst49.executeQuery();
                  while(rs49.next()){
                String RESVE = rs49.getString("FLDTXT");
                request.setAttribute("RESVE",RESVE);
                  }
                  
                String sql50= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst50 = con.prepareStatement(sql50);
                ResultSet rs50 = pst50.executeQuery();
                  while(rs50.next()){
                String MODEXPR = rs50.getString("FLDTXT");
                request.setAttribute("MODEXPR",MODEXPR);
                  }
                  
                String sql51= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst51 = con.prepareStatement(sql51);
                ResultSet rs51 = pst51.executeQuery();
                  while(rs51.next()){
                String PROLNEX = rs51.getString("FLDTXT");
                request.setAttribute("PROLNEX",PROLNEX);
                  }
                  
                String sql52= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst52 = con.prepareStatement(sql52);
                ResultSet rs52 = pst52.executeQuery();
                  while(rs52.next()){
                String EXPRSAP = rs52.getString("FLDTXT");
                request.setAttribute("EXPRSAP",EXPRSAP);
                  }
                  
                String sql53= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst53 = con.prepareStatement(sql53);
                ResultSet rs53 = pst53.executeQuery();
                  while(rs53.next()){
                String EXPRIT = rs53.getString("FLDTXT");
                request.setAttribute("EXPRIT",EXPRIT);
                  }
                  
                String sql54= "select * from Field_Text where FLDID ='56' and LNGID ='"+weblng+"'";
                PreparedStatement pst54 = con.prepareStatement(sql54);
                ResultSet rs54 = pst54.executeQuery();
                  while(rs54.next()){
                String QALIFI = rs54.getString("FLDTXT");
                request.setAttribute("QALIFI",QALIFI);
                  }
                  
                String sql55= "select * from Field_Text where FLDID ='57' and LNGID ='"+weblng+"'";
                PreparedStatement pst55 = con.prepareStatement(sql55);
                ResultSet rs55 = pst55.executeQuery();
                  while(rs55.next()){
                String EMROLE = rs55.getString("FLDTXT");
                request.setAttribute("EMROLE",EMROLE);
                  }  
                  
        request.setAttribute("weblng",weblng);
        request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/empdis")
    public ModelAndView empdis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        
        String weblng = request.getParameter("weblng");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMLST = rs5.getString("FLDTXT");
                request.setAttribute("EMLST",EMLST);
                  }
                  
                  String sql6= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BSDT = rs6.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                  String sql7= "select * from Field_Text where FLDID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String SALDT = rs7.getString("FLDTXT");
                request.setAttribute("SALDT",SALDT);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String ORGDT = rs8.getString("FLDTXT");
                request.setAttribute("ORGDT",ORGDT);
                  }
                  
                  String sql9= "select * from Field_Text where FLDID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String EXPR = rs9.getString("FLDTXT");
                request.setAttribute("EXPR",EXPR);
                  }
                  
                  String sql10= "select * from Field_Text where FLDID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String EMPLNO = rs10.getString("FLDTXT");
                request.setAttribute("EMPLNO",EMPLNO);
                  }
                  
                   String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='14' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String ATST = rs12.getString("FLDTXT");
                request.setAttribute("ATST",ATST);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='15' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String EMPLNAM = rs13.getString("FLDTXT");
                request.setAttribute("EMPLNAM",EMPLNAM);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='16' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String DOBRT = rs14.getString("FLDTXT");
                request.setAttribute("DOBRT",DOBRT);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String GNDR = rs15.getString("FLDTXT");
                request.setAttribute("GNDR",GNDR);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='18' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String AGE = rs16.getString("FLDTXT");
                request.setAttribute("AGE",AGE);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='19' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String SPLNEX = rs17.getString("FLDTXT");
                request.setAttribute("SPLNEX",SPLNEX);
                  }
                  
                String sql18= "select * from Field_Text where FLDID ='20' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String ATSTDT = rs18.getString("FLDTXT");
                request.setAttribute("ATSTDT",ATSTDT);
                  }
                  
                String sql19= "select * from Field_Text where FLDID ='21' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String ATENDT = rs19.getString("FLDTXT");
                request.setAttribute("ATENDT",ATENDT);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='22' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String STRT = rs20.getString("FLDTXT");
                request.setAttribute("STRT",STRT);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='23' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CITY = rs21.getString("FLDTXT");
                request.setAttribute("CITY",CITY);
                  }
                  
                String sql22= "select * from Field_Text where FLDID ='24' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String STATE = rs22.getString("FLDTXT");
                request.setAttribute("STATE",STATE);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CONTR = rs23.getString("FLDTXT");
                request.setAttribute("CONTR",CONTR);
                  }
                  
                String sql24= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String LANGU = rs24.getString("FLDTXT");
                request.setAttribute("LANGU",LANGU);
                  }
                  
                String sql25= "select * from Field_Text where FLDID ='27' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String PSTLCOD = rs25.getString("FLDTXT");
                request.setAttribute("PSTLCOD",PSTLCOD);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='28' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String PHON = rs26.getString("FLDTXT");
                request.setAttribute("PHON",PHON);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='29' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String FAKUSU = rs27.getString("FLDTXT");
                request.setAttribute("FAKUSU",FAKUSU);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='30' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String MERU = rs28.getString("FLDTXT");
                request.setAttribute("MERU",MERU);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String GINKO = rs29.getString("FLDTXT");
                request.setAttribute("GINKO",GINKO);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='32' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String BSLRY = rs30.getString("FLDTXT");
                request.setAttribute("BSLRY",BSLRY);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='33' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String HRAL = rs31.getString("FLDTXT");
                request.setAttribute("HRAL",HRAL);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='34' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String CONAL = rs32.getString("FLDTXT");
                request.setAttribute("CONAL",CONAL);
                  }
                
                String sql33= "select * from Field_Text where FLDID ='35' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String STTBN = rs33.getString("FLDTXT");
                request.setAttribute("STTBN",STTBN);
                  }
                
                String sql34= "select * from Field_Text where FLDID ='36' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String INCENT = rs34.getString("FLDTXT");
                request.setAttribute("INCENT",INCENT);
                  }
                 
                String sql35= "select * from Field_Text where FLDID ='37' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String BOUNS = rs35.getString("FLDTXT");
                request.setAttribute("BOUNS",BOUNS);
                  }
                  
                String sql36= "select * from Field_Text where FLDID ='38' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String SOIN = rs36.getString("FLDTXT");
                request.setAttribute("SOIN",SOIN);
                  }
                  
                String sql37= "select * from Field_Text where FLDID ='39' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String HELIN = rs37.getString("FLDTXT");
                request.setAttribute("HELIN",HELIN);
                  }
                  
                String sql38= "select * from Field_Text where FLDID ='40' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String ADVNC = rs38.getString("FLDTXT");
                request.setAttribute("ADVNC",ADVNC);
                  }
                  
                String sql39= "select * from Field_Text where FLDID ='41' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String EMPF = rs39.getString("FLDTXT");
                request.setAttribute("EMPF",EMPF);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='42' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String ZEITAX = rs40.getString("FLDTXT");
                request.setAttribute("ZEITAX",ZEITAX);
                  }
                  
                String sql41= "select * from Field_Text where FLDID ='43' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String TOTDED = rs41.getString("FLDTXT");
                request.setAttribute("TOTDED",TOTDED);
                  }
                  
                String sql42= "select * from Field_Text where FLDID ='44' and LNGID ='"+weblng+"'";
                PreparedStatement pst42 = con.prepareStatement(sql42);
                ResultSet rs42 = pst42.executeQuery();
                  while(rs42.next()){
                String BILRATE = rs42.getString("FLDTXT");
                request.setAttribute("BILRATE",BILRATE);
                  }
                  
                String sql43= "select * from Field_Text where FLDID ='45' and LNGID ='"+weblng+"'";
                PreparedStatement pst43 = con.prepareStatement(sql43);
                ResultSet rs43 = pst43.executeQuery();
                  while(rs43.next()){
                String GRSSAL = rs43.getString("FLDTXT");
                request.setAttribute("GRSSAL",GRSSAL);
                  }
                  
                String sql44= "select * from Field_Text where FLDID ='46' and LNGID ='"+weblng+"'";
                PreparedStatement pst44 = con.prepareStatement(sql44);
                ResultSet rs44 = pst44.executeQuery();
                  while(rs44.next()){
                String NETSL = rs44.getString("FLDTXT");
                request.setAttribute("NETSL",NETSL);
                  }
                  
                String sql45= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst45 = con.prepareStatement(sql45);
                ResultSet rs45 = pst45.executeQuery();
                  while(rs45.next()){
                String BUSILN = rs45.getString("FLDTXT");
                request.setAttribute("BUSILN",BUSILN);
                  }
                  
                String sql46= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst46 = con.prepareStatement(sql46);
                ResultSet rs46 = pst46.executeQuery();
                  while(rs46.next()){
                String DEPMNT = rs46.getString("FLDTXT");
                request.setAttribute("DEPMNT",DEPMNT);
                  }
                  
                String sql47= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst47 = con.prepareStatement(sql47);
                ResultSet rs47 = pst47.executeQuery();
                  while(rs47.next()){
                String EMTYP = rs47.getString("FLDTXT");
                request.setAttribute("EMTYP",EMTYP);
                  }
                  
                String sql48= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst48 = con.prepareStatement(sql48);
                ResultSet rs48 = pst48.executeQuery();
                  while(rs48.next()){
                String EMRNK = rs48.getString("FLDTXT");
                request.setAttribute("EMRNK",EMRNK);
                  }
                  
                String sql49= "select * from Field_Text where FLDID ='51' and LNGID ='"+weblng+"'";
                PreparedStatement pst49 = con.prepareStatement(sql49);
                ResultSet rs49 = pst49.executeQuery();
                  while(rs49.next()){
                String RESVE = rs49.getString("FLDTXT");
                request.setAttribute("RESVE",RESVE);
                  }
                  
                String sql50= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst50 = con.prepareStatement(sql50);
                ResultSet rs50 = pst50.executeQuery();
                  while(rs50.next()){
                String MODEXPR = rs50.getString("FLDTXT");
                request.setAttribute("MODEXPR",MODEXPR);
                  }
                  
                String sql51= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst51 = con.prepareStatement(sql51);
                ResultSet rs51 = pst51.executeQuery();
                  while(rs51.next()){
                String PROLNEX = rs51.getString("FLDTXT");
                request.setAttribute("PROLNEX",PROLNEX);
                  }
                  
                String sql52= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst52 = con.prepareStatement(sql52);
                ResultSet rs52 = pst52.executeQuery();
                  while(rs52.next()){
                String EXPRSAP = rs52.getString("FLDTXT");
                request.setAttribute("EXPRSAP",EXPRSAP);
                  }
                  
                String sql53= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst53 = con.prepareStatement(sql53);
                ResultSet rs53 = pst53.executeQuery();
                  while(rs53.next()){
                String EXPRIT = rs53.getString("FLDTXT");
                request.setAttribute("EXPRIT",EXPRIT);
                  }
                  
                String sql54= "select * from Field_Text where FLDID ='56' and LNGID ='"+weblng+"'";
                PreparedStatement pst54 = con.prepareStatement(sql54);
                ResultSet rs54 = pst54.executeQuery();
                  while(rs54.next()){
                String QALIFI = rs54.getString("FLDTXT");
                request.setAttribute("QALIFI",QALIFI);
                  }
                  
                String sql55= "select * from Field_Text where FLDID ='57' and LNGID ='"+weblng+"'";
                PreparedStatement pst55 = con.prepareStatement(sql55);
                ResultSet rs55 = pst55.executeQuery();
                  while(rs55.next()){
                String EMROLE = rs55.getString("FLDTXT");
                request.setAttribute("EMROLE",EMROLE);
                  }  
                  
        request.setAttribute("weblng",weblng);
        request.setAttribute("scrn", "dis");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }    
    
    /**
     *
     * @param request
     * @param response
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @RequestMapping(value="/emplst")
    public ModelAndView employeelist(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        
        mav = new ModelAndView("emplist");
        
       
        return mav;
        
    }
    /** Employee End
    
    /**
     * Department details
     */  
    @RequestMapping(value="/depcre")
    public ModelAndView depcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DEP = rs1.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/department.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/depcha")
    public ModelAndView depcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DEP = rs1.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/department.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/depdis")
    public ModelAndView depdis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DEP = rs1.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/department.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/depdel")
    public ModelAndView depdel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DEP = rs1.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/department.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/insertdep")
    public ModelAndView insertdep(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String depId = request.getParameter("depId");
            String depName = request.getParameter("depName");
            System.out.println("depName:"+depName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Department (DPTCOD,DPT_TEXT) VALUES ('"+depId+"','"+depName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Department Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+depId+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }
                String sql6= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DEP = rs6.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/department.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updatedep")
    public ModelAndView updatedep(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String depId = request.getParameter("depId");
            String depName = request.getParameter("depName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Department set DPT_TEXT = '"+depName+"' where DPTCOD = '"+depId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Department Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +depId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DEP = rs1.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/department.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getdep")
    public ModelAndView getdep(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String depId = request.getParameter("depId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Department where DPTCOD = '"+depId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String depName = ss.getString("DPT_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("depId", depId);
                request.setAttribute("depName", depName);
                String sql1= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DEP = rs1.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/department.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/deldep")
    public ModelAndView deldep(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String depId = request.getParameter("depId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Department where DPTCOD = '"+depId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Department Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + depId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DEP = rs1.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/department.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DEP = rs1.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/department.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  

    
    /* Department Details Ends */
    
    /* Language Details starts */
    
 @RequestMapping(value="/langcre")
    public ModelAndView langcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String LAN = rs1.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/language.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/langcha")
    public ModelAndView langcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String LAN = rs1.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/language.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/langdis")
    public ModelAndView langdis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String LAN = rs1.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/language.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/langdel")
    public ModelAndView langdel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String LAN = rs1.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/language.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/insertlang")
    public ModelAndView insertlang(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String langId = request.getParameter("langId");
            String langName = request.getParameter("langName");
            System.out.println("langName:"+langName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Language_Master (LNGID,LNG_TEXT) VALUES ('"+langId+"','"+langName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Language Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+langId+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }
                String sql6= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String LAN = rs6.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/language.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updatelang")
    public ModelAndView updatelang(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String langId = request.getParameter("langId");
            String langName = request.getParameter("langName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Language_Master set LNG_TEXT = '"+langName+"' where LNGID = '"+langId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Language Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +langId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String LAN = rs1.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/language.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getlang")
    public ModelAndView getlang(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String langId = request.getParameter("langId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Language_Master where LNGID = '"+langId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String langName = ss.getString("LNG_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("langId", langId);
                request.setAttribute("langName", langName);
                String sql1= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String LAN = rs1.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/language.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/dellang")
    public ModelAndView dellang(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String langId = request.getParameter("langId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Language_Master where LNGID = '"+langId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Language Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + langId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String LAN= rs1.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/language.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String LAN = rs1.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/language.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  

   
    
  /* Programming_Language Details starts */
    
 @RequestMapping(value="/progcre")
    public ModelAndView progcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PGM = rs1.getString("FLDTXT");
                request.setAttribute("PGM",PGM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/programming.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/progcha")
    public ModelAndView progcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PGM = rs1.getString("FLDTXT");
                request.setAttribute("PGM",PGM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/programming.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/progdis")
    public ModelAndView progdis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PGM = rs1.getString("FLDTXT");
                request.setAttribute("PGM",PGM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/programming.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/insertprog")
    public ModelAndView insertprog(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String progId = request.getParameter("progId");
            String progName = request.getParameter("progName");
            System.out.println("progName:"+progName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Programming_Language (PGMLANG,PGLN_TEXT) VALUES ('"+progId+"','"+progName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Programming Language Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+progName+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                String sql5= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String PGM = rs5.getString("FLDTXT");
                request.setAttribute("PGM",PGM);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/programming.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updateprog")
    public ModelAndView updateprog(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String progId = request.getParameter("progId");
            String progName = request.getParameter("progName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Programming_Language set PGLN_TEXT = '"+progName+"' where PGMLANG = '"+progId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Programming Language Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +progId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PGM = rs1.getString("FLDTXT");
                request.setAttribute("PGM",PGM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/programming.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getprog")
    public ModelAndView getprog(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String progId = request.getParameter("progId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Programming_Language where PGMLANG = '"+progId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String progName = ss.getString("PGLN_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("progId", progId);
                request.setAttribute("progName", progName);
                String sql1= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PGM = rs1.getString("FLDTXT");
                request.setAttribute("PGM",PGM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/programming.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    }
@RequestMapping(value="/delprog")
    public ModelAndView delprog(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String progId = request.getParameter("progId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Programming_Language where PGMLANG = '"+progId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Programming Language ID Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + progId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PGM = rs1.getString("FLDTXT");
                request.setAttribute("PGM",PGM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/programming.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PGM= rs1.getString("FLDTXT");
                request.setAttribute("PGM",PGM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/programming.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  
    
/* Module Details starts */
    
 @RequestMapping(value="/modcre")
    public ModelAndView modcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String MOD = rs1.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/module.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/modcha")
    public ModelAndView modcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String MOD = rs1.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/module.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/moddis")
    public ModelAndView moddis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String MOD = rs1.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/module.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/insertmod")
    public ModelAndView insertmod(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String modId = request.getParameter("modId");
            String modName = request.getParameter("modName");
            System.out.println("modName:"+modName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Module (MODUL,MOD_TEXT) VALUES ('"+modId+"','"+modName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Module Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+modName+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                String sql5= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String MOD = rs5.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/module.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updatemod")
    public ModelAndView updatemod(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String modId = request.getParameter("modId");
            String modName = request.getParameter("modName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Module set MOD_TEXT = '"+modName+"' where MODUL = '"+modId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Module Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +modId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String MOD = rs1.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/module.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getmod")
    public ModelAndView getmod(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String modId = request.getParameter("modId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Module where MODUL = '"+modId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String modName = ss.getString("MOD_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("modId", modId);
                request.setAttribute("modName", modName);
                String sql1= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String MOD = rs1.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/module.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    }
@RequestMapping(value="/delmod")
    public ModelAndView delmod(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String modId = request.getParameter("modId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Module where MODUL = '"+modId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Module ID Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + modId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String MOD = rs1.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/module.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String MOD = rs1.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/module.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  
    
/* Payment Terms Details starts */
    
 @RequestMapping(value="/paycre")
    public ModelAndView paycre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PAY = rs1.getString("FLDTXT");
                request.setAttribute("PAY",PAY);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/payment.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/paycha")
    public ModelAndView paycha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PAY = rs1.getString("FLDTXT");
                request.setAttribute("PAY",PAY);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/payment.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/paydis")
    public ModelAndView paydis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PAY = rs1.getString("FLDTXT");
                request.setAttribute("PAY",PAY);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/payment.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/insertpay")
    public ModelAndView insertpay(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String payId = request.getParameter("payId");
            String payName = request.getParameter("payName");
            System.out.println("payName:"+payName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Payment_Terms (PAYTRMS,PAYTXT) VALUES ('"+payId+"','"+payName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Payment Terms Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+payId+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                String sql5= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String PAY = rs5.getString("FLDTXT");
                request.setAttribute("PAY",PAY);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/payment.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updatepay")
    public ModelAndView updatepay(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String payId = request.getParameter("payId");
            String payName = request.getParameter("payName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Payment_Terms set PAYTXT = '"+payName+"' where PAYTRMS = '"+payId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Payment Terms Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +payId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PAY = rs1.getString("FLDTXT");
                request.setAttribute("PAY",PAY);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/payment.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getpay")
    public ModelAndView getpay(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String payId = request.getParameter("payId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Payment_Terms where PAYTRMS  = '"+payId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String payName = ss.getString("PAYTXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("payId", payId);
                request.setAttribute("payName", payName);
                String sql1= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PAY = rs1.getString("FLDTXT");
                request.setAttribute("PAY",PAY);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/payment.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/delpay")
    public ModelAndView delpay(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String payId = request.getParameter("payId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Payment_Terms where PAYTRMS = '"+payId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Payment Terms ID Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + payId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PAY = rs1.getString("FLDTXT");
                request.setAttribute("PAY",PAY);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/payment.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PAY = rs1.getString("FLDTXT");
                request.setAttribute("PAY",PAY);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/payment.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  
   
/* Gender Details Starts */
    
 @RequestMapping(value="/gencre")
    public ModelAndView gencre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String GEN = rs1.getString("FLDTXT");
                request.setAttribute("GEN",GEN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/gender.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/gencha")
    public ModelAndView gencha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String GEN = rs1.getString("FLDTXT");
                request.setAttribute("GEN",GEN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/gender.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/gendis")
    public ModelAndView gendis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String GEN = rs1.getString("FLDTXT");
                request.setAttribute("GEN",GEN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/gender.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/gendel")
    public ModelAndView gendel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String GEN = rs1.getString("FLDTXT");
                request.setAttribute("GEN",GEN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/gender.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/insertgen")
    public ModelAndView insertgen(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String genId = request.getParameter("genId");
            String genName = request.getParameter("genName");
            System.out.println("genName:"+genName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Gender (GENDER,GEN_TEXT) VALUES ('"+genId+"','"+genName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Gender Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+genId+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }
                String sql6= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String GEN = rs6.getString("FLDTXT");
                request.setAttribute("GEN",GEN);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/gender.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updategen")
    public ModelAndView updategen(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String genId = request.getParameter("genId");
            String genName = request.getParameter("genName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Gender set GEN_TEXT = '"+genName+"' where GENDER = '"+genId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Payment Terms Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +genId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String GEN = rs1.getString("FLDTXT");
                request.setAttribute("GEN",GEN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/gender.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getgen")
    public ModelAndView getgen(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String genId = request.getParameter("genId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Gender where GENDER = '"+genId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String genName = ss.getString("GEN_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("genId", genId);
                request.setAttribute("genName", genName);
                String sql1= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String GEN = rs1.getString("FLDTXT");
                request.setAttribute("GEN",GEN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/gender.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/delgen")
    public ModelAndView delgen(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String genId = request.getParameter("genId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Gender where GENDER = '"+genId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Gender ID Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + genId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String GEN = rs1.getString("FLDTXT");
                request.setAttribute("GEN",GEN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/gender.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String GEN = rs1.getString("FLDTXT");
                request.setAttribute("GEN",GEN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/gender.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  
/* Rank Details Starts */
    
 @RequestMapping(value="/rancre")
    public ModelAndView rancre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String RAN = rs1.getString("FLDTXT");
                request.setAttribute("RAN",RAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/rank.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/rancha")
    public ModelAndView rancha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String RAN = rs1.getString("FLDTXT");
                request.setAttribute("RAN",RAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/rank.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/randis")
    public ModelAndView randis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String RAN = rs1.getString("FLDTXT");
                request.setAttribute("RAN",RAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/rank.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/randel")
    public ModelAndView randel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String RAN = rs1.getString("FLDTXT");
                request.setAttribute("RAN",RAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/rank.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/insertran")
    public ModelAndView insertran(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String ranId = request.getParameter("ranId");
            String ranName = request.getParameter("ranName");
            System.out.println("ranName:"+ranName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Rank_emp (RANKCOD,RNK_TEXT) VALUES ('"+ranId+"','"+ranName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Rank Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+ranId+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }
                String sql6= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String RAN = rs6.getString("FLDTXT");
                request.setAttribute("RAN",RAN);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/rank.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updateran")
    public ModelAndView updateran(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String ranId = request.getParameter("ranId");
            String ranName = request.getParameter("ranName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Rank_emp set RNK_TEXT = '"+ranName+"' where RANKCOD = '"+ranId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Rank Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +ranId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String RAN = rs1.getString("FLDTXT");
                request.setAttribute("RAN",RAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/rank.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getran")
    public ModelAndView getran(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String ranId = request.getParameter("ranId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Rank_emp where RANKCOd = '"+ranId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String ranName = ss.getString("RNK_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("ranId", ranId);
                request.setAttribute("ranName", ranName);
                String sql1= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String RAN = rs1.getString("FLDTXT");
                request.setAttribute("RAN",RAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/rank.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/delran")
    public ModelAndView delran(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String ranId = request.getParameter("ranId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Rank_emp where RANKCOD = '"+ranId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Rank ID Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + ranId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String RAN = rs1.getString("FLDTXT");
                request.setAttribute("RAN",RAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/rank.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String RAN = rs1.getString("FLDTXT");
                request.setAttribute("RAN",RAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/rank.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  
/* Country Details Starts */
    
 @RequestMapping(value="/concre")
    public ModelAndView concre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CON = rs1.getString("FLDTXT");
                request.setAttribute("CON",CON);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/country.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/concha")
    public ModelAndView concha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CON = rs1.getString("FLDTXT");
                request.setAttribute("CON",CON);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/country.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/condis")
    public ModelAndView condis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CON = rs1.getString("FLDTXT");
                request.setAttribute("CON",CON);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/country.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/condel")
    public ModelAndView condel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CON = rs1.getString("FLDTXT");
                request.setAttribute("CON",CON);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/country.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/insertcon")
    public ModelAndView insertcon(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String conId = request.getParameter("conId");
            String conName = request.getParameter("conName");
            System.out.println("conName:"+conName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Country (COUNTRY,CNTR_TEXT) VALUES ('"+conId+"','"+conName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Rank Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+conId+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }
                String sql6= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String CON = rs6.getString("FLDTXT");
                request.setAttribute("CON",CON);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/country.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updatecon")
    public ModelAndView updatecon(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String conId = request.getParameter("conId");
            String conName = request.getParameter("conName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Country set CNTR_TEXT = '"+conName+"' where COUNTRY = '"+conId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Country Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +conId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CON = rs1.getString("FLDTXT");
                request.setAttribute("CON",CON);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/country.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getcon")
    public ModelAndView getcon(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String conId = request.getParameter("conId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Country where COUNTRY = '"+conId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String conName = ss.getString("CNTR_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("conId", conId);
                request.setAttribute("conName", conName);
                String sql1= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CON = rs1.getString("FLDTXT");
                request.setAttribute("CON",CON);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/country.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/delcon")
    public ModelAndView delcon(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String conId = request.getParameter("conId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Country where COUNTRY = '"+conId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Country ID Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + conId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CON = rs1.getString("FLDTXT");
                request.setAttribute("CON",CON);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/country.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CON = rs1.getString("FLDTXT");
                request.setAttribute("CON",CON);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/country.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  
/* Phase Details Starts */
    
 @RequestMapping(value="/phacre")
    public ModelAndView phacre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PHA = rs1.getString("FLDTXT");
                request.setAttribute("PHA",PHA);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/phase.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/phacha")
    public ModelAndView phacha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PHA = rs1.getString("FLDTXT");
                request.setAttribute("PHA",PHA);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/phase.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/phadis")
    public ModelAndView phadis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PHA = rs1.getString("FLDTXT");
                request.setAttribute("PHA",PHA);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/phase.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/phadel")
    public ModelAndView phadel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PHA = rs1.getString("FLDTXT");
                request.setAttribute("PHA",PHA);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/phase.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/insertpha")
    public ModelAndView insertpha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String phaId = request.getParameter("phaId");
            String phaName = request.getParameter("phaName");
            System.out.println("phaName:"+phaName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Phase (PHASEID,PHASE) VALUES ('"+phaId+"','"+phaName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Phase Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+phaId+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }
                String sql6= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String PHA = rs6.getString("FLDTXT");
                request.setAttribute("PHA",PHA);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/phase.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updatepha")
    public ModelAndView updatepha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String phaId = request.getParameter("phaId");
            String phaName = request.getParameter("phaName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Phase set PHASE = '"+phaName+"' where PHASEID = '"+phaId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Phase Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +phaId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PHA = rs1.getString("FLDTXT");
                request.setAttribute("PHA",PHA);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/phase.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getpha")
    public ModelAndView getpha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String phaId = request.getParameter("phaId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Phase where PHASEID = '"+phaId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String phaName = ss.getString("PHASE");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("phaId", phaId);
                request.setAttribute("phaName", phaName);
                String sql1= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PHA = rs1.getString("FLDTXT");
                request.setAttribute("PHA",PHA);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/phase.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/delpha")
    public ModelAndView delpha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String phaId = request.getParameter("phaId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Phase where PHASEID = '"+phaId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Phase Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + phaId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PHA = rs1.getString("FLDTXT");
                request.setAttribute("PHA",PHA);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/phase.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String PHA = rs1.getString("FLDTXT");
                request.setAttribute("PHA",PHA);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/phase.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  
/* Phase Details End */
/* Bank Details Starts */

 @RequestMapping(value="/bancre")
    public ModelAndView bancre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BAN = rs1.getString("FLDTXT");
                request.setAttribute("BAN",BAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/bank.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/bancha")
    public ModelAndView bancha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BAN = rs1.getString("FLDTXT");
                request.setAttribute("BAN",BAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/bank.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/bandis")
    public ModelAndView bandis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BAN = rs1.getString("FLDTXT");
                request.setAttribute("BAN",BAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/bank.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/bandel")
    public ModelAndView bandel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BAN = rs1.getString("FLDTXT");
                request.setAttribute("BAN",BAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/bank.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/insertban")
    public ModelAndView insertban(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String banId = request.getParameter("banId");
            String banName = request.getParameter("banName");
            System.out.println("banName:"+banName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Bank (BANCOD,BNK_TEXT) VALUES ('"+banId+"','"+banName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Bank Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+banId+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }
                String sql6= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BAN = rs6.getString("FLDTXT");
                request.setAttribute("BAN",BAN);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/bank.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updateban")
    public ModelAndView updateban(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String banId = request.getParameter("banId");
            String banName = request.getParameter("banName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Bank set BNK_TEXT = '"+banName+"' where BANCOD = '"+banId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Bank Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +banId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BAN = rs1.getString("FLDTXT");
                request.setAttribute("BAN",BAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/bank.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getban")
    public ModelAndView getban(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String banId = request.getParameter("banId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Bank where BANCOD = '"+banId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String banName = ss.getString("BNK_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("banId", banId);
                request.setAttribute("banName", banName);
                String sql1= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BAN = rs1.getString("FLDTXT");
                request.setAttribute("BAN",BAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/bank.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/delban")
    public ModelAndView delban(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String banId = request.getParameter("banId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Bank where BANCOD = '"+banId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Bank Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + banId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BAN = rs1.getString("FLDTXT");
                request.setAttribute("BAN",BAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/bank.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BAN = rs1.getString("FLDTXT");
                request.setAttribute("BAN",BAN);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/bank.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }   
/* Bank Details End */
/* Deliverables Details Starts */

 @RequestMapping(value="/dblcre")
    public ModelAndView dblcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DBL = rs1.getString("FLDTXT");
                request.setAttribute("DBL",DBL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deliverables.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/dblcha")
    public ModelAndView dblcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DBL = rs1.getString("FLDTXT");
                request.setAttribute("DBL",DBL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deliverables.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/dbldis")
    public ModelAndView dbldis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DBL = rs1.getString("FLDTXT");
                request.setAttribute("DBL",DBL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deliverables.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/dbldel")
    public ModelAndView dbldel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DBL = rs1.getString("FLDTXT");
                request.setAttribute("DBL",DBL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deliverables.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }

@RequestMapping(value="/back11")
    public ModelAndView back11(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
         String scrn = request.getParameter("scrn");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
              String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                  String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }  
                  
                 /**
                 * Department Details
                 */
                String sql6= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DEP = rs6.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                  }
             /** 
              * Language Details
              */   
                String sql7= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String LAN = rs7.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }    
               /* Programming_Language Details*/
                String sql8= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String PGM = rs8.getString("FLDTXT");
                request.setAttribute("PGM",PGM); 
                  }
                /* Module Details*/
                String sql9= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String MOD = rs9.getString("FLDTXT");
                request.setAttribute("MOD",MOD); 
                  }
                 /* Payment terms Details*/
                String sql10= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PAY = rs10.getString("FLDTXT");
                request.setAttribute("PAY",PAY); 
                  }
                  /* Gender Details Details*/
                String sql11= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String GEN = rs11.getString("FLDTXT");
                request.setAttribute("GEN",GEN); 
                  }
                   /* Rank Details Details*/
                String sql12= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String RAN = rs12.getString("FLDTXT");
                request.setAttribute("RAN",RAN); 
                  }
                  /* Country Details Details*/
                String sql13= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CON = rs13.getString("FLDTXT");
                request.setAttribute("CON",CON); 
                  }
                  /* Phase Details Details*/
                String sql14= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PHA = rs14.getString("FLDTXT");
                request.setAttribute("PHA",PHA); 
                  }
                   /* Bank Details Details*/
                String sql15= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BAN = rs15.getString("FLDTXT");
                request.setAttribute("BAN",BAN); 
                  }
                  /* Deliverables Details Details*/
                String sql16= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String DBL = rs16.getString("FLDTXT");
                request.setAttribute("DBL",DBL); 
                  }
                 /* Delivery Place  Details Details*/
                String sql17= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String DLC = rs17.getString("FLDTXT");
                request.setAttribute("DLC",DLC); 
                  }
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
                
                  
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
@RequestMapping(value="/insertdbl")
    public ModelAndView insertdbl(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String dblId = request.getParameter("dblId");
            String dblName = request.getParameter("dblName");
            System.out.println("dblName:"+dblName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Deliverables (DELVRBLID,DELVRBLS) VALUES ('"+dblId+"','"+dblName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Deliverables Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+dblId+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }
                String sql6= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DBL = rs6.getString("FLDTXT");
                request.setAttribute("DBL",DBL);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deliverables.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updatedbl")
    public ModelAndView updatedbl(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String dblId = request.getParameter("dblId");
            String dblName = request.getParameter("dblName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Deliverables set DELVRBLS = '"+dblName+"' where DELVRBLID = '"+dblId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Deliverables Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +dblId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DBL = rs1.getString("FLDTXT");
                request.setAttribute("DBL",DBL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deliverables.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getdbl")
    public ModelAndView getdbl(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String dblId = request.getParameter("dblId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Deliverables where DELVRBLID = '"+dblId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String dblName = ss.getString("DELVRBLS");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("dblId", dblId);
                request.setAttribute("dblName", dblName);
                String sql1= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DBL = rs1.getString("FLDTXT");
                request.setAttribute("DBL",DBL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deliverables.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/deldbl")
    public ModelAndView deldbl(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String dblId = request.getParameter("dblId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Deliverables where DELVRBLID = '"+dblId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Deliverables Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + dblId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DBL = rs1.getString("FLDTXT");
                request.setAttribute("DBL",DBL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deliverables.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DBL = rs1.getString("FLDTXT");
                request.setAttribute("DBL",DBL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/deliverables.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }   
/* Deliverables Details End */
/* Delivery Location Details starts */
 @RequestMapping(value="/dlccre")
    public ModelAndView dlccre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DLC = rs1.getString("FLDTXT");
                request.setAttribute("DLC",DLC);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/delivery.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/dlccha")
    public ModelAndView dlccha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DLC = rs1.getString("FLDTXT");
                request.setAttribute("DLC",DLC);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/delivery.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/dlcdis")
    public ModelAndView dlcdis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DLC = rs1.getString("FLDTXT");
                request.setAttribute("DLC",DLC);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/delivery.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/dlcdel")
    public ModelAndView dlcdel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DLC = rs1.getString("FLDTXT");
                request.setAttribute("DLC",DLC);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/delivery.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/back12")
    public ModelAndView back12(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
         String scrn = request.getParameter("scrn");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                  String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }  
                  
                 /**
                 * Department Details
                 */
                String sql6= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DEP = rs6.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                  }
             /** 
              * Language Details
              */   
                String sql7= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String LAN = rs7.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }    
               /* Programming_Language Details*/
                String sql8= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String PGM = rs8.getString("FLDTXT");
                request.setAttribute("PGM",PGM); 
                  }
                /* Module Details*/
                String sql9= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String MOD = rs9.getString("FLDTXT");
                request.setAttribute("MOD",MOD); 
                  }
                 /* Payment terms Details*/
                String sql10= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PAY = rs10.getString("FLDTXT");
                request.setAttribute("PAY",PAY); 
                  }
                  /* Gender Details Details*/
                String sql11= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String GEN = rs11.getString("FLDTXT");
                request.setAttribute("GEN",GEN); 
                  }
                   /* Rank Details Details*/
                String sql12= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String RAN = rs12.getString("FLDTXT");
                request.setAttribute("RAN",RAN); 
                  }
                  /* Country Details Details*/
                String sql13= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CON = rs13.getString("FLDTXT");
                request.setAttribute("CON",CON); 
                  }
                  /* Phase Details Details*/
                String sql14= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PHA = rs14.getString("FLDTXT");
                request.setAttribute("PHA",PHA); 
                  }
                   /* Bank Details Details*/
                String sql15= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BAN = rs15.getString("FLDTXT");
                request.setAttribute("BAN",BAN); 
                  }
                  /* Deliverables Details Details*/
                String sql16= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String DBL = rs16.getString("FLDTXT");
                request.setAttribute("DBL",DBL); 
                  }
                 /* Delivery Place  Details Details*/
                String sql17= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String DLC = rs17.getString("FLDTXT");
                request.setAttribute("DLC",DLC); 
                  }
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
                
                  
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
                    
@RequestMapping(value="/insertdlc")
    public ModelAndView insertdlc(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String dlcId = request.getParameter("dlcId");
            String dlcName = request.getParameter("dlcName");
            System.out.println("dlcName:"+dlcName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Delivery_Place (DELLOCID,DELLOC) VALUES ('"+dlcId+"','"+dlcName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Delivery Place Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+dlcId+" Created Successfully");
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }
                String sql6= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DLC = rs6.getString("FLDTXT");
                request.setAttribute("DLC",DLC);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/delivery.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updatedlc")
    public ModelAndView updatedlc(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String dlcId = request.getParameter("dlcId");
            String dlcName = request.getParameter("dlcName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Delivery_Place set DELLOC = '"+dlcName+"' where DELLOCID = '"+dlcId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Delivery Place Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +dlcId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DLC = rs1.getString("FLDTXT");
                request.setAttribute("DLC",DLC);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/delivery.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getdlc")
    public ModelAndView getdlc(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String dlcId = request.getParameter("dlcId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Delivery_Place where DELLOCID = '"+dlcId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String dlcName = ss.getString("DELLOC");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("dlcId", dlcId);
                request.setAttribute("dlcName", dlcName);
                String sql1= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DLC = rs1.getString("FLDTXT");
                request.setAttribute("DLC",DLC);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/delivery.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/deldlc")
    public ModelAndView deldlc(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String dlcId = request.getParameter("dlcId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Delivery_Place where DELLOCID = '"+dlcId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Delivery Place Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + dlcId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DLC = rs1.getString("FLDTXT");
                request.setAttribute("DLC",DLC);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/delivery.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String DLC = rs1.getString("FLDTXT");
                request.setAttribute("DLC",DLC);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/delivery.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }   
/* Business Line Details starts */
 @RequestMapping(value="/bizcre")
    public ModelAndView bizcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BIZ = rs1.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/business.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/bizcha")
    public ModelAndView bizcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BIZ = rs1.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/business.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/bizdis")
    public ModelAndView bizdis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BIZ = rs1.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/business.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/bizdel")
    public ModelAndView bizdel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BIZ= rs1.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/business.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/back13")
    public ModelAndView back13(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
         String scrn = request.getParameter("scrn");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                  String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }  
                  
                 /**
                 * Department Details
                 */
                String sql6= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DEP = rs6.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                  }
             /** 
              * Language Details
              */   
                String sql7= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String LAN = rs7.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }    
               /* Programming_Language Details*/
                String sql8= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String PGM = rs8.getString("FLDTXT");
                request.setAttribute("PGM",PGM); 
                  }
                /* Module Details*/
                String sql9= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String MOD = rs9.getString("FLDTXT");
                request.setAttribute("MOD",MOD); 
                  }
                 /* Payment terms Details*/
                String sql10= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PAY = rs10.getString("FLDTXT");
                request.setAttribute("PAY",PAY); 
                  }
                  /* Gender Details Details*/
                String sql11= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String GEN = rs11.getString("FLDTXT");
                request.setAttribute("GEN",GEN); 
                  }
                   /* Rank Details Details*/
                String sql12= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String RAN = rs12.getString("FLDTXT");
                request.setAttribute("RAN",RAN); 
                  }
                  /* Country Details Details*/
                String sql13= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CON = rs13.getString("FLDTXT");
                request.setAttribute("CON",CON); 
                  }
                  /* Phase Details Details*/
                String sql14= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PHA = rs14.getString("FLDTXT");
                request.setAttribute("PHA",PHA); 
                  }
                   /* Bank Details Details*/
                String sql15= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BAN = rs15.getString("FLDTXT");
                request.setAttribute("BAN",BAN); 
                  }
                  /* Deliverables Details Details*/
                String sql16= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String DBL = rs16.getString("FLDTXT");
                request.setAttribute("DBL",DBL); 
                  }
                 /* Delivery Place  Details Details*/
                String sql17= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String DLC = rs17.getString("FLDTXT");
                request.setAttribute("DLC",DLC); 
                  }
                /* Business Line Details*/
                String sql18= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BIZ = rs18.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ); 
                  }
                /* Business Line Details*/
                String sql19= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EMT = rs19.getString("FLDTXT");
                request.setAttribute("EMT",EMT); 
                  }
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
                
                  
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
                    
@RequestMapping(value="/insertbiz")
    public ModelAndView insertbiz(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String bizId = request.getParameter("bizId");
            String bizName = request.getParameter("bizName");
            System.out.println("bizName:"+bizName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Business_Line (BIZID,BIZ_TEXT) VALUES ('"+bizId+"','"+bizName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Business Line Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+bizId+" Created Successfully");
                  String sql1= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BIZ = rs1.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
            /*    String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                  }
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }
                String sql6= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DLC = rs6.getString("FLDTXT");
                request.setAttribute("DLC",DLC); 
                  } */
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/business.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updatebiz")
    public ModelAndView updatebiz(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String bizId = request.getParameter("bizId");
            String bizName = request.getParameter("bizName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Business_Line set BIZ_TEXT = '"+bizName+"' where BIZID = '"+bizId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Delivery Place Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +bizId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BIZ = rs1.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/business.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getbiz")
    public ModelAndView getbiz(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String bizId = request.getParameter("bizId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Business_Line where BIZID = '"+bizId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String bizName = ss.getString("BIZ_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("bizId", bizId);
                request.setAttribute("bizName", bizName);
                String sql1= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BIZ = rs1.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/business.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/delbiz")
    public ModelAndView delbiz(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String bizId = request.getParameter("bizId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Business_Line where BIZID = '"+bizId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Business Line Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + bizId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BIZ = rs1.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/business.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String BIZ = rs1.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/business.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }   
/* Employee Type Details starts */
 @RequestMapping(value="/emtcre")
    public ModelAndView emtcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String EMT = rs1.getString("FLDTXT");
                request.setAttribute("EMT",EMT);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/emptype.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/emtcha")
    public ModelAndView emtcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String EMT = rs1.getString("FLDTXT");
                request.setAttribute("EMT",EMT);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/emptype.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/emtdis")
    public ModelAndView emtdis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String EMT = rs1.getString("FLDTXT");
                request.setAttribute("EMT",EMT);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/emptype.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/emtdel")
    public ModelAndView emtdel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String EMT= rs1.getString("FLDTXT");
                request.setAttribute("EMT",EMT);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/emptype.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/back14")
    public ModelAndView back14(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
         String scrn = request.getParameter("scrn");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                  String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }  
                  
                 /**
                 * Department Details
                 */
                String sql6= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DEP = rs6.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                  }
             /** 
              * Language Details
              */   
                String sql7= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String LAN = rs7.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }    
               /* Programming_Language Details*/
                String sql8= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String PGM = rs8.getString("FLDTXT");
                request.setAttribute("PGM",PGM); 
                  }
                /* Module Details*/
                String sql9= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String MOD = rs9.getString("FLDTXT");
                request.setAttribute("MOD",MOD); 
                  }
                 /* Payment terms Details*/
                String sql10= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PAY = rs10.getString("FLDTXT");
                request.setAttribute("PAY",PAY); 
                  }
                  /* Gender Details Details*/
                String sql11= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String GEN = rs11.getString("FLDTXT");
                request.setAttribute("GEN",GEN); 
                  }
                   /* Rank Details Details*/
                String sql12= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String RAN = rs12.getString("FLDTXT");
                request.setAttribute("RAN",RAN); 
                  }
                  /* Country Details Details*/
                String sql13= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CON = rs13.getString("FLDTXT");
                request.setAttribute("CON",CON); 
                  }
                  /* Phase Details Details*/
                String sql14= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PHA = rs14.getString("FLDTXT");
                request.setAttribute("PHA",PHA); 
                  }
                   /* Bank Details Details*/
                String sql15= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BAN = rs15.getString("FLDTXT");
                request.setAttribute("BAN",BAN); 
                  }
                  /* Deliverables Details Details*/
                String sql16= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String DBL = rs16.getString("FLDTXT");
                request.setAttribute("DBL",DBL); 
                  }
                 /* Delivery Place  Details Details*/
                String sql17= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String DLC = rs17.getString("FLDTXT");
                request.setAttribute("DLC",DLC); 
                  }
                /* Business Line Details*/
                String sql18= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BIZ = rs18.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ); 
                  }
                /* Employee type Details*/
                String sql19= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EMT = rs19.getString("FLDTXT");
                request.setAttribute("EMT",EMT); 
                  }
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
                
                  
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
                    
@RequestMapping(value="/insertemt")
    public ModelAndView insertemt(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String emtId = request.getParameter("emtId");
            String emtName = request.getParameter("emtName");
            System.out.println("emtName:"+emtName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Employee_Type (EMPTYP,EMTY_TEXT) VALUES ('"+emtId+"','"+emtName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Employee Type Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+emtId+" Created Successfully");
                  String sql1= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String EMT = rs1.getString("FLDTXT");
                request.setAttribute("EMT",EMT);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/emptype.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updateemt")
    public ModelAndView updateemt(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String emtId = request.getParameter("emtId");
            String emtName = request.getParameter("emtName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Employee_Type set EMTY_TEXT = '"+emtName+"' where EMPTYP = '"+emtId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Employee Type Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +emtId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String EMT = rs1.getString("FLDTXT");
                request.setAttribute("EMT",EMT);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/emptype.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getemt")
    public ModelAndView getemt(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String emtId = request.getParameter("emtId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Employee_Type where EMPTYP = '"+emtId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String emtName = ss.getString("EMTY_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("emtId", emtId);
                request.setAttribute("emtName", emtName);
                String sql1= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String EMT = rs1.getString("FLDTXT");
                request.setAttribute("EMT",EMT);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/emptype.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/delemt")
    public ModelAndView delemt(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String emtId = request.getParameter("emtId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Employee_Type where EMPTYP = '"+emtId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Employee Type Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + emtId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String EMT = rs1.getString("FLDTXT");
                request.setAttribute("EMT",EMT);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/emptype.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String EMT = rs1.getString("FLDTXT");
                request.setAttribute("EMT",EMT);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/emptype.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }   
/* Role Master Details starts */
 @RequestMapping(value="/rolcre")
    public ModelAndView rolcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String ROL = rs1.getString("FLDTXT");
                request.setAttribute("ROL",ROL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/role.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/rolcha")
    public ModelAndView rolcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String ROL = rs1.getString("FLDTXT");
                request.setAttribute("ROL",ROL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/role.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/roldis")
    public ModelAndView roldis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String ROL = rs1.getString("FLDTXT");
                request.setAttribute("ROL",ROL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/role.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/roldel")
    public ModelAndView roldel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String ROL= rs1.getString("FLDTXT");
                request.setAttribute("ROL",ROL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/role.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/back15")
    public ModelAndView back15(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
         String scrn = request.getParameter("scrn");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                  String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }  
                  
                 /**
                 * Department Details
                 */
                String sql6= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DEP = rs6.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                  }
             /** 
              * Language Details
              */   
                String sql7= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String LAN = rs7.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }    
               /* Programming_Language Details*/
                String sql8= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String PGM = rs8.getString("FLDTXT");
                request.setAttribute("PGM",PGM); 
                  }
                /* Module Details*/
                String sql9= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String MOD = rs9.getString("FLDTXT");
                request.setAttribute("MOD",MOD); 
                  }
                 /* Payment terms Details*/
                String sql10= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PAY = rs10.getString("FLDTXT");
                request.setAttribute("PAY",PAY); 
                  }
                  /* Gender Details Details*/
                String sql11= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String GEN = rs11.getString("FLDTXT");
                request.setAttribute("GEN",GEN); 
                  }
                   /* Rank Details Details*/
                String sql12= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String RAN = rs12.getString("FLDTXT");
                request.setAttribute("RAN",RAN); 
                  }
                  /* Country Details Details*/
                String sql13= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CON = rs13.getString("FLDTXT");
                request.setAttribute("CON",CON); 
                  }
                  /* Phase Details Details*/
                String sql14= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PHA = rs14.getString("FLDTXT");
                request.setAttribute("PHA",PHA); 
                  }
                   /* Bank Details Details*/
                String sql15= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BAN = rs15.getString("FLDTXT");
                request.setAttribute("BAN",BAN); 
                  }
                  /* Deliverables Details Details*/
                String sql16= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String DBL = rs16.getString("FLDTXT");
                request.setAttribute("DBL",DBL); 
                  }
                 /* Delivery Place  Details Details*/
                String sql17= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String DLC = rs17.getString("FLDTXT");
                request.setAttribute("DLC",DLC); 
                  }
                /* Business Line Details*/
                String sql18= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BIZ = rs18.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ); 
                  }
                /* Employee type Details*/
                String sql19= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EMT = rs19.getString("FLDTXT");
                request.setAttribute("EMT",EMT); 
                  }
                /* Role Master Details*/
                String sql20= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ROL = rs20.getString("FLDTXT");
                request.setAttribute("ROL",ROL); 
                  }
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
                
                  
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
                    
@RequestMapping(value="/insertrol")
    public ModelAndView insertrol(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String rolId = request.getParameter("rolId");
            String rolName = request.getParameter("rolName");
            System.out.println("rolName:"+rolName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Role_Master (ROLEID,ROLE_TEXT) VALUES ('"+rolId+"','"+rolName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Role Master Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+rolId+" Created Successfully");
                  String sql1= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String ROL = rs1.getString("FLDTXT");
                request.setAttribute("ROL",ROL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/role.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updaterol")
    public ModelAndView updaterol(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String rolId = request.getParameter("rolId");
            String rolName = request.getParameter("rolName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Role_Master set ROLE_TEXT = '"+rolName+"' where ROLEID = '"+rolId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Role Master Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +rolId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String ROL = rs1.getString("FLDTXT");
                request.setAttribute("ROL",ROL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/role.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getrol")
    public ModelAndView getrol(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String rolId = request.getParameter("rolId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Role_Master where ROLEID = '"+rolId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String rolName = ss.getString("ROLE_TEXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("rolId", rolId);
                request.setAttribute("rolName", rolName);
                String sql1= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String ROL = rs1.getString("FLDTXT");
                request.setAttribute("ROL",ROL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/role.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/delrol")
    public ModelAndView delrol(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String rolId = request.getParameter("rolId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Role_Master where ROLEID = '"+rolId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Role Master Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + rolId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String ROL = rs1.getString("FLDTXT");
                request.setAttribute("ROL",ROL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/role.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String ROL = rs1.getString("FLDTXT");
                request.setAttribute("ROL",ROL);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/role.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  
    
/* Company Code Detail starts */
 @RequestMapping(value="/comcre")
    public ModelAndView comcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String COM = rs1.getString("FLDTXT");
                request.setAttribute("COM",COM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            String sql6= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BSDT = rs6.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
            String sql20= "select * from Field_Text where FLDID ='22' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String STRT = rs20.getString("FLDTXT");
                request.setAttribute("STRT",STRT);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='23' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CITY = rs21.getString("FLDTXT");
                request.setAttribute("CITY",CITY);
                  }
                  
                String sql22= "select * from Field_Text where FLDID ='24' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String STATE = rs22.getString("FLDTXT");
                request.setAttribute("STATE",STATE);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CONTR = rs23.getString("FLDTXT");
                request.setAttribute("CONTR",CONTR);
                  }
                  
                String sql24= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String LANGU = rs24.getString("FLDTXT");
                request.setAttribute("LANGU",LANGU);
                  }
                  
                String sql25= "select * from Field_Text where FLDID ='27' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String PSTLCOD = rs25.getString("FLDTXT");
                request.setAttribute("PSTLCOD",PSTLCOD);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='28' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String PHON = rs26.getString("FLDTXT");
                request.setAttribute("PHON",PHON);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='29' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String FAKUSU = rs27.getString("FLDTXT");
                request.setAttribute("FAKUSU",FAKUSU);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='30' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String MERU = rs28.getString("FLDTXT");
                request.setAttribute("MERU",MERU);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String GINKO = rs29.getString("FLDTXT");
                request.setAttribute("GINKO",GINKO);
                  }
                String sql30= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CUR = rs30.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
                String sql31= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String TAX = rs31.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                  
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/compcode.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/comcha")
    public ModelAndView comcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String COM = rs1.getString("FLDTXT");
                request.setAttribute("COM",COM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/compcode.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/comdis")
    public ModelAndView comdis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String COM = rs1.getString("FLDTXT");
                request.setAttribute("COM",COM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            String sql6= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BSDT = rs6.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
            String sql20= "select * from Field_Text where FLDID ='22' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String STRT = rs20.getString("FLDTXT");
                request.setAttribute("STRT",STRT);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='23' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CITY = rs21.getString("FLDTXT");
                request.setAttribute("CITY",CITY);
                  }
                  
                String sql22= "select * from Field_Text where FLDID ='24' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String STATE = rs22.getString("FLDTXT");
                request.setAttribute("STATE",STATE);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CONTR = rs23.getString("FLDTXT");
                request.setAttribute("CONTR",CONTR);
                  }
                  
                String sql24= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String LANGU = rs24.getString("FLDTXT");
                request.setAttribute("LANGU",LANGU);
                  }
                  
                String sql25= "select * from Field_Text where FLDID ='27' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String PSTLCOD = rs25.getString("FLDTXT");
                request.setAttribute("PSTLCOD",PSTLCOD);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='28' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String PHON = rs26.getString("FLDTXT");
                request.setAttribute("PHON",PHON);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='29' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String FAKUSU = rs27.getString("FLDTXT");
                request.setAttribute("FAKUSU",FAKUSU);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='30' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String MERU = rs28.getString("FLDTXT");
                request.setAttribute("MERU",MERU);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String GINKO = rs29.getString("FLDTXT");
                request.setAttribute("GINKO",GINKO);
                  }
                String sql30= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CUR = rs30.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
                String sql31= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String TAX = rs31.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                  
         
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/compcode.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/comdel")
    public ModelAndView comdel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String COM= rs1.getString("FLDTXT");
                request.setAttribute("COM",COM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/compcode.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/back16")
    public ModelAndView back16(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
         String scrn = request.getParameter("scrn");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                  String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }  
                  
                 /**
                 * Department Details
                 */
                String sql6= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DEP = rs6.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                  }
             /** 
              * Language Details
              */   
                String sql7= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String LAN = rs7.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }    
               /* Programming_Language Details*/
                String sql8= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String PGM = rs8.getString("FLDTXT");
                request.setAttribute("PGM",PGM); 
                  }
                /* Module Details*/
                String sql9= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String MOD = rs9.getString("FLDTXT");
                request.setAttribute("MOD",MOD); 
                  }
                 /* Payment terms Details*/
                String sql10= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PAY = rs10.getString("FLDTXT");
                request.setAttribute("PAY",PAY); 
                  }
                  /* Gender Details Details*/
                String sql11= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String GEN = rs11.getString("FLDTXT");
                request.setAttribute("GEN",GEN); 
                  }
                   /* Rank Details Details*/
                String sql12= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String RAN = rs12.getString("FLDTXT");
                request.setAttribute("RAN",RAN); 
                  }
                  /* Country Details Details*/
                String sql13= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CON = rs13.getString("FLDTXT");
                request.setAttribute("CON",CON); 
                  }
                  /* Phase Details Details*/
                String sql14= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PHA = rs14.getString("FLDTXT");
                request.setAttribute("PHA",PHA); 
                  }
                   /* Bank Details Details*/
                String sql15= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BAN = rs15.getString("FLDTXT");
                request.setAttribute("BAN",BAN); 
                  }
                  /* Deliverables Details Details*/
                String sql16= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String DBL = rs16.getString("FLDTXT");
                request.setAttribute("DBL",DBL); 
                  }
                 /* Delivery Place  Details Details*/
                String sql17= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String DLC = rs17.getString("FLDTXT");
                request.setAttribute("DLC",DLC); 
                  }
                /* Business Line Details*/
                String sql18= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BIZ = rs18.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ); 
                  }
                /* Employee type Details*/
                String sql19= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EMT = rs19.getString("FLDTXT");
                request.setAttribute("EMT",EMT); 
                  }
                /* Role Master Details*/
                String sql20= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ROL = rs20.getString("FLDTXT");
                request.setAttribute("ROL",ROL); 
                  }
                /* Company Code Details*/
                String sql21= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String COM = rs21.getString("FLDTXT");
                request.setAttribute("COM",COM); 
                  }
                /* Currency Details*/
                String sql22= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CUR = rs22.getString("FLDTXT");
                request.setAttribute("CUR",CUR); 
                  }
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
                
                  
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
                    
@RequestMapping(value="/insertcom")
    public ModelAndView insertcom(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
             
            String comId = request.getParameter("comId");
            String comName = request.getParameter("comName");
            
            String str1 = request.getParameter("str1");
            String str2 = request.getParameter("str2");
            String str3 = request.getParameter("str3");
            String city = request.getParameter("city");
            String stat = request.getParameter("stat");
            String cntry = request.getParameter("cntry");
            String pstl = request.getParameter("pstl");
            String langId = request.getParameter("langId");
            String phn1 = request.getParameter("phn1");
            String phn2 = request.getParameter("phn2");
            String fax = request.getParameter("fax");
            String emil = request.getParameter("emil");
            
            String bnk = request.getParameter("bnk");
            String curId = request.getParameter("curId");
            String taxId = request.getParameter("taxId");
            String time = request.getParameter("time");

           try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlad = "INSERT INTO Address (STREET1, STREET2, STREET3, CITY, STATE, CNTRY, PINCODE, PHONE1, PHONE2, FAXNO, EMAIL, LNGID,TZONE, CREDT, CRETIM) VALUES ('"+str1+"', '"+str2+"', '"+str3+"', '"+city+"', '"+stat+"', '"+cntry+"', '"+pstl+"', '"+phn1+"', '"+phn2+"', '"+fax+"', '"+emil+"', '"+langId+"','"+time+"', CURDATE(), CURTIME());";
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sqlad);
            if(n1 > 0){
            try{
                con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                Class.forName("com.mysql.cj.jdbc.Driver");
                String sqladno = "SELECT max(ADDNO) as adno FROM Address;";
                pst = con.prepareStatement(sqladno);
                rs=pst.executeQuery();
                while(rs.next()){
                    
                    String addno = rs.getString("adno");
                    System.out.println(addno);
                    
            try{
               con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
               Class.forName("com.mysql.cj.jdbc.Driver");
               String sqlcom = "INSERT INTO Company_Code (CCOD,CMPNAM,ADDNO,BNKNO,CURR,TAX,CREDT,CRETIM) VALUES ('"+comId+"', '"+comName+"', '"+addno+"', '"+bnk+"', '"+curId+"','"+taxId+"', CURDATE(),CURTIME());";
               System.out.println("sqlcom:"+sqlcom);  
               cst = con.createStatement();
               int e1 = cst.executeUpdate(sqlcom);
               if(e1 > 0){
               System.out.println("Company Code is created Successfully");
               JOptionPane.showMessageDialog(null, "Record "+comId+" Created Successfully");
                String sql1= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String COM = rs1.getString("FLDTXT");
                request.setAttribute("COM",COM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                   String sql6= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BSDT = rs6.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
            String sql20= "select * from Field_Text where FLDID ='22' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String STRT = rs20.getString("FLDTXT");
                request.setAttribute("STRT",STRT);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='23' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CITY = rs21.getString("FLDTXT");
                request.setAttribute("CITY",CITY);
                  }
                  
                String sql22= "select * from Field_Text where FLDID ='24' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String STATE = rs22.getString("FLDTXT");
                request.setAttribute("STATE",STATE);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CONTR = rs23.getString("FLDTXT");
                request.setAttribute("CONTR",CONTR);
                  }
                  
                String sql24= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String LANGU = rs24.getString("FLDTXT");
                request.setAttribute("LANGU",LANGU);
                  }
                  
                String sql25= "select * from Field_Text where FLDID ='27' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String PSTLCOD = rs25.getString("FLDTXT");
                request.setAttribute("PSTLCOD",PSTLCOD);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='28' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String PHON = rs26.getString("FLDTXT");
                request.setAttribute("PHON",PHON);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='29' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String FAKUSU = rs27.getString("FLDTXT");
                request.setAttribute("FAKUSU",FAKUSU);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='30' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String MERU = rs28.getString("FLDTXT");
                request.setAttribute("MERU",MERU);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String GINKO = rs29.getString("FLDTXT");
                request.setAttribute("GINKO",GINKO);
                  }
                String sql30= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CUR = rs30.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
                String sql31= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String TAX = rs31.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/compcode.jsp");
                rd.forward(request, response);
                
               
        /*    }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }*/
             
             
             

               //important                            
                    }
              //important      
                    }
                    catch(SQLException gx){
                    JOptionPane.showMessageDialog(null,"Error: "+gx.getMessage());
                    System.out.println(gx.getMessage());
                    mav = new ModelAndView("log");
                    }
                    
                }
            // important   
            }
            catch(SQLException fx){
                JOptionPane.showMessageDialog(null,"Error: "+fx.getMessage());
                System.out.println(fx.getMessage());
                mav = new ModelAndView("log");
            }
            
            }
            
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
                System.out.println(ex.getMessage());
                mav = new ModelAndView("log");
            }
            
        return mav;
    }
    
    @RequestMapping(value="/updatecom")
    public ModelAndView updatecom(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            
            //String rolId = request.getParameter("rolId");
            //String rolName = request.getParameter("rolName");
            String comId = request.getParameter("comId");
            String comName = request.getParameter("comName");
            
            String str1 = request.getParameter("str1");
            String str2 = request.getParameter("str2");
            String str3 = request.getParameter("str3");
            String city = request.getParameter("city");
            String stat = request.getParameter("stat");
            String cntry = request.getParameter("cntry");
            String pstl = request.getParameter("pstl");
            String langId = request.getParameter("langId");
            String phn1 = request.getParameter("phn1");
            String phn2 = request.getParameter("phn2");
            String fax = request.getParameter("fax");
            String emil = request.getParameter("emil");
            
            String bnk = request.getParameter("bnk");
            String curId = request.getParameter("curId");
            String taxId = request.getParameter("taxId");
            String time = request.getParameter("time");

        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql  = "update agnieportal.Company_Code cc inner join agnieportal.Address am on cc.ADDNO = am.ADDNO set cc.CMPNAM = '"+comName+"', am.STREET1 = '"+str1+"', am.STREET2 = '"+str2+"', am.STREET3 = '"+str3+"', am.CITY = '"+city+"', am.STATE = '"+stat+"', am.CNTRY = '"+cntry+"', am.PINCODE = '"+pstl+"', am.PHONE1 = '"+phn1+"', am.PHONE2 = '"+phn2+"', am.FAXNO = '"+fax+"', am.EMAIL = '"+emil+"',am.LNGID = '"+langId+"',am.TZONE = '"+time+"', cc.BNKNO = '"+bnk+"',cc.CURR = '"+curId+"',cc.TAX = '"+taxId+"' where cc.CCOD = '"+comId+"';";

                    
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Company Code Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +comId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String COM = rs1.getString("FLDTXT");
                request.setAttribute("COM",COM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                 String sql6= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BSDT = rs6.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
            String sql20= "select * from Field_Text where FLDID ='22' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String STRT = rs20.getString("FLDTXT");
                request.setAttribute("STRT",STRT);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='23' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CITY = rs21.getString("FLDTXT");
                request.setAttribute("CITY",CITY);
                  }
                  
                String sql22= "select * from Field_Text where FLDID ='24' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String STATE = rs22.getString("FLDTXT");
                request.setAttribute("STATE",STATE);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CONTR = rs23.getString("FLDTXT");
                request.setAttribute("CONTR",CONTR);
                  }
                  
                String sql24= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String LANGU = rs24.getString("FLDTXT");
                request.setAttribute("LANGU",LANGU);
                  }
                  
                String sql25= "select * from Field_Text where FLDID ='27' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String PSTLCOD = rs25.getString("FLDTXT");
                request.setAttribute("PSTLCOD",PSTLCOD);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='28' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String PHON = rs26.getString("FLDTXT");
                request.setAttribute("PHON",PHON);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='29' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String FAKUSU = rs27.getString("FLDTXT");
                request.setAttribute("FAKUSU",FAKUSU);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='30' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String MERU = rs28.getString("FLDTXT");
                request.setAttribute("MERU",MERU);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String GINKO = rs29.getString("FLDTXT");
                request.setAttribute("GINKO",GINKO);
                  }
                String sql30= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CUR = rs30.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
                String sql31= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String TAX = rs31.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/compcode.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getcom")
    public ModelAndView getcom(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        
        String comId = request.getParameter("comId");
        System.out.println("get is working fine"+comId);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM agnieportal.Company_Code em inner join agnieportal.Address am on em.ADDNO = am.ADDNO where CCOD = '"+comId+"' ;";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
        while(ss.next()){
            String comId1 = ss.getString("CCOD");
            String comName = ss.getString("CMPNAM");
            
            String str1 = ss.getString("STREET1");
            String str2 = ss.getString("STREET2");
            String str3 = ss.getString("STREET3");
            String city = ss.getString("CITY");
            String stat = ss.getString("STATE");
            String cntry = ss.getString("CNTRY");
            String langId = ss.getString("LNGID");
            String pstl = ss.getString("PINCODE");
            String phn1 = ss.getString("PHONE1");
            String phn2 = ss.getString("PHONE2");
            String fax = ss.getString("FAXNO");
            String emil = ss.getString("EMAIL");
            
            String bnk = ss.getString("BNKNO");
            String curId = ss.getString("CURR");
            String taxId = ss.getString("TAX");
            String time = ss.getString("TZONE");
            
            
          request.setAttribute("getnm","2");
          request.setAttribute("comId1", comId1);
          request.setAttribute("comName", comName);
          
          request.setAttribute("str1", str1);
          request.setAttribute("str2", str2);
          request.setAttribute("str3", str3);
          request.setAttribute("city", city);
          request.setAttribute("stat", stat);
          request.setAttribute("cntry", cntry);
          request.setAttribute("langId", langId);
          request.setAttribute("pstl", pstl);
          request.setAttribute("phn1", phn1);
          request.setAttribute("phn2", phn2);
          request.setAttribute("fax", fax);
          request.setAttribute("emil", emil);
          request.setAttribute("time", time);
          
          request.setAttribute("bnk", bnk);
          request.setAttribute("curId", curId);
          request.setAttribute("taxId", taxId);
          
          String sql1= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String COM = rs1.getString("FLDTXT");
                request.setAttribute("COM",COM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                   String sql6= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BSDT = rs6.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
            String sql20= "select * from Field_Text where FLDID ='22' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String STRT = rs20.getString("FLDTXT");
                request.setAttribute("STRT",STRT);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='23' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CITY = rs21.getString("FLDTXT");
                request.setAttribute("CITY",CITY);
                  }
                  
                String sql22= "select * from Field_Text where FLDID ='24' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String STATE = rs22.getString("FLDTXT");
                request.setAttribute("STATE",STATE);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CONTR = rs23.getString("FLDTXT");
                request.setAttribute("CONTR",CONTR);
                  }
                  
                String sql24= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String LANGU = rs24.getString("FLDTXT");
                request.setAttribute("LANGU",LANGU);
                  }
                  
                String sql25= "select * from Field_Text where FLDID ='27' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String PSTLCOD = rs25.getString("FLDTXT");
                request.setAttribute("PSTLCOD",PSTLCOD);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='28' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String PHON = rs26.getString("FLDTXT");
                request.setAttribute("PHON",PHON);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='29' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String FAKUSU = rs27.getString("FLDTXT");
                request.setAttribute("FAKUSU",FAKUSU);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='30' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String MERU = rs28.getString("FLDTXT");
                request.setAttribute("MERU",MERU);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String GINKO = rs29.getString("FLDTXT");
                request.setAttribute("GINKO",GINKO);
                  }
                String sql30= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CUR = rs30.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
                String sql31= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String TAX = rs31.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
          request.setAttribute("scrn", scrn); 
          request.setAttribute("weblng",weblng);
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/compcode.jsp");
          rd.forward(request, response);   
        
        }
        
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;    
    }
    
@RequestMapping(value="/delcom")
    public ModelAndView delcom(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String comId = request.getParameter("comId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Company_Code where CCOD = '"+comId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Company Code Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + comId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String COM = rs1.getString("FLDTXT");
                request.setAttribute("COM",COM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                   String sql6= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BSDT = rs6.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
            String sql20= "select * from Field_Text where FLDID ='22' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String STRT = rs20.getString("FLDTXT");
                request.setAttribute("STRT",STRT);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='23' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CITY = rs21.getString("FLDTXT");
                request.setAttribute("CITY",CITY);
                  }
                  
                String sql22= "select * from Field_Text where FLDID ='24' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String STATE = rs22.getString("FLDTXT");
                request.setAttribute("STATE",STATE);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CONTR = rs23.getString("FLDTXT");
                request.setAttribute("CONTR",CONTR);
                  }
                  
                String sql24= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String LANGU = rs24.getString("FLDTXT");
                request.setAttribute("LANGU",LANGU);
                  }
                  
                String sql25= "select * from Field_Text where FLDID ='27' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String PSTLCOD = rs25.getString("FLDTXT");
                request.setAttribute("PSTLCOD",PSTLCOD);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='28' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String PHON = rs26.getString("FLDTXT");
                request.setAttribute("PHON",PHON);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='29' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String FAKUSU = rs27.getString("FLDTXT");
                request.setAttribute("FAKUSU",FAKUSU);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='30' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String MERU = rs28.getString("FLDTXT");
                request.setAttribute("MERU",MERU);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String GINKO = rs29.getString("FLDTXT");
                request.setAttribute("GINKO",GINKO);
                  }
                String sql30= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CUR = rs30.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
                String sql31= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String TAX = rs31.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/compcode.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String COM = rs1.getString("FLDTXT");
                request.setAttribute("COM",COM);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                   String sql6= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String BSDT = rs6.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
            String sql20= "select * from Field_Text where FLDID ='22' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String STRT = rs20.getString("FLDTXT");
                request.setAttribute("STRT",STRT);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='23' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CITY = rs21.getString("FLDTXT");
                request.setAttribute("CITY",CITY);
                  }
                  
                String sql22= "select * from Field_Text where FLDID ='24' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String STATE = rs22.getString("FLDTXT");
                request.setAttribute("STATE",STATE);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CONTR = rs23.getString("FLDTXT");
                request.setAttribute("CONTR",CONTR);
                  }
                  
                String sql24= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String LANGU = rs24.getString("FLDTXT");
                request.setAttribute("LANGU",LANGU);
                  }
                  
                String sql25= "select * from Field_Text where FLDID ='27' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String PSTLCOD = rs25.getString("FLDTXT");
                request.setAttribute("PSTLCOD",PSTLCOD);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='28' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String PHON = rs26.getString("FLDTXT");
                request.setAttribute("PHON",PHON);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='29' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String FAKUSU = rs27.getString("FLDTXT");
                request.setAttribute("FAKUSU",FAKUSU);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='30' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String MERU = rs28.getString("FLDTXT");
                request.setAttribute("MERU",MERU);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String GINKO = rs29.getString("FLDTXT");
                request.setAttribute("GINKO",GINKO);
                  }
                String sql30= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CUR = rs30.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
                String sql31= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String TAX = rs31.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/compcode.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }   
/* Currency Details starts */
 @RequestMapping(value="/curcre")
    public ModelAndView curcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
            String sql1= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CUR = rs1.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
            
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/currency.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
     @RequestMapping(value="/curcha")
    public ModelAndView curcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CUR = rs1.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
              
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "cha");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/currency.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/curdis")
    public ModelAndView curdis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
       // String depId = request.getParameter("depId");
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CUR = rs1.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "dis");  
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/currency.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    } 
@RequestMapping(value="/curdel")
    public ModelAndView curdel(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                 String sql1= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CUR= rs1.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }
               String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                while(rs5.next()){
                String EMDEL= rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                } 
             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/currency.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
@RequestMapping(value="/back17")
    public ModelAndView back17(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
         String emnum = request.getParameter("emnum");
         String scrn = request.getParameter("scrn");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
                String sql1= "select * from Field_Text where FLDID ='06'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String EMM = rs1.getString("FLDTXT");
                request.setAttribute("EMM",EMM);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                }
                
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next())
                {
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String EMDIS = rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                
                  }
                  String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                
                  }  
                  
                 /**
                 * Department Details
                 */
                String sql6= "select * from Field_Text where FLDID ='48' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String DEP = rs6.getString("FLDTXT");
                request.setAttribute("DEP",DEP);
                  }
             /** 
              * Language Details
              */   
                String sql7= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String LAN = rs7.getString("FLDTXT");
                request.setAttribute("LAN",LAN);
                }    
               /* Programming_Language Details*/
                String sql8= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String PGM = rs8.getString("FLDTXT");
                request.setAttribute("PGM",PGM); 
                  }
                /* Module Details*/
                String sql9= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String MOD = rs9.getString("FLDTXT");
                request.setAttribute("MOD",MOD); 
                  }
                 /* Payment terms Details*/
                String sql10= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PAY = rs10.getString("FLDTXT");
                request.setAttribute("PAY",PAY); 
                  }
                  /* Gender Details Details*/
                String sql11= "select * from Field_Text where FLDID ='17' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String GEN = rs11.getString("FLDTXT");
                request.setAttribute("GEN",GEN); 
                  }
                   /* Rank Details Details*/
                String sql12= "select * from Field_Text where FLDID ='50' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String RAN = rs12.getString("FLDTXT");
                request.setAttribute("RAN",RAN); 
                  }
                  /* Country Details Details*/
                String sql13= "select * from Field_Text where FLDID ='25' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CON = rs13.getString("FLDTXT");
                request.setAttribute("CON",CON); 
                  }
                  /* Phase Details Details*/
                String sql14= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PHA = rs14.getString("FLDTXT");
                request.setAttribute("PHA",PHA); 
                  }
                   /* Bank Details Details*/
                String sql15= "select * from Field_Text where FLDID ='31' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BAN = rs15.getString("FLDTXT");
                request.setAttribute("BAN",BAN); 
                  }
                  /* Deliverables Details Details*/
                String sql16= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String DBL = rs16.getString("FLDTXT");
                request.setAttribute("DBL",DBL); 
                  }
                 /* Delivery Place  Details Details*/
                String sql17= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String DLC = rs17.getString("FLDTXT");
                request.setAttribute("DLC",DLC); 
                  }
                /* Business Line Details*/
                String sql18= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BIZ = rs18.getString("FLDTXT");
                request.setAttribute("BIZ",BIZ); 
                  }
                /* Employee type Details*/
                String sql19= "select * from Field_Text where FLDID ='49' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EMT = rs19.getString("FLDTXT");
                request.setAttribute("EMT",EMT); 
                  }
                /* Role Master Details*/
                String sql20= "select * from Field_Text where FLDID ='143' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ROL = rs20.getString("FLDTXT");
                request.setAttribute("ROL",ROL); 
                  }
                /* Company Code Details*/
                String sql21= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String COM = rs21.getString("FLDTXT");
                request.setAttribute("COM",COM); 
                  }
                /* Currency Details*/
                String sql22= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CUR = rs22.getString("FLDTXT");
                request.setAttribute("CUR",CUR); 
                  }
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
                
                  
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
                    
@RequestMapping(value="/insertcur")
    public ModelAndView insertcur(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
             String scrn = request.getParameter("scrn");
            String curId = request.getParameter("curId");
            String curName = request.getParameter("curName");
            System.out.println("curName:"+curName);
            
            try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "INSERT INTO Currency (CURID,CURTXT) VALUES ('"+curId+"','"+curName+"');";
            
           System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            
            System.out.println("n1:"+n1);
            
            if (n1 > 0) {
                System.out.println("Currency Created Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record "+curId+" Created Successfully");
                  String sql1= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CUR = rs1.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                  request.setAttribute("weblng",weblng);
                  request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/currency.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav;
    }
    
    @RequestMapping(value="/updatecur")
    public ModelAndView updatecur(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException
    {
            //String scrn = request.getParameter("scrn");
            ModelAndView mav = null;
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
            String curId = request.getParameter("curId");
            String curName = request.getParameter("curName");
           
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "update Currency set CURTXT = '"+curName+"' where CURID = '"+curId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Currency Updated Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " +curId+ " Updated Successfully");
                String sql1= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CUR = rs1.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/currency.jsp");
                rd.forward(request, response);
                
            }}

        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
            
        return mav;
    }
    
    
@RequestMapping(value="/getcur")
    public ModelAndView getcur(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String curId = request.getParameter("curId");
        //String scrn = request.getParameter("scrn");
        System.out.println(weblng);
        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        String sqlget = "SELECT * FROM Currency where CURID = '"+curId+"';";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
            while (ss.next()) {
                //get department id and name
               // String depId = ss.getString("DPTCOD");
                String curName = ss.getString("CURTXT");

                request.setAttribute("getnm", "2");
                //need to design input filed to get dept id
                request.setAttribute("curId", curId);
                request.setAttribute("curName", curName);
                String sql1= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CUR = rs1.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }   
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/currency.jsp");
                rd.forward(request, response);
                
            }}
            catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }
        return mav; 
    } 
@RequestMapping(value="/delcur")
    public ModelAndView delcur(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String curId = request.getParameter("curId"); 
        String CONMSG11 = null, CONMSG12 = null;
        String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
        ResultSet rsconmsg1 = pstconmsg1.executeQuery();
        while(rsconmsg1.next())
        {
        CONMSG11 = rsconmsg1.getString("MSGTXT");
        }
        String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
        PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
        ResultSet rsconmsg2 = pstconmsg2.executeQuery();
        while(rsconmsg2.next())
        {
        CONMSG12 = rsconmsg2.getString("MSGTXT");
        }
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
                     JOptionPane.YES_NO_OPTION,
                     JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION)
        {
     
            try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from Currency where CURID = '"+curId+"'";
            System.out.println("sql:"+sql);
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sql);
            System.out.println("n1:"+n1);
             if (n1 > 0) {
                System.out.println("Currency Deleted Successfully:" + n1);
                JOptionPane.showMessageDialog(null, "Record " + curId + " Deleted Successfully");
                String sql1= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CUR = rs1.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/currency.jsp");
                rd.forward(request, response);
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            System.out.println(ex.getMessage());
            mav = new ModelAndView("log");
        }}
            
        else
        {
         String sql1= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                  while(rs1.next()){
                String CUR = rs1.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                }
                  
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String EMC = rs2.getString("FLDTXT");
                request.setAttribute("EMC",EMC);
                
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3= con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String EMED = rs3.getString("FLDTXT");
                request.setAttribute("EMED",EMED);
                }
                 String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                while(rs4.next()){
                String EMDIS= rs4.getString("FLDTXT");
                request.setAttribute("EMDIS",EMDIS);
                }  
                 String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5= con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String EMDEL = rs5.getString("FLDTXT");
                request.setAttribute("EMDEL",EMDEL);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/currency.jsp");
                rd.forward(request, response);
        }
        
        return mav;
    }  
}

//End