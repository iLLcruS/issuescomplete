package DataPackage;

public class Variable extends VariableChooses{
    protected double firstNumber;
    public double getFirstNumber() {
        return firstNumber;
    }
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }
    protected double secondNumber;
    public double getSecondNumber() {
        return secondNumber;
    }
    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }
    protected double result;
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }
    protected String userSentenceAppend;
    public String getUserSentenceAppend() {
        return userSentenceAppend;
    }
    public void setUserSentenceAppend(String userSentenceAppend) {
        this.userSentenceAppend = userSentenceAppend;
    }
    protected String userSentence;
    public String getUserSentence() {
        return userSentence;
    }
    public void setUserSentence(String userSentence) {
        this.userSentence = userSentence;
    }
    protected int numberOneForSubstring;
    public void setNumberOneForSubstring(int numberOneForSubstring) {
        this.numberOneForSubstring = numberOneForSubstring;
    }
    protected int numberTwoForSubstring;
    public void setNumberTwoForSubstring(int numberTwoForSubstring) {
        this.numberTwoForSubstring = numberTwoForSubstring;
    }
    public String nameProperty = System.getProperty("user.name");
}
