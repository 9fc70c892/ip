package task;
/**
 * ToDo is a type of Task.
 * This is the most primitive version of Task
 * @author EL
 */
public class ToDo extends Task {

    /**
     * Constructs a ToDo task with the given name and status.
     *
     * @param name The name of this Todo task.
     * @param status The status of this task.
     */
    public ToDo(String name, boolean status) {
        super(name, status);
    }

    /**
     * Returns the String representation of the Todo task.
     * @return The string representation of this Todo.
     */
    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }

    /**
     * Returns the String representation of the Todo task delimited by commas.
     *
     * @return The string representation of this Todo task in CSV format.
     */
    @Override
    public String toCsv() {
        return String.format("T,%s,%s", this.getTaskName(), this.getStatus());
    }
}
