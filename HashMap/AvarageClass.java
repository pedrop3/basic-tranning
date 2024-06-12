package HashMap;

import java.text.DecimalFormat;
import java.util.HashMap;

//Crie um HashMap que armazene o nome e a nota de 5 alunos. Em seguida, imprima a nota média da turma, usando um Stream.
public class AvarageClass {

    public static void main(String[] args) {

        HashMap<String, Double> notas = new HashMap<>();

        notas.put("João", 9.4);
        notas.put("Maria", 8.0);
        notas.put("Pedro", 7.0);
        notas.put("Ana", 6.5);
        notas.put("Carlos", 5.5);

        var avarageClass = notas.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .getAsDouble();
 
        DecimalFormat df = new DecimalFormat("0.00");
        String formatAvarageClass = df.format(avarageClass);
        
        System.out.println(formatAvarageClass);
    }

}
