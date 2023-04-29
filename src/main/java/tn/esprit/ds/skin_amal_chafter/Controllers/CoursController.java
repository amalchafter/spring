package tn.esprit.ds.skin_amal_chafter.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.ds.skin_amal_chafter.entities.Cours;
import tn.esprit.ds.skin_amal_chafter.entities.Skieur;
import tn.esprit.ds.skin_amal_chafter.services.IServiceCours;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cours")

public class CoursController {
    @Autowired

    IServiceCours c;

    @GetMapping
    public List<Cours> getall()
    {
        return c.retrieveAllCours();
    }
    @GetMapping("{numCours}")
    public  Cours retrieveCours (@PathVariable Long numCours)
    {
        return c.retrieveCours(numCours);
    }
    @PostMapping
    public Cours addCours(@RequestBody Cours cours)
    {
        return  c.addCours(cours);
    }

    @PutMapping
    public Cours updateCours (@RequestBody Cours cours)
    {
        return c.updateCours(cours);
    }

    @DeleteMapping("{numCours}")
    public void removeCours (@PathVariable Long numCours)
    {
        c.removeCours(numCours);
    }
   @GetMapping("numins")

    public Set<Cours> findCoursByInscriptionsSQL()
    {
        return c.findCoursByInscriptionsSQL();
    }
}
