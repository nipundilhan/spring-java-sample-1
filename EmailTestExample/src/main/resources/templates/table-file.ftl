<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Java Techie Mail</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}
</style>
</head>

<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="center" valign="top" bgcolor="#838383"
				style="background-color: #838383;"><br> <br>
				<table width="600" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="center" valign="top" bgcolor="#d3be6c"
							style="background-color:#6699ff; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color: #000000; padding: 0px 15px 10px 15px;">
							
							<div style="font-size: 48px; color:blue;">
								<table border=1> 
									 <tr>
    									<th>no</th>
    									<th>name</th>
 									 </tr>
 									 <#list students as stdnt>
    									<tr><td>${stdnt.no}<td>${stdnt.name} name of student
 									 </#list>
								</table>
							</div>
							

							<div>
								
								<br>"Sharing the knowledge is biggest learning" <br> <br>
								<br> <br> <b>${Name}</b><br>${location}<br>
								<br>
							</div>
						</td>
					</tr>
				</table> <br> <br></td>
		</tr>
	</table>
</body>
</html>