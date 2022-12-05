import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.*;

public class WordFrequencyGame {

    public static final String SPACE_SPLITER = "\\s+";

    public String getResult(String inputStr){

        if (inputStr.split(SPACE_SPLITER).length==1) {
            return inputStr + " 1";
        } else {

            try {
                List<Input> inputList = splitInputString(inputStr);
                return getMapForSizingSameWord(inputList);

            } catch (Exception e) {

                return "Calculate Error";
            }
        }
    }

    private List<Input> splitInputString(String inputStr){
        List<Input> inputList = new ArrayList<>();
        String[] arr = inputStr.split(SPACE_SPLITER);
        Arrays.stream(arr)
                .forEach(word -> inputList.add(new Input(word, 1)));
        return inputList;
    }

    private String getMapForSizingSameWord(List<Input> inputList){
        Map<String, List<Input>> wordListMap =getWordListMap(inputList);
        List<Input> mappedWordlist = new ArrayList<>();

        wordListMap.forEach((key, value) -> mappedWordlist.add(new Input(key, value.size())));
        return joinWordList(mappedWordlist);
    }

    private String joinWordList(List<Input> inputList){
        inputList.sort((word1, word2) -> word2.getWordCount() - word1.getWordCount());

        StringJoiner joiner = new StringJoiner("\n");

        inputList.forEach(inputWord -> joiner
                .add(String.format("%s %s"
                        ,inputWord.getValue(),inputWord.getWordCount())));
        return joiner.toString();
    }

    private Map<String,List<Input>> getWordListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        inputList.forEach(inputWord
                -> map.computeIfAbsent(inputWord.getValue(), word -> new ArrayList<>()).add(inputWord));
        return map;
    }


}
