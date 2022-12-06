import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){
        return getResultWhenLengthNotOne(inputStr);
    }

    private String getResultWhenLengthNotOne(String inputStr) {
        try {
            //split the input string with 1 to n pieces of spaces
            List<Input> inputList = getInputs(inputStr);
            //get the map for the next step of sizing the same word
            Map<String, List<Input>> map =getListMap(inputList);
            return map.entrySet().stream()
                    .map(entry -> new Input(entry.getKey(), entry.getValue().size()))
                    .sorted((w1, w2) -> w2.getWordCount() - w1.getWordCount())
                    .map(input -> input.getValue() + " " + input.getWordCount())
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private static List<Input> getInputs(String inputStr) {
        return Arrays.stream(inputStr.split("\\s+"))
                .map(input -> new Input(input,1))
                .collect(Collectors.toList());
    }


    private Map<String,List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> maps = new HashMap<>();
        inputList.forEach(input -> maps.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input));
        return maps;
    }
}
