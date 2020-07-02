package cn.walls1717.test;

import cn.walls1717.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

/**
 * 测试
 * @version 2020-7-2
 * @author CJ
 */
public class JacksonTest {
    @Test
    public void test1() throws Exception {
        // 创建 person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");

        // 创建jackson的核心对象 ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        // 转换
        /*
         * 转换方法：
         */
        /*String json = mapper.writeValueAsString(p);
        System.out.println(json);*/

       /* // writeValue
        mapper.writeValue(new File("e://a.text"), p);*/

        mapper.writeValue(new FileWriter("e://b.txt"), p);
    }

    @Test
    public void test2() throws Exception {
        // 创建 person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        // 转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);

        System.out.println(json);
    }

    @Test
    public void test3() throws Exception {
        // 创建 person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        // 创建 person对象
        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        // 创建 person对象
        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(23);
        p2.setGender("男");
        p2.setBirthday(new Date());

        // 创建List集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p);
        ps.add(p1);
        ps.add(p2);

        // 转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);

        //
        System.out.println(json);
    }

    @Test
    public void test4() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 23);
        map.put("gender", "男");

        // 转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);

        System.out.println(json);
    }

    /**
     * 演示 json 字符转转化为 java 对象
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {
        // 初始化 json 字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";

        // 创建 objectMapper 对象
        ObjectMapper mapper = new ObjectMapper();
        // 转化为 java 对象， person 对象
        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);
    }
}
