/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processamento;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.lang.Math.pow;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

/**
 *
 * @author lucas
 */
public class ProcessamentoImagem {
    
    public static BufferedImage detectarPeleHumana(BufferedImage imagem){
        
        
            double CanalY;
            double CanalU;
            double CanalV;
            double CanalI;
            double Arct;

        
        for(int i = 0; i < imagem.getWidth(); i++){
            for(int j = 0; j < imagem.getHeight(); j++){
                Color c = new Color(imagem.getRGB(i,j));
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                
                
                     CanalY = 0.299 * r + 0.587 * g  + 0.114 * b;
                    
                    CanalU = (-0.147) * r + (-0.289) * g  + 0.436 * b;
                    
                    CanalV = 0.615 * r + (-0.515) * g  + (-0.100) * b;
                    
                    CanalI = 0.596 * r + (-0.274) * g  + (-0.322) * b;
                    
                    Arct=  Math.atan(Math.abs(CanalV)/Math.abs(CanalU ));  
            
                   
                    
                    if ( (Arct >=1.8 && Arct <= 2.3) || ( CanalI>=10 && CanalI<=55)  ) {
                       
                    }
                    
                    else {
                     imagem.setRGB(i, j, Color.BLACK.getRGB());
                    }               
            }
        }     
        
        return imagem;
    } 
    
    
}