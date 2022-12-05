import java.util.*;

public class WordFrequencyGame {
    public String getResult(String inputStr){

        try {

            //split the input string with 1 to n pieces of spaces
            String[] wordArray = inputStr.split("\\s+");

            Map <String, Integer> wordCountMap = new HashMap<>();
            Arrays.stream(wordArray).forEach(word -> wordCountMap.merge(word, 1, Integer::sum));

            StringJoiner joiner = new StringJoiner("\n");

            wordCountMap.entrySet()
                    .stream()
                    .map(wordCountEntry -> new WordCountInfo(wordCountEntry.getKey(), wordCountEntry.getValue()))
                    .sorted((w1, w2) -> w2.getWordCount() - w1.getWordCount())
                    .forEach(wordCountInfo -> joiner.add(wordCountInfo.getWordWithCount()));

            return joiner.toString();
        } catch (Exception e) {
            return "Calculate Error";
        }

    }


}
