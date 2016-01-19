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
        @NamedQuery(name = "klient.kartapromocyjna", query = "Select k from Klient k where k.kartapromocyjna = true")
})
