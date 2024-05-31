package com.manage.project.service;

import com.manage.project.model.domain.Worker;

import java.util.List;

public interface WorkerService {
    int deleteByPrimaryKey(Long id);

    int insert(Worker record);

    int insertSelective(Worker record);

    Worker selectByPrimaryKey(Long id);

    List<Worker> selectAllWorkers();

    int updateByPrimaryKeySelective(Worker record);

    int updateByPrimaryKey(Worker record);
}
