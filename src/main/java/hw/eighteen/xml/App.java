package hw.eighteen.xml;

import lombok.extern.log4j.Log4j;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

@Log4j
public class App
{
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        InputStream xmlInputStream = App.class.getResourceAsStream("Workers.xml");
        SAXParser parser = spf.newSAXParser();
        parser.parse(xmlInputStream, new Handler());
        WorkersContainer.getInstance().forEach(log::debug);
    }
}
