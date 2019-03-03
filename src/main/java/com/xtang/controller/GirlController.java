package com.xtang.controller;

import com.xtang.aspect.HttpAspect;
import com.xtang.domain.Girl;
import com.xtang.domain.Result;
import com.xtang.repository.GirlRepository;
import com.xtang.service.GirlService;
import com.xtang.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @program: springbootdemo
 * @Date: 2019/3/3 16:44
 * @Author: river
 * @Description:
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询女生列表所有
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girls(){
        return girlRepository.findAll();
    }

    /**
     * 添加
     * @return
     */
    @PostMapping(value = "/addGirls")
    public Result<Girl> girlsAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查询
     * @return
     */
    @GetMapping(value = "/getGirls/{id}")
    public Girl girlsFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 更新
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/updateGirls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping(value = "/deleteGirls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    @GetMapping(value = "getGirlsByAge/{age}")
    public List<Girl> getListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/insertGirls")
    public void girlTow(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
