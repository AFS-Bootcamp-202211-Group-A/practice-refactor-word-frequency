import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.io.CharArrayWriter;
import java.util.*;
import java.util.stream.Collectors;

import java.time.LocalDateTime;

public class WordFrequencyGame {

    public static final String SPACE_SPLITER = "\\s+";

    public String getResult(String inputStr){

        if (inputStr.split(SPACE_SPLITER).length==1) {
            return inputStr + " 1";
        } else {

            try {

                //split the input string with 1 to n pieces of spaces
                List<Input> inputList = splitInputString(inputStr);

                //get the map for the next step of sizing the same word
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
        Map<String, List<Input>> map =getListMap(inputList);

        List<Input> list = new ArrayList<>();
        for (Map.Entry<String, List<Input>> entry : map.entrySet()){
            Input input = new Input(entry.getKey(), entry.getValue().size());
            list.add(input);
        }
        inputList = list;

        inputList.sort((word1, word2) -> word2.getWordCount() - word1.getWordCount());

        StringJoiner joiner = new StringJoiner("\n");
        for (Input w : inputList) {
            String s = w.getValue() + " " +w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }

    private Map<String,List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input :  inputList){
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(input.getValue())){
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            }

            else {
                map.get(input.getValue()).add(input);
            }
        }


        return map;
    }


}
