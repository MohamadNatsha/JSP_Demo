<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP_Demo</title>
</head>
<body>
    <form action="SaveAccount" method="post"  enctype="multipart/form-data">
        <label for="name">name: </label><input type="text" name="name" id="name"> <br>
        <label for="email">email: </label><input type="email" name="email" id="email"> <br>
        <label for="phone">phone: </label><input type="tel" id="phone" name="phone"> <br>
        <textarea name="desc" id="" cols="30" rows="10"></textarea> <br>
        <select name="type" id="">
            <option value="later">later</option>
        </select>
        <br />
 
        <label for="image">Upload an image</label>
        <input type = "file" name = "image" size = "50" />
        <br />

        <label for="video">Upload a Video</label>
        <input type = "file" name = "video" size = "50" />
        <br />
        <button type="submit">add user</button>
    </form>
    
    <form action="UploadTest" method="post"  enctype="multipart/form-data">
 		 <label for="name">name: </label><input type="text" name="name" id="name"> <br>
        <label for="image">Upload an image</label>
        <input type = "file" name = "image" size = "50" />
        <br />
 		<label for="image">Upload an image2</label>
        <input type = "file" name = "image" size = "50" />
        <br />

        <button type="submit">add user</button>
    </form>
</body>
</html>