package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Created by lenovo on 2018/8/24.
 */

@Entity
@Table(name="timeChange")
public class TimeChangeEntity {

    @Id
    private int id;
    private String carOwnerType;
    private String carColor;
    private String carPositionNum;
    private String comeState;
    private String operator;
    private String carPersonName;
    private int comeTime;
    @OneToOne
    private CarOwnerInfoEntity carOwnerInfoEntity;

    public CarOwnerInfoEntity getCarOwnerInfoEntity() {
        return carOwnerInfoEntity;
    }

    public void setCarOwnerInfoEntity(CarOwnerInfoEntity carOwnerInfoEntity) {
        this.carOwnerInfoEntity = carOwnerInfoEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getComeTime() {
        return comeTime;
    }

    public void setComeTime(int comeTime) {
        this.comeTime = comeTime;
    }

    public String getCarPersonName() {
        return carPersonName;
    }

    public void setCarPersonName(String carPersonName) {
        this.carPersonName = carPersonName;
    }
}
