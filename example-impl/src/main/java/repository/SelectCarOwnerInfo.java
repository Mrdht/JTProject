package repository;

import entity.CarOwnerInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lenovo on 2018/8/20.
 */
public interface SelectCarOwnerInfo extends CrudRepository<CarOwnerInfoEntity,Integer>,PagingAndSortingRepository<CarOwnerInfoEntity,Integer>,JpaSpecificationExecutor {

    CarOwnerInfoEntity findBycarPersonNameAndCarId(String carPersonName, String carId);

     // List<CarOwnerInfoEntity> findAll();

    //分页
    Page<CarOwnerInfoEntity>  findAll(Pageable pageable);
   //排序
    Iterable<CarOwnerInfoEntity> findAll(Sort sort);
}
