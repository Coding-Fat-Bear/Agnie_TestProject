<%-- 
    Document   : inquiryview
    Created on : Nov 22, 2021, 5:08:05 PM
    Author     : Admin
--%>

<%@page import="java.lang.String"%>
<%@page import="java.sql.PreparedStatement"%>
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
<%@page import="com.agnie.controller.PurchaseOrder" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchase Order Page</title>
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
  width: 984px;
  
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
  width: 985px;
  
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
        <h1 align="center">Purchase Order</h1>
      </header>
        <form method="post">
            <div class="mbar" >
      <div class="dropdown">
                <button  class="dropbtn">Purchase Order</button>
                <div id="drpcnt" class="dropdown-content">
                    <li><button  formaction="pocre" class="menu" style="cursor: pointer" >Create</button></li>
                    <li><button  formaction="pocha" class="menu" style="cursor: pointer" >Change</button></li>
                    <li><button  formaction="podis" class="menu" style="cursor: pointer" >Display</button></li>
                    <li><button  formaction="podel" class="menu" style="cursor: pointer" >Delete</button></li>
                    <li><button  formaction="poprint" class="menu" style="cursor: pointer" >Print</button></li>
                </div>
            </div>  
        <div class="dropdown">
                <button  class="dropbtn">Edit</button>
            </div>
        <div class="dropdown">
                <button  class="dropbtn">Goto</button>
            </div>
            <div class="dropdown">
                <button  class="dropbtn">Environment</button>
            </div>
            <div class="dropdown">
                <button  class="dropbtn">System</button>
            </div>   
    </div>
<!--        <div>
            <button type="submit" onclick="window.location='index.jsp'" style="float:left;margin-bottom:10px;font-size:25px;margin-right:20px" title=Back><i class="fa fa-arrow-circle-left"></i></button>
       </div>-->
