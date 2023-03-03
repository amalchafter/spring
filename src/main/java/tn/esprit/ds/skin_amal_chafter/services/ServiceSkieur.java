package tn.esprit.ds.skin_amal_chafter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.repositories.SkieurRepository;

import java.util.List;
@Service
public class ServiceSkieur implements  IServiceSkieur{
    @Autowired
    SkieurRepository sk;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return sk.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        return sk.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return sk.save(skieur);
    }
    @Override
    public void removeSkieur(Long numSkieur) {

     sk.deleteById(numSkieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return sk.findById(numSkieur).orElse(null);
    }


}
