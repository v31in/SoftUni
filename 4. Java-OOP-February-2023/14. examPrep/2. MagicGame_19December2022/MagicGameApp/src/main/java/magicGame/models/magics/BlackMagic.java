package magicGame.models.magics;

public class BlackMagic extends MagicImpl {
    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    private int bullets = getBulletsCount();

    @Override
    public int fire() {
        if (bullets - 1 < 0) {
            bullets = 0;
            return 0;
        } else {
            bullets -= 1;
            return 1;
        }
    }
}
