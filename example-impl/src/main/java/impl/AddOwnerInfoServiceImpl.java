package impl;

import api.AddOwnerInfoService;
import entity.CarOwnerInfoEntity;
import repository.AddCarOwnerInfoRepo;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/8/23.
 */
public class AddOwnerInfoServiceImpl implements AddOwnerInfoService {
    @Inject
    AddCarOwnerInfoRepo addCarOwnerInfoRepo;
    @Override
    public void addOwnerInfo(String carPersonName, String carId, int carPersonAge, String carPersonSFId, String carType) {

        CarOwnerInfoEntity c=new CarOwnerInfoEntity();
        c.setCarId(carId);
        c.setCarPersonName(carPersonName);
        c.setCarPersonAge(carPersonAge);
        c.setCarPersonSFId(carPersonSFId);
        c.setCarType(carType);

        addCarOwnerInfoRepo.save(c);
    }
}
