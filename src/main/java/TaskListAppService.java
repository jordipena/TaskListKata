import Exceptions.TaskListEmptyException;
import Exceptions.TaskNameIncorrectFormatException;

import java.util.ArrayList;
import java.util.List;

public class TaskListAppService {

     public TaskListAppRepository taskListAppRepository = new TaskListAppRepository();


    public void add(Task task) throws TaskNameIncorrectFormatException {

        if(nameLengthIsCorrect(task) && isAlphanumeric(task)){
            taskListAppRepository.addTask(task);
        }
        else{
            throw new TaskNameIncorrectFormatException("Task name format Incorrect");
        }
    }

    public List<Task> listAll(){

        List<Task> fullList = taskListAppRepository.listAllTasks();

        if(fullList.isEmpty()){
            throw new TaskListEmptyException("There is no tasks in the list");
        }

        return fullList;
    }

    public List<Task> listIncomplete(){

        List<Task> allTasks = taskListAppRepository.listAllTasks();
        List<Task> incompletedTaskList = new ArrayList();

        for (Task task: allTasks) {

            checkStatusOfATAsk(incompletedTaskList, task);
        }
        return incompletedTaskList;

    }

    private void checkStatusOfATAsk(List<Task> incompletedTask, Task task) {
        if(!task.getStatus()){
            incompletedTask.add(task);
        }
    }

    public void markTaskAsComplete(int taskId){

        List<Task> allTasks = taskListAppRepository.listAllTasks();

        for (Task task: allTasks) {
            changeStatus(taskId, task);
        }
    }




    private void changeStatus(int taskId, Task task) {
        if(task.getId() == taskId){
            task.changeStatusToComplete();
        }
    }

    private boolean nameLengthIsCorrect(Task task) {
        return task.nameLength() > 5 && task.nameLength() < 20;
    }

    private boolean isAlphanumeric(Task task){
        return task.getName().matches("^[a-zA-Z0-9 ]*$");
    }
}
