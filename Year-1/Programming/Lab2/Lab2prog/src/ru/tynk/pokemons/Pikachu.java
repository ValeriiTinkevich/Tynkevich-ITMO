package ru.tynk.pokemons;
import ru.ifmo.se.pokemon.*;
import ru.tynk.attacks.*;

public class Pikachu extends Pokemon {
    public Pikachu(String name, int level) {
      super(name,level);
      setStats(35,55,40,50,50,90);
      setType(Type.ELECTRIC);
      setMove(new Confide(), new Thunderbolt(), new Agility());
    }
}
