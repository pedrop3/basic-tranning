package Strings;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * ### Problem: Character Limit in Text Messages
 * You are developing a messaging application where users can share links. However, each message has a maximum limit of 160 characters (like in SMS). When users share long URLs, the link can take up a large portion of the character limit, leaving little room for the actual message.
 * ### Solution:
 * To solve this problem, you decide to implement a feature that automatically shortens long URLs before sending them. This allows users to efficiently share links without worrying about the character limit, ensuring that the main message still fits within the available space.
 * This can be useful, for example, when sharing links to news articles, documents, or any other web content, where the URL may be quite long.
 */

public class ShortURL {

    public static void main(String[] args) {

        String smsRequest = "Hey, check out this amazing article I found on climate change https://www.examplelongurl.com/articles/climate-change-impact-on-the-environment-and-society/2024";

        UrlShortener shortener = new UrlShortener("https://short.ly/");

        smsRequest = shortenURL(smsRequest, shortener);
        sendSMS(smsRequest);
    }

    private static String shortenURL(String smsRequest, UrlShortener shortener) {
        String urlPattern = "(https?://\\S+)";

        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(smsRequest);

        if (matcher.find()) {
            var longUrl = matcher.group(1);
            String shortUrlWithMap = shortener.shortenUrl(longUrl);
            String shortUrlWithHash = shortener.shortenGenerateHash(longUrl);

            smsRequest = smsRequest.replace(longUrl, shortUrlWithHash);
        }

        return smsRequest;
    }

    public static class UrlShortener {
        private HashMap<String, String> urlMap; // Armazena pares de URL original e encurtada
        private String baseUrl; // A URL base para encurtar

        public UrlShortener(String baseUrl) {
            this.urlMap = new HashMap<>();
            this.baseUrl = baseUrl; // Ex: "http://short.ly/"
        }

        private int urlCount = 0; // Contador para gerar identificadores únicos

        public String shortenUrl(String originalUrl) {
            // Verifica se a URL já foi encurtada
            if (urlMap.containsValue(originalUrl)) {
                for (Map.Entry<String, String> entry : urlMap.entrySet()) {
                    if (entry.getValue().equals(originalUrl)) {
                        return entry.getKey(); // Retorna a URL encurtada existente
                    }
                }
            }

            // Cria um novo identificador encurtado
            String shortUrl = baseUrl + Integer.toString(urlCount++, 36);  // Converte o contador para base 36
            urlMap.put(shortUrl, originalUrl); // Armazena o par de URLs

            return shortUrl; // Retorna a URL encurtada
        }

        public String shortenGenerateHash(String originalUrl) {
            // Gera um hash para a URL original
            String hash = generateHash(originalUrl);

            // Cria a URL encurtada
            String shortUrl = baseUrl + hash;

            // Armazena o par de URLs
            urlMap.put(shortUrl, originalUrl);

            return shortUrl; // Retorna a URL encurtada
        }

        // Método para gerar hash SHA-256 da URL original
        private String generateHash(String originalUrl) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                byte[] hashBytes = digest.digest(originalUrl.getBytes());

                // Converte os bytes do hash para uma string hexadecimal
                StringBuilder hexString = new StringBuilder();
                for (byte b : hashBytes) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                return hexString.substring(0, 10);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void sendSMS(String sms) {
        if (sms.length() >= 160) {
            throw new RuntimeException("SMS to long");
        }
        System.out.println(sms);
    }


}
