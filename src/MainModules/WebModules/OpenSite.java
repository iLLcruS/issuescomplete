package MainModules.WebModules;

import MainModules.MainMenu;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class OpenSite {

    public void openWebPage() throws URISyntaxException {
        System.out.println("Enter URL: ");
        String url = new Scanner(System.in).nextLine();
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
    public OpenSite() throws URISyntaxException {
    }

}
