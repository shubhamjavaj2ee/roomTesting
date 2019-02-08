package com.sai.main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author sai
 */
public class DOMEx5 {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory documentBuilderFactory=
                DocumentBuilderFactory.newInstance();
        
        DocumentBuilder documentBuilder=
                documentBuilderFactory.newDocumentBuilder();
    
        Document parent=documentBuilder.parse("D:\\XMLBatch-6pm\\DomEx1\\src\\xmldocs\\books.xml");
        
        Node booksNode=parent.getElementsByTagName("books").item(0);
        displayBookDetails(booksNode, parent);
        System.out.println("After adding....");
        addBook(booksNode,parent);
        displayBookDetails(booksNode,parent);
        doTransformation(parent);
       }
    
    private static void doTransformation(Document doc) throws Exception{
        TransformerFactory transformerFactory=TransformerFactory.newInstance();
        DOMSource dOMSource=new DOMSource(doc);
        Transformer transformer=transformerFactory.newTransformer();
         Result result=new StreamResult(System.out);
        //Result result=new StreamResult(new File("D:\\XMLBatch-6pm\\DomEx1\\src\\xmldocs\\mybooks.xml"));
        transformer.transform(dOMSource,result);
    }
    
    private static void addBook(Node booksNode,Document document){
        Element bookElement=document.createElement("book");
        Element nameElement=document.createElement("name");
        Text text=document.createTextNode("Webservices");
        nameElement.appendChild(text);
        bookElement.appendChild(nameElement);
        booksNode.appendChild(bookElement);
       
    }
    
    private static void displayBookDetails(Node node,Document document){
        
        NodeList bookListNodes=node.getChildNodes();
        
        for(int i=0;i<bookListNodes.getLength();i++){
            Node mynode=bookListNodes.item(i);
            if(mynode.getNodeType() == Node.ELEMENT_NODE){
                System.out.println(mynode.getNodeName());
            }
        }
    }
    
}
