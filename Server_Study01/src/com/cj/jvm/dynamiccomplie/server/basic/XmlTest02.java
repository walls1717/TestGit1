package com.cj.jvm.dynamiccomplie.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;


/**
 * 熟悉SAX解析流程
 *
 * @author CJ
 */

@SuppressWarnings("all")
public class XmlTest02 {
    public static void main(String[] args) throws Exception {
        //SAX解析
        //1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        //3.编写处理器
        //4.加载Document 注册处理器
        PersonHandler handler = new PersonHandler();
        //5.解析
        parse.parse(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("com/cj/jvm/dynamiccomplie/dynamiccomplie/server/servlet/Web")
                , handler);

        //获取数据
        List<Person> persons = handler.getPersons();
        for(Person p:persons){
            System.out.println(p.getName()+"-->"+p.getAge());
        }
    }
}

@SuppressWarnings("all")
class PersonHandler extends DefaultHandler {
    private List<Person> persons;
    private Person person;
    private String tag; // 存储操作标签

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (null != tag) { // 处理了空的问题
            if (tag.equals("name")) {
                person.setName(contents);
            } else if (tag.equals("age")) {
                if (contents.length() > 0) {
                    person.setAge(Integer.valueOf(contents));
                }
            }
        }
    }

    @Override
    public void startDocument() throws SAXException {
        persons = new ArrayList<Person>();
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "-->解析开始");
        if (null != qName) {
            tag = qName; // 存储标签名
            if (tag.equals("person")) {
                person = new Person();
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "-->解析结束");
        if (null != qName) {
            if (qName.equals("person")) {
                persons.add(person);
            }
        }
        tag = null; //tag丢弃了
    }
}
