/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ws.mtom.handler;

import com.sun.xml.ws.api.streaming.XMLStreamWriterFactory;
import com.sun.xml.ws.transport.http.client.HttpTransportPipe;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.MTOMFeature;

/**
 *
 * @author Shivraj
 */
public class AttachmentHandler implements SOAPHandler<SOAPMessageContext> {
    
    public boolean handleMessage(SOAPMessageContext messageContext) {
      SOAPMessage msg = messageContext.getMessage();
    
        try {
            System.out.println("properties--->"+msg.getProperty("enable-mtom"));
            msg.setProperty("enable-mtom", true);
              
             // SOAPMessage msg = messageContext.getMessage();
              //SOAPPart soapPart = msg.getSOAPPart();
             
          /*  HttpTransportPipe.dump = true;
            
        Boolean isOutgoing = (Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
              System.out.println("testing ");
        if (isOutgoing) {
          System.out.println("\nOutbound message:");
                 try {
                      messageContext.getMessage().writeTo(System.out);
                  //    System.out.println("Message Context--->"+messageContext.getMessage());
                  } catch (SOAPException ex) {
                      Logger.getLogger(AttachmentHandler.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                      Logger.getLogger(AttachmentHandler.class.getName()).log(Level.SEVERE, null, ex);
                  }
                
            
          
            
       } else {
          System.out.println("\nInbound message:");
        }
        * */
        } catch (SOAPException ex) {
            Logger.getLogger(AttachmentHandler.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("exception occured--->"+ex);
        }

        
        return true;
    }
    
    public Set<QName> getHeaders() {
        return Collections.EMPTY_SET;
    }
    
    public boolean handleFault(SOAPMessageContext messageContext) {
        System.out.println("Handle fault");
        return true;
    }
    
    public void close(MessageContext context) {
    }
}
