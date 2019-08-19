package disuptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author wh
 * @date 2019-08-19
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();

    }
}
