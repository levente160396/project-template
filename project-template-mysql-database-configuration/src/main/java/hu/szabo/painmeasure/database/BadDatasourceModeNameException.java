package hu.szabo.painmeasure.database;

public class BadDatasourceModeNameException extends Exception {

	private static final long serialVersionUID = 7338793402923833344L;

	public BadDatasourceModeNameException(String msg) {
		super(msg);
	}

	public BadDatasourceModeNameException(String msg, Throwable t) {
		super(msg, t);
	}
}
