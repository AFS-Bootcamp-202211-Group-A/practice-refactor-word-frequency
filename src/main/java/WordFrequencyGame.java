import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){

        try {
            return Arrays.stream(inputStr.split("\\s+"))
                    .collect(Collectors.groupingBy(s -> s)) // group by word -> Entry<word, List<word>>
                    .entrySet()
                    .stream()
                    .map(entry -> new WordCountInfo(entry.getKey(), entry.getValue().size()))
                    .sorted(Comparator.comparing(WordCountInfo::getWordCount, Comparator.reverseOrder()))
                    .map(WordCountInfo::getWordWithCount)
                    .collect(Collectors.joining("\n"));

        } catch (Exception e) {
            return "Calculate Error";
        }

    }


}