<div id="hed" class="head" >
    <!--<form action="insert" method="post">--> 
                <ul class="opbut">                    
                    <li><button type="submit" id="pobtncre" formaction="insertpo" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=CreatePO><i class="fa fa-save"></i></button></li>
                    <li><button type="button" id="pobtnget" onclick="pobutget()" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=Get><i class="fas fa-glasses"></i></i></button></li>
                    <li><button type="submit" id="pobtnedt" formaction="updtpo" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=Update ><i class="fa fa-save"></i></button></li>
                    <li><button type="submit" id="pobtndel" formaction="delpo" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=Delete ><i class="fa fa-trash"></i></button></li>                            
                    <li><button type="submit" id="pobtnbck" onclick="window.location='index.jsp'" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=Back><i class="fa fa-hand-o-left"></i></button></li>   
                    <li><button type="button" id="pobtnprnt" onclick="prntpo()" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=Print ><i class="fa fa-print"></i></button></li>
                    <li><button type="button" id="pobtnmail" onclick="EmailPo()" style="display:none;cursor: pointer;text-align:center;font-size:25px" title=SendEmail ><i class="fa fa-envelope"></i></button></li>
                </ul>
      <div id="modal" class="modal">
        <div class="modal-content">
            <br>
            <span class="close">&times;</span> 
             <form action="mailto:mahesh.k@agnieindia.com" method="post" enctype="text/plain">
               Name:<br>
              <input type="text" name="name"><br>
              Comment:<br>
              <input type="text" name="comment" size="50"><br><br>
              <input type="submit" name="send" value="Send">
              <input type="reset" name="reset" value="Reset">
             </form>
        </div>
      </div>
        <ul class="top">
            <input type="text" style="width:53px;" maxlength="7" name="weblng" id="weblng" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="scrn" id="scrn" hidden>
          <li><label for="ponum" style="width:135px">Purchase Order No </label> <input type="text" name="ponum" maxlength="10" size="10" id="ponum"> </li>                
        </ul>
    <!--- Purchase Order Header Details Tabs -->
    <div class="htabs">
        <button type="button" class="htablinks" id="HT1" onclick="OpenPage(this.id)">PO Header</button>
        <button type="button" class="htablinks" id="HT2" onclick="OpenPage(this.id)">PO Terms </button>
        <button type="button"  class="htablinks" id="HT3" onclick="OpenPage(this.id)">PO Info </button>
        <button type="button"  class="htablinks" id="HT4" onclick="OpenPage(this.id)">PO Texts </button>
    </div>
       <div id="HT1" class="tabcontents">
               <%
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      Connection con1 = null;
                      Statement stm = null;
               %>
        <ul>
        <label for="ccod">Company Code</label> <input type="text" name="ccod" maxlength="4" size="4" id="ccod"> <br>     
         <label for="cntrtyp">Contract Type </label> 
            <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="cntrtyp" name="cntrtyp" >
            <option value="" disabled selected></option>
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
         <label for="inqno">Inquiry No</label> <input type="text" name="inqno" maxlength="7" size="7" id="inqno" ><br>   
         <label for="prjno">Project No</label> <input type="text" name="prjno" size="9" maxlength="9" id="prjno"><br>        
         <label for="bpestno">Estimation No</label> <input type="text" name="bpestno" maxlength="7" size="7" id="bpestno" ><br>
        </ul> 
    </div>   
    <div id="HT2" class="tabcontents">
        <ul>
          <label for="pofrmdt">PO Validity Start Date</label> <input type="date" name="pofrmdt" style="width: 135px;text-transform:uppercase" id="pofrmdt" ><br>
          <label for="poendt">PO Validity End Date</label> <input type="date" name="poendt" style="width: 135px;text-transform:uppercase" id="poendt" ><br>    
            <label for="cnsmptax">Consumption Tax </label> <!--<input type="text" name="taxcode" id="taxcode" size="4"> <br> -->
            <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="cnsmptax" name="cnsmptax" onblur="calc()" >
            <option value="" disabled selected></option>
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
            <label for="paytrms">Payment Terms</label> <!-- <input type="text" name="paytrms" size="5" maxlength="5" id="paytrms"><br> -->    
            <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="paytrms" name="paytrms">
            <option value="" disabled selected></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Payment_Terms";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("PAYTRMS")%>"><%=rs2.getString("PAYTXT")%></option>
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
     <ul>
      <label for="delloc">Delivery Place </label> <!-- <input type="text" name="dellocid" maxlength="20" size="20" id="dellocid" ><br> -->
             <select maxlength="4" style="width:120px;text-transform:uppercase" type="text" id="delloc" name="delloc" >
            <option value="" disabled selected></option>
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
            
            <label for="delvrbls">Deliverables </label> <!-- <input type="text" name="delvrblid" maxlength="20" size="20" id="delvrblid" ><br> -->
             <select maxlength="5" style="width:120px;text-transform:uppercase" type="text" id="delvrbls" name="delvrbls" >
            <option value="" disabled selected></option>
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
      <label for="postatus">PO Status</label> <input type="text" name="postatus" maxlength="30" size="25" id="postatus" ><br>        
     </ul>
    </div>        
    <div id="HT4" class="tabcontents">
     <ul>   
      <label for="pohtxt">PO Header Text  </label> <textarea class="form-control rounded-0" id="pohtxt" name="pohtxt" rows="1"></textarea> <br>
      <label for="poitxt">PO Item Text </label> <textarea class="form-control rounded-0" id="poitxt" name="poitxt" rows="2"></textarea> <br>
      <label for="potxts">PO Other Texts </label> <textarea class="form-control rounded-0" id="potxts" name="potxts" rows="3"></textarea> <br>
     </ul>
    </div>
            
            <br>   
    <!--- Purchase Order Item Details Tabs -->
        <div class="tabs">
        <button type="button" class="tablink" id="T1" onclick="openPage(this.id)">Purchase Items</button>
        <!--<button type="button" class="tablink" id="T2" onclick="openPage(this.id)">Purchase Info</button>-->
        <!--<button type="button"  class="tablink" id="T3" onclick="openPage(this.id)">Purchase Terms</button>-->
        <!--<button type="button" class="tablink" id="T4" onclick="openPage(this.id)">Purchase Texts </button>-->
        </div>  
