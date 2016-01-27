$(document).ready(function()
		   {
		       $.get("/kino/rest/bilet/pobierzBilety", function(data, textStatus)
		       {
		          var scenaSelect = document.getElementById('biletID');
		          for(var i in data) {
		               var opt = document.createElement('option');
		               var scenaInfo = data[i].idBilet;
		               opt.value = scenaInfo;
		               opt.innerHTML = scenaInfo;
		               scenaSelect.appendChild(opt);
		          }
		       });
		   });