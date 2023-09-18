public class Car extends Essence implements Moveable {
    private final CarDoor door = new CarDoor();

    public void openDoor() {
        door.open();
    }
    public void closeDoor() {
        door.close();
    }


    public Car(String name) {
        super(name);
    }


    public static class engine {
        public static void rev() {
            System.out.println("Мотор загудел");
        }
    }

    private class CarDoor {
        public void open() {
            System.out.println("дверь открылась");
        }
        public void close() {
            System.out.println("дверь закрылась");
        }
    }

    @Override
    public void move(Place moveto) {
        System.out.println(getName() + "добрался до" + moveto);
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

}
