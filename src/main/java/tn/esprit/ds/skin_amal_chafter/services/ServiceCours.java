package tn.esprit.ds.skin_amal_chafter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skin_amal_chafter.entities.Cours;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.repositories.CoursRepository;

import java.util.List;

@Service
public class ServiceCours implements IServiceCours{
    @Autowired

    CoursRepository c;
    @Override
    public List<Cours> retrieveAllCours() {
        return c.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return c.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
         return c.save(cours);
    }

    @Override
    public void removeCours(Long numCours) {
        c.deleteById(numCours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return c.findById(numCours).orElse(null);
    }
}
