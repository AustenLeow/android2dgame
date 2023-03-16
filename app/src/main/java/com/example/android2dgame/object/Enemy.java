package com.example.android2dgame.object;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.android2dgame.GameLoop;
import com.example.android2dgame.R;

/**
 * Enemy is a character which always moves in the direction of the player.
 */

public class Enemy extends Circle {

    private static final double SPEED_PIXELS_PER_SECOND = Player.SPEED_PIXELS_PER_SECOND * 0.6;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private final Player player;

    public Enemy(Context context, Player player, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.enemy), positionX, positionY, radius);

        this.player = player;
    }

    @Override
    public void update() {
        /////////////////// update velocity of enemy so that velocity is in direction of player ///////////////////////////////////////////////

        // calculate vector from enemy to player (in x and y)
        double distanceToPlayerX = player.getPositionX() - positionX;
        double distanceToPlayerY = player.getPositionY() - positionY;

        // calculate (absolute) distance between enemy (this) and player
        double distanceToPlayer = GameObject.getDistanceBetweenObjects(this, player);

        // calculate direction from enemy to player
        double directionX = distanceToPlayerX / distanceToPlayer;
        double directionY = distanceToPlayerY / distanceToPlayer;

        // set velocity in direction of player
        if (distanceToPlayer > 0) {
            velocityX = directionX * MAX_SPEED;
            velocityY = directionY * MAX_SPEED;
        }

        // update the position of the enemy
        positionX += velocityX;
        positionY += velocityY;

    }
}
