package com.donjondragon.microdonjondragon.dao;
import com.donjondragon.microdonjondragon.model.Character;
import java.util.List;
// gérer l'acces au données
// interface nommée CharacterDao, dans laquelle on déclare les opérations qui vont etre implémenter
public interface CharacterDao {
    //findAll : renvoie la liste complète de tous les personnages ;
    public List<Character>findAll();
    //findById : renvoie un personnage par son Id ;
    public Character findById(int id);
    //save : ajoute un personnage.
    public Character save(Character character);
    //delete: supprimer un personnage
    public Boolean delete(int id);

    //put: modifier un personnage
    public Character update(Character character);

}



