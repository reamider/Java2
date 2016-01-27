$(document).ready(function()
{
      $.get("/kino/rest/bilet/pobierzBilety", function(data, textStatus)
      {
              var table = document.getElementById('presentationTable');

              for(var i in data) {
                    var row = document.createElement("tr");

                    var cellID = document.createElement("td");
                    var cellIDText = document.createTextNode(data[i].idBilet);
                    var cellRodzaj = document.createElement("td");
                    var cellRodzajText = document.createTextNode(data[i].rodzaj);
                    var cellOpis = document.createElement("td");
                    var cellOpis = document.createTextNode(data[i].opis);
                    var cellCena = document.createElement("td");
                    var cellCenaText = document.createTextNode(data[i].cena);

                    cellID.appendChild(cellIDText);
                    cellRodzaj.appendChild(cellRodzajText);
                    cellOpis.appendChild(cellOpisText);
                    cellCena.appendChild(cellCenaText);

                    //Operation cells:

                    //Read:
                    var cellRead = document.createElement("td");
                    var cellReadLink = document.createElement("a");

                    var cellReadPicture = document.createElement("img");
                    cellReadPicture.setAttribute('src', '/kino/obrazki/edytuj.png');

                    cellReadLink.appendChild(cellReadPicture);
                    cellReadLink.href = "../../kino/dzialnia/bilet/zobaczBilet.html?id=" + data[i].idBilet;
                    cellRead.appendChild(cellReadLink);

                    //Update:
                    var cellUpdate = document.createElement("td");
                    var cellUpdateLink = document.createElement("a");

                    var cellUpdatePicture = document.createElement("img");
                    cellUpdatePicture.setAttribute('src', '/kino/obrazki/edytuj.png');

                    cellUpdateLink.appendChild(cellUpdatePicture);
                    cellUpdateLink.href = "../../kino/dzialania/bilet/edytujBilet.html?id=" + data[i].idBilet;
                    cellUpdate.appendChild(cellUpdateLink);

                    //Delete:
                    var cellDelete = document.createElement("td");
                    var cellDeleteLink = document.createElement("a");

                    var cellDeletePicture = document.createElement("img");
                    cellDeletePicture.setAttribute('src', '/kino/obrazki/usun.png');

                    cellDeleteLink.appendChild(cellDeletePicture);
                    cellDeleteLink.href = "../../kino/dzialania/bilet/usunBilet.html?id=" + data[i].idBilet;
                    cellDelete.appendChild(cellDeleteLink);

                    row.appendChild(cellID);
                    row.appendChild(cellRodzaj);
                    row.appendChild(cellOpis);
                    row.appendChild(cellCena);
                    row.appendChild(cellRead);
                    row.appendChild(cellUpdate);
                    row.appendChild(cellDelete);

                    table.appendChild(row);
              }
      });
});