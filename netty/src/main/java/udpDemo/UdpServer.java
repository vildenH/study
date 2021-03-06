package udpDemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author wh
 * @date 2019-08-13
 */
public class UdpServer {

    private static AtomicLong count = new AtomicLong(0);

    public static void main(String[] args) {
        try {
            Bootstrap b = new Bootstrap();
            EventLoopGroup group = new NioEventLoopGroup();
            b.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(4096))
                    .handler(new UdpServerHandler());

            b.bind(2555).sync().channel().closeFuture().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
            try {
                // System.out.println(packet.sender().getPort());
                System.out.println(packet.sender().getHostName());
                ByteBuf buf = packet.copy().content();
                byte[] req = new byte[buf.readableBytes()];
                buf.readBytes(req);
                String body = new String(req, "UTF-8");
                // System.out.println(body);//打印收到的信息
                //向客户端发送消息
                String json = "来自服务端: 南无阿弥陀佛";
                // 由于数据报的数据是以字符数组传的形式存储的，所以传转数据
                // for (int i = 1000; i < 10000; i++) {
                //     String str = String.valueOf(i);
                //     str = str + RandomStringUtils.randomAlphabetic(i - str.length());
                //     byte[] bytes = str.getBytes("UTF-8");
                //     DatagramPacket data = new DatagramPacket(Unpooled.copiedBuffer(bytes), packet.sender());
                //     ctx.writeAndFlush(data);//向客户端发送消息
                // }
                // DatagramPacket data2 = new DatagramPacket(Unpooled.copiedBuffer(json.getBytes("UTF-8")), packet.sender());
                System.out.println(count.getAndIncrement());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
