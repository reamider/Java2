$(document).ready(function(){
	 $.get("/kino/rest/bilet/pobierzBilety", function(data, textStatus){
       var biletWybierz = document.getElementById('idBilet');

       for(var i in data) {
            var opcje = document.createElement('option');

            var biletInfo = data[i].idBilet + ". " + data[i].Rodzaj + " " + data[i].Opis + " " + data[i].Cena;

            opcje.value = biletInfo;
            opcje.innerHTML = biletInfo;
            biletWybierz.appendChild(opt);
       }
    });
}};