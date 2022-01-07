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
<%@page import="com.agnie.controller.inquiry2" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inquiry Page</title>
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
    margin-right: 10px
}

.head{
	display:block;
        margin:20px
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
  width: 79.3%;
  
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
        <form  method="post">
        <header>
            
            <button  formaction="backtohome1" style="color:white;margin: 10px;background-color: transparent;cursor: pointer">
                <i class="fa fa-angle-double-left"></i></button>
        
        </header>
            <div class="mbar" >
      <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("INQ") %></button>
                <div id="drpcnt" class="dropdown-content">
                    <li><button onclick="Create()" formaction="inqcre" class="menu" ><%= request.getAttribute("INCRE") %></button></li>
                    <li><button onclick="Edit()" formaction="inqcha" class="menu" ><%= request.getAttribute("INEDT") %></button></li>
                    <li><button onclick="Display()" formaction="inqdis" class="menu" ><%= request.getAttribute("INDIS") %></button></li>
                    <li><button onclick="List();" class="menu" ><%= request.getAttribute("INLST") %></button></li>
                    <li><button onclick="Exit();" class="menu" ><%= request.getAttribute("EXT") %></button></li>
                </div>
            </div>  
        <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("EDT") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" ><%= request.getAttribute("INCRE") %></button></li>
                 <li><button  class="menu" ><%= request.getAttribute("INEDT") %></button></li>
                 <li><button  class="menu" ><%= request.getAttribute("INDIS") %></button></li>
                </div>
            </div>
        <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("GOTO") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" ><%= request.getAttribute("INCRE") %></button></li>
                  <li><button  class="menu" ><%= request.getAttribute("INEDT") %></button></li>
                 <li><button  class="menu" ><%= request.getAttribute("INDIS") %></button></li>
                </div>
            </div>
            <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("ENV") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" ><%= request.getAttribute("INCRE") %></button></li>
                 <li><button  class="menu" ><%= request.getAttribute("INEDT") %></button></li>
                 <li><button  class="menu" ><%= request.getAttribute("INDIS") %></button></li>
                </div>
            </div>
            <div class="dropdown">
                <button  class="dropbtn"><%= request.getAttribute("SYS") %></button>
                <div id="drpcnt" class="dropdown-content">
                 <li><button  class="menu" ><%= request.getAttribute("INCRE") %></button></li>
                 <li><button  class="menu" ><%= request.getAttribute("INEDT") %></button></li>
                 <li><button  class="menu" ><%= request.getAttribute("INDIS") %></button></li>
                </div>
            </div>
    </div>
<div id="hed" class="head" >
    
<!--    <form action="insert" method="post"> -->
                <ul class="opbut">
            <li><button type="button" id="btnget" onclick="butget();" style="display:none;text-align:center;font-size:20px"  title=<%= request.getAttribute("GET") %> ><i class="fas fa-glasses"></i></button></li>
            <li><button type="submit" id="btndel" formaction="delinq" style="display:none;text-align:center;font-size:20px" title=<%= request.getAttribute("DLT") %> ><i class="fa fa-trash"></i></button></li>
            <li><button type="submit" id="btnedt" formaction="updtinq" style="display:none;text-align:center;font-size:20px" title=<%= request.getAttribute("UPD") %> ><i class="fa fa-save"></i></button></li>
            <li><button  type="submit" id="btncre" formaction="insertinq" style="display:block;text-align:center;font-size:20px" title=<%= request.getAttribute("SAV") %> ><i class="fa fa-save"></i></button></li>
        </ul>
        
        <ul class="top">
            <input type="text" style="width:53px;" maxlength="7" name="weblng" id="weblng" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="scrn" id="scrn" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="emnum" id="emnum" hidden>
          <li><label for="inqno" style="width:60px"><%= request.getAttribute("INQ") %>  </label> <input type="text" name="inqno" maxlength="7" style="width:65px" id="inqno" > </li>                
          <li><label for="ccod" style="width:120px"><%= request.getAttribute("CMPNY") %> </label> <input type="text" name="ccod" maxlength="4" style="width:40px" id="ccod"></li>
          <li><label for="empno" style="width:80px"><%= request.getAttribute("EMP") %>  </label> <input type="text" name="empno" maxlength="7" style="width:65px" id="empno"></li>
          <li><label for="prjdes" style="width:150px"><%= request.getAttribute("PRTXT") %> </label> <input type="text" maxlength="30" size="30"name="prjdes" id="prjdes"></li> <br>
        </ul>
        <div class="tabs">
        <button type="button" class="tablink" id="T1" onclick="openPage(this.id)"><%= request.getAttribute("D1") %></button>
        <button type="button" class="tablink" id="T2" onclick="openPage(this.id)"><%= request.getAttribute("D2") %></button>
        <button type="button"  class="tablink" id="T3" onclick="openPage(this.id)"><%= request.getAttribute("EST") %></button>
        <button type="button" class="tablink" id="T4" onclick="openPage(this.id)"><%= request.getAttribute("ORGD") %> </button>
        </div>
<div id="T1" class="tabcontent">
  <!--<h3> Data1</h3>-->
  <%
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      Connection con1 = null;
                      Statement stm = null;
  %>
  <ul>
        <label for="assnper"><%= request.getAttribute("ASSN") %></label> <input type="text" name="assnper" maxlength="4" size="4" id="assnper" ><br>
        <label for="bizid"><%= request.getAttribute("BZLN") %> </label> <!-- <input type="text" name="bizid" maxlength="4" size="4" id="bizid" > <br> -->
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
        <label for="modul"><%= request.getAttribute("MOD") %> </label> <!-- <input type="text" name="modul" maxlength="4" size="4" id="modul" >  -->
        <select maxlength="2" style="width:125px;text-transform:uppercase" type="text" id="modul" name="modul" >
            <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Module";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("MODUL")%>"><%=rs2.getString("MOD_TEXT")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
          </select>   <br>
        <label for="lngid"><%= request.getAttribute("LNG") %>  </label>  <!--  <input type="text" name="lngid" maxlength="4" size="4" id="lngid" > -->
                  <select maxlength="2" style="width:100px;text-transform:uppercase" type="text" id="lngid" name="lngid" >
            <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Language_Master";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("LNGID")%>"><%=rs2.getString("LNG_TEXT")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
          </select> <br>
        <label for="posbper"><%= request.getAttribute("POSB") %> </label> <input type="text" name="posbper" maxlength="4" size="4" id="posbper" >
      </ul>  
</div>
  <div id="T2" class="tabcontent">
  <!--<h3> Data2</h3>-->
     <ul>
         <label for="frndt"><%= request.getAttribute("STDT") %></label> <input type="date" name="frmdt" style="width: 135px" id="frmdt" ><br>
          <label for="todt"><%= request.getAttribute("ENDT") %></label> <input type="date" name="todt" style="width: 135px" id="todt" ><br>
          <label for="status"><%= request.getAttribute("STAT") %>  </label> <input type="text" name="status" maxlength="20" size="20" id="status" ><br>
          <label for="phaseid"><%= request.getAttribute("PHAS") %>  </label> <!-- <input type="text" name="phase" maxlength="30" size="30" id="phase" ><br>  -->
                <select maxlength="2" style="width:120px;text-transform:uppercase" width="180px" type="text" id="phaseid" name="phaseid" >
            <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Phase";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("PHASEID")%>"><%=rs2.getString("PHASE")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
          </select>
          </ul>
</div>

<div id="T3" class="tabcontent">
  <!--<h3>Estimation Detail</h3>-->
  <ul>
           <label for="estamt"><%= request.getAttribute("ESTA") %> </label> <input type="text" name="estamt" maxlength="12" size="12" id="estamt" ><br>
           <label for="curr"><%= request.getAttribute("CUR") %>  </label>  <input type="text" name="curr" maxlength=3" size="3" id="curr" ><br>
           <label for="taxamt"><%= request.getAttribute("TAX") %>  </label> <input type="text" name="taxamt" maxlength="12" size="12" id="taxamt" ><br>
           <label for="qty"><%= request.getAttribute("QNTY") %>  </label> <input type="text" name="qty" maxlength=3" size="3" id="qty" ><br>
           <label for="rate"><%= request.getAttribute("RTE") %>  </label> <input type="text" name="rate" maxlength=3" size="3" id="rate" ><br>
           <label for="unit"><%= request.getAttribute("UNT") %>  </label> <input type="text" name="unit" maxlength="12" size="12" id="unit" >
  </ul>
</div>

<div id="T4" class="tabcontent">
  <!--<h3>Organization Detail</h3>-->
  <ul>
     <label for="custno"><%= request.getAttribute("CUST") %>  </label> <input type="text" name="custno" maxlength="7" size="7" id="custno"><br>
     <label for="eusrno"><%= request.getAttribute("EUSR") %> </label> <input type="text" name="eusrno" maxlength="7" size="7" id="eusrno" ><br>
     <label for="custinfo"><%= request.getAttribute("CINFO") %>  </label> <input type="text" name="custinfo" maxlength="30" size="30" id="custinfo" ><br>
     <label for="remarks"><%= request.getAttribute("RMKS") %>  </label> <input type="text" name="remarks" maxlength="30" size="30" id="remarks" ><br>
<!--     <label for="credt">Creation Date  </label> <input type="date" name="credt" style="width: 135px" id="credt" ><br>
     <label for="cretim">Creation Time  </label> <input type="time" name="cretm" id="cretim" ><br>--> 
</ul>
</div>
    
</div>

<table style="display:none;overflow-x: auto" id="myTable" name="myTable" class="myTable">
            
           <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String sqllst = "SELECT * FROM Inquiry";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(sqllst);
                      while(rs2.next())
                      {
                          %>
               <tr>
               <td><%=rs2.getString("INQNO") %></td> <!--0-->
               <td><%=rs2.getString("CCOD") %></td>   <!--1-->
               <td><%=rs2.getString("EMPNO") %></td> <!--2-->
               <td><%=rs2.getString("ASSNPER") %></td>  <!--3-->
               <td><%=rs2.getString("BIZID") %></td>  <!--4-->
               <td><%=rs2.getString("MODUL") %></td>  <!--5-->
               <td><%=rs2.getString("LNGID") %></td>  <!--6-->
               <td><%=rs2.getString("FRMDT") %></td>   <!--7-->
               <td><%=rs2.getString("TODT") %></td>   <!--8-->
               <td><%=rs2.getString("POSBPER") %></td>   <!--9-->
               <td><%=rs2.getString("PRJDES") %></td>  <!--10-->
               <td><%=rs2.getString("PRJSTS") %></td>    <!--11-->
               <td><%=rs2.getString("PHASEID") %></td>   <!--12-->
               <td><%=rs2.getString("ESTMAMT") %></td>   <!--13-->
               <td><%=rs2.getString("CURR") %></td>   <!--14-->
               <td><%=rs2.getString("TAXAMT") %></td>   <!--15-->
               <td><%=rs2.getString("QTY") %></td>   <!--16-->
               <td><%=rs2.getString("RATE") %></td>   <!--17-->
               <td><%=rs2.getString("UNIT") %></td>   <!--18-->
               <td><%=rs2.getString("CUSTNO") %></td>   <!--19-->
               <td><%=rs2.getString("EUSRNO") %></td>   <!--20-->
               <td><%=rs2.getString("CUSTINFO") %></td>   <!--21-->
               <td><%=rs2.getString("REMARKS") %></td>   <!--22-->               
               
               
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
                  </script>                 
<script>

function butget(){
          var inq = document.getElementById("inqno").value;
          var input, filter, table, tr, td, i, txtValue;
          table = document.getElementById("myTable");
          var rowlen = table.rows.length;
          tr = table.getElementsByTagName("tr");
          for (i = 0; i < rowlen; i++) {
              
          var inqno = table.rows[i].cells[0].innerText;
          var ccod = table.rows[i].cells[1].innerText;
          var empno = table.rows[i].cells[2].innerText;
          var assnper = table.rows[i].cells[3].innerText;
          var bizid = table.rows[i].cells[4].innerText;
          var modul = table.rows[i].cells[5].innerText;
          var lngid = table.rows[i].cells[6].innerText;
          var frmdt = table.rows[i].cells[7].innerText;
          var todt = table.rows[i].cells[8].innerText;
          var posbper = table.rows[i].cells[9].innerText;
          var prjdes = table.rows[i].cells[10].innerText;
          var status = table.rows[i].cells[11].innerText;
          var phaseid = table.rows[i].cells[12].innerText;
          var estamt = table.rows[i].cells[13].innerText;
          var curr = table.rows[i].cells[14].innerText;
          var taxamt = table.rows[i].cells[15].innerText;
          var qty = table.rows[i].cells[16].innerText;
          var rate = table.rows[i].cells[17].innerText;
          var unit = table.rows[i].cells[18].innerText;
          var custno = table.rows[i].cells[19].innerText;
          var eusrno = table.rows[i].cells[20].innerText;
          var custinfo = table.rows[i].cells[21].innerText;
          var remarks = table.rows[i].cells[22].innerText;
          
         if(inq === inqno){
         document.getElementById('ccod').value = ccod;
         document.getElementById('empno').value = empno;         
         
         document.getElementById('assnper').value = assnper;
         document.getElementById('bizid').value = bizid;
         document.getElementById('modul').value = modul;
         document.getElementById('lngid').value = lngid;
         document.getElementById('frmdt').value = frmdt;
         document.getElementById('todt').value = todt;
         
         document.getElementById('posbper').value = posbper;
         document.getElementById('prjdes').value = prjdes;
         document.getElementById('status').value = status;
         document.getElementById('phaseid').value = phaseid;
         document.getElementById('estamt').value = estamt;
         document.getElementById('curr').value = curr;
         document.getElementById('taxamt').value = taxamt;
         document.getElementById('qty').value = qty;
         document.getElementById('rate').value = rate;
         document.getElementById('unit').value = unit;
         document.getElementById('custno').value = custno;
         document.getElementById('eusrno').value = eusrno;
         document.getElementById('custinfo').value = custinfo;
         document.getElementById('remarks').value = remarks;
         
            }
              
          }
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
    //Current Date and Time
//    var today = new Date();
//    var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
//    document.getElementById("credt").value = date;
</script>

<script>
//    document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
         if(<%= request.getAttribute("appnm") %> === 1){
              
        alert("Inquiry "+<%= request.getAttribute("inqno") %>+"  created successfully");
        
        
        }
 </script>
  
 <script>
//     document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';

    if(<%= request.getAttribute("getnm") %> === 2){
         
         document.getElementById('inqno').value = '<%= request.getAttribute("inqno1") %>';
         document.getElementById('ccod').value = '<%= request.getAttribute("ccod") %>';
         document.getElementById('empno').value = '<%= request.getAttribute("empno") %>';        
         document.getElementById('assnper').value = '<%= request.getAttribute("assnper") %>';
         document.getElementById('bizid').value = '<%= request.getAttribute("bizid") %>';
         document.getElementById('modul').value = '<%= request.getAttribute("modul") %>';
         document.getElementById('lngid').value = '<%= request.getAttribute("lngid") %>';
         document.getElementById('frmdt').value = '<%= request.getAttribute("frmdt") %>';         
         document.getElementById('todt').value = '<%= request.getAttribute("todt") %>';         
         document.getElementById('posbper').value = '<%= request.getAttribute("posbper") %>';
         document.getElementById('prjdes').value = '<%= request.getAttribute("prjdes") %>';          
         document.getElementById('status').value = '<%= request.getAttribute("status") %>';
         document.getElementById('phaseid').value = '<%= request.getAttribute("phaseid") %>';
         document.getElementById('estamt').value = '<%= request.getAttribute("estamt") %>';
         document.getElementById('curr').value = '<%= request.getAttribute("curr") %>';
         document.getElementById('taxamt').value = '<%= request.getAttribute("taxamt") %>';
         document.getElementById('qty').value = '<%= request.getAttribute("qty") %>';
         document.getElementById('rate').value = '<%= request.getAttribute("rate") %>';
         document.getElementById('unit').value = '<%= request.getAttribute("unit") %>';
         document.getElementById('custno').value = '<%= request.getAttribute("custno") %>';
         document.getElementById('eusrno').value = '<%= request.getAttribute("eusrno") %>';
         document.getElementById('custinfo').value = '<%= request.getAttribute("custinfo") %>';      
         document.getElementById('remarks').value = '<%= request.getAttribute("remarks") %>';
        
     }
 </script>
 
 <script>
   
//   document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
        if('<%= request.getAttribute("delet") %>' === 'DEL'){
            alert("Record Deleted Successfully");
//            window.location.reload();
            
        }
        
 </script>
 <script>
//      document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
        if('<%= request.getAttribute("updtinq") %>' === 'UPD'){
           alert("Record Updated Successfully");
      //       alert("Inquiry "+<%= request.getAttribute("inqno1") %>+"  Updated successfully");
//            window.location.reload();
            
        }
        
 </script>

 <script>
//     document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
//     Create Funtion
      function Create(){
        document.getElementById("scrn").value = "cre";
         document.getElementById("btncre").style.display = "block";
         document.getElementById("btnedt").style.display = "none";
         document.getElementById("btnget").style.display = "none";
         document.getElementById("btndel").style.display = "none";
         document.getElementById("inqno").required = true;
         document.getElementById('ccod').disabled = false;
         document.getElementById('empno').disabled = false;         
         
         document.getElementById('assnper').disabled = false;
         document.getElementById('bizid').disabled = false;
         document.getElementById('modul').disabled = false;
         document.getElementById('lngid').disabled = false;
         document.getElementById('frmdt').disabled = false;
         document.getElementById('todt').disabled = false;
         
         document.getElementById('posbper').disabled = false;
         document.getElementById('prjdes').disabled = false;
         document.getElementById('status').disabled = false;
         document.getElementById('phaseid').disabled = false;
         document.getElementById('estamt').disabled = false;
         document.getElementById('curr').disabled = false;
         document.getElementById('taxamt').disabled = false;
         document.getElementById('qty').disabled = false;
         document.getElementById('rate').disabled = false;
         document.getElementById('unit').disabled = false;
         document.getElementById('custno').disabled = false;
         document.getElementById('eusrno').disabled = false;
         document.getElementById('custinfo').disabled = false;
         document.getElementById('remarks').disabled = false;
      }
     
     
//     Change/Edit Function   
     function Edit(){
         document.getElementById("scrn").value = "edt";
         document.getElementById("btncre").style.display = "none";
         document.getElementById("btnedt").style.display = "block";
         document.getElementById("btnget").style.display = "block";
         document.getElementById("btndel").style.display = "block";
//         document.getElementById("inqno").required = true;
         document.getElementById('ccod').disabled = false;
         document.getElementById('empno').disabled = false;         
         
         document.getElementById('assnper').disabled = false;
         document.getElementById('bizid').disabled = false;
         document.getElementById('modul').disabled = false;
         document.getElementById('lngid').disabled = false;
         document.getElementById('frmdt').disabled = false;
         document.getElementById('todt').disabled = false;
         
         document.getElementById('posbper').disabled = false;
         document.getElementById('prjdes').disabled = false;
         document.getElementById('status').disabled = false;
         document.getElementById('phaseid').disabled = false;
         document.getElementById('estamt').disabled = false;
         document.getElementById('curr').disabled = false;
         document.getElementById('taxamt').disabled = false;
         document.getElementById('qty').disabled = false;
         document.getElementById('rate').disabled = false;
         document.getElementById('unit').disabled = false;
         document.getElementById('custno').disabled = false;
         document.getElementById('eusrno').disabled = false;
         document.getElementById('custinfo').disabled = false;
         document.getElementById('remarks').disabled = false;
     }
     
//     Display Function
         function Display(){
         document.getElementById("scrn").value = "dis";
         document.getElementById("btncre").style.display = "none";
         document.getElementById("btnedt").style.display = "none";
         document.getElementById("btnget").style.display = "block";
         document.getElementById("btndel").style.display = "none";
//         document.getElementById("inqno").required = true;
         document.getElementById('ccod').disabled = true;
         document.getElementById('empno').disabled = true;         
         
         document.getElementById('assnper').disabled = true;
         document.getElementById('bizid').disabled = true;
         document.getElementById('modul').disabled = true;
         document.getElementById('lngid').disabled = true;
         document.getElementById('frmdt').disabled = true;
         document.getElementById('todt').disabled = true;
         
         document.getElementById('posbper').disabled = true;
         document.getElementById('prjdes').disabled = true;
         document.getElementById('status').disabled = true;
         document.getElementById('phaseid').disabled = true;
         document.getElementById('estamt').disabled = true;
         document.getElementById('curr').disabled = true;
         document.getElementById('taxamt').disabled = true;
         document.getElementById('qty').disabled = true;
         document.getElementById('rate').disabled = true;
         document.getElementById('unit').disabled = true;
         document.getElementById('custno').disabled = true;
         document.getElementById('eusrno').disabled = true;
         document.getElementById('custinfo').disabled = true;
         document.getElementById('remarks').disabled = true;
         }

     
 </script>
 
  <script>
    
      
       if('<%= request.getAttribute("scrn") %>' === 'cre'){
         document.getElementById("scrn").value = "cre";
         document.getElementById("btncre").style.display = "block";
         document.getElementById("btnedt").style.display = "none";
         document.getElementById("btnget").style.display = "none";
         document.getElementById("btndel").style.display = "none";
//         document.getElementById("inqno").required = false;
         document.getElementById('ccod').disabled = false;
         document.getElementById('empno').disabled = false;         
         
         document.getElementById('assnper').disabled = false;
         document.getElementById('bizid').disabled = false;
         document.getElementById('modul').disabled = false;
         document.getElementById('lngid').disabled = false;
         document.getElementById('frmdt').disabled = false;
         document.getElementById('todt').disabled = false;
         
         document.getElementById('posbper').disabled = false;
         document.getElementById('prjdes').disabled = false;
         document.getElementById('status').disabled = false;
         document.getElementById('phaseid').disabled = false;
         document.getElementById('estamt').disabled = false;
         document.getElementById('curr').disabled = false;
         document.getElementById('taxamt').disabled = false;
         document.getElementById('qty').disabled = false;
         document.getElementById('rate').disabled = false;
         document.getElementById('unit').disabled = false;
         document.getElementById('custno').disabled = false;
         document.getElementById('eusrno').disabled = false;
         document.getElementById('custinfo').disabled = false;
         document.getElementById('remarks').disabled = false;
         
//         document.getElementById("inqno").value = "";
//         document.getElementById('ccod').value = "";
//         document.getElementById('empno').value = "";         
//         
//         document.getElementById('assnper').value = "";
//         document.getElementById('bizid').value = "";
//         document.getElementById('modul').value = "";
//         document.getElementById('lngid').value = "";
//         document.getElementById('frmdt').value = "";
//         document.getElementById('todt').value = "";
//         
//         document.getElementById('posbper').value = "";
//         document.getElementById('prjdes').value = "";
//         document.getElementById('status').value = "";
//         document.getElementById('phaseid').value = "";
//         document.getElementById('estamt').value = "";
//         document.getElementById('curr').value = "";
//         document.getElementById('taxamt').value = "";
//         document.getElementById('qty').value = "";
//         document.getElementById('rate').value = "";
//         document.getElementById('unit').value = "";
//         document.getElementById('custno').value = "";
//         document.getElementById('eusrno').value = "";
//         document.getElementById('custinfo').value = "";
//         document.getElementById('remarks').value = "";
           
       }
      
      
       if('<%= request.getAttribute("scrn") %>' === 'edt'){
           document.getElementById("scrn").value = "edt";
         document.getElementById("btncre").style.display = "none";
         document.getElementById("btnedt").style.display = "block";
         document.getElementById("btnget").style.display = "block";
         document.getElementById("btndel").style.display = "block";
//         document.getElementById("inqno").required = true;
         document.getElementById('ccod').disabled = false;
         document.getElementById('empno').disabled = false;         
         
         document.getElementById('assnper').disabled = false;
         document.getElementById('bizid').disabled = false;
         document.getElementById('modul').disabled = false;
         document.getElementById('lngid').disabled = false;
         document.getElementById('frmdt').disabled = false;
         document.getElementById('todt').disabled = false;
         
         document.getElementById('posbper').disabled = false;
         document.getElementById('prjdes').disabled = false;
         document.getElementById('status').disabled = false;
         document.getElementById('phaseid').disabled = false;
         document.getElementById('estamt').disabled = false;
         document.getElementById('curr').disabled = false;
         document.getElementById('taxamt').disabled = false;
         document.getElementById('qty').disabled = false;
         document.getElementById('rate').disabled = false;
         document.getElementById('unit').disabled = false;
         document.getElementById('custno').disabled = false;
         document.getElementById('eusrno').disabled = false;
         document.getElementById('custinfo').disabled = false;
         document.getElementById('remarks').disabled = false;
           
       }
       
       if('<%= request.getAttribute("scrn") %>' === 'dis'){
         document.getElementById("scrn").value = "dis";
         document.getElementById("btncre").style.display = "none";
         document.getElementById("btnedt").style.display = "none";
         document.getElementById("btnget").style.display = "block";
         document.getElementById("btndel").style.display = "none";
//         document.getElementById("inqno").required = true;
         document.getElementById('ccod').disabled = true;
         document.getElementById('empno').disabled = true;         
         
         document.getElementById('assnper').disabled = true;
         document.getElementById('bizid').disabled = true;
         document.getElementById('modul').disabled = true;
         document.getElementById('lngid').disabled = true;
         document.getElementById('frmdt').disabled = true;
         document.getElementById('todt').disabled = true;
         
         document.getElementById('posbper').disabled = true;
         document.getElementById('prjdes').disabled = true;
         document.getElementById('status').disabled = true;
         document.getElementById('phaseid').disabled = true;
         document.getElementById('estamt').disabled = true;
         document.getElementById('curr').disabled = true;
         document.getElementById('taxamt').disabled = true;
         document.getElementById('qty').disabled = true;
         document.getElementById('rate').disabled = true;
         document.getElementById('unit').disabled = true;
         document.getElementById('custno').disabled = true;
         document.getElementById('eusrno').disabled = true;
         document.getElementById('custinfo').disabled = true;
         document.getElementById('remarks').disabled = true;
           
       }
       
 </script>
 
    </body>
</html>

