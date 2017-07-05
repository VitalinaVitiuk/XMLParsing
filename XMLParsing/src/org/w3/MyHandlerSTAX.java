package org.w3;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.*;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHandlerSTAX {
    public static void parseBySTAX () throws Exception {

        List<Postcard> postcardList = new ArrayList<>();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        Reader fileReader = new FileReader("oldcards.xml");
        XMLEventReader reader = factory.createXMLEventReader(fileReader);
        Postcard postcard = null;


        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                if (startElement.getName().getLocalPart() == "postcard") {
                    postcard = new Postcard();
                    Iterator<Attribute> attributes = startElement
                            .getAttributes();
                    while (attributes.hasNext()) {
                        Attribute attribute = attributes.next();
                        if (attribute.getName().toString().equals("id")) {
                            postcard.id = attribute.getValue();
                        }
                    }
                }

                if (event.asStartElement().getName().getLocalPart()
                        .equals("type")) {
                    event = reader.nextEvent();
                    postcard.type = TypeOfCard.valueOf(event.asCharacters().getData());
                    continue;
                }

                if (event.asStartElement().getName().getLocalPart()
                        .equals("theme")) {
                    event = reader.nextEvent();
                    postcard.theme = event.asCharacters().getData();
                    continue;
                }

                if (event.asStartElement().getName().getLocalPart()
                        .equals("country")) {
                    event = reader.nextEvent();
                    postcard.country = event.asCharacters().getData();
                    continue;
                }

                if (event.asStartElement().getName().getLocalPart()
                        .equals("year")) {
                    event = reader.nextEvent();
                    postcard.year = event.asCharacters().getData();
                    continue;
                }


                if (event.asStartElement().getName().getLocalPart()
                        .equals("author")) {
                    event = reader.nextEvent();
                    postcard.author = event.asCharacters().getData();
                    continue;
                }

                if (event.asStartElement().getName().getLocalPart()
                        .equals("worth")) {
                    Worth worth = new Worth();
                    postcard.worth=worth;
                    continue;
                }

                if (event.asStartElement().getName().getLocalPart()
                        .equals("value")) {
                    event = reader.nextEvent();
                    postcard.worth.value = event.asCharacters().getData();
                    continue;
                }

                if (event.asStartElement().getName().getLocalPart()
                        .equals("price")) {
                    event = reader.nextEvent();
                    postcard.worth.price = event.asCharacters().getData();
                    continue;
                }


            }
                // If we reach the end of an item element, we add it to the list
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart() == ("postcard")) {
                        postcardList.add(postcard);
                    }
                }
        }


        for(Postcard postcard1:postcardList){
            System.out.println(postcard1);
            System.out.println("========================");

        }

        System.out.println("Good job, StAX!");
    }
}

