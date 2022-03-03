<%-- 
    Document   : inquiryview
    Created on : Nov 22, 2021, 5:08:05 PM
    Author     : Admin
--%>

<%-- 
    Document   : loj
    Created on : Oct 21, 2021, 12:35:22 AM
    Author     : Agnie
--%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="java.util.Random"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.agnie.controller.Project" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project Details Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    </head>
    
<style>
        html, body,  span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, font, img1 ins, kbd, q, s, samp,
small, strike, strong, sub, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td {
    margin:0;
    padding:0;
    border:0;
    outline:0;
	width:auto;
    vertical-align: bottom;
    background:transparent;
}
body {
    line-height:1.78;
    position: center;
    font-family:'ヒラギノ角ゴ Pro W3','Hiragino Kaku Gothic Pro','メイリオ',Meiryo,'ＭＳ Ｐゴシック',sans-serif;
    font-size: 14.5px;
    height:auto;
    color: #848484;
    background-color: #F4F6F9;
    background-size: 100%;
    overflow:auto;
  /* background-color: transparent; */
    overflow-x:hidden;
}

header{
  width:100%;
  margin: 0;
  padding:0;
  background: rgba(42,55,123,0.9);
  position: fixed top;
  height: 50px;
  overflow: hidden;
  z-index: 50
}

 header::after{
  content: "";
  display: table;
  clear: both;
  bottom: 0px;
}

.header-inner{
    float: left;
    width: 30px;
    margin: auto; 
    position: relative; 
}

.header-inner1{
    float: right;
    width: 146px;
    margin: 30px
/*   position:relative; */
}

.dropbtn {
  background-color: transparent;
  color:white;
  padding: 16px;
  font-size: 16px;
  border: none;
}

.dropdown {
  position: relative;
  display: inline-block;
  margin-right: 40px
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #889189;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content li {
    align-content: center;
  color: black;
  width:100%;
  height: 100%;
  margin-bottom: 0px;
  padding: 20px 0px;
  text-decoration: none;
  display: block;
}
.dropdown-content .menu{
    margin-top: -10px;
    width: 100%;
    height: 100%;
    cursor: pointer;
    text-align: left;
    float:left;
    border:none;
    outline: none;
    background-color: transparent;
    font-size: 16px;
    margin-left: 10px
}

