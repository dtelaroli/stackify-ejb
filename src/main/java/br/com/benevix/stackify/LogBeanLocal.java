package br.com.benevix.stackify;

import javax.ejb.Local;

@Local
public interface LogBeanLocal {
	
	String stackify();

	String log4j();

	String logback();

	String java();
	
}
