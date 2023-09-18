public class Policeman extends Human implements Pickable {

    private final Type button;
    private final Place workplace;
    public Policeman(String name, Type button, Place workplace) {
        super(name);
        this.button = button;
        this.workplace = workplace;
    }

    public void getUniform() {
        switch (button) {
            case Shiny -> System.out.println(getName() + " был одет в мундир с ярко блестящими пуговицами");
            case Greasy -> System.out.println(getName() + " был одет в мундир с тусклыми и окисленными пуговицами");
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
}
