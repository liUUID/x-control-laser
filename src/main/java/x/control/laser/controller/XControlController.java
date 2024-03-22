package x.control.laser.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import x.control.laser.commend.ApiController;
import x.control.laser.commend.R;
import x.control.laser.dao.ControlModelDao;
import x.control.laser.entity.ControlModel;
import x.control.laser.entity.Vo.XControlVo;
import x.control.laser.entity.XControl;
import x.control.laser.service.XControlService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static x.control.laser.annotation.Constant.*;

/**
 * (XControl)表控制层
 *
 * @author makejava
 * @since 2024-03-19 14:50:24
 */
@RestController
@RequestMapping("xControl")
public class XControlController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private XControlService xControlService;
    @Resource
    private ControlModelDao controlMapper;

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping
    public R selectAll() {
        List<XControl> pages = this.xControlService.list();
        for (XControl record : pages) {
            List<ControlModel> controlModels = controlMapper.selectList(new LambdaQueryWrapper<ControlModel>().eq(ControlModel::getControlId, record.getId()));
            record.setCommend(controlModels);
        }
        return success(pages);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable("id") Long id) {
        XControl byId = this.xControlService.getById(id);
        List<ControlModel> controlModels = controlMapper.selectList(new LambdaQueryWrapper<ControlModel>().eq(ControlModel::getControlId, id));
        byId.setCommend(controlModels);
        return success(byId);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/getByid/{id}")
    public R getByid(@PathVariable("id") Long id) {
        return success(controlMapper.selectById(id));
    }
    /**
     * 新增数据
     *
     * @param xControl 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody XControl xControl) {
        boolean save = this.xControlService.save(xControl);
        List<ControlModel> commend = xControl.getCommend();
        commend.forEach(data->{
            data.setControlId(xControl.getId());
            controlMapper.insert(data);
        });
        return success(save);
    }
    /**
     * 新增数据--》子节点
     *
     * @return 新增结果
     */
    @PostMapping("saveControl")
    public R insertSave(@RequestBody ControlModel ControlModel) {
        return success(controlMapper.insert(ControlModel) > 0);
    }
    /**
     * 新增数据--》主节点
     *
     * @return 新增结果
     */
    @PostMapping("saveXcontro")
    public R insertSave(@RequestBody XControl XControl) {
        boolean save = xControlService.save(XControl);
        ControlModel controlModel = new ControlModel();
        controlModel.setControlId(XControl.getId());
        controlModel.setName(built_in);
        controlModel.setIp(IP);
        controlModel.setPort(port);
        controlModel.setNumber(Number);
        controlModel.setControl(Number);
        controlMapper.insert(controlModel);
        return success(save);
    }
    /**
     * 修改数据 大类
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody XControlVo vo) {
        return success(this.xControlService.updateById(BeanUtil.toBean(vo ,XControl.class )));
    }
    /**
     * 修改数据--》 小类别
     *
     * @param xControl 实体对象
     * @return 修改结果
     */
    @PutMapping("/con/")
    public R updateByid(@RequestBody ControlModel xControl) {
        return success(this.controlMapper.updateById(xControl));
    }
    /**
     * 删除数据
     *
     * @param id 主键结合
     * @return 删除结果
     */
    @DeleteMapping("{id}")
    public R delete(@PathVariable("id") Long id) {
        ControlModel controlModel = controlMapper.selectById(id);
        if (controlModel!=null){
            int i = controlMapper.deleteById(id);
        }
        XControl byId = xControlService.getById(id);
        if (byId!=null){
            boolean b = this.xControlService.removeById(id);
        }
        return success(200);
    }

    /**
     * 更具子节点查询具体ID
     */
    @GetMapping("/getByIdFor/{id}")
    public R getByIdFor(@PathVariable("id") Long id) {
        ControlModel controlModel = controlMapper.selectById(id);
        return success(controlModel.getControlId().toString());
    }
    /**
     * 更具子节点查询具体ID
     */
    @GetMapping("/getByIdFores/{id}")
    public R getByIdFores(@PathVariable("id") Long id) {
        ControlModel controlModel = controlMapper.selectById(id);
        if (controlModel!=null){
            return success(controlModel);
        }else {
            return success(null);
        }
    }

    /**
     * 更具子节点查询具体ID
     */
    @GetMapping("/getProjectName")
    public R getByIdFores() {
        List<XControl> list = xControlService.list();
        return success(list);
    }

    /**
     * 更具名称查询具体的参数值
     */
    @GetMapping("/getName/{name}")
    public R getName(@PathVariable("name") String name) {
        List<XControl> list = xControlService.list(new LambdaQueryWrapper<XControl>().eq(XControl::getLaserName , name));
        return success(list);
    }
    /**
     * 获取长度
     */
    @GetMapping("/getdataLeans/{name}")
    public R getdataLeans(@PathVariable("name") Long name) {
        int size = 0;
        List<XControl> list = xControlService.list(new LambdaQueryWrapper<XControl>().eq(XControl::getLaserName, name));
        for (XControl xControl : list) {
            List<ControlModel> controlModels = controlMapper.selectList(new LambdaQueryWrapper<ControlModel>().eq(ControlModel::getControlId, xControl.getId()));
            size = controlModels.size();
        }
        return success(size);
    }


}

