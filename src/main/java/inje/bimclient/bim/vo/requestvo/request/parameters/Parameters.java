package inje.bimclient.bim.vo.requestvo.request.parameters;

public class Parameters {
    private String _projectName;
    private String _schema;
    private boolean onlyTopLevel;
    private boolean onlyActive;

    public String get_projectName() {
        return _projectName;
    }

    public void set_projectName(String _projectName) {
        this._projectName = _projectName;
    }

    public String get_schema() {
        return _schema;
    }

    public void set_schema(String _schema) {
        this._schema = _schema;
    }

    public boolean isOnlyTopLevel() {
        return onlyTopLevel;
    }

    public void setOnlyTopLevel(boolean onlyTopLevel) {
        this.onlyTopLevel = onlyTopLevel;
    }

    public boolean isOnlyActive() {
        return onlyActive;
    }

    public void setOnlyActive(boolean onlyActive) {
        this.onlyActive = onlyActive;
    }
}