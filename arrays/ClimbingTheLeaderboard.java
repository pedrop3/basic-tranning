package arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * An arcade game player wants to climb to the top of the leaderboard and track
 * their ranking. The game uses Dense Ranking, so its leaderboard works like
 * this:
 * 
 * The player with the highest score is ranked number on the leaderboard.
 * Players who have equal scores receive the same ranking number, and the next
 * player(s) receive the immediately following ranking number.
 * Example
 * 
 * 
 * 
 * The ranked players will have ranks , , , and , respectively. If the player's
 * scores are , and , their rankings after each game are , and . Return .
 * 
 * Function Description
 * 
 * Complete the climbingLeaderboard function in the editor below.
 * 
 * climbingLeaderboard has the following parameter(s):
 * 
 * int ranked[n]: the leaderboard scores
 * int player[m]: the player's scores
 * Returns
 * 
 * int[m]: the player's rank after each new score
 * Input Format
 * 
 * The first line contains an integer , the number of players on the
 * leaderboard.
 * The next line contains space-separated integers , the leaderboard scores in
 * decreasing order.
 * The next line contains an integer, , the number games the player plays.
 * The last line contains space-separated integers , the game scores.
 */
class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY ranked
     * 2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

                Instant before = Instant.now();

        List<Integer> playerRanks = new ArrayList<>();
        Set<Integer> uniqueRankedScores = new TreeSet<>(ranked);

        for (int playerScore : player) {
            uniqueRankedScores.add(playerScore);
            ArrayList<Integer> uniqueRankedScoresList = new ArrayList<>(uniqueRankedScores);
            int rank = uniqueRankedScoresList.size() - uniqueRankedScoresList.indexOf(playerScore);
            playerRanks.add(rank);
        }

        Instant after = Instant.now();
        System.out.println(Duration.between(before, after).toMillis());
        return playerRanks;
    }

    public static List<Integer> climbingLeaderboardOptimized(List<Integer> ranked, List<Integer> player) {
        Instant before = Instant.now();
        
        ranked.stream().distinct();
        TreeSet<Integer> uniqueRanked = new TreeSet<>(ranked);

        // Create a list to store the result
        List<Integer> result = new ArrayList<>();

        // Iterate through each player's score
        for (int i = 0; i < player.size(); i++) {
            int playerScore = player.get(i);

            // Add the player's score to the ranked scores
            uniqueRanked.add(playerScore);

            // Use the lower() method to find the rank efficiently
            result.add(uniqueRanked.size() - uniqueRanked.headSet(playerScore, false).size());
        }

        Instant after = Instant.now();
        System.out.println(Duration.between(before, after).toMillis());
        return result;
    }


    public static List<Integer> climbingLeaderboardStream(List<Integer> ranked, List<Integer> player) {
        Instant before = Instant.now();
        int[] ranksArr = ranked.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int[] playerArr = player.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        List<Integer> result = new ArrayList<>();

        for (Integer score : playerArr) {
            result.add(calculateRank(ranksArr, score));
        }

        Instant after = Instant.now();
        System.out.println(Duration.between(before, after).toMillis());
        return result;
    }

    private static int calculateRank(int[] ranksArr, int n) {
        int left = 0;
        int right = ranksArr.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            int current = ranksArr[mid];
            if (current == n) {
                return mid + 1;
            } else if (current > n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            mid = (left + right) / 2;
        }

        if (ranksArr[mid] < n) {
            return mid + 1;
        }
        return mid + 2;
    }
}

public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        // int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        // int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);
        List<Integer> result2 = Result.climbingLeaderboardOptimized(ranked, player);
        List<Integer> result3 = Result.climbingLeaderboardStream(ranked, player);


        bufferedReader.close();
    }
}