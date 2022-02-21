<%-- 
    Document   : compcode
    Created on : 8 Feb, 2022, 8:48:00 PM
    Author     : agnie
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
        <title>Company Code</title>
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
            display:grig;
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

        .form1 .but1{
            background-color: #e7e9ec;
            color: black;
            transition: all 0.1s;
            border: 1px solid transparent;
            padding: 12px 24px;
            border-radius: 4px;
            cursor: pointer;
            background-image: none !important;
        }
        .form1 .but1:hover{
            background-color: #8d9096;
            color: white;
        }



    </style>

    <body>


        <header>
        </header>
        <form method="post">

            <div class="mbar" >
                <div class="dropdown">
                    <button type="button" class="dropbtn"><%= request.getAttribute("COM")%></button>
                    <div id="drpcnt" class="dropdown-content">

                        <li><button type="button" id="cre" onclick="comcre();" class="menu" ><%= request.getAttribute("EMC")%></button></li>
                        <li><button type="button" id="cha" onclick="comcha();" class="menu" ><%= request.getAttribute("EMED")%></button></li>
                        <li><button type="button" id="dis" onclick="comdis();" class="menu" ><%= request.getAttribute("EMDIS")%></button></li>
                        <li><button type="button" id="del" onclick="comdel();" class="menu" ><%= request.getAttribute("EMDEL")%></button></li>
                   
                    </div>
                </div>  
            </div>

            <div id="hed" class="head" style="margin-left:0px;">
             <input type="text" style="width:53px;" maxlength="7" name="weblng" id="weblng" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="emnum" id="emnum" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="scrn" id="scrn" hidden>
                <ul class="opbut">
            <li><button  type="submit" id="crebut" style="cursor: pointer;display:block;text-align:left;font-size:25px" formaction="insertcom" title="Create Company Code" ><i class="fa fa-save"></i></button></li>
            <li><button type="submit" id="getbut" formaction="getcom" style="cursor: pointer;display:none;text-align:left;font-size:25px"  title="Get Company Code" ><i class="fas fa-glasses"></i></button></li>
            <li><button type="submit" id="delbut" formaction="delcom" style="cursor: pointer;display:none;text-align:left;font-size:25px" title="Delete Company Code" ><i class="fa fa-trash"></i></button></li>
            <li><button type="submit" id="chabut" formaction="updatecom" style="cursor: pointer;display:none;text-align:left;font-size:25px" title="Update Company Code" ><i class="fa fa-save"></i></button></li>
            <li><button type="submit" id="bck" formaction="back16" style="cursor: pointer;display:none;text-align:left;font-size:25px"> <i class="fa fa-hand-o-left"></i></button></li> 
                </ul>
     <ul class="top">  
     <li><label for="comId" style="width:100px" ><%= request.getAttribute("COM") %></label><input type="text" style="width:33px;" maxlength="4" name="comId" id="comId"></li>
     <li><label for="comName" style="width:100px" >Company Name</label><input maxlength="50" style="width:190px;" type="text" name="comName" id="comName" /></li>    
     </ul>
            
    <button type="button" class="tablink" id="BD1" onclick="openPage(this.id)"><%= request.getAttribute("BSDT") %>1</button>
    <button type="button" class="tablink" id="BD2" onclick="openPage(this.id)"><%= request.getAttribute("BSDT") %>2</button>
    <button type="button" class="tablink" id="BD3" onclick="openPage(this.id)"><%= request.getAttribute("BSDT") %>3</button>      

        
<div id="BD1" class="tabcontent">
  <!--<h3>Basci Data1</h3>-->
