<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JSP_Demo</title>
<link rel="stylesheet" href="./css/main.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

</head>
<body>
	<div>
		<div style="background: white; padding: 15px; margin: 20px">
			<h1>${msg}</h1>

			<form action="ViewAccount?" method="get">
				<input style="display: none" type="email" id="email" name="email"
					value="${param.email}">
				<button type="submit" class="btn btn-primary">View the data</button>
			</form>
		</div>
	</div>
</body>
</html>