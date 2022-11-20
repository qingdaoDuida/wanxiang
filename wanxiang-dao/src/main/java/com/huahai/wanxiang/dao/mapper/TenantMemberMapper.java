package com.huahai.wanxiang.dao.mapper;

import com.huahai.wanxiang.dao.domain.TenantMemberDO;
import com.huahai.wanxiang.dao.domain.TenantMemberDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author haofuwei
 * @date Wed Jul 06 18:15:00 CST 2022
 */
@Mapper
public interface TenantMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TenantMemberDO record);

    int insertSelective(TenantMemberDO record);

    List<TenantMemberDO> selectByExample(TenantMemberDOExample example);

    TenantMemberDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TenantMemberDO record, @Param("example") TenantMemberDOExample example);

    int updateByExample(@Param("record") TenantMemberDO record, @Param("example") TenantMemberDOExample example);

    int updateByPrimaryKeySelective(TenantMemberDO record);

    int updateByPrimaryKey(TenantMemberDO record);
}