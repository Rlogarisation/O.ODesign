package unsw.fileEditor;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class TextEditor implements EditorFactory {
    private JFrame frame;
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private WindowAdapter windowAdapter;
    private JDesktopPane pane;
    private ActionListener listener;

    public TextEditor() {
        this.createFrame();
        this.createDesktopPane();
        this.createButtonListener();
        this.createMenuBar();
        this.createEditMenu();
        this.createToolBar();
        this.createWindowAdapter();

        frame.setJMenuBar(menuBar);
        frame.addWindowListener(windowAdapter);
        frame.getContentPane().add(toolBar, "North");
        frame.getContentPane().add(pane);
    }


    public void createFrame() {
        this.frame = new JFrame("Basic Editor");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.height = screenSize.height - (25 * screenSize.height / 768);
        frame.setSize(screenSize);
    }

    public void createDesktopPane() {
        this.pane = new JDesktopPane();
    }

    public void createButtonListener() {
        this.listener = new ButtonListener(pane);
    }

    public void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        String[] fileMenuItems = new String[] { "New", "Open", "Save", "Save As" };

        for (int i = 0; i < fileMenuItems.length; i++) {
            JMenuItem menuItem = new JMenuItem(fileMenuItems[i]);
            fileMenu.add(menuItem);
            menuItem.addActionListener(listener); // Listens to button press
        }
        menuBar.add(fileMenu);
    }

    public void createEditMenu() {
        JMenu editMenu = new JMenu("Edit");
        String[] editMenuItems = new String[] { "Copy", "Cut", "Paste", "Select All" };

        for (int i = 0; i < editMenuItems.length; i++) {
            JMenuItem menuItem = new JMenuItem(editMenuItems[i]);
            editMenu.add(menuItem);
            menuItem.addActionListener(listener); // Listens to button press
        }
        menuBar.add(editMenu);
    }

    public void createToolBar() {
        this.toolBar = new JToolBar();
        String[] buttons = new String[] { "New", "Open", "Save", "Copy", "Cut", "Paste" };

        for (int i = 0; i < buttons.length; i++) {
            JButton button = new JButton(buttons[i], new ImageIcon(buttons[i] + ".jpg"));
            button.setPreferredSize(new Dimension(500, 50));
            toolBar.add(button);
            button.addActionListener(listener);
            if (i == 2)
                toolBar.addSeparator(new Dimension(10, toolBar.getHeight()));
        }
    }

    public void createWindowAdapter() {
        this.windowAdapter = new WindowCloser(pane);
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
