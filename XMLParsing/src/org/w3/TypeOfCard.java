
package org.w3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


@XmlType(name = "TypeOfCard")
@XmlEnum
public enum TypeOfCard {

    GREETING,
    ADVERTISING,
    LEAFLET;

    public String value() {
        return name();
    }

    public static TypeOfCard fromValue(String v) {
        return valueOf(v);
    }

}
