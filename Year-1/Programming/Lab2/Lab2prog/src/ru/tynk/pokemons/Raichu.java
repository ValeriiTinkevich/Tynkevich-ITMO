package ru.tynk.pokemons;
import ru.ifmo.se.pokemon.*;
import ru.tynk.attacks.*;

public class Raichu extends Pokemon {
    public Raichu(String name, int level) {
      super(name,level);
      setStats(60,90,55,90,80,110);
      setType(Type.ELECTRIC);
      setMove(new Confide(), new Thunderbolt(), new Agility(), new Swagger());
    }
}
