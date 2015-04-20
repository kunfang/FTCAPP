package com.ftc.exception;

import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * This is the common superclass for all application exceptions. This class and
 * its subclasses support the chained exception facility that allows a root
 * cause Throwable to be wrapped by this class or one of its descendants. This
 * class also supports multiple exceptions via the exceptionList field.
 */
public class BaseException extends Exception {

	protected Throwable rootCause = null;
	private List exceptions = new ArrayList();
	private String messageKey = null;
	private Object[] messageArgs = null;

	public BaseException() {
		super();
	}

	public BaseException(Throwable rootCause) {
		this.rootCause = rootCause;
	}

	public List getExceptions() {
		return exceptions;
	}

	public void addException(BaseException ex) {
		exceptions.add(ex);
	}

	public void setMessageKey(String key) {
		this.messageKey = key;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public void setMessageArgs(Object[] args) {
		this.messageArgs = args;
	}

	public Object[] getMessageArgs() {
		return messageArgs;
	}

	public void setRootCause(Throwable anException) {
		rootCause = anException;
	}

	public Throwable getRootCause() {
		return rootCause;
	}

	@Override
	public void printStackTrace() {
		printStackTrace(System.err);
	}

	@Override
	public void printStackTrace(PrintStream outStream) {
		printStackTrace(new PrintWriter(outStream));
	}

	@Override
	public void printStackTrace(PrintWriter writer) {
		super.printStackTrace(writer);

		if (getRootCause() != null) {
			getRootCause().printStackTrace(writer);
		}
		writer.flush();
	}
}