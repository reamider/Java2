package com.kino;

import java.util.List;
import com.kino.domain.*;

public interface ZamowienieDAO{
    Zamowienie dodajZamowienie(Zamowienie zamowienie);
    void usunZamowienie(Zamowienie zamowienie);
    Zamowienie edytujZamowienie(Zamowienie zamowienie);
	Zamowienie pobierzZamowieniePoID(Long idZamowienie);
    List<Zamowienie> pobierzZamowienia();
	List<Zamowienie> pobierzZamowieniaPoIDBiletu(Bilet bilet);
    List<Zamowienie> pobierzZamowieniaPoIDKlienta(Klient klient);
    List<Zamowienie> pobierzZamowieniaPoIDPracownika(Pracownik pracownik);
}