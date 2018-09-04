package Proxy.Dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 *
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("入口打印一些日志");
        Object result = method.invoke(object, args);
        System.out.println("出口打印一些日志");
        return result;
    }
}
