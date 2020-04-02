package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.UploadAPISummary;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UploadAPISummaryDao {
    //    根据指定的API版本id查找该版本的详细信息
    @Select("select Endpoint,Portal,PrimaryCategory,SecondaryCategories,APIProvider,SSLSupport,APIForum,TwitterURL,SupportEmailAddress," +
            "InteractiveConsoleURL,AuthenticationModel,VersionStatus,APIDesign,Scope,DeviceSpecific,DocsHomePageURL,ArchitecturalStyle,SupportedRequestFormats,SupportedResponseFormats," +
            "UnofficialAPI,HypermediaAPI,RestrictedAccess from uploadapisummary where APIVersionsId=#{APIVersionsId}")
    UploadAPISummary selectUploadAPISummaryDaoByAPIVersionsId(int APIVersionsId);

    //为指定的API和API版本添加该版本的详细信息
    @Insert("insert into uploadapisummary (APIId,APIVersionsId,Endpoint,Portal,PrimaryCategory,SecondaryCategories,APIProvider,SSLSupport,APIForum,TwitterURL,SupportEmailAddress," +
            "InteractiveConsoleURL,AuthenticationModel,VersionStatus,APIDesign,Scope,DeviceSpecific,DocsHomePageURL,ArchitecturalStyle,SupportedRequestFormats,SupportedResponseFormats," +
            "UnofficialAPI,HypermediaAPI,RestrictedAccess) values(#{APIId},#{APIVersionsId},#{Endpoint},#{Portal},#{PrimaryCategory},#{SecondaryCategories},#{APIProvider},#{SSLSupport},#{APIForum},#{TwitterURL},#{SupportEmailAddress}," +
            "#{InteractiveConsoleURL},#{AuthenticationModel},#{VersionStatus},#{APIDesign},#{Scope},#{DeviceSpecific},#{DocsHomePageURL},#{ArchitecturalStyle},#{SupportedRequestFormats},#{SupportedResponseFormats}," +
            "#{UnofficialAPI},#{HypermediaAPI},#{RestrictedAccess})")
    boolean addUploadAPISummary(UploadAPISummary uploadAPISummary);

    //通过指定的版本APIVersionsId进行更新
    @Update("update uploadapisummary set Endpoint=#{Endpoint},Portal=#{Portal},PrimaryCategory=#{PrimaryCategory},SecondaryCategories=#{SecondaryCategories},APIProvider=#{APIProvider},SSLSupport=#{SSLSupport},APIForum=#{APIForum},TwitterURL=#{TwitterURL},SupportEmailAddress=#{SupportEmailAddress},InteractiveConsoleURL=#{InteractiveConsoleURL},AuthenticationModel=#{AuthenticationModel},VersionStatus=#{VersionStatus},APIDesign=#{APIDesign},Scope=#{Scope},DeviceSpecific=#{DeviceSpecific},DocsHomePageURL=#{DocsHomePageURL},ArchitecturalStyle=#{ArchitecturalStyle},SupportedRequestFormats=#{SupportedRequestFormats},SupportedResponseFormats=#{SupportedResponseFormats},UnofficialAPI=#{UnofficialAPI},HypermediaAPI=#{HypermediaAPI},RestrictedAccess=#{RestrictedAccess} where APIVersionsId=#{APIVersionsId}")
    boolean updateUploadAPISummaryByAPIVersionsId(UploadAPISummary uploadAPISummary);


    //    删除指定id的uploadapisummary
    @Delete("delete from uploadapisummary where id=#{id}")
    boolean deleteUploadAPISummaryById(int id);

    //    删除指定APIId的uploadapisummary
    @Delete("delete from uploadapisummary where APIId=#{APIId}")
    boolean deleteUploadAPISummaryByAPIId(int APIId);

    //    删除指定APIVersionsId的uploadapisummary
    @Delete("delete from uploadapisummary where APIVersionsId=#{APIVersionsId}")
    boolean deleteUploadAPISummaryByAPIVersionsId(int APIVersionsId);

}
