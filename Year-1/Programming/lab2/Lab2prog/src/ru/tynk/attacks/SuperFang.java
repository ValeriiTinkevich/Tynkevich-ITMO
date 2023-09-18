package ru.tynk.attacks;
import ru.ifmo.se.pokemon.*;

public class SuperFang extends PhysicalMove {
    public SuperFang(){
      super(Type.NORMAL,0,90);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
      double currHP = def.getHP();
      damage =  currHP / 2;
      if(currHP == 1) {
        def.setMod(Stat.HP, 1);
      }
      else {
          def.setMod(Stat.HP, (int)damage);
      }
    }

    @Override
    protected String describe() {
      return "использует Super Fang";
    }

}
