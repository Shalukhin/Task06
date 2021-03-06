<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto&display=swap">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Alfa+Slab+One|Sen&display=swap">



</head>


<header>
	
</header>

<body background="view/pict/background.gif">

<style>	   
<%@ include file="css/bootstrap.min.css"%>
<%@include file="css/styles.css"%>
</style>

<br>
		<h4>
			<p style="text-align: center;">
				<strong>XML Парсер</strong>
			</p>
		</h4>

	<div class="container">
		<div class="grid">
			<form action="do?command=parse" method="post" enctype="multipart/form-data">
				<div class="row">
					<div class="col-md-6">
						<div class="custom-file">
							<input type="file" name="file" class="custom-file-input"
								id="customFile"> <label id="customFileLabel"
								class="custom-file-label" for="customFile">Выберете xml файл</label>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-5">
						<select class="custom-select" name="parser">
							<option selected>Выберете парсер</option>
							<option value="DOM">DOM</option>
							<option value="SAX">SAX</option>
							<option value="STAX">STAX</option>
						</select>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-1">
						<button type="submit" class="btn btn-light" name="command"
							value="parse">Распарсить</button>
					</div>
				</div>
			</form>
			<div class="row">
				<div class="col-md-6">
					<div class="illegal-file-message">${illegalFileMessage }</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		
	<%@ include file="js/jquery-3.3.1.min.js"%>
		
	<%@ include file="js/bootstrap.min.js"%>
		
	<%@ include file="js/popper.min.js"%>
		
	<%@ include file="js/main.js"%>
		
	</script>

	<script type="application/javascript">
		
    $('input[type="file"]').change(function(e){
        var fileName = e.target.files[0].name;
        $('.custom-file-label').html(fileName);
    });

	</script>
</body>
</html>
