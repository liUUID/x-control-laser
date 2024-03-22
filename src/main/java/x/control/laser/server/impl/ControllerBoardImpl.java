package x.control.laser.server.impl;
import cn.hutool.core.net.NetUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import x.control.laser.constant.CustomException;
import x.control.laser.dao.ControlModelDao;
import x.control.laser.dao.IniconfigDao;
import x.control.laser.dao.XControlDao;
import x.control.laser.entity.ControlModel;
import x.control.laser.entity.Dto.lampDto;
import x.control.laser.entity.XControl;
import x.control.laser.server.ControllerBoard;
import x.control.laser.utils.UdpTool;

import java.io.IOException;
import java.util.*;
import static x.control.laser.annotation.Constant.A0;
import static x.control.laser.annotation.Constant.A1;

@Component
@Service
public class ControllerBoardImpl implements ControllerBoard {

    @Resource
    private XControlDao xcmapper;
    @Resource
    private ControlModelDao comapper;
    @Override
    public void openAll(boolean state) throws IOException {
        List<XControl> xControls = xcmapper.selectList(null);
        for (XControl xControl : xControls) {
            List<ControlModel> controlModels = comapper.selectList(new LambdaQueryWrapper<ControlModel>().eq(ControlModel::getControlId, xControl.getId()));
            for (ControlModel controlModel : controlModels) {
                UdpTool.sendUdpData(controlModel.getIp() , controlModel.getPort() , (state ? A1 : A0));
            }
        }
    }
    @Override
    public void openById(boolean state , Long id) throws IOException {
        XControl xControls = xcmapper.selectById(id);
        List<ControlModel> controlModels = comapper.selectList(new LambdaQueryWrapper<ControlModel>().eq(ControlModel::getControlId, xControls.getId()));
        for (ControlModel controlModel : controlModels) {
            if (!NetUtil.isValidPort(controlModel.getPort())){
                throw new CustomException("端口不合法");
            }
            UdpTool.sendUdpData(controlModel.getIp() , controlModel.getPort() , (state ? A1 : A0));
        }
    }
    /**
     *      根据具体参数进行灯光的点亮操作
     */
    @Override
    public void OpenOrClose(lampDto dto) {
        //查询本条数据
        ControlModel controlModel = comapper.selectById(dto.getId());

        //初始化控制板
        byte[] commend = new byte[dto.getLaserQuantity()];
        //根据设置填充数据
        if (dto.getLaserQuantity() <= 16){

        }else {

        }
    }

}
