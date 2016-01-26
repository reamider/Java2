package com.kino.domain;
import org.codehaus.jackson.annotate.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Bilet")
@NamedQueries({
        @NamedQuery(name = "bilet.pobierzWszystkie", query = "Select b from Bilet b"),
        @NamedQuery(name = "bilet.pobierzPoID", query = "Select b from Bilet b where b.idBilet = :idBilet")
})

public class Bilet{
    private Long idBilet;
    private String rodzaj;
    private String opis;
    private double cena;

    private List<Klient> klienci = new ArrayList<Klient>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getidBilet(){
        return idBilet;
    }
    public void setidBilet(Long idBilet){
        this.idBilet = idBilet;
    }

    public String getOpis(){
        return opis;
    }
    public void setOpis(String opis){
        this.opis = opis;
    }

    public String getRodzaj(){
        return rodzaj;
    }
    public void setRodzaj(String rodzaj){
        this.rodzaj = rodzaj;
    }

    public double getCena(){
        return cena;
    }
    public void setCena(double cena){
        this.cena = cena;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bilet")
    @JsonIgnore
    public List<Klient> getKlient(){
        return klienci;
    }
    public void setKlienci(List<Klient> klienci){
        this.klienci = klienci;
    }
}