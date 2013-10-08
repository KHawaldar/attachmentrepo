/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.mtom;

import com.sun.xml.ws.developer.StreamingAttachment;
import com.sun.xml.ws.developer.StreamingDataHandler;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;

/**
 *
 * @author Shivraj
 */

@WebService(serviceName = "attachmentservice" )
@StreamingAttachment(parseEagerly=false)
//@MTOM(enabled = true, threshold = 10000)
//@HandlerChain(file=".//xml//resources//attachment_handler.xml")
@MTOM(enabled = true)
//@HandlerChain(file=".//xml//resources//attachment_handler.xml")
//@StreamingAttachment
public class AttachmentWS {
    
    
   public DataHandler getInvoice(String imageName)
   {
   
      String  fileName = "F:\\development\\workspace\\MTOMProvider\\"+imageName;
           
           
    DataSource dataSource=    new FileDataSource (new File(fileName));
 // dataSource = null;
    DataHandler dataHandler = new DataHandler(dataSource);
   return dataHandler;
    // return dataHandler;
    }
  
  public void fileUpload(String fileName,
           @XmlMimeType("application/octet-stream") DataHandler dataHandler)
   {
       
      StreamingDataHandler sdh = (StreamingDataHandler)dataHandler;
     
       
      
       File file = new File("F:\\development\\workspace\\MTOMProvider\\src\\java\\com\\ws\\mtom\\"+fileName);
       try {
           //This will write the content of streaming handler to the file .
           sdh.moveTo(file);
           sdh.close();
       } catch (IOException ex) {
           Logger.getLogger(AttachmentWS.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
}
