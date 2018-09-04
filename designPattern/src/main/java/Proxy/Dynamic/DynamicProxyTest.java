package Proxy.Dynamic;

import Proxy.staticProxy.Service;
import Proxy.staticProxy.ServiceImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author wh
 * @date 2018/7/30
 */
public class DynamicProxyTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Service serive = new ServiceImpl();

        //稍微复杂的写法
        Class<?> proxyClass = Proxy.getProxyClass(Service.class.getClassLoader(), Service.class);
        final Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
        final InvocationHandler ih = new DynamicProxyHandler(serive);
        Service proxy0 = (Service) cons.newInstance(ih);
        proxy0.doSerice();

        //简单写法
        Service proxy = (Service) Proxy.newProxyInstance(Service.class.getClassLoader(), new Class[]{Service.class}, new DynamicProxyHandler(serive));
        proxy.doSerice();


    }
}
