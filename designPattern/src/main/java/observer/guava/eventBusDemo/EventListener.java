package observer.guava.eventBusDemo;

import com.google.common.eventbus.Subscribe;

/**
 * @author wh
 * @date 2018/7/11
 */
public class EventListener {
    public int lastMessage = 0;

    @Subscribe
    public void listen(TestEvent event) {
        lastMessage = event.getMessage();
        System.out.println("Receive Message:" + lastMessage);

    }


    public int getLastMessage() {
        return lastMessage;
    }
}
