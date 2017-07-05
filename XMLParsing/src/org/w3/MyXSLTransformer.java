package org.w3;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class MyXSLTransformer {

    public static void transformer() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new StreamSource("oldcards.xsl"));
        transformer.transform(new StreamSource("oldcards.xml"),new StreamResult("oldcards.html"));
    }


}
