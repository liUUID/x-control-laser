package x.control.laser.enums;

/**
 * x.control.laser.enums
 *
 * @author yuanBin Li
 **/
public enum Deal {

    /**
     * 单开
     *  默认是打开新的，关闭其他的  所以不用获取具体的参数值
     */
    SingleOpening,


    /**
     * 组合    需要获取具体的参数值，根据具体的参数值来生成具体的控制板指令
     */
    Combination,

    /**
     * 默认参数为组合指令 ，且为
     */
    DEFAULT
}
