package x.control.laser.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import x.control.laser.commend.ApiController;
import x.control.laser.commend.R;
import x.control.laser.server.impl.WebSocketServer;

import java.io.IOException;

/**
 * x.control.laser.controller
 *
 * @author yuanBin Li
 **/
@RestController
public class Index extends ApiController {

    @Value("${spring.application.version}")
    private String version;


    @GetMapping(path = {"/" , "index"})
    public  R index(){
        return success(String.format("欢迎使用灯光控制模块-当前系统版本%s"  ,version));
    }

    /**
     * webSocket 向指定用户发送指定消息
     * @param message 消息体
     * @param uid 用户ID
     */
    @GetMapping("/websocket/{message}/{uid}")
    public void SendMessage(
            @PathVariable("message")String message,
            @PathVariable("uid")String uid
                            ) throws IOException {
        WebSocketServer.sendInfo(message , uid);

    }
}
