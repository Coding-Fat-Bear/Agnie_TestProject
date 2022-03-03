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
<%@page import="com.agnie.controller.Estimation" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estimation Page</title>
        <%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
        <%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
       <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.gstatic.com" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter&family=Source+Code+Pro&display=swap"/>
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
    width:990px;
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

.htablinks {
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
  /*height: 40px;*/
}

.htablinks:hover {
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
  width: 986px; 
}

.tabcontents {
  color: white;
  background-color:rgb(94 132 156);
  display: none;
  padding-bottom: 10px;
  padding-top: 50px;
  padding-left: 10px;
  height: auto;
  margin: 0;
  border-radius: 25px;
  width: 740px;
  
}
 input[type=number].no-spinner::-webkit-inner-spin-button, 
    input[type=number]::-webkit-outer-spin-button { 
    -webkit-appearance: none; 
      
}

.top li{
    display: inline-block;
 
}

.opbut li{
    display: inline-flex;
    margin-right: 0px;
}

.sald{
    display: inline-block
}
.bptbl {
    margin-left: 10px;
    transition-property: height;
    transition-duration: 2s;
}
.bptbl thead, td, th {
    border: 1px solid black;
    width: auto;
    background-color: #555;
}
.rowdeldia{
    width: 300px;
    height:80px;
    background-color:threedhighlight
    
}
.draggable {
                cursor: move;
                user-select: none;
            }
            .placeholder {
                background-color: #edf2f7;
                border: 2px dashed #cbd5e0;
            }
            .clone-list {
                border-left: 1px solid #ccc;
                border-top: 1px solid #ccc;
                display: flex;
            }
            .clone-table {
                border-collapse: collapse;
                border: none;
            }
            .clone-table th,
            .clone-table td {
                border: 1px solid #ccc;
                border-left: none;
                border-top: none;
                padding: 0.5rem;
            }
            .dragging {
                background: #fff;
                border-left: 1px solid #ccc;
                border-top: 1px solid #ccc;
                z-index: 999;
            }

</style>

    <body> 
        <header>         
            <h1 align="center"><%= request.getAttribute("ESTMS") %></h1>
        </header>
        <form method="post">
                <%
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      Connection con1 = null;
                      Statement stm = null;
                 %>
            <div class="mbar" >
      <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("ESTS") %></button>
                <div id="drpcnt" class="dropdown-content">
                    <li><button  formaction="estcre" class="menu" style="cursor: pointer" ><%= request.getAttribute("ESTCRE") %></button></li>
                    <li><button  formaction="estcha" class="menu" style="cursor: pointer" ><%= request.getAttribute("ESTEDT") %></button></li>
                    <li><button  formaction="estdis" class="menu" style="cursor: pointer" ><%= request.getAttribute("ESTDIS") %></button></li>
                    <li><button  formaction="estdel" class="menu" style="cursor: pointer" ><%= request.getAttribute("ESTDEL") %></button></li>
                    <li><button  formaction="estext" class="menu" style="cursor: pointer" ><%= request.getAttribute("ESTEXT") %></button></li>
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
                    <li><button type="submit" id="estbtncre" formaction="insertest" style="cursor: pointer;display:none;text-align:center;font-size:25px" title=Create><i class="fa fa-save"></i></button></li>
                    <li><button type="button" id="estbtnget" onclick="estbutget()" style="cursor: pointer;display:none;text-align:center;font-size:25px"  title=Get><i class="fas fa-glasses"></i></i></button></li>
                    <li><button type="submit" id="estbtnedt" formaction="updtest" style="cursor: pointer;display:none;text-align:center;font-size:25px" title=Update ><i class="fa fa-save"></i></button></li>
                    <li><button type="submit" id="estbtndel" formaction="delest" style="cursor: pointer;display:none;text-align:center;font-size:25px" title=Delete ><i class="fa fa-trash"></i></button></li>                            
                    <li><button type="submit" id="btnbck" formaction="estback" style="cursor: pointer;display:none;text-align:center;font-size:25px" title=Back><i class="fa fa-hand-o-left"></i></button></li>   
                </ul>
    
              <dialog id="rowdel" class="rowdeldia" >
                    <button type="button" id="rdclbt" onclick="clrdl();" style="float:right;">X</button>
                            <p style="margin-top:20px"><%= request.getAttribute("ASDL") %></p>
                            <button type="button" id="yesrd" onclick="yesrdl();" ><%= request.getAttribute("DIYS") %></button><button type="button" id="nord" onclick="nordl();" ><%= request.getAttribute("DINO") %></button>
                </dialog>
                <dialog id="rowselch" class="rowdeldia" >                    
                            <p style="margin-top:20px"><%= request.getAttribute("ASLRW") %></p>
                            <button type="button" id="oksld" onclick="oksldl();" >OK</button>
                </dialog>
                <dialog id="dltd" class="rowdeldia" >                    
                            <p style="margin-top:20px"> Record <%= request.getAttribute("DELFLG") %></p>
                            <button type="button" id="dltdbt" onclick="dltd();" >OK</button>
                </dialog>
        
        <ul class="top">
            <input type="text" style="width:53px;" maxlength="7" name="weblng" id="weblng" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="scrn" id="scrn" hidden>
          <li><label for="estmno" style="width:175px"><%= request.getAttribute("ESTNUM") %> </label> <input type="text" name="estmno" maxlength="9" style="width:75px" id="estmno" > </li>
          <li><label for="estmdes" style="width:175px"><%= request.getAttribute("ESTDES") %> </label> <input type="text" maxlength="30" size="30" name="estmdes" id="estmdes"></li> <br>
              <label for="estrevno" style="width:175px"><%= request.getAttribute("ESTREV") %> </label> <input type="text" name="estrevno" maxlength="3" style="width:75px" id="estrevno" > 
        </ul>
        <div class="htabs">
        <!--<button type="button" class="htablinks" id="HT1" onclick="OpenPage(this.id)">PO Header</button>-->
        <button type="button" class="htablinks" id="HT1" onclick="OpenPage(this.id)"><%= request.getAttribute("ESTINFO") %></button>
        <button type="button"  class="htablinks" id="HT2" onclick="OpenPage(this.id)"><%= request.getAttribute("ESTTRMS") %></button>
        <button type="button"  class="htablinks" id="HT3" onclick="OpenPage(this.id)"><%= request.getAttribute("ESTTXTS") %></button>
        </div>
         <div id="HT1" class="tabcontents">
           <label for="ccod"><%= request.getAttribute("CMPNY") %> </label> <input type="text" name="ccod" maxlength="4" size="4" id="ccod"> <br>  
           <label for="prjno"><%= request.getAttribute("PRJNUM") %></label> <input type="text" name="prjno" size="9" maxlength="9" id="prjno"><br>
           <label for="inqno"><%= request.getAttribute("INQNUM") %></label> <input type="text" name="inqno" maxlength="7" size="7" id="inqno" ><br>  
           <label for="frmdt"><%= request.getAttribute("ESTSTDT") %></label> <input type="date" name="frmdt" style="width: 135px;text-transform:uppercase" id="frmdt" ><br>
           <label for="todt"><%= request.getAttribute("ESTENDT") %></label> <input type="date" name="todt" style="width: 135px;text-transform:uppercase" id="todt" ><br>
         </div>
        <div id="HT2" class="tabcontents"> 
  <!--<h3> Estimation Data</h3>-->
  <ul>
            <label for="curr">Currency</label> <!-- <input type="text" name="curr" id="curr" size="4"> <br> -->
            <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="curr" name="curr">
            <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Currency";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("CURID")%>"><%=rs2.getString("CURTXT")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
            </select> <br>
            <label for="taxcode"><%= request.getAttribute("TAX") %></label> <!--<input type="text" name="taxcode" id="taxcode" size="4"> <br> -->
            <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="taxcode" name="taxcode" onblur="calc()" >
            <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Tax_Codes";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("TAX")%>"><%=rs2.getString("TAXCODE")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
            </select> <br>
            <label for="discount"><%= request.getAttribute("DISCNT") %></label> <input type="text" name="discount" id="discount" size="10" onblur="calc()"> <br>           
            <label for="delloc"><%= request.getAttribute("DELLOC") %> </label> <!-- <input type="text" name="dellocid" maxlength="20" size="20" id="dellocid" ><br> -->
             <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="delloc" name="delloc" >
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
            <label for="delvrbls"><%= request.getAttribute("DELVBLS") %>  </label> <!-- <input type="text" name="delvrblid" maxlength="20" size="20" id="delvrblid" ><br> -->
             <select maxlength="2" style="width:120px;text-transform:uppercase" type="text" id="delvrbls" name="delvrbls" >
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
     </ul>
