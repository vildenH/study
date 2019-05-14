package Proxy.staticProxy;

/**
 * @author wh
 * @date 2018/7/30
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        //未代理情况
        service.doService();
        service.doService2();

        System.out.println("----------------------------------------------");
        //代理类的情况
        ServiceProxy proxy = new ServiceProxy(service);
        proxy.doService();
        proxy.doService2();
    }
}
