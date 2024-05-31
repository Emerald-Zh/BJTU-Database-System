package com.manage.project.service.impl;

import com.manage.project.mapper.WorkerMapper;
import com.manage.project.model.domain.Worker;
import com.manage.project.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkerService {
    @Autowired
    private WorkerMapper workerMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return workerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Worker record) {
        return workerMapper.insert(record);
    }

    @Override
    public int insertSelective(Worker record) {
        return workerMapper.insertSelective(record);
    }

    @Override
    public Worker selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<Worker> selectAllWorkers() {
        return workerMapper.selectWorkList();
    }

    @Override
    public int updateByPrimaryKeySelective(Worker record) {
        return workerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Worker record) {
        return 0;
    }
}
