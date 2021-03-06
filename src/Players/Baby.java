package Players;

import java.util.HashMap;

import Builders.FrameBuilder;
import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.Key;
import GameObject.Frame;
import GameObject.ImageEffect;
import GameObject.SpriteSheet;
import Level.Player;

// This is the class for the Cat player character
// basically just sets some values for physics and then defines animations
public class Baby extends Player {

	public Baby(){ this(-1, -1); }

	public Baby(float x, float y) {
		super(new SpriteSheet(ImageLoader.load("Baby.png"), 24, 24), x, y, "STAND_RIGHT");
		gravity = .5f;
		terminalVelocityY = 6f;
		jumpHeight = 14.5f;
		jumpDegrade = .5f;
		walkSpeed = 3.6f;
		momentumYIncrease = .5f;
		JUMP_KEY = Key.UP;
		MOVE_LEFT_KEY = Key.LEFT;
		MOVE_RIGHT_KEY = Key.RIGHT;
		CROUCH_KEY = Key.DOWN;
		POWERUP_ONE_KEY = Key.ONE;
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void draw(GraphicsHandler graphicsHandler) {
		super.draw(graphicsHandler);
		// drawBounds(graphicsHandler, new Color(255, 0, 0, 170));
	}

	@Override
	public HashMap<String, Frame[]> getAnimations(SpriteSheet spriteSheet) {
		return new HashMap<String, Frame[]>() {
			{
				put("STAND_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(0, 0), 0).withScale(3).withBounds(8, 9, 8, 9).build() });

				put("STAND_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(0, 0), 0).withScale(3)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build() });

				put("INVINCIBLE", new Frame[]{
		                new FrameBuilder(spriteSheet.getSprite(0, 1), 200)
		                        .withScale(3)
		                        .withBounds(8, 9, 8, 9)
		                        .build()
		            });
				
				put("WALK_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(1, 0), 200).withScale(3).withBounds(8, 9, 8, 9).build(),
						new FrameBuilder(spriteSheet.getSprite(1, 1), 200).withScale(3).withBounds(8, 9, 8, 9).build(),
						new FrameBuilder(spriteSheet.getSprite(1, 2), 200).withScale(3).withBounds(8, 9, 8, 9).build(),
						new FrameBuilder(spriteSheet.getSprite(1, 3), 200).withScale(3).withBounds(8, 9, 8, 9)
								.build() });

				put("WALK_LEFT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(1, 0), 200).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build(),
								new FrameBuilder(spriteSheet.getSprite(1, 1), 200).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build(),
								new FrameBuilder(spriteSheet.getSprite(1, 2), 200).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build(),
								new FrameBuilder(spriteSheet.getSprite(1, 3), 200).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build() });

				put("JUMP_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(2, 0), 0).withScale(3).withBounds(8, 9, 8, 9).build() });

				put("JUMP_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(2, 0), 0).withScale(3)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build() });

				put("FALL_RIGHT", new Frame[] {
						new FrameBuilder(spriteSheet.getSprite(3, 0), 0).withScale(3).withBounds(8, 9, 8, 9).build() });

				put("FALL_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(3, 0), 0).withScale(3)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 9, 8, 9).build() });

				put("CROUCH_RIGHT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(4, 0), 0).withScale(3)
						.withBounds(8, 12, 8, 6).build() });

				put("CROUCH_LEFT", new Frame[] { new FrameBuilder(spriteSheet.getSprite(4, 0), 0).withScale(3)
						.withImageEffect(ImageEffect.FLIP_HORIZONTAL).withBounds(8, 12, 8, 6).build() });

				put("DEATH_RIGHT",
						new Frame[] { new FrameBuilder(spriteSheet.getSprite(5, 0), 100).withScale(3).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 1), 100).withScale(3).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 2), -1).withScale(3).build() });

				put("DEATH_LEFT",
						new Frame[] {
								new FrameBuilder(spriteSheet.getSprite(5, 0), 100).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 1), 100).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build(),
								new FrameBuilder(spriteSheet.getSprite(5, 2), -1).withScale(3)
										.withImageEffect(ImageEffect.FLIP_HORIZONTAL).build() });
				put("MILKED_STAND_RIGHT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(6, 0), 0)
	                            .withScale(3)
	                            .withBounds(8, 9, 8, 9)
	                            .build()
	            });

	            put("MILKED_STAND_LEFT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(6, 0), 0)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .withBounds(8, 9, 8, 9)
	                            .build()
	            });

	            put("MILKED_WALK_RIGHT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(7, 0), 200)
	                            .withScale(3)
	                            .withBounds(8, 9, 8, 9)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(7, 1), 200)
	                            .withScale(3)
	                            .withBounds(8, 9, 8, 9)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(7, 2), 200)
	                            .withScale(3)
	                            .withBounds(8, 9, 8, 9)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(7, 3), 200)
	                            .withScale(3)
	                            .withBounds(8, 9, 8, 9)
	                            .build()
	            });

	            put("MILKED_WALK_LEFT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(7, 0), 200)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .withBounds(8, 9, 8, 9)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(7, 1), 200)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .withBounds(8, 9, 8, 9)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(7, 2), 200)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .withBounds(8, 9, 8, 9)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(7, 3), 200)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .withBounds(8, 9, 8, 9)
	                            .build()
	            });

	            put("MILKED_JUMP_RIGHT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(8, 0), 0)
	                            .withScale(3)
	                            .withBounds(8, 9, 8, 9)
	                            .build()
	            });

	            put("MILKED_JUMP_LEFT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(8, 0), 0)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .withBounds(8, 9, 8, 9)
	                            .build()
	            });

	            put("MILKED_FALL_RIGHT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(9, 0), 0)
	                            .withScale(3)
	                            .withBounds(8, 9, 8, 9)
	                            .build()
	            });

	            put("MILKED_FALL_LEFT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(9, 0), 0)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .withBounds(8, 9, 8, 9)
	                            .build()
	            });

	            put("MILKED_CROUCH_RIGHT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(10, 0), 0)
	                            .withScale(3)
	                            .withBounds(8, 12, 8, 6)
	                            .build()
	            });

	            put("MILKED_CROUCH_LEFT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(10, 0), 0)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .withBounds(8, 12, 8, 6)
	                            .build()
	            });

	            put("DEATH_MILKED_RIGHT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(11, 0), 100)
	                            .withScale(3)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(11, 1), 100)
	                            .withScale(3)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(11, 2), -1)
	                            .withScale(3)
	                            .build()
	            });

	            put("DEATH_MILKED_LEFT", new Frame[] {
	                    new FrameBuilder(spriteSheet.getSprite(11, 0), 100)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(11, 1), 100)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .build(),
	                    new FrameBuilder(spriteSheet.getSprite(11, 2), -1)
	                            .withScale(3)
	                            .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
	                            .build()
	            });
			}
		};
	}
}