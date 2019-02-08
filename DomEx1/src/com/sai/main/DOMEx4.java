package com.sai.main;

import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author sai
 */
public class DOMEx4 {
    public static void main(String[] args)
            throws Exception {
    DocumentBuilderFactory documentBuilderFactory
            =DocumentBuilderFactory.newInstance();
        
        documentBuilderFactory.setValidating(true);
        
     DocumentBuilder documentBuilder=
       documentBuilderFactory.newDocumentBuilder();
        
      Document document=documentBuilder.parse
        (new File("D:\\XMLBatch-6pm\\DomEx1"
                + "\\src\\xmldocs\\company.xml"));
        
        Scanner scanner=new Scanner(System.in);
    
        System.out.println("Enter element name "
                + "for attributes");
        
        String elementname=scanner.next();
        
        findAttributes(elementname,document);
    }
    
    private static void findAttributes
        (String element,Document document){
    NodeList elementList=
            document.getElementsByTagName(element);
        for(int i=0;i<elementList.getLength();i++){
            Node node=elementList.item(i);
            if(node.getNodeType() == 
                    Node.ELEMENT_NODE){
                if(node.hasAttributes()){
    NamedNodeMap namedNodeMap=node.getAttributes();
    for(int j=0;j<namedNodeMap.getLength();j++){
        Attr attrNode=(Attr)namedNodeMap.item(j);
    System.out.println(attrNode.getName()+","+attrNode.getValue());
                }
    }
   }
        }
        }
}
