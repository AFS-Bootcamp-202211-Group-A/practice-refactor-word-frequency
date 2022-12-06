Refactoring steps
1. Run test cases
2. Find code smell
3. Refactor and rerun test cases
   1. rename mysterious names in Input
   2. remove useless else in getResult
   3. extract & replace for with stream in splitString
   4. In getListMap
      1. use computeIfAbsent instead of if-else
      2. use forEach instead of for
      3. rename listMap
   5. In getResult
      1. replace for with forEach
      2. remove unnecessary assignment of inputCountList to inputList
      3. remove unnecessary if block
      4. rename splitInputStringToList, groupInputByValue, groupedInput
      7. extract countGroupByValueInput, joinInputCountListString
   6. Remove line breaks and comments
   7. Extract string in splitInputStringToList
   8. Add final to constants
4. Commit in baby steps