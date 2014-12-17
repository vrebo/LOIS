package org.losi.vistas.componentes;

import java.awt.Dimension;
import javax.swing.JInternalFrame;

public class MyInternalFrame extends JInternalFrame {

    public MyInternalFrame(){
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
    }
    
    @Override
    public void show() {
        Dimension deskopSize = getDesktopPane().getSize();
        Dimension catalogoSize = getSize();
        int x = deskopSize.width / 2 - catalogoSize.width / 2;
        int y = deskopSize.height / 2 - catalogoSize.height / 2;
        setLocation(x, y);
        super.show();
    }
}
