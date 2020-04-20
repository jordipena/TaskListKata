import Exceptions.TaskNameIncorrectFormatException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaskListApplicationShould {

    TaskListAppRepository taskListAppRepository;
    TaskListAppService taskListAppService;

    @Before
    public void init_test(){
        taskListAppService = new TaskListAppService();
        taskListAppRepository = new TaskListAppRepository();
    }

    @Test
    public void add_task_into_tasksList(){

        List<Task> expectedTaskList = new ArrayList();
        Task task = new Task(1,"First Task","20/04/2020",false);

        taskListAppService.add(task);
        expectedTaskList.add(task);

        assertEquals(expectedTaskList,taskListAppService.listAll());
    }

    @Test
    public void return_the_list_of_incomplete_tasks(){

        Task taskIncompleted1 = new Task(1,"taskIncompleted1", "20/04/2020",false);
        Task taskIncompleted2 = new Task(1,"taskIncompleted2", "20/04/2020",false);
        Task taskCompleted = new Task(1,"taskCompleted", "20/04/2020",true);

        taskListAppService.add(taskIncompleted1);
        taskListAppService.add(taskIncompleted2);
        taskListAppService.add(taskCompleted);

        assertEquals(2,taskListAppService.listIncomplete().size());
    }

    @Test
    public void return_all_the_tasks_list(){

        Task taskIncompleted1 = new Task(1,"taskIncompleted1", "20/04/2020",false);
        Task taskIncompleted2 = new Task(1,"taskIncompleted2", "20/04/2020",false);
        Task taskCompleted = new Task(1,"taskCompleted", "20/04/2020",true);

        taskListAppService.add(taskIncompleted1);
        taskListAppService.add(taskIncompleted2);
        taskListAppService.add(taskCompleted);

        assertEquals(3,taskListAppService.listAll().size());
    }

    @Test
    public void change_status_of_a_task_to_complete(){

        Task taskIncomplete = new Task(1,"taskIncomplete", "20/04/2020",false);

        taskListAppService.add(taskIncomplete);
        taskListAppService.markTaskAsComplete(taskIncomplete.getId());

        assertEquals(true,taskIncomplete.getStatus());
    }

    @Test
    public void rise_error_when_task_name_format_is_incorrect(){

        Task taskBelow5characters = new Task(1,"xxx","20/04/2020",false);

        assertThrows(TaskNameIncorrectFormatException.class, () ->taskListAppService.add(taskBelow5characters));

    }

}
