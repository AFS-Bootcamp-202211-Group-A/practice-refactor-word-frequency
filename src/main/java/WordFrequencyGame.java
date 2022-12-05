import java.util.*;

public class WordFrequencyGame {
    public String getResult(String inputStr){

        try {

            //split the input string with 1 to n pieces of spaces
            String[] wordArray = inputStr.split("\\s+");

            Map <String, Integer> wordCountMap = new HashMap<>();
            Arrays.stream(wordArray).forEach(word -> wordCountMap.merge(word, 1, Integer::sum));

            List<WordCountInfo> wordCountList = new ArrayList<>();
            wordCountMap.forEach((key, value) -> wordCountList.add(new WordCountInfo(key, value)));

            wordCountList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

            StringJoiner joiner = new StringJoiner("\n");
            wordCountList.forEach(wordCountInfo -> joiner.add(wordCountInfo.getWordWithCount()));

            return joiner.toString();
        } catch (Exception e) {
            return "Calculate Error";
        }

    }


}
