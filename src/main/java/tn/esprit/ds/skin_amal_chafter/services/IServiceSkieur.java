package tn.esprit.ds.skin_amal_chafter.services;

import tn.esprit.ds.skin_amal_chafter.entities.Skieur;

import java.util.List;

public interface IServiceSkieur {

    List<Skieur> retrieveAllSkieurs();
    Skieur addSkieur(Skieur skieur);

    Skieur updateSkieur (Skieur skieur);
    void removeSkieur (Long numSkieur);
    Skieur retrieveSkieur (Long numSkieur);
}
