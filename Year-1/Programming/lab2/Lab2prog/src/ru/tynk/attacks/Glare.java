package ru.tynk.attacks;
import ru.ifmo.se.pokemon.*;

public class Glare extends StatusMove {
    public Glare(){
      super(Type.NORMAL,0,100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
      Effect.paralyze(p);
    }

    @Override
    protected String describe() {
      return "Использует Glare и paralyze цель";
    }
}
