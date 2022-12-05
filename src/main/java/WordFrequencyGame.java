import java.util.*;
import java.io.CharArrayWriter;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr){


        if (inputStr.split("\\s+").length==1) {
            return inputStr + " 1";
        } else {

            try {

                //split the input string with 1 to n pieces of spaces
                List<Input> inputList = getInputs(inputStr);

                //get the map for the next step of sizing the same word
                Map<String, List<Input>> map =getListMap(inputList);

                inputList = map.entrySet().stream()
                        .map(entry -> new Input(entry.getKey(), entry.getValue().size()))
                        .collect(Collectors.toList());

                inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

                return inputList.stream()
                        .map(input -> input.getValue() + " " +input.getWordCount())
                        .collect(Collectors.joining("\n"));
            } catch (Exception e) {


                return "Calculate Error";
            }
        }
    }

    private static List<Input> getInputs(String inputStr) {
        return Arrays.stream(inputStr.split("\\s+"))
                .map(input -> new Input(input,1))
                .collect(Collectors.toList());
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
