package impl;

import api.SelectAllOwnerInfoService;
import entity.CarOwnerInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pojo.OwnerInfo;
import repository.SelectCarOwnerInfo;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/8/22.
 */
 public class SelectAllOwnerInfoServiceImpl implements SelectAllOwnerInfoService {

   @Inject
   SelectCarOwnerInfo selectCarOwnerInfo;
    @Override
    public List<OwnerInfo> selectAllOwnerInfo(int page) {

        Page<CarOwnerInfoEntity> p = selectCarOwnerInfo.findAll(new PageRequest(page, 5));

        /*

        将 CarOwnerInfoEntity 按id进行倒序排序
        Sort s=new Sort(Sort.Direction.DESC,"id");
        Iterable<CarOwnerInfoEntity> i=  selectCarOwnerInfo.findAll(Sort sort);

         for(CarOwnerInfoEntity c:i){

            System.err.println(c.getId()+"     "+c.getCarId());
        }

   */

        /*

        将CarOwnerInfoEntity先按carId进行排序然后再按id进行排序
        List<Sort.Order> l=new ArrayList<>();
        Sort.Order sort = new Sort.Order(Sort.Direction.DESC,"id");
        Sort.Order sort1 = new Sort.Order(Sort.Direction.DESC,"carId");

        //List中先装谁就先按谁排序
        l.add(sort1);
        l.add(sort);


        Sort s=new Sort(l);

        Iterable<CarOwnerInfoEntity> i=selectCarOwnerInfo.findAll(s);

        for(CarOwnerInfoEntity c:i){

            System.err.println(c.getId()+"     "+c.getCarId());
        }

*/

       /*

        System.err.println(p.getTotalPages()+"  "+p.getTotalElements());

        for(CarOwnerInfoEntity p1:p){

            System.out.println(p1.getCarPersonName());
        }

        */

       /* 将所有用户展示

       List<CarOwnerInfoEntity>  carOwnerInfoEntity=selectCarOwnerInfo.findAll();

        List<OwnerInfo> ownerInfos=new ArrayList<>();

        for(CarOwnerInfoEntity c:carOwnerInfoEntity){

            OwnerInfo ownerInfo=new OwnerInfo();

            ownerInfo.setId(c.getId());
            ownerInfo.setCarPersonName(c.getCarPersonName());
            ownerInfo.setCarPersonAge(c.getCarPersonAge());
            ownerInfo.setCarId(c.getCarId());
            ownerInfo.setCarType(c.getCarType());
            ownerInfo.setCarPersonSFId(c.getCarPersonSFId());

            ownerInfos.add(ownerInfo);
        }*/


       //分页展示用户
        List<OwnerInfo> ownerInfos = new ArrayList<>();

        for (CarOwnerInfoEntity c : p) {

            OwnerInfo ownerInfo = new OwnerInfo();

            ownerInfo.setId(c.getId());
            ownerInfo.setCarPersonName(c.getCarPersonName());
            ownerInfo.setCarPersonAge(c.getCarPersonAge());
            ownerInfo.setCarId(c.getCarId());
            ownerInfo.setCarType(c.getCarType());
            ownerInfo.setCarPersonSFId(c.getCarPersonSFId());
            ownerInfo.setSumPage(p.getTotalPages());
            ownerInfos.add(ownerInfo);
        }

        return ownerInfos;
    }

}
