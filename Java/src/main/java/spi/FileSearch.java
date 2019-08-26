package spi;

import java.util.List;

/**
 * @author wh
 * @date 2019-08-26
 */
public class FileSearch implements Search {
    @Override
    public List<String> searchList(String keyword) {
        System.out.println("this is fileSearch" + keyword);
        return null;
    }
}
