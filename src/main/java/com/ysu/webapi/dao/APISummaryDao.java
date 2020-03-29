package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.APISummary;
import org.apache.ibatis.annotations.*;

@Mapper
public interface APISummaryDao {
    //    根据指定的API版本id查找该版本的详细信息
    @Select("select Endpoint,Portal,PrimaryCategory,SecondaryCategories,APIProvider,SSLSupport,APIForum,TwitterURL,SupportEmailAddress," +
            "InteractiveConsoleURL,AuthenticationModel,VersionStatus,APIDesign,Scope,DeviceSpecific,DocsHomePageURL,ArchitecturalStyle,SupportedRequestFormats,SupportedResponseFormats," +
            "UnofficialAPI,HypermediaAPI,RestrictedAccess from apisummary where APIVersionsId=#{APIVersionsId}")
    APISummary selectAPISummaryDaoByAPIVersionsId(int APIVersionsId);

    //为指定的API和API版本添加该版本的详细信息
    @Insert("insert into apisummary (APIId,APIVersionsId,Endpoint,Portal,PrimaryCategory,SecondaryCategories,APIProvider,SSLSupport,APIForum,TwitterURL,SupportEmailAddress," +
            "InteractiveConsoleURL,AuthenticationModel,VersionStatus,APIDesign,Scope,DeviceSpecific,DocsHomePageURL,ArchitecturalStyle,SupportedRequestFormats,SupportedResponseFormats," +
            "UnofficialAPI,HypermediaAPI,RestrictedAccess) values(#{APIId},#{APIVersionsId},#{Endpoint},#{Portal},#{PrimaryCategory},#{SecondaryCategories},#{APIProvider},#{SSLSupport},#{APIForum},#{TwitterURL},#{SupportEmailAddress}," +
            "#{InteractiveConsoleURL},#{AuthenticationModel},#{VersionStatus},#{APIDesign},#{Scope},#{DeviceSpecific},#{DocsHomePageURL},#{ArchitecturalStyle},#{SupportedRequestFormats},#{SupportedResponseFormats}," +
            "#{UnofficialAPI},#{HypermediaAPI},#{RestrictedAccess})")
    boolean addAPISummary(APISummary apiSummary);

    //通过指定的版本APIVersionsId进行更新
    @Update("update apisummary set Endpoint=#{Endpoint},Portal=#{Portal},PrimaryCategory=#{PrimaryCategory},SecondaryCategories=#{SecondaryCategories},APIProvider=#{APIProvider},SSLSupport=#{SSLSupport},APIForum=#{APIForum},TwitterURL=#{TwitterURL},SupportEmailAddress=#{SupportEmailAddress},InteractiveConsoleURL=#{InteractiveConsoleURL},AuthenticationModel=#{AuthenticationModel},VersionStatus=#{VersionStatus},APIDesign=#{APIDesign},Scope=#{Scope},DeviceSpecific=#{DeviceSpecific},DocsHomePageURL=#{DocsHomePageURL},ArchitecturalStyle=#{ArchitecturalStyle},SupportedRequestFormats=#{SupportedRequestFormats},SupportedResponseFormats=#{SupportedResponseFormats},UnofficialAPI=#{UnofficialAPI},HypermediaAPI=#{HypermediaAPI},RestrictedAccess=#{RestrictedAccess} where APIVersionsId=#{APIVersionsId}")
    boolean updateAPISummaryByAPIVersionsId(APISummary apiSummary);

    //    删除指定id的apisummary
    @Delete("delete from apisummary where id=#{id}")
    boolean deleteAPISummaryById(int id);

    //    删除指定APIId的apisummary
    @Delete("delete from apisummary where APIId=#{APIId}")
    boolean deleteAPISummaryByAPIId(int APIId);

    //    删除指定APIVersionsId的apisummary
    @Delete("delete from apisummary where APIVersionsId=#{APIVersionsId}")
    boolean deleteAPISummaryByAPIVersionsId(int APIVersionsId);

}
