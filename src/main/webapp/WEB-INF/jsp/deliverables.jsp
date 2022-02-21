<%-- 
    Document   : deliverables
    Created on : 1 Feb, 2022, 1:49:26 PM
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
        <title>Deliverables</title>
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
                    <button type="button" class="dropbtn"><%= request.getAttribute("DBL")%></button>
                    <div id="drpcnt" class="dropdown-content">

                        <li><button type="button" id="cre" onclick="dblcre();" class="menu" ><%= request.getAttribute("EMC")%></button></li>
                        <li><button type="button" id="cha" onclick="dblcha();" class="menu" ><%= request.getAttribute("EMED")%></button></li>
                        <li><button type="button" id="dis" onclick="dbldis();" class="menu" ><%= request.getAttribute("EMDIS")%></button></li>
                        <li><button type="button" id="del" onclick="dbldel();" class="menu" ><%= request.getAttribute("EMDEL")%></button></li>
                   
                    </div>
                </div>  
            </div>

            <div id="hed" class="head" style="margin-left:0px;">
             <input type="text" style="width:53px;" maxlength="7" name="weblng" id="weblng" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="emnum" id="emnum" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="scrn" id="scrn" hidden>
                <ul class="opbut">
            <li><button  type="submit" id="crebut" style="cursor: pointer;display:block;text-align:left;font-size:25px" formaction="insertdbl" title="Create Deliverable" ><i class="fa fa-save fa-2x"></i></button></li>
            <li><button type="submit" id="getbut" formaction="getdbl" style="cursor: pointer;display:none;text-align:left;font-size:25px"  title="Get Deliverable" ><i class="fas fa-glasses fa-2x"></i></button></li>
            <li><button type="submit" id="delbut" formaction="deldbl" style="cursor: pointer;display:none;text-align:left;font-size:25px" title="Delete Deliverable" ><i class="fa fa-trash fa-2x"></i></button></li>
            <li><button type="submit" id="chabut" formaction="updatedbl" style="cursor: pointer;display:none;text-align:left;font-size:25px" title="Update Deliverable" ><i class="fa fa-save fa-2x"></i></button></li>
            <li><button type="submit" id="bck" formaction="back11" style="cursor: pointer;display:none;text-align:left;font-size:25px"> <i class="fa fa-hand-o-left fa-2x"></i></button></li>
                </ul>

            <ul>
             <li><label for="dblId" style="width:95px" >Deliverables ID</label><input maxlength="5" style="width:60px;" type="text" name="dblId" id="dblId" /></li>
             <li><label for="dblName" style="width:95px" ><%= request.getAttribute("DBL")%></label><input maxlength="60" style="width:230px;" type="text" name="dblName" id="dblName" /></li>
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
         document.getElementById("dblId").required = true;
         document.getElementById("dblName").disabled = false;
      }
       if('<%= request.getAttribute("scrn") %>' === 'dis')
       {
        // var BackgroundColor="LightGreen"; // what ever color you want
         //document.body.style.backgroundColor=BackgroundColor; //changing bg color 
         document.getElementById("scrn").value = "dis";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("bck").style.display = "block";
         document.getElementById("dblId").required = true;
         document.getElementById("dblName").disabled = true;
     }
     if('<%= request.getAttribute("scrn") %>' === 'del')
       {
         //var BackgroundColor="LightBlue"; // what ever color you want
         //document.body.style.backgroundColor=BackgroundColor; //changing bg color
         
         document.getElementById("scrn").value = "del";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "block";
         document.getElementById("bck").style.display = "block";
         document.getElementById("dblId").required = true;
         document.getElementById("dblName").disabled = false;
     }
     if('<%= request.getAttribute("scrn") %>' === 'cre'){
         //var BackgroundColor="Pink"; // what ever color you want
         //document.body.style.backgroundColor=BackgroundColor; //changing bg color
         
         document.getElementById("scrn").value = "cre";
         document.getElementById("crebut").style.display = "block";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "none";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("bck").style.display = "block";
         document.getElementById("dblId").required = true;
         document.getElementById("dblId").value = "";
         document.getElementById('dblName').value = "";
     }
    </script>
        
    <script> 
//     change option starts
     function dblcha(){
         document.getElementById("scrn").value = "cha";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "block";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("bck").style.display = "block";
         document.getElementById("dblId").required = true;
         document.getElementById('dblName').disabled = false;
        }
     function dblcre(){
         document.getElementById("scrn").value = "cre";
         document.getElementById("crebut").style.display = "block";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "none";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("bck").style.display = "block";
         document.getElementById("dblId").required = true;
         document.getElementById('dblName').disabled = false;
        }
    
     // Delete option starts
     function dbldel(){
         document.getElementById("scrn").value = "del";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "block";
         document.getElementById("bck").style.display = "block";
         document.getElementById("dblId").required = true;
         document.getElementById('dblName').disabled = false;
     }
    // Display option starts
     function dbldis(){   
         document.getElementById("scrn").value = "dis";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("bck").style.display = "block";
         document.getElementById("dblId").required = true;
         document.getElementById('dblName').disabled = true;
     }
//     (Programming_Language) Display option end
 </script>
    <script>
//     During Get operation got data from backend and pass to display fields
     
     if(<%= request.getAttribute("getnm") %> === 2){   
         document.getElementById('dblId').value = '<%= request.getAttribute("dblId") %>';
         document.getElementById('dblName').value = '<%= request.getAttribute("dblName") %>';
     }
 </script>     
    </body>
</html>




