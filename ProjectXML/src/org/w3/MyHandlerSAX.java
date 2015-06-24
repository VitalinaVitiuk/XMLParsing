
package org.w3;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandlerSAX extends DefaultHandler {
    List<Postcard> postcards = new ArrayList<>();
    private int flag = 0;
    Postcard postcard = null;

    public List<Postcard> getPostcards() {
        return postcards;
    }

    @Override
    public void startDocument() {
        System.out.println("Document started");
    }

    @Override
    public void endDocument() {
        System.out.println("Document ended");

    }

    @Override
    public void startElement(String uri, String localName, String tegName, Attributes tegAttr) {

        uri = "http://www.w3.org";
        localName = "myspace";

        switch (tegName) {
            case "oldcards":
                break;
            case "postcard": {
                postcard = new Postcard();
                postcard.setId(tegAttr.getValue("id"));
                break;
            }
            case "type": {
                flag = 1;
                break;
            }
            case "theme": {
                flag = 2;
                break;
            }
            case "country": {
                flag = 3;
                break;
            }
            case "year": {
                flag = 4;
                break;
            }
            case "author": {
                flag = 5;
                break;
            }
            case "myspace:worth": {
                Worth worth = new Worth();
                postcard.worth = worth;
                break;
            }
            case "myspace:value": {
                flag = 6;
                break;
            }
            case "myspace:price": {
                flag = 7;
                break;
            }
        }

    }

    @Override
    public void characters(char[] text, int start, int len) {

        String s = new String(text, start, len);
        switch (flag) {
            case 1: {
                postcard.setType(TypeOfCard.valueOf(s));
                break;
            }
            case 2: {
                postcard.setTheme(s);
                break;
            }
            case 3: {
                postcard.setCountry(s);
                break;
            }
            case 4: {
                postcard.year = s;
                break;
            }
            case 5: {
                postcard.author = s;
                break;
            }
            case 6: {
                postcard.worth.value = s;
                break;
            }
            case 7: {
                postcard.worth.price = s;
                break;
            }
        }
        flag = 0;
    }

    @Override
    public void endElement(String uri, String localName, String tegName) {
        uri = "http://www.w3.org";
        localName = "myspace";


        switch (tegName) {
            case "oldcars": {
                break;
            }
            case "postcard": {
                postcards.add(postcard);
                postcard = null;
                break;
            }
        }
    }


}
