public class WordCountInfo {
    private String word;
    private int count;

    public WordCountInfo(String word, int count){
        this.word = word;
        this.count = count;
    }

    public int getWordCount() {
        return this.count;
    }

    public String getWordWithCount(){
        return this.word + " " + this.count;
    }


}