.dropdown-content li:hover {background-color: #ddd;}

.dropdown:hover .dropdown-content {display: block;}

.dropdown:hover .dropbtn {background-color: #3e8e41;}

.mbar{
    
    background-color: #555;
    border-bottom-style: ridge;
    margin-left: 10px;
    margin-right: 10px;
    width: 750px;
}

.head{
	display:block;
        margin:10px
}
.head ul {
	
	margin:30px;
        text-decoration: none;
	list-style-type: none;
        margin-left: 5px;
        
}

.head ul li{
	/*display:grid;*/
	margin-right:0px;
        color: black;
        text-decoration: none;
        margin-bottom: 5px
}

.head label{
	color: black;
	font-size:100%;
        display: inline-block;
        text-align: left;
        width: 200px;
}

.tablink {
  background-color: #555;
  color: white;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 12px 14px;
  font-size: 14px;
  width: 20%;
  border-radius: 0px 25px 0px;
}

.tablink:hover {
  background-color:#777
}

.tabcontent {
  color: white;
  background-color:rgb(94 132 156);
  display: none;
  padding-bottom: 10px;
  padding-top: 50px;
  padding-left: 10px;
  height: auto;
  margin: 0;
  border-radius: 25px;
  width: 748px;
  
}
 input[type=number].no-spinner::-webkit-inner-spin-button, 
    input[type=number]::-webkit-outer-spin-button { 
    -webkit-appearance: none; 
      
}

.top li{
    display: inline-block;
 
}

.opbut li{
    display: inline-block;
}

.sald{
    display: inline-block
}
input.larger{
    width: 20px;
    height: 20px;
}
	
	.gfg {
		cursor: pointer;
	}
	
	.gfg::before {
		content: "\25B6";
		color: black;
		display: inline-block;
		margin-right: 8px;
                
	}
	
	.cover {
		display: none;
                margin-left: 20px;
	}
	
	.active {
		display: block;
	}
	
	ol [type=a] {
		background-color: lawngreen;
		color: purple;
                margin-left: 15px;
	}
 /*Modal CSS*/
 .modal {
  display: none;
  /* Hidden by default */
  position: fixed;
  /* Stay in place */
  z-index: 1;
  /* Sit on top */
  padding-top: 100px;
  /* Location of the box */
  left: 0;
  top: 30px;
  width: 100%;
  /* Full width */
  height: 100%;
  /* Full height */
  overflow: auto;
  /* Enable scroll if needed */
  background-color: rgb(0, 0, 0);
  /* Fallback color */
  background-color: rgba(0, 0, 0, 0.4);
  /* Black w/ opacity */
}
/* Modal Content */

.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 40%;
}


/* The Close Button */

.close {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}

</style>
    <body> 
        <header> 
        <h1 align="center"><%= request.getAttribute("PRJMS") %></h1>
        </header>
        <form method="post">
            <div class="mbar" >
      <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("PRJS") %></button>
                <div id="drpcnt" class="dropdown-content">
                    <li><button  formaction="prjcre" class="menu" style="cursor: pointer" ><%= request.getAttribute("PRJCRE") %></button></li>
                    <li><button  formaction="prjcha" class="menu" style="cursor: pointer" ><%= request.getAttribute("PRJEDT") %></button></li>
                    <li><button  formaction="prjdis" class="menu" style="cursor: pointer" ><%= request.getAttribute("PRJDIS") %></button></li>
                    <li><button  formaction="prjdel" class="menu" style="cursor: pointer" ><%= request.getAttribute("PRJDEL") %></button></li>
                    <li><button  class="menu" ><%= request.getAttribute("PRJEXT") %></button></li>
                </div>
            </div>  
        <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("TOLEDT") %></button>
            </div>
        <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("TOLGOTO") %></button>
            </div>
            <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("TOLENV") %></button>
            </div>
            <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("TOLSYS") %></button>
            </div>   
    </div>

<div id="hed" class="head" >
    <!--<form action="insert" method="post">--> 
                <ul class="opbut">                    
                    <li><button type="submit" id="btncre" formaction="insertprj" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=CreateProject><i class="fa fa-save"></i></button></li>
                    <li><button type="button" id="btnget" onclick="prjbutget()" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=Get><i class="fas fa-glasses"></i></i></button></li>
                    <li><button type="submit" id="btnedt" formaction="updtprj" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=Update ><i class="fa fa-save"></i></button></li>
                    <li><button type="submit" id="btndel" formaction="delprj" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=Delete ><i class="fa fa-trash"></i></button></li>                            
                    <li><button type="submit" id="btnbck" formaction="prjback" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=Back><i class="fa fa-hand-o-left"></i></button></li>   
                </ul>
                <dialog id="dltd" class="rowdeldia" >                    
                            <p style="margin-top:20px">Record <%= request.getAttribute("DELFLG") %></p>
                            <button type="button" id="dltdbt" onclick="dltd();" >OK</button>
                </dialog>
        
        <ul class="top">
            <input type="text" style="width:53px;" maxlength="7" name="weblng" id="weblng" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="scrn" id="scrn" hidden>
          <li><label for="prjno" style="width:120px"><%= request.getAttribute("PRJNUM") %> </label> <input type="text" name="prjno" maxlength="9" style="width:75px" id="prjno" > </li>                
          <!--<li><label for="ccod" style="width:120px">Company Code </label> <input type="text" name="ccod" maxlength="4" style="width:40px" id="ccod"></li>-->
          <li><label for="prjdes" style="width:150px"><%= request.getAttribute("PRJDES") %> </label> <input type="text" maxlength="30" size="30" name="prjdes" id="prjdes"></li>
        </ul>
        <div class="tabs">
        <button type="button" class="tablink" id="T1" onclick="openPage(this.id)"><%= request.getAttribute("PINFO") %></button>
        <button type="button" class="tablink" id="T2" onclick="openPage(this.id)"><%= request.getAttribute("PTRMS") %></button>
        <button type="button"  class="tablink" id="T3" onclick="openPage(this.id)"><%= request.getAttribute("CNTRLS") %></button>
        <!--<button type="button" class="tablink" id="T4" onclick="openPage(this.id)">Departments/Employees </button>-->
        </div>
<div id="T1" class="tabcontent">
  <!--<h3> Data1</h3>-->
  <%
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      Connection con1 = null;
                      Statement stm = null;
  %>
  <ul>
      <label for="bizid"><%= request.getAttribute("BZLIN") %></label> <!--  <input type="text" name="bizid" maxlength="7" size="7" id="bizid" ><br>-->
               <select maxlength="2" style="width:120px;text-transform:uppercase" type="text" id="bizid" name="bizid" >
            <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Business_Line";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("BIZID")%>"><%=rs2.getString("BIZ_TEXT")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
          </select> <br>  
         <label for="cntrtyp"><%= request.getAttribute("CNTYP") %> </label> <!-- <input type="text" name="cntrno" maxlength="7" size="7" id="cntrno"><br>   -->
             <select maxlength="3" style="width:120px;text-transform:uppercase" type="text" id="cntrtyp" name="cntrtyp" >
            <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Contract_Types";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("CNTRTYP")%>"><%=rs2.getString("CNTRTEXT")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
          </select> <br>  
          <label for="frmdt"><%= request.getAttribute("PRJSTDT") %></label> <input type="date" name="frmdt" style="width: 135px;text-transform:uppercase" id="frmdt" ><br>
          <label for="prjlivdt"><%= request.getAttribute("PRJGLDT") %></label> <input type="date" name="prjlivdt" style="width: 135px;text-transform:uppercase" id="prjlivdt" ><br>
          <label for="todt"><%= request.getAttribute("PRJENDT") %></label> <input type="date" name="todt" style="width: 135px;text-transform:uppercase" id="todt" > <br>
      </ul>  
</div>
  <div id="T2" class="tabcontent">
  <!--<h3> Data2</h3>-->
     <ul>
         
         <label for="srepno"><%= request.getAttribute("SREP") %> </label> <input type="text" name="srepno" maxlength="7" size="7" id="srepno" value="Sales Rep" onclick="openModal()" >
          <div id="modal" class="modal">
        <div class="modal-content">
            <br>
            <span class="close">&times;</span>      
  <ul id="tuitorial">
        <li><span class="gfg">Departments/Employees</span>
            <ol class="cover" type="i">
                <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '01'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '01'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>                         
                            <li class="elist" id="ename" onclick="EName()" ><%=rs.getString("EMPNAM")%></li>  
                            <!--<option><%=rs.getString("EMPNAM")%></option>-->
                         <%
                             }
                              %>
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                  <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '02'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '02'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                      
                        <!--<li><%=rs2.getString("DPT_TEXT")%></li>-->
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                               <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '03'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '03'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                      
                        <!--<li><%=rs2.getString("DPT_TEXT")%></li>-->
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                            <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '04'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '04'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                        <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '05'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '05'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                      
                        <!--<li><%=rs2.getString("DPT_TEXT")%></li>-->
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
            </ol>
        </li>
    </ul>          
        </div>
    </div>
