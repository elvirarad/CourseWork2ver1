package Task;

import EnumTask.RepeatabilityTask;
import EnumTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(Type type, String title, String descriptions, RepeatabilityTask repeatabilityTask) {
        super ( type, title, descriptions , repeatabilityTask);
    }

    public YearlyTask(Type type,  String title, String descriptions, LocalDateTime dateLead, RepeatabilityTask repeatabilityTask) {
        super (type, title, descriptions , dateLead , repeatabilityTask);
    }

    @Override
    public boolean appearsIn (LocalDate date) {
        return getDateLead ().toLocalDate ().getMonth () == date.getMonth ()
                && getDateLead ().toLocalDate ().getDayOfYear () == date.getDayOfYear ();
    }

}
