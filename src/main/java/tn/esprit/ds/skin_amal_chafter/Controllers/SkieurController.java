package tn.esprit.ds.skin_amal_chafter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skin_amal_chafter.entities.*;
import tn.esprit.ds.skin_amal_chafter.services.IServiceSkieur;
import tn.esprit.ds.skin_amal_chafter.services.ServiceSkieur;

import java.util.List;

@RestController
@RequestMapping("/skieur")
public class SkieurController {
    @Autowired
    IServiceSkieur sk;
    //localhost:9090/retrieveAllSkieurs
    @GetMapping
    public List<Skieur> getall()
    {
        return sk.retrieveAllSkieurs();
    }
    @GetMapping("{numSkieur}")
    public  Skieur retrieveSkieur (@PathVariable Long numSkieur)
    {
        return sk.retrieveSkieur(numSkieur);
    }
    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur skieur)
    {
       return  sk.addSkieur(skieur);
    }

    @PutMapping
    public Skieur updateSkieur (@RequestBody Skieur skieur)
    {
        return sk.updateSkieur(skieur);
    }

    @DeleteMapping("{numSkieur}")
    public void removeSkieur (@PathVariable Long numSkieur)
    {
        sk.removeSkieur(numSkieur);
    }

    @PutMapping("{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable Long numSkieur, @PathVariable Long numPiste)
    {
        return sk.assignSkierToPiste(numSkieur,numPiste);
    }

   /* @GetMapping("amal/{typeAbonnement}")
    public List<Skieur> retrieveSkiersBySubscriptionType(@PathVariable TypeAbonnement typeAbonnement)
    {
        return sk.retrieveSkiersBySubscriptionType(typeAbonnement);
    }*/
    @PutMapping("a/{numSkieur}/{numAbon}")
    public Skieur assignSkierToAbonnement(@PathVariable Long numSkieur, @PathVariable Long numAbon)
    {
        return sk.assignSkierToAbonnement(numSkieur,numAbon);
    }
    @GetMapping("s/{typeAbon}")
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbon)
    {
        return sk.retrieveSkiersBySubscriptionType(typeAbon);
    }

    @GetMapping("d/{typeCours}/{support}/{couleur}")
    public    List<Skieur>findByInscriptionsCoursTypeCoursSupportAAndPistesCouleur(@PathVariable TypeCours typeCours, @PathVariable Support support,@PathVariable Couleur couleur)
    {
        return sk.findByInscriptionsCoursTypeCoursAndInscriptionsCoursSupportAndPistesCouleur(typeCours,support,couleur);
    }
   @GetMapping("p/{support}/{nom}")
    public List<Skieur> AmalJPQL(Support support, String nom)
    {
        return sk.AmalJPQL(support,nom);
    }


    @PostMapping("aadski")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur)
    {
        return sk.addSkierAndAssignToCourse(skieur);
    }
}
