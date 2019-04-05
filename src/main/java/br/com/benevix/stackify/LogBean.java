package br.com.benevix.stackify;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;

@Stateless(name = "LogBean", mappedName = "LogBean")
@Local(LogBeanLocal.class)
@WebService(name = "Service", serviceName = "Log", portName = "LogServicePort")
@BindingType("http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class LogBean implements LogBeanLocal {

    @WebMethod @Override
    public String stackify() {
    	com.stackify.api.common.log.direct.Logger.queueMessage("INFO", "EJB STACKIFY MESSAGE");
        return "test stackify";
    }
    
    @WebMethod @Override
	public String log4j() {
    	org.apache.log4j.Logger.getLogger(getClass()).info("EJB LOG4J MESSAGE");
		return "test log4j";
	}
	
    @WebMethod @Override
	public String logback() {
    	org.slf4j.LoggerFactory.getLogger(getClass()).info("EJB LOGBACK MESSAGE");
		return "test logback";
	}
    
    @WebMethod @Override
	public String java() {
    	java.util.logging.Logger.getLogger(getClass().getCanonicalName()).info("EJB JAVALOGGER MESSAGE");
		return "test logback";
	}
}
