package impl;

import api.AddChangeInfoService;
import entity.CarOwnerInfoEntity;
import entity.TimeChangeEntity;
import repository.CarOwnerInfoRepo;
import repository.TimeChangeRepo;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/8/24.
 */
public class AddChangeInfoServiceImpl implements AddChangeInfoService {

    @Inject
    TimeChangeRepo timeChangeRepo;

    @Inject
    CarOwnerInfoRepo carOwnerInfoRepo;

    @Override
    public void addTimeChangeInfo(String carOwnerType, String carColor, String carPositionNum, String comeState, String operator,String carPersonName, int comeTime) {

        TimeChangeEntity timeChangeEntity=new TimeChangeEntity();

        timeChangeEntity.setCarOwnerType(carOwnerType);
        timeChangeEntity.setCarColor(carColor);
        timeChangeEntity.setCarPositionNum(carPositionNum);
        timeChangeEntity.setComeState(comeState);
        timeChangeEntity.setOperator(operator);
        timeChangeEntity.setCarPersonName(carPersonName);
        timeChangeEntity.setComeTime(comeTime);

        timeChangeRepo.save(timeChangeEntity);
    }

    @Override
    public void addCarOwnerInfoEntityInfo(String carPersonName, String carType, String carId) {

        CarOwnerInfoEntity carOwnerInfoEntity=new CarOwnerInfoEntity();

        carOwnerInfoEntity.setCarPersonName(carPersonName);
        carOwnerInfoEntity.setCarType(carType);
        carOwnerInfoEntity.setCarId(carId);

        carOwnerInfoRepo.save(carOwnerInfoEntity);
    }
}
