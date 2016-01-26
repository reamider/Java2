$(document).ready(function(){
	var id = window.location.search.replace("?id=", "");
    document.getElementById('idBilet').value = id;

    $.get("/kino/rest/bilet/pobierzBilet/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.idBilet;
       document.getElementById('imie').innerHTML = data.imie;
       document.getElementById('nazwisko').innerHTML = data.nazwisko;
       document.getElementById('nrTelefonu').innerHTML = data.nrTelefonu;
    });
});