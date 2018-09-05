package impl;

import api.ExampleApi;
import entity.AddId;
import error.ExampleErrorCodes;
import org.coodex.concrete.common.Assert;
import repository.AddEntityRepo;
import javax.inject.Inject;

/**
 * Created by lenovo on 2018/8/16.
 */
public class ExampleImpl implements ExampleApi {

    @Inject
    AddEntityRepo addEntityRepo;

    @Override
    public int add(int x1, int x2) {

       /* int a=0;
        if(addEntityRepo.findOne(new AddId(x1, x2))==null){
            a=1;
        }if(addEntityRepo.findOne(new AddId(x1, x2))!=null){
            a=2;
        }
        return a;*/

        return Assert.isNull(
                addEntityRepo.findOne(new AddId(x1, x2)),
                ExampleErrorCodes.TOO_HARD, x1, x2).getSum();
    }

    @Override
    public String getRandomVeh(String id) {
        System.out.println(id);
        return "兄弟别闹";
    }

    @Override
    public String aclTest() {
        return null;
    }

}
