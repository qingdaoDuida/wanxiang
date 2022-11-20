package com.huahai.wanxiang.dao.mapper;

import com.huahai.wanxiang.dao.domain.ArticleInfoDO;
import com.huahai.wanxiang.dao.domain.ArticleInfoDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author haofuwei
 * @date Wed Jul 06 18:15:58 CST 2022
 */
@Mapper
public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ArticleInfoDO record);

    int insertSelective(ArticleInfoDO record);

    List<ArticleInfoDO> selectByExampleWithBLOBs(ArticleInfoDOExample example);

    List<ArticleInfoDO> selectByExample(ArticleInfoDOExample example);

    ArticleInfoDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleInfoDO record, @Param("example") ArticleInfoDOExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleInfoDO record, @Param("example") ArticleInfoDOExample example);

    int updateByExample(@Param("record") ArticleInfoDO record, @Param("example") ArticleInfoDOExample example);

    int updateByPrimaryKeySelective(ArticleInfoDO record);

    int updateByPrimaryKeyWithBLOBs(ArticleInfoDO record);

    int updateByPrimaryKey(ArticleInfoDO record);
}