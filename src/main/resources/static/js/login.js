function clique(){
	let u_name = document.getElementById("username").value;
	let pwd = document.getElementById("pwd").value;
	
	fetch("/login", {
		method: "POST",
		headers: {
			"Content-Type": "application/JSON"
		},
		body: JSON.stringify({username: u_name, password: pwd})
		
	}).then(function(response){
		console.log(response);
		if(response.status == 200){
			response.json().then(function(data){
				console.log(data);
				localStorage.setItem("user", JSON.stringify(data));
				document.location = "profile.html";
			})
		}
		
	}).catch(function(error){
		console.log(error);
	})
	
}