package com.manage.project.mapper;

import com.manage.project.model.domain.Worker;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 麻小神
* @description 针对表【worker】的数据库操作Mapper
* @createDate 2024-05-12 20:42:48
* @Entity com.manage.project.model.domain.Worker
*/
@Mapper
public interface WorkerMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Worker record);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(Long id);
    List<Worker> selectWorkList();

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);

}
