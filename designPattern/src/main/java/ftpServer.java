import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wh
 * @date 2019-06-24
 */
public class ftpServer {
    public static void main(String[] args) throws FtpException {
        FtpServerFactory serverFactory = new FtpServerFactory();

        ListenerFactory factory = new ListenerFactory();
        //设置监听端口
        factory.setPort(2121);

        //替换默认监听
        serverFactory.addListener("default", factory.createListener());

        //用户名
        BaseUser user = new BaseUser();
        user.setName("admin");
        //密码 如果不设置密码就是匿名用户
        user.setPassword("123456");
        //用户主目录
        user.setHomeDirectory("/Users/wh/Desktop");

        List<Authority> authorities = new ArrayList<Authority>();
        //增加写权限
        authorities.add(new WritePermission());
        user.setAuthorities(authorities);

        //增加该用户
        serverFactory.getUserManager().save(user);

        /**
         * 也可以使用配置文件来管理用户
         */
//	    PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
//	    userManagerFactory.setFile(new File("users.properties"));
//	    serverFactory.setUserManager(userManagerFactory.createUserManager());

        FtpServer server = serverFactory.createServer();
        server.start();
    }
}
