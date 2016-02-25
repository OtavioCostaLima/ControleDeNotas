package br.com.controle.visao;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Otavio Costa
 */
public class GerenteDeArquivos {

    public boolean setImagemLabel(String path, JLabel jLabel) {
        File file = new File(path);
        if (file.isFile()) {
            jLabel.setIcon(new ImageIcon(path));
            return true;
        }
        return false;
    }

    public void escreverImagem(String path, int width, int height, String novoCaminho) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            BufferedImage new_img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = new_img.createGraphics();
            g.drawImage(image, 0, 0, width, height, null);
            ImageIO.write(new_img, "JPG", new File(novoCaminho));

        } catch (IOException iOException) {
            System.err.println("Erro: " + iOException.getMessage());
        }
    }

    public String escolherImagem(JLabel jLabel) {
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        chooser.setFileFilter(new FileFilter() {

            @Override
            public boolean accept(File f) {
                String caminho = f.getAbsolutePath();
                return caminho.endsWith("png") | caminho.endsWith("jpg") | caminho.endsWith("bmp") | f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Imagem";
            }
        });

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            ImageIcon icone = new ImageIcon(path);
            Image image = icone.getImage().getScaledInstance(jLabel.getWidth() - 2, jLabel.getHeight() - 2, Image.SCALE_DEFAULT);
            jLabel.setIcon(new ImageIcon(image));
            return chooser.getSelectedFile().getAbsolutePath();
        }
        return "";
    }
}
