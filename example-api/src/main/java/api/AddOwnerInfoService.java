package api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.MicroService;

/**
 * Created by lenovo on 2018/8/23.
 */
@MicroService("AddOwnerInfoService")
public interface AddOwnerInfoService extends ConcreteService {

    void addOwnerInfo(String carPersonName,String carId,int carPersonAge,String carPersonSFId,String carType);
}
