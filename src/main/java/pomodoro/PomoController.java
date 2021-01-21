package pomodoro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/pomo")
public class PomoController {
    private Map<String, PomoTimer> pomoTimers = new HashMap<>();

    @PostMapping
    @ResponseBody
    public void startPomo(@RequestBody Pomo pomo){ // 사용자의 pomo 정보를 받아와야 함
        String userId = pomo.getUserId();
        long minute = pomo.getMinute();

        if(pomoTimers.containsKey(userId)) {
            log.info("이미 있는 사용자입니다.");
            return;
        }

        pomoTimers.put(userId, new PomoTimer(userId));
        PomoTimer pomoTimer = pomoTimers.get(userId);
        pomoTimer.setTimer(minute);

        return ;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public long pausePomo(@PathVariable("id") String id){
        PomoTimer pomoTimer = pomoTimers.get(id);
        pomoTimers.remove(id);

        log.info("해당 뽀모의 주인 id : " + pomoTimer.userId);

        return pomoTimer.pauseTimer();
    }
}
