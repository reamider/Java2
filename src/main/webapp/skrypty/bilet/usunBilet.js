$(document).ready(function(){
	var id = window.location.search.replace("?id=", "");
    document.getElementById('idBilet').value = id;

    $.get("/kino/rest/bilet/pobierzBilet/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.idBilet;
       document.getElementById('rodzaj').innerHTML = data.rodzaj;
       document.getElementById('opis').innerHTML = data.opis;
       document.getElementById('cena').innerHTML = data.cena;
    });
});