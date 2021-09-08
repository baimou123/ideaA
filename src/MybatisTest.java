import com.bai.bean.Person;
import com.bai.bean.dto.PersonDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MybatisTest {
    private SqlSession sqlSession;  //讲一下 mybatis的执行流程？？？
    @Before //在@Test注解之前，执行的方法。提取重复的代码的。
    public void before() throws Exception {
        //加载并读取xml
        String path="SqlMapConfig.xml";
        //import org.apache.ibatis.io.Resources;
        InputStream is= Resources.getResourceAsStream(path);
        //sql 链接的 工厂类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession();
        System.out.println("sqlSession = " + sqlSession);
        //sqlSession = org.apache.ibatis.session.defaults.DefaultSqlSession@6fc6f14e
        //sqlSession.close();
    }
    //全查
    @Test
    public void test01() throws Exception {
        List<Person> personList = sqlSession.selectList("com.bai.dao.PersonDao.selectAll");
        for (Person person : personList) {
            System.out.println("person = " + person);
        }
        sqlSession.close();
    }

    @Test
    public void test02(){
        List<Person> personList = sqlSession.selectList("com.bai.dao.PersonDao.selectPersonBySex", 2);
        for (Person person : personList) {
            System.out.println("person = " + person);
        }
        sqlSession.close();
    }

    //查总条数，这个主要学习的是 返回的数据类型，和上面的数据类型不一样
    @Test
    public void test03(){
        long o = sqlSession.selectOne("com.bai.dao.PersonDao.selectCount");
        System.out.println("o = " + o);
        sqlSession.close();
    }

    //带参数查询 第一种方式：实体类传参--多见于 单表查询
    @Test
    public void test04(){
        Person person=new Person();
        person.setScore(100);
        person.setGender(2);
        long o = sqlSession.selectOne("com.bai.dao.PersonDao.selectCountByParam01", person);
        System.out.println("o = " + o);
        sqlSession.close();
    }

    //带参数查询 第二种方式：map传参--多见于 多表查询
    @Test
    public void test05() throws ParseException {
        String date="2020-10-14";
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sf.parse(date);
        Map map=new HashMap();
        map.put("gender",2); //key 一定要和 #{gender} 值保持一致
        map.put("birthday",birthday );//key 一定要和 #{birthday} 值保持一致
        List<Person> lists = sqlSession.selectList("com.bai.dao.PersonDao.selectCountByParam02", map);
        for (Person list : lists) {
            System.out.println("list = " + list);
        }
        sqlSession.close();
    }

    //查询分值最高的人
    //子查询
    @Test
    public void test06(){
        List<Person> person = sqlSession.selectList("com.bai.dao.PersonDao.selectPersonByZi");
        for (Person person1 : person) {
            System.out.println("person1 = " + person1);
        }
        sqlSession.close();
    }

    //分组查询
    @Test
    public void test07(){
        List<PersonDTO> personDTOS = sqlSession.selectList("com.bai.dao.PersonDao.selectAvgScore");
        for (PersonDTO personDTO : personDTOS) {
            System.out.println("personDTO = " + personDTO);
        }
        sqlSession.close();
    }

    //分组查询 + 参数
    @Test
    public void test08(){
        List<PersonDTO> personDTOS = sqlSession.selectList("com.bai.dao.PersonDao.selectAvgScoreParam",200);
        for (PersonDTO personDTO : personDTOS) {
            System.out.println("personDTO = " + personDTO);
        }
        sqlSession.close();
    }
    //分组查询 + map接收
    @Test
    public void test09(){
        List<Map> maps = sqlSession.selectList("com.bai.dao.PersonDao.selectAvgScoreParam02", 200);
        for (Map map : maps) {
            System.out.println("map = " + map);
        }
        sqlSession.close();
    }

    //查询 姓 孙的 所以 你不要用 拼接的
    @Test
    public void test10(){
        Map map=new HashMap();
        map.put("name","孙");
        List<Person> personList = sqlSession.selectList("com.bai.dao.PersonDao.selectPersonByLike", map);
        //There is no getter for property named 'name',因为 $是凭借的，没有getter这个概念,
        //List<Person> personList = sqlSession.selectList("com.bai.dao.PersonDao.selectPersonByLike", "孙");
        for (Person person : personList) {
            System.out.println("person = " + person);
        }
        sqlSession.close();
    }
    //查询 姓 孙的 可以使用这个
    @Test
    public void test11(){
        List<Person> personList = sqlSession.selectList("com.bai.dao.PersonDao.selectPersonByLike02", "孙");
        for (Person person : personList) {
            System.out.println("person = " + person);
        }
        sqlSession.close();
    }
    //查询 姓 孙的 可以使用这个
    @Test
    public void test12(){
        List<Person> personList = sqlSession.selectList("com.bai.dao.PersonDao.selectPersonByLike03", "孙");
        for (Person person : personList) {
            System.out.println("person = " + person);
        }
        sqlSession.close();
    }
    //以上就是单表的 所有查询！！！ 看好这些例子，以后 模仿去公司写
    //玩 增加 insert into ......
    @Test
    public void test13(){
        Person person = new Person();
        person.setName("超阳的对象");
        person.setGender(1);
        person.setBirthday(new Date());
        person.setAddress("加拿大");
        person.setScore(6666);
        int insert = sqlSession.insert("com.bai.dao.PersonDao.insertPerson", person);
        System.out.println("insert = " + insert);
        sqlSession.commit();
        sqlSession.close();
    }
    //删除
    @Test
    public void test14(){
        int i = sqlSession.delete("com.bai.dao.PersonDao.deletePersonById", 16);
        System.out.println("i = " + i);
        sqlSession.commit();
        sqlSession.close();
    }

    //动态sql:重点，难点，也是高薪的起点。
    //动态sql其实就是 让达到1条xml中的语句可以实现 N多种查询。
    //那么 要实现多种查询，就有硬性的条件！你的参数要多，参数要多》》1.放弃单个属性（int，String），改用实体类 2.参数改用map
    //今天所学的 推到 昨天所学的。那么就需要 总结昨天所学的。

    //第一类，特征 1） 返回值====》 正常表的结果集，对应的是 person实体类
    //           2）都是select * from person 开头的
    //1.1 select * from person  if如果where后面没参数那么就是全查
    //1.2 select <include refid="birthdayColumn"/> from person where gender = #{gender} if如果where后面参数是gender 那么就是单查gender
    //1.3 select * from person where gender=#{gender} and birthday<#{birthday}
    //1.4 select * from person where name like "%"#{name}"%"
    //1-4 可以 合N为1 ，只需要把where后面的参数做个 if判断

    //第二类：特征1） 返回值===》是一个数，单行单列 非person实体类，是一个数据类型
    //          2）都是select count(*) from person 开头的
    //2.1 select count(*) from person
    //2.2 select count(*) from person where sex=2 and score>100

    //综上所述！！ 以上sql 可以进行动态判断 形成一个sql！！ 这就叫做动态sql。

    //动态查询
    @Test
    public void test15(){
        Person person=new Person();
        //null是全查
        //person.setId(16); //select * from person p where p.id=?
        person.setScore(200);
        person.setGender(2);//select * from person p where p.gender=? and p.score>?
        List<Person> personList = sqlSession.selectList("com.bai.dao.PersonDao.dongTaiSelect", person);
        for (Person person1 : personList) {
            System.out.println(person1);
        }
    }
    //动态修改，其实就是有选择性修改多个字段，比如 可以修改女孩子 分数,日期等等。。。
    @Test
    public void test16(){
        Person person=new Person();
        person.setId(16);
        person.setAddress("英国");
        person.setBirthday(new Date());
        int i = sqlSession.update("com.bai.dao.PersonDao.dongTaiUpdate", person);
        System.out.println("i = " + i);
        sqlSession.commit();
        sqlSession.close();
    }

    //批量删除
    //构造1个ids
    @Test
    public void test17(){
        List<Integer> idList=new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        idList.add(4);
        Map map=new HashMap();
        map.put("ids",idList);
        int delete = sqlSession.delete("com.bai.dao.PersonDao.piLiangDel", map);
        System.out.println("delete = " + delete);
        sqlSession.commit();
        sqlSession.close();
    }
    //以上代码 不用手写，因为谁写谁垃圾。
    //xml 不需要你写！！！ DAO不需要你写
    //但是需要你能看得懂。
}
