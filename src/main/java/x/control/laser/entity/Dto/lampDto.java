package x.control.laser.entity.Dto;

import lombok.Data;

/**
 * x.control.laser.entity.Dto
 *
 * @author yuanBin Li
 **/
@Data
public class lampDto {

    /**
     * 当前数据的ID
     */
    private Long id;

    /**
     * 需要灯光的状态
     */
    private boolean start;
    /**
     * 几路灯
     */
    private int laserQuantity;

    /**
     * 灯光是最追加打开还是覆盖打开
     */
    private boolean setup;

    /**
     * 具体是那个灯
     */
    private int[] lamp;
}
