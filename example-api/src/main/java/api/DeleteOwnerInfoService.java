package api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.MicroService;

/**
 * Created by lenovo on 2018/8/22.
 */
@MicroService("DeleteOwnerInfoService")
public interface DeleteOwnerInfoService extends ConcreteService {

    void deleteOwnerInfo( int id);
}
