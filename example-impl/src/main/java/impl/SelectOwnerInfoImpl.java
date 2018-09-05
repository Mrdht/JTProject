package impl;

import api.SelectOwnerInfo;
import pojo.OwnerInfo;
import repository.SelectCarOwnerInfo;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/8/20.
 */
public class SelectOwnerInfoImpl implements SelectOwnerInfo{

    @Inject
    SelectCarOwnerInfo selectOwnerInfo;

    @Override
    public OwnerInfo selectOwnerInfo(String carPersonName, String carId) {

        OwnerInfo ownerInfo =new OwnerInfo();

        ownerInfo.setCarId(selectOwnerInfo.findBycarPersonNameAndCarId(carPersonName,carId).getCarId());
        ownerInfo.setCarPersonAge(selectOwnerInfo.findBycarPersonNameAndCarId(carPersonName,carId).getCarPersonAge());
        ownerInfo.setCarPersonName(selectOwnerInfo.findBycarPersonNameAndCarId(carPersonName,carId).getCarPersonName());
        ownerInfo.setCarPersonSFId(selectOwnerInfo.findBycarPersonNameAndCarId(carPersonName,carId).getCarPersonSFId());
        ownerInfo.setCarType(selectOwnerInfo.findBycarPersonNameAndCarId(carPersonName,carId).getCarType());

        return ownerInfo;
    }

}
