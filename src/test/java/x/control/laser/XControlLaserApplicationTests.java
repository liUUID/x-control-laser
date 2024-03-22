package x.control.laser;

import org.junit.jupiter.api.Test;
import x.control.laser.domain.Lamp;
import x.control.laser.service.ControLaser;

import java.io.IOException;

class XControlLaserApplicationTests{
    public static  ControLaser controLaser;

   
    @Test
     void contextLoads() throws IOException {
        ControLaser controLaser1 = new ControLaser() {

        };
        Lamp lp = new Lamp();
        lp.setIp("127.0.0.1");
        lp.setPort(12345);
        controLaser1.V16Open(lp , 0 , 7 ,  1 ,  0);
    }


}
