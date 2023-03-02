package Task;

import EnumTask.RepeatabilityTask;
import EnumTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(Type type ,  String title  , String descriptions , RepeatabilityTask repeatabilityTask) {
        super ( type, title, descriptions , repeatabilityTask);
    }

    public WeeklyTask(Type type , String title , String descriptions , LocalDateTime dateLead , RepeatabilityTask repeatabilityTask) {
        super ( type , title , descriptions , dateLead , repeatabilityTask );
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return getDateLead ().toLocalDate ().getDayOfWeek ().equals ( date.getDayOfWeek () );
    }
}
