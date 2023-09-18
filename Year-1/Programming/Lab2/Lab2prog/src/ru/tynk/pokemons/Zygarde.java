package ru.tynk.pokemons;
import ru.ifmo.se.pokemon.*;
import ru.tynk.attacks.*;

public class Zygarde extends Pokemon {
    public Zygarde(String name, int level) {
      super(name,level);
      setStats(108,100,121,81,95,95);
      setType(Type.DRAGON, Type.GROUND);
      setMove(new Glare(), new Coil(), new Haze(), new DragonPulse());
    }
}
