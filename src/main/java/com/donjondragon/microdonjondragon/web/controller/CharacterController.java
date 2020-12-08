package com.donjondragon.microdonjondragon.web.controller;
import com.donjondragon.microdonjondragon.dao.CharacterDaoImpl;
import com.donjondragon.microdonjondragon.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// modifier du contrôleur afin qu'elle utilise la couche DAO pour manipuler les personnages.
@RestController
public class CharacterController {

    @Autowired
    private CharacterDaoImpl characterDao;

    //Récupérer la liste des personnages
    @RequestMapping(value="/Characters", method=RequestMethod.GET)
    public List<Character>listePersonnages() {
        return characterDao.findAll();
    }

    //Récupérer un personnage par son Id
    @GetMapping(value="/Characters/{id}")
    public Character afficherUnPersonnage(@PathVariable int id) {
        return characterDao.findById(id);
    }
}


