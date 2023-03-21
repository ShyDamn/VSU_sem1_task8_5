import java.util.Locale;

public class GuiMain {

    public static void main(String[] args) throws Exception {
        winMain();
    }

    public static void winMain() throws Exception {
        Locale.setDefault(Locale.ROOT);

        java.awt.EventQueue.invokeLater(() -> new FrameMain().setVisible(true));
    }
}
