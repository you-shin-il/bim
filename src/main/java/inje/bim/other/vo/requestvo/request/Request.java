package inje.bim.other.vo.requestvo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import inje.bim.other.vo.requestvo.request.parameters.Parameters;

public class Request {
    @JsonProperty("interface")
    private String _interface;
    @JsonProperty("method")
    private String _method;
    private Parameters parameters;

    public String get_interface() {
        return _interface;
    }

    public void set_interface(String _interface) {
        this._interface = _interface;
    }

    public String get_method() {
        return _method;
    }

    public void set_method(String _method) {
        this._method = _method;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }
}