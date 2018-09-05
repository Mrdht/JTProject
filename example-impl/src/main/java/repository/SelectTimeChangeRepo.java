package repository;

import entity.SelectTimeChangeEntity;
import entity.TimeChangeEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lenovo on 2018/8/24.
 */
public interface SelectTimeChangeRepo extends CrudRepository<TimeChangeEntity,Integer>,PagingAndSortingRepository<TimeChangeEntity,Integer>,JpaSpecificationExecutor {

     //nativeQuery = true,在后面加上之后前面写原生sql,这时对应的是数据库名而不是实体名，如果不写原生sql一定要写实体名
    //这样写时SelectTimeChangeEntity中必须有构造方法
    @Query(value = "select new entity.SelectTimeChangeEntity(e.carOwnerType,e.carColor,e.carPositionNum,e.comeState,e.operator,e.comeTime,c.carType,c.carId) from TimeChangeEntity e left  join CarOwnerInfoEntity c on e.carPersonName=c.carPersonName where e.carPersonName=?1")
    SelectTimeChangeEntity selectTimeChange(String carPersonName);


}

