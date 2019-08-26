package spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author wh
 * @date 2019-08-26
 */
public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()) {
            Search search = iterator.next();
            search.searchList("hello world");
        }
    }
}
