$(document).ready(function(){
    var id = window.location.search.replace("?id=", "");
    document.getElementById('idBilet').value = id;
	
	$.get("/kino/rest/bilet/pobierzBilet/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.idBilet;
       document.getElementById('rodzaj').value = data.rodzaj;
       document.getElementById('opis').value = data.opis;
       document.getElementById('cena').value = data.cena;
    });
});
