package api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.MicroService;
import pojo.OwnerInfo;
import java.util.List;

/**
 * Created by lenovo on 2018/8/22.
 */
@MicroService("SelectAllOwnerInfoService")
public interface SelectAllOwnerInfoService extends ConcreteService{

    List<OwnerInfo> selectAllOwnerInfo(int page);
}
