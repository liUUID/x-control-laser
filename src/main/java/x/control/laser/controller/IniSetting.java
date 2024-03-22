package x.control.laser.controller;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import x.control.laser.commend.R;
import x.control.laser.dao.IniconfigDao;
import x.control.laser.entity.Iniconfig;
import java.util.HashMap;
import java.util.Map;
import static x.control.laser.annotation.Constant.*;
/**
 * x.control.laser.controller
 *
 * @author yuanBin Li
 **/
@RestController
@RequestMapping("/ini")
public class IniSetting {
    @Resource
    private IniconfigDao mapper;

    /**
         * 获取现有值
     */
    @GetMapping("/getData")
    public R<Map<String , Object>> getIniData()  {
        Iniconfig ycIniConfig = mapper.selectOne(new QueryWrapper<Iniconfig>().lambda().eq(Iniconfig::getId , 1));
        return R.ok(MapUtil.builder(new HashMap<String , Object>())
                .put(existing_value ,ycIniConfig.getValue() )
                .put(Explain , ycIniConfig.getDescription())
                .build());
    }


    /**
     * 修改相对值
     */
    @GetMapping("/setData")
    public R<Map<String , Object>> setIniData(@RequestParam("bo") boolean bo){
        Iniconfig ycIniConfig = mapper.selectOne(new QueryWrapper<Iniconfig>().lambda().eq(Iniconfig::getId , 1));
        if (ycIniConfig.getValue()) {
            return R.failed("现有数据已经为参数值-->"+bo);
        }
        Iniconfig config =  new Iniconfig();
        config.setValue(bo);
        config.setDescription(bo ? APPEND_OPEN : CLOSE_FIRST_THEN_OPEN);
        mapper.update(config , null);
        return R.ok(MapUtil.builder(new HashMap<String , Object>())
                .put(existing_value ,config.getValue() )
                .put(Explain , config.getDescription())
                .build());
    }
}
