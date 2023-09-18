package ru.tynk.attacks;
import ru.ifmo.se.pokemon.*;

public class Thunderbolt extends SpecialMove {
    public Thunderbolt(){
      super(Type.ELECTRIC,90,100);
    }

    boolean isParalyzed = false;
    @Override
    protected void applyOppEffects(Pokemon p){
        if(Math.random() <= 0.1){
            isParalyzed = true;
            Effect.paralyze(p);
        }
    }

    @Override
    protected String describe() {
      return "использует Thunderbolt";
    }

}
