package com.kino.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "zamowienie.pobierzWszystkie", query = "Select z from Zamowienie z"),
        @NamedQuery(name = "zamowienie.pobierzPoID", query = "Select z from Zamowienie z where z.Zamowienie = :idZamowienie"),
        @NamedQuery(name = "zamowienie.pobierzPoIDKlienta", query = "Select z from Zamowienie z where z.klient = :idKlient"),
        @NamedQuery(name = "zamowienie.pobierzPoIDPracownika", query = "Select z from Zamowienie z where z.pracownik = :idPracownik"),
        @NamedQuery(name = "zamowienie.pobierzPoIDBiletu", query = "Select z from Zamowienie z where z.bilet = :idBilet")
})

public class Zamowienie{
    private Long idZamowienie;
    private Date datazamowienia;       //date of order
    private double cena;
	
	private Klient klient;
    private Pracownik pracownik;
    private Bilet bilet;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	//autoinkrementacja , zeby nie bylo problemow z primary key
    public Long getidZamowienie() {
        return idZamowienie;
    }
    public void setidZamowienie(Long idZamowienie) {
        this.idZamowienie = idZamowienie;
    }

	//JPA DATA
	@Temporal(TemporalType.DATE)
    public Date getDataZamowienia() {
        return doo;
    }
    public void setDataZamowienia(Date datazamowienia) {
        this.datazamowienia = datazamowienia;
    }

    public double getCena() {
        return cena;
    }
	
    public void setCena(double cena) {
        this.cena = cena;
    }
	
	//RELACJA WIELE DO JEDNEGO ZAMOWIENIE-KLIENT
	@ManyToOne
    @JoinColumn(name = "idKlient")
    public Klient getKlient() {
        return klient;
    }
    public void setKlient(Klient klient) {
        this.klient = klient;
    }
	
	//RELACJA WIELE DO JEDNEGO ZAMOWIENIE-PRACOWNIK
	@ManyToOne
    @JoinColumn(name = "idPracownik")
    public Pracownik getPracownik() {
        return pracownik;
    }
    public void setPracownik(Pracownik pracownik){
        this.pracownik = pracownik;
    }

	//RELACJA WIELE DO JEDNEGO ZAMOWIENIE-BILET
    @ManyToOne
    @JoinColumn(name = "idBilet")
    public Bilet getBilet(){
        return bilet;
    }
    public void setBilet(Bilet bilet){
        this.bilet = bilet;
    }
}