package impl;

import api.SelectChangeInfoService;
import entity.SelectTimeChangeEntity;
import pojo.TimeChange;
import repository.SelectTimeChangeRepo;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/8/24.
 */
public class SelectChangeInfoServiceImpl implements SelectChangeInfoService {

    @Inject
    SelectTimeChangeRepo selectTimeChangeRepo;
    @Override
    public TimeChange selectChangeInfo(String carPersonName) {

        SelectTimeChangeEntity selectTimeChangeEntity=selectTimeChangeRepo.selectTimeChange(carPersonName);

        TimeChange timeChange=new TimeChange();

        timeChange.setCarOwnerType(selectTimeChangeEntity.getCarOwnerType());
        timeChange.setCarColor(selectTimeChangeEntity.getCarColor());
        timeChange.setCarPositionNum(selectTimeChangeEntity.getCarPositionNum());
        timeChange.setComeState(selectTimeChangeEntity.getComeState());
        timeChange.setOperator(selectTimeChangeEntity.getOperator());
        timeChange.setComeTime(selectTimeChangeEntity.getComeTime());
        timeChange.setCarType(selectTimeChangeEntity.getCarType());
        timeChange.setCarId(selectTimeChangeEntity.getCarId());
        timeChange.setLeaveTime("11");

        return timeChange;
    }
}
