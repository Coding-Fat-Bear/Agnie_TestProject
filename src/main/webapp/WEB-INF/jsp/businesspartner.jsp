<%-- 
    Document   : businesspartner
    Created on : Dec 25, 2021, 11:07:32 PM
    Author     : Welcome
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Business Partner</title>
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
  width: 59.2%;
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
.bpTable{
    margin-left: 10px;
    transition-property: height;
    transition-duration: 2s;
}
.bpTable thead th{
    background-color: #555;
    /*width: 250px;*/
    font-size: 10px;
/*    margin-left: 10px;
    margin-right: 10px;*/
    position: sticky;
    color: white;

}
</style>
    <body>
        
        <form method="post">
        <header>
            <button formaction="backtohome2" style="color:white;margin: 10px;background-color: transparent;cursor: pointer">
                <i class="fa fa-angle-double-left"></i></button>
        <!--<div class="header-inner1">-->
<!--	<h1><a href="index.htm">
                <img src="assets/logo.gif" class="logo" alt="Agnie India" >
            </a></h1>-->
            
          <!--</div>-->
	<!--</div>-->
      </header>    
        <%
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      Connection con1 = null;
                      Statement stm = null;
        %>
            
            <div class="mbar" >
      <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("BPMM") %></button>
                <div id="drpcnt" class="dropdown-content">
                    
                    <li><button id="ecre" formaction="empcre" class="menu" ><%= request.getAttribute("EMC") %></button></li>
                    <li><button id="echa" formaction="empcha" class="menu" ><%= request.getAttribute("EMED") %></button></li>
                    <li><button id="edis" formaction="empdis" class="menu" ><%= request.getAttribute("EMDIS") %></button></li>
                    <li><button formaction="emplst" class="menu" ><%= request.getAttribute("EMLST") %></button></li>
                    
                </div>
            </div>  
        <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("TOLEDT") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" >Create</button></li>
                 <li><button  class="menu" >Change</button></li>
                 <li><button  class="menu" >Display</button></li>
                </div>
            </div>
        <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("TOLGOTO") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" >Create</button></li>
                 <li><button  class="menu" >Change</button></li>
                 <li><button  class="menu" >Display</button></li>
                </div>
            </div>
            <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("TOLENV") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" >Create</button></li>
                 <li><button  class="menu" >Change</button></li>
                 <li><button  class="menu" >Display</button></li>
                </div>
            </div>
            <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("TOLSYS") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" >Create</button></li>
                 <li><button  class="menu" >Change</button></li>
                 <li><button  class="menu" >Display</button></li>
                </div>
            </div>
    </div>
            
            <div id="hed" class="head" >
                
                <ul class="opbut">
                <li><button type="button" id="getbutbp" onclick="bpbutget();" style="cursor: pointer;display:none;text-align:center;font-size:20px"  title="Get Employee Data" ><i class="fas fa-glasses"></i></button></li>
                <li><button type="submit" id="delbutbp" formaction="delemp" style="cursor: pointer;display:none;text-align:center;font-size:20px" title="Delete Employee" ><i class="fa fa-trash"></i></button></li>
                <li><button type="submit" id="chabutbp" formaction="updt" style="cursor: pointer;display:none;text-align:center;font-size:20px" title="Update Employee" ><i class="fa fa-save"></i></button></li>
                <li><button  type="submit" id="crebutbp" style="margin: 0px;float: left;cursor: pointer;display:block;text-align:center;font-size:20px" formaction="insertbpm" title="Create Employee" ><i class="fa fa-file"></i></button></li>
                <li><button type="submit" id="chabutbp" formaction="check" style="cursor: pointer;display:block;text-align:center;font-size:20px" title="Update Employee" >check</button></li>
                </ul>
                <ul class="top">

                 <li><label  for="bpmno" style="width:160px" ><%= request.getAttribute("BPNO") %></label>
                     <input type="text" style="width:53px;" maxlength="7" name="bpmno" title="Enter Employee Number" id="bpmno" /></li>            
                 <li><label for="ccod" style="width:150px" ><%= request.getAttribute("COMCD") %></label><input type="text" style="width:33px;" maxlength="4" name="ccod" id="ccod"></li>
                 <input type="text" style="width:53px;" maxlength="7" name="weblng" id="weblng" hidden>
                 <input type="text" style="width:53px;" maxlength="7" name="emnum" id="emnum" hidden>
                 <input type="text" style="width:53px;" maxlength="7" name="scrn" id="scrn" hidden>

                </ul>
                
                <button type="button" class="tablink" id="BD1" onclick="openPage(this.id)"><%= request.getAttribute("BSDT") %>1</button>
                <button type="button" class="tablink" id="BD2" onclick="openPage(this.id)"><%= request.getAttribute("BSDT") %>2</button>
                <button type="button"  class="tablink" id="SALD" onclick="openPage(this.id)"><%= request.getAttribute("BSDT") %>3</button>
