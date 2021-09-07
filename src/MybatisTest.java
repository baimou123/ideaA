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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
