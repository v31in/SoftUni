package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician {
    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setMagic(magic);
        isAlive = true;
    }

    @Override
    public void takeDamage(int points) {
        //takeDamage() method decreases the Magician's protection and health.
        // First, you need to reduce the protection.
        // If the protection reaches 0, transfer the damage to health points.
        // If the health points are less than or equal to zero, the magician is dead.
        this.protection -= points;
        if (this.protection < 0){
            health += this.protection;
        }
        if (health <= 0){
            isAlive = false;
        }
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    public void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    public void setAlive(boolean alive) {
        isAlive = health > 0;
    }

    public void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %s%n" +
                        "Health: %d%n" +
                        "Protection: %d%n" +
                        "Magic: %s%n",
                getClass().getSimpleName(), getUsername(), getHealth(), getProtection(), getMagic().getName());
    }
}
