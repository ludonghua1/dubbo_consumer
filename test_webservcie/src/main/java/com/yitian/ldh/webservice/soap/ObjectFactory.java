
package com.yitian.ldh.webservice.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yitian.ldh.webservice.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindUserByLoginNameResponse_QNAME = new QName("http://soap.webservice.ldh.yitian.com/", "findUserByLoginNameResponse");
    private final static QName _FindUserByLoginName_QNAME = new QName("http://soap.webservice.ldh.yitian.com/", "findUserByLoginName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yitian.ldh.webservice.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindUserByLoginNameResponse }
     * 
     */
    public FindUserByLoginNameResponse createFindUserByLoginNameResponse() {
        return new FindUserByLoginNameResponse();
    }

    /**
     * Create an instance of {@link FindUserByLoginName }
     * 
     */
    public FindUserByLoginName createFindUserByLoginName() {
        return new FindUserByLoginName();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByLoginNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservice.ldh.yitian.com/", name = "findUserByLoginNameResponse")
    public JAXBElement<FindUserByLoginNameResponse> createFindUserByLoginNameResponse(FindUserByLoginNameResponse value) {
        return new JAXBElement<FindUserByLoginNameResponse>(_FindUserByLoginNameResponse_QNAME, FindUserByLoginNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByLoginName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.webservice.ldh.yitian.com/", name = "findUserByLoginName")
    public JAXBElement<FindUserByLoginName> createFindUserByLoginName(FindUserByLoginName value) {
        return new JAXBElement<FindUserByLoginName>(_FindUserByLoginName_QNAME, FindUserByLoginName.class, null, value);
    }

}
