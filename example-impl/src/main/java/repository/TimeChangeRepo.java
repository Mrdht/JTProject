package repository;

import entity.TimeChangeEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lenovo on 2018/8/24.
 */
public interface TimeChangeRepo extends CrudRepository<TimeChangeEntity, Integer>,PagingAndSortingRepository<TimeChangeEntity, Integer>,JpaSpecificationExecutor {

}
