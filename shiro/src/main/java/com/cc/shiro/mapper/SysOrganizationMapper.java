package com.cc.shiro.mapper;

import com.cc.shiro.pojo.SysOrganization;
import com.cc.shiro.pojo.SysOrganizationExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysOrganizationMapper {
    int countByExample(SysOrganizationExample example);

    int deleteByExample(SysOrganizationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysOrganization record);

    int insertSelective(SysOrganization record);

    List<SysOrganization> selectByExample(SysOrganizationExample example);

    SysOrganization selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysOrganization record, @Param("example") SysOrganizationExample example);

    int updateByExample(@Param("record") SysOrganization record, @Param("example") SysOrganizationExample example);

    int updateByPrimaryKeySelective(SysOrganization record);

    int updateByPrimaryKey(SysOrganization record);
    
    List<SysOrganization> findAllWithExclude(Map<String, String> map);
    
    void  moveSourceSql(Map<String, String> map);
    
    void  moveSourceDescendantsSql(Map<String, String> map);
}