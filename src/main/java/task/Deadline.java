package task;

import java.time.LocalDateTime;

import core.DateHandler;
/**
 * Deadline is a type of Task.
 * Deadlines have a 'by' field to indicate the period which the task must be completed by.
 * @author EL
 */
public class Deadline extends Task {
    private final LocalDateTime by;

    /**
     * Constructs a Deadline task with the given name, status and timing details.
     *
     * @param name The name of this Deadline.
     * @param status The status of this Deadline.
     * @param by The end date time of this Deadline
     */
    public Deadline(String name, boolean status, LocalDateTime by) {
        super(name, status);
        this.by = by;
    }

    /**
     * Returns the String representation of the Deadline task.
     *
     * @return The name of this task and the timing details.
     */
    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), this.by);
    }

    /**
     * Returns the String representation of an Event task delimited by commas.
     *
     * @return The name of this task and the timing details in CSV format.
     */
    @Override
    public String toCsv() {
        return String.format("D,%s,%s,%s", this.getTaskName(),
                this.getStatus(), DateHandler.unconvert(this.by));
    }
}
