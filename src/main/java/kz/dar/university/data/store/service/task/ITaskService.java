package kz.dar.university.data.store.service.task;

import com.fasterxml.jackson.core.JsonProcessingException;
import kz.dar.university.data.store.model.TaskRequest;
import kz.dar.university.data.store.model.TaskResponse;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITaskService {

    List<TaskResponse> getAllTasks(Pageable pageable);

    TaskResponse createTask(TaskRequest task) throws JsonProcessingException;

    TaskResponse getTaskByTaskId(String taskId);

    void deleteTaskByTaskId(String taskId);

    List<TaskResponse> getTasksByInitiatorId(String initiatorId, Pageable pageable);

}
