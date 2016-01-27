package com.kino.service;
import com.kino.domain.*;
import com.kino.BiletDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BiletManager implements BiletDAO{
	@PersistenceContext
    EntityManager em;
	
	public Bilet dodajBilet(Bilet bilet){
        em.persist(bilet);
        em.flush();
        return bilet;
    }
	
	public Bilet edytujBilet(Bilet bilet){
        return em.merge(bilet);
    }
	
	public void usunBilet(Bilet bilet){
        em.remove(em.getReference(Bilet.class, bilet.getidBilet()));
    }
	
	public List<Bilet> pobierzBilety(){
        return em.createNamedQuery("bilet.pobierzBilety").getResultList();
    }
	
	 public Bilet pobierzBiletPoID(Long id){
        return em.find(Bilet.class, id);
    }
}