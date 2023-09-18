package ru.tynk.attacks;
import ru.ifmo.se.pokemon.*;

public class DragonPulse extends SpecialMove {
    public DragonPulse(){
      super(Type.DRAGON,85,100);
    }


    @Override
    protected String describe() {
      return "Использует Dragon Pulse";
    }
}
