import util.ArrayUtils;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;

public class FrameMain extends JFrame {
    private JTable tableOutputArray;
    private JTable tableInputArray;
    private JButton buttonLoadFromFile;
    private JButton buttonSaveIntoFile;
    private JButton buttonCreateRandomArray;
    private JButton buttonOutputArray;
    private JPanel panelMain;
    private JScrollPane scrollPaneTableInput;

    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;
    private JMenuBar menuBarMain;
    private JMenu menuLookAndFeel;

    public FrameMain() {
        this.setTitle("Task 8");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        util.JTableUtils.initJTableForArray(tableInputArray, 60, true, true, true, true);
        util.JTableUtils.initJTableForArray(tableOutputArray, 60, true, true, true, true);

        tableInputArray.setRowHeight(30);
        tableOutputArray.setRowHeight(30);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        util.JTableUtils.writeArrayToJTable(tableInputArray, new int[]{0, 1, 2, 3});

        buttonLoadFromFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = util.ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
                        util.JTableUtils.writeArrayToJTable(tableInputArray, arr);
                    }
                } catch (Exception e) {
                   util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonSaveIntoFile.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[][] arr = util.JTableUtils.readIntMatrixFromJTable(tableOutputArray);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, arr);
                    }
                } catch (Exception e) {
                    util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonCreateRandomArray.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] arr = util.ArrayUtils.createRandomIntMatrix(tableInputArray.getRowCount(), tableInputArray.getColumnCount(), 100);
                    util.JTableUtils.writeArrayToJTable(tableInputArray, arr);
                } catch (Exception e) {
                    util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonOutputArray.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] arr = util.JTableUtils.readIntMatrixFromJTable(tableInputArray);
                    MinMax permutation = new MinMax();
                    int[][] result = permutation.MinMax(arr);
                    util.JTableUtils.writeArrayToJTable(tableOutputArray, result);
                } catch (Exception e) {
                   util.SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }

    public JMenuBar getMenuBarMain() {
        return menuBarMain;
    }

    public void setMenuBarMain(JMenuBar menuBarMain) {
        this.menuBarMain = menuBarMain;
    }

    public JMenu getMenuLookAndFeel() {
        return menuLookAndFeel;
    }

    public void setMenuLookAndFeel(JMenu menuLookAndFeel) {
        this.menuLookAndFeel = menuLookAndFeel;
    }

    public JScrollPane getScrollPaneTableInput() {
        return scrollPaneTableInput;
    }

    public void setScrollPaneTableInput(JScrollPane scrollPaneTableInput) {
        this.scrollPaneTableInput = scrollPaneTableInput;
    }
}

