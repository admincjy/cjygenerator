package com.wecat.small.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.wecat.small.service.EmployeeService;
import com.wecat.small.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wecat.small.common.BaseRespMsg;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cjy
 * @since 2018-11-27
 */
@RestController
@RequestMapping("Employee")
public class EmployeeController {


    @Autowired
    private EmployeeService targetService;

    
    /**
     * 获取数据列表
     */
//    @RequestMapping("/list")
//    @ResponseBody
//    public BaseResponse findListByPage(@RequestParam(name = "page", defaultValue = "1") int pageIndex,@RequestParam(name = "rows", defaultValue = "20") int step){
//        Page page = new Page(pageIndex,step);
//        targetService.selectPage(page);
//        return BaseResponse.onSuccess(page);
//    }


    /**
     * 获取全部数据
     */
    @RequestMapping("/all")
    @ResponseBody
    public Object findAll(){
        List<Employee> entitys = targetService.selectList();
        return entitys;
    }


    /**
     * 根据ID查找数据
     */
    @RequestMapping("/find")
    @ResponseBody
    public Object find(@RequestParam("id") Long id){
        Employee entity = targetService.selectById(id);
        if(entity==null){
            return new BaseRespMsg(99,"未查询到该记录");
        }
        return entity;
    }


    /**
     * 添加数据
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespMsg addItem(@RequestBody Employee entity){
        int isOk = targetService.insert(entity);
        if(isOk==1){
            return new BaseRespMsg(0,"添加成功");
        }
        return BaseRespMsg.error("添加失败");
    }


    /**
     * 更新数据
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseRespMsg update(@RequestBody Employee entity){
        int isOk = targetService.update(entity);
        if(isOk==1){
            return new BaseRespMsg(0,"更新成功");
        }
        return BaseRespMsg.error("更新失败");
     }


    /**
     * 批量删除数据
     */
    @RequestMapping("/dels")
    @ResponseBody
    public BaseRespMsg deleteItems(@RequestParam("ids") List<Long> ids){
        int isOk = targetService.deleteBatchIds(ids);
        if(isOk>0){
            return new BaseRespMsg(0,"批量删除成功");
        }
        return BaseRespMsg.error("批量删除失败");
    }
    
    /**
     * 删除数据
     */
    @RequestMapping("/del")
    @ResponseBody
    public BaseRespMsg deleteItems(@RequestParam("id") Long id){
        int isOk = targetService.deleteBatchId(id);
        if(isOk==1){
            return new BaseRespMsg(0,"删除成功");
        }
        return BaseRespMsg.error("删除失败");
    }
    
  }