package com.wecat.small.service;

import com.wecat.small.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.wecat.small.mapper.EmployeeMapper;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjy
 * @since 2018-11-27
 */
@Service
@Transactional
public class EmployeeService{

    @Autowired
    private EmployeeMapper targetMapper;
    
    
    /**
     * 获取全部数据
     */
    public List<Employee> selectList(){
        List<Employee> entitys = targetMapper.selectList();
        return entitys;
    }


    /**
     * 根据ID查找数据
     */
    public Employee selectById(Long id){
        Employee entity = targetMapper.selectById(id);
        return entity;
    }


    /**
     * 添加数据
     */
    public int insert(Employee entity){
        int isOk = targetMapper.insert(entity);
        return isOk;
    }


    /**
     * 更新数据
     */
    public int update(Employee entity){
        int isOk = targetMapper.update(entity);
        return isOk;
     }


    /**
     * 批量删除数据
     */
    public int deleteBatchIds(List<Long> ids){
        int isOk = targetMapper.deleteBatchIds(ids);
        return isOk;
    }
    
    /**
     * 删除数据
     */
    public int deleteBatchId(Long id){
        int isOk = targetMapper.deleteBatchId(id);
        return isOk;
    }

}

