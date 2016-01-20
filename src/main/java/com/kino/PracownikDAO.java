package com.kino;

import java.util.List;
import com.kino.domain.Pracownik;

public interface PracownikDAO{
    Pracownik dodajPracownik(Pracownik pracownik);
    void usunPracownik(Pracownik pracownik);
    Pracownik edytujPracownik(Pracownik pracownik);
    List<Pracownik> pobierzPracownikow();
    Pracownik pobierzPracownikaPoID(Long idPracownik);

}