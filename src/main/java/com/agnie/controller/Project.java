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
 * @author Admin
 */
@Controller
public class Project {
    
         private DataSource datasource;
    
    public void setDatasource(DataSource datasource){
        this.datasource = datasource;
    }
    
    Connection con = null;
    PreparedStatement pst = null;
    Statement cst = null;
    ResultSet rs = null;
    ResultSet ss = null;
    
//        @RequestMapping(value= "/Project", method= RequestMethod.POST)
////    public ModelAndView initView(HttpServletRequest request, HttpServletResponse response) {
////        System.out.println("Handler method is called.");
////       ModelAndView modelview = new ModelAndView();
////        modelview.addObject("welcome_msg", "Project Master");      
////        modelview.setViewName("projectview");
////        return modelview;
////    }
//        
//    public ModelAndView showLogin(HttpServletRequest request,HttpServletResponse response) 
//            throws SQLException, ServletException, IOException, ClassNotFoundException{
//        
//        String uname = request.getParameter("uname");
//        String pass = request.getParameter("pass");
//        String sql = "select * from Login where USERNAME='"+uname+"' and PASSWORD='"+pass+"'";
//        ModelAndView mav = null;
////        mav = new ModelAndView("log");
//        try{
//            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            pst = con.prepareStatement(sql);
////            pst.setString(1,uname);
////            pst.setString(2,pass);
//            
//            rs=pst.executeQuery();
//            if(rs.next()){
//                System.out.println("hai how are you");
//                mav = new ModelAndView("projectview");
////                request.setAttribute("weblng",weblng);
////                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
////                rd.forward(request, response);
//                
////        mav.addObject("log",new log());
////            return mav;
//            }
//            else{
//            request.setAttribute("appnm","1");
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request, response);
//            System.out.println("user and pass is worng");
////            mav = new ModelAndView("index");
//            }
//        }
//        catch(IOException | SQLException | ServletException ex){
////            System.out.println(ex);
//                JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
//                System.out.println("Error"+ex.getMessage());
//        }
//       con.close();
////        System.out.println("hai how are you");
////        ModelAndView mav = new ModelAndView("log");
//////        mav.addObject("log",new log());
//        return mav;        
//    }
    
        @RequestMapping(value="/insertprj")
    public ModelAndView insertprj (HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
             ModelAndView mav = null;
            String prjno = request.getParameter("prjno");
            String prjdes = request.getParameter("prjdes");
            String bizid = request.getParameter("bizid");
            String cntrtyp = request.getParameter("cntrtyp");
            String bpno = request.getParameter("bpno");
            String eusrno = request.getParameter("eusrno");
            String srepno = request.getParameter("srepno");
            String acmno = request.getParameter("acmno");
            String frmdt = request.getParameter("frmdt");
            String prjlivdt = request.getParameter("prjlivdt");
            String todt = request.getParameter("todt");
            String cntfrmdt = request.getParameter("cntfrmdt");
            String cnttodt = request.getParameter("cnttodt");
            String extflg = request.getParameter("extflg");
            String dellocid = request.getParameter("dellocid");
            String delvrblid = request.getParameter("delvrblid");
            String wrkhrs = request.getParameter("wrkhrs");
            String othrs = request.getParameter("othrs");
            String extflg1;
            if(extflg == null){
              extflg1 = "";
            }else{
               extflg1 = "X";
            }
            
            try{
                    con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    
                    String sqlprj = "INSERT INTO Project_Master (PRJNO, PRJDES, BIZID, CNTRTYP, BPNO, EUSRNO, SREPNO, ACMNO, FRMDT, PRJLIVDT, TODT, CNTFRMDT, CNTTODT, EXTFLG, DELLOCID, DELVRBLID, WRKHRS, OTHRS, CREDT, CRETIM) VALUES ('"+prjno+"', '"+prjdes+"', '"+bizid+"', '"+cntrtyp+"', '"+bpno+"', '"+eusrno+"', '"+srepno+"', '"+acmno+"', '"+frmdt+"', '"+prjlivdt+"', '"+todt+"','"+cntfrmdt+"','"+cnttodt+"', '"+extflg1+"', '"+dellocid+"', '"+delvrblid+"', '"+wrkhrs+"', '"+othrs+"', CURDATE(), CURTIME())";
                    
                    cst = con.createStatement();
                    int e1 = cst.executeUpdate(sqlprj);
                    if(e1 > 0){
                        System.out.println("Successfully created Project");
                        try{
                            con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            String sqlprjno = "SELECT max(PRJNO) as prj FROM Project_Master;";
//                        String sqlinqno = "INSERT INTO Inquiry (CCOD, EMPNO, ASSNPER, BIZID, MODUL, LNGID, FRMDT, TODT, POSBPER, PRJDES, STATUS, PHASEID, ESTAMT, CURR, TAXAMT, QTY, RATE, UNIT, CUSTNO, EUSRNO, CUSTINFO, REMARKS, CREDT, CRETIM) VALUES ('"+ccod+"', '"+empno+"', '"+assnper+"', '"+bizid+"', '"+modul+"', '"+lngid+"', '"+frmdt+"', '"+todt+"', '"+posbper+"', '"+prjdes+"','"+status+"','"+phaseid+"', '"+estamt+"', '"+curr+"', '"+taxamt+"', '"+qty+"', '"+rate+"', '"+unit+"', '"+custno+"', '"+eusrno+"', '"+custinfo+"', '"+remarks+"', CURDATE(), CURTIME();";
                            pst = con.prepareStatement(sqlprjno);
                            ss=pst.executeQuery();
                            while(ss.next()){
                                
                               String prj = ss.getString("prj");
                                JOptionPane.showMessageDialog(null,"Successfully created Project "+prj);
                               String weblng = request.getParameter("weblng");              
                String sql0= "select * from Field_Text where FLDID ='124'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String PRJMS = rs0.getString("FLDTXT");
                request.setAttribute("PRJMS",PRJMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='129'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String PRJS = rs1.getString("FLDTXT");
                request.setAttribute("PRJS",PRJS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String PRJCRE = rs2.getString("FLDTXT");
                request.setAttribute("PRJCRE",PRJCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String PRJEDT = rs3.getString("FLDTXT");
                request.setAttribute("PRJEDT",PRJEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String PRJDIS = rs4.getString("FLDTXT");
                request.setAttribute("PRJDIS",PRJDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String PRJDEL = rs5.getString("FLDTXT");
                request.setAttribute("PRJDEL",PRJDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PRJNUM = rs10.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String PRJDES = rs11.getString("FLDTXT");
                request.setAttribute("PRJDES",PRJDES);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BZLIN = rs12.getString("FLDTXT");
                request.setAttribute("BZLIN",BZLIN);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CNTYP = rs13.getString("FLDTXT");
                request.setAttribute("CNTYP",CNTYP);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='130' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PRJSTDT = rs14.getString("FLDTXT");
                request.setAttribute("PRJSTDT",PRJSTDT);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='131' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String PRJGLDT = rs15.getString("FLDTXT");
                request.setAttribute("PRJGLDT",PRJGLDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='132' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String PRJENDT = rs16.getString("FLDTXT");
                request.setAttribute("PRJENDT",PRJENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='133' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String SREP = rs17.getString("FLDTXT");
                request.setAttribute("SREP",SREP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='92' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BZPT = rs18.getString("FLDTXT");
                request.setAttribute("BZPT",BZPT);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EUSR = rs19.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='134' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ACM = rs20.getString("FLDTXT");
                request.setAttribute("ACM",ACM);
                  }
                String sql21= "select * from Field_Text where FLDID ='135' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CNTSTDT = rs21.getString("FLDTXT");
                request.setAttribute("CNTSTDT",CNTSTDT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='136' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTENDT = rs22.getString("FLDTXT");
                request.setAttribute("CNTENDT",CNTENDT);
                  } 
                String sql23= "select * from Field_Text where FLDID ='137' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String PEXTFLG = rs23.getString("FLDTXT");
                request.setAttribute("PEXTFLG",PEXTFLG);
                  }  
                String sql24= "select * from Field_Text where FLDID ='138' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String SWH = rs24.getString("FLDTXT");
                request.setAttribute("SWH",SWH);
                  }
                String sql25= "select * from Field_Text where FLDID ='139' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String AOTH = rs25.getString("FLDTXT");
                request.setAttribute("AOTH",AOTH);
                  }
                String sql26= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DELLOC = rs26.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }  
                String sql27= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String DELVBLS = rs27.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }  
                String sql28= "select * from Field_Text where FLDID ='140' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String PINFO = rs28.getString("FLDTXT");
                request.setAttribute("PINFO",PINFO);
                  }
                String sql29= "select * from Field_Text where FLDID ='141' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String PTRMS = rs29.getString("FLDTXT");
                request.setAttribute("PTRMS",PTRMS);
                  }
                String sql30= "select * from Field_Text where FLDID ='142' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CNTRLS = rs30.getString("FLDTXT");
                request.setAttribute("CNTRLS",CNTRLS);
                  } 
                String sql31= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String PRJEXT = rs31.getString("FLDTXT");
                request.setAttribute("PRJEXT",PRJEXT);
                  }  
                 String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  } 
                  
                             request.setAttribute("weblng",weblng);    
                                request.setAttribute("appnm","1");
                                request.setAttribute("prj",prj);
                                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/projectview.jsp");
                                rd.forward(request, response);                               
                                System.out.println("Successfully created Project"+prjno);
                               
                            }
                        
                        }
                        catch(SQLException hx){
                            JOptionPane.showMessageDialog(null,"Error: "+hx.getMessage());
                            System.out.println(hx.getMessage());
//                        request.setAttribute("err","ERR");
//                        request.setAttribute("mes",hx.getMessage());
//                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//                        rd.forward(request, response);
                            mav = new ModelAndView("projectview");
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
                mav = new ModelAndView("projectview");
            }
       
        return mav;
  }
       
    
     @RequestMapping(value="/updtprj")
    public ModelAndView update(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
           String scrn = request.getParameter("scrn");
               ModelAndView mav = null;
            String prjno = request.getParameter("prjno");
            String prjdes = request.getParameter("prjdes");
            String bizid = request.getParameter("bizid");
            String cntrtyp = request.getParameter("cntrtyp");
            String bpno = request.getParameter("bpno");
            String eusrno = request.getParameter("eusrno");
            String srepno = request.getParameter("srepno");
            String acmno = request.getParameter("acmno");
            String frmdt = request.getParameter("frmdt");
            String prjlivdt = request.getParameter("prjlivdt");
            String todt = request.getParameter("todt");
            String cntfrmdt = request.getParameter("cntfrmdt");
            String cnttodt = request.getParameter("cnttodt");
            String extflg = request.getParameter("extflg");
            String dellocid = request.getParameter("dellocid");
            String delvrblid = request.getParameter("delvrblid");
            String wrkhrs = request.getParameter("wrkhrs");
            String othrs = request.getParameter("othrs");
             String extflg1;
            if(extflg == null){
              extflg1 = "";
            }else{
               extflg1 = "X";
            }
        try{
             con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sqlupd = "update Project_Master set PRJDES = '"+prjdes+"', BIZID = '"+bizid+"', CNTRTYP = '"+cntrtyp+"', BPNO = '"+bpno+"', EUSRNO = '"+eusrno+"', "+
                            "SREPNO = '"+srepno+"', ACMNO = '"+acmno+"', FRMDT = '"+frmdt+"', PRJLIVDT = '"+prjlivdt+"', TODT = '"+todt+"', CNTFRMDT = '"+cntfrmdt+"', "+
                            "CNTTODT = '"+cnttodt+"', EXTFLG = '"+extflg1+"', DELLOCID = '"+dellocid+"', DELVRBLID = '"+delvrblid+"', WRKHRS = '"+wrkhrs+"', OTHRS = '"+othrs+"' where PRJNO = '"+prjno+"';";
            
             cst = con.createStatement();
            int u1 = cst.executeUpdate(sqlupd);
            
            if(u1 > 0){
            
              JOptionPane.showMessageDialog(null,"Record "+prjno+" Updated Successfully");    
             String weblng = request.getParameter("weblng");                
                String sql0= "select * from Field_Text where FLDID ='124'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String PRJMS = rs0.getString("FLDTXT");
                request.setAttribute("PRJMS",PRJMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='129'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String PRJS = rs1.getString("FLDTXT");
                request.setAttribute("PRJS",PRJS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String PRJCRE = rs2.getString("FLDTXT");
                request.setAttribute("PRJCRE",PRJCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String PRJEDT = rs3.getString("FLDTXT");
                request.setAttribute("PRJEDT",PRJEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String PRJDIS = rs4.getString("FLDTXT");
                request.setAttribute("PRJDIS",PRJDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String PRJDEL = rs5.getString("FLDTXT");
                request.setAttribute("PRJDEL",PRJDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PRJNUM = rs10.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String PRJDES = rs11.getString("FLDTXT");
                request.setAttribute("PRJDES",PRJDES);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BZLIN = rs12.getString("FLDTXT");
                request.setAttribute("BZLIN",BZLIN);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CNTYP = rs13.getString("FLDTXT");
                request.setAttribute("CNTYP",CNTYP);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='130' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PRJSTDT = rs14.getString("FLDTXT");
                request.setAttribute("PRJSTDT",PRJSTDT);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='131' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String PRJGLDT = rs15.getString("FLDTXT");
                request.setAttribute("PRJGLDT",PRJGLDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='132' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String PRJENDT = rs16.getString("FLDTXT");
                request.setAttribute("PRJENDT",PRJENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='133' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String SREP = rs17.getString("FLDTXT");
                request.setAttribute("SREP",SREP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='92' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BZPT = rs18.getString("FLDTXT");
                request.setAttribute("BZPT",BZPT);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EUSR = rs19.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='134' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ACM = rs20.getString("FLDTXT");
                request.setAttribute("ACM",ACM);
                  }
                String sql21= "select * from Field_Text where FLDID ='135' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CNTSTDT = rs21.getString("FLDTXT");
                request.setAttribute("CNTSTDT",CNTSTDT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='136' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTENDT = rs22.getString("FLDTXT");
                request.setAttribute("CNTENDT",CNTENDT);
                  } 
                String sql23= "select * from Field_Text where FLDID ='137' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String PEXTFLG = rs23.getString("FLDTXT");
                request.setAttribute("PEXTFLG",PEXTFLG);
                  }  
                String sql24= "select * from Field_Text where FLDID ='138' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String SWH = rs24.getString("FLDTXT");
                request.setAttribute("SWH",SWH);
                  }
                String sql25= "select * from Field_Text where FLDID ='139' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String AOTH = rs25.getString("FLDTXT");
                request.setAttribute("AOTH",AOTH);
                  }
                String sql26= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DELLOC = rs26.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }  
                String sql27= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String DELVBLS = rs27.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }  
                String sql28= "select * from Field_Text where FLDID ='140' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String PINFO = rs28.getString("FLDTXT");
                request.setAttribute("PINFO",PINFO);
                  }
                String sql29= "select * from Field_Text where FLDID ='141' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String PTRMS = rs29.getString("FLDTXT");
                request.setAttribute("PTRMS",PTRMS);
                  }
                String sql30= "select * from Field_Text where FLDID ='142' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CNTRLS = rs30.getString("FLDTXT");
                request.setAttribute("CNTRLS",CNTRLS);
                  }                                  
               String sql31= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String PRJEXT = rs31.getString("FLDTXT");
                request.setAttribute("PRJEXT",PRJEXT);
                  } 
                 String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  } 
                  
                request.setAttribute("weblng",weblng);
                request.setAttribute("updt","UPD");
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/projectview.jsp");
                rd.forward(request, response);
            
            }
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
//            request.setAttribute("err","ERR");
//            request.setAttribute("mes",ex.getMessage());
//            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/log.jsp");
//            rd.forward(request, response);
            System.out.println(ex.getMessage());
            mav = new ModelAndView("projectview");
        
        }       
        return mav;
    
    }
    
    
     @RequestMapping(value="/delprj")
    public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String prjno = request.getParameter("prjno");
        String scrn = request.getParameter("scrn");
        String weblng = request.getParameter("weblng");
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
            String sqldel = "Update Project_Master set ACTFLG = 'X' where PRJNO = '"+prjno+"';";
            cst = con.createStatement();
            int d1 = cst.executeUpdate(sqldel);
            
            if(d1 > 0){
              JOptionPane.showMessageDialog(null,"Record"+prjno+" is Set for Deletion Flag");
              
                String sql0= "select * from Field_Text where FLDID ='124'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String PRJMS = rs0.getString("FLDTXT");
                request.setAttribute("PRJMS",PRJMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='129'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String PRJS = rs1.getString("FLDTXT");
                request.setAttribute("PRJS",PRJS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String PRJCRE = rs2.getString("FLDTXT");
                request.setAttribute("PRJCRE",PRJCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String PRJEDT = rs3.getString("FLDTXT");
                request.setAttribute("PRJEDT",PRJEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String PRJDIS = rs4.getString("FLDTXT");
                request.setAttribute("PRJDIS",PRJDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String PRJDEL = rs5.getString("FLDTXT");
                request.setAttribute("PRJDEL",PRJDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PRJNUM = rs10.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String PRJDES = rs11.getString("FLDTXT");
                request.setAttribute("PRJDES",PRJDES);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BZLIN = rs12.getString("FLDTXT");
                request.setAttribute("BZLIN",BZLIN);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CNTYP = rs13.getString("FLDTXT");
                request.setAttribute("CNTYP",CNTYP);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='130' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PRJSTDT = rs14.getString("FLDTXT");
                request.setAttribute("PRJSTDT",PRJSTDT);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='131' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String PRJGLDT = rs15.getString("FLDTXT");
                request.setAttribute("PRJGLDT",PRJGLDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='132' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String PRJENDT = rs16.getString("FLDTXT");
                request.setAttribute("PRJENDT",PRJENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='133' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String SREP = rs17.getString("FLDTXT");
                request.setAttribute("SREP",SREP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='92' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BZPT = rs18.getString("FLDTXT");
                request.setAttribute("BZPT",BZPT);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EUSR = rs19.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='134' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ACM = rs20.getString("FLDTXT");
                request.setAttribute("ACM",ACM);
                  }
                String sql21= "select * from Field_Text where FLDID ='135' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CNTSTDT = rs21.getString("FLDTXT");
                request.setAttribute("CNTSTDT",CNTSTDT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='136' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTENDT = rs22.getString("FLDTXT");
                request.setAttribute("CNTENDT",CNTENDT);
                  } 
                String sql23= "select * from Field_Text where FLDID ='137' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String PEXTFLG = rs23.getString("FLDTXT");
                request.setAttribute("PEXTFLG",PEXTFLG);
                  }  
                String sql24= "select * from Field_Text where FLDID ='138' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String SWH = rs24.getString("FLDTXT");
                request.setAttribute("SWH",SWH);
                  }
                String sql25= "select * from Field_Text where FLDID ='139' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String AOTH = rs25.getString("FLDTXT");
                request.setAttribute("AOTH",AOTH);
                  }
                String sql26= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DELLOC = rs26.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }  
                String sql27= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String DELVBLS = rs27.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }  
                String sql28= "select * from Field_Text where FLDID ='140' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String PINFO = rs28.getString("FLDTXT");
                request.setAttribute("PINFO",PINFO);
                  }
                String sql29= "select * from Field_Text where FLDID ='141' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String PTRMS = rs29.getString("FLDTXT");
                request.setAttribute("PTRMS",PTRMS);
                  }
                String sql30= "select * from Field_Text where FLDID ='142' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CNTRLS = rs30.getString("FLDTXT");
                request.setAttribute("CNTRLS",CNTRLS);
                  } 
               String sql31= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String PRJEXT = rs31.getString("FLDTXT");
                request.setAttribute("PRJEXT",PRJEXT);
                  }  
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }  
                  
          request.setAttribute("weblng",weblng);
                request.setAttribute("delet","DEL");
                request.setAttribute("scrn",scrn);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/projectview.jsp");
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
            mav = new ModelAndView("projectview");
        
        }  
    }        
        else{
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/projectview.jsp");
                rd.forward(request, response);       
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
    
                @RequestMapping(value="/prjcre")
           public ModelAndView empcre(HttpServletRequest request,HttpServletResponse response) 
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
                String sql0= "select * from Field_Text where FLDID ='124'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String PRJMS = rs0.getString("FLDTXT");
                request.setAttribute("PRJMS",PRJMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='129'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String PRJS = rs1.getString("FLDTXT");
                request.setAttribute("PRJS",PRJS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String PRJCRE = rs2.getString("FLDTXT");
                request.setAttribute("PRJCRE",PRJCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String PRJEDT = rs3.getString("FLDTXT");
                request.setAttribute("PRJEDT",PRJEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String PRJDIS = rs4.getString("FLDTXT");
                request.setAttribute("PRJDIS",PRJDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String PRJDEL = rs5.getString("FLDTXT");
                request.setAttribute("PRJDEL",PRJDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PRJNUM = rs10.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String PRJDES = rs11.getString("FLDTXT");
                request.setAttribute("PRJDES",PRJDES);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BZLIN = rs12.getString("FLDTXT");
                request.setAttribute("BZLIN",BZLIN);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CNTYP = rs13.getString("FLDTXT");
                request.setAttribute("CNTYP",CNTYP);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='130' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PRJSTDT = rs14.getString("FLDTXT");
                request.setAttribute("PRJSTDT",PRJSTDT);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='131' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String PRJGLDT = rs15.getString("FLDTXT");
                request.setAttribute("PRJGLDT",PRJGLDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='132' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String PRJENDT = rs16.getString("FLDTXT");
                request.setAttribute("PRJENDT",PRJENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='133' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String SREP = rs17.getString("FLDTXT");
                request.setAttribute("SREP",SREP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='92' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BZPT = rs18.getString("FLDTXT");
                request.setAttribute("BZPT",BZPT);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EUSR = rs19.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='134' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ACM = rs20.getString("FLDTXT");
                request.setAttribute("ACM",ACM);
                  }
                String sql21= "select * from Field_Text where FLDID ='135' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CNTSTDT = rs21.getString("FLDTXT");
                request.setAttribute("CNTSTDT",CNTSTDT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='136' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTENDT = rs22.getString("FLDTXT");
                request.setAttribute("CNTENDT",CNTENDT);
                  } 
                String sql23= "select * from Field_Text where FLDID ='137' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String PEXTFLG = rs23.getString("FLDTXT");
                request.setAttribute("PEXTFLG",PEXTFLG);
                  }  
                String sql24= "select * from Field_Text where FLDID ='138' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String SWH = rs24.getString("FLDTXT");
                request.setAttribute("SWH",SWH);
                  }
                String sql25= "select * from Field_Text where FLDID ='139' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String AOTH = rs25.getString("FLDTXT");
                request.setAttribute("AOTH",AOTH);
                  }
                String sql26= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DELLOC = rs26.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }  
                String sql27= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String DELVBLS = rs27.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }  
                String sql28= "select * from Field_Text where FLDID ='140' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String PINFO = rs28.getString("FLDTXT");
                request.setAttribute("PINFO",PINFO);
                  }
                String sql29= "select * from Field_Text where FLDID ='141' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String PTRMS = rs29.getString("FLDTXT");
                request.setAttribute("PTRMS",PTRMS);
                  }
                String sql30= "select * from Field_Text where FLDID ='142' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CNTRLS = rs30.getString("FLDTXT");
                request.setAttribute("CNTRLS",CNTRLS);
                  }                                  
               String sql31= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String PRJEXT = rs31.getString("FLDTXT");
                request.setAttribute("PRJEXT",PRJEXT);
                  }
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
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
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/projectview.jsp");
          rd.forward(request, response);       
          ModelAndView mav = new ModelAndView("projectview");        
        
             return mav;
    
    }
    
    
              @RequestMapping(value="/prjcha")
         public ModelAndView prjcha(HttpServletRequest request,HttpServletResponse response) 
            throws SQLException, ServletException, IOException, ClassNotFoundException{
              String weblng = request.getParameter("weblng");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");             
                String sql0= "select * from Field_Text where FLDID ='124'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String PRJMS = rs0.getString("FLDTXT");
                request.setAttribute("PRJMS",PRJMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='129'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String PRJS = rs1.getString("FLDTXT");
                request.setAttribute("PRJS",PRJS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String PRJCRE = rs2.getString("FLDTXT");
                request.setAttribute("PRJCRE",PRJCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String PRJEDT = rs3.getString("FLDTXT");
                request.setAttribute("PRJEDT",PRJEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String PRJDIS = rs4.getString("FLDTXT");
                request.setAttribute("PRJDIS",PRJDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String PRJDEL = rs5.getString("FLDTXT");
                request.setAttribute("PRJDEL",PRJDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PRJNUM = rs10.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String PRJDES = rs11.getString("FLDTXT");
                request.setAttribute("PRJDES",PRJDES);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BZLIN = rs12.getString("FLDTXT");
                request.setAttribute("BZLIN",BZLIN);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CNTYP = rs13.getString("FLDTXT");
                request.setAttribute("CNTYP",CNTYP);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='130' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PRJSTDT = rs14.getString("FLDTXT");
                request.setAttribute("PRJSTDT",PRJSTDT);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='131' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String PRJGLDT = rs15.getString("FLDTXT");
                request.setAttribute("PRJGLDT",PRJGLDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='132' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String PRJENDT = rs16.getString("FLDTXT");
                request.setAttribute("PRJENDT",PRJENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='133' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String SREP = rs17.getString("FLDTXT");
                request.setAttribute("SREP",SREP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='92' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BZPT = rs18.getString("FLDTXT");
                request.setAttribute("BZPT",BZPT);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EUSR = rs19.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='134' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ACM = rs20.getString("FLDTXT");
                request.setAttribute("ACM",ACM);
                  }
                String sql21= "select * from Field_Text where FLDID ='135' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CNTSTDT = rs21.getString("FLDTXT");
                request.setAttribute("CNTSTDT",CNTSTDT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='136' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTENDT = rs22.getString("FLDTXT");
                request.setAttribute("CNTENDT",CNTENDT);
                  } 
                String sql23= "select * from Field_Text where FLDID ='137' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String PEXTFLG = rs23.getString("FLDTXT");
                request.setAttribute("PEXTFLG",PEXTFLG);
                  }  
                String sql24= "select * from Field_Text where FLDID ='138' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String SWH = rs24.getString("FLDTXT");
                request.setAttribute("SWH",SWH);
                  }
                String sql25= "select * from Field_Text where FLDID ='139' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String AOTH = rs25.getString("FLDTXT");
                request.setAttribute("AOTH",AOTH);
                  }
                String sql26= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DELLOC = rs26.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }  
                String sql27= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String DELVBLS = rs27.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }  
                String sql28= "select * from Field_Text where FLDID ='140' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String PINFO = rs28.getString("FLDTXT");
                request.setAttribute("PINFO",PINFO);
                  }
                String sql29= "select * from Field_Text where FLDID ='141' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String PTRMS = rs29.getString("FLDTXT");
                request.setAttribute("PTRMS",PTRMS);
                  }
                String sql30= "select * from Field_Text where FLDID ='142' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CNTRLS = rs30.getString("FLDTXT");
                request.setAttribute("CNTRLS",CNTRLS);
                  }                                  
              String sql31= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String PRJEXT = rs31.getString("FLDTXT");
                request.setAttribute("PRJEXT",PRJEXT);
                  } 
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }  
                  
             request.setAttribute("weblng",weblng);
             request.setAttribute("scrn", "edt");          
      RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/projectview.jsp");
      rd.forward(request, response);    
      ModelAndView mav = new ModelAndView("projectview"); 
         
        return mav;  
    }
    
      @RequestMapping(value="/prjdis")
       public ModelAndView prjdis(HttpServletRequest request,HttpServletResponse response) 
        throws SQLException, ServletException, IOException, ClassNotFoundException{
             String weblng = request.getParameter("weblng");
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");                
                String sql0= "select * from Field_Text where FLDID ='124'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String PRJMS = rs0.getString("FLDTXT");
                request.setAttribute("PRJMS",PRJMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='129'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String PRJS = rs1.getString("FLDTXT");
                request.setAttribute("PRJS",PRJS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String PRJCRE = rs2.getString("FLDTXT");
                request.setAttribute("PRJCRE",PRJCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String PRJEDT = rs3.getString("FLDTXT");
                request.setAttribute("PRJEDT",PRJEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String PRJDIS = rs4.getString("FLDTXT");
                request.setAttribute("PRJDIS",PRJDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String PRJDEL = rs5.getString("FLDTXT");
                request.setAttribute("PRJDEL",PRJDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PRJNUM = rs10.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String PRJDES = rs11.getString("FLDTXT");
                request.setAttribute("PRJDES",PRJDES);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BZLIN = rs12.getString("FLDTXT");
                request.setAttribute("BZLIN",BZLIN);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CNTYP = rs13.getString("FLDTXT");
                request.setAttribute("CNTYP",CNTYP);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='130' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PRJSTDT = rs14.getString("FLDTXT");
                request.setAttribute("PRJSTDT",PRJSTDT);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='131' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String PRJGLDT = rs15.getString("FLDTXT");
                request.setAttribute("PRJGLDT",PRJGLDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='132' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String PRJENDT = rs16.getString("FLDTXT");
                request.setAttribute("PRJENDT",PRJENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='133' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String SREP = rs17.getString("FLDTXT");
                request.setAttribute("SREP",SREP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='92' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BZPT = rs18.getString("FLDTXT");
                request.setAttribute("BZPT",BZPT);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EUSR = rs19.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='134' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ACM = rs20.getString("FLDTXT");
                request.setAttribute("ACM",ACM);
                  }
                String sql21= "select * from Field_Text where FLDID ='135' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CNTSTDT = rs21.getString("FLDTXT");
                request.setAttribute("CNTSTDT",CNTSTDT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='136' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTENDT = rs22.getString("FLDTXT");
                request.setAttribute("CNTENDT",CNTENDT);
                  } 
                String sql23= "select * from Field_Text where FLDID ='137' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String PEXTFLG = rs23.getString("FLDTXT");
                request.setAttribute("PEXTFLG",PEXTFLG);
                  }  
                String sql24= "select * from Field_Text where FLDID ='138' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String SWH = rs24.getString("FLDTXT");
                request.setAttribute("SWH",SWH);
                  }
                String sql25= "select * from Field_Text where FLDID ='139' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String AOTH = rs25.getString("FLDTXT");
                request.setAttribute("AOTH",AOTH);
                  }
                String sql26= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DELLOC = rs26.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }  
                String sql27= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String DELVBLS = rs27.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }  
                String sql28= "select * from Field_Text where FLDID ='140' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String PINFO = rs28.getString("FLDTXT");
                request.setAttribute("PINFO",PINFO);
                  }
                String sql29= "select * from Field_Text where FLDID ='141' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String PTRMS = rs29.getString("FLDTXT");
                request.setAttribute("PTRMS",PTRMS);
                  }
                String sql30= "select * from Field_Text where FLDID ='142' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CNTRLS = rs30.getString("FLDTXT");
                request.setAttribute("CNTRLS",CNTRLS);
                  }                                  
               String sql31= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String PRJEXT = rs31.getString("FLDTXT");
                request.setAttribute("PRJEXT",PRJEXT);
                  }
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  }  
                  
          request.setAttribute("weblng",weblng);
            request.setAttribute("scrn", "dis");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/projectview.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("projectview");
           
           return mav;
       }
       
       
          @RequestMapping(value="/prjdel")
       public ModelAndView prjdel(HttpServletRequest request,HttpServletResponse response) 
        throws SQLException, ServletException, IOException, ClassNotFoundException{
             String weblng = request.getParameter("weblng"); 
        con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
        Class.forName("com.mysql.cj.jdbc.Driver");               
                String sql0= "select * from Field_Text where FLDID ='124'and LNGID ='"+weblng+"'";
                PreparedStatement pst0 = con.prepareStatement(sql0);
                ResultSet rs0 = pst0.executeQuery();
                while(rs0.next()){
                String PRJMS = rs0.getString("FLDTXT");
                request.setAttribute("PRJMS",PRJMS);
                }
                
                String sql1= "select * from Field_Text where FLDID ='129'and LNGID ='"+weblng+"'";
                PreparedStatement pst1 = con.prepareStatement(sql1);
                ResultSet rs1 = pst1.executeQuery();
                while(rs1.next()){
                String PRJS = rs1.getString("FLDTXT");
                request.setAttribute("PRJS",PRJS);
                }
                
                String sql2= "select * from Field_Text where FLDID ='03' and LNGID ='"+weblng+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                ResultSet rs2 = pst2.executeQuery();
                while(rs2.next()){
                String PRJCRE = rs2.getString("FLDTXT");
                request.setAttribute("PRJCRE",PRJCRE);
                }
                String sql3= "select * from Field_Text where FLDID ='04' and LNGID ='"+weblng+"'";
                PreparedStatement pst3 = con.prepareStatement(sql3);
                ResultSet rs3 = pst3.executeQuery();
                while(rs3.next()){
                String PRJEDT = rs3.getString("FLDTXT");
                request.setAttribute("PRJEDT",PRJEDT);
                }
                
                String sql4= "select * from Field_Text where FLDID ='05' and LNGID ='"+weblng+"'";
                PreparedStatement pst4 = con.prepareStatement(sql4);
                ResultSet rs4 = pst4.executeQuery();
                  while(rs4.next()){
                String PRJDIS = rs4.getString("FLDTXT");
                request.setAttribute("PRJDIS",PRJDIS);
                  }
                  
                String sql5= "select * from Field_Text where FLDID ='106' and LNGID ='"+weblng+"'";
                PreparedStatement pst5 = con.prepareStatement(sql5);
                ResultSet rs5 = pst5.executeQuery();
                  while(rs5.next()){
                String PRJDEL = rs5.getString("FLDTXT");
                request.setAttribute("PRJDEL",PRJDEL);
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
                 
                String sql10= "select * from Field_Text where FLDID ='113' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PRJNUM = rs10.getString("FLDTXT");
                request.setAttribute("PRJNUM",PRJNUM);
                  }
                
                String sql11= "select * from Field_Text where FLDID ='59' and LNGID ='"+weblng+"'";
                PreparedStatement pst11 = con.prepareStatement(sql11);
                ResultSet rs11 = pst11.executeQuery();
                  while(rs11.next()){
                String PRJDES = rs11.getString("FLDTXT");
                request.setAttribute("PRJDES",PRJDES);
                  }
                  
                String sql12= "select * from Field_Text where FLDID ='47' and LNGID ='"+weblng+"'";
                PreparedStatement pst12 = con.prepareStatement(sql12);
                ResultSet rs12 = pst12.executeQuery();
                  while(rs12.next()){
                String BZLIN = rs12.getString("FLDTXT");
                request.setAttribute("BZLIN",BZLIN);
                  }
                  
                String sql13= "select * from Field_Text where FLDID ='96' and LNGID ='"+weblng+"'";
                PreparedStatement pst13 = con.prepareStatement(sql13);
                ResultSet rs13 = pst13.executeQuery();
                  while(rs13.next()){
                String CNTYP = rs13.getString("FLDTXT");
                request.setAttribute("CNTYP",CNTYP);
                  }
                  
                String sql14= "select * from Field_Text where FLDID ='130' and LNGID ='"+weblng+"'";
                PreparedStatement pst14 = con.prepareStatement(sql14);
                ResultSet rs14 = pst14.executeQuery();
                  while(rs14.next()){
                String PRJSTDT = rs14.getString("FLDTXT");
                request.setAttribute("PRJSTDT",PRJSTDT);
                  }
                  
                String sql15= "select * from Field_Text where FLDID ='131' and LNGID ='"+weblng+"'";
                PreparedStatement pst15 = con.prepareStatement(sql15);
                ResultSet rs15 = pst15.executeQuery();
                  while(rs15.next()){
                String PRJGLDT = rs15.getString("FLDTXT");
                request.setAttribute("PRJGLDT",PRJGLDT);
                  }
                  
                String sql16= "select * from Field_Text where FLDID ='132' and LNGID ='"+weblng+"'";
                PreparedStatement pst16 = con.prepareStatement(sql16);
                ResultSet rs16 = pst16.executeQuery();
                  while(rs16.next()){
                String PRJENDT = rs16.getString("FLDTXT");
                request.setAttribute("PRJENDT",PRJENDT);
                  }
                  
                String sql17= "select * from Field_Text where FLDID ='133' and LNGID ='"+weblng+"'";
                PreparedStatement pst17 = con.prepareStatement(sql17);
                ResultSet rs17 = pst17.executeQuery();
                  while(rs17.next()){
                String SREP = rs17.getString("FLDTXT");
                request.setAttribute("SREP",SREP);
                  }
                
                String sql18= "select * from Field_Text where FLDID ='92' and LNGID ='"+weblng+"'";
                PreparedStatement pst18 = con.prepareStatement(sql18);
                ResultSet rs18 = pst18.executeQuery();
                  while(rs18.next()){
                String BZPT = rs18.getString("FLDTXT");
                request.setAttribute("BZPT",BZPT);
                  }  
                  
                String sql19= "select * from Field_Text where FLDID ='81' and LNGID ='"+weblng+"'";
                PreparedStatement pst19 = con.prepareStatement(sql19);
                ResultSet rs19 = pst19.executeQuery();
                  while(rs19.next()){
                String EUSR = rs19.getString("FLDTXT");
                request.setAttribute("EUSR",EUSR);
                  }
                  
                String sql20= "select * from Field_Text where FLDID ='134' and LNGID ='"+weblng+"'";
                PreparedStatement pst20 = con.prepareStatement(sql20);
                ResultSet rs20 = pst20.executeQuery();
                  while(rs20.next()){
                String ACM = rs20.getString("FLDTXT");
                request.setAttribute("ACM",ACM);
                  }
                String sql21= "select * from Field_Text where FLDID ='135' and LNGID ='"+weblng+"'";
                PreparedStatement pst21 = con.prepareStatement(sql21);
                ResultSet rs21 = pst21.executeQuery();
                  while(rs21.next()){
                String CNTSTDT = rs21.getString("FLDTXT");
                request.setAttribute("CNTSTDT",CNTSTDT);
                  }  
                String sql22= "select * from Field_Text where FLDID ='136' and LNGID ='"+weblng+"'";
                PreparedStatement pst22 = con.prepareStatement(sql22);
                ResultSet rs22 = pst22.executeQuery();
                  while(rs22.next()){
                String CNTENDT = rs22.getString("FLDTXT");
                request.setAttribute("CNTENDT",CNTENDT);
                  } 
                String sql23= "select * from Field_Text where FLDID ='137' and LNGID ='"+weblng+"'";
                PreparedStatement pst23 = con.prepareStatement(sql23);
                ResultSet rs23 = pst23.executeQuery();
                  while(rs23.next()){
                String PEXTFLG = rs23.getString("FLDTXT");
                request.setAttribute("PEXTFLG",PEXTFLG);
                  }  
                String sql24= "select * from Field_Text where FLDID ='138' and LNGID ='"+weblng+"'";
                PreparedStatement pst24 = con.prepareStatement(sql24);
                ResultSet rs24 = pst24.executeQuery();
                  while(rs24.next()){
                String SWH = rs24.getString("FLDTXT");
                request.setAttribute("SWH",SWH);
                  }
                String sql25= "select * from Field_Text where FLDID ='139' and LNGID ='"+weblng+"'";
                PreparedStatement pst25 = con.prepareStatement(sql25);
                ResultSet rs25 = pst25.executeQuery();
                  while(rs25.next()){
                String AOTH = rs25.getString("FLDTXT");
                request.setAttribute("AOTH",AOTH);
                  }
                String sql26= "select * from Field_Text where FLDID ='119' and LNGID ='"+weblng+"'";
                PreparedStatement pst26 = con.prepareStatement(sql26);
                ResultSet rs26 = pst26.executeQuery();
                  while(rs26.next()){
                String DELLOC = rs26.getString("FLDTXT");
                request.setAttribute("DELLOC",DELLOC);
                  }  
                String sql27= "select * from Field_Text where FLDID ='120' and LNGID ='"+weblng+"'";
                PreparedStatement pst27 = con.prepareStatement(sql27);
                ResultSet rs27 = pst27.executeQuery();
                  while(rs27.next()){
                String DELVBLS = rs27.getString("FLDTXT");
                request.setAttribute("DELVBLS",DELVBLS);
                  }  
                String sql28= "select * from Field_Text where FLDID ='140' and LNGID ='"+weblng+"'";
                PreparedStatement pst28 = con.prepareStatement(sql28);
                ResultSet rs28 = pst28.executeQuery();
                  while(rs28.next()){
                String PINFO = rs28.getString("FLDTXT");
                request.setAttribute("PINFO",PINFO);
                  }
                String sql29= "select * from Field_Text where FLDID ='141' and LNGID ='"+weblng+"'";
                PreparedStatement pst29 = con.prepareStatement(sql29);
                ResultSet rs29 = pst29.executeQuery();
                  while(rs29.next()){
                String PTRMS = rs29.getString("FLDTXT");
                request.setAttribute("PTRMS",PTRMS);
                  }
                String sql30= "select * from Field_Text where FLDID ='142' and LNGID ='"+weblng+"'";
                PreparedStatement pst30 = con.prepareStatement(sql30);
                ResultSet rs30 = pst30.executeQuery();
                  while(rs30.next()){
                String CNTRLS = rs30.getString("FLDTXT");
                request.setAttribute("CNTRLS",CNTRLS);
                  }                                  
                String sql31= "select * from Field_Text where FLDID ='60' and LNGID ='"+weblng+"'";
                PreparedStatement pst31 = con.prepareStatement(sql31);
                ResultSet rs31 = pst31.executeQuery();
                  while(rs31.next()){
                String PRJEXT = rs31.getString("FLDTXT");
                request.setAttribute("PRJEXT",PRJEXT);
                  }
                String sql41= "select * from Message_Txt where MSGID ='07' and LNGID ='"+weblng+"'";
                PreparedStatement pst41 = con.prepareStatement(sql41);
                ResultSet rs41 = pst41.executeQuery();
                  while(rs41.next()){
                String DELFLG = rs41.getString("MSGTXT");
                request.setAttribute("DELFLG",DELFLG);
                  } 
                  
          request.setAttribute("weblng",weblng);
            request.setAttribute("scrn", "del");          
          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/projectview.jsp");
          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("projectview");
           
           return mav;
       } 
 
   @RequestMapping(value="/prjback")
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
                String sql9= "select * from Field_Text where FLDID ='107' and LNGID ='"+weblng+"'";
                PreparedStatement pst9 = con.prepareStatement(sql9);
                ResultSet rs9 = pst9.executeQuery();
                  while(rs9.next()){
                String ESTMS = rs9.getString("FLDTXT");
                request.setAttribute("ESTMS",ESTMS);
                  }  
               String sql10= "select * from Field_Text where FLDID ='124' and LNGID ='"+weblng+"'";
                PreparedStatement pst10 = con.prepareStatement(sql10);
                ResultSet rs10 = pst10.executeQuery();
                  while(rs10.next()){
                String PRJMS = rs10.getString("FLDTXT");
                request.setAttribute("PRJMS",PRJMS);
                  }   
                
                                
                request.setAttribute("emnum",emnum);
                request.setAttribute("weblng",weblng);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/start.jsp");
                rd.forward(request, response);
        
        mav = new ModelAndView("emplist");
        
       
        return mav;
        
    } 
       
              
}

