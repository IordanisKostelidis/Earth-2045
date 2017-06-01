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

    private final String XML;
    private final Document docXML;
    
    public XMLReader(String File) throws Exception {
        
        XML = new TXTReader(File, "Can't find XML !").getReadedFile();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        StringBuilder xmlStringBuilder = new StringBuilder();
        xmlStringBuilder.append(XML);
        ByteArrayInputStream input = new ByteArrayInputStream(
                xmlStringBuilder.toString().getBytes("UTF-8"));
        docXML = builder.parse(input);
    }
    
    public NodeList getElementsByName(String Name) {
        return docXML.getElementsByTagName(Name);
    }

}
