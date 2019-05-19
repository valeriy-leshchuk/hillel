package classwork.may19.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

class DefaultHandlerExt extends DefaultHandler
{
    boolean isNameStarted=false;

    @Override
    public void startDocument() throws SAXException
    {
        System.out.println("StartDoc");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException
    {
        System.out.println("EndDoc");
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        System.out.println("StartElem" + qName + " " + localName);
        isNameStarted = qName.equals("Name");
        super.startElement(uri, localName, qName, attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        System.out.println("EndElem" + qName + " " + localName);
        super.endElement(uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        //System.out.println("Characters:" + new String(ch));
        //System.out.println("Start is:" + start);
        //System.out.println("Start of characters methos");
        char[] charContent = new char[length];
        System.arraycopy(ch,start,charContent, 0,length);
        //System.out.println("Chars as str '" + new String(charContent) + "'");
        //System.out.println("Length is:" + length);
        if (isNameStarted)
        {
            System.out.println("User name = " + new String(charContent));
        }
        super.characters(ch, start, length);
    }
}

public class SaxParser
{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        InputStream xmlInputStream = SaxParser.class.getResourceAsStream("test.xml");
        SAXParser parser = spf.newSAXParser();
        DefaultHandlerExt handler = new DefaultHandlerExt();
        parser.parse(xmlInputStream,handler);
    }
}
