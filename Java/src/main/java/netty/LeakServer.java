package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;
import java.security.AccessController;
import sun.security.action.GetPropertyAction;

/**
 * @author wh
 * @date 2019/11/10
 */
public class LeakServer {

  public static void main(String[] args) throws Exception {
    String osname = AccessController
        .doPrivileged(new GetPropertyAction("os.name"));
    System.out.println(osname);
    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .handler(new SimpleServerHandler())
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
              ch.pipeline().addLast(new LeakHandler());
            }
          });

      ChannelFuture f = b.bind(8888).sync();
      f.channel().

          closeFuture().

          sync();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }

  private static class LeakHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      //这里不对ByteBuf进行释放处理
      ByteBuf buf = (ByteBuf) msg;
      String x = buf.toString(CharsetUtil.UTF_8);
      System.out.println(x);
      //主动调用gc 加快垃圾收集的启动
      System.gc();
    }
  }

  private static class SimpleServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
      System.out.println("channelActive");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
      System.out.println("channelRegistered");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
      System.out.println("handlerAdded");
    }

  }
}
