package repository;

import entity.CarOwnerInfoEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lenovo on 2018/8/23.
 */
public interface UpdateCarOwnerInfoRepo extends CrudRepository<CarOwnerInfoEntity,Integer>,PagingAndSortingRepository<CarOwnerInfoEntity,Integer>,JpaSpecificationExecutor {

    @Transactional
    @Modifying
    @Query(value = "update CarOwnerInfoEntity set carId=?1,carPersonAge=?2,carPersonName=?3,carPersonSFId=?4,carType=?5 where id=?6")
    void updateCarOwnerInfo(String carId,int carPersonAge,String carPersonName,String carPersonSFId,String carType,int id);
}
