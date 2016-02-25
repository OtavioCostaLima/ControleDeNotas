package br.com.controle.visao;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            ImageIO.write(image, "JPG", new File(novoCaminho));
        } catch (IOException iOException) {
            System.err.println("Erro? "+iOException.getMessage());
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

    public Image gravarImagem(String path, int width, int height, String matricula) {
        File novaImagem = new File("./fotos/" + matricula + ".jpg");

        Image image = new ImageIcon(path).getImage().getScaledInstance(width - 2, height - 2, Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = new BufferedImage(width - 2, height - 2, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(image, 0, 0, null);
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "JPG", novaImagem);
        } catch (IOException ex) {
            Logger.getLogger(PainelAlunos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

}
