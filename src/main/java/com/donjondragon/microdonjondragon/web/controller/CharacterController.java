package com.donjondragon.microdonjondragon.web.controller;
import com.donjondragon.microdonjondragon.dao.CharacterDaoImpl;
import com.donjondragon.microdonjondragon.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/*
l'annotation @Controller de Spring qui permet de désigner une classe comme contrôleur, lui conférant la capacité de
traiter les requêtes de type GET, POST, etc.

@RestController => Une fois ajouté, il indique que cette classe va pouvoir traiter les requêtes qu'on va définir.
Il indique aussi que chaque méthode va renvoyer directement la réponse JSON à l'utilisateur,
donc pas de vue dans le circuit.

=> réponse formatée en JSON grâce l'annotation @RestController. Spring sait que les réponses aux requêtes devront être
en format JSON => L'auto-configurateur va alors chercher si vous avez dans votre classpath une dépendance capable de
transformer un object Java en JSON, et inversement.
Jackson a été importé avec le starter utilisé. Le Bean Character renvoyé est donc transformé en JSON puis servi
en réponse.
 */

// Ici => modification du contrôleur afin qu'elle utilise la couche DAO pour manipuler les personnages.
@RestController
public class CharacterController {

    /*
      Création d'une variable de type CharacterDaoImpl avec l'annotation @Autowired afin que Spring se
      charge d'en fabriquer une instance. characterDao a désormais accès à toutes les méthodes définies.
    */
    @Autowired
    private CharacterDaoImpl characterDao;

    //Méthode permettant de récupérer la liste des personnages
    @RequestMapping(value="/Characters", method=RequestMethod.GET)
    public List<Character>listePersonnages() {
        return characterDao.findAll();
    }

    /* Méthode pour GET /Characters

      L'annotation @RequestMapping  qui permet de faire le lien entre l'URI "/Characters", invoquée via GET, et la
      méthode listeCharacters

      L'annotation accepte plusieurs paramètres , dont voici les principaux :

       value : C'est ici que vous indiquez l'URI à laquelle cette méthode doit répondre.

       method : Vous indiquez ici à quel type de requêtes cette méthode doit répondre. Dans notre cas, notre méthode
       listCharacters ne sera déclenchée que si l'URI est exactement "/Characters" et que la requête est de type GET.

       produces : Dans certains cas d'utilisations avancées, vous aurez besoin de préciser, par exemple, que
       votre méthode est capable de répondre en XML et en JSON. Cela entre aussi dans le choix de la méthode qui
       correspond le mieux à la requête. Si la requête contient du XML et que vous avez 2 méthodes identiques, dont
       une capable de produire du XML, c'est celle-ci qui sera appelée. Il en va de même pour consumes qui précise
       les formats acceptés.
    */

      /*
     Méthode pour GET /Characters/{id}: récupérer un personnage par son id

     Création d'une deuxième méthode capable d'accepter un Id de Character en paramètre :
     l'ajout de {id} à l'URI. Cette notation permet d'indiquer que cette méthode doit répondre uniquement aux requêtes
     avec une URI de type /Characters/25 par exemple.
     Comme nous avons indiqué que id doit être un int (dans @PathVariable int id)

     Remarques: une @RequestMapping qui accepte des requêtes de type GET, peut etre remplacé par @GetMapping
     */


    /*Les méthodes font appel au DAO pour qu'il communique avec la base de données. Il récupère les informations puis
     il crée une instance de Character qu'il renvoie ensuite aux méthodes.
     Les méthodes retournent l'instance reçue, qui est transformée en JSON grâce à Jackson.
    */

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


