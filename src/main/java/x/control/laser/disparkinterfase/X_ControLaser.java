package x.control.laser.disparkinterfase;

import java.io.IOException;

/**
 * 开放接口调用
 **/
public interface X_ControLaser {

    /**
     * 全开 / 全关
     * @param ip IP地址
     * @param port TCP端口
     * @param start 需要的状态
     */
    void toggleFully(String ip , int port ,boolean start) throws IOException;



}
