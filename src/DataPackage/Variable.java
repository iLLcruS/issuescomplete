package DataPackage;

public class Variable extends VariableChooses{

    protected double firstNumber;

    protected int numberOneForSubstring;

    protected double secondNumber;

    protected char charOne;

    protected char charTwo;

    protected double result;

    protected String userSentenceAppend;

    protected String userSentence;

    protected int numberTwoForSubstring;

    public String nameProperty = System.getProperty("user.name");

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }


    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getUserSentenceAppend() {
        return userSentenceAppend;
    }

    public void setUserSentenceAppend(String userSentenceAppend) {
        this.userSentenceAppend = userSentenceAppend;
    }

    public String getUserSentence() {
        return userSentence;
    }

    public void setUserSentence(String userSentence) {
        this.userSentence = userSentence;
    }

    public void setNumberOneForSubstring(int numberOneForSubstring) {
        this.numberOneForSubstring = numberOneForSubstring;
    }

    public void setNumberTwoForSubstring(int numberTwoForSubstring) {
        this.numberTwoForSubstring = numberTwoForSubstring;
    }

    public void setCharOne(char charOne)
    {
        this.charOne = charOne;
    }

    public char getCharOne()
    {
        return charOne;
    }

    public void setCharTwo(char charTwo)
    {
        this.charTwo = charTwo;
    }

    public char getCharTwo()
    {
        return charTwo;
    }

}
