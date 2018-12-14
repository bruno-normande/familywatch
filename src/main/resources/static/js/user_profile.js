
console.log("oi");
let div = document.getElementById("prof");
let u = JSON.parse(localStorage["user"]);

div.innerHTML = `${u.name}<br/>${u.username}`;
