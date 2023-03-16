package tn.esprit.ds.skin_amal_chafter.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.ds.skin_amal_chafter.entities.Abonnement;
import tn.esprit.ds.skin_amal_chafter.entities.Piste;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.entities.TypeAbonnement;
import tn.esprit.ds.skin_amal_chafter.repositories.AbonnementRepository;
import tn.esprit.ds.skin_amal_chafter.repositories.PisteRepository;
import tn.esprit.ds.skin_amal_chafter.repositories.SkieurRepository;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ServiceSkieur implements  IServiceSkieur{
    @Autowired
    SkieurRepository sk;
    @Autowired
    PisteRepository p;
    @Autowired
    AbonnementRepository a;
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

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        //recuperation des objets
        Skieur skieur= sk.findById(numSkieur).orElse(null);
        Piste piste= p.findById(numPiste).orElse(null);
        if(skieur !=null && piste != null)
        {
            //skieur.getPistes().add(piste);
            Set<Piste> pistes=skieur.getPistes();
            pistes.add(piste);
            skieur.setPistes(pistes);
           return sk.save(skieur);
        }
        return null;
    }

    @Override
    public Skieur assignSkierToAbonnement(Long numSkieur, Long numAbon) {
       Skieur skieur= sk.findById(numSkieur).orElse(null);
        Assert.notNull(skieur,"skieur not found");
        Abonnement abonnement = a.findById(numAbon).orElse(null);
        Assert.notNull(abonnement,"abonnement not found");
        skieur.setAbonnements(abonnement);

        return sk.save(skieur);
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbon) {
        return sk.findSkieursByAbonnements_TypeAbon(typeAbon);
    }

   /* @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return sk.findByAbonnementsTypeAbon(typeAbonnement);
    }*/




}
