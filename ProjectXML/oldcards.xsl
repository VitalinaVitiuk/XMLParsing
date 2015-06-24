<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:myspace="http://www.w3.org"
                version="3.0">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Old postcards</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>id</th>
                        <th>type</th>
                        <th>theme</th>
                        <th>country</th>
                        <th>year</th>
                        <th>author</th>
                        <th>value</th>
                        <th>price</th>
                    </tr>
                    <xsl:for-each select="/myspace:oldcards/myspace:postcard">
                        <tr>

                            <td>
                                <xsl:value-of select="@id"/>
                            </td>

                            <td><xsl:value-of select="myspace:type"/></td>
                            <td>
                                <xsl:value-of select="myspace:theme"/>
                            </td>
                            <td>
                                <xsl:value-of select="myspace:country"/>
                            </td>
                            <td>
                                <xsl:value-of select="myspace:year"/>
                            </td>
                            <td>
                                <xsl:value-of select="myspace:author"/>
                            </td>
                            <td>
                                <xsl:value-of select="myspace:worth/myspace:value"/>
                            </td>
                            <td>
                                <xsl:value-of select="myspace:worth/myspace:price"/>
                            </td>
                        </tr>



                    </xsl:for-each>

                </table>

            </body>

        </html>
    </xsl:template>
</xsl:stylesheet>