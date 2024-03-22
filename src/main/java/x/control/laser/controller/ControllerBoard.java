package x.control.laser.controller;
import cn.hutool.core.net.NetUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import x.control.laser.commend.ApiController;
import x.control.laser.commend.R;
import x.control.laser.constant.CustomException;
import x.control.laser.entity.Dto.lampDto;
import x.control.laser.utils.UdpTool;

import java.io.CharConversionException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static x.control.laser.annotation.Constant.*;
import static x.control.laser.utils.IPutils.isValidIPv4;

/**
 * 灯光信息
 */
@RestController
@RequestMapping("/controlaser")
public class ControllerBoard extends ApiController {


    @Resource
    private x.control.laser.server.ControllerBoard  service;
    /**
     * 灯光全开全关 --  现有系统中的所有控制板灯
     * @param state   =  状态 true   全部打开
     *                       false  全部关闭
     */
    @GetMapping("/open")
    public R fullyOpenOrFullyClosed(
            @RequestParam(value = "state"    , name = "state"    ,required = true  , defaultValue = "false") boolean state
    ) throws IOException {
        service.openAll(state);
        return success(success);
    }

    /**
     * 灯光全开全关  --  根据具体的数据ID进行控制  这里的ID是某个系统的ID
     * @param state   =  状态 true   全部打开
     *                       false  全部关闭
     */
    @GetMapping("/openById")
    public R fullyOpenOrFullyClosedById(
            @RequestParam(value = "state"    , name = "state"    ,required = true  , defaultValue = "false") boolean state,
            @RequestParam(value = "id"    , name = "id"    ,required = true ) Long id
    ) throws IOException {
        service.openById(state , id);
        return success(success);
    }

    /**
     * 向指定IP指定端口的控制板发送指定指令
     * @param ip ip地址
     * @param port 端口
     * @param message 指令
     */
    @GetMapping("/send/{ip}/{port}/{message}")
    public static void Send(
            @PathVariable("ip") String ip,
            @PathVariable("port") int port,
            @PathVariable("message") String message
    ) throws IOException {
        if (!NetUtil.isValidPort(port)){
            throw new CustomException(String.format("端口参数%s不合法" , port));
        }
        if (!isValidIPv4(ip)){
            throw new CustomException(String.format("IP参数%s不合法" , ip));
        }
        UdpTool.sendUdpData(ip , port , message);
    }


    /**
     *      根据具体参数进行灯光的点亮操作
     */
    @GetMapping("/openOrClose")
    public  void OpenOrClose (@RequestParam lampDto dto){
        service.OpenOrClose(dto);
    }


}
