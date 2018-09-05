package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lenovo on 2018/8/20.
 */
@Entity
@Table(name="carowerinfo")
//@IdClass(CarOwnerInfoRepo.class)实现复合主键
public class CarOwnerInfoEntity {

    @Id
    private  int id;
    private  String carId;
    private  int carPersonAge;
    private  String carPersonName;
    private  String carPersonSFId;
    private  String carType;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getCarPersonAge() {
        return carPersonAge;
    }

    public void setCarPersonAge(int carPersonAge) {
        this.carPersonAge = carPersonAge;
    }

    public String getCarPersonName() {
        return carPersonName;
    }

    public void setCarPersonName(String carPersonName) {
        this.carPersonName = carPersonName;
    }

    public String getCarPersonSFId() {
        return carPersonSFId;
    }

    public void setCarPersonSFId(String carPersonSFId) {
        this.carPersonSFId = carPersonSFId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
