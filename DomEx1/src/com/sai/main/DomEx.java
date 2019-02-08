package com.sai.main;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 *
 * @author sai
 */
public class DomEx {
    public static void main(String[] args) 
            throws Exception {
      //1. Instantiating DocumentBuilderFactory 
      //class object
  DocumentBuilderFactory documentBuilderFactory=
          DocumentBuilderFactory.newInstance();
        //enabling xml validation
        documentBuilderFactory.setValidating(true);
      //2. Creating DocumentBuilder object
        DocumentBuilder documentBuilder=
       documentBuilderFactory.newDocumentBuilder();
        System.out.println("Dom parser initialized");
        File file=new File("D:\\XMLBatch-6pm"
            + "\\DomEx1\\src\\xmldocs\\company.xml");
        documentBuilder.parse(file);
        System.out.println("Dom created");
        System.out.println("Document validation done");
    }
 }
