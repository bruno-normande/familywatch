

function clique(){
	let lat = document.getElementById("lat").value;
	let long = document.getElementById("long").value;
	let tm = document.getElementById("tm").value;
	
//	let data = {"timestamp": tm, 
//				"coordinate": {
//					"latitude":lat, 
//					"longitude": long}, 
//				"phone": {"id": 20}
//				};
	
	axios.post("/position", {"timestamp": tm, 
							"coordinate": {
								"latitude":lat, 
								"longitude": long}, 
							"phone": {"id": 20}
		})
		.then(createTable)
		.catch(function(error){
			console.log(error);
		});
	
//	let xhr2 = new XMLHttpRequest();
//	xhr2.open('POST', '/position');
//	xhr2.onload = createTable;
//	xhr2.setRequestHeader("Content-Type", "application/JSON")
//	xhr2.send(JSON.stringify(data));
	
	
}

function createTable(){
	
	axios.get("/position", {params: {page:1}})
		.then(function(response){
			console.log(response);
			let tb = document.getElementById("posicoes");
			tb.innerHTML = "<tr><th>Celular</th><th>Latitude</th><th>Longitude</th><th>Timestamp</th></tr>";
			for(let i=0; i < response.data.content.length; i++){
				let p = response.data.content[i];
				if(p.coordinate)
					tb.innerHTML += `<tr><th>${p.phone.number}</th><th>${p.coordinate.latitude}</th><th>${p.coordinate.longitude}</th><th>${p.timestamp}</th></tr>`;
			}
			
		})
		.catch(function(error){
			console.log(error);
		});
	
	
//	let xhr2 = new XMLHttpRequest();
//	xhr2.open('GET', '/position');
//
//	xhr2.onload = function() {
//		if(this.status == 200){
//			
//			let r = JSON.parse(this.responseText);
//			console.log(r);
//			
//			let tb = document.getElementById("posicoes");
//			
//			//tb.innerHTML = "<tr><th>Celular</th><th>Latitude</th><th>Longitude</th><th>Timestamp</th></tr>";
//			
//			for(let i=0; i < r.content.length; i++){
//				let p = r.content[i];
//				if(p.coordinate)
//					tb.innerHTML += `<tr><th>${p.phone.number}</th><th>${p.coordinate.latitude}</th><th>${p.coordinate.longitude}</th><th>${p.timestamp}</th></tr>`;
//			}
//			
////			r.content.forEach(p => {
////				if(p.coordinate)
////				tb.innerHTML += `<tr><th>${p.phone.number}</th><th>${p.coordinate.latitude}</th><th>${p.coordinate.longitude}</th><th>${p.timestamp}</th></tr>`;
////			});
//		}
//	};
//
//	xhr2.send();
}

createTable();