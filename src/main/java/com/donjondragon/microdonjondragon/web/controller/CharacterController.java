package com.donjondragon.microdonjondragon.web.controller;
import com.donjondragon.microdonjondragon.model.Character;
import org.springframework.web.bind.annotation.*;

/*

l'annotation @Controller de Spring qui permet de désigner une classe comme contrôleur, lui conférant la capacité de
traiter les requêtes de type GET, POST, etc. Vous ajoutez ensuite @ResponseBody aux méthodes qui devront répondre
directement sans passer par une vue.

@RestController est simplement la combinaison des deux annotations précédentes. Une fois ajouté, il indique que cette
classe va pouvoir traiter les requêtes que nous allons définir. Il indique aussi que chaque méthode va renvoyer
directement la réponse JSON à l'utilisateur, donc pas de vue dans le circuit.

réponse formatée en JSON grâce l'annotation @RestController. Spring sait que les réponses aux requêtes qu'il vous passe
devront être en format JSON.
L'auto-configurateur va alors chercher si vous avez dans votre classpath une dépendance capable de transformer un object
Java en JSON, et inversement.
Jackson a été importé avec le starter que nous avons utilisé. Le Bean Product renvoyé est donc transformé en JSON
puis servi en réponse.

 */


@RestController
public class CharacterController {

    /* Méthode pour GET /Characters

       L'annotation @RequestMapping  qui permet de faire le lien entre l'URI "/Produits", invoquée via GET, et la
       méthode listeProduits

       L'annotation accepte plusieurs paramètres , dont voici les principaux :

        value : C'est ici que vous indiquez l'URI à laquelle cette méthode doit répondre.

        method : Vous indiquez ici à quel type de requêtes cette méthode doit répondre. Dans notre cas, notre méthode
        listCharacters ne sera déclenchée que si l'URI est exactement "/Characters" et que la requête est de type GET.

        produces : Dans certains cas d'utilisations avancées, vous aurez besoin de préciser, par exemple, que
        votre méthode est capable de répondre en XML et en JSON. Cela entre aussi dans le choix de la méthode qui
        correspond le mieux à la requête. Si la requête contient du XML et que vous avez 2 méthodes identiques, dont
        une capable de produire du XML, c'est celle-ci qui sera appelée. Il en va de même pour consumes qui précise
        es formats acceptés. Dans la plupart des cas, vous n'avez pas besoin de renseigner ces paramètres.


     */
    @RequestMapping(value="/Characters", method= RequestMethod.GET)
    public String listCharacter() {
        return "Un exemple de personnage";
    }

    /*
     Méthode pour GET /Produits/{id}: récupérer un personnage par son id

     Création d'une deuxième méthode capable d'accepter un Id de produit en paramètre :
     l'ajout de {id} à l'URI. Cette notation permet d'indiquer que cette méthode doit répondre uniquement aux requêtes
     avec une URI de type /Characters/25 par exemple.
     Comme nous avons indiqué que id doit être un int (dans @PathVariable int id)

     Remarques: une @RequestMapping qui accepte des requêtes de type GET, peut etre remplacé par @GetMapping
     */

    @GetMapping(value = "/Characters/{id}")
    public Character afficherUnPersonnage(@PathVariable int id) {
        Character character = new Character(id, new String("Lapin Guerrier"),"Guerrier");
        return character;
    }
}


