package com.kino;

import java.util.List;
import com.kino.domain.Bilet;

public interface BiletDAO{
    Bilet dodajBilet(Bilet bilet);
    void usunBilet(Bilet bilet);
    Bilet edytujBilet(Bilet bilet);
    List<Bilet> pobierzBilety();
    Bilet pobierzBiletPoID(Long idBilet);
    List<Bilet> pobierzBiletPoRodzaju(String rodzaj);
}