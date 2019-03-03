package com.xtang.service;

import com.xtang.Enums.ResultEnum;
import com.xtang.domain.Girl;
import com.xtang.exception.GirlException;
import com.xtang.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: springbootdemo
 * @Date: 2019/3/3 17:56
 * @Author: river
 * @Description:
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("D");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("EEEE");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10){
            //return "你小于10岁";
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //return "你年龄10-16";
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

    }
}
