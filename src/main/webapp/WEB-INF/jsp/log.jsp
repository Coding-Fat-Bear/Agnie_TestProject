
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
<%@page import="com.agnie.controller.login2" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Master</title>
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
    overflow-y:scroll;
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
/*    position:relative; */
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
    margin-right: 10px
}

.head{
	display:block;
        margin:10px
}
.head ul {
	
	margin:30px;
        text-decoration: none;
	list-style-type: none;
        margin-left: 50px;
        
}

.head ul li{
	display:grig;
	margin-right:20px;
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
  
}
 input[type=number].no-spinner::-webkit-inner-spin-button, 
    input[type=number]::-webkit-outer-spin-button { 
    -webkit-appearance: none; 
      
}

.top li{
    
    display: inline-block
}


.opbut li{
    display: inline-block;
}

.sald{
    display: inline-block
}



</style>
    
    <body>
       <form method="post">
    
        <header>
            <button formaction="backtohome" style="color:white;margin: 10px;background-color: transparent;cursor: pointer">
                <i class="fa fa-angle-double-left"></i></button>
        <!--<div class="header-inner1">-->
<!--	<h1><a href="index.htm">
                <img src="assets/logo.gif" class="logo" alt="Agnie India" >
            </a></h1>-->
            
          <!--</div>-->
	<!--</div>-->
      </header>
        
            
    <div class="mbar" >
      <div class="dropdown">
                <button type="button" class="dropbtn"><%= request.getAttribute("EMM") %></button>
                <div id="drpcnt" class="dropdown-content">
                    
                    <li><button id="ecre" formaction="empcre" class="menu" ><%= request.getAttribute("EMC") %></button></li>
                    <li><button id="echa" formaction="empcha" class="menu" ><%= request.getAttribute("EMED") %></button></li>
                    <li><button id="edis" formaction="empdis" class="menu" ><%= request.getAttribute("EMDIS") %></button></li>
                    <li><button formaction="emplst" class="menu" ><%= request.getAttribute("EMLST") %></button></li>
                    
                </div>
            </div>  
        <div  class="dropdown">
                <button type="button"  class="dropbtn"><%= request.getAttribute("TOLEDT") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" >Create</button></li>
                 <li><button  class="menu" >Change</button></li>
                 <li><button  class="menu" >Display</button></li>
                </div>
            </div>
        <div class="dropdown">
                <button type="button" class="dropbtn"><%= request.getAttribute("TOLGOTO") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" >Create</button></li>
                 <li><button  class="menu" >Change</button></li>
                 <li><button  class="menu" >Display</button></li>
                </div>
            </div>
            <div class="dropdown">
                <button type="button"  class="dropbtn"><%= request.getAttribute("TOLENV") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" >Create</button></li>
                 <li><button  class="menu" >Change</button></li>
                 <li><button  class="menu" >Display</button></li>
                </div>
            </div>
            <div class="dropdown">
                <button type="button" class="dropbtn"><%= request.getAttribute("TOLSYS") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" >Create</button></li>
                 <li><button  class="menu" >Change</button></li>
                 <li><button  class="menu" >Display</button></li>
                </div>
            </div>
    </div>
        
<!--        <form action="insert" method="post">-->
<div id="hed" class="head" >
    
     
        <ul class="opbut">
            <li><button type="button" id="getbut" onclick="butget();" style="cursor: pointer;display:none;text-align:center;font-size:20px"  title="Get Employee Data" ><i class="fas fa-glasses"></i></button></li>
            <li><button type="submit" id="delbut" formaction="delemp" style="cursor: pointer;display:none;text-align:center;font-size:20px" title="Delete Employee" ><i class="fa fa-trash"></i></button></li>
            <li><button type="submit" id="chabut" formaction="updt" style="cursor: pointer;display:none;text-align:center;font-size:20px" title="Update Employee" ><i class="fa fa-save"></i></button></li>
            <li><button  type="submit" id="crebut" style="float: left;cursor: pointer;display:block;text-align:center;font-size:20px" formaction="insert" title="Create Employee" ><i class="fa fa-file"></i></button></li>
        </ul>
        <ul class="top">
            
            <li><label  for="empid" style="width:100px" ><%= request.getAttribute("EMPLNO") %></label>
                <input type="text" style="width:53px;" maxlength="7" name="empid" oninvalid="this.setCustomValidity('Enter Employee Number')" title="Enter Employee Number" id="empid" /></li>            
            <li><label for="ccod" style="width:150px" ><%= request.getAttribute("COMCD") %></label><input type="text" style="width:33px;" maxlength="4" name="ccod" id="ccod"></li>
            <input type="text" style="width:53px;" maxlength="7" name="weblng" id="weblng" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="emnum" id="emnum" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="scrn" id="scrn" hidden>
            
        </ul>
     
        <button type="button" class="tablink" id="BD1" onclick="openPage(this.id)"><%= request.getAttribute("BSDT") %>1</button>
        <button type="button" class="tablink" id="BD2" onclick="openPage(this.id)"><%= request.getAttribute("BSDT") %>2</button>
        <button type="button"  class="tablink" id="SALD" onclick="openPage(this.id)"><%= request.getAttribute("SALDT") %></button>
        <button type="button" class="tablink" id="ORGD" onclick="openPage(this.id)"><%= request.getAttribute("ORGDT") %></button>
        <button type="button" class="tablink" id="EXPD" onclick="openPage(this.id)"><%= request.getAttribute("EXPR") %></button>
