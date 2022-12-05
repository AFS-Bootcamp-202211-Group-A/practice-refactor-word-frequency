public class Input {
    private String value;
    private int count;

    public Input(String word, int wordCount){
        this.value =word;
        this.count =wordCount;
    }


    public String getValue() {
        return this.value;
    }

    public int getWordCount() {
        return this.count;
    }


}
