package DesignPatterns.Builder.URLBuilder;


// Used to create URL objects given some params
public class URLMain {
    public static void main(String[] args) {

        URL url = new URL();
        url.setProtocol("https://");
        url.setHostname("mysite");
        url.setPort(":8080");
        url.setPathParam("homepage");
        url.setPathParam("/random");

        System.out.print(url.getProtocol());
        System.out.print(url.getHostname());
        System.out.print(url.getPort());
        System.out.println(url.getPathParam ());

        //-------------------------

        URLBuilder.Builder builder = new URLBuilder.Builder();

        builder.protocol("https://").hostname("mysite").port(":8080");
        URLBuilder urlBuilder = builder.build();

        StringBuilder stringBuilder = new StringBuilder();



        System.out.print(urlBuilder.protocol);
        System.out.print(urlBuilder.hostname);
        System.out.print(urlBuilder.port);
    }

}
