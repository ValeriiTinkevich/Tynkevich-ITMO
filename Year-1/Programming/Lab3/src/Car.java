public class Car extends Essence implements Moveable, Revvable {

    protected final String engine = "Мотор";
    public Car(String name) {
        super(name);
    }

    @Override
    public void move(Place moveto) {
        System.out.println(getName() + "добрался до" + moveto);
    }

    @Override
    public void rev() {
        System.out.println(this.engine + " загудел");
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
