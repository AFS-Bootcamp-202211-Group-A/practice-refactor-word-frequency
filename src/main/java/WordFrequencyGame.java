import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {



    public String getResult(String inputStr){
        try {
            List<Input> inputList = getInputs(inputStr);
            Map<String, List<Input>> map =getListMap(inputList);
            return map.entrySet().stream()
                    .map(entry -> new Input(entry.getKey(), entry.getValue().size()))
                    .sorted((input1, input2) -> input2.getWordCount() - input1.getWordCount())
                    .map(input -> input.getValue() + " " + input.getWordCount())
                    .collect(Collectors.joining("\n"));
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private static List<Input> getInputs(String inputStr) {
        final String SPACE = "\\s+";
        return Arrays.stream(inputStr.split(SPACE))
                .map(input -> new Input(input,1))
                .collect(Collectors.toList());
    }


    private Map<String,List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> maps = new HashMap<>();
        inputList.forEach(input -> maps.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input));
        return maps;
    }
}
