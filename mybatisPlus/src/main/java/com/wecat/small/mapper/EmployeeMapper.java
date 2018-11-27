package com.wecat.small.mapper;

import com.wecat.small.entity.Employee;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjy
 * @since 2018-11-27
 */
public interface EmployeeMapper{

       List<Employee> selectList();
       
       Employee selectById(Long id);
       
       int insert(Employee entity);
       
       int update(Employee entity);
       
       int deleteBatchIds(List<Long> ids);
       
       int deleteBatchId(Long id);

}
