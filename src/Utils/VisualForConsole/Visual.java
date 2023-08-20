package Utils.VisualForConsole;

import lombok.SneakyThrows;

import java.util.stream.Stream;

public class Visual {

    public void printMsgWithProgressBar(String message, int length, long timeInterval)
    {
        char incomplete = '░';
        char complete = '█';
        StringBuilder builder = new StringBuilder();
        Stream.generate(() -> incomplete).limit(length).forEach(builder::append);
        System.out.println(message);
        for(int i = 0; i < length; i++)
        {
            builder.replace(i,i+1,String.valueOf(complete));
            String progressBar = "\r"+builder;
            System.out.print(progressBar);


            try
            {
                Thread.sleep(timeInterval);
            }
            catch (InterruptedException ignored)
            {
            }
        }
    }

    @SneakyThrows
    public void printMessage(String message){
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            Thread.sleep(100);
            System.out.print(c);
        }
    }
    public void printMsgWithSeparator(int length, long timeInterval){
        char incomplete = '-';
        char complete = '=';
        StringBuilder builder = new StringBuilder();
        Stream.generate(() -> incomplete).limit(length).forEach(builder::append);
        for(int i = 0; i < length; i++)
        {
            builder.replace(i,i+1,String.valueOf(complete));
            String progressBar = "\r"+builder;
            System.out.print(progressBar);
            try
            {
                Thread.sleep(timeInterval);
            }
            catch (InterruptedException ignored)
            {
            }
        }
        System.out.println("");
    }
}
