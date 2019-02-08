package com.sai.main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author sai
 */
public class DOMEx2 {
    public static void main(String[] args)
            throws Exception {
        
        DocumentBuilderFactory 
                documentBuilderFactory=
                DocumentBuilderFactory.newInstance();
         
    documentBuilderFactory.setValidating(true);
        
    DocumentBuilder documentBuilder=
       documentBuilderFactory.newDocumentBuilder();
        
    Document parentdoc=documentBuilder.parse
        (new File("D:\\XMLBatch-6pm\\DomEx1"
                + "\\src\\xmldocs\\books.xml"));
    
        displayChildNodes(
        parentdoc.getElementsByTagName
        ("books").item(0));
      }
    
    private static void displayChildNodes
        (Node parentNode){
 NodeList bookList=parentNode.getChildNodes();
        for(int i=0;i<bookList.getLength();i++){
            Node node=bookList.item(i);
 if(node.getNodeType() == Node.ELEMENT_NODE){
    System.out.println("Node name: "
             +node.getNodeName());
    NodeList bookChildNodes=node.getChildNodes();
 for(int j=0;j<bookChildNodes.getLength();j++){
       Node bookChildNode=bookChildNodes.item(j);
  if(bookChildNode.getNodeType() == 
          Node.ELEMENT_NODE){
 System.out.println(bookChildNode.getNodeName());
 Node textNode=bookChildNode.
         getChildNodes().item(0);
  System.out.println("Text Content:"+
          textNode.getTextContent());
                }
            }
            }
        }
    }
}