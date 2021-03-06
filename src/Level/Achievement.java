package Level;

import Engine.GraphicsHandler;
import SpriteFont.SpriteFont;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Achievement {

    protected SpriteFont title;
    protected BufferedImage image;
    protected boolean isFound;
    protected int id;

    public Achievement (String title, BufferedImage image, int id){
        this.title = new SpriteFont(title, 80, 45, "Arial", 12, Color.WHITE);
        this.image = image;
        this.id = id;
    }

    public void draw(GraphicsHandler graphicsHandler) {
        graphicsHandler.drawFilledRectangleWithBorder(0, 0, 175, 76, new Color(0.02f, 0.01f, 0.31f), Color.BLACK, 2);
        graphicsHandler.drawImage(image, 13, 13, 50, 50);
        title.draw(graphicsHandler);
    }

    public int getId(){
        return id;
    }

    public void setIsFound(boolean isFound){
        this.isFound = isFound;
    }
    
}
