import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //CheckVowel.checkVowel("aeiouertiou");
        List<Integer> colorA = new ArrayList<>();
        colorA.add(0);
        colorA.add(1);
        colorA.add(3);
        List<Integer> colorB = new ArrayList<>();
        colorB.add(1);
        colorB.add(3);
        colorB.add(5);
        List<Integer> colorC = new ArrayList<>();
        colorC.add(2);
        colorC.add(2);
        colorC.add(4);
        List<List<Integer>> colors = new ArrayList<>();
        colors.add(colorA);
        colors.add(colorB);
        colors.add(colorC);
        GetWhiteLength.getWhiteLength(5,3,colors);
    }
}