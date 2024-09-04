
| **Versão** | **Principais Features** | **Mudanças e Melhorias** | **Status de Suporte** |
|------------|-------------------------|--------------------------|-----------------------|
| **Java 8** (2014) | **Lambda Expressions**: Simplificação da sintaxe para expressões anônimas. <br> **Streams API**: Processamento de coleções de forma funcional e paralelizada. <br> **Default Methods**: Métodos com implementação em interfaces. <br> **Date and Time API**: Nova API para manipulação de data e hora (java.time). | **PermGen Removido**: Substituído pelo Metaspace, que gerencia melhor a memória. <br> **Nashorn JavaScript Engine**: Integração do Java com JavaScript. <br> **Annotations on Java Types**: Anotações em tipos de variáveis, genéricos, etc. | Suporte de Longo Prazo (LTS), ainda amplamente utilizado. |
| **Java 11** (2018) | **var para Variáveis Locais**: Inferência de tipo para variáveis locais. <br> **Novas APIs para Strings**: `String.repeat()`, `String.lines()`, etc. <br> **HttpClient API**: Nova API para HTTP/2 e WebSocket. <br> **Run Single-File Source-Code Programs**: Possibilidade de executar arquivos `.java` diretamente. | **Remoção de Features**: Remoção do JavaFX da JDK, e remoção do Java EE e CORBA. <br> **ZGC (Z Garbage Collector)**: Coletor de lixo experimental de baixa latência. <br> **Deprecações**: Remoção do Nashorn JavaScript Engine e várias APIs obsoletas. | Suporte de Longo Prazo (LTS), adotado em muitas organizações. |
| **Java 17** (2021) | **Pattern Matching for instanceof**: Simplificação do casting com instanceof. <br> **Sealed Classes**: Controle de quais classes podem estender uma classe específica. <br> **Records**: Classe imutável com dados encapsulados e comportamento minimalista. <br> **Text Blocks**: Strings multilinha sem necessidade de concatenação ou escape. | **Foreign Function & Memory API (Incubating)**: Acesso eficiente a APIs nativas. <br> **Deprecações e Remoções**: Remoção de antigos Applets, várias APIs legadas descontinuadas. <br> **Enhanced Pseudo-Random Number Generators**: Melhoria em geradores de números aleatórios. | Suporte de Longo Prazo (LTS), atualmente recomendada para novas implementações. |
| **Java 21** (2023) | **Pattern Matching for switch**: Simplificação de expressões `switch` com padrões. <br> **String Templates**: Interpolação de Strings com placeholders e expressões dinâmicas. <br> **Record Patterns**: Desestruturação de objetos `Record` em padrões `switch`. <br> **Sequenced Collections**: Interface unificada para List, Set, e Map com ordenação. | **Scoped Values**: Alternativa ao ThreadLocal, permitindo variáveis mutáveis por escopo. <br> **Virtual Threads (Preview)**: Threads leves para facilitar a programação assíncrona. <br> **Generational ZGC**: Nova versão do ZGC com suporte a gerações para melhor gerenciamento de memória. | Suporte regular, mas com muitas inovações que podem ser adotadas rapidamente. |

JDK Project - https://openjdk.org/projects/jdk/

Amber Project - https://openjdk.org/projects/amber/


## Java 8 (2014)

### Expressões Lambda

- **Descrição:** Introduzidas para facilitar a programação funcional em Java, permitindo passar funções como argumentos e simplificando o código que manipula coleções ou streams.
- **Exemplo:**

  ```java
  import java.util.Arrays;
  import java.util.List;

  public class LambdaExample {
      public static void main(String[] args) {
          List<String> names = Arrays.asList("John", "Jane", "Max");
          names.forEach(name -> System.out.println(name));
      }
  }
  ```

- **Impacto:** Reduz o boilerplate necessário para iteração sobre coleções, melhorando a legibilidade e expressividade do código.

### Streams API

- **Descrição:** Introduz uma maneira funcional e paralela de processar coleções de dados, permitindo a manipulação de sequências de elementos de forma declarativa.
- **Exemplo:**

  ```java
  import java.util.Arrays;
  import java.util.List;
  import java.util.stream.Collectors;

  public class StreamExample {
      public static void main(String[] args) {
          List<String> names = Arrays.asList("John", "Jane", "Max", "Doe");
          List<String> filteredNames = names.stream()
              .filter(name -> name.startsWith("J"))
              .collect(Collectors.toList());
          System.out.println(filteredNames);
      }
  }
  ```

