$(document).ready(function(){
    var id = window.location.search.replace("?id=", "");

    $.get("/musicstore/kino/bilet/pobierzBilet/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.idBilet;
       document.getElementById('imie').innerHTML = data.imie;
       document.getElementById('nazwisko').innerHTML = data.nazwisko;
       document.getElementById('nrTelefonu').innerHTML = data.nrTelefonu;
    });
});