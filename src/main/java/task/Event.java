package task;
import java.time.LocalDateTime;
/**
 * Event is a type of Task.
 * Events have a 'from' and 'to' field to indicate the period which the task takes place.
 */

public class Event extends Task {
    private final LocalDateTime from;
    private final LocalDateTime to;

    /**
     * Constructs an Event task with the given name, status and timing details.
     *
     * @param name The name of this Event
     * @param status The status of this Event
     * @param from The start date time of this Event
     * @param to The end date time of this Event
     */
    public Event(String name, Boolean status, LocalDateTime from, LocalDateTime to) {
        super(name, status);
        this.from = from;
        this.to = to;
    }

//    /**
//     * Constructs an Event task with the given name and timing details.
//     * By default, the task created has its status set to false.
//     *
//     * @param name
//     * @param from
//     * @param to
//     */
//    public Event(String name, LocalDateTime from, LocalDateTime to) {
//        this(name, false, from, to);
//    }

    /**
     * Returns the String representation of an Event task.
     *
     * @return The name of this task and the timing details.
     */
    @Override
    public String toString() {
        return String.format("[E]%s (from: %s , to: %s)", super.toString(), this.from, this.to);
    }

    /**
     * Returns the String representation of an Event task delimited by commas.
     *
     * @return The name of this task and the timing details in CSV format.
     */
    @Override
    public String toCSV() {
        return String.format("E,%s,%s,%s,%s", this.name(), this.status, this.from, this.to);
    }

}
