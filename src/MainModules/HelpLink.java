package MainModules;

import lombok.SneakyThrows;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;

public class HelpLink {

    private final String telegram = "https://t.me/javaissue";
    @SneakyThrows
    public void start(){
        System.out.print("Telegram: "+telegram+"\n");
        openWebPage(telegram);
    }

    public void openWebPage(String url) throws URISyntaxException {
        URI uri = new URI(url);
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}