</div>
          <div id="HT3" class="tabcontents">
    <!--<h3>Estimation texts</h3>-->
     <ul>
      <label for="estmtxt1"><%= request.getAttribute("ESTXT1") %>  </label> <!-- <input type="text" name="estmtxt1" id="estmtxt1" ><br> -->
      <textarea class="form-control rounded-0" id="estmtxt1" name="estmtxt1" rows="1"></textarea> <br>
      <label for="estmtxt2"><%= request.getAttribute("ESTXT2") %> </label> <!-- <input type="text" name="estmtxt2" id="estmtxt2" ><br> -->
      <textarea class="form-control rounded-0" id="estmtxt2" name="estmtxt2" rows="2"></textarea> <br>
      <label for="estmtxt3"><%= request.getAttribute("ESTXT3") %> </label> <!-- <input type="text" name="estmtxt3" id="estmtxt3" ><br> -->
      <textarea class="form-control rounded-0" id="estmtxt3" name="estmtxt3" rows="3"></textarea> <br>
     </ul>

</div>
            <br>
    <!--- Estimation Item Details Tabs -->
        <div class="tabs">
        <button type="button" class="tablink" id="T1" onclick="openPage(this.id)"><%= request.getAttribute("CNSLTNTS") %> </button>
        <!--<button type="button" class="tablink" id="T2" onclick="openPage(this.id)"><%= request.getAttribute("ESTINFO") %> </button>-->
        <!--<button type="button"  class="tablink" id="T3" onclick="openPage(this.id)"><%= request.getAttribute("ESTTRMS") %> </button>-->
        <!--<button type="button" class="tablink" id="T4" onclick="openPage(this.id)"><%= request.getAttribute("ESTTXTS") %> </button>-->
        </div>
<div id="T1" class="tabcontent">
  <!--<h3> Consultants</h3>-->
  <ul>
            <button type="button" onclick="addRows();"><i class="fa fa-plus-square"></i></button>
            <button type="button" onclick="deleteRows();"><i class="fa fa-minus-square"></i></button>
         <table style="height: 255px;display:block;overflow-x: scroll;width: 975px;" id="bptbl" name="bptbl" class="bptbl">
             <thead style="position: sticky;top: 0">
            <tr>
              <th></th>  
              <th><%= request.getAttribute("ESTITM") %></th> 
              <th><%= request.getAttribute("CNSLTID") %></th>
              <th><%= request.getAttribute("CNSLTNAM") %></th>
              <th><%= request.getAttribute("UNT") %></th>
              <th><%= request.getAttribute("QUAN") %></th>
              <th><%= request.getAttribute("RAT") %></th>
              <th><%= request.getAttribute("TOT") %></th> 
              <!--<th>Delete</th>-->
            </tr>                             
             </thead>
             <tbody style="overflow-y: scroll">
            <tr>
                <td id="col0"><input class="check" type="checkbox" onclick="selectedRow()" id="check" name="check" size="4"></td>
                <td id="col1"><input class="estmitem" type="text" id="estmitem" name="estmitem" size="9" value="1"  ></td>
                <td id="col2"><input class="bpid" type="text" id="bpid" name="bpid" size="12" ></td>
                <td id="col3"><input class="bpname" type="text" id="bpname" name="bpname" size="25" ></td>
                <td id="col4"><select maxlength="4" style="width:120px;text-transform:uppercase" class="unit" type="text" id="unit" name="unit" style="width:80px;" >
                 <option value=""></option>
                  <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Unit";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("UNIT")%>"><%=rs2.getString("UNITTXT")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
                </select>     
                </td>
                <td id="col5"><input class="qty" type="text" id="qty" name="qty" size="15" onblur="calc()" ></td>            
                <td id="col6"><input class="rate" type="text" id="rate" name="rate" size="15" onblur="calc()" ></td>              
                <td id="col7"><input class="total" type="text" id="total" name="total" size="15" ></td>
                <!--<td>Remove</td>-->
            </tr>
            </tbody>
         </table> <br>
           <label for="estmamt"><%= request.getAttribute("ESTAMT") %></label> <input type="text" name="estmamt" id="estmamt" size="12"> <br>
      </ul>  
