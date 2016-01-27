$(document).ready(function(){
    var id = window.location.search.replace("?id=", "");

    document.getElementById('idKlient').value = id;

    //Load customers
    $.get("/kino/rest/bilet/pobierzBilety", function(data, textStatus)
    {
       var biletSelect = document.getElementById('idBilet');

       for(var i in data) {
            var opt = document.createElement('option');
            var biletInfo = data[i].idBilet;
			var biletInfo2 = data[i].rodzaj;
			opt.value = biletInfo;
			opt.innerHTML = biletInfo2;
			biletSelect.appendChild(opt);
       }
    });
	
	//Load rest of shop order data
    $.get("/kino/rest/klient/pobierzKlientow/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.idKlient;
       document.getElementById('imie').value = data.imie;
       document.getElementById('nazwisko').value = data.nazwisko;
	   document.getElementById('nrTelefonu').value = data.nrTelefonu;
       document.getElementById('idBilet').value = data.bilet.idBilet;
    });
});