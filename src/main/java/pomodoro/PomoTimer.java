package pomodoro;

import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;

@Slf4j
public class PomoTimer extends Timer {
    private Timer timer;
    private TaskToDo task;

    public class TaskToDo extends TimerTask {
        long second;

        public TaskToDo(long minute){
            this.second = minute * 60;
        }

        @Override
        public void run(){
           second -= 1;
           log.info("late time: " + second / 60 + " m " + second % 60 + " s");
           if(second == 0) timer.cancel();
        }
    }

    public void setTimer(long minute) {
        timer = new Timer();
        task = new TaskToDo(minute);
        timer.schedule(task, 0, 1000);
    }

    public long pauseTimer(){
        long second = task.second;
        timer.cancel();
        log.info("pause time: " + second / 60 + " m " + second % 60 + " s");

        return second;
    }

}
