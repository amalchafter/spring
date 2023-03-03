package tn.esprit.ds.skin_amal_chafter.services;

import tn.esprit.ds.skin_amal_chafter.entities.Piste;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;

import java.util.List;

public interface IServicePiste {
    List<Piste> retrieveAllPistes();
    Piste addPiste(Piste piste);

    Piste updatePiste (Piste piste);
    void removePiste (Long numPiste);
    Piste retrievePiste (Long numPiste);
}
