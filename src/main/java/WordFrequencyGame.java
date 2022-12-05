import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

public class WordFrequencyGame {
    public String getResult(String inputStr){

        try {
            return Arrays.stream(inputStr.split("\\s+"))
                    .collect(Collectors.groupingBy(Function.identity(), summingInt(x -> 1))) // group by word -> Entry<word, List<word>>
                    .entrySet()
                    .stream()
                    .map(entry -> new WordCountInfo(entry.getKey(), entry.getValue()))
                    .sorted(Comparator.comparing(WordCountInfo::getWordCount, Comparator.reverseOrder()))
                    .map(WordCountInfo::getWordWithCount)
                    .collect(Collectors.joining("\n"));

        } catch (Exception e) {
            return "Calculate Error";
        }

    }


}
