package disuptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author wh
 * @date 2019-08-19
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("Event: " + event);
    }
}
