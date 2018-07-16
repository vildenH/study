package observer.guava.eventBusDemo;

import com.google.common.eventbus.EventBus;

/**
 * @author wh
 * @date 2018/7/11
 */
public class TestEventBus {
    public static void testReceiveEvent() throws Exception {
        EventBus eventBus = new EventBus("test");
        EventListener listner = new EventListener();
        eventBus.register(listner);
        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent(300));

    }

    public static void main(String[] args) throws Exception {
        testReceiveEvent();
    }
}
