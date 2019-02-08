package com.sai.main;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author sai
 */
public class DOMEx6 {
    
    public static void main(String[] args)throws Exception {
     DocumentBuilderFactory documentBuilderFactory=
                DocumentBuilderFactory.newInstance();
     
     documentBuilderFactory.setValidating(true);
     
     DocumentBuilder documentBuilder=
                documentBuilderFactory.newDocumentBuilder();
    
        Document parent=documentBuilder.parse("D:\\XMLBatch-6pm\\DomEx1\\src\\xmldocs\\books.xml");
        
        Node bookNode=parent.getElementsByTagName("book").item(0);
    
        fetchChildNodes(bookNode,parent);
        
        doTransformation(parent);
    }
    
    private static void fetchChildNodes(Node node,Document document){
        NodeList bookChildNodes=node.getChildNodes();
        for(int i=0;i<bookChildNodes.getLength();i++){
            Node childNode=bookChildNodes.item(i);
            if(childNode.getNodeType() == Node.ELEMENT_NODE && childNode.getNodeName().equalsIgnoreCase("name")){
              NodeList textNodeList=childNode.getChildNodes();
              for(int j=0;j<textNodeList.getLength();j++){
              Node textNode=textNodeList.item(j);
              if(textNode.getNodeType() == Node.TEXT_NODE){
              childNode.replaceChild(document.createTextNode("XML"),textNode);
              break;
              }
              }
              // childNode.appendChild(document.createTextNode("XML"));
                break;
            }
        }
    }
    
    public static void doTransformation(Document document) throws Exception{
        TransformerFactory transformerFactory=TransformerFactory.newInstance();
        
        Transformer transformer=transformerFactory.newTransformer();
        
        DOMSource dOMSource=new DOMSource(document);
        
        StreamResult streamResult=new StreamResult(System.out);
        
        transformer.transform(dOMSource,streamResult);
    }
    
}
