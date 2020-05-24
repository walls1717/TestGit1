package com.cj.jvm.dynamiccomplie.server.basic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


/**
 * 熟悉SAX解析流程
 *
 * @author CJ
 */

@SuppressWarnings("all")
public class XmlTest01 {
    public static void main(String[] args) throws Exception {
        //SAX解析
        //1.获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.从解析工厂获取解析器
        SAXParser parse = factory.newSAXParser();
        //3.编写处理器
        //4.加载Document 注册处理器
        PHandler handler = new PHandler();
        //5.解析
        parse.parse(Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("com/cj/jvm/dynamiccomplie/dynamiccomplie/server/servlet/Web")
                , handler);
    }
}

class PHandler extends DefaultHandler {
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String contents = new String(ch, start, length).trim();
        if (contents.length() > 0) {
            System.out.println("内容为" + contents);
        }else{
            System.out.println("内容为->"+"空");
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("---解析文档开始---");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("---解析文档结束---");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName + "-->解析开始");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName + "-->解析结束");
    }
}
