package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class HttpServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new ChannelInboundHandlerAdapter())
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            //http协议解码
                            pipeline.addLast("decoder", new HttpRequestDecoder());
                            //聚合http请求
                            pipeline.addLast("aggre", new HttpObjectAggregator(10 * 1024 * 1024));
                            pipeline.addLast("codec", new HttpServerCodec());
                            pipeline.addLast(new SimpleChannelInboundHandler<FullHttpRequest>() {
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg)
                                        throws Exception {
                                    System.out.println(msg.protocolVersion().text());
                                    System.out.println(msg.headers().toString());
                                    FullHttpResponse response = new DefaultFullHttpResponse(
                                            HttpVersion.HTTP_1_1,
                                            HttpResponseStatus.OK,
                                            Unpooled.copiedBuffer("receive msg", CharsetUtil.UTF_8));
                                    response.headers()
                                            .set(HttpHeaderNames.CONTENT_TYPE, "text/plain;charset=UTF-8");
                                    response.headers()
                                            .set(HttpHeaderNames.CONTENT_LENGTH, "receive msg".getBytes().length);
                                    ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
                                }
                            });
                            pipeline.addLast("encoder", new HttpResponseEncoder());
                        }
                    });

            ChannelFuture f = b.bind(8888).sync();
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
