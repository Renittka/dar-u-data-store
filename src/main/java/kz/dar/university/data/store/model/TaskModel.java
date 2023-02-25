package kz.dar.university.data.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskModel {

    private String taskId;
    private String description;
    private String employeeId;

}
