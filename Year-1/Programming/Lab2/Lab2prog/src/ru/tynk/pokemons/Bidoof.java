package ru.tynk.pokemons;
import ru.ifmo.se.pokemon.*;
import ru.tynk.attacks.*;

public class Bidoof extends Pokemon {
    public Bidoof(String name, int level) {
      super(name,level);
      setStats(59,45,40,35,40,31);
      setType(Type.NORMAL);
      setMove(new Swagger(), new SuperFang(), new Amnesia());
    }
}
