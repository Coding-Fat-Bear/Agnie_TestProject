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
        margin-left: 10px;
        
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
  margin-right: 0px;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 12px 14px;
  font-size: 14px;
  width: 20.2%;
  border-radius: 0px 25px 0px 25px;
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
  width: 59.9%;
  /*width: auto;*/
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
    margin-right: 0px
}

.sald{
    display: inline-block
}
.bpTable{
    margin-left: 10px;
    transition-property: height;
    transition-duration: 2s;
    /*width:100%;*/
    /*overflow: visible;*/
    
}
.bpTable thead, th, td{
    background-color: #555;
    width: auto;
    border: 1px solid black;
    /*font-size: 12px;*/
/*    margin-left: 10px;
    margin-right: 10px;*/
    /*position: absolute;*/
    /*top: 0;*/
/*    color: white;*/

}

.rowdeldia{
    width: 300px;
    height:80px;
    background-color:threedhighlight
    
}
</style>
    <body>
        
        <form method="post">
        <header>
          h1 align="center">Business Partners </h1>
      </header>    
        <%
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      Connection con1 = null;
                      Statement stm = null;
        %>
            
            <div class="mbar" >
      <div class="dropdown">
          <button type="button"  class="dropbtn"><%= request.getAttribute("BPMM") %></button>
                <div id="drpcnt" class="dropdown-content">
                    
                    <li><button id="ecre" formaction="bpmcre" class="menu" ><%= request.getAttribute("EMC") %></button></li>
                    <li><button id="echa" formaction="bpmcha" class="menu" ><%= request.getAttribute("EMED") %></button></li>
                    <li><button id="edis" formaction="bpmdis" class="menu" ><%= request.getAttribute("EMDIS") %></button></li>
                    <li><button id="edesl" formaction="bpmdel" class="menu" ><%= request.getAttribute("DDLT") %></button></li>
                    <li><button formaction="bpmlst" class="menu" ><%= request.getAttribute("EMLST") %></button></li>
                    
                </div>
            </div>  
        <div class="dropdown">
            <button type="button" class="dropbtn"><%= request.getAttribute("TOLEDT") %></button>
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
                <button type="button" class="dropbtn"><%= request.getAttribute("TOLENV") %></button>
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
            
            <div id="hed" class="head" >
                
                <ul class="opbut">
                <li><button type="button" id="getbutbp" onclick="bpbutget();" style="cursor: pointer;display:none;text-align:center;font-size:25px" title="Get Employee Data" >
                        <i class="fas fa-glasses"></i></button></li>
                <li><button type="submit" id="delbutbp" formaction="delbpm" style="cursor: pointer;display:none;text-align:center;font-size:25px" title="Delete Employee" >
                        <i class="fa fa-trash"></i></button></li>
                <li><button type="submit" id="chabutbp" formaction="updtbpm" style="cursor: pointer;display:none;text-align:center;font-size:25px" title="Update Employee" >
                        <i class="fa fa-save"></i></button></li>
                <li><button  type="submit" id="crebutbp" formaction="insertbpm" style="cursor: pointer;display:none;text-align:center;font-size:25px" title="Create Employee" >
                        <i class="fa fa-save"></i></button></li>
                <li><button type="submit" id="bck" formaction="backtohome2" style="cursor: pointer;display:none;text-align:center;font-size:25px">
                        <i class="fa fa-hand-o-left"></i></button></li>
                <!--<li><button type="submit" id="chabutbp" formaction="check" style="cursor: pointer;display:block;text-align:center;font-size:20px" title="Update Employee" >check</button></li>-->
                </ul>
                
                <dialog id="rowdel" class="rowdeldia" >
                    <button type="button" id="rdclbt" onclick="clrdl();" style="float:right;">X</button>
                            <p style="margin-top:20px"><%= request.getAttribute("ASDL") %></p>
                            <button type="button" id="yesrd" onclick="yesrdl();" ><%= request.getAttribute("DIYS") %></button><button type="button" id="nord" onclick="nordl();" ><%= request.getAttribute("DINO") %></button>
                </dialog>
                <dialog id="rowselch" class="rowdeldia" >                    
                            <p style="margin-top:20px"><%= request.getAttribute("ASLRW") %></p>
                            <button type="button" id="oksld" onclick="oksldl();" >Ok</button>
                </dialog>
                <dialog id="dltd" class="rowdeldia" >                    
                            <p style="margin-top:20px"><%= request.getAttribute("DELFLG") %></p>
                            <button type="button" id="dltdbt" onclick="dltd();" >Ok</button>
                </dialog>
                
                <ul class="top">
                 <li><label  for="bpmno" style="width:160px" ><%= request.getAttribute("BPNO") %></label>
                     <input type="text" style="width:53px;" maxlength="7" name="bpmno" title="Enter Employee Number" id="bpmno" /></li>
                 <li><label for="bpdes" style="width:100px" ><%= request.getAttribute("BPDES") %></label><input maxlength="30" style="width:226px;" type="text" name="bpdes" id="bpdes" /></li>
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
                <button type="button" onclick="addrow();"><i class="fa fa-plus-square"></i></button>
                <button type="button" onclick="deleterow();"><i class="fa fa-minus-square"></i></button>
                <!--<button type="submit" formaction="deletbpitm" ><i class="fa fa-minus-square"></i></button>-->

                        <table style="height: 250px;display:block;overflow-x: scroll" id="bpTable" name="bpTable" class="bpTable">
                            <thead style="position:sticky;top: 0;">
                                <tr>
                                    <th></th>
                                    <th><%= request.getAttribute("ITMNO") %></th>
                                    <th><%= request.getAttribute("CNTID") %></th>
                                    <th><%= request.getAttribute("CNTNAM") %></th>
                                    <th><%= request.getAttribute("BPUNT") %></th>
                                    <th><%= request.getAttribute("BPRTE") %></th>
                                    <th><%= request.getAttribute("BPSLUNT") %></th>
                                    <th><%= request.getAttribute("BPSLRTE") %></th>
                                    <th><%= request.getAttribute("CURRN") %></th>
                                    <th><%= request.getAttribute("CNTTYP") %></th>
                                    <th><%= request.getAttribute("MDUL") %></th>
                                    <th><%= request.getAttribute("SPKLNG") %></th>
                                    <th><%= request.getAttribute("PGLNG") %></th>
                                    <th><%= request.getAttribute("SAPEX") %></th>
                                    <th><%= request.getAttribute("ITEX") %></th>
                                </tr>
                            </thead>
                            <tbody style="overflow-y:scroll">
                                <tr>
                                    <td id="col0" name="col0" ><input class="selch" type="checkbox" value="1" onclick="bpcheck();" name="selch" id="selch" /></td>
                                    <td id="col1" name="col1" ><input class="itmno" maxlength="5" size="4" value="1" type="text" name="bpitm" id="bpitm" /></td>
                                    <td id="col2" name="col2" ><input class="bpid"  maxlength="7" size="8" type="text" name="bpid" id="bpid" /></td>
                                    <td id="col3" name="col3" ><input class="bpnam" maxlength="30" size="15" type="text" name="bpnam" id="bpnam" /></td>
                                    <td id="col4" name="col4" ><input class="bpunit" maxlength="5" size="4" type="text" name="bpunit" id="bpunit" /></td>                                    
                                    <td id="col5" name="col5" ><input class="bprate" maxlength="5" size="5" type="text" name="bprate" id="bprate" /></td>
                                    <td id="col6" name="col6" ><input class="bpselunt" maxlength="5" size="4" type="text" name="bpselunt" id="bpselunt" /></td>
                                    <td id="col7" name="col7" ><input class="bpselrat" maxlength="5"size="5" type="text" name="bpselrat" id="bpselrat" /></td>
                                    <td id="col8" name="col8" ><select class="bpcurr" maxlength="3" style="width:80px;" type="text" name="bpcurr" id="bpcurr" >
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
                                    <td id="col9" name="col9" ><select class="bpconstyp" maxlength="3" style="width:100px;" type="text" name="bpconstyp" id="bpconstyp" >
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
                                    <td id="col10" name="col10" ><select class="bpmodu" maxlength="3" style="width:100px;" type="text" name="bpmodu" id="bpmodu" >
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
                                    <td id="col11" name="col11" ><select class="bpsplng" maxlength="3" style="width:100px;" type="text" name="bpsplng" id="bpsplng" >
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
                                    <td id="col12" name="col12" ><select class="bppmglng" maxlength="3" style="width:100px;" type="text" name="bppmglng" id="bppmglng" >
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
                                    <td id="col13" name="col13" ><input class="expsap" maxlength="3" size="3" type="text" name="expsap" id="expsap" /></td>
                                    <td id="col14" name="col14" ><input class="expit" maxlength="3" size="3" type="text" name="expit" id="expit" /></td>
                                </tr>
                            </tbody>
                            
                        </table>
            </div>
                                        
                
                <div id="BD2" class="tabcontent">
                    <ul>
                                              
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
                    <div id="SALD" class="tabcontent">
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
               <td><%=rs2.getString("ACTFLG") %></td>  <!--11-->
               
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
    function bpcheck(){
        var x = document.getElementById("bpTable").getElementsByTagName("tr");
        var higlen = document.getElementsByClassName("selch").length;
        var actlen = higlen - 1;
        var a = 0;
        
        for(var h = 0; h < higlen;h++){
            a = h + 1;
            if(document.getElementsByClassName("selch")[h].checked === true){
                x[a].getElementsByTagName("td")[0].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[1].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[2].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[3].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[4].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[5].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[6].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[7].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[8].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[9].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[10].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[11].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[12].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[13].style.backgroundColor = "red";
                x[a].getElementsByTagName("td")[14].style.backgroundColor = "red";
            }
            else{
                x[a].getElementsByTagName("td")[0].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[1].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[2].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[3].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[4].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[5].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[6].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[7].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[8].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[9].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[10].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[11].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[12].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[13].style.backgroundColor = "#555";
                x[a].getElementsByTagName("td")[14].style.backgroundColor = "#555";
            }
            
        }
    }
