package Proxy.staticProxy;

/**
 * @author wh
 * @date 2018/7/30
 */
public class ServiceImpl implements Service {
    @Override
    public void doService2() {
        System.out.println("业务代码2 服务代码~~~~~");
    }

    @Override
    public void doService() {
        System.out.println("业务代码 服务代码~~~~~");
    }
}
