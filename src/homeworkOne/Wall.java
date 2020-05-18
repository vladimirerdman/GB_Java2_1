package homeworkOne;

public class Wall extends Barrier{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    String go(Opponent opponent) {
        return opponent.jump(height);
    }
}
