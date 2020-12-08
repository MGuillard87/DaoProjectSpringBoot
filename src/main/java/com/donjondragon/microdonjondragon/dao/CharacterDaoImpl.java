package com.donjondragon.microdonjondragon.dao;

import com.donjondragon.microdonjondragon.model.Character;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

//classe qui implémente l'interface CharacterDao

/* appliquée à la classe afin d'indiquer à Spring qu'il s'agit d'une classe qui gère les données, ce qui va permettre
de profiter de certaines fonctionnalités

définition d'un tableau de personnages  dans lequel on ajoute 10 personnages statiques. Les méthodes sont
 redéfinies pour renvoyer les données adéquates :

*/
@Repository
public class CharacterDaoImpl implements CharacterDao {
    // création des Personnages en dur
    public static List<Character>characters=new ArrayList<>();
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
    public List<Character>findAll() {
        return characters;
    }

    @Override
    public Character findById(int id) {
        for (Character character : characters) {
            if(character.getId() ==id){
                return character;
            }
        }
        return null;
    }

    @Override
    public Character save(Character character) {
        characters.add(character);
        return character;
    }
}
