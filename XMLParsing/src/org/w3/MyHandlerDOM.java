package org.w3;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MyHandlerDOM {

    public static void parseByDOM() {

        List<Postcard> postcardList = new ArrayList<>();
        Document document = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            document = builder.parse("oldcards.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Element root = document.getDocumentElement();
        NodeList nList = document.getElementsByTagName("postcard");


        for (int i = 0; i < nList.getLength(); i++) {
            Element postcard = (Element) nList.item(i);
            Postcard exactCard = new Postcard();
            exactCard.id = postcard.getAttribute("id");

            Element type = (Element) postcard.getElementsByTagName("type").item(0);
            exactCard.type = TypeOfCard.valueOf(((Text) type.getFirstChild()).getNodeValue());

            Element theme = (Element) postcard.getElementsByTagName("theme").item(0);
            exactCard.theme = ((Text) theme.getFirstChild()).getNodeValue();

            Element country = (Element) postcard.getElementsByTagName("country").item(0);
            exactCard.country = ((Text) country.getFirstChild()).getNodeValue();

            Element year = (Element) postcard.getElementsByTagName("year").item(0);
            exactCard.year = ((Text) year.getFirstChild()).getNodeValue();

            Element author = (Element) postcard.getElementsByTagName("author").item(0);
            exactCard.author = ((Text) author.getFirstChild()).getNodeValue();

            Element worth = (Element) postcard.getElementsByTagName("myspace:worth").item(0);
            exactCard.worth = new Worth();

            Element value = (Element) worth.getElementsByTagName("myspace:value").item(0);
            exactCard.worth.value = ((Text) value.getFirstChild()).getNodeValue();

            Element price = (Element) worth.getElementsByTagName("myspace:price").item(0);
            exactCard.worth.price = ((Text) price.getFirstChild()).getNodeValue();

            postcardList.add(exactCard);
        }

        for (int j = 0; j < postcardList.size(); j++) {
            System.out.println(postcardList.get(j));
        }


    }
}



