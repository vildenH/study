package dfa;

/**
 * @author wh
 * @date 2019/9/9
 */
public class StateMachine {

  State nowState;

  StateMachine() {
    init();
  }

  public void init() {
    nowState = State.start;
  }

}
