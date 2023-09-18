public class Place extends Essence{

    private Furniture[] furniture;
    public Place (String name) throws NameError {
        super((name.isEmpty()) ? "Место" : name);
        if(name.isEmpty())
        {
            throw new NameError("Объект не может быть создан без имени!");
        }
        this.furniture = null;
    }
    public Place(String name, Furniture[] furniture) {
        super(name);
        this.furniture = furniture;
    }

    public void describeFurniture() {
        for(Furniture i: furniture) {
            System.out.println("в комнате был " + i.getName());
        }
    }

    static class Furniture extends Essence {
        public Furniture(String name) {
            super(name);
        }
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
        return "Имя: " + getName();
    }
}