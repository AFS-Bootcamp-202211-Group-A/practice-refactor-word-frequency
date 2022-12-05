import java.util.*;

import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){
        try {

            List<Input> inputList = splitInputStringToList(inputStr);

            //get the map for the next step of sizing the same word
            Map<String, List<Input>> groupByValueInput = groupInputByValue(inputList);

            List<Input> inputCountList = countGroupByValueInput(groupByValueInput);

            return joinInputCountListString(inputCountList);
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private String joinInputCountListString(List<Input> inputCountList) {
        StringJoiner joiner = new StringJoiner("\n");
        inputCountList
                .forEach(input ->
                joiner.add(input.getValue() + " " + input.getWordCount())
        );
        return joiner.toString();
    }

    private List<Input> countGroupByValueInput(Map<String, List<Input>> groupedInput) {
        List<Input> inputCountList = new ArrayList<>();
        groupedInput.forEach(((key, value) -> {
            Input input = new Input(key, value.size());
            inputCountList.add(input);
        }));
        inputCountList.sort((currInput, nextInput) -> nextInput.getWordCount() - currInput.getWordCount());
        return inputCountList;
    }

    //split the input string with 1 to n pieces of spaces
    private List<Input> splitInputStringToList(String inputStr) {
        return Arrays.stream(inputStr.split("\\s+"))
                .map(splitInputStr -> new Input(splitInputStr, 1))
                .collect(Collectors.toList());
    }


    private Map<String,List<Input>> groupInputByValue(List<Input> inputList) {
        Map<String, List<Input>> listMap = new HashMap<>();
        inputList.forEach(input ->
                listMap.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input)
        );
        return listMap;
    }


}
