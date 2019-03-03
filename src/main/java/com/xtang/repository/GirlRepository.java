package com.xtang.repository;

import com.xtang.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: springbootdemo
 * @Date: 2019/3/3 16:47
 * @Author: river
 * @Description:
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄来查询
    public List<Girl> findByAge(Integer age);
}