<%
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      Connection con1 = null;
                      Statement stm = null;
  %>
 <ul>
    <li><label  for="bnk" style="width:96px" ><%= request.getAttribute("GINKO") %></label>
          <select type="text" maxlength="10" style="width:100px;text-transform:uppercase" id="bnk" name="bnk" >
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
          </select>
          </li>
          
    <li><label for="curId" style="width:96px" ><%= request.getAttribute("CUR") %></label>
     <select type="text" maxlength="10" style="width:120px;text-transform:uppercase" id="curId" name="curId" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry1 = "select * from Currency";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs1 = stm.executeQuery(qry1);
                      while(rs1.next())
                      {
                          %>
                          <option value="<%=rs1.getString("CURID") %>"><%=rs1.getString("CURTXT") %></option>
              <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select>
          </li>
          
    <li><label for="taxId" style="width:96px" ><%= request.getAttribute("TAX") %></label>
 <select type="text" maxlength="10" style="width:50px;text-transform:uppercase" id="taxId" name="taxId" >
              <option value=""></option>
              <%
                  try
                  {
                      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                      String qry1 = "select * from Tax_Codes";
                      con1 = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                      stm = con1.createStatement();
                      ResultSet rs1 = stm.executeQuery(qry1);
                      while(rs1.next())
                      {
                          %>
                          <option value="<%=rs1.getString("TAX") %>"><%=rs1.getString("TAXCODE") %></option>
              <%
                      }
                  }
                  catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                  }
                  con1.close();
                  %>
          </select>
          </li>
 </ul>  
   
</div>

<div id="BD2" class="tabcontent">
  <!--<h3>Basci Data2</h3>-->
  <ul>
      <li><label  for="str1"><%= request.getAttribute("STRT") %>1</label><input maxlength="30" style="width:210px;" type="text" id="str1" name="str1" /></li>
      <li><label  for="str2"><%= request.getAttribute("STRT") %>2</label><input maxlength="30" style="width:210px;" type="text" id="str2" name="str2" /></li>
      <li><label  for="str3"><%= request.getAttribute("STRT") %>3</label><input maxlength="30" style="width:210px;" type="text" id="str3" name="str3" /></li>
      <li><label  for="city" ><%= request.getAttribute("CITY") %></label><input maxlength="30" style="width:160px;" type="text" id="city" name="city" /></li>
      <li><label  for="stat" ><%= request.getAttribute("STATE") %></label><input maxlength="30" style="width:160px;" type="text" id="stat" name="stat" /></li>
      <li><label  for="cntry" style="width:196px" ><%= request.getAttribute("CONTR") %></label>
          <select maxlength="10" style="width:100px;text-transform:uppercase" type="text" id="cntry" name="cntry" >
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
          <li><label for="pstl" ><%= request.getAttribute("PSTLCOD") %></label><input type="text" maxlength="10" style="width:70px;" inputmode="numeric" id="pstl" name="pstl" /></li> 
  </ul>
  
</div>
           
<div id="BD3" class="tabcontent">
  <!--<h3>Basci Data2</h3>-->
  <ul>
       <li><label  for="langId" style="width:196px" ><%= request.getAttribute("LANGU") %></label>
           <select type="text" maxlength="10" style="width:100px;text-transform:uppercase" id="langId" name="langId" >
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
          <li><label  for="phn1" ><%= request.getAttribute("PHON") %>1</label><input type="tel" maxlength="30" style="width:100px;" id="phn1" name="phn1" /></li>
          <li><label  for="phn2" ><%= request.getAttribute("PHON") %>2</label><input maxlength="30" style="width:100px;" type="text" id="phn2" name="phn2" /></li>
          <li><label  for="fax" ><%= request.getAttribute("FAKUSU") %></label><input type="text" maxlength="30" style="width:90px;" id="fax" name="fax" /></li>
          <li><label  for="emil" ><%= request.getAttribute("MERU") %></label><input maxlength="50" style="width:220px;" type="text" id="emil" name="emil" /></li>
          <li><label for="time" style="width:200px" >Time Zone</label><input maxlength="50" style="width:150px;" type="text" name="time" id="time" /></li> 
  </ul>
</div>
  
 </form>
<script>
    document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
    document.getElementById("emnum").value = '<%= request.getAttribute("emnum") %>';

