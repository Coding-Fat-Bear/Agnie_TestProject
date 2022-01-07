/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnie.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.activation.DataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Welcome
 */
@Controller
public class inquiry2 {
    
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
    @RequestMapping(value="/Inquiry",method = RequestMethod.POST)
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

        try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            pst = con.prepareStatement(sql); 
            rs=pst.executeQuery();
            while(rs.next()){
            dbunm = rs.getString("USERNAME");
            dbpwd = rs.getString("PASSWORD");
            emnum = rs.getInt("EMPCOD");
            System.out.println(dbunm);            
            }
            if(uname.equals(dbunm) && pass.equals(dbpwd) ){
                 
                System.out.println(emnum);
 String sql1= "select * from Field_Text where FLDID ='58'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String INQMS = rs1.getString("FLDTXT");
                request.setAttribute("INQMS",INQMS);
                }
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String INCRE = rs2.getString("FLDTXT");
                request.setAttribute("INCRE",INCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String INEDT = rs3.getString("FLDTXT");
                request.setAttribute("INEDT",INEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String INDIS = rs4.getString("FLDTXT");
                request.setAttribute("INDIS",INDIS);
                  }  
               String sql5= "select * from Field_Text where FLDID ='61' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String MENU = rs5.getString("FLDTXT");
                request.setAttribute("MENU",MENU);
                  }  
                   String sql6= "select * from Field_Text where FLDID ='66' and LNGID ='"+weblng+"'";
                PreparedStatement pst6 = con.prepareStatement(sql6);
                ResultSet rs6 = pst6.executeQuery();
                  while(rs6.next()){
                String HP = rs6.getString("FLDTXT");
                request.setAttribute("HP",HP);
                  }  
                 String sql7= "select * from Field_Text where FLDID ='06' and LNGID ='"+weblng+"'";
                PreparedStatement pst7 = con.prepareStatement(sql7);
                ResultSet rs7 = pst7.executeQuery();
                  while(rs7.next()){
                String EMPMS = rs7.getString("FLDTXT");
                request.setAttribute("EMPMS",EMPMS);
                  }                                  
                               
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
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
          
           
    
   
    @RequestMapping(value="/insertinq")
    public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
           String scrn = request.getParameter("scrn");
           String weblng = request.getParameter("weblng");
           con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
           String s1= "select * from Field_Text where FLDID ='58'and LNGID ='"+weblng+"'";
            PreparedStatement p1 = con.prepareStatement(s1);
                ResultSet r1 = p1.executeQuery();
                while(r1.next()){
                String INQMS = r1.getString("FLDTXT");
                request.setAttribute("INQMS",INQMS);
                }   
               String s2= "select * from Field_Text where FLDID ='02' and LNGID ='"+weblng+"'";
                PreparedStatement p2 = con.prepareStatement(s2);
                ResultSet r2 = p2.executeQuery();
                  while(r2.next()){
                String INQ = r2.getString("FLDTXT");
                request.setAttribute("INQ",INQ);
                  } 
              String s3= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement p3 = con.prepareStatement(s3);
                ResultSet r3 = p3.executeQuery();
                while(r3.next()){
                String INCRE = r3.getString("FLDTXT");
                request.setAttribute("INCRE",INCRE);
                }
                String s4= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement p4 = con.prepareStatement(s4);
                ResultSet r4 = p4.executeQuery();
                while(r4.next()){
                String INEDT = r4.getString("FLDTXT");
                request.setAttribute("INEDT",INEDT);
                }
                
