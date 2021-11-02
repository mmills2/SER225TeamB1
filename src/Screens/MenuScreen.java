package Screens;

import Engine.*;
import Game.GameState;
import Game.ScreenCoordinator;
import Level.Map;
import Maps.TitleScreenMap;
import SpriteFont.SpriteFont;
import Utils.Stopwatch;

import java.awt.*;

// This is the class for the main menu screen
public class MenuScreen extends Screen {
    protected ScreenCoordinator screenCoordinator;
    protected int currentMenuItemHovered = 0; // current menu item being "hovered" over
    protected int menuItemSelected = -1;
    protected SpriteFont playGame;
    protected SpriteFont instructionsMenu;
    protected SpriteFont credits;
    protected SpriteFont usagePrompt;
    protected SpriteFont settings;
    protected Map background;
    protected Stopwatch keyTimer = new Stopwatch();
    protected int pointerLocationX, pointerLocationY;
    protected KeyLocker keyLocker = new KeyLocker();

    public MenuScreen(ScreenCoordinator screenCoordinator) {
        this.screenCoordinator = screenCoordinator;
    }

    @Override
    public void initialize() {
        playGame = new SpriteFont("PLAY GAME", 200, 150, "Comic Sans", 30, new Color(49, 207, 240));
        playGame.setOutlineColor(Color.black);
        playGame.setOutlineThickness(3);
        instructionsMenu = new SpriteFont("INSTRUCTIONS", 200, 225, "Comic Sans", 30, new Color (49, 207,240));
        instructionsMenu.setOutlineColor(Color.black);
        instructionsMenu.setOutlineThickness(3);
        credits = new SpriteFont("CREDITS", 200, 300, "Comic Sans", 30, new Color(49, 207, 240));
        credits.setOutlineColor(Color.black);
        credits.setOutlineThickness(3);
        settings = new SpriteFont("SETTINGS", 200, 375, "Comic Sans", 30, new Color(49, 207, 240));
        settings.setOutlineColor(Color.black);
        settings.setOutlineThickness(3);
        
        usagePrompt = new SpriteFont("Use the Arrow Keys and Enter to use the menu", 30, 40, "Times New Roman", 30, Color.white);
        background = new TitleScreenMap();
        background.setAdjustCamera(false);
        keyTimer.setWaitTime(200);
        menuItemSelected = -1;
        keyLocker.lockKey(Key.ENTER);
    }

    public void update() {
        // update background map (to play tile animations)
        background.update(null);

        // if down or up is pressed, change menu item "hovered" over (blue square in front of text will move along with currentMenuItemHovered changing)
        if (Keyboard.isKeyDown(Key.DOWN) && keyTimer.isTimeUp()) {
            keyTimer.reset();
            currentMenuItemHovered++;
        } else if (Keyboard.isKeyDown(Key.UP) && keyTimer.isTimeUp()) {
            keyTimer.reset();
            currentMenuItemHovered--;
        }

        // if down is pressed on last menu item or up is pressed on first menu item, "loop" the selection back around to the beginning/end
        if (currentMenuItemHovered > 3) {
            currentMenuItemHovered = 0;
        }
        else if (currentMenuItemHovered < 0) {
            currentMenuItemHovered = 3;
        }
        // sets location for blue square in front of text (pointerLocation) and also sets color of spritefont text based on which menu item is being hovered
        if (currentMenuItemHovered == 0) {
            playGame.setColor(new Color(255, 215, 0));
            instructionsMenu.setColor(new Color(49, 207, 240));
            credits.setColor(new Color(49, 207, 240));
            settings.setColor(new Color(49, 207, 240));
            pointerLocationX = 170;
            pointerLocationY = 130;
        } else if (currentMenuItemHovered == 1) {
            playGame.setColor(new Color(49, 207, 240));
            instructionsMenu.setColor(new Color(255, 215, 0));
            credits.setColor(new Color(49, 207, 240));
            settings.setColor(new Color(49, 207, 240));
            pointerLocationX = 170;
            pointerLocationY = 205;
        }
        else if (currentMenuItemHovered == 2) {
        	playGame.setColor(new Color(49, 207, 240));
            instructionsMenu.setColor(new Color(49, 207, 240));
            credits.setColor(new Color(255, 215, 0));
            settings.setColor(new Color(49, 207, 240));
            pointerLocationX = 170;
            pointerLocationY = 280;
        }
        else if(currentMenuItemHovered == 3) {
        	playGame.setColor(new Color(49, 207, 240));
        	instructionsMenu.setColor(new Color(49, 207, 240));
        	credits.setColor(new Color(49, 207, 240));
            settings.setColor(new Color(255, 215, 0));
            pointerLocationX = 170;
            pointerLocationY = 355;
        }

        // if space is pressed on menu item, change to appropriate screen based on which menu item was chosen
        if (Keyboard.isKeyUp(Key.ENTER)) {
            keyLocker.unlockKey(Key.ENTER);
        }
        if (!keyLocker.isKeyLocked(Key.ENTER) && Keyboard.isKeyDown(Key.ENTER)) {
            menuItemSelected = currentMenuItemHovered;
            if (menuItemSelected == 0) {
                screenCoordinator.setGameState(GameState.INTRO);
            } else if (menuItemSelected == 1) {
                screenCoordinator.setGameState(GameState.INSTRUCTIONS);
            }
            else if (menuItemSelected == 2) {
                screenCoordinator.setGameState(GameState.CREDITS);
            }
             else if(menuItemSelected == 3){ 
             screenCoordinator.setGameState(GameState.SETTINGS);
             }
             
        }
    }

    public void draw(GraphicsHandler graphicsHandler) {
        background.draw(graphicsHandler);
        playGame.draw(graphicsHandler);
        instructionsMenu.draw(graphicsHandler);
        credits.draw(graphicsHandler);
        usagePrompt.draw(graphicsHandler);
        settings.draw(graphicsHandler);
        graphicsHandler.drawFilledRectangleWithBorder(pointerLocationX, pointerLocationY, 20, 20, new Color(49, 207, 240), Color.black, 2);
    }

    public int getMenuItemSelected() {
        return menuItemSelected;
    }
}