</script>
<script>
    document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
    
       if('<%= request.getAttribute("scrn")%>' === 'cha')
       {
         // var BackgroundColor="LightYellow"; // what ever color you want
         //document.body.style.backgroundColor=BackgroundColor; //changing bg color 
         document.getElementById("scrn").value = "cha";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "block";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
          document.getElementById("bck").style.display = "block";
         document.getElementById("comId").required = true;
         document.getElementById("comName").disabled = false;
        document.getElementById('str1').disabled = false;
         document.getElementById('str2').disabled = false;
         document.getElementById('str3').disabled = false;
         document.getElementById('city').disabled = false;
         document.getElementById('stat').disabled = false;
         document.getElementById('cntry').disabled = false;
         document.getElementById('langId').disabled = false;
         document.getElementById('pstl').disabled = false;
         document.getElementById('phn1').disabled = false;
         document.getElementById('phn2').disabled = false;
         document.getElementById('fax').disabled = false;
         document.getElementById('emil').disabled = false;
         document.getElementById('bnk').disabled = false;
         document.getElementById('curId').disabled = false;
         document.getElementById('taxId').disabled = false;
         document.getElementById('time').disabled = false;
      }
       if('<%= request.getAttribute("scrn") %>' === 'dis')
       { 
         document.getElementById("scrn").value = "dis";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
          document.getElementById("bck").style.display = "block";
          document.getElementById("comId").required = true;
         document.getElementById("comName").disabled = true;
         document.getElementById('str1').disabled = true;
         document.getElementById('str2').disabled = true;
         document.getElementById('str3').disabled = true;
         document.getElementById('city').disabled = true;
         document.getElementById('stat').disabled = true;
         document.getElementById('cntry').disabled = true;
         document.getElementById('langId').disabled = true;
         document.getElementById('pstl').disabled = true;
         document.getElementById('phn1').disabled = true;
         document.getElementById('phn2').disabled = true;
         document.getElementById('fax').disabled = true;
         document.getElementById('emil').disabled = true;
         document.getElementById('bnk').disabled = true;
         document.getElementById('curId').disabled = true;
         document.getElementById('taxId').disabled = true;
         document.getElementById('time').disabled = true;
     }
     if('<%= request.getAttribute("scrn") %>' === 'del')
       {
         document.getElementById("scrn").value = "del";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "block";
          document.getElementById("bck").style.display = "block";
        // document.getElementById("bizId").required = true;
         document.getElementById("comId").disabled = false;
         document.getElementById("comName").disabled = false;
         document.getElementById('str1').disabled = false;
         document.getElementById('str2').disabled = false;
         document.getElementById('str3').disabled = false;
         document.getElementById('city').disabled = false;
         document.getElementById('stat').disabled = false;
         document.getElementById('cntry').disabled = false;
         document.getElementById('langId').disabled = false;
         document.getElementById('pstl').disabled = false;
         document.getElementById('phn1').disabled = false;
         document.getElementById('phn2').disabled = false;
         document.getElementById('fax').disabled = false;
         document.getElementById('emil').disabled = false;
         document.getElementById('bnk').disabled = false;
         document.getElementById('curId').disabled = false;
         document.getElementById('taxId').disabled = false;
         document.getElementById('time').disabled = false;
     }
     if('<%= request.getAttribute("scrn") %>' === 'cre'){
         document.getElementById("scrn").value = "cre";
         document.getElementById("crebut").style.display = "block";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "none";
         document.getElementById("delbut").style.display = "none";
          document.getElementById("bck").style.display = "block";
         //document.getElementById("bizId").required = true;
         document.getElementById("comId").value = "";
         document.getElementById('comName').value = "";
         document.getElementById('str1').value = "";
         document.getElementById('str2').value = "";
         document.getElementById('str3').value = "";
         document.getElementById('city').value = "";
         document.getElementById('stat').value = "";
         document.getElementById('cntry').value = "";
         document.getElementById('langId').value = "";
         document.getElementById('pstl').value = "";
         document.getElementById('phn1').value = "";
         document.getElementById('phn2').value = "";
         document.getElementById('fax').value = "";
         document.getElementById('emil').value = "";
         document.getElementById('bnk').value = "";
         document.getElementById('curId').value = "";
         document.getElementById('taxId').value = "";
         document.getElementById('time').value = "";
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
//     change option starts
     function comcha(){
         document.getElementById("scrn").value = "cha";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "block";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
          document.getElementById("bck").style.display = "block";
        // document.getElementById("bizId").required = true;
         // document.getElementById("comId").required = true;
         document.getElementById('comName').disabled = false;
          document.getElementById('str1').disabled = false;
         document.getElementById('str2').disabled = false;
         document.getElementById('str3').disabled = false;
         document.getElementById('city').disabled = false;
         document.getElementById('stat').disabled = false;
         document.getElementById('cntry').disabled = false;
         document.getElementById('langId').disabled = false;
         document.getElementById('pstl').disabled = false;
         document.getElementById('phn1').disabled = false;
         document.getElementById('phn2').disabled = false;
         document.getElementById('fax').disabled = false;
         document.getElementById('emil').disabled = false;
         document.getElementById('bnk').disabled = false;
         document.getElementById('curId').disabled = false;
         document.getElementById('taxId').disabled = false;
         document.getElementById('time').disabled = false;
        }
     function comcre(){
         document.getElementById("scrn").value = "cre";
         document.getElementById("crebut").style.display = "block";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "none";
         document.getElementById("delbut").style.display = "none";
          document.getElementById("bck").style.display = "block";
         //document.getElementById("bizId").required = true;
         document.getElementById('comName').disabled = false;
         document.getElementById('str1').disabled = false;
         document.getElementById('str2').disabled = false;
         document.getElementById('str3').disabled = false;
         document.getElementById('city').disabled = false;
         document.getElementById('stat').disabled = false;
         document.getElementById('cntry').disabled = false;
         document.getElementById('langId').disabled = false;
         document.getElementById('pstl').disabled = false;
         document.getElementById('phn1').disabled = false;
         document.getElementById('phn2').disabled = false;
         document.getElementById('fax').disabled = false;
         document.getElementById('emil').disabled = false;
         document.getElementById('bnk').disabled = false;
         document.getElementById('curId').value = false;
         document.getElementById('taxId').value = false;
         document.getElementById('time').value = false;
        }
    
     // Delete option starts
     function comdel(){
         document.getElementById("scrn").value = "del";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "block";
          document.getElementById("bck").style.display = "block";
        // document.getElementById("bizId").required = true;
         document.getElementById('comName').disabled = false;
     }
    // Display option starts
     function comdis(){   
         document.getElementById("scrn").value = "dis";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
          document.getElementById("bck").style.display = "block";
          document.getElementById("comId").required = true;
         document.getElementById('comName').disabled = true;
          document.getElementById('str1').disabled = true;
         document.getElementById('str2').disabled = true;
         document.getElementById('str3').disabled = true;
         document.getElementById('city').disabled = true;
         document.getElementById('stat').disabled = true;
         document.getElementById('cntry').disabled = true;
         document.getElementById('langId').disabled = true;
         document.getElementById('pstl').disabled = true;
         document.getElementById('phn1').disabled = true;
         document.getElementById('phn2').disabled = true;
         document.getElementById('fax').disabled = true;
         document.getElementById('emil').disabled = true;
         document.getElementById('bnk').disabled = true;
         document.getElementById('curId').disabled = true;
         document.getElementById('taxId').disabled = true;
         document.getElementById('time').disabled = true;
     }
//     (Programming_Language) Display option end
 </script>
    <script>
//     During Get operation got data from backend and pass to display fields
     
     if(<%= request.getAttribute("getnm") %> === 2){   
         document.getElementById('comId').value = '<%= request.getAttribute("comId1") %>';
         document.getElementById('comName').value = '<%= request.getAttribute("comName") %>';
         
         document.getElementById('str1').value = '<%= request.getAttribute("str1") %>';
         document.getElementById('str2').value = '<%= request.getAttribute("str2") %>';
         document.getElementById('str3').value = '<%= request.getAttribute("str3") %>';
         document.getElementById('city').value = '<%= request.getAttribute("city") %>';
         document.getElementById('stat').value = '<%= request.getAttribute("stat") %>';
         document.getElementById('cntry').value = '<%= request.getAttribute("cntry") %>';
         document.getElementById('langId').value = '<%= request.getAttribute("langId") %>';
         document.getElementById('pstl').value = '<%= request.getAttribute("pstl") %>';
         document.getElementById('phn1').value = '<%= request.getAttribute("phn1") %>';
         document.getElementById('phn2').value = '<%= request.getAttribute("phn2") %>';
         document.getElementById('fax').value = '<%= request.getAttribute("fax") %>';
         document.getElementById('emil').value = '<%= request.getAttribute("emil") %>';
         
         document.getElementById('bnk').value = '<%= request.getAttribute("bnk") %>';
         document.getElementById('curId').value = '<%= request.getAttribute("curId") %>';
         document.getElementById('taxId').value = '<%= request.getAttribute("taxId") %>';
         document.getElementById('time').value = '<%= request.getAttribute("time") %>';
     }
 </script>     
    </body>
</html>