                String s5= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement p5 = con.prepareStatement(s5);
                ResultSet r5 = p5.executeQuery();
                  while(r5.next()){
                String INDIS = r5.getString("FLDTXT");
                request.setAttribute("INDIS",INDIS);
                  }        
              String s6= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement p6 = con.prepareStatement(s6);
                ResultSet r6 = p6.executeQuery();
                  while(r6.next()){
                String CMPNY = r6.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
              String s7= "select * from Field_Text where FLDID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement p7 = con.prepareStatement(s7);
                ResultSet r7 = p7.executeQuery();
                  while(r7.next()){
                String INLST = r7.getString("FLDTXT");
                request.setAttribute("INLST",INLST);
                  }  
             String s8= "select * from Field_Text where FLDID ='01' and LNGID ='"+weblng+"'";
                PreparedStatement p8 = con.prepareStatement(s8);
                ResultSet r8 = p8.executeQuery();
                  while(r8.next()){
                String EMP = r8.getString("FLDTXT");
                request.setAttribute("EMP",EMP);
                  }    
                String s9= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement p9 = con.prepareStatement(s9);
                ResultSet r9 = p9.executeQuery();
                  while(r9.next()){
                String PRTXT = r9.getString("FLDTXT");
                request.setAttribute("PRTXT",PRTXT);
                  }             
             String s10= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement p10 = con.prepareStatement(s10);
                ResultSet r10 = p10.executeQuery();
                  while(r10.next()){
                String EXT = r10.getString("FLDTXT");
                request.setAttribute("EXT",EXT);
                  }
            String s11= "select * from Field_Text where FLDID ='62' and LNGID ='"+weblng+"'";
                PreparedStatement p11 = con.prepareStatement(s11);
                ResultSet r11 = p11.executeQuery();
                  while(r11.next()){
                String D1 = r11.getString("FLDTXT");
                request.setAttribute("D1",D1);
                  }       
            String s12= "select * from Field_Text where FLDID ='63' and LNGID ='"+weblng+"'";
                PreparedStatement p12 = con.prepareStatement(s12);
                ResultSet r12 = p12.executeQuery();
                  while(r12.next()){
                String D2 = r12.getString("FLDTXT");
                request.setAttribute("D2",D2);
                  }              
            String s13= "select * from Field_Text where FLDID ='64' and LNGID ='"+weblng+"'";
                PreparedStatement p13 = con.prepareStatement(s13);
                ResultSet r13= p13.executeQuery();
                  while(r13.next()){
                String EST = r13.getString("FLDTXT");
                request.setAttribute("EST",EST);
                  }  
             String s14= "select * from Field_Text where FLDID ='65' and LNGID ='"+weblng+"'";
                PreparedStatement p14 = con.prepareStatement(s14);
                ResultSet r14 = p14.executeQuery();
                  while(r14.next()){
                String ORGD = r14.getString("FLDTXT");
                request.setAttribute("ORGD",ORGD);
                  }
            String s15= "select * from Field_Text where FLDID ='68' and LNGID ='"+weblng+"'";
                PreparedStatement p15 = con.prepareStatement(s15);
                ResultSet r15 = p15.executeQuery();
                  while(r15.next()){
                String ASSN = r15.getString("FLDTXT");
                request.setAttribute("ASSN",ASSN);
                  }
           String s16= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement p16 = con.prepareStatement(s16);
                ResultSet r16 = p16.executeQuery();
                  while(r16.next()){
                String STDT = r16.getString("FLDTXT");
                request.setAttribute("STDT",STDT);
                  } 
          String s17= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement p17 = con.prepareStatement(s17);
                ResultSet r17 = p17.executeQuery();
                  while(r17.next()){
                String ENDT = r17.getString("FLDTXT");
                request.setAttribute("ENDT",ENDT);
                  } 
         String s18= "select * from Field_Text where FLDID ='71' and LNGID ='"+weblng+"'";
                PreparedStatement p18 = con.prepareStatement(s18);
                ResultSet r18 = p18.executeQuery();
                  while(r18.next()){
                String POSB = r18.getString("FLDTXT");
                request.setAttribute("POSB",POSB);
                  }  
         String s19= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement p19 = con.prepareStatement(s19);
                ResultSet r19 = p19.executeQuery();
                  while(r19.next()){
                String BZLN = r19.getString("FLDTXT");
                request.setAttribute("BZLN",BZLN);
                  } 
         String s20= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement p20 = con.prepareStatement(s20);
                ResultSet r20 = p20.executeQuery();
                  while(r20.next()){
                String LNG = r20.getString("FLDTXT");
                request.setAttribute("LNG",LNG);
                  } 
         String s21= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement p21 = con.prepareStatement(s21);
                ResultSet r21 = p21.executeQuery();
                  while(r21.next()){
                String MOD = r21.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                  }        
         String s22= "select * from Field_Text where FLDID ='72' and LNGID ='"+weblng+"'";
                PreparedStatement p22 = con.prepareStatement(s22);
                ResultSet r22 = p22.executeQuery();
                  while(r22.next()){
                String STAT = r22.getString("FLDTXT");
                request.setAttribute("STAT",STAT);
                  }   
         String s23= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement p23 = con.prepareStatement(s23);
                ResultSet r23 = p23.executeQuery();
                  while(r23.next()){
                String PHAS = r23.getString("FLDTXT");
                request.setAttribute("PHAS",PHAS);
                  }    
         String s24= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement p24 = con.prepareStatement(s24);
                ResultSet r24 = p24.executeQuery();
                  while(r24.next()){
                String ESTA = r24.getString("FLDTXT");
                request.setAttribute("ESTA",ESTA);
                  }  
         String s25= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement p25 = con.prepareStatement(s25);
                ResultSet r25 = p25.executeQuery();
                  while(r25.next()){
                String CUR = r25.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
         String s26= "select * from Field_Text where FLDID ='76' and LNGID ='"+weblng+"'";
                PreparedStatement p26 = con.prepareStatement(s26);
                ResultSet r26 = p26.executeQuery();
                  while(r26.next()){
                String TAX = r26.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  } 
         String s27= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement p27 = con.prepareStatement(s27);
                ResultSet r27 = p27.executeQuery();
                  while(r27.next()){
                String QNTY = r27.getString("FLDTXT");
                request.setAttribute("QNTY",QNTY);
                  }
         String s28= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement p28 = con.prepareStatement(s28);
                ResultSet r28 = p28.executeQuery();
                  while(r28.next()){
                String RTE = r28.getString("FLDTXT");
                request.setAttribute("RTE",RTE);
                  }
         String s29= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement p29 = con.prepareStatement(s29);
                ResultSet r29 = p29.executeQuery();
                  while(r29.next()){
                String UNT = r29.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
         String s30= "select * from Field_Text where FLDID ='80' and LNGID ='"+weblng+"'";
                PreparedStatement p30 = con.prepareStatement(s30);
                ResultSet r30 = p30.executeQuery();
                  while(r30.next()){
                String CUST = r30.getString("FLDTXT");
                request.setAttribute("CUST",CUST);
                  }
         String s31= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement p31 = con.prepareStatement(s31);
                ResultSet r31 = p31.executeQuery();
                  while(r31.next()){
                String EUSR = r31.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  } 
         String s32= "select * from Field_Text where FLDID ='82' and LNGID ='"+weblng+"'";
                PreparedStatement p32 = con.prepareStatement(s32);
                ResultSet r32 = p32.executeQuery();
                  while(r32.next()){
                String CINFO = r32.getString("FLDTXT");
                request.setAttribute("CINFO",CINFO);
                  }   
         String s33= "select * from Field_Text where FLDID ='83' and LNGID ='"+weblng+"'";
                PreparedStatement p33 = con.prepareStatement(s33);
                ResultSet r33 = p33.executeQuery();
                  while(r33.next()){
                String RMKS = r33.getString("FLDTXT");
                request.setAttribute("RMKS",RMKS);
                  } 
         String s34= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement p34 = con.prepareStatement(s34);
                ResultSet r34 = p34.executeQuery();
                  while(r34.next()){
                String EDT = r34.getString("FLDTXT");
                request.setAttribute("EDT",EDT);
                  } 
         String s35= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement p35 = con.prepareStatement(s35);
                ResultSet r35 = p35.executeQuery();
                  while(r35.next()){
                String GOTO = r35.getString("FLDTXT");
                request.setAttribute("GOTO",GOTO);
                  } 
         String s36= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement p36 = con.prepareStatement(s36);
                ResultSet r36 = p36.executeQuery();
                  while(r36.next()){
                String ENV = r36.getString("FLDTXT");
                request.setAttribute("ENV",ENV);
                  } 
         String s37= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement p37 = con.prepareStatement(s37);
                ResultSet r37 = p37.executeQuery();
                  while(r37.next()){
                String SYS = r37.getString("FLDTXT");
                request.setAttribute("SYS",SYS);
                  } 
         String s38= "select * from Field_Text where FLDID ='88' and LNGID ='"+weblng+"'";
                PreparedStatement p38 = con.prepareStatement(s38);
                ResultSet r38 = p38.executeQuery();
                  while(r38.next()){
                String SAV = r38.getString("FLDTXT");
                request.setAttribute("SAV",SAV);
                  }   
         String s39= "select * from Field_Text where FLDID ='89' and LNGID ='"+weblng+"'";
                PreparedStatement p39 = con.prepareStatement(s39);
                ResultSet r39 = p39.executeQuery();
                  while(r39.next()){
                String UPD = r39.getString("FLDTXT");
                request.setAttribute("UPD",UPD);
                  }   
         String s40= "select * from Field_Text where FLDID ='90' and LNGID ='"+weblng+"'";
                PreparedStatement p40 = con.prepareStatement(s40);
                ResultSet r40 = p40.executeQuery();
                  while(r40.next()){
                String DLT = r40.getString("FLDTXT");
                request.setAttribute("DLT",DLT);
                  }   
         String s41= "select * from Field_Text where FLDID ='91' and LNGID ='"+weblng+"'";
                PreparedStatement p41 = con.prepareStatement(s41);
                ResultSet r41 = p41.executeQuery();
                  while(r41.next()){
                String GET = r41.getString("FLDTXT");
                request.setAttribute("GET",GET);
                  }             
          request.setAttribute("weblng",weblng);

            ModelAndView mav = null;
            String inqno = request.getParameter("inqno");
            String ccod = request.getParameter("ccod");
            String empno = request.getParameter("empno");
            String assnper = request.getParameter("assnper");
            String bizid = request.getParameter("bizid");
            String modul = request.getParameter("modul");
            String lngid = request.getParameter("lngid");
            String frmdt = request.getParameter("frmdt");
            String todt = request.getParameter("todt");
            String posbper = request.getParameter("posbper");
            String prjdes = request.getParameter("prjdes");
            String status = request.getParameter("status");
            String phaseid = request.getParameter("phaseid");
            String estamt = request.getParameter("estamt");
            String curr = request.getParameter("curr");
            String taxamt = request.getParameter("taxamt");
            String qty = request.getParameter("qty");
            String rate = request.getParameter("rate");
            String unit = request.getParameter("unit");
            String custno = request.getParameter("custno");
            String eusrno = request.getParameter("eusrno");
            String custinfo = request.getParameter("custinfo");
            String remarks = request.getParameter("remarks");
   //         String credt = request.getParameter("credt");
  //          String cretim = request.getParameter("cretim");
                    
                    try{
                    con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    
                    String sqlinq = "INSERT INTO Inquiry (CCOD, EMPNO, ASSNPER, BIZID, MODUL, LNGID, FRMDT, TODT, POSBPER, PRJDES, PRJSTS, PHASEID, ESTAMT, CURR, TAXAMT, QTY, RATE, UNIT, CUSTNO, EUSRNO, CUSTINFO, REMARKS, CREDT, CRETIM) VALUES ('"+ccod+"', '"+empno+"', '"+assnper+"', '"+bizid+"', '"+modul+"', '"+lngid+"', '"+frmdt+"', '"+todt+"', '"+posbper+"', '"+prjdes+"','"+status+"','"+phaseid+"', '"+estamt+"', '"+curr+"', '"+taxamt+"', '"+qty+"', '"+rate+"', '"+unit+"', '"+custno+"', '"+eusrno+"', '"+custinfo+"', '"+remarks+"', CURDATE(), CURTIME())";
                    
                    cst = con.createStatement();
                    int e1 = cst.executeUpdate(sqlinq);
                    if(e1 > 0){
                        System.out.println("Successfully created Inquiry");
                        try{
                            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String sqlinqno = "SELECT max(INQNO) as inq FROM Inquiry;";
//                        String sqlinqno = "INSERT INTO Inquiry (CCOD, EMPNO, ASSNPER, BIZID, MODUL, LNGID, FRMDT, TODT, POSBPER, PRJDES, STATUS, PHASEID, ESTAMT, CURR, TAXAMT, QTY, RATE, UNIT, CUSTNO, EUSRNO, CUSTINFO, REMARKS, CREDT, CRETIM) VALUES ('"+ccod+"', '"+empno+"', '"+assnper+"', '"+bizid+"', '"+modul+"', '"+lngid+"', '"+frmdt+"', '"+todt+"', '"+posbper+"', '"+prjdes+"','"+status+"','"+phaseid+"', '"+estamt+"', '"+curr+"', '"+taxamt+"', '"+qty+"', '"+rate+"', '"+unit+"', '"+custno+"', '"+eusrno+"', '"+custinfo+"', '"+remarks+"', CURDATE(), CURTIME();";
                            pst = con.prepareStatement(sqlinqno);
                            ss=pst.executeQuery();
                            while(ss.next()){
                                
                               String inq = ss.getString("inq");
                                request.setAttribute("appnm","1");
                                request.setAttribute("inqno",inq);
                           //     request.setAttribute("addno",addno);
                                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/inquiryview.jsp");
                                rd.forward(request, response);
//                                login2 call = new login2();
                                
                                System.out.println("Successfully created inquiry"+inqno);
                               
                            }
                        
                        }
                        catch(SQLException hx){
                            System.out.println(hx.getMessage());
//                        request.setAttribute("err","ERR");
//                        request.setAttribute("mes",hx.getMessage());
//                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//                        rd.forward(request, response);
                            mav = new ModelAndView("inquiryview");
                    }
                                            
                    }
                    
                    }

            catch(SQLException ex){
//                request.setAttribute("err","ERR");
//                        request.setAttribute("mes",ex.getMessage());
//                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//                        rd.forward(request, response);
                System.out.println(ex.getMessage());
                mav = new ModelAndView("inquiryview");
            }
            
        return mav;
    } 
    
    
    @RequestMapping(value="/getinq")
    public ModelAndView getemp(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        String inqno = request.getParameter("inqno");
         String scrn = request.getParameter("scrn");
        System.out.println("get is working fine"+inqno);
           String weblng = request.getParameter("weblng");  
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
             Class.forName("com.mysql.cj.jdbc.Driver");
             String s1= "select * from Field_Text where FLDID ='58'and LNGID ='"+weblng+"'";
            PreparedStatement p1 = con.prepareStatement(s1);
                ResultSet r1 = p1.executeQuery();
                while(r1.next()){
                String INQMS = r1.getString("FLDTXT");
                request.setAttribute("INQMS",INQMS);
                }   
               String s2= "select * from Field_Text where FLDID ='02' and LNGID ='"+weblng+"'";
                PreparedStatement p2 = con.prepareStatement(s2);
                ResultSet r2 = p2.executeQuery();
                  while(r2.next()){
                String INQ = r2.getString("FLDTXT");
                request.setAttribute("INQ",INQ);
                  } 
              String s3= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement p3 = con.prepareStatement(s3);
                ResultSet r3 = p3.executeQuery();
                while(r3.next()){
                String INCRE = r3.getString("FLDTXT");
                request.setAttribute("INCRE",INCRE);
                }
                String s4= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement p4 = con.prepareStatement(s4);
                ResultSet r4 = p4.executeQuery();
                while(r4.next()){
                String INEDT = r4.getString("FLDTXT");
                request.setAttribute("INEDT",INEDT);
                }
                
                String s5= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement p5 = con.prepareStatement(s5);
                ResultSet r5 = p5.executeQuery();
                  while(r5.next()){
                String INDIS = r5.getString("FLDTXT");
                request.setAttribute("INDIS",INDIS);
                  }        
              String s6= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement p6 = con.prepareStatement(s6);
                ResultSet r6 = p6.executeQuery();
                  while(r6.next()){
                String CMPNY = r6.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
              String s7= "select * from Field_Text where FLDID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement p7 = con.prepareStatement(s7);
                ResultSet r7 = p7.executeQuery();
                  while(r7.next()){
                String INLST = r7.getString("FLDTXT");
                request.setAttribute("INLST",INLST);
                  }  
             String s8= "select * from Field_Text where FLDID ='01' and LNGID ='"+weblng+"'";
                PreparedStatement p8 = con.prepareStatement(s8);
                ResultSet r8 = p8.executeQuery();
                  while(r8.next()){
                String EMP = r8.getString("FLDTXT");
                request.setAttribute("EMP",EMP);
                  }    
                String s9= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement p9 = con.prepareStatement(s9);
                ResultSet r9 = p9.executeQuery();
                  while(r9.next()){
                String PRTXT = r9.getString("FLDTXT");
                request.setAttribute("PRTXT",PRTXT);
                  }             
             String s10= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement p10 = con.prepareStatement(s10);
                ResultSet r10 = p10.executeQuery();
                  while(r10.next()){
                String EXT = r10.getString("FLDTXT");
                request.setAttribute("EXT",EXT);
                  }
            String s11= "select * from Field_Text where FLDID ='62' and LNGID ='"+weblng+"'";
                PreparedStatement p11 = con.prepareStatement(s11);
                ResultSet r11 = p11.executeQuery();
                  while(r11.next()){
                String D1 = r11.getString("FLDTXT");
                request.setAttribute("D1",D1);
                  }       
            String s12= "select * from Field_Text where FLDID ='63' and LNGID ='"+weblng+"'";
                PreparedStatement p12 = con.prepareStatement(s12);
                ResultSet r12 = p12.executeQuery();
                  while(r12.next()){
                String D2 = r12.getString("FLDTXT");
                request.setAttribute("D2",D2);
                  }              
            String s13= "select * from Field_Text where FLDID ='64' and LNGID ='"+weblng+"'";
                PreparedStatement p13 = con.prepareStatement(s13);
                ResultSet r13= p13.executeQuery();
                  while(r13.next()){
                String EST = r13.getString("FLDTXT");
                request.setAttribute("EST",EST);
                  }  
             String s14= "select * from Field_Text where FLDID ='65' and LNGID ='"+weblng+"'";
                PreparedStatement p14 = con.prepareStatement(s14);
                ResultSet r14 = p14.executeQuery();
                  while(r14.next()){
                String ORGD = r14.getString("FLDTXT");
                request.setAttribute("ORGD",ORGD);
                  }
            String s15= "select * from Field_Text where FLDID ='68' and LNGID ='"+weblng+"'";
                PreparedStatement p15 = con.prepareStatement(s15);
                ResultSet r15 = p15.executeQuery();
                  while(r15.next()){
                String ASSN = r15.getString("FLDTXT");
                request.setAttribute("ASSN",ASSN);
                  }
           String s16= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement p16 = con.prepareStatement(s16);
                ResultSet r16 = p16.executeQuery();
                  while(r16.next()){
                String STDT = r16.getString("FLDTXT");
                request.setAttribute("STDT",STDT);
                  } 
          String s17= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement p17 = con.prepareStatement(s17);
                ResultSet r17 = p17.executeQuery();
                  while(r17.next()){
                String ENDT = r17.getString("FLDTXT");
                request.setAttribute("ENDT",ENDT);
                  } 
         String s18= "select * from Field_Text where FLDID ='71' and LNGID ='"+weblng+"'";
                PreparedStatement p18 = con.prepareStatement(s18);
                ResultSet r18 = p18.executeQuery();
                  while(r18.next()){
                String POSB = r18.getString("FLDTXT");
                request.setAttribute("POSB",POSB);
                  }  
         String s19= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement p19 = con.prepareStatement(s19);
                ResultSet r19 = p19.executeQuery();
                  while(r19.next()){
                String BZLN = r19.getString("FLDTXT");
                request.setAttribute("BZLN",BZLN);
                  } 
         String s20= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement p20 = con.prepareStatement(s20);
                ResultSet r20 = p20.executeQuery();
                  while(r20.next()){
                String LNG = r20.getString("FLDTXT");
                request.setAttribute("LNG",LNG);
                  } 
         String s21= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement p21 = con.prepareStatement(s21);
                ResultSet r21 = p21.executeQuery();
                  while(r21.next()){
                String MOD = r21.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                  }        
         String s22= "select * from Field_Text where FLDID ='72' and LNGID ='"+weblng+"'";
                PreparedStatement p22 = con.prepareStatement(s22);
                ResultSet r22 = p22.executeQuery();
                  while(r22.next()){
                String STAT = r22.getString("FLDTXT");
                request.setAttribute("STAT",STAT);
                  }   
         String s23= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement p23 = con.prepareStatement(s23);
                ResultSet r23 = p23.executeQuery();
                  while(r23.next()){
                String PHAS = r23.getString("FLDTXT");
                request.setAttribute("PHAS",PHAS);
                  }    
         String s24= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement p24 = con.prepareStatement(s24);
                ResultSet r24 = p24.executeQuery();
                  while(r24.next()){
                String ESTA = r24.getString("FLDTXT");
                request.setAttribute("ESTA",ESTA);
                  }  
         String s25= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement p25 = con.prepareStatement(s25);
                ResultSet r25 = p25.executeQuery();
                  while(r25.next()){
                String CUR = r25.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
         String s26= "select * from Field_Text where FLDID ='76' and LNGID ='"+weblng+"'";
                PreparedStatement p26 = con.prepareStatement(s26);
                ResultSet r26 = p26.executeQuery();
                  while(r26.next()){
                String TAX = r26.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  } 
         String s27= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement p27 = con.prepareStatement(s27);
                ResultSet r27 = p27.executeQuery();
                  while(r27.next()){
                String QNTY = r27.getString("FLDTXT");
                request.setAttribute("QNTY",QNTY);
                  }
         String s28= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement p28 = con.prepareStatement(s28);
                ResultSet r28 = p28.executeQuery();
                  while(r28.next()){
                String RTE = r28.getString("FLDTXT");
                request.setAttribute("RTE",RTE);
                  }
         String s29= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement p29 = con.prepareStatement(s29);
                ResultSet r29 = p29.executeQuery();
                  while(r29.next()){
                String UNT = r29.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
         String s30= "select * from Field_Text where FLDID ='80' and LNGID ='"+weblng+"'";
                PreparedStatement p30 = con.prepareStatement(s30);
                ResultSet r30 = p30.executeQuery();
                  while(r30.next()){
                String CUST = r30.getString("FLDTXT");
                request.setAttribute("CUST",CUST);
                  }
         String s31= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement p31 = con.prepareStatement(s31);
                ResultSet r31 = p31.executeQuery();
                  while(r31.next()){
                String EUSR = r31.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  } 
         String s32= "select * from Field_Text where FLDID ='82' and LNGID ='"+weblng+"'";
                PreparedStatement p32 = con.prepareStatement(s32);
                ResultSet r32 = p32.executeQuery();
                  while(r32.next()){
                String CINFO = r32.getString("FLDTXT");
                request.setAttribute("CINFO",CINFO);
                  }   
         String s33= "select * from Field_Text where FLDID ='83' and LNGID ='"+weblng+"'";
                PreparedStatement p33 = con.prepareStatement(s33);
                ResultSet r33 = p33.executeQuery();
                  while(r33.next()){
                String RMKS = r33.getString("FLDTXT");
                request.setAttribute("RMKS",RMKS);
                  } 
         String s34= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement p34 = con.prepareStatement(s34);
                ResultSet r34 = p34.executeQuery();
                  while(r34.next()){
                String EDT = r34.getString("FLDTXT");
                request.setAttribute("EDT",EDT);
                  } 
         String s35= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement p35 = con.prepareStatement(s35);
                ResultSet r35 = p35.executeQuery();
                  while(r35.next()){
                String GOTO = r35.getString("FLDTXT");
                request.setAttribute("GOTO",GOTO);
                  } 
         String s36= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement p36 = con.prepareStatement(s36);
                ResultSet r36 = p36.executeQuery();
                  while(r36.next()){
                String ENV = r36.getString("FLDTXT");
                request.setAttribute("ENV",ENV);
                  } 
         String s37= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement p37 = con.prepareStatement(s37);
                ResultSet r37 = p37.executeQuery();
                  while(r37.next()){
                String SYS = r37.getString("FLDTXT");
                request.setAttribute("SYS",SYS);
                  } 
         String s38= "select * from Field_Text where FLDID ='88' and LNGID ='"+weblng+"'";
                PreparedStatement p38 = con.prepareStatement(s38);
                ResultSet r38 = p38.executeQuery();
                  while(r38.next()){
                String SAV = r38.getString("FLDTXT");
                request.setAttribute("SAV",SAV);
                  }   
         String s39= "select * from Field_Text where FLDID ='89' and LNGID ='"+weblng+"'";
                PreparedStatement p39 = con.prepareStatement(s39);
                ResultSet r39 = p39.executeQuery();
                  while(r39.next()){
                String UPD = r39.getString("FLDTXT");
                request.setAttribute("UPD",UPD);
                  }   
         String s40= "select * from Field_Text where FLDID ='90' and LNGID ='"+weblng+"'";
                PreparedStatement p40 = con.prepareStatement(s40);
                ResultSet r40 = p40.executeQuery();
                  while(r40.next()){
                String DLT = r40.getString("FLDTXT");
                request.setAttribute("DLT",DLT);
                  }   
         String s41= "select * from Field_Text where FLDID ='91' and LNGID ='"+weblng+"'";
                PreparedStatement p41 = con.prepareStatement(s41);
                ResultSet r41 = p41.executeQuery();
                  while(r41.next()){
                String GET = r41.getString("FLDTXT");
                request.setAttribute("GET",GET);
                  }             
          request.setAttribute("weblng",weblng);

        ModelAndView mav = null;
        
        try{
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
//        String sqlget = "SELECT * FROM Employee_Master where EMPCOD = '"+empid+"';";
        String sqlget = "SELECT * FROM Inquiry where INQNO = '"+inqno+"' ;";
        pst = con.prepareStatement(sqlget);
        ss=pst.executeQuery();
        
        while(ss.next()){
            
            String inqno1 = ss.getString("INQNO");
            String ccod = ss.getString("CCOD");
            String empno = ss.getString("EMPNO");
            String assnper = ss.getString("ASSNPER");
            String bizid = ss.getString("BIZID");
            String modul = ss.getString("MODUL");
            String lngid = ss.getString("LNGID");
            String frmdt = ss.getString("FRMDT");            
            String todt = ss.getString("TODT");
            String posbper = ss.getString("POSBPER");
            String prjdes = ss.getString("PRJDES");
            String status = ss.getString("PRJSTS");
            String phaseid = ss.getString("PHASEID");
            String estamt = ss.getString("ESTAMT");
            String curr = ss.getString("CURR");
            String taxamt = ss.getString("TAXAMT");
            String qty = ss.getString("QTY");
            String rate = ss.getString("RATE");
            String unit = ss.getString("UNIT");
            String custno = ss.getString("CUSTNO");
            String eusrno = ss.getString("EUSRNO");
            String custinfo = ss.getString("CUSTINFO");
            String remarks = ss.getString("REMARKS");

            
          request.setAttribute("getnm","2");
          request.setAttribute("inqno1", inqno1);
          request.setAttribute("ccod", ccod);
          request.setAttribute("empno", empno);          
          request.setAttribute("assnper", assnper);          
          request.setAttribute("bizid", bizid);                    
          request.setAttribute("modul", modul);
          request.setAttribute("lngid", lngid);
          request.setAttribute("frmdt", frmdt);
          request.setAttribute("todt", todt);
          request.setAttribute("posbper", posbper);
          request.setAttribute("prjdes", prjdes);
          request.setAttribute("status", status);
          request.setAttribute("phaseid", phaseid);
          request.setAttribute("estamt", estamt);
          request.setAttribute("curr", curr);
          request.setAttribute("taxamt", taxamt);
          request.setAttribute("qty", qty);
          request.setAttribute("rate", rate);
          request.setAttribute("unit", unit);
          request.setAttribute("custno", custno);
          request.setAttribute("eusrno", eusrno);
          request.setAttribute("custinfo", custinfo);
          request.setAttribute("remarks", remarks);
           request.setAttribute("scrn", scrn); 
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/inquiryview.jsp");
          rd.forward(request, response);   
        
        }
        
        }
        catch(SQLException ex){
//            request.setAttribute("err","ERR");
//            request.setAttribute("mes",ex.getMessage());
//            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//            rd.forward(request, response);
            System.out.println(ex.getMessage());
            mav = new ModelAndView("inquiryview");
        }
        return mav;    
    }
    
    
   @RequestMapping(value="/delinq")
    public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String inqno = request.getParameter("inqno");
    
        try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqldel = "Delete from Inquiry where INQNO = '"+inqno+"';";
            cst = con.createStatement();
            int d1 = cst.executeUpdate(sqldel);
            
            if(d1 > 0){
            
                
//                login2.this.showLogin(request, response);
                request.setAttribute("delet","DEL");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/inquiryview.jsp");
                rd.forward(request, response);
            
            }
            
            
        }
        catch(SQLException ex){
            
//            request.setAttribute("err","ERR");
//            request.setAttribute("mes",ex.getMessage());
//            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//            rd.forward(request, response);
            System.out.println(ex.getMessage());
            mav = new ModelAndView("inquiryview");
        
        }          
             return mav;
    } 
    

    @RequestMapping(value="/updtinq")
    public ModelAndView update(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            String scrn = request.getParameter("scrn");
            String weblng = request.getParameter("weblng");  
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
             Class.forName("com.mysql.cj.jdbc.Driver");
             String s1= "select * from Field_Text where FLDID ='58'and LNGID ='"+weblng+"'";
            PreparedStatement p1 = con.prepareStatement(s1);
                ResultSet r1 = p1.executeQuery();
                while(r1.next()){
                String INQMS = r1.getString("FLDTXT");
                request.setAttribute("INQMS",INQMS);
                }   
               String s2= "select * from Field_Text where FLDID ='02' and LNGID ='"+weblng+"'";
                PreparedStatement p2 = con.prepareStatement(s2);
                ResultSet r2 = p2.executeQuery();
                  while(r2.next()){
                String INQ = r2.getString("FLDTXT");
                request.setAttribute("INQ",INQ);
                  } 
              String s3= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement p3 = con.prepareStatement(s3);
                ResultSet r3 = p3.executeQuery();
                while(r3.next()){
                String INCRE = r3.getString("FLDTXT");
                request.setAttribute("INCRE",INCRE);
                }
                String s4= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement p4 = con.prepareStatement(s4);
                ResultSet r4 = p4.executeQuery();
                while(r4.next()){
                String INEDT = r4.getString("FLDTXT");
                request.setAttribute("INEDT",INEDT);
                }
                
                String s5= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement p5 = con.prepareStatement(s5);
                ResultSet r5 = p5.executeQuery();
                  while(r5.next()){
                String INDIS = r5.getString("FLDTXT");
                request.setAttribute("INDIS",INDIS);
                  }        
              String s6= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement p6 = con.prepareStatement(s6);
                ResultSet r6 = p6.executeQuery();
                  while(r6.next()){
                String CMPNY = r6.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
              String s7= "select * from Field_Text where FLDID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement p7 = con.prepareStatement(s7);
                ResultSet r7 = p7.executeQuery();
                  while(r7.next()){
                String INLST = r7.getString("FLDTXT");
                request.setAttribute("INLST",INLST);
                  }  
             String s8= "select * from Field_Text where FLDID ='01' and LNGID ='"+weblng+"'";
                PreparedStatement p8 = con.prepareStatement(s8);
                ResultSet r8 = p8.executeQuery();
                  while(r8.next()){
                String EMP = r8.getString("FLDTXT");
                request.setAttribute("EMP",EMP);
                  }    
                String s9= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement p9 = con.prepareStatement(s9);
                ResultSet r9 = p9.executeQuery();
                  while(r9.next()){
                String PRTXT = r9.getString("FLDTXT");
                request.setAttribute("PRTXT",PRTXT);
                  }             
             String s10= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement p10 = con.prepareStatement(s10);
                ResultSet r10 = p10.executeQuery();
                  while(r10.next()){
                String EXT = r10.getString("FLDTXT");
                request.setAttribute("EXT",EXT);
                  }
            String s11= "select * from Field_Text where FLDID ='62' and LNGID ='"+weblng+"'";
                PreparedStatement p11 = con.prepareStatement(s11);
                ResultSet r11 = p11.executeQuery();
                  while(r11.next()){
                String D1 = r11.getString("FLDTXT");
                request.setAttribute("D1",D1);
                  }       
            String s12= "select * from Field_Text where FLDID ='63' and LNGID ='"+weblng+"'";
                PreparedStatement p12 = con.prepareStatement(s12);
                ResultSet r12 = p12.executeQuery();
                  while(r12.next()){
                String D2 = r12.getString("FLDTXT");
                request.setAttribute("D2",D2);
                  }              
            String s13= "select * from Field_Text where FLDID ='64' and LNGID ='"+weblng+"'";
                PreparedStatement p13 = con.prepareStatement(s13);
                ResultSet r13= p13.executeQuery();
                  while(r13.next()){
                String EST = r13.getString("FLDTXT");
                request.setAttribute("EST",EST);
                  }  
             String s14= "select * from Field_Text where FLDID ='65' and LNGID ='"+weblng+"'";
                PreparedStatement p14 = con.prepareStatement(s14);
                ResultSet r14 = p14.executeQuery();
                  while(r14.next()){
                String ORGD = r14.getString("FLDTXT");
                request.setAttribute("ORGD",ORGD);
                  }
            String s15= "select * from Field_Text where FLDID ='68' and LNGID ='"+weblng+"'";
                PreparedStatement p15 = con.prepareStatement(s15);
                ResultSet r15 = p15.executeQuery();
                  while(r15.next()){
                String ASSN = r15.getString("FLDTXT");
                request.setAttribute("ASSN",ASSN);
                  }
           String s16= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement p16 = con.prepareStatement(s16);
                ResultSet r16 = p16.executeQuery();
                  while(r16.next()){
                String STDT = r16.getString("FLDTXT");
                request.setAttribute("STDT",STDT);
                  } 
          String s17= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement p17 = con.prepareStatement(s17);
                ResultSet r17 = p17.executeQuery();
                  while(r17.next()){
                String ENDT = r17.getString("FLDTXT");
                request.setAttribute("ENDT",ENDT);
                  } 
         String s18= "select * from Field_Text where FLDID ='71' and LNGID ='"+weblng+"'";
                PreparedStatement p18 = con.prepareStatement(s18);
                ResultSet r18 = p18.executeQuery();
                  while(r18.next()){
                String POSB = r18.getString("FLDTXT");
                request.setAttribute("POSB",POSB);
                  }  
         String s19= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement p19 = con.prepareStatement(s19);
                ResultSet r19 = p19.executeQuery();
                  while(r19.next()){
                String BZLN = r19.getString("FLDTXT");
                request.setAttribute("BZLN",BZLN);
                  } 
         String s20= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement p20 = con.prepareStatement(s20);
                ResultSet r20 = p20.executeQuery();
                  while(r20.next()){
                String LNG = r20.getString("FLDTXT");
                request.setAttribute("LNG",LNG);
                  } 
         String s21= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement p21 = con.prepareStatement(s21);
                ResultSet r21 = p21.executeQuery();
                  while(r21.next()){
                String MOD = r21.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                  }        
         String s22= "select * from Field_Text where FLDID ='72' and LNGID ='"+weblng+"'";
                PreparedStatement p22 = con.prepareStatement(s22);
                ResultSet r22 = p22.executeQuery();
                  while(r22.next()){
                String STAT = r22.getString("FLDTXT");
                request.setAttribute("STAT",STAT);
                  }   
         String s23= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement p23 = con.prepareStatement(s23);
                ResultSet r23 = p23.executeQuery();
                  while(r23.next()){
                String PHAS = r23.getString("FLDTXT");
                request.setAttribute("PHAS",PHAS);
                  }    
         String s24= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement p24 = con.prepareStatement(s24);
                ResultSet r24 = p24.executeQuery();
                  while(r24.next()){
                String ESTA = r24.getString("FLDTXT");
                request.setAttribute("ESTA",ESTA);
                  }  
         String s25= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement p25 = con.prepareStatement(s25);
                ResultSet r25 = p25.executeQuery();
                  while(r25.next()){
                String CUR = r25.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
         String s26= "select * from Field_Text where FLDID ='76' and LNGID ='"+weblng+"'";
                PreparedStatement p26 = con.prepareStatement(s26);
                ResultSet r26 = p26.executeQuery();
                  while(r26.next()){
                String TAX = r26.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  } 
         String s27= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement p27 = con.prepareStatement(s27);
                ResultSet r27 = p27.executeQuery();
                  while(r27.next()){
                String QNTY = r27.getString("FLDTXT");
                request.setAttribute("QNTY",QNTY);
                  }
         String s28= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement p28 = con.prepareStatement(s28);
                ResultSet r28 = p28.executeQuery();
                  while(r28.next()){
                String RTE = r28.getString("FLDTXT");
                request.setAttribute("RTE",RTE);
                  }
         String s29= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement p29 = con.prepareStatement(s29);
                ResultSet r29 = p29.executeQuery();
                  while(r29.next()){
                String UNT = r29.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
         String s30= "select * from Field_Text where FLDID ='80' and LNGID ='"+weblng+"'";
                PreparedStatement p30 = con.prepareStatement(s30);
                ResultSet r30 = p30.executeQuery();
                  while(r30.next()){
                String CUST = r30.getString("FLDTXT");
                request.setAttribute("CUST",CUST);
                  }
         String s31= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement p31 = con.prepareStatement(s31);
                ResultSet r31 = p31.executeQuery();
                  while(r31.next()){
                String EUSR = r31.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  } 
         String s32= "select * from Field_Text where FLDID ='82' and LNGID ='"+weblng+"'";
                PreparedStatement p32 = con.prepareStatement(s32);
                ResultSet r32 = p32.executeQuery();
                  while(r32.next()){
                String CINFO = r32.getString("FLDTXT");
                request.setAttribute("CINFO",CINFO);
                  }   
         String s33= "select * from Field_Text where FLDID ='83' and LNGID ='"+weblng+"'";
                PreparedStatement p33 = con.prepareStatement(s33);
                ResultSet r33 = p33.executeQuery();
                  while(r33.next()){
                String RMKS = r33.getString("FLDTXT");
                request.setAttribute("RMKS",RMKS);
                  } 
         String s34= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement p34 = con.prepareStatement(s34);
                ResultSet r34 = p34.executeQuery();
                  while(r34.next()){
                String EDT = r34.getString("FLDTXT");
                request.setAttribute("EDT",EDT);
                  } 
         String s35= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement p35 = con.prepareStatement(s35);
                ResultSet r35 = p35.executeQuery();
                  while(r35.next()){
                String GOTO = r35.getString("FLDTXT");
                request.setAttribute("GOTO",GOTO);
                  } 
         String s36= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement p36 = con.prepareStatement(s36);
                ResultSet r36 = p36.executeQuery();
                  while(r36.next()){
                String ENV = r36.getString("FLDTXT");
                request.setAttribute("ENV",ENV);
                  } 
         String s37= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement p37 = con.prepareStatement(s37);
                ResultSet r37 = p37.executeQuery();
                  while(r37.next()){
                String SYS = r37.getString("FLDTXT");
                request.setAttribute("SYS",SYS);
                  } 
         String s38= "select * from Field_Text where FLDID ='88' and LNGID ='"+weblng+"'";
                PreparedStatement p38 = con.prepareStatement(s38);
                ResultSet r38 = p38.executeQuery();
                  while(r38.next()){
                String SAV = r38.getString("FLDTXT");
                request.setAttribute("SAV",SAV);
                  }   
         String s39= "select * from Field_Text where FLDID ='89' and LNGID ='"+weblng+"'";
                PreparedStatement p39 = con.prepareStatement(s39);
                ResultSet r39 = p39.executeQuery();
                  while(r39.next()){
                String UPD = r39.getString("FLDTXT");
                request.setAttribute("UPD",UPD);
                  }   
         String s40= "select * from Field_Text where FLDID ='90' and LNGID ='"+weblng+"'";
                PreparedStatement p40 = con.prepareStatement(s40);
                ResultSet r40 = p40.executeQuery();
                  while(r40.next()){
                String DLT = r40.getString("FLDTXT");
                request.setAttribute("DLT",DLT);
                  }   
         String s41= "select * from Field_Text where FLDID ='91' and LNGID ='"+weblng+"'";
                PreparedStatement p41 = con.prepareStatement(s41);
                ResultSet r41 = p41.executeQuery();
                  while(r41.next()){
                String GET = r41.getString("FLDTXT");
                request.setAttribute("GET",GET);
                  }             
          request.setAttribute("weblng",weblng);

            ModelAndView mav = null;
            String inqno = request.getParameter("inqno");
            String ccod = request.getParameter("ccod");
            String empno = request.getParameter("empno");
            String assnper = request.getParameter("assnper");
            String bizid = request.getParameter("bizid");
            String modul = request.getParameter("modul");
            String lngid = request.getParameter("lngid");
            String frmdt = request.getParameter("frmdt");
            String todt = request.getParameter("todt");
            String posbper = request.getParameter("posbper");
            String prjdes = request.getParameter("prjdes");
            String status = request.getParameter("status");
            String phaseid = request.getParameter("phaseid");
            String estamt = request.getParameter("estamt");
            String curr = request.getParameter("curr");
            String taxamt = request.getParameter("taxamt");
            String qty = request.getParameter("qty");
            String rate = request.getParameter("rate");
            String unit = request.getParameter("unit");
            String custno = request.getParameter("custno");
            String eusrno = request.getParameter("eusrno");
            String custinfo = request.getParameter("custinfo");
            String remarks = request.getParameter("remarks");       
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlupd = "update Inquiry set CCOD = '"+ccod+"', EMPNO = '"+empno+"', ASSNPER = '"+assnper+"', BIZID = '"+bizid+"', MODUL = '"+modul+"', "+
                            "LNGID = '"+lngid+"', FRMDT = '"+frmdt+"', TODT = '"+todt+"', POSBPER = '"+posbper+"', PRJDES = '"+prjdes+"', PRJSTS = '"+status+"', "+
                            "PHASEID = '"+phaseid+"', ESTAMT = '"+estamt+"', CURR = '"+curr+"', TAXAMT = '"+taxamt+"', QTY = '"+qty+"', RATE = '"+rate+"', "+
                            "UNIT = '"+unit+"', CUSTNO = '"+custno+"', EUSRNO = '"+eusrno+"', CUSTINFO = '"+custinfo+"', REMARKS = '"+remarks+"' where INQNO = '"+inqno+"';";
            
             cst = con.createStatement();
            int u1 = cst.executeUpdate(sqlupd);
            
            if(u1 > 0){
            
                
//                Inquiry.this.showLogin(request, response);
                request.setAttribute("updt","UPD");
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/inquiryview.jsp");
                rd.forward(request, response);
            
            }
            
        }
        catch(SQLException ex){
//            request.setAttribute("err","ERR");
//            request.setAttribute("mes",ex.getMessage());
//            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//            rd.forward(request, response);
            System.out.println(ex.getMessage());
            mav = new ModelAndView("inquiryview");
        
        }
        
         return mav;
     
    }
    
              @RequestMapping(value="/inqcre")
    public ModelAndView empcre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
            String weblng = request.getParameter("weblng"); 
            String emnum = request.getParameter("emnum");
            String authflg = ""; 
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
             Class.forName("com.mysql.cj.jdbc.Driver");
             
           String sqlauth = "select * from Authorisation_Master where APPMSTR ='IM'and EMPCOD ='"+emnum+"'";
                PreparedStatement pstauth = con.prepareStatement(sqlauth);
                ResultSet rsauth = pstauth.executeQuery();
                while(rsauth.next()){
                    authflg = rsauth.getString("AUTHFLG");
                }
             
              String s1= "select * from Field_Text where FLDID ='58'and LNGID ='"+weblng+"'";
                PreparedStatement p1 = con.prepareStatement(s1);
                ResultSet r1 = p1.executeQuery();
                while(r1.next()){
                String INQMS = r1.getString("FLDTXT");
                request.setAttribute("INQMS",INQMS);
                }   
               String s2= "select * from Field_Text where FLDID ='02' and LNGID ='"+weblng+"'";
                PreparedStatement p2 = con.prepareStatement(s2);
                ResultSet r2 = p2.executeQuery();
                  while(r2.next()){
                String INQ = r2.getString("FLDTXT");
                request.setAttribute("INQ",INQ);
                  } 
              String s3= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement p3 = con.prepareStatement(s3);
                ResultSet r3 = p3.executeQuery();
                while(r3.next()){
                String INCRE = r3.getString("FLDTXT");
                request.setAttribute("INCRE",INCRE);
                }
                String s4= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement p4 = con.prepareStatement(s4);
                ResultSet r4 = p4.executeQuery();
                while(r4.next()){
                String INEDT = r4.getString("FLDTXT");
                request.setAttribute("INEDT",INEDT);
                }
                
                String s5= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement p5 = con.prepareStatement(s5);
                ResultSet r5 = p5.executeQuery();
                  while(r5.next()){
                String INDIS = r5.getString("FLDTXT");
                request.setAttribute("INDIS",INDIS);
                  }        
              String s6= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement p6 = con.prepareStatement(s6);
                ResultSet r6 = p6.executeQuery();
                  while(r6.next()){
                String CMPNY = r6.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
              String s7= "select * from Field_Text where FLDID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement p7 = con.prepareStatement(s7);
                ResultSet r7 = p7.executeQuery();
                  while(r7.next()){
                String INLST = r7.getString("FLDTXT");
                request.setAttribute("INLST",INLST);
                  }  
             String s8= "select * from Field_Text where FLDID ='01' and LNGID ='"+weblng+"'";
                PreparedStatement p8 = con.prepareStatement(s8);
                ResultSet r8 = p8.executeQuery();
                  while(r8.next()){
                String EMP = r8.getString("FLDTXT");
                request.setAttribute("EMP",EMP);
                  }    
                String s9= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement p9 = con.prepareStatement(s9);
                ResultSet r9 = p9.executeQuery();
                  while(r9.next()){
                String PRTXT = r9.getString("FLDTXT");
                request.setAttribute("PRTXT",PRTXT);
                  }             
             String s10= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement p10 = con.prepareStatement(s10);
                ResultSet r10 = p10.executeQuery();
                  while(r10.next()){
                String EXT = r10.getString("FLDTXT");
                request.setAttribute("EXT",EXT);
                  }
            String s11= "select * from Field_Text where FLDID ='62' and LNGID ='"+weblng+"'";
                PreparedStatement p11 = con.prepareStatement(s11);
                ResultSet r11 = p11.executeQuery();
                  while(r11.next()){
                String D1 = r11.getString("FLDTXT");
                request.setAttribute("D1",D1);
                  }       
            String s12= "select * from Field_Text where FLDID ='63' and LNGID ='"+weblng+"'";
                PreparedStatement p12 = con.prepareStatement(s12);
                ResultSet r12 = p12.executeQuery();
                  while(r12.next()){
                String D2 = r12.getString("FLDTXT");
                request.setAttribute("D2",D2);
                  }              
            String s13= "select * from Field_Text where FLDID ='64' and LNGID ='"+weblng+"'";
                PreparedStatement p13 = con.prepareStatement(s13);
                ResultSet r13= p13.executeQuery();
                  while(r13.next()){
                String EST = r13.getString("FLDTXT");
                request.setAttribute("EST",EST);
                  }  
             String s14= "select * from Field_Text where FLDID ='65' and LNGID ='"+weblng+"'";
                PreparedStatement p14 = con.prepareStatement(s14);
                ResultSet r14 = p14.executeQuery();
                  while(r14.next()){
                String ORGD = r14.getString("FLDTXT");
                request.setAttribute("ORGD",ORGD);
                  }
            String s15= "select * from Field_Text where FLDID ='68' and LNGID ='"+weblng+"'";
                PreparedStatement p15 = con.prepareStatement(s15);
                ResultSet r15 = p15.executeQuery();
                  while(r15.next()){
                String ASSN = r15.getString("FLDTXT");
                request.setAttribute("ASSN",ASSN);
                  }
           String s16= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement p16 = con.prepareStatement(s16);
                ResultSet r16 = p16.executeQuery();
                  while(r16.next()){
                String STDT = r16.getString("FLDTXT");
                request.setAttribute("STDT",STDT);
                  } 
          String s17= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement p17 = con.prepareStatement(s17);
                ResultSet r17 = p17.executeQuery();
                  while(r17.next()){
                String ENDT = r17.getString("FLDTXT");
                request.setAttribute("ENDT",ENDT);
                  } 
         String s18= "select * from Field_Text where FLDID ='71' and LNGID ='"+weblng+"'";
                PreparedStatement p18 = con.prepareStatement(s18);
                ResultSet r18 = p18.executeQuery();
                  while(r18.next()){
                String POSB = r18.getString("FLDTXT");
                request.setAttribute("POSB",POSB);
                  }  
         String s19= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement p19 = con.prepareStatement(s19);
                ResultSet r19 = p19.executeQuery();
                  while(r19.next()){
                String BZLN = r19.getString("FLDTXT");
                request.setAttribute("BZLN",BZLN);
                  } 
         String s20= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement p20 = con.prepareStatement(s20);
                ResultSet r20 = p20.executeQuery();
                  while(r20.next()){
                String LNG = r20.getString("FLDTXT");
                request.setAttribute("LNG",LNG);
                  } 
         String s21= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement p21 = con.prepareStatement(s21);
                ResultSet r21 = p21.executeQuery();
                  while(r21.next()){
                String MOD = r21.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                  }        
         String s22= "select * from Field_Text where FLDID ='72' and LNGID ='"+weblng+"'";
                PreparedStatement p22 = con.prepareStatement(s22);
                ResultSet r22 = p22.executeQuery();
                  while(r22.next()){
                String STAT = r22.getString("FLDTXT");
                request.setAttribute("STAT",STAT);
                  }   
         String s23= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement p23 = con.prepareStatement(s23);
                ResultSet r23 = p23.executeQuery();
                  while(r23.next()){
                String PHAS = r23.getString("FLDTXT");
                request.setAttribute("PHAS",PHAS);
                  }    
         String s24= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement p24 = con.prepareStatement(s24);
                ResultSet r24 = p24.executeQuery();
                  while(r24.next()){
                String ESTA = r24.getString("FLDTXT");
                request.setAttribute("ESTA",ESTA);
                  }  
         String s25= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement p25 = con.prepareStatement(s25);
                ResultSet r25 = p25.executeQuery();
                  while(r25.next()){
                String CUR = r25.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
         String s26= "select * from Field_Text where FLDID ='76' and LNGID ='"+weblng+"'";
                PreparedStatement p26 = con.prepareStatement(s26);
                ResultSet r26 = p26.executeQuery();
                  while(r26.next()){
                String TAX = r26.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  } 
         String s27= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement p27 = con.prepareStatement(s27);
                ResultSet r27 = p27.executeQuery();
                  while(r27.next()){
                String QNTY = r27.getString("FLDTXT");
                request.setAttribute("QNTY",QNTY);
                  }
         String s28= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement p28 = con.prepareStatement(s28);
                ResultSet r28 = p28.executeQuery();
                  while(r28.next()){
                String RTE = r28.getString("FLDTXT");
                request.setAttribute("RTE",RTE);
                  }
         String s29= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement p29 = con.prepareStatement(s29);
                ResultSet r29 = p29.executeQuery();
                  while(r29.next()){
                String UNT = r29.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
         String s30= "select * from Field_Text where FLDID ='80' and LNGID ='"+weblng+"'";
                PreparedStatement p30 = con.prepareStatement(s30);
                ResultSet r30 = p30.executeQuery();
                  while(r30.next()){
                String CUST = r30.getString("FLDTXT");
                request.setAttribute("CUST",CUST);
                  }
         String s31= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement p31 = con.prepareStatement(s31);
                ResultSet r31 = p31.executeQuery();
                  while(r31.next()){
                String EUSR = r31.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  } 
         String s32= "select * from Field_Text where FLDID ='82' and LNGID ='"+weblng+"'";
                PreparedStatement p32 = con.prepareStatement(s32);
                ResultSet r32 = p32.executeQuery();
                  while(r32.next()){
                String CINFO = r32.getString("FLDTXT");
                request.setAttribute("CINFO",CINFO);
                  }   
         String s33= "select * from Field_Text where FLDID ='83' and LNGID ='"+weblng+"'";
                PreparedStatement p33 = con.prepareStatement(s33);
                ResultSet r33 = p33.executeQuery();
                  while(r33.next()){
                String RMKS = r33.getString("FLDTXT");
                request.setAttribute("RMKS",RMKS);
                  } 
         String s34= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement p34 = con.prepareStatement(s34);
                ResultSet r34 = p34.executeQuery();
                  while(r34.next()){
                String EDT = r34.getString("FLDTXT");
                request.setAttribute("EDT",EDT);
                  } 
         String s35= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement p35 = con.prepareStatement(s35);
                ResultSet r35 = p35.executeQuery();
                  while(r35.next()){
                String GOTO = r35.getString("FLDTXT");
                request.setAttribute("GOTO",GOTO);
                  } 
         String s36= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement p36 = con.prepareStatement(s36);
                ResultSet r36 = p36.executeQuery();
                  while(r36.next()){
                String ENV = r36.getString("FLDTXT");
                request.setAttribute("ENV",ENV);
                  } 
         String s37= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement p37 = con.prepareStatement(s37);
                ResultSet r37 = p37.executeQuery();
                  while(r37.next()){
                String SYS = r37.getString("FLDTXT");
                request.setAttribute("SYS",SYS);
                  } 
         String s38= "select * from Field_Text where FLDID ='88' and LNGID ='"+weblng+"'";
                PreparedStatement p38 = con.prepareStatement(s38);
                ResultSet r38 = p38.executeQuery();
                  while(r38.next()){
                String SAV = r38.getString("FLDTXT");
                request.setAttribute("SAV",SAV);
                  }   
         String s39= "select * from Field_Text where FLDID ='89' and LNGID ='"+weblng+"'";
                PreparedStatement p39 = con.prepareStatement(s39);
                ResultSet r39 = p39.executeQuery();
                  while(r39.next()){
                String UPD = r39.getString("FLDTXT");
                request.setAttribute("UPD",UPD);
                  }   
         String s40= "select * from Field_Text where FLDID ='90' and LNGID ='"+weblng+"'";
                PreparedStatement p40 = con.prepareStatement(s40);
                ResultSet r40 = p40.executeQuery();
                  while(r40.next()){
                String DLT = r40.getString("FLDTXT");
                request.setAttribute("DLT",DLT);
                  }   
         String s41= "select * from Field_Text where FLDID ='91' and LNGID ='"+weblng+"'";
                PreparedStatement p41 = con.prepareStatement(s41);
                ResultSet r41 = p41.executeQuery();
                  while(r41.next()){
                String GET = r41.getString("FLDTXT");
                request.setAttribute("GET",GET);
                  }             
          request.setAttribute("weblng",weblng);  
          request.setAttribute("emnum",emnum);
          request.setAttribute("scrn", "cre");          
          if(authflg.contains("C")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/inquiryview.jsp");
                rd.forward(request, response);
                }else{
                    JOptionPane.showMessageDialog(null,"you are not Authorized for create operation");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
                    rd.forward(request, response);
                }
        
        ModelAndView mav = new ModelAndView("inquiryview");
        return mav;
        
    }
    
        @RequestMapping(value="/inqcha")
    public ModelAndView empcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
           String weblng = request.getParameter("weblng");  
            String emnum = request.getParameter("emnum");
            String authflg = "";       
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
             Class.forName("com.mysql.cj.jdbc.Driver");
             
                String sqlauth = "select * from Authorisation_Master where APPMSTR ='IM'and EMPCOD ='"+emnum+"'";
                PreparedStatement pstauth = con.prepareStatement(sqlauth);
                ResultSet rsauth = pstauth.executeQuery();
                while(rsauth.next()){
                    authflg = rsauth.getString("AUTHFLG");
                }
             
          String s1= "select * from Field_Text where FLDID ='58'and LNGID ='"+weblng+"'";
            PreparedStatement p1 = con.prepareStatement(s1);
            ResultSet r1 = p1.executeQuery();
            while(r1.next()){
            String INQMS = r1.getString("FLDTXT");
            request.setAttribute("INQMS",INQMS);
            }   
           String s2= "select * from Field_Text where FLDID ='02' and LNGID ='"+weblng+"'";
            PreparedStatement p2 = con.prepareStatement(s2);
            ResultSet r2 = p2.executeQuery();
              while(r2.next()){
            String INQ = r2.getString("FLDTXT");
            request.setAttribute("INQ",INQ);
              } 
          String s3= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
            PreparedStatement p3 = con.prepareStatement(s3);
            ResultSet r3 = p3.executeQuery();
            while(r3.next()){
            String INCRE = r3.getString("FLDTXT");
            request.setAttribute("INCRE",INCRE);
            }
            String s4= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
            PreparedStatement p4 = con.prepareStatement(s4);
            ResultSet r4 = p4.executeQuery();
            while(r4.next()){
            String INEDT = r4.getString("FLDTXT");
            request.setAttribute("INEDT",INEDT);
            }

            String s5= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
            PreparedStatement p5 = con.prepareStatement(s5);
            ResultSet r5 = p5.executeQuery();
              while(r5.next()){
            String INDIS = r5.getString("FLDTXT");
            request.setAttribute("INDIS",INDIS);
              }        
          String s6= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
            PreparedStatement p6 = con.prepareStatement(s6);
            ResultSet r6 = p6.executeQuery();
              while(r6.next()){
            String CMPNY = r6.getString("FLDTXT");
            request.setAttribute("CMPNY",CMPNY);
              }
          String s7= "select * from Field_Text where FLDID ='07' and LNGID ='"+weblng+"'";
            PreparedStatement p7 = con.prepareStatement(s7);
            ResultSet r7 = p7.executeQuery();
              while(r7.next()){
            String INLST = r7.getString("FLDTXT");
            request.setAttribute("INLST",INLST);
              }  
         String s8= "select * from Field_Text where FLDID ='01' and LNGID ='"+weblng+"'";
            PreparedStatement p8 = con.prepareStatement(s8);
            ResultSet r8 = p8.executeQuery();
              while(r8.next()){
            String EMP = r8.getString("FLDTXT");
            request.setAttribute("EMP",EMP);
              }    
            String s9= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
            PreparedStatement p9 = con.prepareStatement(s9);
            ResultSet r9 = p9.executeQuery();
              while(r9.next()){
            String PRTXT = r9.getString("FLDTXT");
            request.setAttribute("PRTXT",PRTXT);
              }             
         String s10= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
            PreparedStatement p10 = con.prepareStatement(s10);
            ResultSet r10 = p10.executeQuery();
              while(r10.next()){
            String EXT = r10.getString("FLDTXT");
            request.setAttribute("EXT",EXT);
              }
        String s11= "select * from Field_Text where FLDID ='62' and LNGID ='"+weblng+"'";
            PreparedStatement p11 = con.prepareStatement(s11);
            ResultSet r11 = p11.executeQuery();
              while(r11.next()){
            String D1 = r11.getString("FLDTXT");
            request.setAttribute("D1",D1);
              }       
        String s12= "select * from Field_Text where FLDID ='63' and LNGID ='"+weblng+"'";
            PreparedStatement p12 = con.prepareStatement(s12);
            ResultSet r12 = p12.executeQuery();
              while(r12.next()){
            String D2 = r12.getString("FLDTXT");
            request.setAttribute("D2",D2);
              }              
        String s13= "select * from Field_Text where FLDID ='64' and LNGID ='"+weblng+"'";
            PreparedStatement p13 = con.prepareStatement(s13);
            ResultSet r13= p13.executeQuery();
              while(r13.next()){
            String EST = r13.getString("FLDTXT");
            request.setAttribute("EST",EST);
              }  
         String s14= "select * from Field_Text where FLDID ='65' and LNGID ='"+weblng+"'";
            PreparedStatement p14 = con.prepareStatement(s14);
            ResultSet r14 = p14.executeQuery();
              while(r14.next()){
            String ORGD = r14.getString("FLDTXT");
            request.setAttribute("ORGD",ORGD);
              }
        String s15= "select * from Field_Text where FLDID ='68' and LNGID ='"+weblng+"'";
            PreparedStatement p15 = con.prepareStatement(s15);
            ResultSet r15 = p15.executeQuery();
              while(r15.next()){
            String ASSN = r15.getString("FLDTXT");
            request.setAttribute("ASSN",ASSN);
              }
       String s16= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
            PreparedStatement p16 = con.prepareStatement(s16);
            ResultSet r16 = p16.executeQuery();
              while(r16.next()){
            String STDT = r16.getString("FLDTXT");
            request.setAttribute("STDT",STDT);
              } 
      String s17= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
            PreparedStatement p17 = con.prepareStatement(s17);
            ResultSet r17 = p17.executeQuery();
              while(r17.next()){
            String ENDT = r17.getString("FLDTXT");
            request.setAttribute("ENDT",ENDT);
              } 
     String s18= "select * from Field_Text where FLDID ='71' and LNGID ='"+weblng+"'";
            PreparedStatement p18 = con.prepareStatement(s18);
            ResultSet r18 = p18.executeQuery();
              while(r18.next()){
            String POSB = r18.getString("FLDTXT");
            request.setAttribute("POSB",POSB);
              }  
     String s19= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
            PreparedStatement p19 = con.prepareStatement(s19);
            ResultSet r19 = p19.executeQuery();
              while(r19.next()){
            String BZLN = r19.getString("FLDTXT");
            request.setAttribute("BZLN",BZLN);
              } 
     String s20= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
            PreparedStatement p20 = con.prepareStatement(s20);
            ResultSet r20 = p20.executeQuery();
              while(r20.next()){
            String LNG = r20.getString("FLDTXT");
            request.setAttribute("LNG",LNG);
              } 
     String s21= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
            PreparedStatement p21 = con.prepareStatement(s21);
            ResultSet r21 = p21.executeQuery();
              while(r21.next()){
            String MOD = r21.getString("FLDTXT");
            request.setAttribute("MOD",MOD);
              }        
     String s22= "select * from Field_Text where FLDID ='72' and LNGID ='"+weblng+"'";
            PreparedStatement p22 = con.prepareStatement(s22);
            ResultSet r22 = p22.executeQuery();
              while(r22.next()){
            String STAT = r22.getString("FLDTXT");
            request.setAttribute("STAT",STAT);
              }   
     String s23= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
            PreparedStatement p23 = con.prepareStatement(s23);
            ResultSet r23 = p23.executeQuery();
              while(r23.next()){
            String PHAS = r23.getString("FLDTXT");
            request.setAttribute("PHAS",PHAS);
              }    
     String s24= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
            PreparedStatement p24 = con.prepareStatement(s24);
            ResultSet r24 = p24.executeQuery();
              while(r24.next()){
            String ESTA = r24.getString("FLDTXT");
            request.setAttribute("ESTA",ESTA);
              }  
     String s25= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
            PreparedStatement p25 = con.prepareStatement(s25);
            ResultSet r25 = p25.executeQuery();
              while(r25.next()){
            String CUR = r25.getString("FLDTXT");
            request.setAttribute("CUR",CUR);
              }
     String s26= "select * from Field_Text where FLDID ='76' and LNGID ='"+weblng+"'";
            PreparedStatement p26 = con.prepareStatement(s26);
            ResultSet r26 = p26.executeQuery();
              while(r26.next()){
            String TAX = r26.getString("FLDTXT");
            request.setAttribute("TAX",TAX);
              } 
     String s27= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
            PreparedStatement p27 = con.prepareStatement(s27);
            ResultSet r27 = p27.executeQuery();
              while(r27.next()){
            String QNTY = r27.getString("FLDTXT");
            request.setAttribute("QNTY",QNTY);
              }
     String s28= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
            PreparedStatement p28 = con.prepareStatement(s28);
            ResultSet r28 = p28.executeQuery();
              while(r28.next()){
            String RTE = r28.getString("FLDTXT");
            request.setAttribute("RTE",RTE);
              }
     String s29= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
            PreparedStatement p29 = con.prepareStatement(s29);
            ResultSet r29 = p29.executeQuery();
              while(r29.next()){
            String UNT = r29.getString("FLDTXT");
            request.setAttribute("UNT",UNT);
              }
     String s30= "select * from Field_Text where FLDID ='80' and LNGID ='"+weblng+"'";
            PreparedStatement p30 = con.prepareStatement(s30);
            ResultSet r30 = p30.executeQuery();
              while(r30.next()){
            String CUST = r30.getString("FLDTXT");
            request.setAttribute("CUST",CUST);
              }
     String s31= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
            PreparedStatement p31 = con.prepareStatement(s31);
            ResultSet r31 = p31.executeQuery();
              while(r31.next()){
            String EUSR = r31.getString("FLDTXT");
            request.setAttribute("EUSR",EUSR);
              } 
     String s32= "select * from Field_Text where FLDID ='82' and LNGID ='"+weblng+"'";
            PreparedStatement p32 = con.prepareStatement(s32);
            ResultSet r32 = p32.executeQuery();
              while(r32.next()){
            String CINFO = r32.getString("FLDTXT");
            request.setAttribute("CINFO",CINFO);
              }   
     String s33= "select * from Field_Text where FLDID ='83' and LNGID ='"+weblng+"'";
            PreparedStatement p33 = con.prepareStatement(s33);
            ResultSet r33 = p33.executeQuery();
              while(r33.next()){
            String RMKS = r33.getString("FLDTXT");
            request.setAttribute("RMKS",RMKS);
              } 
     String s34= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
            PreparedStatement p34 = con.prepareStatement(s34);
            ResultSet r34 = p34.executeQuery();
              while(r34.next()){
            String EDT = r34.getString("FLDTXT");
            request.setAttribute("EDT",EDT);
              } 
     String s35= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
            PreparedStatement p35 = con.prepareStatement(s35);
            ResultSet r35 = p35.executeQuery();
              while(r35.next()){
            String GOTO = r35.getString("FLDTXT");
            request.setAttribute("GOTO",GOTO);
              } 
     String s36= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
            PreparedStatement p36 = con.prepareStatement(s36);
            ResultSet r36 = p36.executeQuery();
              while(r36.next()){
            String ENV = r36.getString("FLDTXT");
            request.setAttribute("ENV",ENV);
              } 
     String s37= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
            PreparedStatement p37 = con.prepareStatement(s37);
            ResultSet r37 = p37.executeQuery();
              while(r37.next()){
            String SYS = r37.getString("FLDTXT");
            request.setAttribute("SYS",SYS);
              } 
     String s38= "select * from Field_Text where FLDID ='88' and LNGID ='"+weblng+"'";
            PreparedStatement p38 = con.prepareStatement(s38);
            ResultSet r38 = p38.executeQuery();
              while(r38.next()){
            String SAV = r38.getString("FLDTXT");
            request.setAttribute("SAV",SAV);
              }   
     String s39= "select * from Field_Text where FLDID ='89' and LNGID ='"+weblng+"'";
            PreparedStatement p39 = con.prepareStatement(s39);
            ResultSet r39 = p39.executeQuery();
              while(r39.next()){
            String UPD = r39.getString("FLDTXT");
            request.setAttribute("UPD",UPD);
              }   
     String s40= "select * from Field_Text where FLDID ='90' and LNGID ='"+weblng+"'";
            PreparedStatement p40 = con.prepareStatement(s40);
            ResultSet r40 = p40.executeQuery();
              while(r40.next()){
            String DLT = r40.getString("FLDTXT");
            request.setAttribute("DLT",DLT);
              }   
     String s41= "select * from Field_Text where FLDID ='91' and LNGID ='"+weblng+"'";
            PreparedStatement p41 = con.prepareStatement(s41);
            ResultSet r41 = p41.executeQuery();
              while(r41.next()){
            String GET = r41.getString("FLDTXT");
            request.setAttribute("GET",GET);
              }             
          request.setAttribute("weblng",weblng);
          request.setAttribute("scrn", "edt"); 
          request.setAttribute("emnum",emnum);
  
        
          if(authflg.contains("U")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/inquiryview.jsp");
                rd.forward(request, response);
                }else{
                    JOptionPane.showMessageDialog(null,"you are not Authorized for Update operation");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                    rd.forward(request, response);
                }

    ModelAndView mav = new ModelAndView("inquiryview");
    return mav;

}

@RequestMapping(value="/inqdis")
public ModelAndView empdis(HttpServletRequest request,HttpServletResponse response) 
        throws SQLException, ServletException, IOException, ClassNotFoundException{
       String weblng = request.getParameter("weblng"); 
       String emnum = request.getParameter("emnum");
        String authflg = "";
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         String sqlauth = "select * from Authorisation_Master where APPMSTR ='IM'and EMPCOD ='"+emnum+"'";
                PreparedStatement pstauth = con.prepareStatement(sqlauth);
                ResultSet rsauth = pstauth.executeQuery();
                while(rsauth.next()){
                    authflg = rsauth.getString("AUTHFLG");
                }
         
          String s1= "select * from Field_Text where FLDID ='58'and LNGID ='"+weblng+"'";
            PreparedStatement p1 = con.prepareStatement(s1);
                ResultSet r1 = p1.executeQuery();
                while(r1.next()){
                String INQMS = r1.getString("FLDTXT");
                request.setAttribute("INQMS",INQMS);
                }   
               String s2= "select * from Field_Text where FLDID ='02' and LNGID ='"+weblng+"'";
                PreparedStatement p2 = con.prepareStatement(s2);
                ResultSet r2 = p2.executeQuery();
                  while(r2.next()){
                String INQ = r2.getString("FLDTXT");
                request.setAttribute("INQ",INQ);
                  } 
              String s3= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement p3 = con.prepareStatement(s3);
                ResultSet r3 = p3.executeQuery();
                while(r3.next()){
                String INCRE = r3.getString("FLDTXT");
                request.setAttribute("INCRE",INCRE);
                }
                String s4= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement p4 = con.prepareStatement(s4);
                ResultSet r4 = p4.executeQuery();
                while(r4.next()){
                String INEDT = r4.getString("FLDTXT");
                request.setAttribute("INEDT",INEDT);
                }
                
                String s5= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement p5 = con.prepareStatement(s5);
                ResultSet r5 = p5.executeQuery();
                  while(r5.next()){
                String INDIS = r5.getString("FLDTXT");
                request.setAttribute("INDIS",INDIS);
                  }        
              String s6= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement p6 = con.prepareStatement(s6);
                ResultSet r6 = p6.executeQuery();
                  while(r6.next()){
                String CMPNY = r6.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
              String s7= "select * from Field_Text where FLDID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement p7 = con.prepareStatement(s7);
                ResultSet r7 = p7.executeQuery();
                  while(r7.next()){
                String INLST = r7.getString("FLDTXT");
                request.setAttribute("INLST",INLST);
                  }  
             String s8= "select * from Field_Text where FLDID ='01' and LNGID ='"+weblng+"'";
                PreparedStatement p8 = con.prepareStatement(s8);
                ResultSet r8 = p8.executeQuery();
                  while(r8.next()){
                String EMP = r8.getString("FLDTXT");
                request.setAttribute("EMP",EMP);
                  }    
                String s9= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement p9 = con.prepareStatement(s9);
                ResultSet r9 = p9.executeQuery();
                  while(r9.next()){
                String PRTXT = r9.getString("FLDTXT");
                request.setAttribute("PRTXT",PRTXT);
                  }             
             String s10= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement p10 = con.prepareStatement(s10);
                ResultSet r10 = p10.executeQuery();
                  while(r10.next()){
                String EXT = r10.getString("FLDTXT");
                request.setAttribute("EXT",EXT);
                  }
            String s11= "select * from Field_Text where FLDID ='62' and LNGID ='"+weblng+"'";
                PreparedStatement p11 = con.prepareStatement(s11);
                ResultSet r11 = p11.executeQuery();
                  while(r11.next()){
                String D1 = r11.getString("FLDTXT");
                request.setAttribute("D1",D1);
                  }       
            String s12= "select * from Field_Text where FLDID ='63' and LNGID ='"+weblng+"'";
                PreparedStatement p12 = con.prepareStatement(s12);
                ResultSet r12 = p12.executeQuery();
                  while(r12.next()){
                String D2 = r12.getString("FLDTXT");
                request.setAttribute("D2",D2);
                  }              
            String s13= "select * from Field_Text where FLDID ='64' and LNGID ='"+weblng+"'";
                PreparedStatement p13 = con.prepareStatement(s13);
                ResultSet r13= p13.executeQuery();
                  while(r13.next()){
                String EST = r13.getString("FLDTXT");
                request.setAttribute("EST",EST);
                  }  
             String s14= "select * from Field_Text where FLDID ='65' and LNGID ='"+weblng+"'";
                PreparedStatement p14 = con.prepareStatement(s14);
                ResultSet r14 = p14.executeQuery();
                  while(r14.next()){
                String ORGD = r14.getString("FLDTXT");
                request.setAttribute("ORGD",ORGD);
                  }
            String s15= "select * from Field_Text where FLDID ='68' and LNGID ='"+weblng+"'";
                PreparedStatement p15 = con.prepareStatement(s15);
                ResultSet r15 = p15.executeQuery();
                  while(r15.next()){
                String ASSN = r15.getString("FLDTXT");
                request.setAttribute("ASSN",ASSN);
                  }
           String s16= "select * from Field_Text where FLDID ='69' and LNGID ='"+weblng+"'";
                PreparedStatement p16 = con.prepareStatement(s16);
                ResultSet r16 = p16.executeQuery();
                  while(r16.next()){
                String STDT = r16.getString("FLDTXT");
                request.setAttribute("STDT",STDT);
                  } 
          String s17= "select * from Field_Text where FLDID ='70' and LNGID ='"+weblng+"'";
                PreparedStatement p17 = con.prepareStatement(s17);
                ResultSet r17 = p17.executeQuery();
                  while(r17.next()){
                String ENDT = r17.getString("FLDTXT");
                request.setAttribute("ENDT",ENDT);
                  } 
         String s18= "select * from Field_Text where FLDID ='71' and LNGID ='"+weblng+"'";
                PreparedStatement p18 = con.prepareStatement(s18);
                ResultSet r18 = p18.executeQuery();
                  while(r18.next()){
                String POSB = r18.getString("FLDTXT");
                request.setAttribute("POSB",POSB);
                  }  
         String s19= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement p19 = con.prepareStatement(s19);
                ResultSet r19 = p19.executeQuery();
                  while(r19.next()){
                String BZLN = r19.getString("FLDTXT");
                request.setAttribute("BZLN",BZLN);
                  } 
         String s20= "select * from Field_Text where FLDID ='26' and LNGID ='"+weblng+"'";
                PreparedStatement p20 = con.prepareStatement(s20);
                ResultSet r20 = p20.executeQuery();
                  while(r20.next()){
                String LNG = r20.getString("FLDTXT");
                request.setAttribute("LNG",LNG);
                  } 
         String s21= "select * from Field_Text where FLDID ='52' and LNGID ='"+weblng+"'";
                PreparedStatement p21 = con.prepareStatement(s21);
                ResultSet r21 = p21.executeQuery();
                  while(r21.next()){
                String MOD = r21.getString("FLDTXT");
                request.setAttribute("MOD",MOD);
                  }        
         String s22= "select * from Field_Text where FLDID ='72' and LNGID ='"+weblng+"'";
                PreparedStatement p22 = con.prepareStatement(s22);
                ResultSet r22 = p22.executeQuery();
                  while(r22.next()){
                String STAT = r22.getString("FLDTXT");
                request.setAttribute("STAT",STAT);
                  }   
         String s23= "select * from Field_Text where FLDID ='73' and LNGID ='"+weblng+"'";
                PreparedStatement p23 = con.prepareStatement(s23);
                ResultSet r23 = p23.executeQuery();
                  while(r23.next()){
                String PHAS = r23.getString("FLDTXT");
                request.setAttribute("PHAS",PHAS);
                  }    
         String s24= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement p24 = con.prepareStatement(s24);
                ResultSet r24 = p24.executeQuery();
                  while(r24.next()){
                String ESTA = r24.getString("FLDTXT");
                request.setAttribute("ESTA",ESTA);
                  }  
         String s25= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement p25 = con.prepareStatement(s25);
                ResultSet r25 = p25.executeQuery();
                  while(r25.next()){
                String CUR = r25.getString("FLDTXT");
                request.setAttribute("CUR",CUR);
                  }
         String s26= "select * from Field_Text where FLDID ='76' and LNGID ='"+weblng+"'";
                PreparedStatement p26 = con.prepareStatement(s26);
                ResultSet r26 = p26.executeQuery();
                  while(r26.next()){
                String TAX = r26.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  } 
         String s27= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement p27 = con.prepareStatement(s27);
                ResultSet r27 = p27.executeQuery();
                  while(r27.next()){
                String QNTY = r27.getString("FLDTXT");
                request.setAttribute("QNTY",QNTY);
                  }
         String s28= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement p28 = con.prepareStatement(s28);
                ResultSet r28 = p28.executeQuery();
                  while(r28.next()){
                String RTE = r28.getString("FLDTXT");
                request.setAttribute("RTE",RTE);
                  }
         String s29= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement p29 = con.prepareStatement(s29);
                ResultSet r29 = p29.executeQuery();
                  while(r29.next()){
                String UNT = r29.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
         String s30= "select * from Field_Text where FLDID ='80' and LNGID ='"+weblng+"'";
                PreparedStatement p30 = con.prepareStatement(s30);
                ResultSet r30 = p30.executeQuery();
                  while(r30.next()){
                String CUST = r30.getString("FLDTXT");
                request.setAttribute("CUST",CUST);
                  }
         String s31= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement p31 = con.prepareStatement(s31);
                ResultSet r31 = p31.executeQuery();
                  while(r31.next()){
                String EUSR = r31.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  } 
         String s32= "select * from Field_Text where FLDID ='82' and LNGID ='"+weblng+"'";
                PreparedStatement p32 = con.prepareStatement(s32);
                ResultSet r32 = p32.executeQuery();
                  while(r32.next()){
                String CINFO = r32.getString("FLDTXT");
                request.setAttribute("CINFO",CINFO);
                  }   
         String s33= "select * from Field_Text where FLDID ='83' and LNGID ='"+weblng+"'";
                PreparedStatement p33 = con.prepareStatement(s33);
                ResultSet r33 = p33.executeQuery();
                  while(r33.next()){
                String RMKS = r33.getString("FLDTXT");
                request.setAttribute("RMKS",RMKS);
                  } 
         String s34= "select * from Field_Text where FLDID ='84' and LNGID ='"+weblng+"'";
                PreparedStatement p34 = con.prepareStatement(s34);
                ResultSet r34 = p34.executeQuery();
                  while(r34.next()){
                String EDT = r34.getString("FLDTXT");
                request.setAttribute("EDT",EDT);
                  } 
         String s35= "select * from Field_Text where FLDID ='85' and LNGID ='"+weblng+"'";
                PreparedStatement p35 = con.prepareStatement(s35);
                ResultSet r35 = p35.executeQuery();
                  while(r35.next()){
                String GOTO = r35.getString("FLDTXT");
                request.setAttribute("GOTO",GOTO);
                  } 
         String s36= "select * from Field_Text where FLDID ='86' and LNGID ='"+weblng+"'";
                PreparedStatement p36 = con.prepareStatement(s36);
                ResultSet r36 = p36.executeQuery();
                  while(r36.next()){
                String ENV = r36.getString("FLDTXT");
                request.setAttribute("ENV",ENV);
                  } 
         String s37= "select * from Field_Text where FLDID ='87' and LNGID ='"+weblng+"'";
                PreparedStatement p37 = con.prepareStatement(s37);
                ResultSet r37 = p37.executeQuery();
                  while(r37.next()){
                String SYS = r37.getString("FLDTXT");
                request.setAttribute("SYS",SYS);
                  } 
         String s38= "select * from Field_Text where FLDID ='88' and LNGID ='"+weblng+"'";
                PreparedStatement p38 = con.prepareStatement(s38);
                ResultSet r38 = p38.executeQuery();
                  while(r38.next()){
                String SAV = r38.getString("FLDTXT");
                request.setAttribute("SAV",SAV);
                  }   
         String s39= "select * from Field_Text where FLDID ='89' and LNGID ='"+weblng+"'";
                PreparedStatement p39 = con.prepareStatement(s39);
                ResultSet r39 = p39.executeQuery();
                  while(r39.next()){
                String UPD = r39.getString("FLDTXT");
                request.setAttribute("UPD",UPD);
                  }   
         String s40= "select * from Field_Text where FLDID ='90' and LNGID ='"+weblng+"'";
                PreparedStatement p40 = con.prepareStatement(s40);
                ResultSet r40 = p40.executeQuery();
                  while(r40.next()){
                String DLT = r40.getString("FLDTXT");
                request.setAttribute("DLT",DLT);
                  }   
         String s41= "select * from Field_Text where FLDID ='91' and LNGID ='"+weblng+"'";
                PreparedStatement p41 = con.prepareStatement(s41);
                ResultSet r41 = p41.executeQuery();
                  while(r41.next()){
                String GET = r41.getString("FLDTXT");
                request.setAttribute("GET",GET);
                  }             
          request.setAttribute("weblng",weblng);
          request.setAttribute("emnum",emnum);
          request.setAttribute("scrn", "dis");  

        
         if(authflg.contains("R")){
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/inquiryview.jsp");
                rd.forward(request, response);
                }else{
                    JOptionPane.showMessageDialog(null,"you are not Authorized for READ operation");
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                    rd.forward(request, response);
                }
        
        ModelAndView mav = new ModelAndView("inquiryview");
        return mav;
        
    }

@RequestMapping(value="/backtohome1")
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
