import java.util.Date;

public class Task {

    private int id;
    private String name;
    private String date;
    private Boolean statusComplete;

    public Task(int id, String name, String date, Boolean statusComplete) {

        this.id = id;
        this.name = name;
        this.date = "20/04/2020";
        this.statusComplete = statusComplete;
    }

    public int getId(){
        return id;
    }


    public int nameLength(){
        return  name.length();
    }

    public String getName(){
        return name;
    }

    public boolean getStatus(){
        return statusComplete;
    }

    public void changeStatusToComplete(){

        statusComplete = true;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + date +
                ", StatusComplete=" + statusComplete +
                '}';
    }
}
