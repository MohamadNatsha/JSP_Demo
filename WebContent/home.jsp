<!DOCTYPE html>
<html lang="en" class="full-scale no-overflow">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP_Demo</title>
        <link rel="stylesheet" href="./css/main.css">
    <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body class="full-scale no-overflow">
    <div class="full-scale center">
	    <form class = "form-box" action="SaveAccount" method="post"  enctype="multipart/form-data">
		    <div class="form-group">
			    <label for="name">Name</label>
			    <input type="text" class="form-control" id="name" name="name" placeholder="Username" required>
			  </div>
			  <div class="form-group">
			    <label for="email">Email address</label>
			    <input type="email" class="form-control" id="email"  name="email" placeholder="Enter email" required>
			  </div>
			  <div class="form-group">
			    <label for="phone">Phone Number</label>
			    <input type="tel" class="form-control" id="phone" name = "phone" placeholder="phone" required>
			  </div>
			  <div class="form-group">
			    <label for="type">User type</label>
			    <select class="form-control" id="type" name = "type" required>
			      <option>User</option>
			      <option>Admin</option>
			      <option>Spectator</option>
			 
			    </select>
			  </div>
			  <div class="mb-3">
			    <label for="desc">Description</label>
			    <textarea class="form-control is-invalid" id="desc" name = "desc" placeholder="Please Enter your Description" required></textarea>
			    <div class="invalid-feedback">
			      
			    </div>
			  </div>
      
      
                <div>
                    <br>
                    <input accept="image/*" type = "file" name = "image" size = "50" />
                </div>
                <div> 
                     <br>
                    <input accept="video/*" type = "file" name = "video" size = "50" />
                     <br>
                </div>
           
              <button type="submit" class="btn btn-primary">Add User</button>
        </form>
    </div>
  
</body>
</html>