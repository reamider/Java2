package com.kino.rest;
import com.kino.domain.Klient;
import com.kino.KlientDAO;
import com.kino.BiletDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.List;

@Stateless
@Path("/klient")
public class KlientResource{
	@EJB
    private BiletDAO biletManager;
	
    @EJB
    private KlientDAO klientManager;
	
	@POST
    @Path("/dodajKlient")
    public Response dodajKlient(
		@FormParam("imie") String imie,
		@FormParam("nazwisko") String nazwisko,
		@FormParam("nrTelefonu") int nrTelefonu,
		@FormParam("bilet") String bilet)
		{
			Long idBilet = Long.parseLong(bilet.substring(0, bilet.indexOf('.')));
			Klient klient = new Klient();
			klient.setImie(imie);
			klient.setNazwisko(nazwisko);
			klient.setnrTelefonu(nrTelefonu);
			klient.setBilet(biletManager.pobierzBiletPoID(idBilet));
			klientManager.dodajKlient(klient);
			return Response.status(Response.Status.CREATED).build();
		}
		
		@POST
		@Path("/edytujKlient")
		public Response edytujKlient(@FormParam("idKlient") long idKlient,
    								 @FormParam("imie") String imie,
    								 @FormParam("nazwisko") String nazwisko,                            
                                     @FormParam("nrTelefonu") int nrTelefonu,
    								 @FormParam("bilet") String bilet)
		{
			Long idBilet = Long.parseLong(bilet.substring(0, bilet.indexOf('.')));
			Klient klient = klientManager.pobierzKlientaPoID(idKlient);
			klient.setImie(imie);
			klient.setNazwisko(nazwisko);
			klient.setnrTelefonu(nrTelefonu);
			klient.setBilet(biletManager.pobierzBiletPoID(idBilet));
			klientManager.edytujKlient(klient);
			return Response.status(Response.Status.OK).build();
		}
		
		@POST
		@Path("/usunKlient")
		public Response usunKlient(@FormParam("idKlient") long idKlient){
			Klient klient = new Klient();
			klient.setidKlient(idKlient);
			klientManager.usunKlient(klient);
			return Response.status(Response.Status.OK).build();
		}
		
		@GET
		@Path("/pobierzKlientow")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Klient> pobierzKlientow(){
			return klientManager.pobierzKlientow();
		}
		
		@GET
		@Path("/pobierzKlient/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Klient pobierzKlientaPoID(@PathParam("id") Long id){
			return klientManager.pobierzKlientaPoID(id);
		}
		
}