function updateData(data){
	$("#name").text(data.Name?data.Name:"");
	$("#email").text(data.Email?data.Email:"");
	$("#phone").text(data.Phone?data.Phone:"");
	$("#desc").text(data.Desc?data.Desc:"");
	$("#type").text(data.AccountType?data.AccountType:"");
	$("#image").attr("src",data.Image?data.Image:"");
	$("#video").attr("src",data.Video?data.Video:"");
}

function hideLoadingScreen(){
	$("#blackbox").css("display", "none");
}

$(() => {
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const email = urlParams.get('email');
	console.log(email);
	  $.ajax({
	  url: "accountData?", 
	  type: 'GET',
      data: { "email": email} ,
	  success: function(result){
	    updateData(result);
	    hideLoadingScreen();
	  }});

});