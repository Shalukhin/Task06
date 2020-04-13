package command.constant;

public enum RequestParameterManager {

	LOGIN("login"), PASSWORD("password"), COMMAND("command"), PARSER("parser"), FILE("file");

	private String parameterName;

	private RequestParameterManager(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getParameterName() {
		return parameterName;
	}
}
