<%-- 
Document   : prjrevrep
Created on : Mar 7, 2022, 8:42:37 AM
Author     : Admin
--%>

<%@page import="java.sql.CallableStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Project Revenue Report</title>
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
.opbut {
    display:block;
    margin:10px
}
.opbut ul {

    margin:30px;
    text-decoration: none;
    list-style-type: none;
    margin-left: 5px;

}

.opbut ul li{
    display:inline-block;
    margin-right:0px;
    color: black;
    text-decoration: none;
    margin-bottom: 5px;

}

table, th, td {
position: relative;
border: 1px solid black;
width: auto;
height: auto;
/*background-color: #555;*/
margin-left: 10px;
transition-property: height;
transition-duration: 2s;
/*top: 5%;*/
}

</style>  
<body>
    <h1 align="center">Project Revenue Report</h1>
    <form method="post">
    <div>
        <ul class="opbut">
            <li><label for="prjno" style="width:120px">Project No</label> <input type="text" name="prjno" size="10" maxlength="9" id="prjno" > </li>  
            <li><input type="submit" value="Get Report" id="revrep" onclick="GetData()" style="cursor: pointer" > </li>
            <!--<li><input type="submit" value="Get Report" id="getrep" formaction="getreport" style="cursor: pointer" > </li>-->
        </ul>
    </div>

      <table style="display:none;overflow-x: auto" id="reptbl" name="reptbl" class="reptbl">
        <%
                  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                  Connection con = null;
                  Statement stm = null;
                //  String pno = request.getParameter("prjno");
           %>
       <%   
              try
              {
                  // String pno = request.getParameter("prjno");
                  Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                  String sqlmst = "{call agnieportal.prj_procedure('PRJ01')}";
                  con = DriverManager.getConnection("jdbc:mysql://agn.db.mysql.agnieindia.com:3306/agnieportal","db_user","AgnChennai@2021");
                  stm = con.createStatement();
                  ResultSet rs2 = stm.executeQuery(sqlmst);
                  while(rs2.next())
                  {
                      %>
          <tr>
          <th>Project No</th>  
          <th>Project Name</th> 
          <th>End User</th>
          <th>Prj Start Date</th>
          <th>Prj End Date</th>
          <th>Sales Rep</th>
          <th>Business Partner</th>
          <th>Consultants</th> 
          <th>Rank</th>              
          <th>Buying Rate(Cost)</th>  
          <th>Selling Rate(Revenue)</th> 
<!--              <th>Payment Terms</th>
          <th>Delivery Place</th>
          <th>Deliverables</th>
          <th>Status</th>
          <th>PO H Tex</th>
          <th>PO I Text</th> 
          <th>PO Texts</th>
          <th>Flag</th>-->
        </tr>          
           <tr>
           <td><%=rs2.getString("PRJNO") %></td> <!--0-->
           <td><%=rs2.getString("PRJDES") %></td>   <!--1-->
           <td><%=rs2.getString("EUSRNO") %></td> <!--2-->
           <td><%=rs2.getString("FRMDT") %></td>  <!--3-->
           <td><%=rs2.getString("TODT") %></td>  <!--4-->
           <td><%=rs2.getString("EMPNAM") %></td>  <!--5-->
           <td><%=rs2.getString("BPDES") %></td>  <!--6-->
           <td><%=rs2.getString("BPNAME") %></td>  <!--7-->
           <td><%=rs2.getString("RNK_TEXT") %></td>   <!--8-->
           <td><%=rs2.getString("RATE") %></td>   <!--9-->
           <td><%=rs2.getString("SELRATE") %></td>  <!--10-->
<!--               <td><%=rs2.getString("PAYTRMS") %></td>  11
           <td><%=rs2.getString("DELLOC") %></td>  12
           <td><%=rs2.getString("DELVRBLS") %></td>  13
           <td><%=rs2.getString("POSTATUS") %></td>  14
           <td><%=rs2.getString("POHTXT") %></td>  15
           <td><%=rs2.getString("POITXT") %></td>  16
           <td><%=rs2.getString("POTXTS") %></td>  17               
           <td><%=rs2.getString("ACTFLG") %></td>  18             -->
           </tr>
            <%
                  }
              }
              catch(Exception ex){
                System.out.println("Error"+ex.getMessage());
              }
              con.close();
              %>


        </table>   

   </form>
   <script>
      function GetData(){
          var btn = document.getElementById("revrep");
          var table = document.getElementById("reptbl");
          if(table.style.display === "none")
              table.style.display = "block";           
          else
              table.style.display = "none";   
      }
   </script>           
</body>
</html>
