import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    public static final String STRING_REGEX = "\\s+";
    public static final int ONE = 1;
    public static final String SINGLE_INTEGER_STRING = " 1";
    public static final String CALCULATE_ERROR = "Calculate Error";
    public static final String SPACE_STRING = " ";
    public static final String NEW_LINE_DELIMITER = "\n";

    public String getResult(String inputStr) {
        if (inputStr.split(STRING_REGEX).length == ONE) {
            return inputStr + SINGLE_INTEGER_STRING;
        } else {
            try {
                List<Input> inputList = splitInputWithSpaces(inputStr);
                Map<String, List<Input>> listMap = getListMap(inputList);
                return generateResult(listMap);
            } catch (Exception e) {
                return CALCULATE_ERROR;
            }
        }
    }

    private static String generateResult(Map<String, List<Input>> listMap) {
        return listMap.entrySet()
                .stream()
                .map(entry -> new Input(entry.getKey(), entry.getValue().size()))
                .sorted((word1, word2) -> word2.getWordCount() - word1.getWordCount())
                .map(input -> input.getWord() + SPACE_STRING + input.getWordCount())
                .collect(Collectors.joining(NEW_LINE_DELIMITER));
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
