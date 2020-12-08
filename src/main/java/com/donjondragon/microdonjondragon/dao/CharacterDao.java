package com.donjondragon.microdonjondragon.dao;
import com.donjondragon.microdonjondragon.model.Character;
import java.util.List;

public interface CharacterDao {
    public List<Character>findAll();
    public Character findById(int id);
    public Character save(Character character);
}

