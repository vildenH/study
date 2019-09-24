package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

/**
 * @author wh
 * @date 2019/1/16
 */
public class SimpleClient {

  public static void main(String[] args) {
    Bootstrap b=new Bootstrap();
    EventLoopGroup group = new NioEventLoopGroup();
  }
}
