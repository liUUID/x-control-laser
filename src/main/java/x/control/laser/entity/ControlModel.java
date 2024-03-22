package x.control.laser.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * (ControlModel)表实体类
 *
 * @author makejava
 * @since 2024-03-19 14:50:24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ControlModel extends Model<ControlModel> {

    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 控制板名称
     */
    private String name;

    /**
     * 编号
     */
    private Integer number;

    /**
     * 激光编号
     */
    private Integer control;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 端口
     */
    private Integer port;


    /**
     * 大类的ID
     */
    private Long controlId;

}

