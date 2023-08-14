package Modules.VisualForConsole;


import static java.lang.System.out;

public class ChangeConsoleColor {

    private String color;
    public void setBlackColor(){
        out.println((char)27 + "[30m" + "");
    }
    public void setRedColor(){
        out.println((char)27 + "[31m" + "");
    }
    public void setGreenColor(){
        out.println((char)27 + "[32m" + "");
    }
    public void setYellowColor(){
        out.println((char)27 + "[33m" + "");
    }
    public void setBlueColor(){
        out.println((char)27 + "[34m" + "");
    }
    public void setPurpleColor(){
        out.println((char)27 + "[35m" + "");
    }
    public void setCeruleanColor(){
        out.println((char)27 + "[36m" + "");
    }
    public void setWhiteColor(){
        out.println((char)27 + "[37m" + "");
    }

}
