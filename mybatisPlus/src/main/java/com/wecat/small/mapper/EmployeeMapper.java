package com.wecat.small.mapper;

import com.wecat.small.entity.Employee;
import com.wecat.small.common.PageInfoReqVo;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjy
 * @since 2018-11-29
 */
public interface EmployeeMapper{

       List<Employee> selectList();
       
       Employee selectById(Long id);
       
       int insert(Employee entity);
       
       int update(Employee entity);
       
       int deleteById(Long id);
       
       int deleteBatchIds(List<Long> ids);
       
       List<Employee> selectByPage(PageInfoReqVo<Employee> pageInfoReqVo);

}
