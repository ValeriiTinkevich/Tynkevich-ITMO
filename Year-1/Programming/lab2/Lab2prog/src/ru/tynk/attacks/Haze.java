package ru.tynk.attacks;
import ru.ifmo.se.pokemon.*;

public class Haze extends StatusMove {
    public Haze(){
      super(Type.ICE,0,0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
      p.setMod(Stat.ACCURACY, 0);
      p.setMod(Stat.ATTACK, 0);
      p.setMod(Stat.DEFENSE, 0);
      p.setMod(Stat.EVASION, 0);
      p.setMod(Stat.HP, 0);
      p.setMod(Stat.SPECIAL_ATTACK, 0);
      p.setMod(Stat.SPECIAL_DEFENSE, 0);
      p.setMod(Stat.SPEED, 0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
      p.setMod(Stat.ACCURACY, 0);
      p.setMod(Stat.ATTACK, 0);
      p.setMod(Stat.DEFENSE, 0);
      p.setMod(Stat.EVASION, 0);
      p.setMod(Stat.HP, 0);
      p.setMod(Stat.SPECIAL_ATTACK, 0);
      p.setMod(Stat.SPECIAL_DEFENSE, 0);
      p.setMod(Stat.SPEED, 0);
    }

    @Override
    protected String describe() {
      return "Использует Haze";
    }
}
