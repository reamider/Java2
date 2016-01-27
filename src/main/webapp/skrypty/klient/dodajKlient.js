$(document).ready(function()
		   {
		       $.get("/kino/rest/bilet/pobierzBilety", function(data, textStatus)
		       {
		          var biletSelect = document.getElementById('biletID');
		          for(var i in data) {
		               var opt = document.createElement('option');
		               var biletInfo = data[i].idBilet;
					   var biletInfo2 = data[i].rodzaj;
		               opt.value = biletInfo;
		               opt.innerHTML = biletInfo2;
		               biletSelect.appendChild(opt);
		          }
		       });
		   });