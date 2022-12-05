import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr) {

        return inputStr.split("\\s+").length == 1?inputStr + " 1":getString(inputStr);
    }

    private String getString(String inputStr) {
        try {

            return getListMap(Arrays
                    .stream(inputStr.split("\\s+"))
                    .map(str -> new Input(str, 1))
                    .collect(Collectors.toList()))
                    .entrySet()
                    .stream()
                    .map(entry -> new Input(entry.getKey(), entry.getValue().size()))
                    .sorted((w1, w2) -> w2.getWordCount() - w1.getWordCount())
                    .map(input -> input.getValue() + " " + input.getWordCount())
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {


            return "Calculate Error";
        }
    }


    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        inputList.stream().forEach(input -> {
            map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
        });
        return map;
    }


}
