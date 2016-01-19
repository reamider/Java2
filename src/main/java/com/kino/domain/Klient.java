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
        @NamedQuery(name = "klient.kartaPromocyjna", query = "Select k from Klient k where k.kartaPromocyjna = true")
})

public class Klient{
    private Long idKlient;
    private String Imie;
    private String Nazwisko;
    private String nrTelefonu;
    private Boolean kartaPromocyjna = false;

    private List<Zamowienie> zamowienia = new ArrayList<Zamowienie>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getidKlient() {
        return idKlient;
    }
	
    public void setidKlient(Long idKlient) {
        this.idKlient = idKlient;
    }

    public String getImie() {
        return Imie;
    }
    public void setImie(String Imie) {
        this.Imie = Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }
	
    public void setNazwisko(String Nazwisko) {
        this.Nazwisko = Nazwisko;
    }

    public String getnrTelefonu() {
        return nrTelefonu;
    }
	
    public void setnrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public Boolean getkartaPromocyjna() {
        return kartaPromocyjna;
    }
	
    public void setkartaPromocyjna(Boolean kartaPromocyjna) {
        this.kartaPromocyjna = kartaPromocyjna;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "klient")
    @JsonIgnore
    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }
	
    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }
	
}