<div id="BD1" class="tabcontent">
  <!--<h3>Basci Data1</h3>-->
  <%
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      Connection con1 = null;
                      Statement stm = null;
  %>
  <ul>
      <li><label for="empnm"><%= request.getAttribute("EMPLNAM") %></label><input maxlength="30" style="width:226px;" type="text" name="empnm" id="empnm" /></li>
      <li><label  for="dob"><%= request.getAttribute("DOBRT") %></label><input type="date"  style="width:130px;text-transform: uppercase" placeholder="MM/DD/YYYY" onchange="dob();"  name="dob" id="dob" /></li>
      <li><label  for="gnd" style="width:196px" ><%= request.getAttribute("GNDR") %></label>
          <select type="text"  style="width:80px;text-transform:uppercase" name="gnd" id="gnd" >
              <option value=""></option>
              
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry = "select * from Gender";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry);
                      while(rs.next())
                      {
                          %>
                          <option value="<%=rs.getString("GENDER") %>"><%=rs.getString("GEN_TEXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                   con1.close();
                  %>
              
          </select></li>
      <li><label  for="age" style="width:201px" ><%= request.getAttribute("AGE") %></label><input maxlength="2" style="width:32px;" id="age" type="number" min="0" max="99" name="age" /></li>
      <li><label  for="splnex" style="width:196px" ><%= request.getAttribute("SPLNEX") %></label>
          <select type="text" maxlength="2" style="width:100px;text-transform:uppercase" id="splnex" name="splnex" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry1 = "select * from Language_Master";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs1 = stm.executeQuery(qry1);
                      while(rs1.next())
                      {
                          %>
                          <option value="<%=rs1.getString("LNGID") %>"><%=rs1.getString("LNG_TEXT") %></option>
              <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select></li>
      <li><label for="actstrt"><%= request.getAttribute("ATSTDT") %></label><input type="date"  width="120px" style="width:130px;text-transform: uppercase" id="actstrt" name="actstrt" /></li>
      <li><label for="actend"><%= request.getAttribute("ATENDT") %></label><input type="date" width="120px" style="width:130px;text-transform: uppercase" onchange="datval();" type="date" id="actend" name="actend" /></li>
  </ul>
  
</div>

<div id="BD2" class="tabcontent">
  <!--<h3>Basci Data2</h3>-->
  <ul>
      <li><label  for="str1"><%= request.getAttribute("STRT") %>1</label><input maxlength="30" style="width:226px;" type="text" id="str1" name="str1" /></li>
      <li><label  for="str2"><%= request.getAttribute("STRT") %>2</label><input maxlength="30" style="width:226px;" type="text" id="str2" name="str2" /></li>
      <li><label  for="str3"><%= request.getAttribute("STRT") %>3</label><input maxlength="30" style="width:226px;" type="text" id="str3" name="str3" /></li>
      <li><label  for="city" ><%= request.getAttribute("CITY") %></label><input maxlength="30" style="width:226px;" type="text" id="city" name="city" /></li>
      <li><label  for="stat" ><%= request.getAttribute("STATE") %></label><input maxlength="30" style="width:226px;" type="text" id="stat" name="stat" /></li>
      <li><label  for="cntry" style="width:196px" ><%= request.getAttribute("CONTR") %></label>
          <select maxlength="2" style="width:100px;text-transform:uppercase" type="text" id="cntry" name="cntry" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry1 = "select * from Country";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs1 = stm.executeQuery(qry1);
                      while(rs1.next())
                      {
                          %>
                          <option value="<%=rs1.getString("COUNTRY") %>"><%=rs1.getString("CNTR_TEXT") %></option>
              <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select></li>
       <li><label  for="lang" style="width:196px" ><%= request.getAttribute("LANGU") %></label>
           <select type="text" maxlength="2" style="width:100px;text-transform:uppercase" id="lang" name="lang" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry1 = "select * from Language_Master";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs1 = stm.executeQuery(qry1);
                      while(rs1.next())
                      {
                          %>
                          <option value="<%=rs1.getString("LNGID") %>"><%=rs1.getString("LNG_TEXT") %></option>
              <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select></li>
          <li><label for="pstl" ><%= request.getAttribute("PSTLCOD") %></label><input type="text" maxlength="10" style="width:80px;" inputmode="numeric" id="pstl" name="pstl" /></li>
          <li><label  for="phn1" ><%= request.getAttribute("PHON") %>1</label><input type="tel" maxlength="30" style="width:226px;" id="phn1" name="phn1" /></li>
          <li><label  for="phn2" ><%= request.getAttribute("PHON") %>2</label><input maxlength="30" style="width:226px;" type="text" id="phn2" name="phn2" /></li>
          <li><label  for="fax" ><%= request.getAttribute("FAKUSU") %></label><input type="text" maxlength="30" style="width:226px;" id="fax" name="fax" /></li>
          <li><label  for="emil" ><%= request.getAttribute("MERU") %></label><input maxlength="50" style="width:226px;" type="text" id="emil" name="emil" /></li>
  </ul>
  
</div>

<div id="SALD" class="tabcontent">
  <!--<h3>Salary Detail</h3>-->
  <ul class="sald">
      <li><label  for="bnk" style="width:196px" ><%= request.getAttribute("GINKO") %></label>
          <select type="text" maxlength="2" style="width:100px;text-transform:uppercase" id="bnk" name="bnk" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry1 = "select * from Bank";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs1 = stm.executeQuery(qry1);
                      while(rs1.next())
                      {
                          %>
                          <option value="<%=rs1.getString("BANCOD") %>"><%=rs1.getString("BNK_TEXT") %></option>
              <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select></li>
      <li><label  for="bsal"><%= request.getAttribute("BSLRY") %></label><input maxlength="13" class="no-spinner" onchange="grs()" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="number" step="0.01" id="bsal" name="bsal" /></li>
      <li><label for="hrawl" ><%= request.getAttribute("HRAL") %></label><input maxlength="13" class="no-spinner" onchange="grs()" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="number" step="0.01" id="hrawl" name="hrawl" /></li>
      <li><label  for="conawl" ><%= request.getAttribute("CONAL") %></label><input maxlength="13" class="no-spinner" onchange="grs()" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="number" step="0.01" id="conawl" name="conawl" /></li>
      <li><label  for="sttben" ><%= request.getAttribute("STTBN") %></label><input maxlength="13" class="no-spinner" onchange="grs()" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="number" step="0.01" id="sttben" name="sttben" /></li>
      <li><label  for="incnt"><%= request.getAttribute("INCENT") %></label><input maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="text"id="incnt" name="incnt" /></li>
      <li><label  for="bons"><%= request.getAttribute("BOUNS") %></label><input maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="text" id="bons" name="bons" /></li>
      <li><label  for="sclins" ><%= request.getAttribute("SOIN") %></label><input maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="text" id="sclins" name="sclins" /></li>
    </ul>
    <ul class="sald">        
      <li><label  for="helins" ><%= request.getAttribute("HELIN") %></label><input maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="text" id="helins" name="helins" /></li>
      <li><label  for="epf" ><%= request.getAttribute("EMPF") %></label><input onchange="dtct()" type="text" maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" id="epf" name="epf" /></li>
      <li><label  for="advnc" ><%= request.getAttribute("ADVNC") %></label><input onchange="dtct()" type="text" maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" id="advnc" name="advnc" /></li>
      <li><label  for="tax" ><%= request.getAttribute("ZEITAX") %></label><input onchange="dtct()" type="text" maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" id="tax" name="tax" /></li>
      <li><label  for="totdt" ><%= request.getAttribute("TOTDED") %></label><input maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="text" id="totdt" name="totdt" /></li>
      <li><label  for="bilrat" ><%= request.getAttribute("BILRATE") %></label><input maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="text" id="bilrat" name="bilrat" /></li>
      <li><label  for="grssal" ><%= request.getAttribute("GRSSAL") %></label><input maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="text" id="grssal" name="grssal" /></li>
      <li><label  for="netsal" ><%= request.getAttribute("NETSL") %></label><input maxlength="13" class="no-spinner" style="width:100px;text-align: right" value="0.00" placeholder="0.00" type="text" id="netsal" name="netsal" /></li>
  </ul>
  
</div>

<div id="ORGD" class="tabcontent">
  <!--<h3>Organization Detail</h3>-->
  <ul>
      <li><label for="bslin"><%= request.getAttribute("BUSILN") %></label>
          <select maxlength="2" style="width:80px;text-transform:uppercase" width="120px" type="text" id="bslin" name="bslin" >
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
          </select></li>
      <li><label for="dept"><%= request.getAttribute("DEPMNT") %></label>
          <select maxlength="2" style="width:180px;text-transform:uppercase" type="text" id="dept" name="dept" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry3 = "select * from Department";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs3 = stm.executeQuery(qry3);
                      while(rs3.next())
                      {
                          %>
                          <option value="<%=rs3.getString("DPTCOD") %>" ><%=rs3.getString("DPT_TEXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select></li>
      <li><label for="emptyp"><%= request.getAttribute("EMTYP") %></label>
          <select maxlength="2" style="width:160px;text-transform:uppercase" type="text" id="emptyp" name="emptyp" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry4 = "select * from Employee_Type";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs4 = stm.executeQuery(qry4);
                      while(rs4.next())
                      {
                          %>
                          <option value="<%=rs4.getString("EMPTYP") %>"><%=rs4.getString("EMTY_TEXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select></li>
      <li><label for="rank" ><%= request.getAttribute("EMRNK") %></label>
          <select maxlength="2" style="width:150px;text-transform:uppercase" type="text" id="rank" name="rank" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry5 = "select * from Rank_emp";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs5 = stm.executeQuery(qry5);
                      while(rs5.next())
                      {
                          %>
                          <option value="<%=rs5.getString("RANKCOD") %>"><%=rs5.getString("RNK_TEXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select></li>
                    
  </ul>
  
</div>

<div id="EXPD" class="tabcontent">
  <!--<h3>Experience</h3>-->
  <ul>
      <li><label for="resv" ><%= request.getAttribute("RESVE") %></label><input maxlength="30" style="width:226px;" type="text" id="resv" name="resv" /></li>
      <li><label for="modexp" style="width:196px" ><%= request.getAttribute("MODEXPR") %></label>
          <select maxlength="4" style="width:150px;text-transform:uppercase" width="120px" type="text" id="modexp" name="modexp" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry5 = "select * from Module";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs5 = stm.executeQuery(qry5);
                      while(rs5.next())
                      {
                          %>
                          <option value="<%=rs5.getString("MODUL") %>"><%=rs5.getString("MOD_TEXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select></li>
      <li><label for="pmglnex" style="width:196px" ><%= request.getAttribute("PROLNEX") %></label>
          <select maxlength="2" style="width:100px;text-transform:uppercase" type="text" id="pmglnex" name="pmglnex" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry5 = "select * from Programming_Language";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs5 = stm.executeQuery(qry5);
                      while(rs5.next())
                      {
                          %>
                          <option value="<%=rs5.getString("PGMLANG") %>"><%=rs5.getString("PGLN_TEXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select></li>
          <li><label for="exsap"><%= request.getAttribute("EXPRSAP") %></label><input maxlength="2" style="width:32px;" type="number" id="exsap" name="exsap" /></li>
          <li><label for="exit" ><%= request.getAttribute("EXPRIT") %></label><input maxlength="2" style="width:32px;" type="number" id="exit" name="exit" /></li>      
          <li><label for="quli" ><%= request.getAttribute("QALIFI") %></label><input maxlength="30" style="width:226px;" type="text" id="quli" name="quli" /></li>
  </ul>
  
</div>
    
</div>
  <table style="display:none;overflow-x: auto" id="myTable" name="myTable" class="myTable">
            
           <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String sqllst = "SELECT * FROM agnieportal.Employee_Master em inner join agnieportal.Address am on em.ADDNO = am.ADDNO";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(sqllst);
                      while(rs2.next())
                      {
                          %>
               <tr>
               <td><%=rs2.getString("EMPCOD") %></td> <!--0-->
               <td><%=rs2.getString("CCOD") %></td>   <!--1-->
               <td><%=rs2.getString("EMPNAM") %></td> <!--2-->
               <td><%=rs2.getString("EMPDOB") %></td>  <!--3-->
               <td><%=rs2.getString("GENDER") %></td>  <!--4-->
               <td><%=rs2.getString("SPLNGID") %></td>  <!--5-->
               <td><%=rs2.getString("ACTSTRDT") %></td>  <!--6-->
               <td><%=rs2.getString("ACTENDT") %></td>   <!--7-->
               <td><%=rs2.getString("STREET1") %></td>   <!--8-->
               <td><%=rs2.getString("STREET2") %></td>   <!--9-->
               <td><%=rs2.getString("STREET3") %></td>  <!--10-->
               <td><%=rs2.getString("CITY") %></td>    <!--11-->
               <td><%=rs2.getString("STATE") %></td>   <!--12-->
               <td><%=rs2.getString("CNTRY") %></td>   <!--13-->
               <td><%=rs2.getString("LNGID") %></td>   <!--14-->
               <td><%=rs2.getString("PINCODE") %></td>   <!--15-->
               <td><%=rs2.getString("PHONE1") %></td>   <!--16-->
               <td><%=rs2.getString("PHONE2") %></td>   <!--17-->
               <td><%=rs2.getString("FAXNO") %></td>   <!--18-->
               <td><%=rs2.getString("EMAIL") %></td>   <!--19-->
               <td><%=rs2.getString("BANCOD") %></td>   <!--20-->
               <td><%=rs2.getString("BASSAL") %></td>   <!--21-->
               <td><%=rs2.getString("HRALW") %></td>   <!--22-->
               <td><%=rs2.getString("CONALW") %></td>   <!--23-->
               <td><%=rs2.getString("STATBEN") %></td>   <!--24-->
               <td><%=rs2.getString("INCNT") %></td>   <!--25-->
               <td><%=rs2.getString("BONUS") %></td>   <!--26-->
               <td><%=rs2.getString("SOCINS") %></td>   <!--27-->
               <td><%=rs2.getString("HELINS") %></td>   <!--28-->
               <td><%=rs2.getString("PENSION") %></td>   <!--29-->
               <td><%=rs2.getString("LOAN") %></td>   <!--30-->
               <td><%=rs2.getString("TAX") %></td>   <!--31-->
               <td><%=rs2.getString("BILRATE") %></td>   <!--32-->
               <td><%=rs2.getString("BIZID") %></td>   <!--33-->
               <td><%=rs2.getString("DPTCOD") %></td>   <!--34-->
               <td><%=rs2.getString("EMPTYP") %></td>   <!--35-->
               <td><%=rs2.getString("RANKCOD") %></td>   <!--36-->
               <td><%=rs2.getString("RESERV") %></td>   <!--37-->
               <td><%=rs2.getString("MODUL") %></td>   <!--38-->
               <td><%=rs2.getString("PGMLANG") %></td>   <!--39-->
               <td><%=rs2.getString("EXSAP") %></td>   <!--40-->
               <td><%=rs2.getString("EXPIT") %></td>   <!--41-->
               <td><%=rs2.getString("QUALI") %></td>   <!--42-->
               <td><%=rs2.getString("ACTFLG") %></td>   <!--43-->
               
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
 
      <script>
          function butget(){
          var empid = document.getElementById("empid").value;
          var input, filter, table, tr, td, i, txtValue;
          table = document.getElementById("myTable");
          var rowlen = table.rows.length;
          tr = table.getElementsByTagName("tr");
          for (i = 0; i < rowlen; i++) {
//          td = tr[i].getElementsByTagName("td")[0].innerText;
            
          var celemp = table.rows[i].cells[0].innerText;
          var comp = table.rows[i].cells[1].innerText;
          var empnam = table.rows[i].cells[2].innerText;
          var empdob = table.rows[i].cells[3].innerText;
          var empgndr = table.rows[i].cells[4].innerText;
          var empsplng = table.rows[i].cells[5].innerText;
          var actst = table.rows[i].cells[6].innerText;
          var acten = table.rows[i].cells[7].innerText;
          var str1 = table.rows[i].cells[8].innerText;
          var str2 = table.rows[i].cells[9].innerText;
          var str3 = table.rows[i].cells[10].innerText;
          var city = table.rows[i].cells[11].innerText;
          var stat = table.rows[i].cells[12].innerText;
          var cntry = table.rows[i].cells[13].innerText;
          var lang = table.rows[i].cells[14].innerText;
          var pstl = table.rows[i].cells[15].innerText;
          var phn1 = table.rows[i].cells[16].innerText;
          var phn2 = table.rows[i].cells[17].innerText;
          var fax = table.rows[i].cells[18].innerText;
          var emil = table.rows[i].cells[19].innerText;
          var bnk = table.rows[i].cells[20].innerText;
          var bsal = table.rows[i].cells[21].innerText;
          var hrawl = table.rows[i].cells[22].innerText;
          var conawl = table.rows[i].cells[23].innerText;
          var sttben = table.rows[i].cells[24].innerText;
          var incnt = table.rows[i].cells[25].innerText;
          var bons = table.rows[i].cells[26].innerText;
          var sclins = table.rows[i].cells[27].innerText;
          var helins = table.rows[i].cells[28].innerText;
          var epf = table.rows[i].cells[29].innerText;
          var advnc = table.rows[i].cells[30].innerText;
          var tax = table.rows[i].cells[31].innerText;
          var bilrat = table.rows[i].cells[32].innerText;
          var bslin = table.rows[i].cells[33].innerText;
          var dept = table.rows[i].cells[34].innerText;
          var emptyp = table.rows[i].cells[35].innerText;
          var rank = table.rows[i].cells[36].innerText;
          var resv = table.rows[i].cells[37].innerText;
          var modexp = table.rows[i].cells[38].innerText;
          var pmglnex = table.rows[i].cells[39].innerText;
          var exsap = table.rows[i].cells[40].innerText;
          var exit = table.rows[i].cells[41].innerText;
          var quli = table.rows[i].cells[42].innerText;
          var actflg = table.rows[i].cells[43].innerText;
          
          if(empid === celemp){
              if (actflg === "X"){
              alert("already deleted");
              document.getElementById("empid").value = "";
         document.getElementById('ccod').value = "";         
         
         document.getElementById('empnm').value = "";
         document.getElementById('dob').value = "";
         document.getElementById('gnd').value = "";
         document.getElementById("age").value = "";
         document.getElementById('splnex').value = "";
         document.getElementById('actstrt').value = "";
         document.getElementById('actend').value = "";
         
         document.getElementById('str1').value = "";
         document.getElementById('str2').value = "";
         document.getElementById('str3').value = "";
         document.getElementById('city').value = "";
         document.getElementById('stat').value = "";
         document.getElementById('cntry').value = "";
         document.getElementById('lang').value = "";
         document.getElementById('pstl').value = "";
         document.getElementById('phn1').value = "";
         document.getElementById('phn2').value = "";
         document.getElementById('fax').value = "";
         document.getElementById('emil').value = "";
         
         document.getElementById('bnk').value = "";
         document.getElementById('bsal').value = "0.00";
         document.getElementById('hrawl').value = "0.00";
         document.getElementById('conawl').value = "0.00";
         document.getElementById('sttben').value = "0.00";
         document.getElementById('incnt').value = "0.00";
         document.getElementById('bons').value = "0.00";
         document.getElementById('sclins').value = "0.00";
         document.getElementById('helins').value = "0.00";
         document.getElementById('epf').value = "0.00";
         document.getElementById('advnc').value = "0.00";
         document.getElementById('tax').value = "0.00";
         document.getElementById('bilrat').value = "0.00";
         document.getElementById('grssal').value = "0.00";
         document.getElementById('totdt').value = "0.00";
         document.getElementById('netsal').value = "0.00";
         
         document.getElementById('bslin').value = "";
         document.getElementById('dept').value = "";
         document.getElementById('emptyp').value = "";
         document.getElementById('rank').value = "";         
         
         document.getElementById('resv').value = "";
         document.getElementById('modexp').value = "";
         document.getElementById('pmglnex').value = "";
         document.getElementById('exsap').value = "";
         document.getElementById('exit').value = "";
         document.getElementById('quli').value = "";
          }else{
//              alert(celemp);
            document.getElementById("ccod").value = comp;
            document.getElementById("empnm").value = empnam;
            document.getElementById("dob").value = empdob;
            var today = new Date();
            var y1 = empdob.substr(0,4);
         var y2 = today.getFullYear();
         var age = y2 - y1;
         var m1 = empdob.substr(5,2);
         var m2 = (today.getMonth()+1);

            if(m1 > m2){
                document.getElementById("age").value = (age - 1);
            }
            else{
                document.getElementById("age").value = age;
            }
            document.getElementById("gnd").value = empgndr;
            document.getElementById("splnex").value = empsplng;
            document.getElementById("actstrt").value = actst;
            document.getElementById("actend").value = acten;
            document.getElementById("str1").value = str1;
            document.getElementById("str2").value = str2;
            document.getElementById("str3").value = str3;
            document.getElementById("city").value = city;
            document.getElementById("stat").value = stat;
            document.getElementById("cntry").value = cntry;
            document.getElementById("lang").value = lang;
            document.getElementById("pstl").value = pstl;
            document.getElementById("phn1").value = phn1;
            document.getElementById("phn2").value = phn2;
            document.getElementById("fax").value = fax;
            document.getElementById("emil").value = emil;
            document.getElementById("bnk").value = bnk;
            document.getElementById("bsal").value = bsal;
            document.getElementById("hrawl").value = hrawl;
            document.getElementById("conawl").value = conawl;
            document.getElementById("sttben").value = sttben;
            var totgrs = Number(bsal) + Number(hrawl)+ Number(conawl)+ Number(sttben);      
            document.getElementById("grssal").value = totgrs+'.00';
            document.getElementById("incnt").value = incnt;
            document.getElementById("bons").value = bons;
            document.getElementById("sclins").value = sclins;
            document.getElementById("helins").value = helins;
            document.getElementById("epf").value = epf;
            document.getElementById("advnc").value = advnc;
            document.getElementById("tax").value = tax;
            var totdct = Number(epf) + Number(advnc) + Number(tax);
            var tdct = document.getElementById('totdt').value = totdct + '.00';
            var totnet = Number(totgrs) - Number(tdct);
            document.getElementById("netsal").value = totnet + '.00';
            document.getElementById("bilrat").value = bilrat;
            document.getElementById("bslin").value = bslin;
            document.getElementById("dept").value = dept;
            document.getElementById("emptyp").value = emptyp;
            document.getElementById("rank").value = rank;
            document.getElementById("resv").value = resv;
            document.getElementById("modexp").value = modexp;
            document.getElementById("pmglnex").value = pmglnex;
            document.getElementById("exsap").value = exsap;
            document.getElementById("exit").value = exit;
            document.getElementById("quli").value = quli;
            
            
          }
           }
            
            }
      }
      </script>     
                  
  <script>
     function datval(){ 
         
         var actst = document.getElementById("actstrt").value;
         var acten = document.getElementById("actend").value;
       if(acten < actst){           
           alert("Active end date is less than Active start date please check the data");
           document.getElementById("actend").value = "";
        }
   }
      
  </script>
          
<script>
    document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
    document.getElementById("emnum").value = '<%= request.getAttribute("emnum") %>';
    
       if('<%= request.getAttribute("scrn") %>' === 'cha'){
            
         document.getElementById("scrn").value = "cha";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "block";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "block";
//         document.getElementById("empid").required = true;
         document.getElementById('ccod').disabled = false;         
         
         document.getElementById('empnm').disabled = false;
         document.getElementById('dob').disabled = false;
         document.getElementById('gnd').disabled = false;
         document.getElementById("age").disabled = false;
         document.getElementById('splnex').disabled = false;
         document.getElementById('actstrt').disabled = false;
         document.getElementById('actend').disabled = false;
         
         document.getElementById('str1').disabled = false;
         document.getElementById('str2').disabled = false;
         document.getElementById('str3').disabled = false;
         document.getElementById('city').disabled = false;
         document.getElementById('stat').disabled = false;
         document.getElementById('cntry').disabled = false;
         document.getElementById('lang').disabled = false;
         document.getElementById('pstl').disabled = false;
         document.getElementById('phn1').disabled = false;
         document.getElementById('phn2').disabled = false;
         document.getElementById('fax').disabled = false;
         document.getElementById('emil').disabled = false;
         
         document.getElementById('bnk').disabled = false;
         document.getElementById('bsal').disabled = false;
         document.getElementById('hrawl').disabled = false;
         document.getElementById('conawl').disabled = false;
         document.getElementById('sttben').disabled = false;
         document.getElementById('incnt').disabled = false;
         document.getElementById('bons').disabled = false;
         document.getElementById('sclins').disabled = false;
         document.getElementById('helins').disabled = false;
         document.getElementById('epf').disabled = false;
         document.getElementById('advnc').disabled = false;
         document.getElementById('tax').disabled = false;
         document.getElementById('bilrat').disabled = false;
         document.getElementById('grssal').disabled = false;
         document.getElementById('totdt').disabled = false;
         document.getElementById('netsal').disabled = false;
         
         document.getElementById('bslin').disabled = false;
         document.getElementById('dept').disabled = false;
         document.getElementById('emptyp').disabled = false;
         document.getElementById('rank').disabled = false;         
         
         document.getElementById('resv').disabled = false;
         document.getElementById('modexp').disabled = false;
         document.getElementById('pmglnex').disabled = false;
         document.getElementById('exsap').disabled = false;
         document.getElementById('exit').disabled = false;
         document.getElementById('quli').disabled = false;
     }
     
     if('<%= request.getAttribute("scrn") %>' === 'dis'){
            
            document.getElementById("scrn").value = "dis";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
//         document.getElementById("empid").required = true;
         document.getElementById('ccod').disabled = true;         
         
         document.getElementById('empnm').disabled = true;
         document.getElementById('dob').disabled = true;
         document.getElementById('gnd').disabled = true;
         document.getElementById("age").disabled = true;
         document.getElementById('splnex').disabled = true;
         document.getElementById('actstrt').disabled = true;
         document.getElementById('actend').disabled = true;
         
         document.getElementById('str1').disabled = true;
         document.getElementById('str2').disabled = true;
         document.getElementById('str3').disabled = true;
         document.getElementById('city').disabled = true;
         document.getElementById('stat').disabled = true;
         document.getElementById('cntry').disabled = true;
         document.getElementById('lang').disabled = true;
         document.getElementById('pstl').disabled = true;
         document.getElementById('phn1').disabled = true;
         document.getElementById('phn2').disabled = true;
         document.getElementById('fax').disabled = true;
         document.getElementById('emil').disabled = true;
         
         document.getElementById('bnk').disabled = true;
         document.getElementById('bsal').disabled = true;
         document.getElementById('hrawl').disabled = true;
         document.getElementById('conawl').disabled = true;
         document.getElementById('sttben').disabled = true;
         document.getElementById('incnt').disabled = true;
         document.getElementById('bons').disabled = true;
         document.getElementById('sclins').disabled = true;
         document.getElementById('helins').disabled = true;
         document.getElementById('epf').disabled = true;
         document.getElementById('advnc').disabled = true;
         document.getElementById('tax').disabled = true;
         document.getElementById('bilrat').disabled = true;
         document.getElementById('grssal').disabled = true;
         document.getElementById('totdt').disabled = true;
         document.getElementById('netsal').disabled = true;
         
         document.getElementById('bslin').disabled = true;
         document.getElementById('dept').disabled = true;
         document.getElementById('emptyp').disabled = true;
         document.getElementById('rank').disabled = true;         
         
         document.getElementById('resv').disabled = true;
         document.getElementById('modexp').disabled = true;
         document.getElementById('pmglnex').disabled = true;
         document.getElementById('exsap').disabled = true;
         document.getElementById('exit').disabled = true;
         document.getElementById('quli').disabled = true;
            
        }
        
        if('<%= request.getAttribute("scrn") %>' === 'cre'){
            
            document.getElementById("scrn").value = "cre";
         document.getElementById("crebut").style.display = "block";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "none";
         document.getElementById("delbut").style.display = "none";
//         document.getElementById("empid").required = false;
         document.getElementById('ccod').disabled = false;         
         
         document.getElementById('empnm').disabled = false;
         document.getElementById('dob').disabled = false;
         document.getElementById('gnd').disabled = false;
         document.getElementById("age").disabled = false;
         document.getElementById('splnex').disabled = false;
         document.getElementById('actstrt').disabled = false;
         document.getElementById('actend').disabled = false;
         
         document.getElementById('str1').disabled = false;
         document.getElementById('str2').disabled = false;
         document.getElementById('str3').disabled = false;
         document.getElementById('city').disabled = false;
         document.getElementById('stat').disabled = false;
         document.getElementById('cntry').disabled = false;
         document.getElementById('lang').disabled = false;
         document.getElementById('pstl').disabled = false;
         document.getElementById('phn1').disabled = false;
         document.getElementById('phn2').disabled = false;
         document.getElementById('fax').disabled = false;
         document.getElementById('emil').disabled = false;
         
         document.getElementById('bnk').disabled = false;
         document.getElementById('bsal').disabled = false;
         document.getElementById('hrawl').disabled = false;
         document.getElementById('conawl').disabled = false;
         document.getElementById('sttben').disabled = false;
         document.getElementById('incnt').disabled = false;
         document.getElementById('bons').disabled = false;
         document.getElementById('sclins').disabled = false;
         document.getElementById('helins').disabled = false;
         document.getElementById('epf').disabled = false;
         document.getElementById('advnc').disabled = false;
         document.getElementById('tax').disabled = false;
         document.getElementById('bilrat').disabled = false;
         document.getElementById('grssal').disabled = false;
         document.getElementById('totdt').disabled = false;
         document.getElementById('netsal').disabled = false;
         
         document.getElementById('bslin').disabled = false;
         document.getElementById('dept').disabled = false;
         document.getElementById('emptyp').disabled = false;
         document.getElementById('rank').disabled = false;         
         
         document.getElementById('resv').disabled = false;
         document.getElementById('modexp').disabled = false;
         document.getElementById('pmglnex').disabled = false;
         document.getElementById('exsap').disabled = false;
         document.getElementById('exit').disabled = false;
         document.getElementById('quli').disabled = false;
         
         document.getElementById("empid").value = "";
         document.getElementById('ccod').value = "";         
         
         document.getElementById('empnm').value = "";
         document.getElementById('dob').value = "";
         document.getElementById('gnd').value = "";
         document.getElementById("age").value = "";
         document.getElementById('splnex').value = "";
         document.getElementById('actstrt').value = "";
         document.getElementById('actend').value = "";
         
         document.getElementById('str1').value = "";
         document.getElementById('str2').value = "";
         document.getElementById('str3').value = "";
         document.getElementById('city').value = "";
         document.getElementById('stat').value = "";
         document.getElementById('cntry').value = "";
         document.getElementById('lang').value = "";
         document.getElementById('pstl').value = "";
         document.getElementById('phn1').value = "";
         document.getElementById('phn2').value = "";
         document.getElementById('fax').value = "";
         document.getElementById('emil').value = "";
         
         document.getElementById('bnk').value = "";
         document.getElementById('bsal').value = "0.00";
         document.getElementById('hrawl').value = "0.00";
         document.getElementById('conawl').value = "0.00";
         document.getElementById('sttben').value = "0.00";
         document.getElementById('incnt').value = "0.00";
         document.getElementById('bons').value = "0.00";
         document.getElementById('sclins').value = "0.00";
         document.getElementById('helins').value = "0.00";
         document.getElementById('epf').value = "0.00";
         document.getElementById('advnc').value = "0.00";
         document.getElementById('tax').value = "0.00";
         document.getElementById('bilrat').value = "0.00";
         document.getElementById('grssal').value = "0.00";
         document.getElementById('totdt').value = "0.00";
         document.getElementById('netsal').value = "0.00";
         
         document.getElementById('bslin').value = "";
         document.getElementById('dept').value = "";
         document.getElementById('emptyp').value = "";
         document.getElementById('rank').value = "";         
         
         document.getElementById('resv').value = "";
         document.getElementById('modexp').value = "";
         document.getElementById('pmglnex').value = "";
         document.getElementById('exsap').value = "";
         document.getElementById('exit').value = "";
         document.getElementById('quli').value = "";
         
        }
            
    </script>
          
<script>
 var temp = 0;
 var temp1 = "BD1";
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
document.getElementById("BD1").click();
</script>

<script>
    var today = new Date();
    var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
    
    
//    document.getElementById("cdat").value = date;
    function dob(){
    
    var dob = document.getElementById("dob").value;
//    var age = date - dob;
//    calculate_age();
var y1 = dob.substr(0,4);
var y2 = today.getFullYear();
var age = y2 - y1;
var m1 = dob.substr(5,2);
var m2 = (today.getMonth()+1);

    if(m1 > m2){
        document.getElementById("age").value = (age - 1);
    }
    else{
        document.getElementById("age").value = age;
    }
    
}
</script>

<script>
   function grs(){
       var bassal = document.getElementById('bsal').value;
       var hralw = document.getElementById('hrawl').value;
       var conalw = document.getElementById('conawl').value;
       var sttben = document.getElementById('sttben').value;
       var totgrs = Number(bassal) + Number(hralw)+ Number(conalw)+ Number(sttben);      
       document.getElementById("grssal").value = totgrs+'.00';
       
        }
        
        function dtct(){
            var epf = document.getElementById('epf').value;
            var advnc = document.getElementById('advnc').value;
            var tax = document.getElementById('tax').value;
            var totdct = Number(epf) + Number(advnc) + Number(tax);
            
            var tdct = document.getElementById('totdt').value = totdct + '.00';
            var grs = document.getElementById("grssal").value;
            var totnet = Number(grs) - Number(tdct);
            document.getElementById("netsal").value = totnet + '.00';
        }
        
</script>

<script>
         if(<%= request.getAttribute("appnm") %> === 1){
              
//        alert("Employee "+<%= request.getAttribute("empno") %>+" and Address"+<%= request.getAttribute("addno") %>+" created successfully");
        
        
        }
 </script>
 

 <script>
     
//     change option starts
     function logcha(){
         
         document.getElementById("scrn").value = "cha";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "block";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "block";
         document.getElementById("empid").required = true;
         document.getElementById('ccod').disabled = false;         
         
         document.getElementById('empnm').disabled = false;
         document.getElementById('dob').disabled = false;
         document.getElementById('gnd').disabled = false;
         document.getElementById("age").disabled = false;
         document.getElementById('splnex').disabled = false;
         document.getElementById('actstrt').disabled = false;
         document.getElementById('actend').disabled = false;
         
         document.getElementById('str1').disabled = false;
         document.getElementById('str2').disabled = false;
         document.getElementById('str3').disabled = false;
         document.getElementById('city').disabled = false;
         document.getElementById('stat').disabled = false;
         document.getElementById('cntry').disabled = false;
         document.getElementById('lang').disabled = false;
         document.getElementById('pstl').disabled = false;
         document.getElementById('phn1').disabled = false;
         document.getElementById('phn2').disabled = false;
         document.getElementById('fax').disabled = false;
         document.getElementById('emil').disabled = false;
         
         document.getElementById('bnk').disabled = false;
         document.getElementById('bsal').disabled = false;
         document.getElementById('hrawl').disabled = false;
         document.getElementById('conawl').disabled = false;
         document.getElementById('sttben').disabled = false;
         document.getElementById('incnt').disabled = false;
         document.getElementById('bons').disabled = false;
         document.getElementById('sclins').disabled = false;
         document.getElementById('helins').disabled = false;
         document.getElementById('epf').disabled = false;
         document.getElementById('advnc').disabled = false;
         document.getElementById('tax').disabled = false;
         document.getElementById('bilrat').disabled = false;
         document.getElementById('grssal').disabled = false;
         document.getElementById('totdt').disabled = false;
         document.getElementById('netsal').disabled = false;
         
         document.getElementById('bslin').disabled = false;
         document.getElementById('dept').disabled = false;
         document.getElementById('emptyp').disabled = false;
         document.getElementById('rank').disabled = false;
         
         
         document.getElementById('resv').disabled = false;
         document.getElementById('modexp').disabled = false;
         document.getElementById('pmglnex').disabled = false;
         document.getElementById('exsap').disabled = false;
         document.getElementById('exit').disabled = false;
         document.getElementById('quli').disabled = false;
     }
//     change option end

//        create option starts
     function logcre(){
         
         document.getElementById("scrn").value = "cre";
         document.getElementById("crebut").style.display = "block";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "none";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("empid").required = false;
         document.getElementById('ccod').disabled = false;         
         
         document.getElementById('empnm').disabled = false;
         document.getElementById('dob').disabled = false;
         document.getElementById('gnd').disabled = false;
         document.getElementById("age").disabled = false;
         document.getElementById('splnex').disabled = false;
         document.getElementById('actstrt').disabled = false;
         document.getElementById('actend').disabled = false;
         
         document.getElementById('str1').disabled = false;
         document.getElementById('str2').disabled = false;
         document.getElementById('str3').disabled = false;
         document.getElementById('city').disabled = false;
         document.getElementById('stat').disabled = false;
         document.getElementById('cntry').disabled = false;
         document.getElementById('lang').disabled = false;
         document.getElementById('pstl').disabled = false;
         document.getElementById('phn1').disabled = false;
         document.getElementById('phn2').disabled = false;
         document.getElementById('fax').disabled = false;
         document.getElementById('emil').disabled = false;
         
         document.getElementById('bnk').disabled = false;
         document.getElementById('bsal').disabled = false;
         document.getElementById('hrawl').disabled = false;
         document.getElementById('conawl').disabled = false;
         document.getElementById('sttben').disabled = false;
         document.getElementById('incnt').disabled = false;
         document.getElementById('bons').disabled = false;
         document.getElementById('sclins').disabled = false;
         document.getElementById('helins').disabled = false;
         document.getElementById('epf').disabled = false;
         document.getElementById('advnc').disabled = false;
         document.getElementById('tax').disabled = false;
         document.getElementById('bilrat').disabled = false;
         document.getElementById('grssal').disabled = false;
         document.getElementById('totdt').disabled = false;
         document.getElementById('netsal').disabled = false;
         
         document.getElementById('bslin').disabled = false;
         document.getElementById('dept').disabled = false;
         document.getElementById('emptyp').disabled = false;
         document.getElementById('rank').disabled = false;        
         
         document.getElementById('resv').disabled = false;
         document.getElementById('modexp').disabled = false;
         document.getElementById('pmglnex').disabled = false;
         document.getElementById('exsap').disabled = false;
         document.getElementById('exit').disabled = false;
         document.getElementById('quli').disabled = false;
         
         document.getElementById("empid").value = "";
         document.getElementById('ccod').value = "";         
         
         document.getElementById('empnm').value = "";
         document.getElementById('dob').value = "";
         document.getElementById('gnd').value = "";
         document.getElementById("age").value = "";
         document.getElementById('splnex').value = "";
         document.getElementById('actstrt').value = "";
         document.getElementById('actend').value = "";
         
         document.getElementById('str1').value = "";
         document.getElementById('str2').value = "";
         document.getElementById('str3').value = "";
         document.getElementById('city').value = "";
         document.getElementById('stat').value = "";
         document.getElementById('cntry').value = "";
         document.getElementById('lang').value = "";
         document.getElementById('pstl').value = "";
         document.getElementById('phn1').value = "";
         document.getElementById('phn2').value = "";
         document.getElementById('fax').value = "";
         document.getElementById('emil').value = "";
         
         document.getElementById('bnk').value = "";
         document.getElementById('bsal').value = "0.00";
         document.getElementById('hrawl').value = "0.00";
         document.getElementById('conawl').value = "0.00";
         document.getElementById('sttben').value = "0.00";
         document.getElementById('incnt').value = "0.00";
         document.getElementById('bons').value = "0.00";
         document.getElementById('sclins').value = "0.00";
         document.getElementById('helins').value = "0.00";
         document.getElementById('epf').value = "0.00";
         document.getElementById('advnc').value = "0.00";
         document.getElementById('tax').value = "0.00";
         document.getElementById('bilrat').value = "0.00";
         document.getElementById('grssal').value = "0.00";
         document.getElementById('totdt').value = "0.00";
         document.getElementById('netsal').value = "0.00";
         
         document.getElementById('bslin').value = "";
         document.getElementById('dept').value = "";
         document.getElementById('emptyp').value = "";
         document.getElementById('rank').value = "";         
         
         document.getElementById('resv').value = "";
         document.getElementById('modexp').value = "";
         document.getElementById('pmglnex').value = "";
         document.getElementById('exsap').value = "";
         document.getElementById('exit').value = "";
         document.getElementById('quli').value = "";
         
         
     }
//     create option end
     
//        Display option starts
     function logdis(){
         
         document.getElementById("scrn").value = "dis";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("empid").required = true;
         document.getElementById('ccod').disabled = true;         
         
         document.getElementById('empnm').disabled = true;
         document.getElementById('dob').disabled = true;
         document.getElementById('gnd').disabled = true;
         document.getElementById("age").disabled = true;
         document.getElementById('splnex').disabled = true;
         document.getElementById('actstrt').disabled = true;
         document.getElementById('actend').disabled = true;
         
         document.getElementById('str1').disabled = true;
         document.getElementById('str2').disabled = true;
         document.getElementById('str3').disabled = true;
         document.getElementById('city').disabled = true;
         document.getElementById('stat').disabled = true;
         document.getElementById('cntry').disabled = true;
         document.getElementById('lang').disabled = true;
         document.getElementById('pstl').disabled = true;
         document.getElementById('phn1').disabled = true;
         document.getElementById('phn2').disabled = true;
         document.getElementById('fax').disabled = true;
         document.getElementById('emil').disabled = true;
         
         document.getElementById('bnk').disabled = true;
         document.getElementById('bsal').disabled = true;
         document.getElementById('hrawl').disabled = true;
         document.getElementById('conawl').disabled = true;
         document.getElementById('sttben').disabled = true;
         document.getElementById('incnt').disabled = true;
         document.getElementById('bons').disabled = true;
         document.getElementById('sclins').disabled = true;
         document.getElementById('helins').disabled = true;
         document.getElementById('epf').disabled = true;
         document.getElementById('advnc').disabled = true;
         document.getElementById('tax').disabled = true;
         document.getElementById('bilrat').disabled = true;
         document.getElementById('grssal').disabled = true;
         document.getElementById('totdt').disabled = true;
         document.getElementById('netsal').disabled = true;
         
         document.getElementById('bslin').disabled = true;
         document.getElementById('dept').disabled = true;
         document.getElementById('emptyp').disabled = true;
         document.getElementById('rank').disabled = true;         
         
         document.getElementById('resv').disabled = true;
         document.getElementById('modexp').disabled = true;
         document.getElementById('pmglnex').disabled = true;
         document.getElementById('exsap').disabled = true;
         document.getElementById('exit').disabled = true;
         document.getElementById('quli').disabled = true;
     }
//     Display option end
 </script>
 
<!-- <script>
//     During Get operation got data from backend and pass to display fields
     
     if(<%= request.getAttribute("getnm") %> === 2){
         var today = new Date();
         var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
         
         document.getElementById('empid').value = '<%= request.getAttribute("empid1") %>';
         document.getElementById('ccod').value = '<%= request.getAttribute("ccod") %>';         
         
         document.getElementById('empnm').value = '<%= request.getAttribute("empnm") %>';
         var dob = document.getElementById('dob').value = '<%= request.getAttribute("dob") %>';
         var y1 = dob.substr(0,4);
         var y2 = today.getFullYear();
         var age = y2 - y1;
         var m1 = dob.substr(5,2);
         var m2 = (today.getMonth()+1);

            if(m1 > m2){
                document.getElementById("age").value = (age - 1);
            }
            else{
                document.getElementById("age").value = age;
            }
         document.getElementById('gnd').value = '<%= request.getAttribute("gnd") %>';
         document.getElementById('splnex').value = '<%= request.getAttribute("splnex") %>';         
         document.getElementById('actstrt').value = '<%= request.getAttribute("actstrt") %>';
         document.getElementById('actend').value = '<%= request.getAttribute("actend") %>';
         
         document.getElementById('str1').value = '<%= request.getAttribute("str1") %>';
         document.getElementById('str2').value = '<%= request.getAttribute("str2") %>';
         document.getElementById('str3').value = '<%= request.getAttribute("str3") %>';
         document.getElementById('city').value = '<%= request.getAttribute("city") %>';
         document.getElementById('stat').value = '<%= request.getAttribute("stat") %>';
         document.getElementById('cntry').value = '<%= request.getAttribute("cntry") %>';
         document.getElementById('lang').value = '<%= request.getAttribute("lang") %>';
         document.getElementById('pstl').value = '<%= request.getAttribute("pstl") %>';
         document.getElementById('phn1').value = '<%= request.getAttribute("phn1") %>';
         document.getElementById('phn2').value = '<%= request.getAttribute("phn2") %>';
         document.getElementById('fax').value = '<%= request.getAttribute("fax") %>';
         document.getElementById('emil').value = '<%= request.getAttribute("emil") %>';
         
         document.getElementById('bnk').value = '<%= request.getAttribute("bnk") %>';
         var bassal = document.getElementById('bsal').value = '<%= request.getAttribute("bsal") %>';
         var hralw = document.getElementById('hrawl').value = '<%= request.getAttribute("hrawl") %>';
         var conalw = document.getElementById('conawl').value = '<%= request.getAttribute("conawl") %>';
         var sttben = document.getElementById('sttben').value = '<%= request.getAttribute("sttben") %>';
          var totgrs = Number(bassal) + Number(hralw)+ Number(conalw)+ Number(sttben);      
          document.getElementById("grssal").value = totgrs+'.00';
         document.getElementById('incnt').value = '<%= request.getAttribute("incnt") %>';
         document.getElementById('bons').value = '<%= request.getAttribute("bons") %>';
         document.getElementById('sclins').value = '<%= request.getAttribute("sclins") %>';
         document.getElementById('helins').value = '<%= request.getAttribute("helins") %>';
         var epf = document.getElementById('epf').value = '<%= request.getAttribute("epf") %>';
         var advnc = document.getElementById('advnc').value = '<%= request.getAttribute("advnc") %>';
         var tax = document.getElementById('tax').value = '<%= request.getAttribute("tax") %>';
         var totdct = Number(epf) + Number(advnc) + Number(tax);
         var tdct = document.getElementById('totdt').value = totdct + '.00';
         var totnet = Number(totgrs) - Number(tdct);
         document.getElementById("netsal").value = totnet + '.00';
         document.getElementById('bilrat').value = '<%= request.getAttribute("bilrat") %>';
         
         document.getElementById('bslin').value = '<%= request.getAttribute("bslin") %>';
         document.getElementById('dept').value = '<%= request.getAttribute("dept") %>';
         document.getElementById('emptyp').value = '<%= request.getAttribute("emptyp") %>';
         document.getElementById('rank').value = '<%= request.getAttribute("rank") %>';         
         
         document.getElementById('resv').value = '<%= request.getAttribute("resv") %>';
         document.getElementById('modexp').value = '<%= request.getAttribute("modexp") %>';
         document.getElementById('pmglnex').value = '<%= request.getAttribute("pmglnex") %>';
         document.getElementById('exsap').value = '<%= request.getAttribute("exsap") %>';
         document.getElementById('exit').value = '<%= request.getAttribute("exit") %>';
         document.getElementById('quli').value = '<%= request.getAttribute("quli") %>';
         
        
         
     }
 </script>-->
 
 
              
    </body>
</html>
