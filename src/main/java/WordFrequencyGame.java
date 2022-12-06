import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    private static final String NEWLINE_CHARACTER = "\n";
    private static final String WHITE_SPACE_REGEX = "\\s+";
    private static final int COUNT = 1;

    public String getResult(String inputStr){
            try {
                return printWordFrequency(inputStr);
            } catch (Exception e) {
                return "Calculate Error";
            }
    }

    private String printWordFrequency(String inputStr) {
        String[] arr = inputStr.split(WHITE_SPACE_REGEX);
        return Arrays.stream(arr)
                .map(word -> new Input(word, COUNT))
                .collect(Collectors.groupingBy(Input::getValue))
                .entrySet()
                .stream()
                .map( word ->  new Input(word.getKey(), word.getValue().size()))
                .sorted((w1, w2) -> w2.getWordCount() - w1.getWordCount())
                .map(word -> word.getValue() + " " + word.getWordCount())
                .collect(Collectors.joining(NEWLINE_CHARACTER));
    }


}
