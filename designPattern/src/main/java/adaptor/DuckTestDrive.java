package adaptor;

/**
 * @author wh
 * @date 2018/7/13
 */
public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        turkey.gobble();
        turkey.fly();

        testDuck(turkeyAdapter);
        testDuck(duck);

    }

    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
