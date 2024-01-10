package DesignPatterns;

// Classe que converte XML para JSON
class XMLToJsonConverter {
    public String convertXMLToJson(String xmlData) {
        // Lógica de conversão XML para JSON
        // Vamos assumir uma implementação simples para este exemplo
        String jsonData = "JSON data converted from XML: " + xmlData;
        return jsonData;
    }
}

// Interface que aceita objetos JSON
interface JsonConverter {
    void convertToJson(String jsonData);
}

// Classe que aceita objetos JSON
class JsonConverterImpl implements JsonConverter {
    @Override
    public void convertToJson(String jsonData) {
        System.out.println("Converted JSON data: " + jsonData);
        // Lógica para manipular o objeto JSON
    }
}

// Adaptador para converter XML para JSON e passar para JsonConverter
class XMLToJsonAdapter implements JsonConverter {
    private XMLToJsonConverter xmlToJsonConverter;

    public XMLToJsonAdapter(XMLToJsonConverter xmlToJsonConverter) {
        this.xmlToJsonConverter = xmlToJsonConverter;
    }

    @Override
    public void convertToJson(String xmlData) {
        // Convertendo XML para JSON usando o XMLToJsonConverter
        String jsonData = xmlToJsonConverter.convertXMLToJson(xmlData);
        // Passando o JSON convertido para o JsonConverter
        new JsonConverterImpl().convertToJson(jsonData);
    }
}

// Exemplo de uso
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Criando instâncias das classes
        XMLToJsonConverter xmlToJsonConverter = new XMLToJsonConverter();
        JsonConverter jsonConverter = new JsonConverterImpl();
        JsonConverter xmlAdapter = new XMLToJsonAdapter(xmlToJsonConverter);

        // Convertendo XML para JSON usando JsonConverter
        jsonConverter.convertToJson("Sample JSON Data");

        // Convertendo XML para JSON usando o adaptador
        xmlAdapter.convertToJson("Sample XML Data");
    }
}

