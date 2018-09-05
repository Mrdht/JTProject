package entity;

import javax.persistence.*;

@Entity
@Table(name = "t_add")
@IdClass(AddId.class)
public class AddEntity {
    @Id
    private int x1;
    @Id
    private int x2;

    @Column(name = "col_sum")
    private int sum;

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

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}