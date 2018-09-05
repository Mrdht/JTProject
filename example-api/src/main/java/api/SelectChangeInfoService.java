package api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.MicroService;
import pojo.TimeChange;

/**
 * Created by lenovo on 2018/8/24.
 */
@MicroService("SelectChangeInfoService")
public interface SelectChangeInfoService extends ConcreteService {

    TimeChange selectChangeInfo(String carPersonName);
}
