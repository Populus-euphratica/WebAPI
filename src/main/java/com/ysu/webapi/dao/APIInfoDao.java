package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.APIInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface APIInfoDao {

    //    根据指定的APIInfo id查找对应的APIInfo
    @Select("select * from apiinfo where id=#{id}")
    APIInfo selectAPIInfoById(int id);

    //    根据APIInfo clickNum查找排名靠前APIInfo
    @Select("select * from apiinfo ORDER BY clickNum DESC limit 1,10")
    List<APIInfo> selectAPIInfoByClickNum();

    //    根据APIInfo collectionNum查找排名靠前APIInfo
    @Select("select * from apiinfo ORDER BY collectionNum DESC limit 1,10")
    List<APIInfo> selectAPIInfoByCollectionNum();

    //    查找所有APIInfo
    @Select("select * from apiinfo")
    List<APIInfo> selectAllAPIInfo();
    //     添加APIInfo
    @Insert("insert into apiinfo (id,clickNum,collectionNum) values(#{id},#{clickNum},#{collectionNum})")
    boolean addAPIInfo(APIInfo apiInfo);
    //    更新指定apiId的APIInfo clickNum
    @Update("update apiinfo set clickNum=#{clickNum} where id=#{id}")
    boolean updateAPIInfoClickNum(int clickNum,int id);

    //    更新指定apiId的APIInfo collectionNum
    @Update("update apiinfo set collectionNum=#{collectionNum} where id=#{iId}")
    boolean updateAPIInfoCollectionNum(int collectionNum,int id);
    //    删除指定apiId的APIInfo
    @Delete("delete from apiinfo where id=#{id}")
    boolean deleteAPIInfoById(int id);
}
