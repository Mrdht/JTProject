package api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Description;
import org.coodex.concrete.api.MicroService;

/**
 * Created by lenovo on 2018/8/24.
 */
@MicroService("AddChangeInfoService")
public interface AddChangeInfoService extends ConcreteService {

    @Description(name = "向TimeChange表中插入计时收费信息")
    void addTimeChangeInfo(String carOwnerType,String carColor,String carPositionNum,String comeState,String operator,String carPersonName,int comeTime);
    @Description(name = "向carownerinfo表中插入计时收费信息")
    void addCarOwnerInfoEntityInfo(String carPersonName,String carType,String carId);

}
