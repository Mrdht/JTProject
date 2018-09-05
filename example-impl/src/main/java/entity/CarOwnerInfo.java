package entity;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/8/20.
 */

public class CarOwnerInfo implements Serializable {

    private  int id;
    private  String carId;
    private  int carPersonAge;
    private  String carPersonName;
    private  String carPersonSFId;

    private  String carType;

    public CarOwnerInfo(){}

    public CarOwnerInfo(int id, String carId, int carPersonAge, String carPersonName, String carPersonSFId, String carType) {
        this.id = id;
        this.carId = carId;
        this.carPersonAge = carPersonAge;
        this.carPersonName = carPersonName;
        this.carPersonSFId = carPersonSFId;
        this.carType = carType;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarOwnerInfo that = (CarOwnerInfo) o;

        if (id != that.id) return false;
        if (carPersonAge != that.carPersonAge) return false;
        if (carId != null ? !carId.equals(that.carId) : that.carId != null) return false;
        if (carPersonName != null ? !carPersonName.equals(that.carPersonName) : that.carPersonName != null)
            return false;
        if (carPersonSFId != null ? !carPersonSFId.equals(that.carPersonSFId) : that.carPersonSFId != null)
            return false;
        return carType != null ? carType.equals(that.carType) : that.carType == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (carId != null ? carId.hashCode() : 0);
        result = 31 * result + carPersonAge;
        result = 31 * result + (carPersonName != null ? carPersonName.hashCode() : 0);
        result = 31 * result + (carPersonSFId != null ? carPersonSFId.hashCode() : 0);
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        return result;
    }
}
