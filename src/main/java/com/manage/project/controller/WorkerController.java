package com.manage.project.controller;

import com.manage.project.model.domain.Worker;
import com.manage.project.model.response.Result;
import com.manage.project.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkerController {
    @Autowired
    private WorkerService workerService;
    @RequestMapping("/insertWorker")
    public Result insert(String name, String sex, String age){
        Worker worker = new Worker();
        worker.setWorkerName(name);
        worker.setWorkerSex(sex);
        worker.setWorkerAge(Integer.valueOf(age));
        int insert = workerService.insert(worker);
        if (insert > 0){
            return Result.success("添加员工成功");
        }
        return Result.failure("添加员工失败",40000);
    }
    @RequestMapping("/updateWorker")
    public Result update(String id,String name, String sex, String age){
        Worker worker = new Worker();
        worker.setWorkerId(Integer.valueOf(id));
        worker.setWorkerName(name);
        worker.setWorkerSex(sex);
        worker.setWorkerAge(Integer.valueOf(age));
        int update = workerService.updateByPrimaryKeySelective(worker);
        if (update > 0){
            return Result.success("修改员工成功");
        }
        return Result.failure("修改员工失败",40000);
    }

    @RequestMapping("/deleteWorker")
    public Result delete(int workerId){
        Long id = (long) workerId;
        int delete = workerService.deleteByPrimaryKey(id);
        if (delete > 0){
            return Result.success("删除员工成功");
        }
        return Result.failure("删除员工失败",40000);
    }
    @RequestMapping("/getWorkerList")
    public Result getWorkerList(){
        List<Worker> workers = workerService.selectAllWorkers();
        if (workers != null){
            return Result.success("查询员工成功",workers);
        }
        return Result.failure("查询员工失败",40000);
    }
}
