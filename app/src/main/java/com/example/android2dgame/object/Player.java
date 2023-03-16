package com.example.android2dgame.object;

import android.content.Context;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

import com.example.android2dgame.GameLoop;
import com.example.android2dgame.Joystick;
import com.example.android2dgame.R;
import com.example.android2dgame.Utils;

/**
 * Player is the main character of the game, which the user can control with the touch joystick.
 * Player class is an extension of Circle, which is an extension of GameObject.
 */

public class Player extends Circle {

    public static final double SPEED_PIXELS_PER_SECOND = 400.0;
    public static final int MAX_HEALTH_POINTS = 10;
    protected static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;

    private final Joystick joystick;
    private final HealthBar healthBar;
    private HealthBar healthbar;
    private int healthPoints;


    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);

        this.joystick = joystick;
        this.healthBar = new HealthBar(context, this);
        this.healthPoints = MAX_HEALTH_POINTS;
    }

    public void update() {

        // update velocity based on actuator of joystick
        velocityX = joystick.getActuatorX() * MAX_SPEED;
        velocityY = joystick.getActuatorY() * MAX_SPEED;

        // update position
        positionX += velocityX;
        positionY += velocityY;

        // update direction
        if (velocityX != 0 || velocityY != 0) {
            // normalize velocity to get direction (unit vector of velocity)
            double distance = Utils.getDistanceBetweenPoints(0, 0, velocityX, velocityY);
            directionX = velocityX / distance;
            directionY = velocityY / distance;
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);

        healthBar.draw(canvas);
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        // only allow positive values
        if (healthPoints >= 0)
            this.healthPoints = healthPoints;
    }
}
