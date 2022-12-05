import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){

        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        }

        try {

            List<Input> inputList = splitString(inputStr);

            //get the map for the next step of sizing the same word
            Map<String, List<Input>> map =getListMap(inputList);

            List<Input> list = new ArrayList<>();
            for (Map.Entry<String, List<Input>> entry : map.entrySet()){
                Input input = new Input(entry.getKey(), entry.getValue().size());
                list.add(input);
            }
            inputList = list;

            inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

            StringJoiner joiner = new StringJoiner("\n");
            for (Input w : inputList) {
                String s = w.getValue() + " " +w.getWordCount();
                joiner.add(s);
            }
            return joiner.toString();
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    //split the input string with 1 to n pieces of spaces
    private List<Input> splitString(String inputStr) {
        return Arrays.stream(inputStr.split("\\s+"))
                .map(splitInputStr -> new Input(splitInputStr, 1))
                .collect(Collectors.toList());
    }


    private Map<String,List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> listMap = new HashMap<>();
        inputList.forEach(input ->
                listMap.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input)
        );
        return listMap;
    }


}
