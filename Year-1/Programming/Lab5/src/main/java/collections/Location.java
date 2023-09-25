package collections;

import java.util.Objects;

public class Location {
    private double x;
    private Long y; //Поле не может быть null
    private Integer z; //Поле не может быть null

    public Location(double x, Long y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Double getX() {
        return x;
    }

    public Long getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(Long y) {
        this.y = y;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Location location)) return false;

        return Objects.equals(this.getX(), location.getX()) && Objects.equals(this.getY(), location.getY())
                && Objects.equals(this.getZ(), location.getZ());
    }
}
