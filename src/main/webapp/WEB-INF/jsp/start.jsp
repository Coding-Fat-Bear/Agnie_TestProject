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
	
	<li><button id="opnbt" class="openbtn" onclick="openNav()">☰ Menu</button></li>
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
                <div onclick="tiledrop(this.id);" id="im1" class="tile" title="<%= request.getAttribute("INQM") %>">
                    <div class="mstic" style="margin-left:8px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("INQM") %></label>
                    <i id="im1" class='fas fa-file' style='font-size:93px;'></i></div>
                    <div id="im1" class="content">
                        <ul>
                        <li><button formaction="inqcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="inqcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="inqdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="emplst" class="opt"><%= request.getAttribute("EMLST") %></button></li>
                        </ul>
<!--                        <ul>
                            <li><button type="button" id="im1" onclick="retn(this.id);" class="ret" >cre</button></li>
                        </ul>-->
                      </div>                      
                </div>
                        <button type="button" id="im1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>        
                
                <div class="tildiv">
                <div onclick="tiledrop(this.id);" id="bpm1" class="tile" title="<%= request.getAttribute("BPM") %>">
                    <div class="mstic" style="margin-left:8px">
                        <label style="font-size:17px;color:black"><%= request.getAttribute("BPM") %></label>
                    <i id="bpm1" class='fas fa-handshake' style='font-size:93px;'></i></div>
                    <div id="bpm1" class="content">
                        <ul>
                        <li><button formaction="bpmcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="bpmcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="bpmdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="bpmlst" class="opt"><%= request.getAttribute("EMLST") %></button></li>
                        </ul>
<!--                        <ul>
                            <li><button type="button" id="im1" onclick="retn(this.id);" class="ret" >cre</button></li>
                        </ul>-->
                      </div>                      
                </div>
                        <button type="button" id="bpm1" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>  
                </div>
           <div class="tildiv">
            <div onclick="tiledrop(this.id);" id="est" class="tile" title="<%= request.getAttribute("ESTMS") %>">
                <div class="mstic" style="margin-left:8px">
                    <label style="font-size:17px;color:black"><%= request.getAttribute("ESTMS") %></label>
                    <i id="est" class="fa fa-calculator" style='font-size:93px;'></i></div>
                      <div id="est" class="content">
                        <ul>
                        <li><button formaction="estcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="estcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="estdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="estdel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul> 
<!--                        <ul>
                            <button type="button" id="em1" onclick="retn(this.id);" class="ret" >cre</button>
                        </ul>-->
                      </div>                        
                </div>
                        <button type="button" id="est" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>
                </div> 
                        
             <div class="tildiv">
            <div onclick="tiledrop(this.id);" id="prj" class="tile" title="<%= request.getAttribute("PRJMS") %>">
                <div class="mstic" style="margin-left:8px">
                    <label style="font-size:17px;color:black"><%= request.getAttribute("PRJMS") %></label>
                    <i id="prj" class="fas fa-project-diagram" style='font-size:93px;'></i></div>
                      <div id="prj" class="content">
                        <ul>
                        <li><button formaction="prjcre" class="opt" ><%= request.getAttribute("EMC") %></button></li>
			<li><button formaction="prjcha" class="opt"><%= request.getAttribute("EMED") %></button></li>
                        </ul>
                        <ul>
			<li><button formaction="prjdis" class="opt"><%= request.getAttribute("EMDIS") %></button></li>
                        <li><button formaction="prjdel" class="opt"><%= request.getAttribute("EMDEL") %></button></li>
                        </ul> 
                      </div>                        
                </div>
                        <button type="button" id="prj" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>
                </div> 
                        
            <div class="tildiv">
            <div onclick="tiledrop(this.id);" id="po" class="tile" title="Purchase Order">
                <div class="mstic" style="margin-left:8px">
                    <label style="font-size:17px;color:black">Purchase Order</label>  
                    <i id="po" class="fas fa-shopping-cart" style='font-size:93px;'></i></div>
                      <div id="po" class="content">
                        <ul>
                        <li><button formaction="pocre" class="opt">Create</button></li>
			<li><button formaction="pocha" class="opt">Change</button></li>
                        </ul>
                        <ul>
			<li><button formaction="podis" class="opt">Display</button></li>
                        <li><button formaction="podel" class="opt">Delete</button></li>
                        </ul> 
                      </div>                        
                </div>
                        <button type="button" id="po" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>
                </div>   
             <div class="tildiv">
            <div onclick="tiledrop(this.id);" id="prr" class="tile" title="Project Revenue Report">
                <div class="mstic" style="margin-left:8px">
                    <label style="font-size:17px;color:black">Project Revenue</label>  
                    <i id="prr" class="fas fa-money-bill-alt" style='font-size:93px;'></i></div> 
                      <div id="prr" class="content">
                        <ul>
                        <li><button formaction="prjrevrep" class="opt">Create</button></li>
			<li><button formaction="prjrevrep1" class="opt">Change</button></li>
                        </ul>
                        <ul>
			<li><button formaction="prjrevrep2" class="opt">Display</button></li>
                        <li><button formaction="prjrevrep3" class="opt">Delete</button></li>
                        </ul> 
                      </div>                        
                </div>
                        <button type="button" id="prr" onclick="retn(this.id);" class="ret" ><i class="fa fa-undo"></i></button>
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
                    tblk.style.backgroundColor = "white"; 
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
