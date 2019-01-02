package FSM;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.squirrelframework.foundation.fsm.StateMachineBuilderFactory;
import org.squirrelframework.foundation.fsm.UntypedStateMachine;
import org.squirrelframework.foundation.fsm.UntypedStateMachineBuilder;
import org.squirrelframework.foundation.fsm.annotation.StateMachineParameters;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

/**
 * @author wh
 * @date 2018/12/29
 */
public class SquirrelSample {

    // 1. Define State Machine Event
    enum FSMEvent {
        ToA, ToB, ToC, ToD,
        /**
         * 用户支付
         */
        USER_PAY
    }

    @AllArgsConstructor
    @Getter
    enum orderState {
        NEW((short) 0, "新建"),
        PAYING((short) 2, "支付中"),
        FAIL((short) 4, "失败"),
        CLOSED((short) 6, "订单已关闭"),
        SUCCESS((short) 8, "成功"),
        CANCELED((short) 12, "撤销"),
        PART_REFUNDED((short) 16, "部分退款"),
        REFUNDED((short) 20, "全部退款"),
        ABNORMAL((short) 24, "订单异常");

        private short code;
        private String name;

    }

    // 2. Define State Machine Class
    @StateMachineParameters(stateType = orderState.class,
            eventType = FSMEvent.class, contextType = Integer.class)
    static class StateMachineSample extends AbstractUntypedStateMachine {
        protected void fromAToB(orderState from, orderState to
                , FSMEvent event, Integer context) {
            System.out.println("Transition from '" + from + "' to '" + to
                    + "' on event '" + event
                    + "' with context '" + context + "'.");
        }


        protected void ontoB(String from, String to
                , FSMEvent event, Integer context) {
            System.out.println("Entry State \'" + to + "\'.");
        }
    }

    public static void main(String[] args) {
        // 3. Build State Transitions
        UntypedStateMachineBuilder builder = StateMachineBuilderFactory
                .create(StateMachineSample.class);
        builder.externalTransition().from(orderState.NEW).to(orderState.SUCCESS)
                .on(FSMEvent.ToB).callMethod("fromAToB");
        builder.onEntry(orderState.CANCELED).callMethod("ontoB");

        // 4. Use State Machine
        UntypedStateMachine fsm = builder.newStateMachine(orderState.NEW);
        fsm.fire(FSMEvent.ToB, 10);
        orderState currentState = (orderState) fsm.getCurrentState();
        System.out.println("Current state is " + currentState.getCode());
        fsm.fire(FSMEvent.ToA,100);


    }
}
