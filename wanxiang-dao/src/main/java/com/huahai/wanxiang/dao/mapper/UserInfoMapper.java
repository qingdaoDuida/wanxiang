package com.huahai.wanxiang.dao.mapper;

import com.huahai.wanxiang.dao.domain.UserInfoDO;
import com.huahai.wanxiang.dao.domain.UserInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author haofuwei
 * @date Wed Jul 06 18:16:38 CST 2022
 */
@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfoDO record);

    int insertSelective(UserInfoDO record);

    List<UserInfoDO> selectByExample(UserInfoDOExample example);

    UserInfoDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInfoDO record, @Param("example") UserInfoDOExample example);

    int updateByExample(@Param("record") UserInfoDO record, @Param("example") UserInfoDOExample example);

    int updateByPrimaryKeySelective(UserInfoDO record);

    int updateByPrimaryKey(UserInfoDO record);
}