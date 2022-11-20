package com.huahai.wanxiang.dao.mapper;

import com.huahai.wanxiang.dao.domain.TenantInfoDO;
import com.huahai.wanxiang.dao.domain.TenantInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author haofuwei
 * @date Wed Jul 06 18:16:17 CST 2022
 */
@Mapper
public interface TenantInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TenantInfoDO record);

    int insertSelective(TenantInfoDO record);

    List<TenantInfoDO> selectByExample(TenantInfoDOExample example);

    TenantInfoDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TenantInfoDO record, @Param("example") TenantInfoDOExample example);

    int updateByExample(@Param("record") TenantInfoDO record, @Param("example") TenantInfoDOExample example);

    int updateByPrimaryKeySelective(TenantInfoDO record);

    int updateByPrimaryKey(TenantInfoDO record);
}