package x.control.laser.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class Iniconfig extends Model<Iniconfig> {

    @JsonSerialize(using = ToStringSerializer.class)
    private Integer id;

    private Boolean value;

    private String description;

}

