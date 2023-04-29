package tn.esprit.ds.skin_amal_chafter.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import tn.esprit.ds.skin_amal_chafter.entities.*;
import tn.esprit.ds.skin_amal_chafter.repositories.*;

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

    @Autowired
    CoursRepository c;

    @Autowired
    InscriptionRepository i;
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

    @Override
    public List<Skieur> findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(TypeCours typeCours, Support support, Couleur couleur) {
        return sk.findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(typeCours,support,couleur);
    }

    @Override
    public List<Skieur> AmalJPQL(Support support, String nom) {
        return sk.AmalJPQL(support,nom);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur) {
        Assert.notNull(skieur.getAbonnements(),"Abonnement must be entered!!!"); //vérifier si l'objet abonn existe
        Assert.notNull(skieur.getInscriptions(),"Inscription must be entered!!!!");
        Set<Inscription> inscriptions=skieur.getInscriptions();
        inscriptions.forEach(inscription -> {   //nparcouri liste taa inscrip w netfaked ken kol inscri aandha cours
            Assert.notNull(inscription.getCours().getNumCours(),"Cours must be entered!!!");
            Cours cours= c.findById(inscription.getCours().getNumCours()).orElse(null);
            Assert.notNull(cours,"No cours found with this id!!!");
            inscription.setCours(cours); //inscription aandou cours barka donc l inscrip houa li bech ygéri l relation et il va affecter inscrip lel cours
            //taw ki bech ntestiw , exception handler
        });
        sk.saveAndFlush(skieur); //ken bech nhotha dekhel l for mch bech ysajel les controles de saisie donc nhotha l bara w naawed naamel for lel skieur
        skieur.getInscriptions().forEach(inscription ->{
            inscription.setSkieurs(skieur);
            i.saveAndFlush(inscription);
        });
        return skieur;
    }


}
