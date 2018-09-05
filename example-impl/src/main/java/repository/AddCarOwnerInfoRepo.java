package repository;

import entity.CarOwnerInfoEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lenovo on 2018/8/23.
 */
public interface AddCarOwnerInfoRepo extends CrudRepository<CarOwnerInfoEntity,Integer>,PagingAndSortingRepository<CarOwnerInfoEntity,Integer>,JpaSpecificationExecutor {

}
