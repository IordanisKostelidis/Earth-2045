/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dmmn_games.earth_2045.global;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 *
 * @author iordkost
 */
public class XMLReader implements Serializable {

    private final String xml;
    private final Document docXML;
    
    public XMLReader(String file) throws Exception {
        
        xml = new TXTReader(file, "Can't find XML !").getReadedFile();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        StringBuilder xmlStringBuilder = new StringBuilder();
        xmlStringBuilder.append(xml);
        ByteArrayInputStream input = new ByteArrayInputStream(
                xmlStringBuilder.toString().getBytes("UTF-8"));
        docXML = builder.parse(input);
    }
    
    public NodeList getElementsByName(String name) {
        return docXML.getElementsByTagName(name);
    }

}
