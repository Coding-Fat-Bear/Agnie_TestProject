<%-- 
    Document   : start
    Created on : 2021/11/27, 0:08:15
    Author     : Agnie
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
        <title>Home Page</title>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    </head>
    <style>
        
        @charset "UTF-8";

html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, font, img,img1 ins, kbd, q, s, samp,
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
  height: 120px;
  overflow: hidden;
  z-index: 50
}
header li{
	text-decoration: none;
    list-style-type: none;
	display:inline-block
	
	
}

 header::after{
  content: "";
  display: table;
  clear: both;
  bottom: 0px;
}

.header-inner{
	float: right;
  width: 100%;
  /* margin: auto; */
  /* position: relative; */
}

.header-inner h1 {
  float: right;
  margin:30px;
	position: relative;
	display:inline;
  /* left: 5.5%; */
	/* top: 35px; */

}

.logcont nav{
  float: left;
  position: relative;
  border-style: groove;
  height: 300px;
  margin-top: 100px;
	right: 0;
  left: 50px;
}

nav ul{
  top: 50px;
 display: grid;
 position: center;
 margin: 100px;
  list-style: none;

  /* height: 50vh; */
}

nav li {
  float: none;
  align-items: center;
  margin-bottom: 30px;
	color: rgb(14, 13, 13);

  /* padding-bottom: 10px; */

}

.sidebar {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidebar a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidebar a:hover {
  color: #f1f1f1;
}

.sidebar .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

.openbtn {
  font-size: 20px;
  cursor: pointer;
  background-color: transparent;
  color: white;
  margin:20px;
  padding: 10px 15px;
  border: none;
}

.openbtn:hover {
  background-color: #444;
}

#main {
  transition: margin-left .5s;
  padding: 0px;
}

.collapsible {
  background-color: #777;
  color: white;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  border: none;
  text-align: left;
  outline: none;
  font-size: 15px;
}

.active, .collapsible:hover {
  background-color: #555;
}

.content {
  /*padding: 0 18px;*/
  width: 180px;
  height: 160px;
  display: none;
  overflow: hidden;
  background-color: transparent;
      /*rgb(14 13 13);*/
/*  border: 2px ridge #cacad3;
  border-radius: 10px;*/
}
.content ul{
  margin-left:12px;
  /*margin-top: 10px;*/
  margin-bottom: 2px;
 display: inline;
 position: center;
  list-style: none;  
}
.content ul li{
    border: 2px ridge #cacad3;
    border-radius: 10px;
    background-color: white;
    display: inline-block;
    margin-bottom: 4px;
    /*margin-top: 5px;*/
    margin-right: 3px;
    width: 70px;
    height: 70px
}
.opt{
    display: inline-block;
  background-color: transparent;
  color: black;
  cursor: pointer;
  width: 70px;
  height: 70px;  
  border: none;
  text-align: center;
  outline: none;
  font-size: 15px;
}

.opt:hover{
	color: red;
        box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23)
}



.opt:active {
  background-color: #cacad3;
  /*box-shadow: 0 2px #666;*/
  transform: translateY(4px);
}


/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
@media screen and (max-width: 810px){
	
	
	.logcont nav{
		width:70%
	}
	
	nav ul{
		width:50%;
		margin:20px	
	}
}

.tile{
    width:150px;
    height:150px;
    display: inline-block;
    cursor: pointer;
    margin: 20px;
    background-color: white;
    border: 2px ridge #cacad3;
    border-radius: 10px;
    /*box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23)*/
}

.tile:hover{
    box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23)
}

