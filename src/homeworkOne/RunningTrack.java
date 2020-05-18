package homeworkOne;

public class RunningTrack extends Barrier{
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    String go(Opponent opponent) {
        return opponent.run(length);
    }
}
