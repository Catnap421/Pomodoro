package pomodoro;

import java.util.Timer;
import java.util.TimerTask;

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

           if(second == 0) timer.cancel();
        }
    }

    public void setTimer(long minute) {
        timer = new Timer();
        task = new TaskToDo(minute);
        timer.schedule(task, 0, 1000);
    }

    public long pauseTimer(){
        long lateTime = task.second;
        timer.cancel();

        return lateTime;
    }

}
