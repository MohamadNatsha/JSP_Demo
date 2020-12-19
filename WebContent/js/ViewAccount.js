function updateData(data){
	$("#box").html(data);
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