<div id="T1" class="tabcontent">
  <ul>
            <button type="button" onclick="addRows();"><i class="fa fa-plus-square"></i></button>
            <button type="button" onclick="deleteRows();"><i class="fa fa-minus-square"></i></button>
         <table style="height: 255px;display:block;overflow-x: scroll;width: 975px;" id="potbl" name="potbl" class="potbl">
             <thead style="position: sticky;top: 0" id="thd">
            <tr>
              <th></th>  
              <th>Item</th> 
              <th>Business Partner</th>
              <th>Consultant</th>
              <th>Unit</th>
              <th>Quantity</th>
              <th>Rate</th>
              <th>Total</th> 
              <!--<th>Delete</th>-->
            </tr>                             
             </thead>
             <tbody style="overflow-y: scroll">
            <tr>
                <td id="col0"><input class="check" type="checkbox" onclick="selectedRow()" id="check" name="check" size="4"></td>
                <td id="col1"><input class="poitem" type="text" id="poitem" name="poitem" size="9" value="1"  ></td>
                <td id="col2"><select maxlength="9" style="width:175px;text-transform:uppercase" class="bpno" type="text" id="bpno" name="bpno" onchange="BpCnslt()" >
                <option value="Select Business Partner" selected></option>
                  <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry2 = "select * from Businesspartner_Master";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(qry2);
                      while(rs2.next())
                      {
                          %>
                          <option value="<%=rs2.getString("BPNO")%>"> <%=rs2.getString("BPNO")%>   <%=rs2.getString("BPDES")%></option>
                          <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>         
                  
                </select> 

          <script>
                function BpCnslt(){
                var selectBox = document.getElementById("bpno");
                var selectedValue = selectBox.options[selectBox.selectedIndex].value;
                var sv = selectedValue;
                console.log(sv,selectedValue);
            }
            </script>
            
                <td id="col3"><select maxlength="9" style="width:175px;text-transform:uppercase" class="cnslntid" type="text" id="cnslntid" name="cnslntid" >
                <option value="Select Consultants" selected></option>
                  <%
                      String bp = request.getParameter("bpno");
                  try
                  {                    
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      String query = "select * from Businesspartner_Item where BPNO = '"+bp+"' ";
//                      stm = con1.createStatement();
//                      ResultSet rs = stm.executeQuery(query);
                      PreparedStatement psmt=con1.prepareStatement(query);
                      psmt.setString(1, request.getParameter("bpno"));                      
                      ResultSet rs=psmt.executeQuery();
                      while(rs.next())
                      {
                          %>
                          <option value="<%=rs.getString("BPID")%>"> <%=rs.getString("BPID")%>   <%=rs.getString("BPNAME")%></option>
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
                <td id="col4"><select maxlength="4" style="width:120px;text-transform:uppercase" class="unit" type="text" id="unit" name="unit" >
                 <option value="" disabled selected></option>
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
                <td id="col7"><input class="total" type="text" id="total" name="total" size="15" onblur="calc()" ></td>
                <!--<td>Remove</td>-->
            </tr>
            </tbody>
         </table> <br>
            <label for="poamnt">PO Amount </label> <input type="text" name="poamnt" maxlength="15" size="15" id="poamnt" ><br> 
      </ul>  
</div>
    
     <!--List Table Data for Get Operation-->
     <table style="display:none;overflow-x: auto" id="pomtbl" name="pomtbl" class="pomtbl">
            
           <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String sqlmst = "SELECT * FROM Purchase_Order";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs2 = stm.executeQuery(sqlmst);
                      while(rs2.next())
                      {
                          %>
<!--              <tr>
              <th>Purchase Order</th>  
              <th>Company Code</th> 
              <th>Contract Type</th>
              <th>Inquiry No</th>
              <th>Project No</th>
              <th>Estimation No</th>
              <th>Start Date</th>
              <th>End Date</th> 
              <th>Amount</th>              
              <th>Tax</th>  
              <th>Currency</th> 
              <th>Payment Terms</th>
              <th>Delivery Place</th>
              <th>Deliverables</th>
              <th>Status</th>
              <th>PO H Tex</th>
              <th>PO I Text</th> 
              <th>PO Texts</th>
              <th>Flag</th>
            </tr>          -->
               <tr>
               <td><%=rs2.getString("PONUM") %></td> <!--0-->
               <td><%=rs2.getString("CCOD") %></td>   <!--1-->
               <td><%=rs2.getString("CNTRTYP") %></td> <!--2-->
               <td><%=rs2.getString("INQNO") %></td>  <!--3-->
               <td><%=rs2.getString("PRJNO") %></td>  <!--4-->
               <td><%=rs2.getString("BPESTNO") %></td>  <!--5-->
               <td><%=rs2.getString("POFRMDT") %></td>  <!--6-->
               <td><%=rs2.getString("POENDT") %></td>  <!--7-->
               <td><%=rs2.getString("POAMNT") %></td>   <!--8-->
               <td><%=rs2.getString("CNSMPTAX") %></td>   <!--9-->
               <td><%=rs2.getString("CURR") %></td>  <!--10-->
               <td><%=rs2.getString("PAYTRMS") %></td>  <!--11-->
               <td><%=rs2.getString("DELLOC") %></td>  <!--12-->
               <td><%=rs2.getString("DELVRBLS") %></td>  <!--13-->
               <td><%=rs2.getString("POSTATUS") %></td>  <!--14-->
               <td><%=rs2.getString("POHTXT") %></td>  <!--15-->
               <td><%=rs2.getString("POITXT") %></td>  <!--16-->
               <td><%=rs2.getString("POTXTS") %></td>  <!--17-->               
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
                  
            <table style="display:none;overflow-x: auto" id="poitbl" name="poitbl" class="poitbl">
            
           <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String sqlitm = "SELECT * FROM PO_Items";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs3 = stm.executeQuery(sqlitm);
                      while(rs3.next())
                      {
                          %>
<!--               <tr>
              <th></th>  
              <th>Item</th> 
              <th>BPNo</th>
              <th>Consultant</th>
              <th>Unit</th>
              <th>Quantity</th>
              <th>Rate</th>
              <th>Total</th> 
              <th>Delete</th>
            </tr>           -->
               <tr>
               <td><%=rs3.getString("PONUM") %></td> <!--0-->
               <td><%=rs3.getString("POITEM") %></td>   <!--1-->
               <td><%=rs3.getString("BPNO") %></td> <!--2-->
               <td><%=rs3.getString("CNSLNTID") %></td>  <!--3-->
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
        var tabpo = document.getElementById("potbl");
        var rowcount = tabpo.rows.length;
        var prvcol = rowcount - 1;
        var newrowcount = rowcount + 1;
        var cellcount = tabpo.rows[0].cells.length;
        var adrow = tabpo.insertRow(rowcount);
        for(var i =0;i < cellcount;i++){
            var cell = 'cell'+i;
            cell = adrow.insertCell(i);
            var incell = document.getElementById("col"+i).innerHTML;            
            cell.innerHTML=incell;
            
        }       
        document.getElementsByClassName("poitem")[prvcol].value = rowcount;
        document.getElementsByClassName("check")[prvcol].value = rowcount;
    }
          </script>
<!--<script>
       var x = '01';
       document.getElementById("estrevno").value = x;
    
</script>-->
          
  <script>
//              for BP Consultants Table
      function addRows(){
        var tabpo = document.getElementById("potbl");
        var rowcount = tabpo.rows.length;
        var prvcol = rowcount - 1;
        var newrowcount = rowcount + 1;
        var cellcount = tabpo.rows[0].cells.length;
        var adrow = tabpo.insertRow(rowcount);
        for(var i =0;i < cellcount;i++){
            var cell = 'cell'+i;
            cell = adrow.insertCell(i);
            var incell = document.getElementById("col"+i).innerHTML;            
            cell.innerHTML=incell;
            
        }       
        document.getElementsByClassName("poitem")[prvcol].value = rowcount;
        document.getElementsByClassName("bpno")[prvcol].focus();
            }
  </script>      

 <script>
              // Calculate Estimation Amount
              function calc(){
                    var ctbl = document.getElementsByClassName('poitem');
                    var row = ctbl.length;
                    var q,r,tot,sum = 0;
               //     var d = document.getElementById('discount').value;
                    var t = document.getElementById('cnsmptax').value;
                     for (var i = 0; i < row; i++) {
                   q = document.getElementsByClassName('qty')[i].value;
                   r = document.getElementsByClassName('rate')[i].value;
                  tot = (q*r);                 
                  document.getElementsByClassName('total')[i].value = tot;  
                  sum = sum + tot;
            }              
                  var tot1 = sum;
                  var tx = tot1*(t/100);
                  var amnt = tot1+tx;
                  document.getElementById('poamnt').value = amnt;                   
              }
 </script>      
          
<script>
 var temp = 0;
 var temp1 = "T1";
function openPage(clicked_id) {
//var basdt1 ;
  var i, tabcontent,tabid;
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
 
  <script>
//    document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
//     document.getElementById("emnum").value = '<%= request.getAttribute("emnum") %>';
      
       if('<%= request.getAttribute("scrn") %>' === 'cre'){
      //     var x = '01';
     //    document.getElementById("estrevno").value = x;
         document.getElementById("scrn").value = "cre";
         document.getElementById("pobtncre").style.display = "block";
         document.getElementById("pobtnedt").style.display = "none";
         document.getElementById("pobtnget").style.display = "none";
         document.getElementById("pobtndel").style.display = "none";
         document.getElementById("pobtnbck").style.display = "block";
         document.getElementById("ponum").required = false;
         document.getElementById('ccod').disabled = false;         
         document.getElementById('cntrtyp').disabled = false;                   
         document.getElementById('inqno').disabled = false;
         document.getElementById('prjno').disabled = false;        
         document.getElementById('bpestno').disabled = false;
         document.getElementById('pofrmdt').disabled = false;
         document.getElementById('poendt').disabled = false;
         document.getElementById('poamnt').disabled = false;
         document.getElementById('cnsmptax').disabled = false;
         document.getElementById('curr').disabled = false;
         document.getElementById('paytrms').disabled = false;
         document.getElementById('delloc').disabled = false;
         document.getElementById('delvrbls').disabled = false;
         document.getElementById('postatus').disabled = false;
         document.getElementById('pohtxt').disabled = false;
         document.getElementById('poitxt').disabled = false;
         document.getElementById('potxts').disabled = false;
         
         var dlen = document.getElementsByClassName("poitem").length;
         for(var d = 0; d < dlen; d++){
            document.getElementsByClassName("poitem")[d].disabled = false;
            document.getElementsByClassName("bpno")[d].disabled = false;
            document.getElementsByClassName("cnslntid")[d].disabled = false;
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
         document.getElementById("pobtnedt").style.display = "block";
         document.getElementById("pobtnget").style.display = "block";
         document.getElementById("pobtndel").style.display = "none";
         document.getElementById("pobtncre").style.display = "none";
         document.getElementById("pobtnbck").style.display = "block";
         document.getElementById("ponum").required = false;
         document.getElementById('ccod').disabled = false;         
         document.getElementById('cntrtyp').disabled = false;                   
         document.getElementById('inqno').disabled = false;
         document.getElementById('prjno').disabled = false;        
         document.getElementById('bpestno').disabled = false;
         document.getElementById('pofrmdt').disabled = false;
         document.getElementById('poendt').disabled = false;
         document.getElementById('poamnt').disabled = false;
         document.getElementById('cnsmptax').disabled = false;
         document.getElementById('curr').disabled = false;
         document.getElementById('paytrms').disabled = false;
         document.getElementById('delloc').disabled = false;
         document.getElementById('delvrbls').disabled = false;
         document.getElementById('postatus').disabled = false;
         document.getElementById('pohtxt').disabled = false;
         document.getElementById('poitxt').disabled = false;
         document.getElementById('potxts').disabled = false;
         
       var dlen = document.getElementsByClassName("estmitem").length;
         for(var d = 0; d < dlen; d++){
            document.getElementsByClassName("check")[d].disabled = false; 
            document.getElementsByClassName("poitem")[d].disabled = false;
            document.getElementsByClassName("bpno")[d].disabled = false;
            document.getElementsByClassName("cnslntid")[d].disabled = false;
            document.getElementsByClassName("unit")[d].disabled = false;
            document.getElementsByClassName("qty")[d].disabled = false; 
            document.getElementsByClassName("rate")[d].disabled = false;
            document.getElementsByClassName("total")[d].disabled = false;
         }
           
       }
       
       if('<%= request.getAttribute("scrn") %>' === 'dis'){
         document.getElementById("scrn").value = "dis";
         document.getElementById("pobtnget").style.display = "block";
         document.getElementById("pobtncre").style.display = "none";
         document.getElementById("pobtnedt").style.display = "none";
         document.getElementById("pobtndel").style.display = "none";
         document.getElementById("pobtnbck").style.display = "block";
         document.getElementById("pobtnprnt").style.display = "block";
         document.getElementById("pobtnmail").style.display = "block";
         document.getElementById("ponum").required = false;
         document.getElementById('ccod').disabled = true;         
         document.getElementById('cntrtyp').disabled = true;                   
         document.getElementById('inqno').disabled = true;
         document.getElementById('prjno').disabled = true;        
         document.getElementById('bpestno').disabled = true;
         document.getElementById('pofrmdt').disabled = true;
         document.getElementById('poendt').disabled = true;
         document.getElementById('poamnt').disabled = true;
         document.getElementById('cnsmptax').disabled = true;
         document.getElementById('curr').disabled = true;
         document.getElementById('paytrms').disabled = true;
         document.getElementById('delloc').disabled = true;
         document.getElementById('delvrbls').disabled = true;
         document.getElementById('postatus').disabled = true;
         document.getElementById('pohtxt').disabled = true;
         document.getElementById('poitxt').disabled = true;
         document.getElementById('potxts').disabled = true;
         
     var slen = document.getElementsByClassName("poitem").length;
         for(var s = 0; s < slen; s++){
            document.getElementsByClassName("check")[s].disabled = true; 
            document.getElementsByClassName("poitem")[s].disabled = true;
            document.getElementsByClassName("bpno")[s].disabled = true;
            document.getElementsByClassName("cnslntid")[s].disabled = true;
            document.getElementsByClassName("unit")[s].disabled = true;
            document.getElementsByClassName("qty")[s].disabled = true; 
            document.getElementsByClassName("rate")[s].disabled = true;
            document.getElementsByClassName("total")[s].disabled = true;
         }
         
         }
         
        if('<%= request.getAttribute("scrn") %>' === 'del'){
         document.getElementById("scrn").value = "del";
         document.getElementById("pobtnget").style.display = "block";
         document.getElementById("pobtncre").style.display = "none";
         document.getElementById("pobtnedt").style.display = "none";
         document.getElementById("pobtndel").style.display = "block";
         document.getElementById("pobtnbck").style.display = "block";
         document.getElementById("ponum").required = false;
         document.getElementById('ccod').disabled = true;         
         document.getElementById('cntrtyp').disabled = true;                   
         document.getElementById('inqno').disabled = true;
         document.getElementById('prjno').disabled = true;        
         document.getElementById('bpestno').disabled = true;
         document.getElementById('pofrmdt').disabled = true;
         document.getElementById('poendt').disabled = true;
         document.getElementById('poamnt').disabled = true;
         document.getElementById('cnsmptax').disabled = true;
         document.getElementById('curr').disabled = true;
         document.getElementById('paytrms').disabled = true;
         document.getElementById('delloc').disabled = true;
         document.getElementById('delvrbls').disabled = true;
         document.getElementById('postatus').disabled = true;
         document.getElementById('pohtxt').disabled = true;
         document.getElementById('poitxt').disabled = true;
         document.getElementById('potxts').disabled = true;
         
     var slen = document.getElementsByClassName("poitem").length;
         for(var s = 0; s < slen; s++){
            document.getElementsByClassName("check")[s].disabled = true; 
            document.getElementsByClassName("poitem")[s].disabled = true;
            document.getElementsByClassName("bpno")[s].disabled = true;
            document.getElementsByClassName("cnslntid")[s].disabled = true;
            document.getElementsByClassName("unit")[s].disabled = true;
            document.getElementsByClassName("qty")[s].disabled = true; 
            document.getElementsByClassName("rate")[s].disabled = true;
            document.getElementsByClassName("total")[s].disabled = true;
         }
         
         } 
                
 </script>
   
<script>
   function pobutget(){
        var pono = document.getElementById("ponum").value;
        var msttable = document.getElementById("pomtbl");
        var itmtable = document.getElementById("poitbl");
        var poTable = document.getElementById("potbl");
        var porowlen = poTable.rows.length;
        var mstrowlen = msttable.rows.length;
        var col1len = document.getElementsByClassName("poitem").length;
        var colrow = col1len - 1;
        var revno = 0;
            
        
          for(var z = 0;z < mstrowlen;z++){
            var delpono = msttable.rows[z].cells[0].innerText;
            if(pono === delpono){
            var delactflg = msttable.rows[z].cells[18].innerText;
            }          
        }
        
          if(delactflg === 'X'){
            alert("Record " +pono+ " Already Deleted or Deletion Flag is Set ");
          }
             else{
        
        for(var i = 0;i < mstrowlen;i++){
          var ponum1 = msttable.rows[i].cells[0].innerText;
          var ccod = msttable.rows[i].cells[1].innerText;
          var cntrtyp = msttable.rows[i].cells[2].innerText;
          var inqno = msttable.rows[i].cells[3].innerText;
          var prjno = msttable.rows[i].cells[4].innerText;
          var bpestno = msttable.rows[i].cells[5].innerText;
          var pofrmdt = msttable.rows[i].cells[6].innerText;
          var poendt = msttable.rows[i].cells[7].innerText;
          var poamnt = msttable.rows[i].cells[8].innerText;
          var cnsmptax= msttable.rows[i].cells[9].innerText;
          var curr = msttable.rows[i].cells[10].innerText;
          var paytrms = msttable.rows[i].cells[11].innerText;
          var delloc = msttable.rows[i].cells[12].innerText;
          var delvrbls = msttable.rows[i].cells[13].innerText;
          var postatus = msttable.rows[i].cells[14].innerText;
          var pohtxt = msttable.rows[i].cells[15].innerText;
          var poitxt = msttable.rows[i].cells[16].innerText;
          var potxts = msttable.rows[i].cells[17].innerText;
          var actflg = msttable.rows[i].cells[18].innerText;
          if(pono === ponum1){
                
         document.getElementById("ccod").value = ccod;
         document.getElementById("cntrtyp").value = cntrtyp;
         document.getElementById("inqno").value = inqno;
         document.getElementById("prjno").value = prjno;
         document.getElementById("bpestno").value = bpestno;
         document.getElementById("pofrmdt").value = pofrmdt;
         document.getElementById("poendt").value = poendt;
         document.getElementById("poamnt").value = poamnt; 
         document.getElementById("cnsmptax").value = cnsmptax;
         document.getElementById("curr").value = curr;
         document.getElementById("paytrms").value = paytrms;
         document.getElementById("delloc").value = delloc;
         document.getElementById("delvrbls").value = delvrbls;
         document.getElementById("postatus").value = postatus;
         document.getElementById("pohtxt").value = pohtxt;
         document.getElementById("poitxt").value = poitxt;
         document.getElementById("potxts").value = potxts;
        // document.getElementById("actflg").value = actflg;
          }
         }
          
    
        
        var itmrowlen = itmtable.rows.length;
	var count = 0;	          
        for(var j = 0; j < itmrowlen;j++){
            
         var ponum2 = itmtable.rows[j].cells[0].innerText;
         var poitem = itmtable.rows[j].cells[1].innerText;
          var bpno = itmtable.rows[j].cells[2].innerText;
          var cnslntid = itmtable.rows[j].cells[3].innerText;
          var unit = itmtable.rows[j].cells[4].innerText;
          var qty = itmtable.rows[j].cells[5].innerText;
          var rate = itmtable.rows[j].cells[6].innerText;  
      //    var total = itmtable.rows[j].cells[6].innerText; 
                if(count > colrow){
                    var tabpo = document.getElementById("potbl");
                        var rowcount = tabpo.rows.length;
                        var prvcol = rowcount - 1;
                        var newrowcount = rowcount + 1;
                        var cellcount = tabpo.rows[0].cells.length;
                        var adrow = tabpo.insertRow(rowcount);
                        for(var i =0;i < cellcount;i++){
                            var cell = 'cell'+i;
                            cell = adrow.insertCell(i);
                            var incell = document.getElementById("col"+i).innerHTML;            
                            cell.innerHTML=incell;

                        }       
                       document.getElementsByClassName("poitem")[prvcol].value = rowcount;
                       document.getElementsByClassName("check")[prvcol].value = rowcount;
                    }
                                 
                  if(pono === ponum2){
                //      document.getElementsByClassName("poitem")[count].value = estmitem;
                      document.getElementsByClassName("bpno")[count].value = bpno;
                      document.getElementsByClassName("cnslntid")[count].value = cnslntid;
                      document.getElementsByClassName("unit")[count].value = unit;
                      document.getElementsByClassName("qty")[count].value = qty;
                      document.getElementsByClassName("rate")[count].value = rate;
                //      document.getElementsByClassName("total")[count].value = total;
                      count = count + 1;
                  }                                                               
        }

            for(var count1 = count + 1;count1 < col1len;count1++){
       //    document.getElementsByClassName("poitem")[count].value = "";
            document.getElementsByClassName("bpno")[count].value = "";
            document.getElementsByClassName("cnslntid")[count].value = "";
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
                
               var tbl = document.getElementById("potbl").getElementsByTagName("tr");
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
        
                for(var l = 0;l < chlen;l++){
            
            if(document.getElementsByClassName("check")[l].checked === true){
                
                document.getElementById("potbl").deleteRow(l + 1);
                var lopchlen = document.getElementsByClassName("check").length;
                chlen = lopchlen;
                l = l - 1;
                if (confirm('Are you sure you want to Delete the Selected Row(s)')) {
                      // Save it!
                        console.log('Thing was saved to the database.');
                 } else {
                            // Do nothing!
                      console.log('Thing was not saved to the database.');
                      }
            }
            
        }
        
        var reitmno = document.getElementsByClassName("poitem").length;
       var m = 0;
       for(var n = 0;n < reitmno;n++){
           m = n + 1;
           document.getElementsByClassName("poitem")[n].value = m;
       }
   }
                  
 </script>     
 <script>
            document.addEventListener('DOMContentLoaded', function () {
                const table = document.getElementById('potbl');

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
<script>
    function prntpo() {
         var printWindow = window.open('', '_blank', 'height=800,width=800');
         printWindow.document.open();
         printWindow.document.write('<title>Purchase Order</title>');
         var po = document.getElementById("ponum").value;
         var cc = document.getElementById("ccod").value;
         var ctyp = document.getElementById("cntrtyp").value;
         var inq = document.getElementById("inqno").value;
         var prj = document.getElementById("prjno").value;
         var est = document.getElementById("bpestno").value;
         var stdt = document.getElementById("pofrmdt").value;
         var endt = document.getElementById("poendt").value;
         printWindow.document.write('Purchase Order No', '', po, '<br>');         
         printWindow.document.write('Company Code',  '', cc, '<br>');
         printWindow.document.write('Contract Type',  '', ctyp, '<br>');         
         printWindow.document.write('Inquiry No',  '', inq, '<br>');
         printWindow.document.write('Project No',  '', prj, '<br>');         
         printWindow.document.write('Estimation No',  '', est, '<br>');
         printWindow.document.write('PO Validity Start Date',  '', stdt, '<br>');         
         printWindow.document.write('PO Validity End Date',  '', endt, '<br>');
         var tbl = document.getElementById("thd");  
         printWindow.document.write(tbl.innerHTML); 
         printWindow.document.write('<img src="http://www.agnieconsulting.com/assets/img/logo.gif"');
         printWindow.document.close();
    }
    
</script>
<script>
 function EmailPo(){
     //   window.location="EmailPO.jsp";
  // Get the modal
   var modal = document.getElementById('modal');
  //Modal open function  
  modal.style.display = "block";

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
 }
</script>
    </body>
</html>

