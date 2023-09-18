public class Human extends Essence implements Moveable, Speakable, Enterable  {

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


    public static void dissolve(Object obj) throws InvalidTypeException {
        if (!(obj instanceof Human[])) {
            throw new InvalidTypeException("Argument must be of type Human[]");
        }
        System.out.println("толпа рассеялась");
    }

    public void stop(Essence essence) {
        System.out.println(getName() + " остановился возле " + essence.getName());
    }

    public void open(Car car) {
        System.out.println(getName() + " открыл дверь " + car.getName());
    }

    public void close(Car car) {
        System.out.println(getName() + " закрыл дверь " + car.getName());
    }

    public void rise(Place place) {
        System.out.println(getName() + " поднялся с " + place.getName());
    }

    public void drumm(Door door) {
        System.out.println(getName() + " забарабанил в " + door.getName());
    }

    }


