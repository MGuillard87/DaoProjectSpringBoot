package com.donjondragon.microdonjondragon.model;
/*  Création d'une classe qui représente un personnage et qui a au minimun:
    avoir au minimum :
    - un constructeur public sans argument
    - des getters et setters pour toutes les propriétés de la classe.

   Quand on fait appel à l'URI "/Produits/{id}", on renvoie un personnage au format JSON qui correspond à
    à la classe Character
*/
public class Character {

    //  les propriétés de base de la classe Character
    private int id;
    private String nom;
    private String type;

    //constructeur par défaut sans arguments
    public Character() {
    }

    //constructeur pour les tests
    public Character(int id, String nom, String type) {
        this.id = id;
        this.nom = nom;
        this.type = type;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    //méthode magique ToString pour l'affichage automatique
    @Override
    public String toString() {
        return "Character{"+
                "id=" + id +
                ", nom='"+ nom + '\'' +
                ", type=" + type+ '}';
    }

}

