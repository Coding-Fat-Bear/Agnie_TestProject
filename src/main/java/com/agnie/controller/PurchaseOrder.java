/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agnie.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin
 */
@Controller
public class PurchaseOrder {
    
             private DataSource datasource;
    
    public void setDatasource(DataSource datasource){
        this.datasource = datasource;
    }
    
    Connection con = null;
    PreparedStatement pst = null;
    Statement cst = null;
    ResultSet rs = null;
    ResultSet ss = null;
     
    
    @RequestMapping(value="/insertpo")
    public ModelAndView insertpo (HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        PrintWriter out = response.getWriter();
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
 
            String ponum = request.getParameter("ponum");
            String ccod = request.getParameter("ccod");
            String prjno = request.getParameter("prjno");
            String inqno = request.getParameter("inqno");
            String bpestno = request.getParameter("bpestno");
            String cntrtyp = request.getParameter("cntrtyp");
            String[] poitem = request.getParameterValues("poitem");
            String[] bpno = request.getParameterValues("bpno");
            String[] cnslntid = request.getParameterValues("cnslntid");
            String[] unit = request.getParameterValues("unit");
            String[] qty = request.getParameterValues("qty");
            String[] rate = request.getParameterValues("rate");
            String curr = request.getParameter("curr");
            String cnsmptax = request.getParameter("cnsmptax");
            String paytrms = request.getParameter("paytrms");
            String poamnt = request.getParameter("poamnt");
            String pofrmdt = request.getParameter("pofrmdt");
            String poendt = request.getParameter("poendt");
            String delloc = request.getParameter("delloc");
            String delvrbls = request.getParameter("delvrbls");
            String postatus = request.getParameter("postatus");
            String pohtxt = request.getParameter("pohtxt");
            String poitxt = request.getParameter("poitxt");
            String potxts = request.getParameter("potxts");
//            out.println(Arrays.toString(estmitem));
//            out.println(Arrays.toString(bpname));
//            out.println(Arrays.toString(unit));
//            out.println(Arrays.toString(qty));
//            out.println(Arrays.toString(rate));
        
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlpo = "INSERT INTO Purchase_Order (CCOD, PRJNO, INQNO, BPESTNO, CNTRTYP, CURR, CNSMPTAX, PAYTRMS, POAMNT, POFRMDT, POENDT, DELLOC, DELVRBLS, POSTATUS, POHTXT, POITXT, POTXTS, CREDT, CRETIM) VALUES ('"+ccod+"', '"+prjno+"', '"+inqno+"', '"+bpestno+"', '"+cntrtyp+"', '"+curr+"','"+cnsmptax+"','"+paytrms+"', '"+poamnt+"', '"+pofrmdt+"', '"+poendt+"', '"+delloc+"', '"+delvrbls+"', '"+postatus+"', '"+pohtxt+"', '"+poitxt+"', '"+potxts+"', CURDATE(), CURTIME())";
              
           cst = con.createStatement();
            int n1 = cst.executeUpdate(sqlpo);
            if(n1 > 0){
                try{
                con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                Class.forName("com.mysql.cj.jdbc.Driver");
                String sqladno = "SELECT max(PONUM) as pono FROM Purchase_Order;";
                pst = con.prepareStatement(sqladno);
                rs=pst.executeQuery();
                while(rs.next()){
                    String pono = rs.getString("pono");
                 //   out.println(estno);
                    
                    
                    try{
                    con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                   String sqlpoitm = "INSERT INTO PO_Items (PONUM, POITEM, BPNO, CNSLNTID, UNIT, QTY, RATE, CREDT, CRETIM) VALUES (?,?,?,?,?,?,?, CURDATE(), CURTIME())";
           
                     PreparedStatement ps = con.prepareStatement(sqlpoitm);   
                    
                       for(int i = 0;i < poitem.length;i++){
                           if (bpno[i] != ""){                         
                           out.println(poitem[i]);
                         ps.setString(1, pono);
                         ps.setString(2, poitem[i]);
                         ps.setString(3, bpno[i]);
                         ps.setString(4, cnslntid[i]);
                         ps.setString(5, unit[i]);
                         ps.setString(6, qty[i]);
                         ps.setString(7, rate[i]);
                        
                        ps.addBatch();
                           }
                       }
                                                         
                        int[] e1 = ps.executeBatch();
                    if(e1.length > 0){
                        JOptionPane.showMessageDialog(null,"Purchase Order" +pono+ " created sucessfully");

                String sql0= "select * from Field_Text where FLDID ='107'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String ESTMS = rs0.getString("FLDTXT");
                request.setAttribute("ESTMS",ESTMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='109'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String ESTS = rs1.getString("FLDTXT");
                request.setAttribute("ESTS",ESTS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String ESTCRE = rs2.getString("FLDTXT");
                request.setAttribute("ESTCRE",ESTCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String ESTEDT = rs3.getString("FLDTXT");
                request.setAttribute("ESTEDT",ESTEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String ESTDIS = rs4.getString("FLDTXT");
                request.setAttribute("ESTDIS",ESTDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String ESTDEL = rs5.getString("FLDTXT");
                request.setAttribute("ESTDEL",ESTDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='108' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String ESTNUM = rs10.getString("FLDTXT");
                request.setAttribute("ESTNUM",ESTNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String CMPNY = rs11.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='110' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String ESTREV = rs12.getString("FLDTXT");
                request.setAttribute("ESTREV",ESTREV);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='111' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String ESTDES = rs13.getString("FLDTXT");
                request.setAttribute("ESTDES",ESTDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String ESTITM = rs14.getString("FLDTXT");
                request.setAttribute("ESTITM",ESTITM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String CNSLTID = rs15.getString("FLDTXT");
                request.setAttribute("CNSLTID",CNSLTID);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String CNSLTNAM = rs16.getString("FLDTXT");
                request.setAttribute("CNSLTNAM",CNSLTNAM);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String UNT = rs17.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String QUAN = rs18.getString("FLDTXT");
                request.setAttribute("QUAN",QUAN);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String RAT = rs19.getString("FLDTXT");
                request.setAttribute("RAT",RAT);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ESTAMT = rs20.getString("FLDTXT");
                request.setAttribute("ESTAMT",ESTAMT);
                  }
                String sql21= "select * from Field_Text where FLDID ='112' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String TOT = rs21.getString("FLDTXT");
                request.setAttribute("TOT",TOT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String PRJNUM = rs22.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  } 
                String sql23= "select * from Field_Text where FLDID ='114' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String INQNUM = rs23.getString("FLDTXT");
                request.setAttribute("INQNUM",INQNUM);
                  }  
                String sql24= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String CRNCY = rs24.getString("FLDTXT");
                request.setAttribute("CRNCY",CRNCY);
                  }
                String sql25= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String TAX = rs25.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                String sql26= "select * from Field_Text where FLDID ='116' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DISCNT = rs26.getString("FLDTXT");
                request.setAttribute("DISCNT",DISCNT);
                  }  
                String sql27= "select * from Field_Text where FLDID ='117' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String ESTSTDT = rs27.getString("FLDTXT");
                request.setAttribute("ESTSTDT",ESTSTDT);
                  }  
                String sql28= "select * from Field_Text where FLDID ='118' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String ESTENDT = rs28.getString("FLDTXT");
                request.setAttribute("ESTENDT",ESTENDT);
                  }
                String sql29= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String DELLOC = rs29.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }
                String sql30= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String DELVBLS = rs30.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }   
                String sql31= "select * from Field_Text where FLDID ='121' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String ESTXT1 = rs31.getString("FLDTXT");
                request.setAttribute("ESTXT1",ESTXT1);
                  }
                String sql32= "select * from Field_Text where FLDID ='122' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String ESTXT2 = rs32.getString("FLDTXT");
                request.setAttribute("ESTXT2",ESTXT2);
                  }
                String sql33= "select * from Field_Text where FLDID ='123' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String ESTXT3 = rs33.getString("FLDTXT");
                request.setAttribute("ESTXT3",ESTXT3);
                  } 
                String sql34= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ESTEXT = rs34.getString("FLDTXT");
                request.setAttribute("ESTEXT",ESTEXT);
                  }  
                String sql35= "select * from Field_Text where FLDID ='125' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String CNSLTNTS = rs35.getString("FLDTXT");
                request.setAttribute("CNSLTNTS",CNSLTNTS);
                  } 
                String sql36= "select * from Field_Text where FLDID ='126' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ESTINFO = rs36.getString("FLDTXT");
                request.setAttribute("ESTINFO",ESTINFO);
                  }  
                String sql37= "select * from Field_Text where FLDID ='127' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String ESTTRMS = rs37.getString("FLDTXT");
                request.setAttribute("ESTTRMS",ESTTRMS);
                  }   
                String sql38= "select * from Field_Text where FLDID ='128' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String ESTTXTS = rs38.getString("FLDTXT");
                request.setAttribute("ESTTXTS",ESTTXTS);
                  }  
                  String sql39= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String ASDL = rs39.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql40= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String ASLRW = rs40.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql42= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst42 = con.prepareStatement(sql42);
                ResultSet rs42 = pst42.executeQuery();
                  while(rs42.next()){
                String DIYS = rs42.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql43= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst43 = con.prepareStatement(sql43);
                ResultSet rs43 = pst43.executeQuery();
                  while(rs43.next()){
                String DINO = rs43.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  } 
                        
                        request.setAttribute("scrn",scrn);
                        request.setAttribute("weblng",weblng);
                        request.setAttribute("emnum",emnum);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/purchaseorder.jsp");
                        rd.forward(request, response);
                        
                    }
                    }
                    catch(SQLException gx){
                JOptionPane.showMessageDialog(null,"Error: "+gx.getMessage());
//                request.setAttribute("err","ERR");
//                        request.setAttribute("mes",ex.getMessage());
//                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//                        rd.forward(request, response);
                System.out.println(gx.getMessage());
                mav = new ModelAndView("purchaseorder");
            }
                    
                    
                }
                }
                catch(SQLException fx){
                JOptionPane.showMessageDialog(null,"Error: "+fx.getMessage());
//                request.setAttribute("err","ERR");
//                        request.setAttribute("mes",ex.getMessage());
//                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//                        rd.forward(request, response);
                System.out.println(fx.getMessage());
                mav = new ModelAndView("purchaseorder");
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
                mav = new ModelAndView("purchaseorder");
            }
        
        return null;
        
    }
       

    
     @RequestMapping(value="/updtpo")
    public ModelAndView update(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        PrintWriter out = response.getWriter();
        ModelAndView mav = null;
        String weblng = request.getParameter("weblng");
        String emnum = request.getParameter("emnum");
        String scrn = request.getParameter("scrn");
 
            String ponum = request.getParameter("ponum");
            String ccod = request.getParameter("ccod");
            String prjno = request.getParameter("prjno");
            String inqno = request.getParameter("inqno");
            String bpestno = request.getParameter("bpestno");
            String cntrtyp = request.getParameter("cntrtyp");
            String[] poitem = request.getParameterValues("poitem");
            String[] bpno = request.getParameterValues("bpno");
            String[] cnslntid = request.getParameterValues("cnslntid");
            String[] unit = request.getParameterValues("unit");
            String[] qty = request.getParameterValues("qty");
            String[] rate = request.getParameterValues("rate");
            String curr = request.getParameter("curr");
            String cnsmptax = request.getParameter("cnsmptax");
            String paytrms = request.getParameter("paytrms");
            String poamnt = request.getParameter("poamnt");
            String pofrmdt = request.getParameter("pofrmdt");
            String poendt = request.getParameter("poendt");
            String delloc = request.getParameter("delloc");
            String delvrbls = request.getParameter("delvrbls");
            String postatus = request.getParameter("postatus");
            String pohtxt = request.getParameter("pohtxt");
            String poitxt = request.getParameter("poitxt");
            String potxts = request.getParameter("potxts");
            String podt = null;
            String potm = null;
//            out.println(Arrays.toString(estmitem));
//            out.println(Arrays.toString(bpname));
//            out.println(Arrays.toString(unit));
//            out.println(Arrays.toString(qty));
//            out.println(Arrays.toString(rate));
        
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
     //       String updmst = "INSERT INTO Estimation_Master (ESTMDES, ESTREVNO, CCOD, PRJNO, INQNO, CURR, TAXCODE, DISCOUNT, FRMDT, TODT, DELLOC, DELVRBLS, ESTMAMT, ESTMTXT1, ESTMTXT2, ESTMTXT3, CREDT, CRETIM) VALUES ('"+estmdes+"', '"+estrevno+"', '"+ccod+"', '"+prjno+"', '"+inqno+"', '"+curr+"','"+taxcode+"','"+discount+"', '"+frmdt+"', '"+todt+"', '"+delloc+"', '"+delvrbls+"', '"+estmamt+"', '"+estmtxt1+"', '"+estmtxt2+"', '"+estmtxt3+"', CURDATE(), CURTIME())";
            String updmst = "UPDATE Purchase_Order set CCOD = '"+ccod+"', CNTRTYP = '"+cntrtyp+"', PRJNO = '"+prjno+"', INQNO = '"+inqno+"', BPESTNO = '"+bpestno+"', CURR = '"+curr+"', CNSMPTAX = '"+cnsmptax+"', PAYTRMS = '"+paytrms+"', POAMNT = '"+poamnt+"', POFRMDT = '"+pofrmdt+"', POENDT = '"+poendt+"', DELLOC = '"+delloc+"', DELVRBLS = '"+delvrbls+"', POSTATUS = '"+postatus+"', POHTXT = '"+pohtxt+"', POITXT = '"+poitxt+"', POTXTS = '"+potxts+"' where PONUM = '"+ponum+"';";
  
           cst = con.createStatement();
            int n1 = cst.executeUpdate(updmst);
            if(n1 > 0){                   
                     try{
                    con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                   String delallsql = "delete from PO_Items where PONUM = '"+ponum+"';";
                   Statement delalstmt = con.createStatement();
                     int delall = delalstmt.executeUpdate(delallsql);
                     
                     if(delall > 0){
                         
                         int[] e1;
                    int e2 = 0;
                    try{
                    con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                      con.setAutoCommit(false);
                    String sqldtm= "SELECT * FROM Purchase_Order where PONUM = '"+ponum+"'";
                    PreparedStatement pstdtm = con.prepareStatement(sqldtm);
                    ResultSet rsdtm = pstdtm.executeQuery();
                    while(rsdtm.next()){
                    podt = rsdtm.getString("CREDT");
                    potm = rsdtm.getString("CRETIM");
                    
                    }
                    String sqlbpi = "INSERT INTO PO_Items (PONUM, POITEM, BPNO, CNSLNTID, UNIT, QTY, RATE, CREDT, CRETIM) VALUES (?,?,?,?,?,?,?,?,?)";
                     PreparedStatement ps = con.prepareStatement(sqlbpi);   
                    for(int i = 0; i < bpno.length; i++){
                     
                         if (bpno[i] != ""){                         
                           out.println(poitem[i]);
                        
                        ps.setString(1, ponum);
                         ps.setString(2, poitem[i]);
                         ps.setString(3, bpno[i]);
                         ps.setString(4, cnslntid[i]);
                         ps.setString(5, unit[i]);
                         ps.setString(6, qty[i]);
                         ps.setString(7, rate[i]);
                         ps.setString(8, podt);
                         ps.setString(9, potm);
                         
                        
                        ps.addBatch();
                           } 
                    }
                         
                       e1 = ps.executeBatch();
                        con.commit();
                     if(e1.length > 0){
                        JOptionPane.showMessageDialog(null,"Purchase Order" +ponum+  "Updated sucessfully");  

                String sql0= "select * from Field_Text where FLDID ='107'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String ESTMS = rs0.getString("FLDTXT");
                request.setAttribute("ESTMS",ESTMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='109'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String ESTS = rs1.getString("FLDTXT");
                request.setAttribute("ESTS",ESTS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String ESTCRE = rs2.getString("FLDTXT");
                request.setAttribute("ESTCRE",ESTCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String ESTEDT = rs3.getString("FLDTXT");
                request.setAttribute("ESTEDT",ESTEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String ESTDIS = rs4.getString("FLDTXT");
                request.setAttribute("ESTDIS",ESTDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String ESTDEL = rs5.getString("FLDTXT");
                request.setAttribute("ESTDEL",ESTDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='108' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String ESTNUM = rs10.getString("FLDTXT");
                request.setAttribute("ESTNUM",ESTNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String CMPNY = rs11.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='110' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String ESTREV = rs12.getString("FLDTXT");
                request.setAttribute("ESTREV",ESTREV);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='111' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String ESTDES = rs13.getString("FLDTXT");
                request.setAttribute("ESTDES",ESTDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String ESTITM = rs14.getString("FLDTXT");
                request.setAttribute("ESTITM",ESTITM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String CNSLTID = rs15.getString("FLDTXT");
                request.setAttribute("CNSLTID",CNSLTID);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String CNSLTNAM = rs16.getString("FLDTXT");
                request.setAttribute("CNSLTNAM",CNSLTNAM);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String UNT = rs17.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String QUAN = rs18.getString("FLDTXT");
                request.setAttribute("QUAN",QUAN);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String RAT = rs19.getString("FLDTXT");
                request.setAttribute("RAT",RAT);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ESTAMT = rs20.getString("FLDTXT");
                request.setAttribute("ESTAMT",ESTAMT);
                  }
                String sql21= "select * from Field_Text where FLDID ='112' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String TOT = rs21.getString("FLDTXT");
                request.setAttribute("TOT",TOT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String PRJNUM = rs22.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  } 
                String sql23= "select * from Field_Text where FLDID ='114' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String INQNUM = rs23.getString("FLDTXT");
                request.setAttribute("INQNUM",INQNUM);
                  }  
                String sql24= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String CRNCY = rs24.getString("FLDTXT");
                request.setAttribute("CRNCY",CRNCY);
                  }
                String sql25= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String TAX = rs25.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                String sql26= "select * from Field_Text where FLDID ='116' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DISCNT = rs26.getString("FLDTXT");
                request.setAttribute("DISCNT",DISCNT);
                  }  
                String sql27= "select * from Field_Text where FLDID ='117' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String ESTSTDT = rs27.getString("FLDTXT");
                request.setAttribute("ESTSTDT",ESTSTDT);
                  }  
                String sql28= "select * from Field_Text where FLDID ='118' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String ESTENDT = rs28.getString("FLDTXT");
                request.setAttribute("ESTENDT",ESTENDT);
                  }
                String sql29= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String DELLOC = rs29.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }
                String sql30= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String DELVBLS = rs30.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }   
                String sql31= "select * from Field_Text where FLDID ='121' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String ESTXT1 = rs31.getString("FLDTXT");
                request.setAttribute("ESTXT1",ESTXT1);
                  }
                String sql32= "select * from Field_Text where FLDID ='122' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String ESTXT2 = rs32.getString("FLDTXT");
                request.setAttribute("ESTXT2",ESTXT2);
                  }
                String sql33= "select * from Field_Text where FLDID ='123' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String ESTXT3 = rs33.getString("FLDTXT");
                request.setAttribute("ESTXT3",ESTXT3);
                  } 
                String sql34= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ESTEXT = rs34.getString("FLDTXT");
                request.setAttribute("ESTEXT",ESTEXT);
                  }  
                String sql35= "select * from Field_Text where FLDID ='125' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String CNSLTNTS = rs35.getString("FLDTXT");
                request.setAttribute("CNSLTNTS",CNSLTNTS);
                  } 
                String sql36= "select * from Field_Text where FLDID ='126' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ESTINFO = rs36.getString("FLDTXT");
                request.setAttribute("ESTINFO",ESTINFO);
                  }  
                String sql37= "select * from Field_Text where FLDID ='127' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String ESTTRMS = rs37.getString("FLDTXT");
                request.setAttribute("ESTTRMS",ESTTRMS);
                  }   
                String sql38= "select * from Field_Text where FLDID ='128' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String ESTTXTS = rs38.getString("FLDTXT");
                request.setAttribute("ESTTXTS",ESTTXTS);
                  } 
                  String sql39= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String ASDL = rs39.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql40= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String ASLRW = rs40.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql42= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst42 = con.prepareStatement(sql42);
                ResultSet rs42 = pst42.executeQuery();
                  while(rs42.next()){
                String DIYS = rs42.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql43= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst43 = con.prepareStatement(sql43);
                ResultSet rs43 = pst43.executeQuery();
                  while(rs43.next()){
                String DINO = rs43.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  } 
                  

                        request.setAttribute("scrn",scrn);
                        request.setAttribute("weblng",weblng);
                        request.setAttribute("emnum",emnum);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/purchaseorder.jsp");
                        rd.forward(request, response);
                        } 
                  // }
                    }
                    catch(SQLException gx){
                JOptionPane.showMessageDialog(null,"Error: "+gx.getMessage());
//                request.setAttribute("err","ERR");
//                        request.setAttribute("mes",ex.getMessage());
//                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//                        rd.forward(request, response);
                System.out.println(gx.getMessage());
                mav = new ModelAndView("purchaseorder");
            }                   
                    } 
                
 
        }
                     catch(SQLException px){
                JOptionPane.showMessageDialog(null,"Error: "+px.getMessage());
//                
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
                mav = new ModelAndView("purchaseorder");
            }
        
        return null;
        
    }
   
    
    @RequestMapping(value="/delpo")
    public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String ponum = request.getParameter("ponum");
        String weblng = request.getParameter("weblng");
        String scrn = request.getParameter("scrn");
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
            String sqldel = "Update Purchase_Order set ACTFLG = 'X' where PONUM = '"+ponum+"';";
            cst = con.createStatement();
            int d1 = cst.executeUpdate(sqldel);
            
            if(d1 > 0){
              JOptionPane.showMessageDialog(null,"Record" +ponum+ " is Set for Deletion Flag");
              
                String sql0= "select * from Field_Text where FLDID ='107'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String ESTMS = rs0.getString("FLDTXT");
                request.setAttribute("ESTMS",ESTMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='109'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String ESTS = rs1.getString("FLDTXT");
                request.setAttribute("ESTS",ESTS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String ESTCRE = rs2.getString("FLDTXT");
                request.setAttribute("ESTCRE",ESTCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String ESTEDT = rs3.getString("FLDTXT");
                request.setAttribute("ESTEDT",ESTEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String ESTDIS = rs4.getString("FLDTXT");
                request.setAttribute("ESTDIS",ESTDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String ESTDEL = rs5.getString("FLDTXT");
                request.setAttribute("ESTDEL",ESTDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='108' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String ESTNUM = rs10.getString("FLDTXT");
                request.setAttribute("ESTNUM",ESTNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String CMPNY = rs11.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='110' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String ESTREV = rs12.getString("FLDTXT");
                request.setAttribute("ESTREV",ESTREV);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='111' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String ESTDES = rs13.getString("FLDTXT");
                request.setAttribute("ESTDES",ESTDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String ESTITM = rs14.getString("FLDTXT");
                request.setAttribute("ESTITM",ESTITM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String CNSLTID = rs15.getString("FLDTXT");
                request.setAttribute("CNSLTID",CNSLTID);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String CNSLTNAM = rs16.getString("FLDTXT");
                request.setAttribute("CNSLTNAM",CNSLTNAM);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String UNT = rs17.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String QUAN = rs18.getString("FLDTXT");
                request.setAttribute("QUAN",QUAN);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String RAT = rs19.getString("FLDTXT");
                request.setAttribute("RAT",RAT);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ESTAMT = rs20.getString("FLDTXT");
                request.setAttribute("ESTAMT",ESTAMT);
                  }
                String sql21= "select * from Field_Text where FLDID ='112' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String TOT = rs21.getString("FLDTXT");
                request.setAttribute("TOT",TOT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String PRJNUM = rs22.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  } 
                String sql23= "select * from Field_Text where FLDID ='114' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String INQNUM = rs23.getString("FLDTXT");
                request.setAttribute("INQNUM",INQNUM);
                  }  
                String sql24= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String CRNCY = rs24.getString("FLDTXT");
                request.setAttribute("CRNCY",CRNCY);
                  }
                String sql25= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String TAX = rs25.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                String sql26= "select * from Field_Text where FLDID ='116' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DISCNT = rs26.getString("FLDTXT");
                request.setAttribute("DISCNT",DISCNT);
                  }  
                String sql27= "select * from Field_Text where FLDID ='117' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String ESTSTDT = rs27.getString("FLDTXT");
                request.setAttribute("ESTSTDT",ESTSTDT);
                  }  
                String sql28= "select * from Field_Text where FLDID ='118' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String ESTENDT = rs28.getString("FLDTXT");
                request.setAttribute("ESTENDT",ESTENDT);
                  }
                String sql29= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String DELLOC = rs29.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }
                String sql30= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String DELVBLS = rs30.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }   
                String sql31= "select * from Field_Text where FLDID ='121' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String ESTXT1 = rs31.getString("FLDTXT");
                request.setAttribute("ESTXT1",ESTXT1);
                  }
                String sql32= "select * from Field_Text where FLDID ='122' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String ESTXT2 = rs32.getString("FLDTXT");
                request.setAttribute("ESTXT2",ESTXT2);
                  }
                String sql33= "select * from Field_Text where FLDID ='123' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String ESTXT3 = rs33.getString("FLDTXT");
                request.setAttribute("ESTXT3",ESTXT3);
                  } 
                String sql34= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ESTEXT = rs34.getString("FLDTXT");
                request.setAttribute("ESTEXT",ESTEXT);
                  }  
                String sql35= "select * from Field_Text where FLDID ='125' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String CNSLTNTS = rs35.getString("FLDTXT");
                request.setAttribute("CNSLTNTS",CNSLTNTS);
                  } 
                String sql36= "select * from Field_Text where FLDID ='126' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ESTINFO = rs36.getString("FLDTXT");
                request.setAttribute("ESTINFO",ESTINFO);
                  }  
                String sql37= "select * from Field_Text where FLDID ='127' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String ESTTRMS = rs37.getString("FLDTXT");
                request.setAttribute("ESTTRMS",ESTTRMS);
                  }   
                String sql38= "select * from Field_Text where FLDID ='128' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String ESTTXTS = rs38.getString("FLDTXT");
                request.setAttribute("ESTTXTS",ESTTXTS);
                  }  

                request.setAttribute("delet","DEL");
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/purchaseorder.jsp");
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
            mav = new ModelAndView("purchaseorder");
        
        }  
    }        
        else{
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/purchaseorder.jsp");
                rd.forward(request, response);       
            }          
             return mav;
    } 
   
    
