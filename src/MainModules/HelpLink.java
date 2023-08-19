package MainModules;

import MainModules.WebModules.OpenSite;
import lombok.SneakyThrows;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;

public class HelpLink extends OpenSite {


    private final String telegram = "https://t.me/javaissue";

    @SneakyThrows
    public void start() {
        System.out.print("Telegram: " + telegram + "\n");
        openWebPage();
    }

    @SneakyThrows
    public HelpLink() throws URISyntaxException{

    }

    @Override
    public void openWebPage() throws URISyntaxException {
        URI uri = new URI(telegram);
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