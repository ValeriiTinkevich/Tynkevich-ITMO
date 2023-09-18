

import ru.tynk.pokemons.*;
import ru.ifmo.se.pokemon.Battle;

public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        Bibarel p1 = new Bibarel("бобер",1);
        Bidoof p2 = new Bidoof("бобяк", 1);
        Zygarde p3 = new Zygarde("змей", 1);
        Pichu p4 = new Pichu("мыш", 1);
        Pikachu p5 = new Pikachu("большая мыш", 1);
        Raichu p6 = new Raichu("оченьбольшаямыш", 1);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