</script>

<script>
    if('<%= request.getAttribute("scrn") %>' === 'cre'){
        
         document.getElementById("crebutbp").style.display = "block";
         document.getElementById("chabutbp").style.display = "none";
         document.getElementById("getbutbp").style.display = "none";
         document.getElementById("delbutbp").style.display = "none";
         document.getElementById("bck").style.display = "block";
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
         
         var dlen = document.getElementsByClassName("itmno").length;
         
         for(var d = 0;d < dlen;d++){
            document.getElementsByClassName("itmno")[d].disabled = false;
            document.getElementsByClassName("bpid")[d].disabled = false;
            document.getElementsByClassName("bpnam")[d].disabled = false;
            document.getElementsByClassName("bpunit")[d].disabled = false;
            document.getElementsByClassName("bprate")[d].disabled = false;
            document.getElementsByClassName("bpselunt")[d].disabled = false;
            document.getElementsByClassName("bpselrat")[d].disabled = false;
            document.getElementsByClassName("bpcurr")[d].disabled = false;
            document.getElementsByClassName("bpconstyp")[d].disabled = false;
            document.getElementsByClassName("bpmodu")[d].disabled = false;
            document.getElementsByClassName("bpsplng")[d].disabled = false;
            document.getElementsByClassName("bppmglng")[d].disabled = false;
            document.getElementsByClassName("expsap")[d].disabled = false;
            document.getElementsByClassName("expit")[d].disabled = false;
        }
        
    }
    
    if('<%= request.getAttribute("scrn") %>' === 'cha'){
        
         document.getElementById("crebutbp").style.display = "none";         
         document.getElementById("chabutbp").style.display = "block";
         document.getElementById("getbutbp").style.display = "block";
         document.getElementById("delbutbp").style.display = "none";
         document.getElementById("bck").style.display = "block";
         
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
         
         var dlen = document.getElementsByClassName("itmno").length;
         
         for(var d = 0;d < dlen;d++){
            document.getElementsByClassName("selch")[d].disabled = false;
            document.getElementsByClassName("itmno")[d].disabled = false;
            document.getElementsByClassName("bpid")[d].disabled = false;
            document.getElementsByClassName("bpnam")[d].disabled = false;
            document.getElementsByClassName("bpunit")[d].disabled = false;
            document.getElementsByClassName("bprate")[d].disabled = false;
            document.getElementsByClassName("bpselunt")[d].disabled = false;
            document.getElementsByClassName("bpselrat")[d].disabled = false;
            document.getElementsByClassName("bpcurr")[d].disabled = false;
            document.getElementsByClassName("bpconstyp")[d].disabled = false;
            document.getElementsByClassName("bpmodu")[d].disabled = false;
            document.getElementsByClassName("bpsplng")[d].disabled = false;
            document.getElementsByClassName("bppmglng")[d].disabled = false;
            document.getElementsByClassName("expsap")[d].disabled = false;
            document.getElementsByClassName("expit")[d].disabled = false;
        }
        
    }
    
    if('<%= request.getAttribute("scrn") %>' === 'dis'){
        
         document.getElementById("crebutbp").style.display = "none";
         document.getElementById("chabutbp").style.display = "none";
         document.getElementById("getbutbp").style.display = "block";
         document.getElementById("delbutbp").style.display = "none";
         document.getElementById("bck").style.display = "block";
//         document.gatElementById("bpmno").disabled = true;
         document.getElementById("ccod").disabled = true;
         document.getElementById("bpdes").disabled = true;
         document.getElementById("paytm").disabled = true;
         document.getElementById("bpstdt").disabled = true;
         document.getElementById("bpendt").disabled = true;
         document.getElementById("contyp").disabled = true;
         document.getElementById("bscon").disabled = true;
         document.getElementById("nda").disabled = true;
         document.getElementById("asc").disabled = true;
         document.getElementById("aprvl").disabled = true;
         
         var slen = document.getElementsByClassName("itmno").length;
         
         for(var s = 0;s < slen;s++){
            document.getElementsByClassName("selch")[s].disabled = true;
            document.getElementsByClassName("itmno")[s].disabled = true;
            document.getElementsByClassName("bpid")[s].disabled = true;
            document.getElementsByClassName("bpnam")[s].disabled = true;
            document.getElementsByClassName("bpunit")[s].disabled = true;
            document.getElementsByClassName("bprate")[s].disabled = true;
            document.getElementsByClassName("bpselunt")[s].disabled = true;
            document.getElementsByClassName("bpselrat")[s].disabled = true;
            document.getElementsByClassName("bpcurr")[s].disabled = true;
            document.getElementsByClassName("bpconstyp")[s].disabled = true;
            document.getElementsByClassName("bpmodu")[s].disabled = true;
            document.getElementsByClassName("bpsplng")[s].disabled = true;
            document.getElementsByClassName("bppmglng")[s].disabled = true;
            document.getElementsByClassName("expsap")[s].disabled = true;
            document.getElementsByClassName("expit")[s].disabled = true;
         }
        
    }
    
    if('<%= request.getAttribute("scrn") %>' === 'del'){
        
         document.getElementById("crebutbp").style.display = "none";
         document.getElementById("chabutbp").style.display = "none";
         document.getElementById("getbutbp").style.display = "block";
         document.getElementById("delbutbp").style.display = "block";
         document.getElementById("bck").style.display = "block";
//         document.gatElementById("bpmno").disabled = true;
         document.getElementById("ccod").disabled = true;
         document.getElementById("bpdes").disabled = true;
         document.getElementById("paytm").disabled = true;
         document.getElementById("bpstdt").disabled = true;
         document.getElementById("bpendt").disabled = true;
         document.getElementById("contyp").disabled = true;
         document.getElementById("bscon").disabled = true;
         document.getElementById("nda").disabled = true;
         document.getElementById("asc").disabled = true;
         document.getElementById("aprvl").disabled = true;
         
         var slen = document.getElementsByClassName("itmno").length;
         
         for(var s = 0;s < slen;s++){
            document.getElementsByClassName("selch")[s].disabled = true;
            document.getElementsByClassName("itmno")[s].disabled = true;
            document.getElementsByClassName("bpid")[s].disabled = true;
            document.getElementsByClassName("bpnam")[s].disabled = true;
            document.getElementsByClassName("bpunit")[s].disabled = true;
            document.getElementsByClassName("bprate")[s].disabled = true;
            document.getElementsByClassName("bpselunt")[s].disabled = true;
            document.getElementsByClassName("bpselrat")[s].disabled = true;
            document.getElementsByClassName("bpcurr")[s].disabled = true;
            document.getElementsByClassName("bpconstyp")[s].disabled = true;
            document.getElementsByClassName("bpmodu")[s].disabled = true;
            document.getElementsByClassName("bpsplng")[s].disabled = true;
            document.getElementsByClassName("bppmglng")[s].disabled = true;
            document.getElementsByClassName("expsap")[s].disabled = true;
            document.getElementsByClassName("expit")[s].disabled = true;
         }
        
    }
    
