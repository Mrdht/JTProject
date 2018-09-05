package api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.MicroService;

/**
 * Created by lenovo on 2018/8/23.
 */
@MicroService("UpdateOwnerInfoService")
public interface UpdateOwnerInfoService extends ConcreteService {

    void updateOwnerInfo(String carId,int carPersonAge,String carPersonName,String carPersonSFId,String carType,int id);
}
