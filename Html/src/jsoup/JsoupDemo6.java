package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * XPath查询
 * @version 2020-6-10
 * @author CJ
 */
public class JsoupDemo6 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = JsoupDemo6.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 根据 document 对象，创建 JXDocument 对象
        JXDocument jxDocument = new JXDocument(document);

        // 结合 xpath 语法查询
        // 查询所有的 student 标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }

        System.out.println("-----------------");

        // 查询所有 student 标签下的 name 标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
            System.out.println(jxNode);
        }

        System.out.println("-----------------");

        // 查询 student 标签下带有 id 属性的 name 标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }

        System.out.println("-----------------");

        // 查询 student 标签下带有 id 属性的 name 标签，并且 id 属性值为 cj
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='cj']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
            jxNode.getElement();
        }
    }
}
