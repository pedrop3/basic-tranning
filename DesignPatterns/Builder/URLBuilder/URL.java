package DesignPatterns.Builder.URLBuilder;

public class URL {

    private String protocol;
    private String hostname;
    private String port;
    private String pathParam;

    // Construtor vazio
    public URL() {
    }

    // Construtor com 'protocol'
    public URL(String protocol) {
        this.protocol = protocol;
    }

    // Construtor com 'protocol' e 'hostname'
    public URL(String protocol, String hostname) {
        this(protocol);  // Chama o construtor anterior
        this.hostname = hostname;
    }

    // Construtor com 'protocol', 'hostname' e 'port'
    public URL(String protocol, String hostname, String port) {
        this(protocol, hostname);  // Chama o construtor anterior
        this.port = port;
    }

    // Construtor com 'protocol', 'hostname', 'port' e 'pathParam'
    public URL(String protocol, String hostname, String port, String pathParam) {
        this(protocol, hostname, port);  // Chama o construtor anterior
        this.pathParam = pathParam;
    }

    // Construtor com 'protocol', 'hostname', 'port', 'pathParam' e 'queryParam'
    public URL(String protocol, String hostname, String port, String pathParam, String queryParam) {
        this(protocol, hostname, port, pathParam);  // Chama o construtor anterior
        this.queryParam = queryParam;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPathParam(String pathParam) {
        this.pathParam = pathParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    private String queryParam;


    public String getProtocol() {
        return protocol;
    }

    public String getHostname() {
        return hostname;
    }

    public String getPort() {
        return port;
    }

    public String getPathParam() {
        return pathParam;
    }

    public String getQueryParam() {
        return queryParam;
    }



}