.tile:active {
  background-color: #cacad3;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
.tildiv{
    display: inline-block;
    cursor: pointer;
    margin: 0px;
    height: 180px
}

.ret{
    width: 160px;
    display:none;
    margin-left: 30px;
    background-color: yellowgreen;
    cursor: pointer
}
        
    </style>
    <body id="main">
        
         <header>
  <!-- <div class="header-inner"> -->
    <li style="float:right;margin:30px"><h1><a href="index.html"><img src="http://www.agnieconsulting.com/assets/img/logo.gif" class="logo" alt="Agnie India" ></a></h1></li>

  <!-- </div> -->
</header>
        <form>
            <input type="text" style="width:53px;" maxlength="7" name="weblng" id="weblng" hidden>
            <input type="text" style="width:53px;" maxlength="7" name="emnum" id="emnum" hidden>
            <div class="tildiv">
            <div onclick="tiledrop(this.id);" id="em1" class="tile" title="<%= request.getAttribute("EMM") %>">
                <div class="mstic" style="margin-left:8px">
                    <label style="font-size:17px;color:black"><%= request.getAttribute("EMM") %></label>
                    <i id="em1" class='fas fa-id-card' style='font-size:93px;'></i></div>
                      <div id="em1" class="content">
                        <ul>
                        <li><button formaction="empcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="empcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="empdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="emplst" class="opt"><%= request.getAttribute("EMLST") %></button></li>
                        </ul> 
<!--                        <ul>
                            <button type="button" id="em1" onclick="retn(this.id);" class="ret" >cre</button>
                        </ul>-->
                      </div>                        
                </div>
                        <button type="button" id="em1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>
                </div>
                
               <div class="tildiv">
                <div onclick="tiledrop(this.id);" id="dep1" class="tile" title="<%= request.getAttribute("DEP") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("DEP") %></label>
                    <i id="dep1" class='fas fa-file' style='font-size:93px;'></i></div>
                    <div id="dep1" class="content">
                        <ul>
                        <li><button formaction="depcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="depcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="depdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="depdel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="dep1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>    
                        
             <div class="tildiv">
                <div onclick="tiledrop(this.id);" id="lang1" class="tile" title="<%= request.getAttribute("LAN") %>">
                    
                    <div class="mstic" style="margin-left:1px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("LAN") %></label>
                    <i id="lang1" class='fas fa-language' style='font-size:110px;'></i></div>
                    <div id="lang1" class="content">
                        <ul>
                        <li><button formaction="langcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="langcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="langdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="langdel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="lang1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>    
               
                <div class="tildiv">
                <div onclick="tiledrop(this.id);" id="pro1" class="tile" title="<%= request.getAttribute("PGM") %>">
                    
                    <div class="mstic" style="margin-left:2px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("PGM") %></label>
                    <i id="pro1" class='fas fa-laptop-code' style='font-size:70px;'></i></div>
                    <div id="pro1" class="content">
                        <ul>
                        <li><button formaction="progcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="progcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="progdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="progdel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="pro1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>    
                  
           <div class="tildiv">
                <div onclick="tiledrop(this.id);" id="mod1" class="tile" title="<%= request.getAttribute("MOD") %>">
                    
                    <div class="mstic" style="margin-left:2px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("MOD") %></label>
                    <i id="mod1" class='fas fa-tasks' style='font-size:100px;'></i></div>
                    <div id="mod1" class="content">
                        <ul>
                        <li><button formaction="modcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="modcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="moddis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="moddel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="mod1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>    
                        
                        
           <div class="tildiv">
                <div onclick="tiledrop(this.id);" id="pay1" class="tile" title="<%= request.getAttribute("PAY") %>">
                    
                    <div class="mstic" style="margin-left:2px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("PAY") %></label>
                    <i id="pay1" class='fas fa-money-check' style='font-size:93px;'></i></div>
                    <div id="pay1" class="content">
                        <ul>
                        <li><button formaction="paycre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="paycha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="paydis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="paydel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="pay1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>  
               <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="gen1" class="tile" title="<%= request.getAttribute("GEN") %>">
                    
                    <div class="mstic" style="margin-left:2px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("GEN") %></label>
                    <i id="gen1" class='fa fa-venus-mars' style='font-size:93px;'></i></div>
                    <div id="gen1" class="content">
                        <ul>
                        <li><button formaction="gencre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="gencha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="gendis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="gendel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="gen1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>  
                        
              <div class="tildiv">
                <div onclick="tiledrop(this.id);" id="ran1" class="tile" title="<%= request.getAttribute("RAN") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("RAN") %></label>
                    <i id="ran1" class='fas fa-arrow-up' style='font-size:124px;'></i></div>
                    <div id="ran1" class="content">
                        <ul>
                        <li><button formaction="rancre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="rancha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="randis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="randel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="ran1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>          
                  
              
         <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="con1" class="tile" title="<%= request.getAttribute("CON") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("CON") %></label>
                    <i id="con1" class='fas fa-globe' style='font-size:93px;'></i></div>
                    <div id="con1" class="content">
                        <ul>
                        <li><button formaction="concre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="concha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="condis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="condel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="con1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>          
                  
                
                        
         <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="pha1" class="tile" title="<%= request.getAttribute("PHA") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("PHA") %></label>
                    <i id="pha1" class='fa fa-table' style='font-size:100px;'></i></div>
                    <div id="pha1" class="content">
                        <ul>
                        <li><button formaction="phacre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="phacha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="phadis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="phadel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="pha1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>     
             
        <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="ban1" class="tile" title="<%= request.getAttribute("BAN") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("BAN") %></label>
                    <i id="ban1" class='fas fa-piggy-bank' style='font-size:100px;'></i></div>
                    <div id="ban1" class="content">
                        <ul>
                        <li><button formaction="bancre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="bancha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="bandis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="bandel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="del1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>     
        <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="dbl1" class="tile" title="<%= request.getAttribute("DBL") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("DBL") %></label>
                    <i id="dbl1" class='fas fa-draw-polygon' style='font-size:100px;'></i></div>
                    <div id="dbl1" class="content">
                        <ul>
                        <li><button formaction="dblcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="dblcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="dbldis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="dbldel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="dbl1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div> 
                        
         <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="dlc1" class="tile" title="<%= request.getAttribute("DLC") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("DLC") %></label>
                    <i id="dlc1" class='fa fa-map-marker' style='font-size:100px;'></i></div>
                    <div id="dlc1" class="content">
                        <ul>
                        <li><button formaction="dlccre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="dlccha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="dlcdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="dlcdel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="dlc1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div> 
      <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="biz1" class="tile" title="<%= request.getAttribute("BIZ") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("BIZ") %></label>
                    <i id="biz1" class='fas fa-business-time' style='font-size:100px;'></i></div>
                    <div id="biz1" class="content">
                        <ul>
                        <li><button formaction="bizcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="bizcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="bizdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="bizdel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="biz1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div> 
                        
           <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="emt1" class="tile" title="<%= request.getAttribute("EMT") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("EMT") %></label>
                    <i id="emt1" class='fa fa-id-card' style='font-size:100px;'></i></div>
                    <div id="emt1" class="content">
                        <ul>
                        <li><button formaction="emtcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="emtcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="emtdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="emtdel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="emt1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div> 
         <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="rol1" class="tile" title="<%= request.getAttribute("ROL") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("ROL") %></label>
                    <i id="rol1" class='fa fa-file' style='font-size:100px;'></i></div>
                    <div id="rol1" class="content">
                        <ul>
                        <li><button formaction="rolcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="rolcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="roldis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="roldel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="rol1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div> 
              <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="com1" class="tile" title="<%= request.getAttribute("COM") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("COM") %></label>
                    <i id="com1" class='fa fa-building' style='font-size:100px;'></i></div>
                    <div id="com1" class="content">
                        <ul>
                        <li><button formaction="comcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="comcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="comdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="comdel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="com1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div> 
                        
         <div class="tildiv">
              <div onclick="tiledrop(this.id);" id="cur1" class="tile" title="<%= request.getAttribute("CUR") %>">
                    
                    <div class="mstic" style="margin-left:3px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("CUR") %></label>
                    <i id="cur1" class='fa fa-money-check' style='font-size:100px;'></i></div>
                    <div id="cur1" class="content">
                        <ul>
                        <li><button formaction="curcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="curcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="curdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="curdel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul>

                      </div>                      
                </div>
                        <button type="button" id="com1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div> 
        </form>                
                
<script>
    document.getElementById("weblng").value = '<%= request.getAttribute("weblng") %>';
    document.getElementById("emnum").value = '<%= request.getAttribute("emnum") %>';

</script>

<script>
        var cont1 = document.getElementsByClassName("content");
        var tile1 = document.getElementsByClassName("tile");
        var mstic = document.getElementsByClassName("mstic");
        var ret = document.getElementsByClassName("ret");
        var cont1id,tileid;
        var y = 0;
        function retn(retid){
        for(y = 0;y < cont1.length;y++){ 
//          cont1id = cont1[y].id;
//          tileid = tile1[y].id;
//        if(retid === cont1id){ 
        if(cont1[y].style.display === "block"){
            cont1[y].style.display = "none";
            ret[y].style.display = "none";
            tile1[y].style.display = "block";
            tile1[y].style.backgroundColor = "white";
            tile1[y].style.border = "2px ridge #cacad3";
            mstic[y].style.display = "block";
            break;
           
        }
//        }
        }
        }
        
</script>


<script>
        var tile = document.getElementsByClassName("tile");
        var cont = document.getElementsByClassName("content");
        var mstic = document.getElementsByClassName("mstic");
        var ret = document.getElementsByClassName("ret");
        var hvr = '.tile:hover{box-shadow: 0 3px 6px rgba(0,0,0,0.16), 0 3px 6px rgba(0,0,0,0.23)}';
        var actv = '.tile:active {background-color: #cacad3;box-shadow: 0 5px #666;transform: translateY(4px);}';
         var style =  document.createElement('style');
        var k, contid;
        var clstil = 0;
        var tbcl = "em1";
        function tiledrop(tilid){
            
            document.getElementById(tbcl).style.backgroundColor = "white";
            document.getElementById(tbcl).style.border = "2px ridge #cacad3";
            mstic[clstil].style.display = "block";
            cont[clstil].style.display = "none";
            ret[clstil].style.display = "none";
            for (k = 0; k < cont.length; k++) {    
            contid = cont[k].id;
            if(tilid === contid){
                var tblk = document.getElementById(tilid);
               if (cont[k].style.display === "block") {
                    cont[k].style.display = "none";
                    tblk.style.backgroundColor = "white" 
                    mstic[k].style.display = "block";
                    ret[k].style.display = "none";
                  } else {
                    cont[k].style.display = "block";
                    tblk.style.backgroundColor = "transparent";
                    tblk.style.border = "none";
                    tblk.style.boxShadow = "none";
                    tblk.style.transform = "none";
                    mstic[k].style.display = "none";
                    ret[k].style.display = "block";
                  }
              clstil = k;
              tbcl = tilid;
            }
            }
        }
</script>
        
    </body>
</html>
