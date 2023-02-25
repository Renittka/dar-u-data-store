package kz.dar.university.data.store.service;

import kz.dar.university.data.store.model.TaskRequest;
import kz.dar.university.data.store.model.TaskResponse;
import kz.dar.university.data.store.repository.TaskEntity;
import kz.dar.university.data.store.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    ModelMapper mapper = new ModelMapper();

    {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public List<TaskResponse> getAllTasks() {

        return taskRepository.getTaskEntitiesBy()
                .stream().map(entity -> mapper.map(entity, TaskResponse.class))
                .toList();

    }

    @Override
    public TaskResponse createTask(TaskRequest task) {

        log.info("Task request: " + task);
        task.setTaskId(UUID.randomUUID().toString());

        TaskEntity taskEntity = mapper.map(task, TaskEntity.class);
        log.info("Task entity: " + taskEntity);
        TaskEntity result = taskRepository.save(taskEntity);

        log.info("Result: " + result);
        return mapper.map(result, TaskResponse.class);

    }

    @Override
    public TaskResponse getTaskByTaskId(String taskId) {

        TaskEntity result = taskRepository.getTaskEntityByTaskId(taskId);
        return mapper.map(result, TaskResponse.class);

    }

    @Override
    public void deleteTaskByTaskId(String taskId) {

        taskRepository.deleteTaskEntityByTaskId(taskId);

    }

    @Override
    public List<TaskResponse> getTasksByInitiatorId(String initiatorId, Pageable pageable) {

        return taskRepository.getTaskEntitiesByInitiatorId(initiatorId, pageable)
                .stream().map(entity -> mapper.map(entity, TaskResponse.class))
                .toList();

    }

}
