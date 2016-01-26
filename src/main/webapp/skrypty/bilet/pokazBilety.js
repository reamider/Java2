$(document).ready(function(){
      $.get("/kino/rest/bilet/pobierzBilety", function(data, textStatus){
              var table = document.getElementById('prezentacja');

              for(var i in data) {
                    var rzad = document.createElement("tr");
                    var kolumnaID = document.createElement("td");
                    var kolumnaIDText = document.createTextNode(data[i].idBilet);
                    var kolumnaRodzaj = document.createElement("td");
                    var kolumnaRodzajText = document.createTextNode(data[i].rodzaj);
                    var kolumnaOpis = document.createElement("td");
                    var kolumnaOpisText = document.createTextNode(data[i].opis);
                    var kolumnaCena = document.createElement("td");
                    var kolumnaCenaText = document.createTextNode(data[i].cena);

                    kolumnaID.appendChild(kolumnaIDText);
                    kolumnaRodzaj.appendChild(kolumnaRodzajText);
                    kolumnaOpis.appendChild(kolumnaOpisText);
                    kolumnaCena.appendChild(kolumnaCenaText);

                    //Zobacz pojedynczy element:
                    var kolumnaRead = document.createElement("td");
                    var kolumnaReadLink = document.createElement("a");

                    var kolumnaReadPictures = document.createElement("img");
                    kolumnaReadPictures.setAttribute('src', '/kino/obrazki/zobacz.png');

                    kolumnaReadLink.appendChild(kolumnaReadPictures);
                    kolumnaReadLink.href = "../../kino/dzialania/bilet/zobaczBilet.html?id=" + data[i].idBilet;
                    kolumnaRead.appendChild(kolumnaReadLink);

                    //Edytuj Bilet:
                    var kolumnaUpdate = document.createElement("td");
                    var kolumnaUpdateLink = document.createElement("a");

                    var kolumnaUpdatePictures = document.createElement("img");
                    kolumnaUpdatePictures.setAttribute('src', '/kino/obrazki/edytuj.png');

                    kolumnaUpdateLink.appendChild(kolumnaUpdatePictures);
                    kolumnaUpdateLink.href = "../../kino/dzialania/bilet/edytujBilet.html?id=" + data[i].idBilet;
                    kolumnaUpdate.appendChild(kolumnaUpdateLink);

                    //Usun Bilet:
                    var kolumnaDelete = document.createElement("td");
                    var kolumnaDeleteLink = document.createElement("a");

                    var kolumnaDeletePictures = document.createElement("img");
                    kolumnaDeletePictures.setAttribute('src', '/kino/obrazki/usun.png');

                    kolumnaDeleteLink.appendChild(kolumnaDeletePictures);
                    kolumnaDeleteLink.href = "../../kino/dzialania/bilet/usunBilet.html?id=" + data[i].idBilet;
                    kolumnaDelete.appendChild(kolumnaDeleteLink);

                    rzad.appendChild(kolumnaID);
                    rzad.appendChild(kolumnaRodzaj);
                    rzad.appendChild(kolumnaOpis);
                    rzad.appendChild(kolumnaCena);
                    rzad.appendChild(kolumnaRead);
                    rzad.appendChild(kolumnaUpdate);
                    rzad.appendChild(kolumnaDelete);

                    table.appendChild(rzad);
              }
      });
});