- **Impacto:** Facilita operações como filtragem, mapeamento e redução de coleções de maneira concisa e paralela, promovendo código eficiente e escalável.

### Métodos Default

- **Descrição:** Permite que métodos com implementação sejam adicionados a interfaces, mantendo a compatibilidade retroativa com código existente.
- **Exemplo:**

  ```java
  interface MyInterface {
      default void greet() {
          System.out.println("Hello, world!");
      }
  }
  ```

- **Impacto:** Facilita a evolução das interfaces, permitindo a adição de novos métodos sem quebrar as implementações existentes.

### API de Data e Hora (java.time)

- **Descrição:** Nova API para manipulação de data e hora que substitui as antigas classes `java.util.Date` e `java.util.Calendar`, oferecendo uma API mais intuitiva, imutável e thread-safe.
- **Exemplo:**

  ```java
  import java.time.LocalDate;
  import java.time.temporal.ChronoUnit;

  public class DateTimeExample {
      public static void main(String[] args) {
          LocalDate date = LocalDate.now();
          LocalDate nextWeek = date.plus(1, ChronoUnit.WEEKS);
          System.out.println("Hoje: " + date);
          System.out.println("Próxima semana: " + nextWeek);
      }
  }
  ```

- **Impacto:** Proporciona uma manipulação de datas e horas mais segura e fácil de usar, eliminando muitos dos problemas das APIs anteriores.

## Java 11 (2018)

### Palavra-chave `var`

- **Descrição:** Introduz a inferência de tipos para variáveis locais, permitindo que o tipo seja deduzido pelo compilador, simplificando a declaração de variáveis.
- **Exemplo:**

  ```java
  public class VarExample {
      public static void main(String[] args) {
          var message = "Hello, Java 11!";
          System.out.println(message);
      }
  }
  ```

- **Impacto:** Reduz a verbosidade em declarações de variáveis, tornando o código mais conciso e legível, especialmente quando o tipo é evidente.

### API HttpClient

- **Descrição:** Nova API para enviar requisições HTTP de forma mais simples e poderosa, com suporte a HTTP/2 e WebSocket.
- **Exemplo:**

  ```java
  import java.net.URI;
  import java.net.http.HttpClient;
  import java.net.http.HttpRequest;
  import java.net.http.HttpResponse;

  public class HttpClientExample {
      public static void main(String[] args) throws Exception {
          HttpClient client = HttpClient.newHttpClient();
          HttpRequest request = HttpRequest.newBuilder()
                  .uri(URI.create("https://api.github.com"))
                  .build();

          HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
          System.out.println(response.body());
      }
  }
  ```

- **Impacto:** Substitui a antiga API `HttpURLConnection`, oferecendo uma abordagem moderna e fácil de usar para trabalhar com HTTP.

### Melhorias em Strings

- **Descrição:** Novas funcionalidades para a classe `String`, como `String.repeat()`, `String.lines()`, `String.isBlank()`, entre outras.
- **Exemplo:**

  ```java
  public class StringEnhancementsExample {
      public static void main(String[] args) {
          String repeated = "Java ".repeat(3);
          System.out.println(repeated); // Output: Java Java Java 

          String multiline = "Hello\nWorld";
          multiline.lines().forEach(System.out::println);
          
          String blank = "   ";
          System.out.println(blank.isBlank()); // Output: true
      }
  }
  ```

- **Impacto:** Simplifica operações comuns com strings, como repetição de caracteres, manipulação de múltiplas linhas e verificação de espaços em branco, melhorando a produtividade e legibilidade do código.

### Execução de Programas de Código Fonte Único

- **Descrição:** Permite executar arquivos `.java` diretamente sem a necessidade de compilação prévia, facilitando a prototipagem e execução rápida de scripts Java.
- **Exemplo:** Basta criar um arquivo `HelloWorld.java` com o seguinte conteúdo:

  ```java
  public class HelloWorld {
      public static void main(String[] args) {
          System.out.println("Hello, World!");
      }
  }
  ```

  E executá-lo diretamente com:

  ```bash
  java HelloWorld.java
  ```

- **Impacto:** Facilita a experimentação e o desenvolvimento rápido de código em Java, eliminando a necessidade de um ciclo completo de compilação.

## Java 17 (2021)

### Records

