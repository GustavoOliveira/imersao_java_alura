import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    void cria(InputStream inputStream, String nomeAString) throws IOException{
        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        // cria nova imagem em memória com transpearência e com tamanho novo 
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0,null);

        // configurar fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 128);
        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);

        // escrever um frase na nova imagem
        graphics.drawString("Muito Bom", (largura/4), novaAltura - 50);

        // escreve a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("Alura-Stickers/saida/" + nomeAString));
    }
} 