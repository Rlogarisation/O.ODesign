package unsw.fileEditor;

import javax.swing.JFrame;

public class EditorApplication {

    private JFrame frame;

    public EditorApplication(String type) {

        if (type.equals("HTML Editor")) {
            HTMLEditor newHTMLEditor = new HTMLEditor();
            frame = newHTMLEditor.getFrame();

        } 
        else if (type.equals("Text Editor")) {
            TextEditor newTextEditor = new TextEditor();
            frame = newTextEditor.getFrame();
        }
    }
    
    public void setFrameVisible(boolean value) {
        frame.setVisible(value);
    }

    public static void main(String[] args) {
        String editorType = "HTML Editor";
        EditorApplication editor = new EditorApplication(editorType);
        editor.setFrameVisible(true);
    }
	
}