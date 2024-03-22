package x.control.laser.server.impl;

import cn.hutool.core.net.NetUtil;
import x.control.laser.disparkinterfase.X_ControLaser;
import x.control.laser.utils.UdpTool;
import java.io.IOException;
import static x.control.laser.annotation.Constant.A0;
import static x.control.laser.annotation.Constant.A1;
import static x.control.laser.utils.IPutils.isValidIPv4;

public class ControLaserImpl implements X_ControLaser {
    /**
     * 全开 / 全关
     *
     * @param ip    IP地址
     * @param port  TCP端口
     * @param start 需要的状态
     */
    @Override
    public void toggleFully(String ip, int port, boolean start) throws IOException {
        if (!NetUtil.isValidPort(port)){
            throw new RuntimeException(String.format("端口%s错误" , port));
        }
        if (!isValidIPv4(ip)){
            throw new RuntimeException(String.format("IP%s错误" , ip));
        }
        UdpTool.sendUdpData(ip  , port , (start) ? A1 : A0);
    }
}
