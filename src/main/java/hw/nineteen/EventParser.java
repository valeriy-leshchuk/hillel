package hw.nineteen;

import lombok.extern.log4j.Log4j;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class EventParser
{
    private static List<Event> events = new ArrayList<>();

    public static void main(String[] args) throws Exception
    {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        InputStream is = EventParser.class.getResourceAsStream("events.xml");
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(is);

        Element rootElement = doc.getDocumentElement();

        processEvents(rootElement.getChildNodes());
        events.forEach(log::debug);
    }

    private static void processEvents(NodeList events)
    {
        for (int i = 0; i < events.getLength(); i++)
        {
            if (events.item(i).getNodeName().equals("event"))
            {
                processEvent(events.item(i));
            }
        }
    }

    private static void processEvent(Node event)
    {
        NodeList eventNodes = event.getChildNodes();
        String id = "";
        String date = "";
        String priority = "";
        String logLevel = "";
        String source = "";
        for (int i = 0; i < eventNodes.getLength(); i++)
        {
            Node eventChildNode = eventNodes.item(i);

            if (eventChildNode.getNodeName().equals("event_id"))
            {
                id = eventChildNode.getTextContent();
            }
            else if (eventChildNode.getNodeName().equals("event_date"))
            {
                date = eventChildNode.getTextContent();
            }
            else if (eventChildNode.hasChildNodes())
            {
                for (int j = 0; j < eventChildNode.getChildNodes().getLength(); j++)
                {
                    Node nodeOfEventParam = eventChildNode.getChildNodes().item(j);
                    if (nodeOfEventParam.getNodeName().equals("priority"))
                    {
                        priority = nodeOfEventParam.getTextContent();
                    }
                    if (nodeOfEventParam.getNodeName().equals("log_level"))
                    {
                        logLevel = nodeOfEventParam.getTextContent();
                    }
                    if (nodeOfEventParam.getNodeName().equals("source"))
                    {
                        source = nodeOfEventParam.getTextContent();
                    }
                }
            }
        }
        events.add(new Event(id, date, new EventParameter(priority, logLevel, source)));
    }
}
