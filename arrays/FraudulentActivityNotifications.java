package arrays;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class FraudulentActivityNotifications {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        // Path path = Paths.get("/home/pedrosantos/workspace/estudos/basic-tranning/arrays/input03.txt");
        // List<String> lines = Files.readAllLines(path);
        // List<Integer> expenditure = lines.stream().map(Integer::parseInt).collect(toList());

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

        int result = activityNotifications(expenditure, d);
        System.out.println(result);

        bufferedReader.close();
    }

    public static int activityNotifications(List<Integer> expenditure, int d) {


        int size = expenditure.size();

    
        int realLoop = size % d;
        int countNotification = 0;

        expenditure.sort(Integer::compareTo);

        for (int i = 0; i < realLoop; i++) {

            var subList = expenditure.subList(i, d + i);

            int median = (expenditure.get(expenditure.size() / 2) + expenditure.get(expenditure.size() / 2 - 1)) / 2;


            Double average = subList.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .getAsDouble();

            int nextValue = expenditure.get(i + d);

            if (nextValue >= (median * 2)) {
                countNotification++;
            }
        }

        return countNotification;
    }


}
