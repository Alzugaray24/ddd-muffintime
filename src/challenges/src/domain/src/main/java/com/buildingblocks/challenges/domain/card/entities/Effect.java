// Effect.java
package com.buildingblocks.challenges.domain.card.entities;

import com.buildingblocks.challenges.domain.card.values.*;
import com.buildingblocks.challenges.domain.player.values.IsActive;
import com.buildingblocks.shared.domain.generic.Entity;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Effect extends Entity<EffectId> {

    private Title name;
    private Description description;
    private TypeEffect type;
    private Duration duration;
    private IsActive active;

    public Effect(EffectId identity, Title name, Description description, TypeEffect type, Duration duration, IsActive active) {
        super(identity);
        this.name = name;
        this.description = description;
        this.type = type;
        this.duration = duration;
        this.active = active;
    }

    public Effect(Title name, Description description, TypeEffect type, Duration duration, IsActive active) {
        super(new EffectId());
        this.name = name;
        this.description = description;
        this.type = type;
        this.duration = duration;
        this.active = active;
    }

    public Title getName() {
        return name;
    }

    public void setName(Title name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public TypeEffect getType() {
        return type;
    }

    public void setType(TypeEffect type) {
        this.type = type;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public IsActive getActive() {
        return active;
    }

    public void setActive(IsActive active) {
        this.active = active;
    }

    public void activate() {
        if (active.getValue()) {
            throw new IllegalArgumentException("Effect already active");
        } else {
            if (duration.getValue() > 0) {
                active = IsActive.of(true);
                applyEffect();
                scheduleDeactivation();
            } else {
                throw new IllegalArgumentException("Effect duration is 0");
            }
        }
    }

    private void applyEffect() {
        switch (type) {
            case ROBAR_CARTAS:
                System.out.println("Applying effect: Draw cards");
                break;
            case BLOQUEAR_JUGADOR:
                System.out.println("Applying effect: Block player");
                break;
            case INTERCAMBIAR_MUFFINS:
                System.out.println("Applying effect: Exchange muffins");
                break;
            case ACTIVAR_ABSURDO:
                System.out.println("Applying effect: Activate absurd");
                break;
            case TRAMPA:
                System.out.println("Applying effect: Trap");
                break;
            default:
                throw new IllegalArgumentException("Invalid effect type");
        }
    }

    private void scheduleDeactivation() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        long durationMillis = duration.getValue();
        scheduler.schedule(this::deactivate, durationMillis, TimeUnit.MILLISECONDS);
    }

    public void deactivate() {
        if (!active.getValue()) {
            throw new IllegalArgumentException("Effect already deactivated");
        } else {
            active = IsActive.of(false);
        }
    }
}