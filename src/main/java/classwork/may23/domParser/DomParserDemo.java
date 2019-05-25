package classwork.may23.domParser;

import lombok.extern.log4j.Log4j;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

@Log4j
public class DomParserDemo
{
    public static void main(String[] args) throws Exception
    {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        InputStream is = DomParserDemo.class.getResourceAsStream("test.xml");
        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(is);

        Element rootElement = doc.getDocumentElement();
        printXmlNodes(rootElement.getChildNodes(), "\t");

    }

    private static void printXmlNodes(NodeList nodeList, String prefix)
    {
        for (int i=0; i< nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            if (node instanceof Element)
            {
                log.debug(prefix + node.getNodeName());
                if ((node.hasAttributes()))
                {
                    NamedNodeMap attributes = node.getAttributes();
                    for (int j = 0; j < attributes.getLength(); j++)
                    {
                        Node attributeNode = attributes.item(j);
                        log.debug("Attribute class " + prefix + attributeNode.getClass().getName());
                    }
                }
            }
            printXmlNodes(node.getChildNodes(), "\t\t");
        }
    }

}
