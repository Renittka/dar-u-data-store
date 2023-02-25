package kz.dar.university.data.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskResponse {

    private String taskId;
    private String initiatorId;
    private String executorId;
    private String description;

}
