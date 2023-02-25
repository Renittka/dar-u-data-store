package kz.dar.university.data.store.controller;

import kz.dar.university.data.store.model.TaskModel;
import kz.dar.university.data.store.model.TaskRequest;
import kz.dar.university.data.store.model.TaskResponse;
import kz.dar.university.data.store.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ITaskService taskService;


    @GetMapping("/check")
    public String check() {
        return "data-store is working";
    }

    @GetMapping("/{taskId}")
    public TaskResponse getTaskByTaskId(@PathVariable String taskId) {

        return taskService.getTaskByTaskId(taskId);

    }

    @GetMapping("/all")
    public List<TaskResponse> getAllTasks() {

        return taskService.getAllTasks();

    }

    @GetMapping("/initiator/{initiatorId}")
    public List<TaskResponse> getAllTasksByInitiatorId(@PathVariable String initiatorId) {

        return taskService.getTasksByInitiatorId(initiatorId, PageRequest.of());

    }

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest task) {

        return taskService.createTask(task);

    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable String taskId) {

        taskService.deleteTaskByTaskId(taskId);

    }

}
