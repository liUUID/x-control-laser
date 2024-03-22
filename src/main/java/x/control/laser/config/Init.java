package x.control.laser.config;
import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import x.control.laser.dao.XControlDao;
import x.control.laser.entity.XControl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * x.control.laser.config
 *
 * @author yuanBin Li
 *
 *   各项初始化
 **/
@Configuration
@Slf4j
public class Init   {
    @Resource
    private XControlDao xControlMapper;
    @PostConstruct
    public void init() {
        Set<Integer> set = new HashSet<>();

                List<XControl> xControls = xControlMapper.selectList(null);
        if (CollUtil.isNotEmpty(xControls)){
            set = xControls.stream()
                    .map(XControl::getLaserPort)
                    .collect(Collectors.toSet());
        }
        // 根据具体参数监听
        log.info("获取到到参数 {}" , set);
    }
}
