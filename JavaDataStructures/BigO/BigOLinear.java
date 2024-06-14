package JavaDataStructures.BigO;

public class BigOLinear {
    public static void main(String[] args) {
        printLine(10);
    }
    // O(1)
    private static int printLine(int n) {
        return n+ n;
    }
}
