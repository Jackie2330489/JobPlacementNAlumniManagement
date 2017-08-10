<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>

	<body>
		<script src="js/jquery-1.8.3.min.js"></script>

		<select id="sss" multiple="multiple">
			<optgroup label="kkkkkk">
				<option value="volvo">Volvo</option>
				<option value="saab">Saab</option>
				<option value="opel">Opel</option>
				<option value="audi">Audi</option>
			</optgroup>
			<optgroup label="kkkkkk">
				<option value="volvo">Volvo</option>
				<option value="saab">Saab</option>
				<option value="opel">Opel</option>
				<option value="audi">Audi</option>
			</optgroup>
		</select>

		<button class='btn'>点击显示</button>
		<div class="bg-model" style="position:absolute;top:0%;left:0%;display:none;background:rgba(0,0,0,0.3);width:100%;height:100%;position:fixed;z-index:9999">
			<div class='content' style="position: absolute;left: 35%;top: 25%;border-radius: 8px;background-color: #fff;">
				<a class="bg-model-ok" style="float: left;margin: 5px 0 0 8px;" href="#">X</a>
				<div style="clear: both;"></div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
				<div>hehehehe</div>
			</div>
		</div>
	</body>
	<script>
		$(document).ready(function() {
			$(".btn").click(function() {
				alert($("#sss").val());
			});
		});
	</script>

</html>