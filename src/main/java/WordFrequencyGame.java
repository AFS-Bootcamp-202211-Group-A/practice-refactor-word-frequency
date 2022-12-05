import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){
            try {
                List<Input> inputList = extractInputList(inputStr);
                inputList = aggregateInputList(inputList);
                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());
                return printInputList(inputList);
            } catch (Exception e) {
                return "Calculate Error";
            }
    }

    private static String printInputList(List<Input> inputList) {
        return inputList.stream()
                .map(word -> word.getValue() + " " + word.getWordCount())
                .collect(Collectors.joining("\n"));
    }

    private List<Input> aggregateInputList(List<Input> inputList) {
        Map<String, List<Input>> map = getListMap(inputList);
        inputList = map.entrySet()
                .stream()
                .map( word ->  new Input(word.getKey(), word.getValue().size()))
                .collect(Collectors.toList());
        return inputList;
    }

    private static List<Input> extractInputList(String inputStr) {
        String[] arr = inputStr.split("\\s+");
        List<Input> inputList = Arrays.stream(arr)
                .map(word -> new Input(word, 1))
                .collect(Collectors.toList());
        return inputList;
    }


    private Map<String,List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = inputList
                .stream()
                .collect(Collectors.groupingBy(Input::getValue));
        return map;
    }


}
