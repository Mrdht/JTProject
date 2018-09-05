package api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Description;
import org.coodex.concrete.api.MicroService;
import org.coodex.util.Parameter;
import pojo.OwnerInfo;

/**
 * Created by lenovo on 2018/8/20.
 */

@MicroService("SelectOwnerInfo")
public interface SelectOwnerInfo extends ConcreteService {

    @Description(name="通过用户名和车牌号查询用户所有信息")
    OwnerInfo selectOwnerInfo(@Parameter("carPersonName") @Description(name = "车主名")String carPersonName,@Parameter("carId") @Description(name = "车牌号")String carId);
}
