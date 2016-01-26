$(document).ready(function(){
    var id = window.location.search.replace("?id=", "");
    document.getElementById('idBilet').value = id;
	
	$.get("/kino/rest/bilet/pobierzBilet/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.idBilet;
       document.getElementById('imie').value = data.imie;
       document.getElementById('nazwisko').value = data.nazwisko;
       document.getElementById('nrTelefonu').value = data.nrTelefonu;
    });
});
