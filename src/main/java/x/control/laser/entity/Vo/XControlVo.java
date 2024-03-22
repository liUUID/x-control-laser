package x.control.laser.entity.Vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import x.control.laser.entity.ControlModel;

import java.util.List;

/**
 * (XControl)表实体类
 *
 * @author makejava
 * @since 2024-03-19 14:50:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class XControlVo extends Model<XControlVo> {

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 控制板灯光数量
     */
    private int  laserQuantity;

    /**
     * 具体的某个大类的控制板名称
     */
    private String laserName;

    /**
     * 激光控制端口
     */
    private Integer laserPort;

    /**
     * 指令的类型
     */
//    private String laserType = Deal.Combination.toString();
    private String laserType;

    /**
     * 是否需要监听
     */
    private boolean monitoring;


}

