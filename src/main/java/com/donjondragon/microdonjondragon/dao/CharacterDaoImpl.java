package com.donjondragon.microdonjondragon.dao;

import com.donjondragon.microdonjondragon.model.Character;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//classe qui implémente l'interface CharacterDao

/* appliquée à la classe afin d'indiquer à Spring qu'il s'agit d'une classe qui gère les données, ce qui va permettre
de profiter de certaines fonctionnalités

définition d'un tableau de personnages  dans lequel on ajoute 10 personnages statiques. Les méthodes sont
 redéfinies pour renvoyer les données adéquates :

*/
@Repository
public class CharacterDaoImpl implements CharacterDao {
    // création des Personnages en dur
    public static List<Character> characters = new ArrayList<>();

    static {
        characters.add(new Character(1, new String("Hulk"), "Guerrier"));
        characters.add(new Character(2, new String("Merlin"), "Magicien"));
        characters.add(new Character(3, new String("Clochette"), "Magicien"));
        characters.add(new Character(4, new String("Superman"), "Guerrier"));
        characters.add(new Character(5, new String("Spyro"), "Guerrier"));
        characters.add(new Character(6, new String("Lomage"), "Magicien"));
        characters.add(new Character(7, new String("Hercule"), "Guerrier"));
        characters.add(new Character(8, new String("Magne"), "Magicien"));
        characters.add(new Character(9, new String("tac"), "Guerrier"));
        characters.add(new Character(10, new String("Tic"), "Magicien"));
    }

    @Override
    public List<Character> findAll() {
        return characters;
    }

    @Override
    public Character findById(int id) {
        for (Character character : characters) {
            if (character.getId() == id) {
                return character;
            }
        }
        return null;
    }

    @Override
    public Character save(Character character) {
        int id = character.getId();
        Character characterFindById = this.findById(id);
        if (characterFindById == null) {
            characters.add(character);
        }
        return character;
    }

    @Override
    public void delete(int id) {
        characters.removeIf(character -> character.getId() == id);
    }

/* méthode update (put) qui prend en paramétre le nouveau character à mettre dans le tableau à la place du character
à mettre à jour (un remplacement):
  */
    @Override
    public void update(Character character) {
        // récupération de l'id du nouveau character
        int id = character.getId();
        // chercher le character à mettre à jour en fonction de l'id du nouveau character
        Character characterToUpdate = this.findById(id);
        //si le character à mettre à jour recherché à partir de l'id existe: on fait les mises à jour
        if (characterToUpdate != null) {
            characterToUpdate.setNom(character.getNom());
            characterToUpdate.setType(character.getType());
        }
    }

}