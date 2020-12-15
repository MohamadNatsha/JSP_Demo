<!DOCTYPE html>
<html lang="en" class = "full-scale">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./css/main.css">
    
    	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body class = "full-scale">
	<div id = "blackbox" class = "full-scale blackbox center">
		<div class="loader"></div>
	</div>
    <div class = "full-scale center">
        <div class="box">
            <div class="information-box">
                <div class="line">
                    <h1>User data</h1>
                    <div>
                    	<div > <h3> Name : </h3> <p id = "name"> </p> </div>
                    	<div> <h3> Email : </h3> <p id = "email"> </p></div>
                    	<div> <h3> Phone : </h3> <p id = "phone"> </p></div>
                    	<div> <h3> Type : </h3> <p id = "type"> </p></div>
                    	<div style = "height:200px"> <h3> description : </h3> <p id = "desc"> </p></div>
                    </div>
                </div>
            </div>
            <div class = "uploads-view">
            	<img id ="image" src="https://www.generationsforpeace.org/wp-content/uploads/2018/07/empty.jpg" width = "250px">
           		<iframe id = "video" width="250px" height="160" src="https://www.youtube.com/embed/2HGC8XAR_Pg" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
        </div>
    </div>
</body>
<script src="js/ViewAccount.js"></script>
</html>