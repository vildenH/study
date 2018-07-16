package adaptor;

/**
 * @author wh
 * @date 2018/7/13
 */
public class TurkeyAdapter implements Duck {
    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    Turkey turkey;
}
