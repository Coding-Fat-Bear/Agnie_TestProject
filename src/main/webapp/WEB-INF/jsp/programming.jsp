
<%-- 
    Document   : department
    Created on : 3 Jan, 2022, 9:46:29 PM
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
        <title>Programming Language</title>
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
                    <button type="button" class="dropbtn"><%= request.getAttribute("PGM")%></button>
                    <div id="drpcnt" class="dropdown-content">

                        <li><button type="button" id="cre" onclick="progcre();" class="menu" ><%= request.getAttribute("EMC")%></button></li>
                        <li><button type="button" id="cha" onclick="progcha();" class="menu" ><%= request.getAttribute("EMED")%></button></li>
                        <li><button type="button" id="dis" onclick="progdis();" class="menu" ><%= request.getAttribute("EMDIS")%></button></li>

                    </div>
                </div>  
            </div>

            <div id="hed" class="head" >
             <input type="text" style="width:53px;" maxlength="7" name="weblng" id="weblng" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="emnum" id="emnum" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="scrn" id="scrn" hidden>
                <ul class="opbut">
                    
                    <li><button  type="submit" id="crebut" style="cursor: pointer;display:block;text-align:center;" formaction="insertprog" title="Create Programming Language" ><i class="fa fa-file"></i></button></li>
                    <li><button type="submit" id="getbut" formaction="getprog" style="cursor: pointer;border: none;border-radius:5px;display:none;text-align:center;font-size:20px" title="Get Programming Language Data" ><i class="fa fa-glasses"></i></button></li>
                    <li><button type="submit" id="chabut" formaction="updateprog" style="cursor: pointer;display:none;text-align:center;font-size:20px" title="Update Programming Language" ><i class="fa fa-save"></i></button></li> 
                    <li><button type="submit" id="delbut" formaction="delprog" style="cursor: pointer;display:none;text-align:center;font-size:20px" title="Delete Programmming Language" ><i class="fa fa-trash"></i></button></li> 

                </ul>

                <ul>
                    <li><label for="progId">Programming Language ID</label><input maxlength="3" style="width:60px;" type="text" name="progId" id="progId" /></li>
                    <li><label for="progName"><%= request.getAttribute("PGM")%></label><input maxlength="30" style="width:226px;" type="text" name="progName" id="progName" /></li>
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
            
         document.getElementById("scrn").value = "cha";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "block";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "block";
         document.getElementById("progId").required = true;
         document.getElementById("progName").disabled = false;
      }
       if('<%= request.getAttribute("scrn") %>' === 'dis')
       {
            
         document.getElementById("scrn").value = "dis";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("progId").required = true;
         document.getElementById("progName").disabled = true;
     }
     if('<%= request.getAttribute("scrn") %>' === 'cre'){
            
         document.getElementById("scrn").value = "cre";
         document.getElementById("crebut").style.display = "block";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "none";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("progId").required = true;
         document.getElementById("progId").value = "";
         document.getElementById('progName').value = "";
     }
    </script>
        
    <script> 
//     change option starts
     function progcha(){
         
         document.getElementById("scrn").value = "cha";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "block";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "block";
         document.getElementById("progId").required = true;
         document.getElementById('progName').disabled = false;
        }
     // create option starts
     function progcre(){
         
         document.getElementById("scrn").value = "cre";
         document.getElementById("crebut").style.display = "block";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "none";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("progId").required = true;
         document.getElementById('progName').disabled = false;
     }
    // Display option starts
     function progdis(){   
         document.getElementById("scrn").value = "dis";
         document.getElementById("crebut").style.display = "none";
         document.getElementById("chabut").style.display = "none";
         document.getElementById("getbut").style.display = "block";
         document.getElementById("delbut").style.display = "none";
         document.getElementById("progId").required = true;
         document.getElementById('progName').disabled = true;
     }
//     (Programming_Language) Display option end
 </script>
    <script>
//     During Get operation got data from backend and pass to display fields
     
     if(<%= request.getAttribute("getnm") %> === 2){   
         document.getElementById('progId').value = '<%= request.getAttribute("progId") %>';
         document.getElementById('progName').value = '<%= request.getAttribute("progName") %>';
     }
 </script>     
    </body>
</html>
