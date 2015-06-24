package org.w3;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Postcard> mycards;

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        MyHandlerSAX myHandler = new MyHandlerSAX();
        try {
            parser.parse("oldcards.xml", myHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mycards = myHandler.getPostcards();


        for (Postcard postcard : mycards) {
            System.out.println(postcard.getId());
            System.out.println(postcard.getType());
            System.out.println(postcard.getTheme());
            System.out.println(postcard.getAuthor());
            System.out.println(postcard.getCountry());
            System.out.println(postcard.getYear());
            System.out.println(postcard.worth.value);
            System.out.println(postcard.worth.price);
            System.out.println("====================================");
        }


        System.out.println("========== sorted by country ===========");
        mycards.sort(new PostcardComparator());
        for (Postcard postcard : mycards) {
            System.out.println(postcard);
        }

        try {
            MyHandlerSTAX.parseBySTAX();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MyHandlerDOM.parseByDOM();


        System.out.println("==============VALIDATION ==================");

        try {
            System.out.println(MyValidator.validateXML("oldcards.xsd", "oldcards.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            MyXSLTransformer.transformer();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}