<!--                <button type="button" class="tablink" id="ORGD" onclick="openPage(this.id)"><%= request.getAttribute("ORGDT") %></button>
                <button type="button" class="tablink" id="EXPD" onclick="openPage(this.id)"><%= request.getAttribute("EXPR") %></button>-->
                
                <div id="BD1" class="tabcontent">
                    <ul>
                      
                        <li><label for="bpdes"><%= request.getAttribute("BPDES") %></label><input maxlength="30" style="width:226px;" type="text" name="bpdes" id="bpdes" /></li>
                      <li><label for="paytm"><%= request.getAttribute("PYTM") %></label>
                          <select maxlength="30" style="width:226px;" type="text" name="paytm" id="paytm" >
                              <option value=""></option>
                 <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry = "select * from Payment_Terms";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry);
                      while(rs.next())
                      {
                          %>
                          <option value="<%=rs.getString("PAYTRMS") %>"><%=rs.getString("PAYTXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                   con1.close();
                  %>
                          </select></li>
                      <li><label for="bpstdt"><%= request.getAttribute("BPSTDT") %></label><input type="date"  width="120px" style="width:130px;text-transform: uppercase" id="bpstdt" name="bpstdt" /></li>
                      <li><label for="bpendt"><%= request.getAttribute("BPENDT") %></label><input type="date"  width="120px" style="width:130px;text-transform: uppercase" id="bpendt" name="bpendt" /></li>
                    </ul>
                </div>
                    <div id="BD2" class="tabcontent">
                        <ul>
                        <li><label for="contyp"><%= request.getAttribute("CONTYP") %></label>
                          <select maxlength="30" style="width:226px;" type="text" name="contyp" id="contyp" >
                              <option value=""></option>
                              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry1 = "select * from Contract_Types";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs1 = stm.executeQuery(qry1);
                      while(rs1.next())
                      {
                          %>
                          <option value="<%=rs1.getString("CNTRTYP") %>"><%=rs1.getString("CNTRTEXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                   con1.close();
                  %>
                          </select></li>
                          <li><label for="bscon"><%= request.getAttribute("BSCON") %></label><input maxlength="30" onchange="bsco();" style="width:100px;" type="checkbox" value="X" name="bscon" id="bscon" /></li>
                        <li><label for="nda"><%= request.getAttribute("NDA") %></label><input maxlength="30" style="width:100px;" type="checkbox" value="X" name="nda" id="nda" /></li>
                        <li><label for="asc"><%= request.getAttribute("ASC") %></label><input maxlength="30" style="width:100px;" type="checkbox" value="X" name="asc" id="asc" /></li>
                        <li><label for="aprvl">Approval</label><input maxlength="30" style="width:100px;" type="checkbox" value="X" name="aprvl" id="aprvl" /></li>
                        
                        </ul>
                    </div>
                
            </div> 
<!--                        <button id="plus" onclick="expnd();" style="font-size: 25px;margin-left: 10px;display: none"><i class="fa fa-plus-square"></i></button>
                        <button id="minus" onclick="colaps();" style="font-size: 25px;margin-left: 10px"><i class="fa fa-minus-square"></i></button>-->
            <div id="SALD" class="tabcontent">
                <button type="button" onclick="addrow();"><i class="fa fa-plus-square"></i></button>
                        <table style="display:block;overflow-x: auto;overflow-y: auto" id="bpTable" name="bpTable" class="bpTable">
                            <thead>
                                <tr>
                                    <th style="width:100px;">ItemNo</th>
                                    <th style="width:226px;">Consultant ID</th>
                                    <th style="width:226px;">Consultant Name</th>
                                    <th style="width:100px;">Unit</th>
                                    <th style="width:100px;">Rate</th>
                                    <th style="width:100px;">Selling Unit</th>
                                    <th style="width:100px;">Selling Rate</th>
                                    <th style="width:80px;">Currency</th>
                                    <th style="width:100px;">Consultant Type</th>
                                    <th style="width:100px;">Module</th>
                                    <th style="width:100px;">Spoken Language</th>
                                    <th style="width:100px;">Programming Language</th>
                                    <th style="width:100px;">Exp.in SAP </th>
                                    <th style="width:100px;">Exp.in IT </th>
                                </tr>
                            </thead>
                            <tbody style="overflow-y: auto">
                                <tr>
                                    <td id="col0" name="col0"><input class="itmno" maxlength="5" style="width:100px;text-align: center" value="1" type="text" name="bpitm" id="bpdes" /></td>
                                    <td id="col1" name="col1"><input maxlength="30" style="width:226px;" type="text" name="bpid" id="bpid" /></td>
                                    <td id="col2" name="col2"><input maxlength="30" style="width:226px;" type="text" name="bpnam" id="bpnam" /></td>
                                    <td id="col3" name="col3"><input maxlength="5" style="width:100px;" type="text" name="bpunit" id="bpunit" /></td>                                    
                                    <td id="col4" name="col4"><input maxlength="5" style="width:100px;" type="text" name="bprate" id="bprate" /></td>
                                    <td id="col5" name="col5"><input maxlength="5" style="width:100px;" type="text" name="bpselunt" id="bpselunt" /></td>
                                    <td id="col6" name="col6"><input maxlength="5" style="width:100px;" type="text" name="bpselrat" id="bpselrat" /></td>
                                    <td id="col7" name="col7"><select maxlength="3" style="width:80px;" type="text" name="bpcurr" id="bpcurr" >
                                            <option value=""></option>
                 <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry = "select * from Currency";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs = stm.executeQuery(qry);
                      while(rs.next())
                      {
                          %>
                          <option value="<%=rs.getString("CURID") %>"><%=rs.getString("CURTXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                   con1.close();
                  %>
                                        </select></td>
                                    <td id="col8" name="col8"><select maxlength="3" style="width:100px;" type="text" name="bpconstyp" id="bpconstyp" >
                                            <option value=""></option>
                 <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Employee_Type";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("EMPTYP") %>"><%=rs2.getString("EMTY_TEXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                   con1.close();
                  %>
                                        </select></td>
                                    <td id="col9" name="col9"><select maxlength="3" style="width:100px;" type="text" name="bpmodu" id="bpmodu" >
                                            <option value=""></option>
                 <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry3 = "select * from Module";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs3 = stm.executeQuery(qry3);
                      while(rs3.next())
                      {
                          %>
                          <option value="<%=rs3.getString("MODUL") %>"><%=rs3.getString("MOD_TEXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                   con1.close();
                  %>
                                        </select></td>
                                    <td id="col10" name="col10"><select maxlength="3" style="width:100px;" type="text" name="bpsplng" id="bpsplng" >
                                            <option value=""></option>
                <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry4 = "select * from Language_Master";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs4 = stm.executeQuery(qry4);
                      while(rs4.next())
                      {
                          %>
                          <option value="<%=rs4.getString("LNGID") %>"><%=rs4.getString("LNG_TEXT") %></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                   con1.close();
                  %>
                                        </select></td>                                    
                                    <td id="col11" name="col11"><select maxlength="3" style="width:100px;" type="text" name="bppmglng" id="bppmglng" >
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
                                        </select></td>
                                    <td id="col12" name="col12"><input maxlength="3" style="width:100px;" type="text" name="expsap" id="expsap" /></td>
                                    <td id="col13" name="col13"><input maxlength="3" style="width:100px;" type="text" name="expit" id="expit" /></td>
                                </tr>
                            </tbody>
                            
                        </table>
            </div>
                                        
             <table style="display:block;overflow-x: auto" id="bpmmst" name="bpmmst" class="bpmmst">
            
           <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String sqlmst = "SELECT * FROM Businesspartner_Master";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(sqlmst);
                      while(rs2.next())
                      {
                          %>
               <tr>
               <td><%=rs2.getString("BPNO") %></td> <!--0-->
               <td><%=rs2.getString("CCOD") %></td>   <!--1-->
               <td><%=rs2.getString("BPDES") %></td> <!--2-->
               <td><%=rs2.getString("PAYTRMS") %></td>  <!--3-->
               <td><%=rs2.getString("FRMDT") %></td>  <!--4-->
               <td><%=rs2.getString("TODT") %></td>  <!--5-->
               <td><%=rs2.getString("CNTRTYP") %></td>  <!--6-->
               <td><%=rs2.getString("BSCNTR") %></td>   <!--7-->
               <td><%=rs2.getString("NDA") %></td>   <!--8-->
               <td><%=rs2.getString("ASCON") %></td>   <!--9-->
               <td><%=rs2.getString("APPRVL") %></td>  <!--10-->
               
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
                  
            <table style="display:block;overflow-x: auto" id="bpmitm" name="bpmitm" class="bpmitm">
            
           <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String sqlitm = "SELECT * FROM Businesspartner_Item";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs3 = stm.executeQuery(sqlitm);
                      while(rs3.next())
                      {
                          %>
               <tr>
               <td><%=rs3.getString("BPNO") %></td> <!--0-->
               <td><%=rs3.getString("BPITEM") %></td>   <!--1-->
               <td><%=rs3.getString("BPID") %></td> <!--2-->
               <td><%=rs3.getString("BPNAME") %></td>  <!--3-->
               <td><%=rs3.getString("UNIT") %></td>  <!--4-->
               <td><%=rs3.getString("RATE") %></td>  <!--5-->
               <td><%=rs3.getString("SELUNIT") %></td>  <!--6-->
               <td><%=rs3.getString("SELRATE") %></td>   <!--7-->
               <td><%=rs3.getString("CURR") %></td>   <!--8-->
               <td><%=rs3.getString("BPTYP") %></td>   <!--9-->
               <td><%=rs3.getString("MODUL") %></td>  <!--10-->
               <td><%=rs3.getString("LNGID") %></td>    <!--11-->
               <td><%=rs3.getString("PGMLANG") %></td>   <!--12-->
               <td><%=rs3.getString("SAPEXP") %></td>   <!--13-->
               <td><%=rs3.getString("ITEXP") %></td>   <!--14-->
               
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
    
    document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
    document.getElementById("emnum").value = '<%= request.getAttribute("emnum") %>';
    document.getElementById("scrn").value = '<%= request.getAttribute("scrn") %>';
</script>

<script>
    if('<%= request.getAttribute("scrn") %>' === 'cre'){
        
         document.getElementById("crebutbp").style.display = "block";
         document.getElementById("chabutbp").style.display = "none";
         document.getElementById("getbutbp").style.display = "none";
         document.getElementById("delbutbp").style.display = "none";
//         document.gatElementById("bpmno").disabled = false;
         document.getElementById("ccod").disabled = false;
         document.getElementById("bpdes").disabled = false;
         document.getElementById("paytm").disabled = false;
         document.getElementById("bpstdt").disabled = false;
         document.getElementById("bpendt").disabled = false;
         document.getElementById("contyp").disabled = false;
         document.getElementById("bscon").disabled = false;
         document.getElementById("nda").disabled = false;
         document.getElementById("asc").disabled = false;
         document.getElementById("aprvl").disabled = false;
         document.getElementById("bpmno").value = "";
         document.getElementById("ccod").value = "";
         document.getElementById("bpdes").value = "";
         document.getElementById("paytm").value = "";
         document.getElementById("bpstdt").value = "";
         document.getElementById("bpendt").value = "";
         document.getElementById("contyp").value = "";
         document.getElementById("bscon").checked = false;
         document.getElementById("nda").checked = false;
         document.getElementById("asc").checked = false;
         document.getElementById("aprvl").checked = false;
        
    }
    
    if('<%= request.getAttribute("scrn") %>' === 'cha'){
        
         document.getElementById("crebutbp").style.display = "none";
         document.getElementById("chabutbp").style.display = "block";
         document.getElementById("getbutbp").style.display = "block";
         document.getElementById("delbutbp").style.display = "block";
//         document.gatElementById("bpmno").disabled = false;
         document.getElementById("ccod").disabled = false;
         document.getElementById("bpdes").disabled = false;
         document.getElementById("paytm").disabled = false;
         document.getElementById("bpstdt").disabled = false;
         document.getElementById("bpendt").disabled = false;
         document.getElementById("contyp").disabled = false;
         document.getElementById("bscon").disabled = false;
         document.getElementById("nda").disabled = false;
         document.getElementById("asc").disabled = false;
         document.getElementById("aprvl").disabled = false;
        
    }
    
    if('<%= request.getAttribute("scrn") %>' === 'dis'){
        
         document.getElementById("crebutbp").style.display = "none";
         document.getElementById("chabutbp").style.display = "none";
         document.getElementById("getbutbp").style.display = "block";
         document.getElementById("delbutbp").style.display = "none";
//         document.gatElementById("bpmno").disabled = true;
         document.gatElementById("ccod").disabled = true;
         document.gatElementById("bpdes").disabled = true;
         document.gatElementById("paytm").disabled = true;
         document.gatElementById("bpstdt").disabled = true;
         document.gatElementById("bpendt").disabled = true;
         document.gatElementById("contyp").disabled = true;
         document.gatElementById("bscon").disabled = true;
         document.gatElementById("nda").disabled = true;
         document.gatElementById("asc").disabled = true;
         document.gatElementById("aprvl").disabled = true;
        
    }
    
</script>

<script>
    for(var k = 0;k < 4;k++){
         var tabbp = document.getElementById("bpTable");
        var rowcount = tabbp.rows.length;
        var prvcol = rowcount - 1;
        var cellcount = tabbp.rows[0].cells.length;
        var adrow = tabbp.insertRow(rowcount);
        for(var i =0;i < cellcount;i++){
            var cell = 'cell'+i;
            cell = adrow.insertCell(i);
            var incell = document.getElementById("col"+i).innerHTML;            
            cell.innerHTML=incell;
            
        }       
        document.getElementsByClassName("itmno")[prvcol].value = rowcount;
    }
    
    
</script>

<script>
    
    function addrow(){
        var tabbp = document.getElementById("bpTable");
        var rowcount = tabbp.rows.length;
        var prvcol = rowcount - 1;
        var cellcount = tabbp.rows[0].cells.length;
        var adrow = tabbp.insertRow(rowcount);
        for(var i =0;i < cellcount;i++){
            var cell = 'cell'+i;
            cell = adrow.insertCell(i);
            var incell = document.getElementById("col"+i).innerHTML;            
            cell.innerHTML=incell;
            
        }       
        document.getElementsByClassName("itmno")[prvcol].value = rowcount;
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
  
	if(tabid === clicked_id){
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
    function bpbutget(){
        var bpno = document.getElementById("bpmno").value;
        var msttable = document.getElementById("bpmmst");
        var itmtable = document.getElementById("bpmitm");
        var mstrowlen = msttable.rows.length;
        
        
        for(var i = 0;i < mstrowlen;i++){
          var bsptno = msttable.rows[i].cells[0].innerText;
          var compc = msttable.rows[i].cells[1].innerText;
          var descr = msttable.rows[i].cells[2].innerText;
          var payms = msttable.rows[i].cells[3].innerText;
          var strtdt = msttable.rows[i].cells[4].innerText;
          var enddt = msttable.rows[i].cells[5].innerText;
          var contrtyp = msttable.rows[i].cells[6].innerText;
          var basconch = msttable.rows[i].cells[7].innerText;
          var ndach = msttable.rows[i].cells[8].innerText;
          var ascch = msttable.rows[i].cells[9].innerText;
          var aprlch = msttable.rows[i].cells[10].innerText;
          
          if(bsptno === bpno){
              
         document.getElementById("ccod").value = compc;
         document.getElementById("bpdes").value = descr;
         document.getElementById("paytm").value = payms;
         document.getElementById("bpstdt").value = strtdt;
         document.getElementById("bpendt").value = enddt;
         document.getElementById("contyp").value = contrtyp;
         if(basconch === 'X'){
             document.getElementById("bscon").checked = true;
         }else{
             document.getElementById("bscon").checked = false;
         }
         if(ndach === 'X'){
             document.getElementById("nda").checked = true;
         }else{
             document.getElementById("nda").checked = false;
         }
         if(ascch === 'X'){
             document.getElementById("asc").checked = true;
         }else{
            document.getElementById("asc").checked = false;
         }
         if(aprlch === 'X'){
             document.getElementById("aprvl").checked = true;
         }else{
            document.getElementById("aprvl").checked = false;
         }
         
         }
          
        }
        
        var itmrowlen = itmtable.rows.length;
//        for(var j = 0; i < itmrowlen;j++){
//            
//          var bpnum = itmtable.rows[i].cells[0].innerText;
//          var bpitm = itmtable.rows[i].cells[1].innerText;
//          var bpid = itmtable.rows[i].cells[2].innerText;
//          var bpnam = itmtable.rows[i].cells[3].innerText;
//          var bpunit = itmtable.rows[i].cells[4].innerText;
//          var bprate = itmtable.rows[i].cells[5].innerText;
//          var bpselrate = itmtable.rows[i].cells[6].innerText;
//          var bpselunit = itmtable.rows[i].cells[7].innerText;
//          var bpcurr = itmtable.rows[i].cells[8].innerText;
//          var bptype = itmtable.rows[i].cells[9].innerText;
//          var bpmod = itmtable.rows[i].cells[10].innerText;
//          var bplangu = itmtable.rows[i].cells[11].innerText;
//          var bppgmlng = itmtable.rows[i].cells[12].innerText;
//          var bpsapexp = itmtable.rows[i].cells[13].innerText;
//          var bpitexp = itmtable.rows[i].cells[14].innerText;
//            
//        }
        
    }
</script>


    </body>
</html>
