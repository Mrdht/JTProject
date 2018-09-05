package entity;
import java.io.Serializable;
import java.util.Objects;

public class AddId implements Serializable {
    private int x1;
    private int x2;

    public AddId() {
    }

    public AddId(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddId addId = (AddId) o;
        return x1 == addId.x1 &&
                x2 == addId.x2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2);
    }
}