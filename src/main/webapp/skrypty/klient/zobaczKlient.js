$(document).ready(function(){
    var id = window.location.search.replace("?id=", "");

    $.get("/kino/rest/klient/pobierzKlient/" + id, function(data, textStatus)
    {
       document.getElementById('id').innerHTML = data.idKlient;
       document.getElementById('bilet').innerHTML = data.bilet.rodzaj;
       document.getElementById('imie').innerHTML = data.imie;
       document.getElementById('nazwisko').innerHTML = data.nazwisko;
	   document.getElementById('nrTelefonu').innerHTML = data.nrTelefonu;
    });
});