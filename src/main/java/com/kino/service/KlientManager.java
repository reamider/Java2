package com.kino.service;
import com.kino.domain.*;
import com.kino.KlientDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class KlientManager implements KlientDAO{
	@PersistenceContext
    EntityManager em;

	public Klient dodajKlient(Klient klient){
        em.persist(klient);
        em.flush();
        return klient;
    }
	
	public Klient edytujKlient(Klient klient){
        return (Klient)em.merge(klient);
    }
	
	public void usunKlient(Klient klient){
        em.remove(em.getReference(Klient.class, klient.getidKlient()));
    }

	public List<Klient> pobierzKlientow(){
        return em.createNamedQuery("klient.pobierzKlientow").getResultList();
    }
	
	 public Klient pobierzKlientaPoID(Long id){
        return em.find(Klient.class, id);
    }
	
	public List<Klient> pobierzKlientaPoIDBiletu(Bilet bilet){
        return em.createNamedQuery("klient.pobierzPoIDBiletu").setParameter("idBilet", bilet.getidBilet()).getResultList();
    }
}