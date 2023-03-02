package Task;

import EnumTask.RepeatabilityTask;
import EnumTask.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator = 1; // генератор id
    private final String title; // заглавие или имя задачи
    private final Type type; // тип задачи
    private final int id; // порядковый номер задачи
    private final LocalDateTime datetime; // время и дата создания задачи
    private final String descriptions; // descriptions - описание, суть задачи

    private LocalDateTime dateLead;
    private final RepeatabilityTask repeatabilityTask;

    public Task (Type type, String title, String descriptions, RepeatabilityTask repeatabilityTask){
        this.id = idGenerator++;
        this.type = type;
        this.title = title;
        this.descriptions = descriptions;
        this.datetime = LocalDateTime.now();
        this.repeatabilityTask = repeatabilityTask;
    }

    public Task(Type type, String title, String descriptions, LocalDateTime dateLead, RepeatabilityTask repeatabilityTask) {
        this.title = title;
        this.type = type;
        this.id = idGenerator++;
        this.datetime = LocalDateTime.now();
        this.descriptions = descriptions;
        this.dateLead = dateLead;
        this.repeatabilityTask = repeatabilityTask;
    }

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public RepeatabilityTask getRepeatabilityTask() {
        return repeatabilityTask;
    }

    public LocalDateTime getDateLead() {
        return dateLead;
    }

    public abstract boolean appearsIn(LocalDate date);                                                                    // appearsIn


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(datetime, task.datetime) && Objects.equals(descriptions, task.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenerator, title, type, id, datetime, descriptions);
    }

    @Override
    public String toString() {
        return getId() + " - " + getTitle() + ".\n " + getDescriptions() + ".\n "
                + getType() + ".\n Периодичность повторения задачи " + getRepeatabilityTask()
                + ".\n Дата первого выполнения " + getDateLead();
    }
}
