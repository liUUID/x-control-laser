package x.control.laser;

import com.baomidou.mybatisplus.autoconfigure.DdlApplicationRunner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class XControlLaserApplication {

    public static void main(String[] args) {
        SpringApplication.run(XControlLaserApplication.class, args);
        log.info("系统启动成功");
    }

    @Bean
    public DdlApplicationRunner ddlApplicationRunner(@Autowired(required = false) List ddlList) {
        return new DdlApplicationRunner(ddlList);
    }

}
