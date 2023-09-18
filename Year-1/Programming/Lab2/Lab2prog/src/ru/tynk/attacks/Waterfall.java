package ru.tynk.attacks;
import ru.ifmo.se.pokemon.*;

public class Waterfall extends PhysicalMove {
    public Waterfall(){
      super(Type.WATER,80,100);
    }


    @Override
    protected String describe() {
      return "использует Waterfall";
    }

}
