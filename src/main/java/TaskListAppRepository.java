import java.util.ArrayList;
import java.util.List;

public class TaskListAppRepository {

    public List<Task> taskList;

    public TaskListAppRepository() {
        this.taskList = new ArrayList<>();
    }


    public void addTask(Task task){

        taskList.add(task);

    }

    public List<Task> listAllTasks(){

        return taskList;
    }


}
