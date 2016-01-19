package com.kino;

import java.util.List;
import com.kino.domain.Klient;

public interface KlientDAO{
    Klient dodajKlient(Klient klient);
    void usunKlient(Klient klient);
    Klient edytujKlient(Klient klient);
    List<Klient> pobierzKlientow();
    Klient pobierzKlientaPoID(Long idKlient);
    List<Klient> pobierzKlientowZkartaPromocyjna();
}