</script>

<script>
    for(var k = 1;k < 7;k++){
         var tabbp = document.getElementById("bpTable");
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
        document.getElementsByClassName("itmno")[prvcol].value = rowcount;
        document.getElementsByClassName("selch")[prvcol].value = rowcount;
    }
    
    
</script>

<script>
    
    function addrow(){
        var tabbp = document.getElementById("bpTable");
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
        document.getElementsByClassName("itmno")[prvcol].value = rowcount;
        document.getElementsByClassName("bpid")[prvcol].focus();
    }
    
    function deleterow(){
        var totchklen = document.getElementsByClassName("selch").length;
        var chlen = totchklen - 1;
        var selch = 0;
        for(var g = 0;g < chlen;g++){
            if(document.getElementsByClassName("selch")[g].checked === true){
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
        
        var totchklen = document.getElementsByClassName("selch").length;
        var chlen = totchklen - 1;
        var selch = 0;
        for(var g = 0;g < chlen;g++){
            if(document.getElementsByClassName("selch")[g].checked === true){
                selch = selch + 1;
            }
            
        }
        
        
            for(var l = 0;l < chlen;l++){
            
            if(document.getElementsByClassName("selch")[l].checked === true){
                
                document.getElementById("bpTable").deleteRow(l + 1);
                var lopchlen = document.getElementsByClassName("selch").length;
                chlen = lopchlen;
                l = l - 1;
                
            }
            
        }
        
     var reitmno = document.getElementsByClassName("itmno").length;
       var m = 0;
       for(var n = 0;n < reitmno;n++){
           m = n + 1;
           document.getElementsByClassName("itmno")[n].value = m;
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
//            if(tabid === 'SALD'){
//              tabcontent[i].style.width = "auto"; 
//            }else{
//              tabcontent[i].style.width = "59.2%";  
//            }
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
        var bpTable = document.getElementById("bpTable");
        var bprowlen = bpTable.rows.length;
        var mstrowlen = msttable.rows.length;
        var col1len = document.getElementsByClassName("itmno").length;
        var colrow = col1len - 1;
        
        for(var z = 0;z < mstrowlen;z++){
            var delbpno = msttable.rows[z].cells[0].innerText;
            if(bpno === delbpno){
            var delactflg = msttable.rows[z].cells[11].innerText;
            }
            
        }
        if(delactflg === 'X'){
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
         
         var slen = document.getElementsByClassName("itmno").length;
         
         for(var s = 0;s < slen;s++){
            document.getElementsByClassName("selch")[s].value = "";
            document.getElementsByClassName("itmno")[s].value = "";
            document.getElementsByClassName("bpid")[s].value = "";
            document.getElementsByClassName("bpnam")[s].value = "";
            document.getElementsByClassName("bpunit")[s].value = "";
            document.getElementsByClassName("bprate")[s].value = "";
            document.getElementsByClassName("bpselunt")[s].value = "";
            document.getElementsByClassName("bpselrat")[s].value = "";
            document.getElementsByClassName("bpcurr")[s].value = "";
            document.getElementsByClassName("bpconstyp")[s].value = "";
            document.getElementsByClassName("bpmodu")[s].value = "";
            document.getElementsByClassName("bpsplng")[s].value = "";
            document.getElementsByClassName("bppmglng")[s].value = "";
            document.getElementsByClassName("expsap")[s].value = "";
            document.getElementsByClassName("expit")[s].value = "";
         }
         
            document.getElementById("dltd").show();
        }else{      
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
          var actflg = msttable.rows[i].cells[11].innerText;
          
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
         var cunt = 0;
        for(var j = 0; j < itmrowlen;j++){
            
          var bpnum = itmtable.rows[j].cells[0].innerText;
          var bpitm = itmtable.rows[j].cells[1].innerText;
          var bpid = itmtable.rows[j].cells[2].innerText;
          var bpnam = itmtable.rows[j].cells[3].innerText;
          var bpunit = itmtable.rows[j].cells[4].innerText;
          var bprate = itmtable.rows[j].cells[5].innerText;
          var bpselunt = itmtable.rows[j].cells[6].innerText;
          var bpselrat = itmtable.rows[j].cells[7].innerText;
          var bpcurr = itmtable.rows[j].cells[8].innerText;
          var bpconstyp = itmtable.rows[j].cells[9].innerText;
          var bpmodu = itmtable.rows[j].cells[10].innerText;
          var bpsplng = itmtable.rows[j].cells[11].innerText;
          var bppmglng = itmtable.rows[j].cells[12].innerText;
          var expsap = itmtable.rows[j].cells[13].innerText;
          var expit = itmtable.rows[j].cells[14].innerText;                    
              
//              for(var k = 0;k < bprowlen;k++){
                
                
                
                  
                  if(bpnum === bpno){
                      
                      if(cunt > colrow){
                    var tabbp = document.getElementById("bpTable");
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
                        document.getElementsByClassName("itmno")[prvcol].value = rowcount;
                        document.getElementsByClassName("selch")[prvcol].value = rowcount;
                    }
                      
                      document.getElementsByClassName("bpid")[cunt].value = bpid;
                      document.getElementsByClassName("bpnam")[cunt].value = bpnam;
                      document.getElementsByClassName("bpunit")[cunt].value = bpunit;
                      document.getElementsByClassName("bprate")[cunt].value = bprate;
                      document.getElementsByClassName("bpselunt")[cunt].value = bpselunt;
                      document.getElementsByClassName("bpselrat")[cunt].value = bpselrat;
                      document.getElementsByClassName("bpcurr")[cunt].value = bpcurr;
                      document.getElementsByClassName("bpconstyp")[cunt].value = bpconstyp;
                      document.getElementsByClassName("bpmodu")[cunt].value = bpmodu;
                      document.getElementsByClassName("bpsplng")[cunt].value = bpsplng;
                      document.getElementsByClassName("bppmglng")[cunt].value = bppmglng;
                      document.getElementsByClassName("expsap")[cunt].value = expsap;
                      document.getElementsByClassName("expit")[cunt].value = expit;
                      
                      cunt = cunt + 1;
                  }                  
                  
//              }
                                    
        }
        
//        foor
            for(var cunt1 = cunt;cunt1 < col1len;cunt1++){
            document.getElementsByClassName("bpid")[cunt1].value = "";
            document.getElementsByClassName("bpnam")[cunt1].value = "";
            document.getElementsByClassName("bpunit")[cunt1].value = "";
            document.getElementsByClassName("bprate")[cunt1].value = "";
            document.getElementsByClassName("bpselunt")[cunt1].value = "";
            document.getElementsByClassName("bpselrat")[cunt1].value = "";
            document.getElementsByClassName("bpcurr")[cunt1].value = "";
            document.getElementsByClassName("bpconstyp")[cunt1].value = "";
            document.getElementsByClassName("bpmodu")[cunt1].value = "";
            document.getElementsByClassName("bpsplng")[cunt1].value = "";
            document.getElementsByClassName("bppmglng")[cunt1].value = "";
            document.getElementsByClassName("expsap")[cunt1].value = "";    
            document.getElementsByClassName("expit")[cunt1].value = "";
        }
        
    }
//        end
        
    }
    
    function dltd(){
        document.getElementById("dltd").close();
    }
</script>


    </body>
</html>
