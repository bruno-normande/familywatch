
function clique(){
	let lat = document.getElementById("lat").value;
	let long = document.getElementById("long").value;
	let tm = document.getElementById("tm").value;
	
	let data = {"timestamp": tm, 
				"coordinate": {
					"latitude":lat, 
					"longitude": long}, 
				"phone": {"id": 69}
				};
	
	fetch("/position", {
		method: "POST",
		headers: {
			"Content-Type": "application/JSON"
		},
		body: JSON.stringify(data)
		
	}).then(function(response){
		createTable();
		
	}).catch(function(error){
		console.log(error);
	})
	
}

function createTable(){
	
	fetch("/position")
		.then(function(response){
			
			if(response.status >= 200 && response.status <= 300){
				
				response.json()
					.then(function(data){
					
						let tb = document.getElementById("posicoes");
						tb.innerHTML = "<tr><th>Celular</th><th>Latitude</th><th>Longitude</th><th>Timestamp</th></tr>";
						
						for(let i=0; i < data.content.length; i++){
							let p = data.content[i];
							if(p.coordinate)
								tb.innerHTML += `<tr><th>${p.phone.number}</th><th>${p.coordinate.latitude}</th><th>${p.coordinate.longitude}</th><th>${p.timestamp}</th></tr>`;
						}
				})
				
				
			}
			
		}).catch(function(error){
			console.log(error);
		});	
}

createTable();