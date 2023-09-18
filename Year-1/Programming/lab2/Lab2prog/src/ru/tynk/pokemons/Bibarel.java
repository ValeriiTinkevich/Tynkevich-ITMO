package ru.tynk.pokemons;

import ru.ifmo.se.pokemon.*;
import ru.tynk.attacks.*;

public class Bibarel extends Pokemon {
    public Bibarel(String name, int level) {
      super(name, level);
      setStats(79,85,60,55,60,71);
      setType(Type.NORMAL, Type.WATER);
      setMove(new Swagger(), new SuperFang(), new Amnesia(), new Waterfall());
    }
}
