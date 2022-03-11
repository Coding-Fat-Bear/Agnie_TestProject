/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.agnie.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class PrjRevRep {
 @RequestMapping(value="/prjrevrep")
public ModelAndView prjrevrep (HttpServletRequest request,HttpServletResponse response) 
        throws SQLException, ServletException, IOException, ClassNotFoundException{
        ModelAndView mav = null;
        String prjno = request.getParameter("prjno");
        String prj = prjno;
        System.out.println(prj);
        System.out.println("Revenue Report");
         RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/prjrevrep.jsp");
                            rd.forward(request, response);
      //  mav = new ModelAndView("prjrevrep.jsp");
    return mav;
}


@RequestMapping(value="/getreport")
   public ModelAndView getreport (HttpServletRequest request,HttpServletResponse response) 
    throws SQLException, ServletException, IOException, ClassNotFoundException{
//    String scrn = request.getParameter("scrn");
try{
        String prjno = request.getParameter("prjno");
        String prj = prjno;
        System.out.println(prj);
   Class.forName("com.mysql.jdbc.Driver");
   Connection con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
   String reportPath = "C:\\Users\\AGI08\\JaspersoftWorkspace\\MyReports\\Revenue_Report.jrxml";
   JasperReport jr = JasperCompileManager.compileReport(reportPath);
   Map parameters = new HashMap();
   parameters.put("ParamPrjno", prj);
   JasperPrint jp = JasperFillManager.fillReport(jr,parameters, con);
   JasperViewer.viewReport(jp);
   con.close();
}

catch(Exception ex)
{
ex.printStackTrace();
}

//          request.setAttribute("scrn", scrn);          
//          RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/prjrevrep.jsp");
//          rd.forward(request, response);
        
        ModelAndView mav = new ModelAndView("prjrevrep");
           
           return mav;
   }

}