- **Descrição:** Uma forma concisa de definir classes imutáveis, principalmente para carregar dados (data carriers), reduzindo o boilerplate associado à criação de classes simples.
- **Exemplo:**

  ```java
  public record Person(String name, int age) {}

  public class RecordExample {
      public static void main(String[] args) {
          Person person = new Person("John", 30);
          System.out.println(person.name());
          System.out.println(person.age());
      }
  }
  ```

- **Impacto:** Simplifica a criação de classes de dados, automaticamente gerando métodos como `equals()`, `hashCode()` e `toString()`, além de promover a imutabilidade.

### Classes Seladas

- **Descrição:** Permite que uma classe restrinja quais outras classes podem estender dela, promovendo o encapsulamento e controle de herança.
- **Exemplo:**

  ```java
  public abstract sealed class Shape permits Circle, Square {}

  public final class Circle extends Shape {}
  public final class Square extends Shape {}
  ```

- **Impacto:** Facilita a modelagem de hierarquias de classes onde a extensão deve ser controlada, promovendo um design mais robusto e seguro.

### Pattern Matching para `instanceof`

- **Descrição:** Simplifica a sintaxe para verificação e conversão de tipos ao usar `instanceof`, eliminando a necessidade de casts explícitos.
- **Exemplo:**

  ```java
  public class PatternMatchingExample {
      public static void main(String[] args) {
          Object obj = "Hello, World!";
          if (obj instanceof String s) {
              System.out.println(s.toUpperCase());
          }
      }
  }
  ```

- **Impacto:** Torna o código mais limpo e menos propenso a erros, melhorando a legibilidade ao combinar a verificação de tipo e a conversão em uma única operação.

### Blocos de Texto

- **Descrição:** Introduz strings multilinha que não requerem escape de caracteres especiais, tornando a escrita de texto estruturado (como JSON ou XML) mais fácil e legível.
- **Exemplo:**

  ```java
  public class TextBlockExample {
      public static void main(String[] args) {
          String json = """
          {
              "name": "John",
              "age": 30
          }
          """;
          System.out.println(json);
      }
  }
  ```

- **Impacto:** Simplifica a manipulação de strings multilinha, melhorando a legibilidade e manutenção do código, especialmente ao lidar com formatos estruturados.

## Java 21 (2023)

### Pattern Matching para `switch`

- **Descrição:** Expande a funcionalidade de `switch` com suporte para correspondência de padrões, permitindo que `switch` opere sobre mais tipos e padrões complexos.
- **Exemplo:**

  ```java
  public class PatternMatchingSwitchExample {
      public static void main(String[] args) {
          Object obj = 123;
          String result = switch (obj) {
              case Integer i -> "Integer with value " + i;
              case String s -> "String with value " + s;
              default -> "Unknown type";
          };
          System.out.println(result);
      }
  }
  ```

- **Impacto:** Aumenta a expressividade do `switch`, permitindo lógica mais complexa e poderosa dentro da estrutura, com uma sintaxe limpa e eficiente.

### Templates de Strings

- **Descrição:** Introduz placeholders em strings, que são preenchidos dinamicamente, facilitando a interpolação de strings de maneira segura e legível.
- **Exemplo:**

  ```java
  public class StringTemplatesExample {
      public static void main(String[] args) {
          String name = "John";
          int age = 30;
          String greeting = STR."Hello, {name}. You are {age} years old.";
          System.out.println(greeting);
      }
  }
  ```

- **Impacto:** Melhora a legibilidade e segurança da criação de strings dinâmicas, reduzindo a probabilidade de erros e simplificando o código.

### Record Patterns

- **Descrição:** Permite a desestruturação de objetos `Record` dentro de expressões `switch` ou `if`, facilitando o acesso direto a seus componentes.
- **Exemplo:**

  ```java
  public record Point(int x, int y) {}

  public class RecordPatternExample {
      public static void main(String[] args) {
          Object obj = new Point(10, 20);
          if (obj instanceof Point(int x, int y)) {
              System.out.println("x = " + x + ", y = " + y);
          }
      }
  }
  ```

- **Impacto:** Facilita a manipulação de objetos imutáveis, tornando o código mais conciso e expressivo, especialmente em lógica condicional.

### Virtual Threads

- **Descrição:** Introduz threads leves que permitem executar milhares de threads simultaneamente com menor sobrecarga de recursos, facilitando a programação concorrente.
- **Exemplo:**

  ```java
  public class VirtualThreadsExample {
      public static void main(String[] args) throws InterruptedException {
          Thread.ofVirtual().start(() -> System.out.println("Running in a virtual thread")).join();
      }
  }
  ```

