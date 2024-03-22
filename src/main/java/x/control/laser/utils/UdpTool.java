package x.control.laser.utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import x.control.laser.server.impl.WebSocketServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static x.control.laser.annotation.Constant.ADMIN;

/**
 * x.control.laser.utils
 *
 * @author yuanBin Li
 **/
@Slf4j
@Component
public class UdpTool {

    /**
     * 发送UDP协议
     *
     * @param targetIpAddress 目标Ip地址
     * @param port            端口
     * @param message         控制指令
     */
    public static void sendUdpData(String targetIpAddress, int port, String message) throws IOException {
        String messages = "";
        try {
            // 创建 DatagramSocket 对象
            DatagramSocket socket = new DatagramSocket();
            // 准备要发送的数据
            byte[] buffer = message.getBytes();
            InetAddress address = InetAddress.getByName(targetIpAddress);
            // 创建 DatagramPacket 对象
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            // 发送数据
            socket.send(packet);
            // 关闭 socket
            socket.close();
            messages = String.format("Sueecss！ 目标地址为 【%s : %s】 消息体为 【%s】",targetIpAddress, port , message);
            WebSocketServer.broadcast(messages);
            log.info("UDP数据包已发送成功！ 目标地址为 【{} : {}】 消息体为 【{}】" , targetIpAddress, port , message);
        } catch (Exception e) {
            messages = String.format("Error！ 目标地址为 【%s : %s】 消息体为 【%s】",targetIpAddress, port , message);
            WebSocketServer.broadcast(messages);
            log.warn("UDP数据包已发送失败！ 目标地址为 【{} : {}】 消息体为 【{}】" , targetIpAddress, port , message);
        }
    }
}
