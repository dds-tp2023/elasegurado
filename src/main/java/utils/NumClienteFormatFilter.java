package utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumClienteFormatFilter extends DocumentFilter {
	private int limit;

    public NumClienteFormatFilter(int limit) {
        this.limit = limit;
    }
    
    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        if (isNumeric(text) && (fb.getDocument().getLength() + text.length()) <= limit) {
            super.insertString(fb, offset, text, attr);
            formatText(fb);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (isNumeric(text) && (fb.getDocument().getLength() + text.length() - length) <= limit) {
            super.replace(fb, offset, length, text, attrs);
            formatText(fb);
        }
    }

    private boolean isNumeric(String text) {
        return text.matches("\\d*");
    }

    private void formatText(FilterBypass fb) throws BadLocationException {
        String text = fb.getDocument().getText(0, fb.getDocument().getLength());
        text = text.replaceAll("\\D", ""); // Eliminar no dígitos
        StringBuilder formattedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i == 2) {
                formattedText.append("-");
            }
            formattedText.append(text.charAt(i));
        }

        fb.replace(0, fb.getDocument().getLength(), formattedText.toString(), null);
    }
}