package Proxy.staticProxy;

/**
 * @author wh
 * @date 2018/7/30
 */
public class ServiceProxy implements Service {

    private Service service;

    public ServiceProxy(Service service) {
        this.service = service;
    }

    @Override
    public void doSerice() {
        System.out.println("入口打印一些日志");
        service.doSerice();
        System.out.println("出口打印一些日志");
    }
}