//   
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
    

        @RequestMapping(value="/pocre")
           public ModelAndView pocre(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{ 
        
        String weblng = request.getParameter("weblng");
//        String emnum = request.getParameter("emnum");
//        String authflg = ""; 
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");
//        
//                String sqlauth = "select * from Authorisation_Master where APPMSTR ='ES'and EMPCOD ='"+emnum+"'";
//                PreparedStatement pstauth = con.prepareStatement(sqlauth);
//                ResultSet rsauth = pstauth.executeQuery();
//                while(rsauth.next()){
//                    authflg = rsauth.getString("AUTHFLG");
//                }
//                
                String sql0= "select * from Field_Text where FLDID ='107'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String ESTMS = rs0.getString("FLDTXT");
                request.setAttribute("ESTMS",ESTMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='109'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String ESTS = rs1.getString("FLDTXT");
                request.setAttribute("ESTS",ESTS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String ESTCRE = rs2.getString("FLDTXT");
                request.setAttribute("ESTCRE",ESTCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String ESTEDT = rs3.getString("FLDTXT");
                request.setAttribute("ESTEDT",ESTEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String ESTDIS = rs4.getString("FLDTXT");
                request.setAttribute("ESTDIS",ESTDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String ESTDEL = rs5.getString("FLDTXT");
                request.setAttribute("ESTDEL",ESTDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='108' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String ESTNUM = rs10.getString("FLDTXT");
                request.setAttribute("ESTNUM",ESTNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String CMPNY = rs11.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='110' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String ESTREV = rs12.getString("FLDTXT");
                request.setAttribute("ESTREV",ESTREV);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='111' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String ESTDES = rs13.getString("FLDTXT");
                request.setAttribute("ESTDES",ESTDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String ESTITM = rs14.getString("FLDTXT");
                request.setAttribute("ESTITM",ESTITM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String CNSLTID = rs15.getString("FLDTXT");
                request.setAttribute("CNSLTID",CNSLTID);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String CNSLTNAM = rs16.getString("FLDTXT");
                request.setAttribute("CNSLTNAM",CNSLTNAM);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String UNT = rs17.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String QUAN = rs18.getString("FLDTXT");
                request.setAttribute("QUAN",QUAN);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String RAT = rs19.getString("FLDTXT");
                request.setAttribute("RAT",RAT);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ESTAMT = rs20.getString("FLDTXT");
                request.setAttribute("ESTAMT",ESTAMT);
                  }
                String sql21= "select * from Field_Text where FLDID ='112' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String TOT = rs21.getString("FLDTXT");
                request.setAttribute("TOT",TOT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String PRJNUM = rs22.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  } 
                String sql23= "select * from Field_Text where FLDID ='114' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String INQNUM = rs23.getString("FLDTXT");
                request.setAttribute("INQNUM",INQNUM);
                  }  
                String sql24= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String CRNCY = rs24.getString("FLDTXT");
                request.setAttribute("CRNCY",CRNCY);
                  }
                String sql25= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String TAX = rs25.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                String sql26= "select * from Field_Text where FLDID ='116' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DISCNT = rs26.getString("FLDTXT");
                request.setAttribute("DISCNT",DISCNT);
                  }  
                String sql27= "select * from Field_Text where FLDID ='117' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String ESTSTDT = rs27.getString("FLDTXT");
                request.setAttribute("ESTSTDT",ESTSTDT);
                  }  
                String sql28= "select * from Field_Text where FLDID ='118' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String ESTENDT = rs28.getString("FLDTXT");
                request.setAttribute("ESTENDT",ESTENDT);
                  }
                String sql29= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String DELLOC = rs29.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }
                String sql30= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String DELVBLS = rs30.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }   
                String sql31= "select * from Field_Text where FLDID ='121' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String ESTXT1 = rs31.getString("FLDTXT");
                request.setAttribute("ESTXT1",ESTXT1);
                  }
                String sql32= "select * from Field_Text where FLDID ='122' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String ESTXT2 = rs32.getString("FLDTXT");
                request.setAttribute("ESTXT2",ESTXT2);
                  }
                String sql33= "select * from Field_Text where FLDID ='123' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String ESTXT3 = rs33.getString("FLDTXT");
                request.setAttribute("ESTXT3",ESTXT3);
                  } 
                String sql34= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ESTEXT = rs34.getString("FLDTXT");
                request.setAttribute("ESTEXT",ESTEXT);
                  }  
                String sql35= "select * from Field_Text where FLDID ='125' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String CNSLTNTS = rs35.getString("FLDTXT");
                request.setAttribute("CNSLTNTS",CNSLTNTS);
                  } 
                String sql36= "select * from Field_Text where FLDID ='126' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ESTINFO = rs36.getString("FLDTXT");
                request.setAttribute("ESTINFO",ESTINFO);
                  }  
                String sql37= "select * from Field_Text where FLDID ='127' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String ESTTRMS = rs37.getString("FLDTXT");
                request.setAttribute("ESTTRMS",ESTTRMS);
                  }   
                String sql38= "select * from Field_Text where FLDID ='128' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String ESTTXTS = rs38.getString("FLDTXT");
                request.setAttribute("ESTTXTS",ESTTXTS);
                  }  
                 String sql39= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String ASDL = rs39.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql40= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String ASLRW = rs40.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql42= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst42 = con.prepareStatement(sql42);
                ResultSet rs42 = pst42.executeQuery();
                  while(rs42.next()){
                String DIYS = rs42.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql43= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst43 = con.prepareStatement(sql43);
                ResultSet rs43 = pst43.executeQuery();
                  while(rs43.next()){
                String DINO = rs43.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }  
                  
                  
          request.setAttribute("weblng",weblng);
//          request.setAttribute("emnum",emnum);
//          request.setAttribute("scrn", "cre");
//        
//            if(authflg.contains("C")){
//                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/estimation.jsp");
//                rd.forward(request, response);
//                }else{
//                    JOptionPane.showMessageDialog(null,"you are not Authorized for create operation");
//                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
//                    rd.forward(request, response);
//                }
//        
//        
//        return null;    
            request.setAttribute("scrn", "cre");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/purchaseorder.jsp");
          rd.forward(request, response);       
          ModelAndView mav = new ModelAndView("purchaseorder");        
        
             return mav;
    
    }
    
              @RequestMapping(value="/pocha")
         public ModelAndView pocha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
             String weblng = request.getParameter("weblng");
         con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
          Class.forName("com.mysql.cj.jdbc.Driver");
                String sql0= "select * from Field_Text where FLDID ='107'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String ESTMS = rs0.getString("FLDTXT");
                request.setAttribute("ESTMS",ESTMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='109'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String ESTS = rs1.getString("FLDTXT");
                request.setAttribute("ESTS",ESTS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String ESTCRE = rs2.getString("FLDTXT");
                request.setAttribute("ESTCRE",ESTCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String ESTEDT = rs3.getString("FLDTXT");
                request.setAttribute("ESTEDT",ESTEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String ESTDIS = rs4.getString("FLDTXT");
                request.setAttribute("ESTDIS",ESTDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String ESTDEL = rs5.getString("FLDTXT");
                request.setAttribute("ESTDEL",ESTDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='108' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String ESTNUM = rs10.getString("FLDTXT");
                request.setAttribute("ESTNUM",ESTNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String CMPNY = rs11.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='110' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String ESTREV = rs12.getString("FLDTXT");
                request.setAttribute("ESTREV",ESTREV);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='111' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String ESTDES = rs13.getString("FLDTXT");
                request.setAttribute("ESTDES",ESTDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String ESTITM = rs14.getString("FLDTXT");
                request.setAttribute("ESTITM",ESTITM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String CNSLTID = rs15.getString("FLDTXT");
                request.setAttribute("CNSLTID",CNSLTID);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String CNSLTNAM = rs16.getString("FLDTXT");
                request.setAttribute("CNSLTNAM",CNSLTNAM);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String UNT = rs17.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String QUAN = rs18.getString("FLDTXT");
                request.setAttribute("QUAN",QUAN);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String RAT = rs19.getString("FLDTXT");
                request.setAttribute("RAT",RAT);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ESTAMT = rs20.getString("FLDTXT");
                request.setAttribute("ESTAMT",ESTAMT);
                  }
                String sql21= "select * from Field_Text where FLDID ='112' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String TOT = rs21.getString("FLDTXT");
                request.setAttribute("TOT",TOT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String PRJNUM = rs22.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  } 
                String sql23= "select * from Field_Text where FLDID ='114' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String INQNUM = rs23.getString("FLDTXT");
                request.setAttribute("INQNUM",INQNUM);
                  }  
                String sql24= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String CRNCY = rs24.getString("FLDTXT");
                request.setAttribute("CRNCY",CRNCY);
                  }
                String sql25= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String TAX = rs25.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                String sql26= "select * from Field_Text where FLDID ='116' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DISCNT = rs26.getString("FLDTXT");
                request.setAttribute("DISCNT",DISCNT);
                  }  
                String sql27= "select * from Field_Text where FLDID ='117' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String ESTSTDT = rs27.getString("FLDTXT");
                request.setAttribute("ESTSTDT",ESTSTDT);
                  }  
                String sql28= "select * from Field_Text where FLDID ='118' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String ESTENDT = rs28.getString("FLDTXT");
                request.setAttribute("ESTENDT",ESTENDT);
                  }
                String sql29= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String DELLOC = rs29.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }
                String sql30= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String DELVBLS = rs30.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }   
                String sql31= "select * from Field_Text where FLDID ='121' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String ESTXT1 = rs31.getString("FLDTXT");
                request.setAttribute("ESTXT1",ESTXT1);
                  }
                String sql32= "select * from Field_Text where FLDID ='122' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String ESTXT2 = rs32.getString("FLDTXT");
                request.setAttribute("ESTXT2",ESTXT2);
                  }
                String sql33= "select * from Field_Text where FLDID ='123' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String ESTXT3 = rs33.getString("FLDTXT");
                request.setAttribute("ESTXT3",ESTXT3);
                  } 
                String sql34= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ESTEXT = rs34.getString("FLDTXT");
                request.setAttribute("ESTEXT",ESTEXT);
                  }  
                String sql35= "select * from Field_Text where FLDID ='125' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String CNSLTNTS = rs35.getString("FLDTXT");
                request.setAttribute("CNSLTNTS",CNSLTNTS);
                  } 
                String sql36= "select * from Field_Text where FLDID ='126' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ESTINFO = rs36.getString("FLDTXT");
                request.setAttribute("ESTINFO",ESTINFO);
                  }  
                String sql37= "select * from Field_Text where FLDID ='127' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String ESTTRMS = rs37.getString("FLDTXT");
                request.setAttribute("ESTTRMS",ESTTRMS);
                  }   
                String sql38= "select * from Field_Text where FLDID ='128' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String ESTTXTS = rs38.getString("FLDTXT");
                request.setAttribute("ESTTXTS",ESTTXTS);
                  }  
                   String sql39= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String ASDL = rs39.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql40= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String ASLRW = rs40.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql42= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst42 = con.prepareStatement(sql42);
                ResultSet rs42 = pst42.executeQuery();
                  while(rs42.next()){
                String DIYS = rs42.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql43= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst43 = con.prepareStatement(sql43);
                ResultSet rs43 = pst43.executeQuery();
                  while(rs43.next()){
                String DINO = rs43.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }
             request.setAttribute("weblng", weblng);     
             request.setAttribute("scrn", "edt");          
      RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/purchaseorder.jsp");
      rd.forward(request, response);    
      ModelAndView mav = new ModelAndView("purchaseorder"); 
         
        return mav;  
    }
    
      @RequestMapping(value="/podis")
       public ModelAndView podis(HttpServletRequest request,HttpServletResponse response) 
        throws SQLException, ServletException, IOException, ClassNotFoundException{
          String weblng = request.getParameter("weblng");
         con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
          Class.forName("com.mysql.cj.jdbc.Driver");
                String sql0= "select * from Field_Text where FLDID ='107'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String ESTMS = rs0.getString("FLDTXT");
                request.setAttribute("ESTMS",ESTMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='109'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String ESTS = rs1.getString("FLDTXT");
                request.setAttribute("ESTS",ESTS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String ESTCRE = rs2.getString("FLDTXT");
                request.setAttribute("ESTCRE",ESTCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String ESTEDT = rs3.getString("FLDTXT");
                request.setAttribute("ESTEDT",ESTEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String ESTDIS = rs4.getString("FLDTXT");
                request.setAttribute("ESTDIS",ESTDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String ESTDEL = rs5.getString("FLDTXT");
                request.setAttribute("ESTDEL",ESTDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='108' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String ESTNUM = rs10.getString("FLDTXT");
                request.setAttribute("ESTNUM",ESTNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String CMPNY = rs11.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='110' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String ESTREV = rs12.getString("FLDTXT");
                request.setAttribute("ESTREV",ESTREV);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='111' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String ESTDES = rs13.getString("FLDTXT");
                request.setAttribute("ESTDES",ESTDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String ESTITM = rs14.getString("FLDTXT");
                request.setAttribute("ESTITM",ESTITM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String CNSLTID = rs15.getString("FLDTXT");
                request.setAttribute("CNSLTID",CNSLTID);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String CNSLTNAM = rs16.getString("FLDTXT");
                request.setAttribute("CNSLTNAM",CNSLTNAM);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String UNT = rs17.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String QUAN = rs18.getString("FLDTXT");
                request.setAttribute("QUAN",QUAN);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String RAT = rs19.getString("FLDTXT");
                request.setAttribute("RAT",RAT);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ESTAMT = rs20.getString("FLDTXT");
                request.setAttribute("ESTAMT",ESTAMT);
                  }
                String sql21= "select * from Field_Text where FLDID ='112' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String TOT = rs21.getString("FLDTXT");
                request.setAttribute("TOT",TOT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String PRJNUM = rs22.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  } 
                String sql23= "select * from Field_Text where FLDID ='114' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String INQNUM = rs23.getString("FLDTXT");
                request.setAttribute("INQNUM",INQNUM);
                  }  
                String sql24= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String CRNCY = rs24.getString("FLDTXT");
                request.setAttribute("CRNCY",CRNCY);
                  }
                String sql25= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String TAX = rs25.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                String sql26= "select * from Field_Text where FLDID ='116' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DISCNT = rs26.getString("FLDTXT");
                request.setAttribute("DISCNT",DISCNT);
                  }  
                String sql27= "select * from Field_Text where FLDID ='117' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String ESTSTDT = rs27.getString("FLDTXT");
                request.setAttribute("ESTSTDT",ESTSTDT);
                  }  
                String sql28= "select * from Field_Text where FLDID ='118' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String ESTENDT = rs28.getString("FLDTXT");
                request.setAttribute("ESTENDT",ESTENDT);
                  }
                String sql29= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String DELLOC = rs29.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }
                String sql30= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String DELVBLS = rs30.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }   
                String sql31= "select * from Field_Text where FLDID ='121' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String ESTXT1 = rs31.getString("FLDTXT");
                request.setAttribute("ESTXT1",ESTXT1);
                  }
                String sql32= "select * from Field_Text where FLDID ='122' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String ESTXT2 = rs32.getString("FLDTXT");
                request.setAttribute("ESTXT2",ESTXT2);
                  }
                String sql33= "select * from Field_Text where FLDID ='123' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String ESTXT3 = rs33.getString("FLDTXT");
                request.setAttribute("ESTXT3",ESTXT3);
                  } 
                String sql34= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ESTEXT = rs34.getString("FLDTXT");
                request.setAttribute("ESTEXT",ESTEXT);
                  }  
                String sql35= "select * from Field_Text where FLDID ='125' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String CNSLTNTS = rs35.getString("FLDTXT");
                request.setAttribute("CNSLTNTS",CNSLTNTS);
                  } 
                String sql36= "select * from Field_Text where FLDID ='126' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ESTINFO = rs36.getString("FLDTXT");
                request.setAttribute("ESTINFO",ESTINFO);
                  }  
                String sql37= "select * from Field_Text where FLDID ='127' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String ESTTRMS = rs37.getString("FLDTXT");
                request.setAttribute("ESTTRMS",ESTTRMS);
                  }   
                String sql38= "select * from Field_Text where FLDID ='128' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String ESTTXTS = rs38.getString("FLDTXT");
                request.setAttribute("ESTTXTS",ESTTXTS);
                  }  
                 String sql39= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String ASDL = rs39.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql40= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String ASLRW = rs40.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql42= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst42 = con.prepareStatement(sql42);
                ResultSet rs42 = pst42.executeQuery();
                  while(rs42.next()){
                String DIYS = rs42.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql43= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst43 = con.prepareStatement(sql43);
                ResultSet rs43 = pst43.executeQuery();
                  while(rs43.next()){
                String DINO = rs43.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }  
                  
            request.setAttribute("weblng", weblng);
            request.setAttribute("scrn", "dis");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/purchaseorder.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("purchaseorder");
           
           return mav;
       }
       
          @RequestMapping(value="/podel")
       public ModelAndView podel(HttpServletRequest request,HttpServletResponse response) 
        throws SQLException, ServletException, IOException, ClassNotFoundException{
          String weblng = request.getParameter("weblng");
         con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
          Class.forName("com.mysql.cj.jdbc.Driver");
                String sql0= "select * from Field_Text where FLDID ='107'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String ESTMS = rs0.getString("FLDTXT");
                request.setAttribute("ESTMS",ESTMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='109'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String ESTS = rs1.getString("FLDTXT");
                request.setAttribute("ESTS",ESTS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String ESTCRE = rs2.getString("FLDTXT");
                request.setAttribute("ESTCRE",ESTCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String ESTEDT = rs3.getString("FLDTXT");
                request.setAttribute("ESTEDT",ESTEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String ESTDIS = rs4.getString("FLDTXT");
                request.setAttribute("ESTDIS",ESTDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String ESTDEL = rs5.getString("FLDTXT");
                request.setAttribute("ESTDEL",ESTDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='108' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String ESTNUM = rs10.getString("FLDTXT");
                request.setAttribute("ESTNUM",ESTNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='13' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String CMPNY = rs11.getString("FLDTXT");
                request.setAttribute("CMPNY",CMPNY);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='110' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String ESTREV = rs12.getString("FLDTXT");
                request.setAttribute("ESTREV",ESTREV);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='111' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String ESTDES = rs13.getString("FLDTXT");
                request.setAttribute("ESTDES",ESTDES);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='100' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String ESTITM = rs14.getString("FLDTXT");
                request.setAttribute("ESTITM",ESTITM);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='101' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String CNSLTID = rs15.getString("FLDTXT");
                request.setAttribute("CNSLTID",CNSLTID);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='102' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String CNSLTNAM = rs16.getString("FLDTXT");
                request.setAttribute("CNSLTNAM",CNSLTNAM);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='79' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String UNT = rs17.getString("FLDTXT");
                request.setAttribute("UNT",UNT);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='77' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String QUAN = rs18.getString("FLDTXT");
                request.setAttribute("QUAN",QUAN);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='78' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String RAT = rs19.getString("FLDTXT");
                request.setAttribute("RAT",RAT);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='74' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ESTAMT = rs20.getString("FLDTXT");
                request.setAttribute("ESTAMT",ESTAMT);
                  }
                String sql21= "select * from Field_Text where FLDID ='112' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String TOT = rs21.getString("FLDTXT");
                request.setAttribute("TOT",TOT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String PRJNUM = rs22.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  } 
                String sql23= "select * from Field_Text where FLDID ='114' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String INQNUM = rs23.getString("FLDTXT");
                request.setAttribute("INQNUM",INQNUM);
                  }  
                String sql24= "select * from Field_Text where FLDID ='75' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String CRNCY = rs24.getString("FLDTXT");
                request.setAttribute("CRNCY",CRNCY);
                  }
                String sql25= "select * from Field_Text where FLDID ='115' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String TAX = rs25.getString("FLDTXT");
                request.setAttribute("TAX",TAX);
                  }
                String sql26= "select * from Field_Text where FLDID ='116' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DISCNT = rs26.getString("FLDTXT");
                request.setAttribute("DISCNT",DISCNT);
                  }  
                String sql27= "select * from Field_Text where FLDID ='117' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String ESTSTDT = rs27.getString("FLDTXT");
                request.setAttribute("ESTSTDT",ESTSTDT);
                  }  
                String sql28= "select * from Field_Text where FLDID ='118' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String ESTENDT = rs28.getString("FLDTXT");
                request.setAttribute("ESTENDT",ESTENDT);
                  }
                String sql29= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String DELLOC = rs29.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }
                String sql30= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String DELVBLS = rs30.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }   
                String sql31= "select * from Field_Text where FLDID ='121' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String ESTXT1 = rs31.getString("FLDTXT");
                request.setAttribute("ESTXT1",ESTXT1);
                  }
                String sql32= "select * from Field_Text where FLDID ='122' and LNGID ='"+weblng+"'";
                PreparedStatement pst32 = con.prepareStatement(sql32);
                ResultSet rs32 = pst32.executeQuery();
                  while(rs32.next()){
                String ESTXT2 = rs32.getString("FLDTXT");
                request.setAttribute("ESTXT2",ESTXT2);
                  }
                String sql33= "select * from Field_Text where FLDID ='123' and LNGID ='"+weblng+"'";
                PreparedStatement pst33 = con.prepareStatement(sql33);
                ResultSet rs33 = pst33.executeQuery();
                  while(rs33.next()){
                String ESTXT3 = rs33.getString("FLDTXT");
                request.setAttribute("ESTXT3",ESTXT3);
                  } 
                String sql34= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst34 = con.prepareStatement(sql34);
                ResultSet rs34 = pst34.executeQuery();
                  while(rs34.next()){
                String ESTEXT = rs34.getString("FLDTXT");
                request.setAttribute("ESTEXT",ESTEXT);
                  }  
                String sql35= "select * from Field_Text where FLDID ='125' and LNGID ='"+weblng+"'";
                PreparedStatement pst35 = con.prepareStatement(sql35);
                ResultSet rs35 = pst35.executeQuery();
                  while(rs35.next()){
                String CNSLTNTS = rs35.getString("FLDTXT");
                request.setAttribute("CNSLTNTS",CNSLTNTS);
                  } 
                String sql36= "select * from Field_Text where FLDID ='126' and LNGID ='"+weblng+"'";
                PreparedStatement pst36 = con.prepareStatement(sql36);
                ResultSet rs36 = pst36.executeQuery();
                  while(rs36.next()){
                String ESTINFO = rs36.getString("FLDTXT");
                request.setAttribute("ESTINFO",ESTINFO);
                  }  
                String sql37= "select * from Field_Text where FLDID ='127' and LNGID ='"+weblng+"'";
                PreparedStatement pst37 = con.prepareStatement(sql37);
                ResultSet rs37 = pst37.executeQuery();
                  while(rs37.next()){
                String ESTTRMS = rs37.getString("FLDTXT");
                request.setAttribute("ESTTRMS",ESTTRMS);
                  }   
                String sql38= "select * from Field_Text where FLDID ='128' and LNGID ='"+weblng+"'";
                PreparedStatement pst38 = con.prepareStatement(sql38);
                ResultSet rs38 = pst38.executeQuery();
                  while(rs38.next()){
                String ESTTXTS = rs38.getString("FLDTXT");
                request.setAttribute("ESTTXTS",ESTTXTS);
                  }  
                  String sql39= "select * from Message_Txt where MSGID ='09' and LNGID ='"+weblng+"'";
                PreparedStatement pst39 = con.prepareStatement(sql39);
                ResultSet rs39 = pst39.executeQuery();
                  while(rs39.next()){
                String ASDL = rs39.getString("MSGTXT");
                request.setAttribute("ASDL",ASDL);
                  }
                  
                String sql40= "select * from Message_Txt where MSGID ='10' and LNGID ='"+weblng+"'";
                PreparedStatement pst40 = con.prepareStatement(sql40);
                ResultSet rs40 = pst40.executeQuery();
                  while(rs40.next()){
                String ASLRW = rs40.getString("MSGTXT");
                request.setAttribute("ASLRW",ASLRW);
                  }
                  
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }
                  
                String sql42= "select * from Message_Txt where MSGID ='11' and LNGID ='"+weblng+"'";
                PreparedStatement pst42 = con.prepareStatement(sql42);
                ResultSet rs42 = pst42.executeQuery();
                  while(rs42.next()){
                String DIYS = rs42.getString("MSGTXT");
                request.setAttribute("DIYS",DIYS);
                  }
                  
                String sql43= "select * from Message_Txt where MSGID ='12' and LNGID ='"+weblng+"'";
                PreparedStatement pst43 = con.prepareStatement(sql43);
                ResultSet rs43 = pst43.executeQuery();
                  while(rs43.next()){
                String DINO = rs43.getString("MSGTXT");
                request.setAttribute("DINO",DINO);
                  }  
            
            request.setAttribute("weblng", weblng);  
            request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/purchaseorder.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("purchaseorder");
           
           return mav;
       }
       
    @RequestMapping(value="/poback")
    public ModelAndView backhome(HttpServletRequest request,HttpServletResponse response) 
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
                String sql9= "select * from Field_Text where FLDID ='107' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String ESTMS = rs9.getString("FLDTXT");
                request.setAttribute("ESTMS",ESTMS);
                  }  
                
                                
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
        
        mav = new ModelAndView("emplist");
        
       
        return mav;
            
    } 
    
    @RequestMapping(value="/poprint")
       public ModelAndView poprint (HttpServletRequest request,HttpServletResponse response) 
        throws SQLException, ServletException, IOException, ClassNotFoundException{
           
    try{
 
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
       String reportPath = "C:\\Users\\AGI08\\JaspersoftWorkspace\\MyReports\\Sample_A4.jrxml";
       JasperReport jr = JasperCompileManager.compileReport(reportPath);
       JasperPrint jp = JasperFillManager.fillReport(jr,null, con);
       JasperViewer.viewReport(jp);
       con.close();
}
 
catch(Exception ex)
{
    ex.printStackTrace();
}
           
//          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/purchaseorder.jsp");
//          rd.forward(request, response);
//        
//        ModelAndView mav = new ModelAndView("purchaseorder");
//           return mav;
                 return null;
       }
    
}