</div>
<!--  <div id="T2" class="tabcontent">
<h3> Estimation Data</h3>
<ul>
         <label for="ccod"><%= request.getAttribute("CMPNY") %> </label> <input type="text" name="ccod" maxlength="4" size="4" id="ccod"> <br>
         <label for="bizid">Business Line </label> 
         <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="bizid" name="bizid" onchange="Project()" >
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
            </select>
            <label for="cntrtyp">Contract Type </label> 
            <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="cntrtyp" name="cntrtyp" onchange="Project()" >
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
              <label for="prjno">Project No </label> 
             <select maxlength="10" style="width:120px;text-transform:uppercase" type="text" id="prjno" name="prjno" >
            <option value=""></option>
              <%
//                String CNT = request.getParameter("CNTRTYP");
//                String BIZ = request.getParameter("BIZID");
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Project_Master where BIZID = '01' AND CNTRTYP = 'CT2'";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("PRJDES")%>"><%=rs2.getString("PRJNO")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
            </select> <br>
         <label for="prjno"><%= request.getAttribute("PRJNUM") %></label> <input type="text" name="prjno" size="9" maxlength="9" id="prjno"><br>
         <label for="inqno"><%= request.getAttribute("INQNUM") %></label> <input type="text" name="inqno" maxlength="7" size="7" id="inqno" ><br>
         <label style="width:600px"> **Project & Inquiry No's will fetch based on Business Line and Contract Types**</label>
         <label for="estmamt"><%= request.getAttribute("ESTAMT") %></label> <input type="text" name="estmamt" id="estmamt" size="12"> <br>
         </ul>  
</div>

<div id="T3" class="tabcontent"> 
  <h3> Estimation Data</h3>
  <ul>
            <label for="curr"><%= request.getAttribute("CRNCY") %></label> <input type="text" name="curr" id="curr" size="4"> <br>
            <label for="taxcode"><%= request.getAttribute("TAX") %></label> <input type="text" name="taxcode" id="taxcode" size="4"> <br> 
            <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="taxcode" name="taxcode" onblur="calc()" >
            <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Tax_Codes";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("TAX")%>"><%=rs2.getString("TAXCODE")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
            </select> <br>
            <label for="discount"><%= request.getAttribute("DISCNT") %></label> <input type="text" name="discount" id="discount" size="10" onblur="calc()"> <br>
            <label for="frmdt"><%= request.getAttribute("ESTSTDT") %></label> <input type="date" name="frmdt" style="width: 135px;text-transform:uppercase" id="frmdt" ><br>
            <label for="todt"><%= request.getAttribute("ESTENDT") %></label> <input type="date" name="todt" style="width: 135px;text-transform:uppercase" id="todt" ><br>
            <label for="delloc"><%= request.getAttribute("DELLOC") %> </label>  <input type="text" name="dellocid" maxlength="20" size="20" id="dellocid" ><br> 
             <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="delloc" name="delloc" >
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
            <label for="delvrbls"><%= request.getAttribute("DELVBLS") %>  </label>  <input type="text" name="delvrblid" maxlength="20" size="20" id="delvrblid" ><br> 
             <select maxlength="2" style="width:120px;text-transform:uppercase" type="text" id="delvrbls" name="delvrbls" >
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
     </ul>
</div>

<div id="T4" class="tabcontent">
    <h3>Estimation texts</h3>
     <ul>
      <label for="estmtxt1"><%= request.getAttribute("ESTXT1") %>  </label>  <input type="text" name="estmtxt1" id="estmtxt1" ><br> 
      <textarea class="form-control rounded-0" id="estmtxt1" name="estmtxt1" rows="1"></textarea> <br>
      <label for="estmtxt2"><%= request.getAttribute("ESTXT2") %> </label>  <input type="text" name="estmtxt2" id="estmtxt2" ><br> 
      <textarea class="form-control rounded-0" id="estmtxt2" name="estmtxt2" rows="2"></textarea> <br>
      <label for="estmtxt3"><%= request.getAttribute("ESTXT3") %> </label>  <input type="text" name="estmtxt3" id="estmtxt3" ><br> 
      <textarea class="form-control rounded-0" id="estmtxt3" name="estmtxt3" rows="3"></textarea> <br>
     </ul>

