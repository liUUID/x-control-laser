package x.control.laser.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import x.control.laser.entity.Iniconfig;

/**
 * (Iniconfig)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-19 16:20:18
 */
@Mapper
public interface IniconfigDao extends BaseMapper<Iniconfig> {

}

