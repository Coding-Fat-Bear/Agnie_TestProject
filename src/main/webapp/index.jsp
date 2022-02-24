<%-- 
    Document   : index
    Created on : Oct 21, 2021, 12:13:37 AM
    Author     : Agnie Lijoe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
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
    color: #848484;
    background-color: #F4F6F9;
    background-size: 100%;
    overflow:hidden;
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

/*.header-inner img {
  float: right;
  margin:30px;
  position: relative;
  display:inline;
  left: 5.5%; 
  top: 35px; 

}*/


 .form1{
    /*width:120px;*/
    position: absolute;
    float: left;
    display: block;
    width:400px;
    height:330px;
    background-color: white;
    color: rgb(22, 50, 92);
    margin-top: 60px;
    margin-left: 300px;
    padding: 1.25rem;
    border-radius : 0.25rem;
    border: 1px solid rgb(216, 221, 230);
    
}

.form1 li{
    display:grid;
    margin-bottom:20px;
    text-decoration: none;
    list-style-type: none
    
}

.form1 .but{
     background-color: #0070d2;
    color: white;
    transition: all 0.1s;
    border: 1px solid transparent;
    padding: 12px 24px;
    border-radius: 4px;
    cursor: pointer;
    background-image: none !important;
    
}
.form1 .but:hover{
    background-color: #05659f
}
.form1 input{
    border: 1px solid #D8DDE6;
    border-radius: 4px;
    border-image-source: initial;
    border-image-slice: initial;
    border-image-width: initial;
    border-image-outset: initial;
    border-image-repeat: initial;
    background-color: #fff;
    font-family: SFS, Arial, sans-serif;
    box-sizing: border-box;
    -webkit-appearance: none;
    font-size: .8125rem;
    transition: all 0.1s;
    width: 100%;
    padding: 12px;
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
form i {
    
    float:right;
    cursor: pointer;
}
    </style>
    
    <body>
        <header>
        <div class="header-inner1">
	<h1><a href="index.htm">
                <img src="http://www.agnieconsulting.com/assets/img/logo.gif" class="logo" alt="Agnie India" >
            </a></h1>
	</div>
      </header>
    
      <div id="frm" class="form1">
            <form action="login2"  method="post">
                <!--<pre>-->
                    <lable id="lab" style="display:none;color:red;background-color:pink">Please check username and password...!</lable>
                    <lable for="uname">Username:</lable>
                    <li><input id='uname' placeholder="enter username" oninvalid="this.setCustomValidity('Enter Username')"  type="text"  name="uname" required></li>                    
                    <lable for="pass">Password:</lable>
                    <li><input id="pass" placeholder="enter password" oninvalid="this.setCustomValidity('Enter Password')" type="password" name="pass" required></li>
                    <li><label  for="weblng" style="width:196px" >Language : </label>
                        <select type="text"  style="width:120px;text-transform:uppercase"  name="weblng" id="weblng" >
                         <option value=""></option>
                         <option value="EN">English</option>
                         <option value="JA">Japanese</option>
                     </select></li>
                  
                    
                    <li><button type="submit" class="but" >Login</button></li>
  
            </form>
          <div>
                        <!--<form action="usrcre" mothed="post">-->
                        <button type="button" onclick="usrcre()" class="but1">Create User</button>
                        <!--</form>-->
                        <a href="#" style="float:right;margin-top:-25px">New Password</a>
                    </div>
      </div>
        
        <script>
            if(<%= request.getAttribute("appnm") %> === 1){
                    document.getElementById("lab").style.display = "block";
                    document.getElementById("frm").style.height = "350px";
                        }
        </script>
        
        <script>
            function usrcre(){
                
                window.location = 'usercre.jsp';
            }
        </script>
                    
              
    </body>
</html>
