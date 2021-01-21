package pomodoro;

import lombok.Data;

@Data
public class Pomo {
    private String userId;
    private final String taskTitle;
    private final int minute;
}
