package adaptor;

/**
 * @author wh
 * @date 2018/7/13
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("Im flying flying flying Turykey");
    }
}
