package com.kino.domain;
import org.codehaus.jackson.annotate.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Klient")
@NamedQueries({
        @NamedQuery(name = "klient.pobierzWszystkich", query = "Select k from Klient k"),
		@NamedQuery(name = "klient.pobierzPoID", query = "Select k from Klient k where k.idKlient = :idKlient"),
		@NamedQuery(name = "klient.pobierzPoIDBiletu", query = "Select k from Klient k where k.bilet = :idBilet")
})

public class Klient{
    private Long idKlient;
    private String imie;
    private String nazwisko;
    private int nrTelefonu;
	private Bilet bilet;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getidKlient() {
        return idKlient;
    }
    public void setidKlient(Long idKlient) {
        this.idKlient = idKlient;
    }

    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getnrTelefonu() {
        return nrTelefonu;
    }
    public void setnrTelefonu(int nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

	@ManyToOne
    @JoinColumn(name = "idBilet")
    public Bilet getBilet(){
        return bilet;
    }
    public void setBilet(Bilet bilet){
        this.bilet = bilet;
    }
}