package com.kino.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "pracownik.pobierzWszystkich", query = "Select p from Pracownik p"),
        @NamedQuery(name = "pracownik.pobierzPoID", query = "Select p from Pracownik p where p.idPracownik = :idPracownik")
})

public class Employee{
    private Long idPracownik;
    private String Imie;
    private String Nazwisko;
    private String nrTelefonu;
    private Date datazatrudnienia;
	
	private List<Zamowienie> zamowienia = new ArrayList<Zamowienie>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getidPracownik(){
        return idPracownik;
    }

    public void setidPracownik(Long idPracownik) {
        this.idPracownik = idPracownik;
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
	
	@Temporal(TemporalType.DATE)
    public Date getDataZatrudnienia() {
        return datazatrudnienia;
    }
	
	public void setDataZatrudnienia(Date datazatrudnienia) {
        this.datazatrudnienia = datazatrudnienia;
    }

