package entity;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/8/24.
 */

public class SelectTimeChangeEntity implements Serializable {

    private String carOwnerType;
    private String carColor;
    private String carPositionNum;
    private String comeState;
    private String operator;
    private Integer comeTime;
    private String carType;
    private String carId;

    public SelectTimeChangeEntity() {
    }

    public SelectTimeChangeEntity(String carOwnerType, String carColor, String carPositionNum, String comeState, String operator, Integer comeTime, String carType, String carId) {
        this.carOwnerType = carOwnerType;
        this.carColor = carColor;
        this.carPositionNum = carPositionNum;
        this.comeState = comeState;
        this.operator = operator;
        this.comeTime = comeTime;
        this.carType = carType;
        this.carId = carId;
    }

    public String getCarOwnerType() {
        return carOwnerType;
    }

    public void setCarOwnerType(String carOwnerType) {
        this.carOwnerType = carOwnerType;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarPositionNum() {
        return carPositionNum;
    }

    public void setCarPositionNum(String carPositionNum) {
        this.carPositionNum = carPositionNum;
    }

    public String getComeState() {
        return comeState;
    }

    public void setComeState(String comeState) {
        this.comeState = comeState;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getComeTime() {
        return comeTime;
    }

    public void setComeTime(Integer comeTime) {
        this.comeTime = comeTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
}
