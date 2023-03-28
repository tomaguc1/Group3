package org.group3.Helpers;

import javax.swing.*;
import java.io.IOException;

public class ImageLibrary {
//    InputStream stream = getClass().getResourceAsStream("/resources/Miscellaneous/battleshipAppLogo.png");
    public ImageIcon shipLogoImage = new ImageIcon(this.getClass().getResource("/Miscellaneous/battleshipAppLogo.png"));

    public ImageLibrary() throws IOException {
    }
}
