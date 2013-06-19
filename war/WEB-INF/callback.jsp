<%@ page import="com.google.api.services.drive.model.File" %>
<%@ page import="java.util.*" %>

<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<script type="text/javascript">var NREUMQ=NREUMQ||[];NREUMQ.push(["mark","firstbyte",new Date().getTime()]);</script>
	<meta name="description" content="Google Drive Demo Upload a document to your Drive">
	<meta name="author" content="Marcio Mangar">
	<link href="http://bootsnipp.com/css/bootstrap.min.css" media="all" type="text/css" rel="stylesheet">
	<link href="http://bootsnipp.com/css/bootstrap-responsive.min.css" media="all" type="text/css" rel="stylesheet">
	<link href="http://bootsnipp.com/css/bootsnipp.css" media="all" type="text/css" rel="stylesheet">

<style>.center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;}</style>
<title>..::Google Drive Demo ::..</title>
<body>
  <div class="hero-unit center">
    <h1>Google Drive Demo </h1>
    
    <div>
    	<hr>
    	
  		<b>Code:</b> <%= request.getAttribute("code")%> <br>
  		<b>Access Token:</b> <%= request.getAttribute("accessToken")%> <br>
  		
  		<hr>
  		Critério de busca: <b><i><%= request.getAttribute("state")%></i></b> <br>
  		# arquivos no Drive: <%= request.getAttribute("arquivosNoDrive") %> <br>
  		<b>Listagem:</b>
  		<ul>
  		<% 
  		List<File> files = (List<File>)request.getAttribute("files");
  		
        for (File file : files) {
            %>
            <li><%= file.getTitle() %> </li>
        <%
        }  		
  		%>
  		</ul>
	
		<hr>

		<b>Arquivo criado com o ID:</b> 
		<a href="https://docs.google.com/document/d/<%= request.getAttribute("fileIdUploaded")%>/edit" target="_drive"><%= request.getAttribute("fileIdUploaded")%></a>
  		
  	</div>
        
  </div>
  
  
  
  
  <br />

</body>
</html>