package hw.eighteen.xml;

import lombok.extern.log4j.Log4j;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@Log4j
public class Handler extends DefaultHandler
{
    private enum CurrentWorkerElem {login, position, additional}
    private CurrentWorkerElem currentWorkerElem;

    private String login;
    private String position;
    private String company;
    private int sinceYear;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        switch (qName)
        {
            case "worker":
                clearCache();
                break;
            case "login":
                currentWorkerElem = CurrentWorkerElem.login;
                break;
            case "position":
                currentWorkerElem = CurrentWorkerElem.position;
                break;
            case "additionalInfo":
                currentWorkerElem = CurrentWorkerElem.additional;
                company = attributes.getValue("company");
                sinceYear = Integer.valueOf(attributes.getValue("sinceYear"));
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equals("worker"))
        {
            WorkersContainer.getInstance().addWorker(login, position, company, sinceYear);
        }
        currentWorkerElem = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        char[] valueArr = new char[length];
        System.arraycopy(ch, start, valueArr, 0, length);
        String value = new String(valueArr);
        if (currentWorkerElem == null)
        {
            return;
        }
        switch (currentWorkerElem)
        {
            case login:
                login = value;
                break;
            case position:
                position = value;
                break;
        }
    }

    private void clearCache()
    {
        login = null;
        position = null;
        company = null;
        sinceYear = -1;
    }
}