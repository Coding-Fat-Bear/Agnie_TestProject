/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import javax.activation.DataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Welcome
 */
@Controller
public class bpm {
    private DataSource datasource;

    
    public void setDatasource(DataSource datasource){
        this.datasource=datasource;
    }
    
    Connection con = null;
    PreparedStatement pst = null;
    Statement cst = null;
    ResultSet rs = null;
    ResultSet ss = null;
    
    @RequestMapping(value="/bpmcre")
    public ModelAndView bpmcre(HttpServletRequest request,HttpServletResponse response) 
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
                
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                  String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }
                  
          request.setAttribute("weblng",weblng);
          request.setAttribute("emnum",emnum);
          request.setAttribute("scrn", "cre");
        
            if(authflg.contains("C")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                rd.forward(request, response);
                }else{
                    JOptionPane.showMessageDialog(null,"you are not Authorized for create operation");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                    rd.forward(request, response);
                }
        
        
        return null;        
    }
    
    @RequestMapping(value="/bpmcha")
    public ModelAndView bpmcha(HttpServletRequest request,HttpServletResponse response) 
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
                
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }  
                
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }
                  
          request.setAttribute("weblng",weblng);
          request.setAttribute("emnum",emnum);
          request.setAttribute("scrn", "cha");
        
            if(authflg.contains("U")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                rd.forward(request, response);
                }else{
                    JOptionPane.showMessageDialog(null,"you are not Authorized for create operation");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                    rd.forward(request, response);
                }
        
        
        return null;        
    }
    
    @RequestMapping(value="/bpmdis")
    public ModelAndView bpmdis(HttpServletRequest request,HttpServletResponse response) 
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
                
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }
                  
          request.setAttribute("weblng",weblng);
          request.setAttribute("emnum",emnum);
          request.setAttribute("scrn", "dis");
        
            if(authflg.contains("R")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                rd.forward(request, response);
                }else{
                    JOptionPane.showMessageDialog(null,"you are not Authorized for create operation");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                    rd.forward(request, response);
                }
        
        
        return null;        
    }
    
    @RequestMapping(value="/bpmdel")
    public ModelAndView bpmdel(HttpServletRequest request,HttpServletResponse response) 
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
                
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                  String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }
                  
          request.setAttribute("weblng",weblng);
          request.setAttribute("emnum",emnum);
          request.setAttribute("scrn", "del");
        
            if(authflg.contains("D")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                rd.forward(request, response);
                }else{
                    JOptionPane.showMessageDialog(null,"you are not Authorized for create operation");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                    rd.forward(request, response);
                }
        
        
        return null;        
    }
    
    @RequestMapping(value="/insertbpm")
    public ModelAndView inserbpm(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        PrintWriter out = response.getWriter();
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String[] bpitmno = request.getParameterValues("bpitm");
        String[] conid = request.getParameterValues("bpid");
        String[] bpnam = request.getParameterValues("bpnam");
        String[] bpunit = request.getParameterValues("bpunit");
        String[] bprate = request.getParameterValues("bprate");
        String[] bpselunt = request.getParameterValues("bpselunt");
        String[] bpselrat = request.getParameterValues("bpselrat");
        String[] bpcurr = request.getParameterValues("bpcurr");
        String[] bpconstyp = request.getParameterValues("bpconstyp");
        String[] bpmodu = request.getParameterValues("bpmodu");
        String[] bpsplng = request.getParameterValues("bpsplng");
        String[] bppmglng = request.getParameterValues("bppmglng");
        String[] expsap = request.getParameterValues("expsap");
        String[] expit = request.getParameterValues("expit");        
        
        
        String ccod = request.getParameter("ccod");
        String bpdes = request.getParameter("bpdes");
        String paytm = request.getParameter("paytm");
        String bpstdt = request.getParameter("bpstdt");
        String bpendt = request.getParameter("bpendt");
        String contyp = request.getParameter("contyp");
        String bscon = request.getParameter("bscon");
        System.out.println(bscon);
        String bscon1;
        if(bscon == null ){
                bscon1 = "";
        }else{
            bscon1 = "X";
        }
        System.out.println(bscon);
        String nda = request.getParameter("nda");
        String nda1 ;
        if(nda == null ){
                nda1 = "";
        }else{
            nda1 = "X";
        }
        String asc = request.getParameter("asc");
        String asc1;
        if(asc == null ){
                asc1 = "";
        }else{
            asc1 = "X";
        }
        String aprvl = request.getParameter("aprvl");
        String aprvl1;
        if(aprvl == null ){
                aprvl1 = "";
        }else{
            aprvl1 = "X";
        }
        
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
//            String sqlad = "INSERT INTO Address (STREET1, STREET2, STREET3, CITY, STATE, CNTRY, PINCODE, PHONE1, PHONE2, FAXNO, EMAIL, LNGID, CREDT, CRETIM) VALUES ('"+str1+"', '"+str2+"', '"+str3+"', '"+city+"', '"+stat+"', '"+cntry+"', '"+pstl+"', '"+phn1+"', '"+phn2+"', '"+fax+"', '"+emil+"', '"+lang+"', CURDATE(), CURTIME());";
            String sqlbpm ="INSERT INTO Businesspartner_Master (CCOD, BPDES, PAYTRMS,FRMDT, TODT, CNTRTYP, BSCNTR, "+
                     "NDA, ASCON, APPRVL, ACTFLG, CREDT, CRETIM) VALUES ('"+ccod+"','"+bpdes+"','"+paytm+"','"+bpstdt+"',"+
                    "'"+bpendt+"','"+contyp+"','"+bscon1+"','"+nda1+"','"+asc1+"','"+aprvl1+"','', CURDATE(), CURTIME());";
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sqlbpm);
            if(n1 > 0){
                try{
                con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                Class.forName("com.mysql.cj.jdbc.Driver");
                String sqladno = "SELECT max(BPNO) as bpno FROM Businesspartner_Master;";
                pst = con.prepareStatement(sqladno);
                rs=pst.executeQuery();
                while(rs.next()){
                    String bpno = rs.getString("bpno");
                    System.out.println(bpno);
                    
                    try{
                    con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String sqlbpi ="INSERT INTO Businesspartner_Item (BPNO, BPITEM, BPID,BPNAME, UNIT, RATE, SELUNIT, "+
                     "SELRATE, CURR, BPTYP, MODUL, LNGID,PGMLANG,SAPEXP,ITEXP,CREDT, CRETIM) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, CURDATE(), CURTIME());";
                     PreparedStatement ps = con.prepareStatement(sqlbpi);   
                    
                    for(int i = 0;i < bpitmno.length;i++){
                        
//                        String sqlbpi ="INSERT INTO Businesspartner_Item (BPNO, BPITEM, BPID,BPNAME, UNIT, RATE, SELUNIT, "+
//                     "SELRATE, CURR, BPTYP, MODUL, LNGID,PGMLANG,SAPEXP,ITEXP,CREDT, CRETIM) VALUES ('"+bpno+"','"+bpitmno[i]+"','"+conid[i]+"','"+bpnam[i]+"',"+
//                    "'"+bpunit[i]+"','"+bprate[i]+"','"+bpselunt[i]+"','"+bpselrat[i]+"','"+bpcurr[i]+"','"+bpconstyp[i]+"','"+bpmodu[i]+"',"
//                            + "'"+bpsplng[i]+"','"+bppmglng[i]+"','"+expsap[i]+"','"+expit[i]+"', CURDATE(), CURTIME());";
//                         ps = con.prepareStatement(sqlbpi);
                      if(conid[i] != ""){
                          System.out.println("["+conid[i]+"]");
                         ps.setString(1, bpno);
                         ps.setString(2, bpitmno[i]);
                         ps.setString(3, conid[i]);
                         ps.setString(4, bpnam[i]);
                         ps.setString(5, bpunit[i]);
                         ps.setString(6, bprate[i]);
                         ps.setString(7, bpselunt[i]);
                         ps.setString(8, bpselrat[i]);
                         ps.setString(9, bpcurr[i]);
                         ps.setString(10, bpconstyp[i]);
                         ps.setString(11, bpmodu[i]);
                         ps.setString(12, bpsplng[i]);
                         ps.setString(13, bppmglng[i]);
                         ps.setString(14, expsap[i]);
                         ps.setString(15, expit[i]);
                        
                        ps.addBatch();
                      }
                    }
                                        
                    
                    
                        int[] e1 = ps.executeBatch();
                    if(e1.length > 0){
                        JOptionPane.showMessageDialog(null,"BP created sucessfully");
                        
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }  
                        
                        request.setAttribute("scrn",scrn);
                        request.setAttribute("weblng",weblng);
                        request.setAttribute("emnum",emnum);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                        rd.forward(request, response);
                        
                    }
                    }
                    catch(SQLException gx){
                JOptionPane.showMessageDialog(null,"Error: "+gx.getMessage());
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }
                        
                        request.setAttribute("scrn",scrn);
                        request.setAttribute("weblng",weblng);
                        request.setAttribute("emnum",emnum);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                        rd.forward(request, response);
            }
                    
                    
                }
                }
                catch(SQLException fx){
                JOptionPane.showMessageDialog(null,"Error: "+fx.getMessage());
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  } 
                  
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }
                        
                        request.setAttribute("scrn",scrn);
                        request.setAttribute("weblng",weblng);
                        request.setAttribute("emnum",emnum);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                        rd.forward(request, response);
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
        
        return null;
        
    }
        

    @RequestMapping(value="/updtbpm")
    public ModelAndView updatebpm(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        PrintWriter out = response.getWriter();
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String[] bpitmno = request.getParameterValues("bpitm");
        String[] conid = request.getParameterValues("bpid");
        String[] bpnam = request.getParameterValues("bpnam");
        String[] bpunit = request.getParameterValues("bpunit");
        String[] bprate = request.getParameterValues("bprate");
        String[] bpselunt = request.getParameterValues("bpselunt");
        String[] bpselrat = request.getParameterValues("bpselrat");
        String[] bpcurr = request.getParameterValues("bpcurr");
        String[] bpconstyp = request.getParameterValues("bpconstyp");
        String[] bpmodu = request.getParameterValues("bpmodu");
        String[] bpsplng = request.getParameterValues("bpsplng");
        String[] bppmglng = request.getParameterValues("bppmglng");
        String[] expsap = request.getParameterValues("expsap");
        String[] expit = request.getParameterValues("expit");        
        
        String bpmno = request.getParameter("bpmno");
        String ccod = request.getParameter("ccod");
        String bpdes = request.getParameter("bpdes");
        String paytm = request.getParameter("paytm");
        String bpstdt = request.getParameter("bpstdt");
        String bpendt = request.getParameter("bpendt");
        String contyp = request.getParameter("contyp");
        String bscon = request.getParameter("bscon");
        String bpdt = null;
        String bptm = null;
        System.out.println(bscon);
        String bscon1;
        if(bscon == null ){
                bscon1 = "";
        }else{
            bscon1 = "X";
        }
        System.out.println(bscon);
        String nda = request.getParameter("nda");
        String nda1 ;
        if(nda == null ){
                nda1 = "";
        }else{
            nda1 = "X";
        }
        String asc = request.getParameter("asc");
        String asc1;
        if(asc == null ){
                asc1 = "";
        }else{
            asc1 = "X";
        }
        String aprvl = request.getParameter("aprvl");
        String aprvl1;
        if(aprvl == null ){
                aprvl1 = "";
        }else{
            aprvl1 = "X";
        }
        
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
//            String sqlad = "INSERT INTO Address (STREET1, STREET2, STREET3, CITY, STATE, CNTRY, PINCODE, PHONE1, PHONE2, FAXNO, EMAIL, LNGID, CREDT, CRETIM) VALUES ('"+str1+"', '"+str2+"', '"+str3+"', '"+city+"', '"+stat+"', '"+cntry+"', '"+pstl+"', '"+phn1+"', '"+phn2+"', '"+fax+"', '"+emil+"', '"+lang+"', CURDATE(), CURTIME());";
            String sqlbpm ="update Businesspartner_Master set CCOD = '"+ccod+"', BPDES = '"+bpdes+"', PAYTRMS = '"+paytm+"',"
                    + "FRMDT = '"+bpstdt+"', TODT = '"+bpendt+"', CNTRTYP = '"+contyp+"', BSCNTR = '"+bscon1+"', "+
                     "NDA = '"+nda1+"', ASCON = '"+asc1+"', APPRVL = '"+aprvl1+"' where BPNO = '"+bpmno+"';";
            cst = con.createStatement();
            int n1 = cst.executeUpdate(sqlbpm);
            if(n1 > 0){
                
                try{
                    con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                   String delallsql = "delete from agnieportal.Businesspartner_Item where BPNO = '"+bpmno+"';";
                   Statement delalstmt = con.createStatement();
                     int delall = delalstmt.executeUpdate(delallsql);
                     
                     if(delall > 0){
                         
                         int[] e1;
                    int e2 = 0;
                    try{
                     con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con.setAutoCommit(false);
                    String sqldtm= "SELECT * FROM Businesspartner_Master where BPNO = '"+bpmno+"'";
                    PreparedStatement pstdtm = con.prepareStatement(sqldtm);
                    ResultSet rsdtm = pstdtm.executeQuery();
                    while(rsdtm.next()){
                    bpdt = rsdtm.getString("CREDT");
                     bptm = rsdtm.getString("CRETIM");
                    
                    }
                    String sqlbpi ="INSERT INTO Businesspartner_Item (BPNO, BPITEM, BPID,BPNAME, UNIT, RATE, SELUNIT, "+
                     "SELRATE, CURR, BPTYP, MODUL, LNGID,PGMLANG,SAPEXP,ITEXP,CREDT, CRETIM) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                     PreparedStatement ps = con.prepareStatement(sqlbpi);
//                       Statement stmt = con.createStatement();
                    
                    for(int i = 0;i < bpitmno.length;i++){
                        
//                        
                      if(conid[i] != ""){
                          
                          System.out.println("["+conid[i]+"]");
                          
                         
//                          String sqlbpi ="update Businesspartner_Item set BPID = '"+conid[i]+"',BPNAME = '"+bpnam[i]+"', UNIT = '"+bpunit[i]+"', RATE = '"+bprate[i]+"', SELUNIT = '"+bpselunt[i]+"', "+
//                     "SELRATE = '"+bpselrat[i]+"', CURR = '"+bpcurr[i]+"', BPTYP = '"+bpconstyp[i]+"', MODUL = '"+bpmodu[i]+"', LNGID = '"+bpsplng[i]+"',"
//                                  + "PGMLANG = '"+bppmglng[i]+"',SAPEXP = '"+expsap[i]+"',ITEXP = '"+expit[i]+"' where BPNO = '"+bpmno+"' and BPITEM = '"+bpitmno[i]+"';";
                         ps.setString(1, bpmno);
                         ps.setString(2, bpitmno[i]);
                         ps.setString(3, conid[i]);
                         ps.setString(4, bpnam[i]);
                         ps.setString(5, bpunit[i]);
                         ps.setString(6, bprate[i]);
                         ps.setString(7, bpselunt[i]);
                         ps.setString(8, bpselrat[i]);
                         ps.setString(9, bpcurr[i]);
                         ps.setString(10, bpconstyp[i]);
                         ps.setString(11, bpmodu[i]);
                         ps.setString(12, bpsplng[i]);
                         ps.setString(13, bppmglng[i]);
                         ps.setString(14, expsap[i]);
                         ps.setString(15, expit[i]);
                         ps.setString(16, bpdt);
                         ps.setString(17, bptm);
                        
                        ps.addBatch();
//                          stmt.addBatch();
                        System.out.println(ps);
//                        e1 = ps.executeUpdate();
//                        con1.commit();
//                        e1 = ps.executeBatch();
//                        e2 = e2 + e1;                        
                       
                      }
                    }
                                        
                    
                         e1 = ps.executeBatch();
//                         processUpdateCounts(e1);            
                        con.commit();
                        System.out.println(e1.length);
                    if(e1.length > 0){
                        JOptionPane.showMessageDialog(null,"BP updated sucessfully");
                        
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                        
                        request.setAttribute("scrn",scrn);
                        request.setAttribute("weblng",weblng);
                        request.setAttribute("emnum",emnum);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                        rd.forward(request, response);
                        
                    }
                    }
                    catch(SQLException gx){
                JOptionPane.showMessageDialog(null,"Error: "+gx.getMessage());
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }  
                        
                        request.setAttribute("scrn",scrn);
                        request.setAttribute("weblng",weblng);
                        request.setAttribute("emnum",emnum);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                        rd.forward(request, response);
            }
                         
                     }
                     
                }
                catch(SQLException px){
                JOptionPane.showMessageDialog(null,"Error: "+px.getMessage());
//                
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  } 
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }
                        
                        request.setAttribute("scrn",scrn);
                        request.setAttribute("weblng",weblng);
                        request.setAttribute("emnum",emnum);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                        rd.forward(request, response);
            }       
                    
                }
                   
            }
        
        catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
                
                String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }  
                        
                        request.setAttribute("scrn",scrn);
                        request.setAttribute("weblng",weblng);
                        request.setAttribute("emnum",emnum);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                        rd.forward(request, response);
                
            }
        
        return null;
        
    }
    
    @RequestMapping(value="/delbpm")
    public ModelAndView delbpm(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String bpmno = request.getParameter("bpmno");
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
    
        String sql1= "select * from Field_Text where FLDID ='92'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String BPMM = rs1.getString("FLDTXT");
                request.setAttribute("BPMM",BPMM);
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
                  
                String sql6= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String TOLEDT = rs6.getString("FLDTXT");
                request.setAttribute("TOLEDT",TOLEDT);
                  }
                  
                String sql7= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String TOLGOTO = rs7.getString("FLDTXT");
                request.setAttribute("TOLGOTO",TOLGOTO);
                  }
                  
                String sql8= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String TOLENV = rs8.getString("FLDTXT");
                request.setAttribute("TOLENV",TOLENV);
                  }
                  
                String sql9= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String TOLSYS = rs9.getString("FLDTXT");
                request.setAttribute("TOLSYS",TOLSYS);
                  }
                  
                String sql10= "select * from Field_Text where FLDID ='93' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String BPNO = rs10.getString("FLDTXT");
                request.setAttribute("BPNO",BPNO);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String COMCD = rs11.getString("FLDTXT");
                request.setAttribute("COMCD",COMCD);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='08' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BSDT = rs12.getString("FLDTXT");
                request.setAttribute("BSDT",BSDT);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='94' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String BPDES = rs13.getString("FLDTXT");
                request.setAttribute("BPDES",BPDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='95' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PYTM = rs14.getString("FLDTXT");
                request.setAttribute("PYTM",PYTM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String BPSTDT = rs15.getString("FLDTXT");
                request.setAttribute("BPSTDT",BPSTDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String BPENDT = rs16.getString("FLDTXT");
                request.setAttribute("BPENDT",BPENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String CONTYP = rs17.getString("FLDTXT");
                request.setAttribute("CONTYP",CONTYP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='97' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BSCON = rs18.getString("FLDTXT");
                request.setAttribute("BSCON",BSCON);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='98' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String NDA = rs19.getString("FLDTXT");
                request.setAttribute("NDA",NDA);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='99' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ASC = rs20.getString("FLDTXT");
                request.setAttribute("ASC",ASC);
                  }
                  
                String sql21= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String ITMNO = rs21.getString("FLDTXT");
                request.setAttribute("ITMNO",ITMNO);
                  }
                
                String sql22= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTID = rs22.getString("FLDTXT");
                request.setAttribute("CNTID",CNTID);
                  }
                  
                String sql23= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String CNTNAM = rs23.getString("FLDTXT");
                request.setAttribute("CNTNAM",CNTNAM);
                  }
                
                String sql24= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String BPUNT = rs24.getString("FLDTXT");
                request.setAttribute("BPUNT",BPUNT);
                  }
                
                String sql25= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String BPRTE = rs25.getString("FLDTXT");
                request.setAttribute("BPRTE",BPRTE);
                  }
                  
                String sql26= "select * from Field_Text where FLDID ='103' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String BPSLUNT = rs26.getString("FLDTXT");
                request.setAttribute("BPSLUNT",BPSLUNT);
                  }
                  
                String sql27= "select * from Field_Text where FLDID ='104' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String BPSLRTE = rs27.getString("FLDTXT");
                request.setAttribute("BPSLRTE",BPSLRTE);
                  }
                  
                String sql28= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String CURRN = rs28.getString("FLDTXT");
                request.setAttribute("CURRN",CURRN);
                  }
                  
                String sql29= "select * from Field_Text where FLDID ='105' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String CNTTYP = rs29.getString("FLDTXT");
                request.setAttribute("CNTTYP",CNTTYP);
                  }
                  
                String sql30= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String MDUL = rs30.getString("FLDTXT");
                request.setAttribute("MDUL",MDUL);
                  }
                  
                String sql31= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String SPKLNG = rs31.getString("FLDTXT");
                request.setAttribute("SPKLNG",SPKLNG);
                  }
                  
                String sql32= "select * from Field_Text where FLDID ='53' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String PGLNG = rs32.getString("FLDTXT");
                request.setAttribute("PGLNG",PGLNG);
                  }
                  
                String sql33= "select * from Field_Text where FLDID ='54' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String SAPEX = rs33.getString("FLDTXT");
                request.setAttribute("SAPEX",SAPEX);
                  }
                  
                String sql34= "select * from Field_Text where FLDID ='55' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ITEX = rs34.getString("FLDTXT");
                request.setAttribute("ITEX",ITEX);
                  }
                  
                String sql35= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String ASDL = rs35.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql36= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ASLRW = rs36.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql37= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String DELFLG = rs37.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql38= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String DIYS = rs38.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql39= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String DINO = rs39.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }
                  
                String sql40= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String DDLT = rs40.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }
                  
                  request.setAttribute("scrn",scrn);
                        request.setAttribute("weblng",weblng);
                        request.setAttribute("emnum",emnum);
                        
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
              String sqldel = "update Businesspartner_Master set ACTFLG = 'X' where BPNO = '"+bpmno+"'";
            cst = con.createStatement();
            int d1 = cst.executeUpdate(sqldel);
            
            if(d1 > 0){
                String MSG1 = null, MSG2 = null;
                                String msg1= "select * from Message_Txt where MSGID ='08'and LNGID ='"+weblng+"'";
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
            
                 JOptionPane.showMessageDialog(null,MSG1+" "+bpmno+" "+MSG2);
                                                                          
                request.setAttribute("delet","DEL");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                rd.forward(request, response);
            
            }
            else{
            JOptionPane.showMessageDialog(null,"ERROR..! Please check your Input");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                rd.forward(request, response);
            }
            
            
        }
        catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
            
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                rd.forward(request, response);
        
        }
        }
        else{
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/businesspartner.jsp");
                rd.forward(request, response);
        
        }
        
        return mav;
        
    }
        
    
    
//    return null;        
//    }
    
    
    @RequestMapping(value="/backtohome2")
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
                  
                String sql8= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst8 = con.prepareStatement(sql8);
                ResultSet rs8 = pst8.executeQuery();
                  while(rs8.next()){
                String DDLT = rs8.getString("FLDTXT");
                request.setAttribute("DDLT",DDLT);
                  }
                
                                
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
        
        mav = new ModelAndView("emplist");
        
       
        return mav;
        
    }
    
    @RequestMapping(value="/deletbpitm")
    public ModelAndView deletitem(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        PrintWriter out = response.getWriter();
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
        String bpmno = request.getParameter("bpmno");
        String selchval = null;
        String[] bpitmno = request.getParameterValues("bpitm");
        String[] conid = request.getParameterValues("bpid");
        String[] selch = request.getParameterValues("selch");
        
//        out.println(selch.length);
        for(int i = 0;i < selch.length;i++){
          selchval = selch[i];   
          for(int j = 0;j < bpitmno.length;j++){
              out.println(bpitmno[j]);
            if(bpitmno[j].equals(selchval)){
                out.println(conid[j]);
            } 
                
          }     
        }
            
        
        
          return mav;
    }
    
    

    
    
}
