package impl;

import api.UpdateOwnerInfoService;
import repository.UpdateCarOwnerInfoRepo;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/8/23.
 */
public class UpdateOwnerInfoServiceImpl implements UpdateOwnerInfoService{
    @Inject
    UpdateCarOwnerInfoRepo updateCarOwnerInfoRepo;

    @Override
    public void updateOwnerInfo(String carId, int carPersonAge, String carPersonName, String carPersonSFId, String carType,int id) {

        updateCarOwnerInfoRepo.updateCarOwnerInfo(carId,carPersonAge,carPersonName,carPersonSFId,carType,id);
    }
}
