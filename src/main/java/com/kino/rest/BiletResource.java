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
public class BiletResource {
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
