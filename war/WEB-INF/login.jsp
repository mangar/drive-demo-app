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
    <br />
    <p>Esta aplica&ccedil;&atilde;o solicita a permiss&atilde;o do usu&aacute;rio para: 
    <b>(1)</b> listar os documentos dado uma palavra chave, 
    <b>(2)</b> envia um documento .docx para o Google Drive e o 
    <b>(3)</b> converte para o formato nativo .gdoc</p>

	<p>Toda a documenta&ccedil;&atilde;o deste site voc&ecirc; pode encontrar aqui: <a href="#">http://codeinfected.com/blog/aaaaa</a></p>
	<p>O c&oacute;digo fonte est&aacute; dispon&iacute;vel no Github: <a href="https://github.com/mangar/drive-demo-app.git" target="_github">https://github.com/mangar/drive-demo-app.git</a></p>

	<hr>

	<p>
		Listar arquivos com a palavra chave: <br>
		<input id="searchkey" type="text" class="search-query" placeholder="Search">
	</p>


    <a href="#" 
    onclick="window.open('<%= request.getAttribute("url")%>&state=' + document.getElementById('searchkey').value, '_self')"
    class="btn btn-large btn-info">Listar arquivos e Criar Documento</a>
    
    
    
  </div>
  <br />
<%@include file="footer.jsp" %>
</body>
</html>