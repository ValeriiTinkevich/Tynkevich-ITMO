public class Policeman extends Human implements Pickable {

    private final Type button;
    private final Place workplace;

    private final Hat hat;
    public Policeman(String name, Type button,Hat hat, Place workplace) {
        super(name);
        this.button = button;
        this.workplace = workplace;
        this.hat = hat;
    }

    public void getUniform() {
        switch (button) {
            case Shiny -> System.out.println(getName() + " был одет в мундир с ярко блестящими пуговицами");
            case Greasy -> System.out.println(getName() + " был одет в мундир с тусклыми и окисленными пуговицами");
        }
    }
    public void getHat() {
        switch (hat) {
            case Shiny -> System.out.println(getName() + " Носил блестящую каску");
            case NotShiny -> System.out.println(getName() + " Носил не такую блестящую каску");
        }
    }

    @Override
    public void Pickup(Midget midget, Policeman giveto) {
        System.out.println(getName() + " поднял " + midget.getName() + " и передал " + giveto.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode() == this.hashCode();
    }

    @Override
    public String toString() {
        return "Имя " + getName();
    }


    public void getWorkplace() {
        System.out.println(getName() + " работал в " + workplace.getName());
    }

    public void bear(Midget midget, Place place) {
        System.out.println(getName() + " протащил " + midget.getName() + " по " + place.getName());
    }

    public void bump(Midget midget) {
        System.out.println(getName() + " толкнул дубинкой " + midget.getName());
    }
}
