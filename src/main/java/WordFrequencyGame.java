import java.util.*;

public class WordFrequencyGame {
    public String getResult(String inputStr){

        try {

            //split the input string with 1 to n pieces of spaces
            String[] wordArray = inputStr.split("\\s+");

            Map <String, Integer> wordCountMap = new HashMap<>();

            Arrays.stream(wordArray).forEach(word -> wordCountMap.merge(word, 1, Integer::sum));

            List<Input> inputList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()){
                Input input = new Input(entry.getKey(), entry.getValue());
                inputList.add(input);
            }

            inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

            StringJoiner joiner = new StringJoiner("\n");
            for (Input word : inputList) {
                String wordWithCount = word.getWord() + " " +word.getWordCount();
                joiner.add(wordWithCount);
            }
            return joiner.toString();
        } catch (Exception e) {


            return "Calculate Error";
        }

    }


}
