package FSM;

/**
 * @author wh
 * @date 2018/12/29
 */
public class main {

    enum State {
        Initial(false),
        Final(true),
        Error(false);

        static public final Integer length = 1 + Error.ordinal();

        final boolean accepting;

        State(boolean accepting) {
            this.accepting = accepting;
        }
    }

    enum Symbol {
        A, B, C;
        static public final Integer length = 1 + C.ordinal();
    }

    State transition[][] = {
            //      A               B               C
            {
                    State.Initial,  State.Final,    State.Error
            }, {
                    State.Final,    State.Initial,  State.Error
    }
    };
}