<br>
          <label for="bpno"><%= request.getAttribute("BZPT") %></label> <input type="text" name="bpno" maxlength="7" size="7" id="bpno" ><br>
          <label for="eusrno"><%= request.getAttribute("EUSR") %></label> <input type="text" name="eusrno" maxlength="7" size="7" id="eusrno" > <br>
          <label for="acmno"> <%= request.getAttribute("ACM") %> </label> <input type="text" name="acmno" maxlength="7" size="7" id="acmno" onclick="openModal()" >
          <div id="modal" class="modal">
        <div class="modal-content">
            <br>
            <span class="close">&times;</span>      
  <ul id="tuitorial">
        <li><span class="gfg">Departments/Employees</span>
            <ol class="cover" type="i">
                <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '01'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '01'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>                         
                            <li class="elist" id="ename" onclick="EName()" ><%=rs.getString("EMPNAM")%></li>  
                            <!--<option><%=rs.getString("EMPNAM")%></option>-->
                         <%
                             }
                              %>
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                  <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '02'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '02'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                      
                        <!--<li><%=rs2.getString("DPT_TEXT")%></li>-->
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                               <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '03'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '03'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                      
                        <!--<li><%=rs2.getString("DPT_TEXT")%></li>-->
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                            <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '04'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '04'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                        <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '05'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '05'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                      
                        <!--<li><%=rs2.getString("DPT_TEXT")%></li>-->
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
            </ol>
        </li>
    </ul>          
        </div>
          </div> <br>
          </ul>
