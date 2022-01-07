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
            while(rs.next()){
            dbunm = rs.getString("USERNAME");
            dbpwd = rs.getString("PASSWORD");
            emnum = rs.getInt("EMPCOD");
            System.out.println(dbunm);
            
            }
            if(uname.equals(dbunm) && pass.equals(dbpwd) ){
                 
                System.out.println(emnum);
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
//              
                String sql6= "select * from Field_Text where FLDID ='58' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String INQM = rs6.getString("FLDTXT");
                request.setAttribute("INQM",INQM);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='92' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String BPM = rs7.getString("FLDTXT");
                request.setAttribute("BPM",BPM);
                  }  
                
                                
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
                
//        mav.addObject("log",new log());
//            return mav;
            }
            else{
            request.setAttribute("appnm","1");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            System.out.println("user and pass is worng");
//            mav = new ModelAndView("index");
            }
            
        }
        catch(IOException | SQLException | ServletException ex){
//            System.out.println(ex);
                JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
                System.out.println("Error"+ex.getMessage());
        }
       con.close();
//        System.out.println("hai how are you");
//        ModelAndView mav = new ModelAndView("log");
////        mav.addObject("log",new log());
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
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
            String scrn = request.getParameter("scrn");
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
                    
                    String sqlemp = "INSERT INTO Employee_Master (CCOD, EMPNAM, EMPDOB, GENDER, ADDNO, BIZID, DPTCOD, EMPTYP, QUALI, BANCOD, RANKCOD, MODUL, SPLNGID, PGMLANG, EXSAP, EXPIT, RESERV, ACTFLG, BASSAL, INCNT, BONUS, SOCINS, HELINS, STATBEN, CONALW, HRALW, TAX, PENSION, LOAN, BILRATE, CREDT, ACTSTRDT, ACTENDT) VALUES ('"+ccod+"', '"+empnm+"', '"+dob+"', '"+gnd+"', '"+addno+"', '"+bslin+"', '"+dept+"', '"+emptyp+"', '"+quli+"', '"+bnk+"','"+rank+"','"+modexp+"', '"+splnex+"', '"+pmglnex+"', '"+exsap+"', '"+exit+"', '"+resv+"','', '"+bsal+"', '"+incnt+"', '"+bons+"', '"+sclins+"', '"+helins+"', '"+sttben+"', '"+conawl+"', '"+hrawl+"', '"+tax+"', '"+epf+"', '"+advnc+"', '"+bilrat+"', CURDATE(), '"+actstrt+"', '"+actend+"');";
                    
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
                                String MSG1 = null, MSG2 = null;
                                String msg1= "select * from Message_Txt where MSGID ='01'and LNGID ='"+weblng+"'";
                                PreparedStatement pstmsg1 = con.prepareStatement(msg1);
                                ResultSet rsmsg1 = pstmsg1.executeQuery();
                                while(rsmsg1.next()){
                                 MSG1 = rsmsg1.getString("MSGTXT");
                                }
                                String msg2= "select * from Message_Txt where MSGID ='02'and LNGID ='"+weblng+"'";
                                PreparedStatement pstmsg2 = con.prepareStatement(msg2);
                                ResultSet rsmsg2 = pstmsg2.executeQuery();
                                while(rsmsg2.next()){
                                 MSG2 = rsmsg2.getString("MSGTXT");
                                }
                                String empno = ss.getString("empcd");
                                JOptionPane.showMessageDialog(null,MSG1+" "+empno+" "+MSG2);
                                request.setAttribute("appnm","1");
                                request.setAttribute("empno",empno);
                                request.setAttribute("addno",addno);
                                
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
                  
                  String sql56= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst56 = con.prepareStatement(sql56);
                ResultSet rs56 = pst56.executeQuery();
                  while(rs56.next()){
                String TOLEDT = rs56.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql57= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst57 = con.prepareStatement(sql57);
                ResultSet rs57 = pst57.executeQuery();
                  while(rs57.next()){
                String TOLGOTO = rs57.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql58= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst58 = con.prepareStatement(sql58);
                ResultSet rs58 = pst58.executeQuery();
                  while(rs58.next()){
                String TOLENV = rs58.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql59= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst59 = con.prepareStatement(sql59);
                ResultSet rs59 = pst59.executeQuery();
                  while(rs59.next()){
                String TOLSYS = rs59.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
          request.setAttribute("weblng",weblng);
          request.setAttribute("emnum",emnum);
          request.setAttribute("scrn", scrn);
                                
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
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
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
                  
                  String sql56= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst56 = con.prepareStatement(sql56);
                ResultSet rs56 = pst56.executeQuery();
                  while(rs56.next()){
                String TOLEDT = rs56.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql57= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst57 = con.prepareStatement(sql57);
                ResultSet rs57 = pst57.executeQuery();
                  while(rs57.next()){
                String TOLGOTO = rs57.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql58= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst58 = con.prepareStatement(sql58);
                ResultSet rs58 = pst58.executeQuery();
                  while(rs58.next()){
                String TOLENV = rs58.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql59= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst59 = con.prepareStatement(sql59);
                ResultSet rs59 = pst59.executeQuery();
                  while(rs59.next()){
                String TOLSYS = rs59.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql55= "select * from Field_Text where FLDID ='57' and LNGID ='"+weblng+"'";
                PreparedStatement pst55 = con.prepareStatement(sql55);
                ResultSet rs55 = pst55.executeQuery();
                  while(rs55.next()){
                String EMROLE = rs55.getString("FLDTXT");
                request.setAttribute("EMROLE",EMROLE);
                  }
                  
                  String MSG1 = null, MSG2 = null;
                                String msg1= "select * from Message_Txt where MSGID ='01'and LNGID ='"+weblng+"'";
                                PreparedStatement pstmsg1 = con.prepareStatement(msg1);
                                ResultSet rsmsg1 = pstmsg1.executeQuery();
                                while(rsmsg1.next()){
                                 MSG1 = rsmsg1.getString("MSGTXT");
                                }
                                String msg2= "select * from Message_Txt where MSGID ='07'and LNGID ='"+weblng+"'";
                                PreparedStatement pstmsg2 = con.prepareStatement(msg2);
                                ResultSet rsmsg2 = pstmsg2.executeQuery();
                                while(rsmsg2.next()){
                                 MSG2 = rsmsg2.getString("MSGTXT");
                                }
                  
          request.setAttribute("weblng",weblng);
          request.setAttribute("emnum",emnum);
          if(actst.contains("X")){
              JOptionPane.showMessageDialog(null,MSG1+" "+empid+" "+MSG2);
              RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
              rd.forward(request, response);
          }else{
              request.setAttribute("getnm","2");
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
          rd.forward(request, response);
          }
        
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
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        
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
                  
                  String sql56= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst56 = con.prepareStatement(sql56);
                ResultSet rs56 = pst56.executeQuery();
                  while(rs56.next()){
                String TOLEDT = rs56.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql57= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst57 = con.prepareStatement(sql57);
                ResultSet rs57 = pst57.executeQuery();
                  while(rs57.next()){
                String TOLGOTO = rs57.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql58= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst58 = con.prepareStatement(sql58);
                ResultSet rs58 = pst58.executeQuery();
                  while(rs58.next()){
                String TOLENV = rs58.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql59= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst59 = con.prepareStatement(sql59);
                ResultSet rs59 = pst59.executeQuery();
                  while(rs59.next()){
                String TOLSYS = rs59.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql55= "select * from Field_Text where FLDID ='57' and LNGID ='"+weblng+"'";
                PreparedStatement pst55 = con.prepareStatement(sql55);
                ResultSet rs55 = pst55.executeQuery();
                  while(rs55.next()){
                String EMROLE = rs55.getString("FLDTXT");
                request.setAttribute("EMROLE",EMROLE);
                  }
                request.setAttribute("weblng",weblng);
                request.setAttribute("emnum",emnum);
                request.setAttribute("scrn", scrn);
                
                String CONMSG11 = null, CONMSG12 = null;
                                String conmsg1= "select * from Message_Txt where MSGID ='05'and LNGID ='"+weblng+"'";
                                PreparedStatement pstconmsg1 = con.prepareStatement(conmsg1);
                                ResultSet rsconmsg1 = pstconmsg1.executeQuery();
                                while(rsconmsg1.next()){
                                 CONMSG11 = rsconmsg1.getString("MSGTXT");
                                }
                                String conmsg2= "select * from Message_Txt where MSGID ='06'and LNGID ='"+weblng+"'";
                                PreparedStatement pstconmsg2 = con.prepareStatement(conmsg2);
                                ResultSet rsconmsg2 = pstconmsg2.executeQuery();
                                while(rsconmsg2.next()){
                                 CONMSG12 = rsconmsg2.getString("MSGTXT");
                                }
                  
        int result = JOptionPane.showConfirmDialog(null,CONMSG11, CONMSG12,
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
        try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
//            String sqldel = "Delete from Employee_Master, Address using Employee_Master inner join Address on Employee_Master.ADDNO = Address.ADDNO where EMPCOD = '"+empid+"';";
              String sqldel = "update agnieportal.Employee_Master set ACTFLG = 'X' where EMPCOD = '"+empid+"'";
            cst = con.createStatement();
            int d1 = cst.executeUpdate(sqldel);
            
            if(d1 > 0){
                String MSG1 = null, MSG2 = null;
                                String msg1= "select * from Message_Txt where MSGID ='01'and LNGID ='"+weblng+"'";
                                PreparedStatement pstmsg1 = con.prepareStatement(msg1);
                                ResultSet rsmsg1 = pstmsg1.executeQuery();
                                while(rsmsg1.next()){
                                 MSG1 = rsmsg1.getString("MSGTXT");
                                }
                                String msg2= "select * from Message_Txt where MSGID ='04'and LNGID ='"+weblng+"'";
                                PreparedStatement pstmsg2 = con.prepareStatement(msg2);
                                ResultSet rsmsg2 = pstmsg2.executeQuery();
                                while(rsmsg2.next()){
                                 MSG2 = rsmsg2.getString("MSGTXT");
                                }
            
                 JOptionPane.showMessageDialog(null,MSG1+" "+empid+" "+MSG2);
                                                                          
                request.setAttribute("delet","DEL");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
                rd.forward(request, response);
            
            }
            else{
            JOptionPane.showMessageDialog(null,"ERROR..! Please check your Input");
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
        }
        else{
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
                rd.forward(request, response);
        
        }
            
            
            
        return mav;
        
    } 
    
    @RequestMapping(value="/updt")
    public ModelAndView update(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            String scrn = request.getParameter("scrn");
            String weblng = request.getParameter("weblng");
            String emnum = request.getParameter("emnum");
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
                            "em.SPLNGID = '"+splnex+"', em.PGMLANG = '"+pmglnex+"', em.EXSAP = '"+exsap+"', em.EXPIT = '"+exit+"', em.RESERV = '"+resv+"', "+
                            "em.BASSAL = '"+bsal+"', em.INCNT = '"+incnt+"', em.BONUS = '"+bons+"', em.SOCINS = '"+sclins+"', em.HELINS = '"+helins+"', em.STATBEN = '"+sttben+"', "+
                            "em.CONALW = '"+conawl+"', em.HRALW = '"+hrawl+"', em.TAX = '"+tax+"', em.PENSION = '"+epf+"', em.LOAN = '"+advnc+"', em.BILRATE = '"+bilrat+"', "+
                            "em.ACTSTRDT = '"+actstrt+"', em.ACTENDT = '"+actend+"', am.STREET1 = '"+str1+"', am.STREET2 = '"+str2+"', am.STREET3 = '"+str3+"', "+
                            "am.CITY = '"+city+"', am.STATE = '"+stat+"', am.CNTRY = '"+cntry+"', am.PINCODE = '"+pstl+"', am.PHONE1 = '"+phn1+"', am.PHONE2 = '"+phn2+"', "+
                            "am.FAXNO = '"+fax+"', am.EMAIL = '"+emil+"',am.LNGID = '"+lang+"' where em.EMPCOD = '"+empid+"';";
            
             cst = con.createStatement();
            int u1 = cst.executeUpdate(sqlupd);
            
            if(u1 > 0){
                String MSG1 = null, MSG2 = null;
                                String msg1= "select * from Message_Txt where MSGID ='01'and LNGID ='"+weblng+"'";
                                PreparedStatement pstmsg1 = con.prepareStatement(msg1);
                                ResultSet rsmsg1 = pstmsg1.executeQuery();
                                while(rsmsg1.next()){
                                 MSG1 = rsmsg1.getString("MSGTXT");
                                }
                                String msg2= "select * from Message_Txt where MSGID ='03'and LNGID ='"+weblng+"'";
                                PreparedStatement pstmsg2 = con.prepareStatement(msg2);
                                ResultSet rsmsg2 = pstmsg2.executeQuery();
                                while(rsmsg2.next()){
                                 MSG2 = rsmsg2.getString("MSGTXT");
                                }
            
                JOptionPane.showMessageDialog(null,MSG1+" "+empid+" "+MSG2);
                
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
                  
                  String sql56= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst56 = con.prepareStatement(sql56);
                ResultSet rs56 = pst56.executeQuery();
                  while(rs56.next()){
                String TOLEDT = rs56.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql57= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst57 = con.prepareStatement(sql57);
                ResultSet rs57 = pst57.executeQuery();
                  while(rs57.next()){
                String TOLGOTO = rs57.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql58= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst58 = con.prepareStatement(sql58);
                ResultSet rs58 = pst58.executeQuery();
                  while(rs58.next()){
                String TOLENV = rs58.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql59= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst59 = con.prepareStatement(sql59);
                ResultSet rs59 = pst59.executeQuery();
                  while(rs59.next()){
                String TOLSYS = rs59.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
          request.setAttribute("weblng",weblng);
          request.setAttribute("emnum",emnum);
//                
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
        String emnum = request.getParameter("emnum");
        String authflg = ""; 
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String sqlauth = "select * from Authorisation_Master where APPMSTR ='EM'and EMPCOD ='"+emnum+"'";
                PreparedStatement pstauth = con.prepareStatement(sqlauth);
                ResultSet rsauth = pstauth.executeQuery();
                while(rsauth.next()){
                    authflg = rsauth.getString("AUTHFLG");
                }
                                
                System.out.println(authflg);
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
                  
                  String sql56= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst56 = con.prepareStatement(sql56);
                ResultSet rs56 = pst56.executeQuery();
                  while(rs56.next()){
                String TOLEDT = rs56.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql57= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst57 = con.prepareStatement(sql57);
                ResultSet rs57 = pst57.executeQuery();
                  while(rs57.next()){
                String TOLGOTO = rs57.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql58= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst58 = con.prepareStatement(sql58);
                ResultSet rs58 = pst58.executeQuery();
                  while(rs58.next()){
                String TOLENV = rs58.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql59= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst59 = con.prepareStatement(sql59);
                ResultSet rs59 = pst59.executeQuery();
                  while(rs59.next()){
                String TOLSYS = rs59.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
          request.setAttribute("weblng",weblng);
          request.setAttribute("emnum",emnum);
          request.setAttribute("scrn", "cre");

          if(authflg.contains("C")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
                rd.forward(request, response);
                }else{
                    JOptionPane.showMessageDialog(null,"you are not Authorized for create operation");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                    rd.forward(request, response);
                }
          
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/empcha")
    public ModelAndView empcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String authflg = "";
        
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String sqlauth = "select * from Authorisation_Master where APPMSTR ='EM'and EMPCOD ='"+emnum+"'";
                PreparedStatement pstauth = con.prepareStatement(sqlauth);
                ResultSet rsauth = pstauth.executeQuery();
                while(rsauth.next()){
                    authflg = rsauth.getString("AUTHFLG");
                }
        
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
                  
                String sql56= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst56 = con.prepareStatement(sql56);
                ResultSet rs56 = pst56.executeQuery();
                  while(rs56.next()){
                String TOLEDT = rs56.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql57= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst57 = con.prepareStatement(sql57);
                ResultSet rs57 = pst57.executeQuery();
                  while(rs57.next()){
                String TOLGOTO = rs57.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql58= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst58 = con.prepareStatement(sql58);
                ResultSet rs58 = pst58.executeQuery();
                  while(rs58.next()){
                String TOLENV = rs58.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql59= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst59 = con.prepareStatement(sql59);
                ResultSet rs59 = pst59.executeQuery();
                  while(rs59.next()){
                String TOLSYS = rs59.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
        request.setAttribute("weblng",weblng);
        request.setAttribute("emnum",emnum);
        request.setAttribute("scrn", "cha");   
        
          if(authflg.contains("U")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
                rd.forward(request, response);
                }else{
                    JOptionPane.showMessageDialog(null,"you are not Authorized for Update operation");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                    rd.forward(request, response);
                }
        
        ModelAndView mav = new ModelAndView("log");
        return mav;
        
    }
    
    @RequestMapping(value="/empdis")
    public ModelAndView empdis(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String authflg = "";
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String sqlauth = "select * from Authorisation_Master where APPMSTR ='EM'and EMPCOD ='"+emnum+"'";
                PreparedStatement pstauth = con.prepareStatement(sqlauth);
                ResultSet rsauth = pstauth.executeQuery();
                while(rsauth.next()){
                    authflg = rsauth.getString("AUTHFLG");
                }
        
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
                  
                String sql56= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst56 = con.prepareStatement(sql56);
                ResultSet rs56 = pst56.executeQuery();
                  while(rs56.next()){
                String TOLEDT = rs56.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql57= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst57 = con.prepareStatement(sql57);
                ResultSet rs57 = pst57.executeQuery();
                  while(rs57.next()){
                String TOLGOTO = rs57.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql58= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst58 = con.prepareStatement(sql58);
                ResultSet rs58 = pst58.executeQuery();
                  while(rs58.next()){
                String TOLENV = rs58.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql59= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst59 = con.prepareStatement(sql59);
                ResultSet rs59 = pst59.executeQuery();
                  while(rs59.next()){
                String TOLSYS = rs59.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
        request.setAttribute("emnum",emnum);          
        request.setAttribute("weblng",weblng);
        request.setAttribute("scrn", "dis");  

        
         if(authflg.contains("R")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
                rd.forward(request, response);
                }else{
                    JOptionPane.showMessageDialog(null,"you are not Authorized for READ operation");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                    rd.forward(request, response);
                }
        
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
    
    @RequestMapping(value="/backtohome")
    public ModelAndView backtohome(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        
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
//              
                String sql6= "select * from Field_Text where FLDID ='58' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String INQM = rs6.getString("FLDTXT");
                request.setAttribute("INQM",INQM);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='92' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String BPM = rs7.getString("FLDTXT");
                request.setAttribute("BPM",BPM);
                  }  
                
                                
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
        
        mav = new ModelAndView("emplist");
        
       
        return mav;
        
    }
    
}
