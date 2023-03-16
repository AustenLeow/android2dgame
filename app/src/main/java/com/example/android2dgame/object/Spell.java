package com.example.android2dgame.object;

import static com.example.android2dgame.object.Player.MAX_SPEED;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.example.android2dgame.R;

public class Spell extends Circle {
    public Spell(Context context, Player spellcaster) {
        super(
                context,
                ContextCompat.getColor(context, R.color.spell),
                spellcaster.getPositionX(),
                spellcaster.getPositionY(),
                25
        );

        velocityX = spellcaster.getDirectionX() * MAX_SPEED;
        velocityY = spellcaster.getDirectionY() * MAX_SPEED;

    }

    public void update() {
        positionX += velocityX;
        positionY += velocityY;
    }
}
