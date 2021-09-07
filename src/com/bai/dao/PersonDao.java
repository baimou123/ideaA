package com.bai.dao;

import com.bai.bean.Person;
import com.bai.bean.dto.PersonDTO;

import java.util.List;
import java.util.Map;

public interface PersonDao {
    //全查
    List<Person> selectAll();
    //根据性别查询
    List<Person> selectPersonBySex(int sex);
    //List<Person> selectPersonBySex(int sex,String name);//不支持

    //查询总条数
    long selectCount();
    //查询总条数 + 多个参数 第一种方式2个参数都是个person类中的属性，所以直接可以吧 person当作参数
    //实体类做参数
    long selectCountByParam01(Person person);
    //查 性别和生日, 当查询出的sql语句不确定是唯一的一条的时候，返回值一定要用list
    //当多表 联查的时候，请求的参数一定要为map 或者 是 自己写个实体类。 应用场景， 多表联查的多参数查询
    List<Person> selectCountByParam02(Map map);

    //查询分值最高的人是谁？
    List<Person> selectPersonByZi();

    //男生和女生的平均分值各是多少？ 分组查询
    List<PersonDTO> selectAvgScore();

    //男生和女生的平均分值 大于200的 是什么 有参数
    List<PersonDTO> selectAvgScoreParam(int score);
    //男生和女生的平均分值 大于200的 是什么 有参数 使用map 做返回值
    List<Map> selectAvgScoreParam02(int score);
    //查询 姓 孙的 第一种方式 不建议这么写
    List<Person> selectPersonByLike(String name);
    //查询 姓 孙的 第二种方式
    List<Person> selectPersonByLike02(String name);
    //查询 姓 孙的 第三种方式
    List<Person> selectPersonByLike03(String name);
    //增加的方法
    int insertPerson(Person person);
}
