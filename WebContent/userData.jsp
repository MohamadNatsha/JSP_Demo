<div class="information-box">
	<div class="line">
		<h1>User data</h1>
		<div>
			<div>
				<h3>Name :</h3>
				<p id="name">${user.getName()}</p>
			</div>
			<div>
				<h3>Email :</h3>
				<p id="email">${user.getEmail()}</p>
			</div>
			<div>
				<h3>Phone :</h3>
				<p id="phone">${user.getPhone()}</p>
			</div>
			<div>
				<h3>Type :</h3>
				<p id="type">${user.getAccountType().toString()}</p>
			</div>
			<div style="height: 200px">
				<h3>description :</h3>
				<p id="desc">${user.getDesc()}</p>
			</div>
		</div>
	</div>
</div>

<div class="uploads-view">
	<img id="image" src="${user.getImageLink()}" width="250px">
	<iframe id="video" width="250px" height="160" src=" ${user.getVideoLink()}"
		frameborder="0"
		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
		allowfullscreen></iframe>
</div>
