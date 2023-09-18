public class Chauffeur extends Human implements Drivable {
    public Chauffeur(String name) {
        super(name);
    }

    @Override
    public void drive(Car car) {
        System.out.println(car.getName() + " запрыгал по камням мостовой");
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
