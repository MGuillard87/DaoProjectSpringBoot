package com.donjondragon.microdonjondragon.web.controller;
import com.donjondragon.microdonjondragon.dao.CharacterDaoImpl;
import com.donjondragon.microdonjondragon.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// modifier du contrôleur afin qu'elle utilise la couche DAO pour manipuler les personnages.
@RestController
public class CharacterController {

    @Autowired
    private CharacterDaoImpl characterDao;

    //Méthode permettant de récupérer la liste des personnages
    @RequestMapping(value="/Characters", method=RequestMethod.GET)
    public List<Character>listePersonnages() {
        return characterDao.findAll();
    }

    //Méthode permettant de récupérer un personnage par son Id
    @GetMapping(value="/Characters/{id}")
    public Character afficherUnPersonnage(@PathVariable int id) {
        return characterDao.findById(id);
    }


    //Méthode permettant d'ajouter un personnage
    /* @RequestBody, cette annotation demande à Spring que le JSON contenu dans la partie body de la requête HTTP
    soit converti en objet Java
    */
    @PostMapping(value = "/Characters")
    public void ajouterUnPersonnage(@RequestBody Character character) {
        characterDao.save(character);
    }

    //Méthode permettant de supprimer un personnage
    @DeleteMapping(value = "/Characters/{id}")
    public void  supprimerUnPersonnage(@PathVariable int id) {
        characterDao.delete(id);
    }

    //Méthode permettant de modifier un personnage
    @PutMapping(value = "/Characters")
    public void  ModifierUnPersonnage(@RequestBody Character character) {
        characterDao.update(character);
    }

}


