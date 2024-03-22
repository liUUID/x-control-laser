package x.control.laser.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 灯控对象 dc_gf_lamp_control
 *
 * @author liyuanbin
 * @date 2023-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("lamp_control")
public class LampControl extends Model<LampControl> {


    /**
     * 主键
     */
    @TableId
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 控制板编号
     */
    private String k;

    /**
     * 编号
     */
    private String code;

    /**
     * 灯控状态   1 开启  0 关闭
     */
    private int state = 1;
}
