package com.ysu.webapi.dao;

import com.ysu.webapi.pojo.API;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface APIDao {
    //    根据指定的API id查找对应的API
    @Select("select * from api where id=#{id}")
    API selectAPIById(int id);

    //    根据指定的API name查找对应的API
    @Select("select * from api where name like CONCAT('%',#{name},'%')")
    List<API> selectAPIByName(String name);

    //    根据指定的API name查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @Select(" select * from(SELECT * FROM api where  category =(select category from api where name like CONCAT('%',#{name},'%') GROUP BY category ORDER BY count( * ) DESC limit 1))as a INNER JOIN (select id from apiinfo ORDER BY collectionNum DESC) as b on a.id=b.id  limit 0,8;")
    List<API> selectAPIByNameRecommend(String name);
    //    根据指定的API category查找对应的API
    @Select("select * from api where category like CONCAT('%',#{category},'%')")
    List<API> selectAPIByCategory(String category);

    //    根据指定的API category查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @Select(" select * from(SELECT * FROM api where  category =(select category from api where category like CONCAT('%',#{name},'%') GROUP BY category ORDER BY count( * ) DESC limit 1))as a INNER JOIN (select id from apiinfo ORDER BY collectionNum DESC) as b on a.id=b.id  limit 0,8;")
    List<API> selectAPIByCategoryRecommend(String category);

    // 全部模糊匹配
    @Select("select * from api where category like CONCAT('%',#{val},'%') or name like CONCAT('%',#{val},'%')")
    List<API> selectAPIByAll(String val);

    //    根据全部模糊匹配查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @Select(" select * from(SELECT * FROM api where  category =(select category from api where category like CONCAT('%',#{val},'%') or name like CONCAT('%',#{val},'%') GROUP BY category ORDER BY count( * ) DESC limit 1))as a INNER JOIN (select id from apiinfo ORDER BY collectionNum DESC) as b on a.id=b.id  limit 0,8;")
    List<API> selectAPIByAllRecommend(String val);

    //    查找所有api
    @Select("select * from api")
    List<API> selectAllAPI();

    //    根据查找所有api查找出现最多的种类并根据该种类的点击数进行推荐对应的API
    @Select(" select * from(SELECT * FROM api where  category =(select category from api  GROUP BY category ORDER BY count( * ) DESC limit 1))as a INNER JOIN (select id from apiinfo ORDER BY collectionNum DESC) as b on a.id=b.id  limit 0,8;")
    List<API> selectAPIByAllAPIRecommend();

    //     添加api
    @Insert("insert into api (name,descriptionBrief,category) values(#{name},#{descriptionBrief},#{category})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    boolean addAPI(API api);


    //    更新指定id的API
    @Update("update api set name=#{name},descriptionBrief=#{descriptionBrief},category=#{category} where id=#{id}")
    boolean updateAPI(API api);

    //    删除指定id的API
    @Delete("delete from api where id=#{id}")
    boolean deleteAPIById(int id);

}
