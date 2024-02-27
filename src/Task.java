import java.io.Serializable;
import java.util.Objects;
public class Task implements Serializable {

    private String deadline;
    private String dueDate;
    private String name;
    private int priority;

    public Task(String deadline, String dueDate, String name, int priority) {
        this.deadline = deadline;
        this.dueDate = dueDate;
        this.name = name;
        this.priority = priority;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "deadline='" + deadline + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
