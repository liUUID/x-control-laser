package x.control.laser.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import x.control.laser.dao.XControlDao;
import x.control.laser.entity.XControl;
import x.control.laser.service.XControlService;
import org.springframework.stereotype.Service;

/**
 * (XControl)表服务实现类
 *
 * @author makejava
 * @since 2024-03-19 14:50:24
 */
@Service("xControlService")
public class XControlServiceImpl extends ServiceImpl<XControlDao, XControl> implements XControlService {

}

