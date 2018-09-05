package repository;

import entity.AddEntity;
import entity.AddId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lenovo on 2018/8/16.
 */
public interface AddEntityRepo extends CrudRepository<AddEntity, AddId> {


}