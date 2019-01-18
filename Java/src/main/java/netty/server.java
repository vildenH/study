package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @author wh
 * @date 2019/1/16
 */
public class server {

  private static final String IP = "127.0.0.1";
  private static final int PORT = 10000;
  private static final int BIZGROUPSIZE = Runtime.getRuntime().availableProcessors() * 2;
  private static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
  private static final EventLoopGroup workerGroup = new NioEventLoopGroup(100);

  public static void main(String[] args) throws InterruptedException {
    ServerBootstrap bootstrap = new ServerBootstrap();
    bootstrap.group(bossGroup, workerGroup);
    bootstrap.channel(NioServerSocketChannel.class);
    bootstrap.childHandler(new ChannelInitializer<Channel>() {

      @Override
      protected void initChannel(Channel ch) throws Exception {
        // TODO Auto-generated method stub
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
        pipeline.addLast(new LengthFieldPrepender(4));
        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast(new TcpServerHandler());
      }

    });
    ChannelFuture f = bootstrap.bind(IP, PORT).sync();
    f.channel().closeFuture().sync();
    System.out.println("TCP服务器已启动");
  }
}

class TcpServerHandler extends ChannelInboundHandlerAdapter {


  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg)
      throws Exception {
    // TODO Auto-generated method stub
    System.out.println("server receive message :" + msg);
    ctx.channel().writeAndFlush("yes server already accept your message" + msg);
    ctx.close();
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    // TODO Auto-generated method stub
    System.out.println("channelActive>>>>>>>>");
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    System.out.println("exception is general");
  }
}