</div>

<div id="T3" class="tabcontent">
  <!--<h3>Estimation Detail</h3>-->
  <ul>
          <label for="cntfrmdt"><%= request.getAttribute("CNTSTDT") %></label> <input type="date" name="cntfrmdt" style="width: 135px;text-transform:uppercase" id="cntfrmdt" ><br>
          <label for="cnttodt"><%= request.getAttribute("CNTENDT") %></label> <input type="date" name="cnttodt" style="width: 135px;text-transform:uppercase" id="cnttodt" ><br>
          <label for="extflg"><%= request.getAttribute("PEXTFLG") %></label> <input type="checkbox"  class="larger" id="extflg" name="extflg" ><br>
          <script>
               document.getElementById("extflg").checked = true;
               document.getElementById("extflg").checked = false;
          </script>
           <label for="dellocid"><%= request.getAttribute("DELLOC") %> </label> <!-- <input type="text" name="dellocid" maxlength="20" size="20" id="dellocid" ><br> -->
             <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="dellocid" name="dellocid" >
            <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Delivery_Place";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("DELLOCID")%>"><%=rs2.getString("DELLOC")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
          </select> <br>
          <label for="delvrblid"><%= request.getAttribute("DELVBLS") %>  </label> <!-- <input type="text" name="delvrblid" maxlength="20" size="20" id="delvrblid" ><br> -->
             <select maxlength="2" style="width:120px;text-transform:uppercase" type="text" id="delvrblid" name="delvrblid" >
            <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Deliverables";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("DELVRBLID")%>"><%=rs2.getString("DELVRBLS")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
          </select> <br>
           <label for="wrkhrs"><%= request.getAttribute("SWH") %> </label> <input type="text" name="wrkhrs" maxlength="4" size="4" id="wrkhrs" ><br>
           <label for="othrs"><%= request.getAttribute("AOTH") %></label> <input type="text" name="othrs" maxlength=4" size="4" id="othrs" ><br>
          
     </ul>
</div>

<!--<div id="T4" class="tabcontent">
  - Tree View 

  <ul id="tuitorial">
        <li><span class="gfg">Departments/Employees</span>
            <ol class="cover" type="i">
                <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '01'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '01'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                            <option> <%=rs.getString("EMPNAM")%> </option>
                         <%
                             }
                              %>
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                  <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '02'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '02'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                      
                        <li><%=rs2.getString("DPT_TEXT")%></li>
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                               <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '03'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '03'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                      
                        <li><%=rs2.getString("DPT_TEXT")%></li>
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                            <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '04'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '04'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                        <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Department where DPTCOD = '05'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                         <li><span class="gfg"><%=rs2.getString("DPT_TEXT")%></span>
                           <ol class="cover" type="a">
                               <%     
                            String qry = "select * from Employee_Master where DPTCOD = '05'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry); 
                        while(rs.next()){ 
                            %>
                         <li><%=rs.getString("EMPNAM")%></li>
                         <%
                             }
                              %>
                      
                        <li><%=rs2.getString("DPT_TEXT")%></li>
                 </ol>
                </li>  
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
            </ol>
        </li>
    </ul>
  
