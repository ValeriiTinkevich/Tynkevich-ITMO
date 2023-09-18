package collections;

public class Coordinates {
    private Double x; //Максимальное значение поля: 170, Поле не может быть null
    private Long y; //Значение поля должно быть больше -671, Поле не может быть null

    public Coordinates(Double x, Long y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return this.x;
    }

    public Long getY() {
        return this.y;
    }
}