</div>-->
    <!--</form>-->
    
     <!--List Table Data for Get Operation-->
     <table style="display:none;overflow-x: auto" id="estmtbl" name="estmtbl" class="estmtbl">
            
           <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String sqlmst = "SELECT * FROM Estimation_Master";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(sqlmst);
                      while(rs2.next())
                      {
                          %>
               <tr>
               <td><%=rs2.getString("ESTMNO") %></td> <!--0-->
               <td><%=rs2.getString("ESTMDES") %></td>   <!--1-->
               <td><%=rs2.getString("ESTREVNO") %></td> <!--2-->
               <td><%=rs2.getString("CCOD") %></td>  <!--3-->
               <td><%=rs2.getString("PRJNO") %></td>  <!--4-->
               <td><%=rs2.getString("INQNO") %></td>  <!--5-->
               <td><%=rs2.getString("CURR") %></td>  <!--6-->
               <td><%=rs2.getString("TAXCODE") %></td>  <!--7-->
               <td><%=rs2.getString("DISCOUNT") %></td>  <!--8-->
               <td><%=rs2.getString("FRMDT") %></td>   <!--9-->
               <td><%=rs2.getString("TODT") %></td>   <!--10-->
               <td><%=rs2.getString("DELLOC") %></td>  <!--11-->
               <td><%=rs2.getString("DELVRBLS") %></td>  <!--12-->
               <td><%=rs2.getString("ESTMAMT") %></td>  <!--13-->
               <td><%=rs2.getString("ESTMTXT1") %></td>  <!--14-->
               <td><%=rs2.getString("ESTMTXT2") %></td>  <!--15-->
               <td><%=rs2.getString("ESTMTXT3") %></td>  <!--16-->
               <td><%=rs2.getString("DELFLG") %></td>  <!--17-->
               
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
                  
            <table style="display:none;overflow-x: auto" id="eitmtbl" name="eitmtbl" class="eitmtbl">
            
           <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String sqlitm = "SELECT * FROM Estimation_Items";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs3 = stm.executeQuery(sqlitm);
                      while(rs3.next())
                      {
                          %>
               <tr>
               <td><%=rs3.getString("ESTMNO") %></td> <!--0-->
               <td><%=rs3.getString("ESTMITEM") %></td>   <!--1-->
               <td><%=rs3.getString("BPID") %></td> <!--2-->
               <td><%=rs3.getString("BPNAME") %></td>  <!--3-->
               <td><%=rs3.getString("UNIT") %></td>  <!--4-->
               <td><%=rs3.getString("QTY") %></td>  <!--5-->
               <td><%=rs3.getString("RATE") %></td>  <!--6-->
               
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
    document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
  //  document.getElementById("emnum").value = '<%= request.getAttribute("emnum") %>';
    document.getElementById("scrn").value = '<%= request.getAttribute("scrn") %>';
</script>          
    <script>
      for(var k = 1; k < 7; k++){
        var tabbp = document.getElementById("bptbl");
        var rowcount = tabbp.rows.length;
        var prvcol = rowcount - 1;
        var newrowcount = rowcount + 1;
        var cellcount = tabbp.rows[0].cells.length;
        var adrow = tabbp.insertRow(rowcount);
        for(var i =0;i < cellcount;i++){
            var cell = 'cell'+i;
            cell = adrow.insertCell(i);
            var incell = document.getElementById("col"+i).innerHTML;            
            cell.innerHTML=incell;
            
        }       
        document.getElementsByClassName("estmitem")[prvcol].value = rowcount;
        document.getElementsByClassName("check")[prvcol].value = rowcount;
    }
  </script>
          
  <script>
//              for BP Consultants Table
      function addRows(){
        var tabbp = document.getElementById("bptbl");
        var rowcount = tabbp.rows.length;
        var prvcol = rowcount - 1;
        var newrowcount = rowcount + 1;
        var cellcount = tabbp.rows[0].cells.length;
        var adrow = tabbp.insertRow(rowcount);
        for(var i =0;i < cellcount;i++){
            var cell = 'cell'+i;
            cell = adrow.insertCell(i);
            var incell = document.getElementById("col"+i).innerHTML;            
            cell.innerHTML=incell;
            
        }       
        document.getElementsByClassName("estmitem")[prvcol].value = rowcount;
        document.getElementsByClassName("bpid")[prvcol].focus();
            }
  </script>      

 <script>
              // Calculate Estimation Amount
              function calc(){
                    var ctbl = document.getElementsByClassName('estmitem');
                    var row = ctbl.length;
                    var q,r,tot,sum = 0;
                    var d = document.getElementById('discount').value;
                    var t = document.getElementById('taxcode').value;
                     for (var i = 0; i < row; i++) {
                   q = document.getElementsByClassName('qty')[i].value;
                   r = document.getElementsByClassName('rate')[i].value;
                  tot = (q*r);                 
                  document.getElementsByClassName('total')[i].value = tot;  
                  sum = sum + tot;
            }              
                  var tot1 = sum-d;
                  var tx = tot1*(t/100);
                  var est = tot1+tx;
                  document.getElementById('estmamt').value = est;                   
              }
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
</script>
<script>
 var htab = 0;
 var htab1 = "HT1";
function OpenPage(clicked_id) {
//var basdt1 ;
  var h, tabcontent, htabid;
  tabcontent = document.getElementsByClassName("tabcontents");
  
  for (h = 0; h < tabcontent.length; h++) {
  htabid = tabcontent[h].id;
  
	if(htabid === clicked_id){
	tabcontent[htab].style.display = "none";
	document.getElementById(htab1).style.backgroundColor = "#555";
        tabcontent[h].style.display = "block";
	tabcontent[h].style.backgroundColor = "rgb(94 132 156)";
	document.getElementById(clicked_id).style.backgroundColor = "rgb(94 132 156)";
	htab = h;
	htab1 = clicked_id;
	break;
	}
	
  }
 
}
document.getElementById("HT1").click();
</script>

<!--            <script>
                function Project(){
                var selectBox = document.getElementById("bizid");
                var selectBox2 = document.getElementById("cntrtyp");
                var selectedValue = selectBox.options[selectBox.selectedIndex].value;
                var selectedValue2 = selectBox2.options[selectBox2.selectedIndex].value;
                document.getElementById("biz").value = selectedValue;
                document.getElementById("ctyp").value = selectedValue2;
                console.log(selectedValue,selectedValue2);
            }
            </script>-->
  
 
  <script>     
       if('<%= request.getAttribute("scrn") %>' === 'cre'){
           var x = '01';
         document.getElementById("estrevno").value = x;
         document.getElementById("scrn").value = "cre";
         document.getElementById("estbtncre").style.display = "block";
         document.getElementById("estbtnedt").style.display = "none";
         document.getElementById("estbtnget").style.display = "none";
         document.getElementById("estbtndel").style.display = "none";
         document.getElementById("btnbck").style.display = "block";
         document.getElementById("estmno").required = false;
         document.getElementById('estmdes').disabled = false;         
         document.getElementById('estrevno').disabled = true;                   
         document.getElementById('ccod').disabled = false;
         document.getElementById('prjno').disabled = false;        
         document.getElementById('taxcode').disabled = false;
         document.getElementById('discount').disabled = false;
         document.getElementById('frmdt').disabled = false;
         document.getElementById('todt').disabled = false;
         document.getElementById('delloc').disabled = false;
         document.getElementById('delvrbls').disabled = false;
         document.getElementById('estmamt').disabled = false;
         document.getElementById('estmtxt1').disabled = false;
         document.getElementById('estmtxt2').disabled = false;
         document.getElementById('estmtxt3').disabled = false;
         
         var dlen = document.getElementsByClassName("estmitem").length;
         for(var d = 0; d < dlen; d++){
            document.getElementsByClassName("estmitem")[d].disabled = false;
            document.getElementsByClassName("bpid")[d].disabled = false;
            document.getElementsByClassName("bpname")[d].disabled = false;
            document.getElementsByClassName("unit")[d].disabled = false;
            document.getElementsByClassName("qty")[d].disabled = false; 
            document.getElementsByClassName("rate")[d].disabled = false;
            document.getElementsByClassName("total")[d].disabled = false;
         }
                   
       }
      
      
       if('<%= request.getAttribute("scrn") %>' === 'edt'){
//           var x = '02';
//         document.getElementById("estrevno").value = x;
         document.getElementById("scrn").value = "edt";
         document.getElementById("estbtnedt").style.display = "block";
         document.getElementById("estbtnget").style.display = "block";
         document.getElementById("estbtndel").style.display = "none";
         document.getElementById("estbtncre").style.display = "none";
         document.getElementById("btnbck").style.display = "block";
         document.getElementById("estmno").required = false;
         document.getElementById('estmdes').disabled = false;        
         document.getElementById('estrevno').disabled = true;                  
         document.getElementById('ccod').disabled = false;
         document.getElementById('prjno').disabled = false;
         document.getElementById('curr').disabled = false;
         document.getElementById('total').disabled = false;
         document.getElementById('taxcode').disabled = false;
         document.getElementById('discount').disabled = false;
         document.getElementById('frmdt').disabled = false;
         document.getElementById('todt').disabled = false;
         document.getElementById('delloc').disabled = false;
         document.getElementById('delvrbls').disabled = false;
         document.getElementById('estmamt').disabled = false;
         document.getElementById('estmtxt1').disabled = false;
         document.getElementById('estmtxt2').disabled = false;
         document.getElementById('estmtxt3').disabled = false;
         
       var dlen = document.getElementsByClassName("estmitem").length;
         for(var d = 0; d < dlen; d++){
            document.getElementsByClassName("check")[d].disabled = false; 
            document.getElementsByClassName("estmitem")[d].disabled = false;
            document.getElementsByClassName("bpid")[d].disabled = false;
            document.getElementsByClassName("bpname")[d].disabled = false;
            document.getElementsByClassName("unit")[d].disabled = false;
            document.getElementsByClassName("qty")[d].disabled = false; 
            document.getElementsByClassName("rate")[d].disabled = false;
            document.getElementsByClassName("total")[d].disabled = false;
         }
           
       }
       
       if('<%= request.getAttribute("scrn") %>' === 'dis'){
         document.getElementById("scrn").value = "dis";
         document.getElementById("estbtnget").style.display = "block";
         document.getElementById("estbtncre").style.display = "none";
         document.getElementById("estbtnedt").style.display = "none";
         document.getElementById("estbtndel").style.display = "none";
         document.getElementById("btnbck").style.display = "block";
         document.getElementById("estmno").required = false;
         document.getElementById('estmdes').disabled = true;        
         document.getElementById('estrevno').disabled = true;                  
         document.getElementById('ccod').disabled = true;
         document.getElementById('prjno').disabled = true;
         document.getElementById('inqno').disabled = true;
         document.getElementById('curr').disabled = true;
         document.getElementById('total').disabled = true;
         document.getElementById('taxcode').disabled = true;
         document.getElementById('discount').disabled = true;
         document.getElementById('frmdt').disabled = true;
         document.getElementById('todt').disabled = true;
         document.getElementById('delloc').disabled = true;
         document.getElementById('delvrbls').disabled = true;
         document.getElementById('estmamt').disabled = true;
         document.getElementById('estmtxt1').disabled = true;
         document.getElementById('estmtxt2').disabled = true;
         document.getElementById('estmtxt3').disabled = true;
         
     var slen = document.getElementsByClassName("estmitem").length;
         for(var s = 0; s < slen; s++){
            document.getElementsByClassName("check")[s].disabled = true; 
            document.getElementsByClassName("estmitem")[s].disabled = true;
            document.getElementsByClassName("bpid")[s].disabled = true;
            document.getElementsByClassName("bpname")[s].disabled = true;
            document.getElementsByClassName("unit")[s].disabled = true;
            document.getElementsByClassName("qty")[s].disabled = true; 
            document.getElementsByClassName("rate")[s].disabled = true;
            document.getElementsByClassName("total")[s].disabled = true;
         }
         
         }
         
        if('<%= request.getAttribute("scrn") %>' === 'del'){
         document.getElementById("scrn").value = "del";
         document.getElementById("estbtnget").style.display = "block";
         document.getElementById("estbtncre").style.display = "none";
         document.getElementById("estbtnedt").style.display = "none";
         document.getElementById("estbtndel").style.display = "block";
         document.getElementById("btnbck").style.display = "block";
         document.getElementById("estmno").required = false;
         document.getElementById('estmdes').disabled = true;        
         document.getElementById('estrevno').disabled = true;                  
         document.getElementById('ccod').disabled = true;
         document.getElementById('prjno').disabled = true;
         document.getElementById('inqno').disabled = true;
         document.getElementById('curr').disabled = true;
         document.getElementById('taxcode').disabled = true;
         document.getElementById('discount').disabled = true;
         document.getElementById('frmdt').disabled = true;
         document.getElementById('todt').disabled = true;
         document.getElementById('delloc').disabled = true;
         document.getElementById('delvrbls').disabled = true;
         document.getElementById('estmamt').disabled = true;
         document.getElementById('estmtxt1').disabled = true;
         document.getElementById('estmtxt2').disabled = true;
         document.getElementById('estmtxt3').disabled = true;
         
     var slen = document.getElementsByClassName("estmitem").length;
         for(var s = 0; s < slen; s++){
            document.getElementsByClassName("check")[s].disabled = true; 
            document.getElementsByClassName("estmitem")[s].disabled = true;
            document.getElementsByClassName("bpid")[s].disabled = true;
            document.getElementsByClassName("bpname")[s].disabled = true;
            document.getElementsByClassName("unit")[s].disabled = true;
            document.getElementsByClassName("qty")[s].disabled = true; 
            document.getElementsByClassName("rate")[s].disabled = true;
            document.getElementsByClassName("total")[s].disabled = true;
         }
         
         } 
                
 </script>
   
<script>
   function estbutget(){
        var estno = document.getElementById("estmno").value;
        var msttable = document.getElementById("estmtbl");
        var itmtable = document.getElementById("eitmtbl");
        var bpTable = document.getElementById("bptbl");
        var bprowlen = bpTable.rows.length;
        var mstrowlen = msttable.rows.length;
        var col1len = document.getElementsByClassName("estmitem").length;
        var colrow = col1len - 1;
        var revno = 0;
          for(var z = 0;z < mstrowlen;z++){
            var delestno = msttable.rows[z].cells[0].innerText;
            if(estno === delestno){
            var delactflg = msttable.rows[z].cells[17].innerText;
            }          
        }
        
      if(delactflg === 'X'){
          //  alert("Record " +estno+ " Already Deleted or Deletion Flag is Set ");
         document.getElementById("estmno").value = "";
         document.getElementById("estrevno").value = "";
         document.getElementById("estmdes").value = "";
         document.getElementById("ccod").value = "";
         document.getElementById("prjno").value = "";
         document.getElementById("inqno").value = "";
         document.getElementById("curr").value = "";
         document.getElementById("taxcode").value = "";
         document.getElementById("discount").value = "";
         document.getElementById("frmdt").value = "";
         document.getElementById("todt").value = "";
         document.getElementById("delloc").value = "";
         document.getElementById("delvrbls").value = "";
         document.getElementById("estmamt").value = "";
         document.getElementById("estmtxt1").value = "";
         document.getElementById("estmtxt2").value = "";
         document.getElementById("estmtxt3").value = "";
         
         var slen = document.getElementsByClassName("estmitem").length;
         
         for(var s = 0;s < slen;s++){
            document.getElementsByClassName("check")[s].value = "";
         //   document.getElementsByClassName("estmitem")[s].value = "";
            document.getElementsByClassName("bpid")[s].value = "";
            document.getElementsByClassName("bpname")[s].value = "";
            document.getElementsByClassName("unit")[s].value = "";
            document.getElementsByClassName("qty")[s].value = "";
            document.getElementsByClassName("rate")[s].value = "";
            document.getElementsByClassName("total")[s].value = "";
         }
         
            document.getElementById("dltd").show();
          }
             else{
        
        for(var i = 0;i < mstrowlen;i++){
          var estmno1 = msttable.rows[i].cells[0].innerText;
          var estmdes = msttable.rows[i].cells[1].innerText;
          var estrevno = msttable.rows[i].cells[2].innerText;
          var ccod = msttable.rows[i].cells[3].innerText;
          var prjno = msttable.rows[i].cells[4].innerText;
          var inqno = msttable.rows[i].cells[5].innerText;
          var curr = msttable.rows[i].cells[6].innerText;
          var taxcode = msttable.rows[i].cells[7].innerText;
          var discount = msttable.rows[i].cells[8].innerText;
          var frmdt= msttable.rows[i].cells[9].innerText;
          var todt = msttable.rows[i].cells[10].innerText;
          var delloc = msttable.rows[i].cells[11].innerText;
          var delvrbls = msttable.rows[i].cells[12].innerText;
          var estmamt = msttable.rows[i].cells[13].innerText;
          var estmtxt1 = msttable.rows[i].cells[14].innerText;
          var estmtxt2 = msttable.rows[i].cells[15].innerText;
          var estmtxt3 = msttable.rows[i].cells[16].innerText;
          var delflg = msttable.rows[i].cells[17].innerText;
          if(estno === estmno1){
              
              revno = Number(estrevno) + 1; 
         document.getElementById("ccod").value = ccod;
         document.getElementById("estmdes").value = estmdes;
         document.getElementById("estrevno").value = "0" + revno;
         document.getElementById("prjno").value = prjno;
         document.getElementById("inqno").value = inqno;
         document.getElementById("curr").value = curr;
         document.getElementById("taxcode").value = taxcode;
         document.getElementById("discount").value = discount; 
         document.getElementById("frmdt").value = frmdt;
         document.getElementById("todt").value = todt;
         document.getElementById("delloc").value = delloc;
         document.getElementById("delvrbls").value = delvrbls;
         document.getElementById("estmamt").value = estmamt;
         document.getElementById("estmtxt1").value = estmtxt1;
         document.getElementById("estmtxt2").value = estmtxt2;
         document.getElementById("estmtxt3").value = estmtxt3;
        // document.getElementById("delflg").value = delflg;
          }
         }
          
    
        
        var itmrowlen = itmtable.rows.length;
	var count = 0;	          
        for(var j = 0; j < itmrowlen;j++){
            
         var estmno2 = itmtable.rows[j].cells[0].innerText;
         var estmitem = itmtable.rows[j].cells[1].innerText;
          var bpid = itmtable.rows[j].cells[2].innerText;
          var bpname = itmtable.rows[j].cells[3].innerText;
          var unit = itmtable.rows[j].cells[4].innerText;
          var qty = itmtable.rows[j].cells[5].innerText;
          var rate = itmtable.rows[j].cells[6].innerText;  
      //    var total = itmtable.rows[j].cells[6].innerText; 
                if(count > colrow){
                    var tabbp = document.getElementById("bptbl");
                        var rowcount = tabbp.rows.length;
                        var prvcol = rowcount - 1;
                        var newrowcount = rowcount + 1;
                        var cellcount = tabbp.rows[0].cells.length;
                        var adrow = tabbp.insertRow(rowcount);
                        for(var i =0;i < cellcount;i++){
                            var cell = 'cell'+i;
                            cell = adrow.insertCell(i);
                            var incell = document.getElementById("col"+i).innerHTML;            
                            cell.innerHTML=incell;

                        }       
                       document.getElementsByClassName("estmitem")[prvcol].value = rowcount;
                       document.getElementsByClassName("check")[prvcol].value = rowcount;
                    }
                                 
                  if(estno === estmno2){
                //      document.getElementsByClassName("estmitem")[count].value = estmitem;
                      document.getElementsByClassName("bpid")[count].value = bpid;
                      document.getElementsByClassName("bpname")[count].value = bpname;
                      document.getElementsByClassName("unit")[count].value = unit;
                      document.getElementsByClassName("qty")[count].value = qty;
                      document.getElementsByClassName("rate")[count].value = rate;
                //      document.getElementsByClassName("total")[count].value = total;
                      count = count + 1;
                  }                                                               
        }

            for(var count1 = count + 1;count1 < col1len;count1++){
       //    document.getElementsByClassName("estmitem")[count].value = "";
            document.getElementsByClassName("bpid")[count].value = "";
            document.getElementsByClassName("bpname")[count].value = "";
            document.getElementsByClassName("unit")[count].value = "";
            document.getElementsByClassName("qty")[count].value = "";
            document.getElementsByClassName("rate")[count].value = "";
        //    document.getElementsByClassName("total")[count].value = "";
           
        }
            }
    }
</script>  

 <script>
            
            function selectedRow(){
                
               var tbl = document.getElementById("bptbl").getElementsByTagName("tr");
               var cblen = document.getElementsByClassName("check").length;
               var actlen = cblen - 1;
               var x = 0;
               for(var i = 0; i < cblen; i++ ){
                   x = i+1;
                   if(document.getElementsByClassName("check")[i].checked === true){
                       tbl[x].getElementsByTagName("td")[0].style.backgroundColor = "red";
                       tbl[x].getElementsByTagName("td")[1].style.backgroundColor = "red";
                       tbl[x].getElementsByTagName("td")[2].style.backgroundColor = "red";
                       tbl[x].getElementsByTagName("td")[3].style.backgroundColor = "red";
                       tbl[x].getElementsByTagName("td")[4].style.backgroundColor = "red";
                       tbl[x].getElementsByTagName("td")[5].style.backgroundColor = "red";
                       tbl[x].getElementsByTagName("td")[6].style.backgroundColor = "red";
                       tbl[x].getElementsByTagName("td")[7].style.backgroundColor = "red";
                   }else{
                       tbl[x].getElementsByTagName("td")[0].style.backgroundColor = "#555";
                       tbl[x].getElementsByTagName("td")[1].style.backgroundColor = "#555";
                       tbl[x].getElementsByTagName("td")[2].style.backgroundColor = "#555";
                       tbl[x].getElementsByTagName("td")[3].style.backgroundColor = "#555";
                       tbl[x].getElementsByTagName("td")[4].style.backgroundColor = "#555";
                       tbl[x].getElementsByTagName("td")[5].style.backgroundColor = "#555";
                       tbl[x].getElementsByTagName("td")[6].style.backgroundColor = "#555";
                       tbl[x].getElementsByTagName("td")[7].style.backgroundColor = "#555";
                   }
               }
                
            }
        </script>

  <script>
        function deleteRows(){
	      var totchklen = document.getElementsByClassName("check").length;
              var chlen = totchklen - 1;
              var selch = 0;
              for(var g = 0;g < chlen;g++){           
               if(document.getElementsByClassName("check")[g].checked === true){
                selch = selch + 1;
            }           
        }
        
        if(selch > 0){
        document.getElementById("rowdel").show(); 
       }else{
            document.getElementById("rowselch").show();
        }
   }
   
     function yesrdl(){
        
        var totchklen = document.getElementsByClassName("check").length;
        var chlen = totchklen - 1;
        var selch = 0;
        for(var g = 0;g < chlen;g++){
            if(document.getElementsByClassName("check")[g].checked === true){
                selch = selch + 1;
            }
            
        }
        
        
            for(var l = 0;l < chlen;l++){
            
            if(document.getElementsByClassName("check")[l].checked === true){
                
                document.getElementById("bptbl").deleteRow(l + 1);
                var lopchlen = document.getElementsByClassName("check").length;
                chlen = lopchlen;
                l = l - 1;
                
            }
            
        }
        
     var reitmno = document.getElementsByClassName("estmitem").length;
       var m = 0;
       for(var n = 0;n < reitmno;n++){
           m = n + 1;
           document.getElementsByClassName("estmitem")[n].value = m;
       }
        document.getElementById("rowdel").close();
        
    }
    
    
      function nordl(){
        
        document.getElementById("rowdel").close();
        
    }
    
    function clrdl(){
        document.getElementById("rowdel").close();
    }
    function oksldl(){
        document.getElementById("rowselch").close();
    }
    
    function dltd(){
        document.getElementById("dltd").close();
    }
 </script> 
  <script>
            document.addEventListener('DOMContentLoaded', function () {
                const table = document.getElementById('bptbl');

                let draggingEle;
                let draggingColumnIndex;
                let placeholder;
                let list;
                let isDraggingStarted = false;

                // The current position of mouse relative to the dragging element
                let x = 0;
                let y = 0;

                // Swap two nodes
                const swap = function (nodeA, nodeB) {
                    const parentA = nodeA.parentNode;
                    const siblingA = nodeA.nextSibling === nodeB ? nodeA : nodeA.nextSibling;

                    // Move `nodeA` to before the `nodeB`
                    nodeB.parentNode.insertBefore(nodeA, nodeB);

                    // Move `nodeB` to before the sibling of `nodeA`
                    parentA.insertBefore(nodeB, siblingA);
                };

                // Check if `nodeA` is on the left of `nodeB`
                const isOnLeft = function (nodeA, nodeB) {
                    // Get the bounding rectangle of nodes
                    const rectA = nodeA.getBoundingClientRect();
                    const rectB = nodeB.getBoundingClientRect();

                    return rectA.left + rectA.width / 2 < rectB.left + rectB.width / 2;
                };

                const cloneTable = function () {
                    const rect = table.getBoundingClientRect();

                    list = document.createElement('div');
                    list.classList.add('clone-list');
                    list.style.position = 'absolute';
                    list.style.left = `${rect.left}px`;
                    list.style.top = `${rect.top}px`;
                    table.parentNode.insertBefore(list, table);

                    // Hide the original table
                    table.style.visibility = 'hidden';

                    // Get all cells
                    const originalCells = [].slice.call(table.querySelectorAll('tbody td'));

                    const originalHeaderCells = [].slice.call(table.querySelectorAll('th'));
                    const numColumns = originalHeaderCells.length;

                    // Loop through the header cells
                    originalHeaderCells.forEach(function (headerCell, headerIndex) {
                        const width = parseInt(window.getComputedStyle(headerCell).width);

                        // Create a new table from given row
                        const item = document.createElement('div');
                        item.classList.add('draggable');

                        const newTable = document.createElement('table');
                        newTable.setAttribute('class', 'clone-table');
                        newTable.style.width = `${width}px`;

                        // Header
                        const th = headerCell.cloneNode(true);
                        let newRow = document.createElement('tr');
                        newRow.appendChild(th);
                        newTable.appendChild(newRow);

                        const cells = originalCells.filter(function (c, idx) {
                            return (idx - headerIndex) % numColumns === 0;
                        });
                        cells.forEach(function (cell) {
                            const newCell = cell.cloneNode(true);
                            newCell.style.width = `${width}px`;
                            newRow = document.createElement('tr');
                            newRow.appendChild(newCell);
                            newTable.appendChild(newRow);
                        });

                        item.appendChild(newTable);
                        list.appendChild(item);
                    });
                };

                const mouseDownHandler = function (e) {
                    draggingColumnIndex = [].slice.call(table.querySelectorAll('th')).indexOf(e.target);

                    // Determine the mouse position
                    x = e.clientX - e.target.offsetLeft;
                    y = e.clientY - e.target.offsetTop;

                    // Attach the listeners to `document`
                    document.addEventListener('mousemove', mouseMoveHandler);
                    document.addEventListener('mouseup', mouseUpHandler);
                };

                const mouseMoveHandler = function (e) {
                    if (!isDraggingStarted) {
                        isDraggingStarted = true;

                        cloneTable();

                        draggingEle = [].slice.call(list.children)[draggingColumnIndex];
                        draggingEle.classList.add('dragging');

                        // Let the placeholder take the height of dragging element
                        // So the next element won't move to the left or right
                        // to fill the dragging element space
                        placeholder = document.createElement('div');
                        placeholder.classList.add('placeholder');
                        draggingEle.parentNode.insertBefore(placeholder, draggingEle.nextSibling);
                        placeholder.style.width = `${draggingEle.offsetWidth}px`;
                    }

                    // Set position for dragging element
                    draggingEle.style.position = 'absolute';
                    draggingEle.style.top = `${draggingEle.offsetTop + e.clientY - y}px`;
                    draggingEle.style.left = `${draggingEle.offsetLeft + e.clientX - x}px`;

                    // Reassign the position of mouse
                    x = e.clientX;
                    y = e.clientY;

                    // The current order
                    // prevEle
                    // draggingEle
                    // placeholder
                    // nextEle
                    const prevEle = draggingEle.previousElementSibling;
                    const nextEle = placeholder.nextElementSibling;

                    // // The dragging element is above the previous element
                    // // User moves the dragging element to the left
                    if (prevEle && isOnLeft(draggingEle, prevEle)) {
                        // The current order    -> The new order
                        // prevEle              -> placeholder
                        // draggingEle          -> draggingEle
                        // placeholder          -> prevEle
                        swap(placeholder, draggingEle);
                        swap(placeholder, prevEle);
                        return;
                    }

                    // The dragging element is below the next element
                    // User moves the dragging element to the bottom
                    if (nextEle && isOnLeft(nextEle, draggingEle)) {
                        // The current order    -> The new order
                        // draggingEle          -> nextEle
                        // placeholder          -> placeholder
                        // nextEle              -> draggingEle
                        swap(nextEle, placeholder);
                        swap(nextEle, draggingEle);
                    }
                };

                const mouseUpHandler = function () {
                    // // Remove the placeholder
                    placeholder && placeholder.parentNode.removeChild(placeholder);

                    draggingEle.classList.remove('dragging');
                    draggingEle.style.removeProperty('top');
                    draggingEle.style.removeProperty('left');
                    draggingEle.style.removeProperty('position');

                    // Get the end index
                    const endColumnIndex = [].slice.call(list.children).indexOf(draggingEle);

                    isDraggingStarted = false;

                    // Remove the `list` element
                    list.parentNode.removeChild(list);

                    // Move the dragged column to `endColumnIndex`
                    table.querySelectorAll('tr').forEach(function (row) {
                        const cells = [].slice.call(row.querySelectorAll('th, td'));
                        draggingColumnIndex > endColumnIndex
                            ? cells[endColumnIndex].parentNode.insertBefore(
                                  cells[draggingColumnIndex],
                                  cells[endColumnIndex]
                              )
                            : cells[endColumnIndex].parentNode.insertBefore(
                                  cells[draggingColumnIndex],
                                  cells[endColumnIndex].nextSibling
                              );
                    });

                    // Bring back the table
                    table.style.removeProperty('visibility');

                    // Remove the handlers of `mousemove` and `mouseup`
                    document.removeEventListener('mousemove', mouseMoveHandler);
                    document.removeEventListener('mouseup', mouseUpHandler);
                };

                table.querySelectorAll('th').forEach(function (headerCell) {
                    headerCell.classList.add('draggable');
                    headerCell.addEventListener('mousedown', mouseDownHandler);
                });
            });
        </script>
    </body>
</html>

