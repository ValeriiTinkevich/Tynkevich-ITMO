public class Human extends Essence implements Moveable, Speakable, Enterable {

    public Human(String name) {
        super(name);
    }

    @Override
    public void move(Place moveto) {
        System.out.println(getName() + " добрался до " + moveto.getName());
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

    @Override
    public void speak(String words, Human speakto) {
        System.out.println(getName() + " сказал " + speakto.getName() + ": " + words);
    }

    @Override
    public void enterCar(Car car) {
        System.out.println(getName() + " сел в " + car.getName());
    }
}
