package com.kino.rest;
import com.kino.domain.Bilet;
import com.kino.BiletDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.util.List;

@Stateless
@Path("/bilet")
public class BiletResource{
    @EJB
    private BiletDAO biletManager;

    @POST
    @Path("/dodajBilet")
    public Response dodajBilet(
		@FormParam("rodzaj") String rodzaj,
		@FormParam("opis") String opis,
		@FormParam("cena") double cena)
		{
			Bilet bilet = new Bilet();
			bilet.setRodzaj(rodzaj);
			bilet.setOpis(opis);
			bilet.setCena(cena);
			biletManager.dodajBilet(bilet);
			return Response.status(Response.Status.CREATED).build();
		}
	
	@POST
    @Path("/edytujBilet")
    public Response edytujBilet(
		@FormParam("idBilet") long idBilet,
		@FormParam("rodzaj") String rodzaj,
		@FormParam("opis") String opis,
		@FormParam("cena") double cena)
		{
			Bilet bilet = new Bilet();
			bilet.setidBilet(idBilet);
			bilet.setRodzaj(rodzaj);
			bilet.setOpis(opis);
			bilet.setCena(cena);
			biletManager.edytujBilet(bilet);
			return Response.status(Response.Status.OK).build();
		}
		
	@POST
    @Path("/usunBilet")
    public Response usunBilet(
		@FormParam("idBilet") long idBilet)
		{
			Bilet bilet = new Bilet();
			bilet.setidBilet(idBilet);
			biletManager.usunBilet(bilet);
			return Response.status(Response.Status.OK).build();
		}
		
	@GET
    @Path("/pobierzBilety")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bilet> pobierzBilety(){
        return biletManager.pobierzBilety();
    }
	
	@GET
    @Path("/pobierzBilet/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bilet pobierzBiletPoID(@PathParam("id") Long id) {
        return biletManager.pobierzBiletPoID(id);
    }
}