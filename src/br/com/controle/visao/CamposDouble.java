package br.com.controle.visao;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Suporte Técnico
 */
public class CamposDouble extends PlainDocument {

    private final double maiorLimit = 10;
    private final int casasDecimais = 2;

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str != null) {
            str = str.replace('.', ',');
            try {
                String newStr = getText(0, getLength()) + str;

                if (newStr.equals(",")) {
                    newStr = "0,";
                    str = "0,";
                }

                double f = Double.parseDouble(newStr.replace(',', '.'));

                int numeroDecimais = (newStr.indexOf(',') > -1 ? newStr.substring(newStr.indexOf(',')).length() - 1 : 0);

                if (f <= maiorLimit && numeroDecimais <= casasDecimais) {
                    super.insertString(offs, str, a);
                }
            } catch (NumberFormatException ex) {

            }
        }
    }

    @Override
    public void replace(int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

        super.replace(offset, length, text, attrs); //To change body of generated methods, choose Tools | Templates.
    }

}
