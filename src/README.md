Steps:

1.Run test
2.mysterious name:
w -> word,
i -> wordCount
3.extract "\\s+" as SPACE_SPLITER
4.mysterious name:
    w1 -> word1
    w2 -> word2
5.Too long method:
extract splitInputString method, getMapForSizingSameWord
6. Change loop in splitInputString to stream api
7. Replace loop in getMapForSizingSameWord to stream api
8. Rename getListMap to getWordListMap, and 
   Replace loop in getWordListMap method to stream api
   
9.Extract joinWordList method
10.list -> mappedWordlist, map -> wordListMap