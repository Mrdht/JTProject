package repository;

import entity.CarOwnerInfoEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lenovo on 2018/8/22.
 */
public interface DeleteCarOwnerInfoRepo extends CrudRepository<CarOwnerInfoEntity, Integer>,PagingAndSortingRepository<CarOwnerInfoEntity, Integer>,JpaSpecificationExecutor {

}
