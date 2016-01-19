package com.kino.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "bilet.pobierzWszystkie", query = "Select b from Bilet b"),
        @NamedQuery(name = "bilet.pobierzPoID", query = "Select b from Bilet b where b.idBilet = :idBilet"),
        @NamedQuery(name = "bilet.pobierzPoRodzaj", query = "Select b from Bilet b where b.rodzaj = :rodzaj")
})

public class Bilet{
    private Long idBilet;
    private String rodzaj;
    private String opis;
    private String salakinowa;
    private double cena;

    private List<Zamowienie> zamowienia = new ArrayList<Zamowienie>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	//autoinkrementacja , zeby nie bylo problemow z primary key
    public Long getidBilet(){
        return idBilet;
    }
    public void setidBilet(Long idBilet){
        this.idBilet = idBilet;
    }

    public String getSalaKinowa(){
        return salakinowa;
    }
    public void setSalaKinowa(String salakinowa) {
        this.salakinowa = salakinowa;
    }

    public String getOpis() {
        return opis;
    }
	
    public void setOpis(String opis) {
        this.opis = opis;
    }

	//nie moze byc puste 
    @Column(nullable = false)
    public String getRodzaj() {
        return rodzaj;
    }
    public void setModel(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public double getCena() {
        return cena;
    }
	
    public void setCena(double cena) {
        this.cena = cena;
    }

	//jeden do wielu bilet zamowienie
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bilet")
    @JsonIgnore
    public List<Zamowienie> getZamowienie() {
        return zamowienia;
    }
    public void setZamowienie(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }
}