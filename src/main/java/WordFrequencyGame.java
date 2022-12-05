import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public static final String STRING_REGEX = "\\s+";
    public static final int ONE = 1;
    public static final String SINGLE_INTEGER_STRING = " 1";
    public static final String CALCULATE_ERROR = "Calculate Error";

    public String getResult(String inputStr) {


        if (inputStr.split(STRING_REGEX).length == ONE) {
            return inputStr + SINGLE_INTEGER_STRING;
        } else {

            try {

                List<Input> inputList = splitInputWithSpaces(inputStr);

                //get the map for the next step of sizing the same word
                Map<String, List<Input>> map = getListMap(inputList);

                List<Input> list = new ArrayList<>();
                for (Map.Entry<String, List<Input>> entry : map.entrySet()) {
                    Input input = new Input(entry.getKey(), entry.getValue().size());
                    list.add(input);
                }
                inputList = list;

                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                StringJoiner joiner = new StringJoiner("\n");
                for (Input w : inputList) {
                    String s = w.getWord() + " " + w.getWordCount();
                    joiner.add(s);
                }
                return joiner.toString();
            } catch (Exception e) {


                return CALCULATE_ERROR;
            }
        }
    }

    private List<Input> splitInputWithSpaces(String inputStr) {
        return Arrays
                .stream(inputStr.split(STRING_REGEX))
                .map(str -> new Input(str, ONE))
                .collect(Collectors.toList());
    }


    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> listMap = new HashMap<>();
        inputList.stream()
                .forEach(input -> {
                    listMap.computeIfAbsent(input.getWord(), k -> new ArrayList<>()).add(input);
                });
        return listMap;
    }
}
