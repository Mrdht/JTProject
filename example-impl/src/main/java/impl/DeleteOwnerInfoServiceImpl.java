package impl;

import api.DeleteOwnerInfoService;
import repository.DeleteCarOwnerInfoRepo;

import javax.inject.Inject;

/**
 * Created by lenovo on 2018/8/22.
 */
public class DeleteOwnerInfoServiceImpl implements DeleteOwnerInfoService {

    @Inject
    DeleteCarOwnerInfoRepo deleteCarOwnerInfoRepo;

    @Override
    public void deleteOwnerInfo(int id) {

        deleteCarOwnerInfoRepo.delete(id);

    }
}