</div>-->
    <!--</form>-->
         <!--List Table Data for Get Operation-->
     <table style="display:none;overflow-x: auto" id="prjtbl" name="prjtbl" class="prjtbl" hidden="true">
            
           <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String sqlmst = "SELECT * FROM Project_Master";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(sqlmst);
                      while(rs2.next())
                      {
                          %>
               <tr>
               <td><%=rs2.getString("PRJNO") %></td> <!--0-->
               <td><%=rs2.getString("PRJDES") %></td>   <!--1-->
               <td><%=rs2.getString("BIZID") %></td> <!--2-->
               <td><%=rs2.getString("CNTRTYP") %></td>  <!--3-->
               <td><%=rs2.getString("BPNO") %></td>  <!--4-->
               <td><%=rs2.getString("EUSRNO") %></td>  <!--5-->
               <td><%=rs2.getString("SREPNO") %></td>  <!--6-->
               <td><%=rs2.getString("ACMNO") %></td>  <!--7-->
               <td><%=rs2.getString("FRMDT") %></td>  <!--8-->
               <td><%=rs2.getString("PRJLIVDT") %></td>   <!--9-->
               <td><%=rs2.getString("TODT") %></td>   <!--10-->
               <td><%=rs2.getString("CNTFRMDT") %></td>  <!--11-->
               <td><%=rs2.getString("CNTTODT") %></td>  <!--12-->
               <td><%=rs2.getString("EXTFLG") %></td>  <!--13-->
               <td><%=rs2.getString("DELLOCID") %></td>  <!--14-->
               <td><%=rs2.getString("DELVRBLID") %></td>  <!--15-->
               <td><%=rs2.getString("WRKHRS") %></td>  <!--16-->
               <td><%=rs2.getString("OTHRS") %></td>  <!--17-->
               <td><%=rs2.getString("ACTFLG") %></td>  <!--18-->
               
               </tr>
                <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
                  
            
            </table>
    
    </form>
</div>
          
    <script>
	var toggler = document.getElementsByClassName("gfg");
	var i;

	for (i = 0; i < toggler.length; i++) {
		toggler[i].addEventListener("click",
			function() {
				this.parentElement.querySelector(".cover")
					.classList.toggle("active");
				this.classList.toggle("gfg-down");
			}
		);
	}
</script>
  <script>   
    document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
  //  document.getElementById("emnum").value = '<%= request.getAttribute("emnum") %>';
    document.getElementById("scrn").value = '<%= request.getAttribute("scrn") %>';
</script>
      
<script>
 var temp = 0;
 var temp1 = "T1";
function openPage(clicked_id) {
var basdt1 ;
  var i, tabcontent, tablinks, tabid;
  tabcontent = document.getElementsByClassName("tabcontent");
  
  for (i = 0; i < tabcontent.length; i++) {
  tabid = tabcontent[i].id;
  
	if(tabid == clicked_id){
	tabcontent[temp].style.display = "none";
	document.getElementById(temp1).style.backgroundColor = "#555";
    tabcontent[i].style.display = "block";
	tabcontent[i].style.backgroundColor = "rgb(94 132 156)";
	document.getElementById(clicked_id).style.backgroundColor = "rgb(94 132 156)";
	temp = i;
	temp1 = clicked_id;
	break;
	}
	
  }
 
}
document.getElementById("T1").click();
    //Current Date and Time
//    var today = new Date();
//    var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
//    document.getElementById("credt").value = date;
</script>

  <script>
     
       if('<%= request.getAttribute("scrn") %>' === 'cre'){
         document.getElementById("scrn").value = "cre";
         document.getElementById("btncre").style.display = "block";
      //   document.getElementById("btnedt").style.display = "none";
      //   document.getElementById("btnget").style.display = "none";
     //    document.getElementById("btndel").style.display = "none";
         document.getElementById("btnbck").style.display = "block";
         document.getElementById("prjno").required = false;
         document.getElementById('prjdes').disabled = false;
         
         document.getElementById('bizid').disabled = false;                  
         document.getElementById('cntrtyp').disabled = false;
         document.getElementById('bpno').disabled = false;
         document.getElementById('eusrno').disabled = false;
         
         document.getElementById('srepno').disabled = false;
         document.getElementById('acmno').disabled = false;
         document.getElementById('frmdt').disabled = false;         
         document.getElementById('prjlivdt').disabled = false;
         document.getElementById('todt').disabled = false;
         
         document.getElementById('cntfrmdt').disabled = false;
         document.getElementById('cnttodt').disabled = false;
         document.getElementById('extflg').disabled = false;
         document.getElementById('dellocid').disabled = false;
         document.getElementById('delvrblid').disabled = false;
         document.getElementById('wrkhrs').disabled = false;
         document.getElementById('othrs').disabled = false;
                   
       }
      
      
       if('<%= request.getAttribute("scrn") %>' === 'edt'){
           document.getElementById("scrn").value = "edt";
     //    document.getElementById("btncre").style.display = "none";
         document.getElementById("btnedt").style.display = "block";
         document.getElementById("btnget").style.display = "block";
      //   document.getElementById("btndel").style.display = "none";
         document.getElementById("btnbck").style.display = "block";
         document.getElementById("prjno").required = false;
         document.getElementById('prjdes').disabled = false;
         
         document.getElementById('bizid').disabled = false;                  
         document.getElementById('cntrtyp').disabled = false;
         document.getElementById('bpno').disabled = false;
         document.getElementById('eusrno').disabled = false;
         
         document.getElementById('srepno').disabled = false;
         document.getElementById('acmno').disabled = false;
         document.getElementById('frmdt').disabled = false;         
         document.getElementById('prjlivdt').disabled = false;
         document.getElementById('todt').disabled = false;
         
         document.getElementById('cntfrmdt').disabled = false;
         document.getElementById('cnttodt').disabled = false;
         document.getElementById('extflg').disabled = false;
         document.getElementById('dellocid').disabled = false;
         document.getElementById('delvrblid').disabled = false;
         document.getElementById('wrkhrs').disabled = false;
         document.getElementById('othrs').disabled = false;
           
       }
       
       if('<%= request.getAttribute("scrn") %>' === 'dis'){
         document.getElementById("scrn").value = "dis";
         document.getElementById("btncre").style.display = "none";
         document.getElementById("btnedt").style.display = "none";
         document.getElementById("btnget").style.display = "block";
         document.getElementById("btndel").style.display = "none";
         document.getElementById("btnbck").style.display = "block";
         document.getElementById("prjno").required = false;
         document.getElementById('prjdes').disabled = true;
         
         document.getElementById('bizid').disabled = true;                  
         document.getElementById('cntrtyp').disabled = true;
         document.getElementById('bpno').disabled = true;
         document.getElementById('eusrno').disabled = true;
         
         document.getElementById('srepno').disabled = true;
         document.getElementById('acmno').disabled = true;
         document.getElementById('frmdt').disabled = true;         
         document.getElementById('prjlivdt').disabled = true;
         document.getElementById('todt').disabled = true;
         
         document.getElementById('cntfrmdt').disabled = true;
         document.getElementById('cnttodt').disabled = true;
         document.getElementById('extflg').disabled = true;
         document.getElementById('dellocid').disabled = true;
         document.getElementById('delvrblid').disabled = true;
         document.getElementById('wrkhrs').disabled = true;
         document.getElementById('othrs').disabled = true;
         }
         
          if('<%= request.getAttribute("scrn") %>' === 'del'){
         document.getElementById("scrn").value = "del";
         document.getElementById("btncre").style.display = "none";
         document.getElementById("btnedt").style.display = "none";
         document.getElementById("btnget").style.display = "block";
         document.getElementById("btndel").style.display = "block";
         document.getElementById("btnbck").style.display = "block";
         document.getElementById("prjno").required = false;
         document.getElementById('prjdes').disabled = true;
         
         document.getElementById('bizid').disabled = true;                  
         document.getElementById('cntrtyp').disabled = true;
         document.getElementById('bpno').disabled = true;
         document.getElementById('eusrno').disabled = true;
         
         document.getElementById('srepno').disabled = true;
         document.getElementById('acmno').disabled = true;
         document.getElementById('frmdt').disabled = true;         
         document.getElementById('prjlivdt').disabled = true;
         document.getElementById('todt').disabled = true;
         
         document.getElementById('cntfrmdt').disabled = true;
         document.getElementById('cnttodt').disabled = true;
         document.getElementById('extflg').disabled = true;
         document.getElementById('dellocid').disabled = true;
         document.getElementById('delvrblid').disabled = true;
         document.getElementById('wrkhrs').disabled = true;
         document.getElementById('othrs').disabled = true;
         }
       
 </script>
 
 <script>
      function prjbutget(){
        var pjno = document.getElementById("prjno").value;
        var msttable = document.getElementById("prjtbl");
        var mstrowlen = msttable.rows.length;
          for(var z = 0;z < mstrowlen;z++){
            var delprjno = msttable.rows[z].cells[0].innerText;
            if(pjno === delprjno){
            var delactflg = msttable.rows[z].cells[18].innerText;
            }          
        }
        
      if(delactflg === 'X'){
         document.getElementById("prjno").value = "";
         document.getElementById("prjdes").value = "";
         document.getElementById("bizid").value = "";
         document.getElementById("cntrtyp").value = "";
         document.getElementById("bpno").value = "";
         document.getElementById("eusrno").value = "";
         document.getElementById("srepno").value = "";
         document.getElementById("acmno").value = "";
         document.getElementById("frmdt").value = "";
         document.getElementById("todt").value = "";
         document.getElementById("prjlivdt").value = "";
         document.getElementById("cntfrmdt").value = "";
         document.getElementById("cnttodt").value = "";
         document.getElementById("extflg").value = "";
         document.getElementById("dellocid").value = "";
         document.getElementById("delvrblid").value = "";
         document.getElementById("wrkhrs").value = "";
         document.getElementById("othrs").value = "";
         
              document.getElementById("dltd").show();
           // alert("Record " +pjno+ " Already Deleted or Deletion Flag is Set ");
          }
             else{
        
        for(var i = 0;i < mstrowlen;i++){
          var prjno1 = msttable.rows[i].cells[0].innerText;
          var prjdes = msttable.rows[i].cells[1].innerText;
          var bizid = msttable.rows[i].cells[2].innerText;
          var cntrtyp = msttable.rows[i].cells[3].innerText;
          var bpno = msttable.rows[i].cells[4].innerText;
          var eusrno = msttable.rows[i].cells[5].innerText;
          var srepno = msttable.rows[i].cells[6].innerText;
          var acmno = msttable.rows[i].cells[7].innerText;
          var frmdt = msttable.rows[i].cells[8].innerText;
          var prjlivdt= msttable.rows[i].cells[9].innerText;
          var todt = msttable.rows[i].cells[10].innerText;
          var cntfrmdt = msttable.rows[i].cells[11].innerText;
          var cnttodt = msttable.rows[i].cells[12].innerText;
          var extflg = msttable.rows[i].cells[13].innerText;
          var dellocid = msttable.rows[i].cells[14].innerText;
          var delvrblid = msttable.rows[i].cells[15].innerText;
          var wrkhrs = msttable.rows[i].cells[16].innerText;
          var othrs = msttable.rows[i].cells[17].innerText;
          var actflg = msttable.rows[i].cells[18].innerText;
          
      if(pjno === prjno1){
              
         document.getElementById("prjdes").value = prjdes;
         document.getElementById("bizid").value = bizid;
         document.getElementById("cntrtyp").value = cntrtyp;
         document.getElementById("bpno").value = bpno;
         document.getElementById("eusrno").value = eusrno;
         document.getElementById("srepno").value = srepno;
         document.getElementById("acmno").value = acmno;
         document.getElementById("frmdt").value = frmdt; 
         document.getElementById("prjlivdt").value = prjlivdt;
         document.getElementById("todt").value = todt;
         document.getElementById("cntfrmdt").value = cntfrmdt;
         document.getElementById("cnttodt").value = cnttodt;
         if(extflg === 'X'){
             document.getElementById("extflg").checked = true;
         }else{
             document.getElementById("extflg").checked = false;
         }
    //     document.getElementById("extflg").value = extflg;
         document.getElementById("dellocid").value = dellocid;
         document.getElementById("delvrblid").value = delvrblid;
         document.getElementById("wrkhrs").value = wrkhrs;
         document.getElementById("othrs").value = othrs;
  //       document.getElementById("actflg").value = actflg;
          }
         }
     }
 }
  function dltd(){
        document.getElementById("dltd").close();
    }
 </script>
  <script>
     // Get the modal
var modal = document.getElementById('modal');
//Modal open function
 function openModal() {
  modal.style.display = "block";
// document.getElementById('demo').innerHTML = document.getElementById('salesrep').value;
}
//function Dept(){
//        var a = document.getElementById("dept");
//    var rslt = a.options[a.selectedIndex].value;
//    console.log(rslt);
//    document.getElementById("salesrep").value = rslt;
//}   
 function EName(){
//     var emp = document.getElementById("ename").innerText;
//      document.getElementById("salesrep").value = emp;    
     var lis = document.getElementsByClassName("elist");
     for(var z = 0; z < lis.length; z++){
         var emp = lis[z].innerText;

     document.getElementById("srepno").value = emp;
 }
 }
//Modal text update function
function ModalUpdate() {
  modal.style.display = "none";
//  document.getElementById('salesrep').innerHTML = document.getElementById('sval').value;
}
// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
};
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target === modal) {
    modal.style.display = "none";
  }
};
 </script>
 
    </body>
</html>

