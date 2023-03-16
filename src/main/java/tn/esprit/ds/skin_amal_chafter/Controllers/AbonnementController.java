package tn.esprit.ds.skin_amal_chafter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skin_amal_chafter.entities.Abonnement;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.entities.TypeAbonnement;
import tn.esprit.ds.skin_amal_chafter.services.IServiceAbonnement;
import tn.esprit.ds.skin_amal_chafter.services.IServiceSkieur;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/abonnement")
public class AbonnementController {
    @Autowired
    IServiceAbonnement a;
    //localhost:9090/retrieveAllSkieurs
    @GetMapping
    public List<Abonnement> getall()
    {
        return a.retrieveAllAbonnement();
    }
    @GetMapping("{numAbon}")
    public  Abonnement retrieveAbonnement (@PathVariable Long numAbon)
    {
        return a.retrieveAbonnement(numAbon);
    }
    @PostMapping
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement)
    {
        return  a.addAbonnement(abonnement);
    }

    @PutMapping
    public Abonnement updateAbonnement (@RequestBody Abonnement abonnement)
    {
        return a.updateAbonnement(abonnement);
    }

    @DeleteMapping("{numAbon}")
    public void removeAbonnement (@PathVariable Long numAbon)
    {
        a.removeAbonnement(numAbon);
    }
     @GetMapping("aa/{typeAbon}")
     public Set<Abonnement> getSubscriptionByType(@PathVariable TypeAbonnement typeAbon)
    {
        return a.getSubscriptionByType(typeAbon);
    }
   @GetMapping("dd/{dateDebut}/{dateFin}")
    public List<Abonnement> retrieveSubscriptionsByDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDebut, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFin)
    {
        return a.retrieveSubscriptionsByDates(dateDebut,dateFin);
    }
}
