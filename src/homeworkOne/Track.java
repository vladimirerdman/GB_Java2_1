package homeworkOne;

public class Track {
    private Barrier[] barriers;

    public Track(Barrier... barriers) { this.barriers = barriers; }

    void go(Athletes athletes) {
        Opponent[] opponents = athletes.getOpponents();
        if (opponents.length == 0) {
            System.out.println("You don't have any athlete on the track");
            return;
        }
        for (Opponent opponent: opponents) {
            for (Barrier barrier: barriers) {
                athletes.setResults(barrier.go(opponent));
                if (!opponent.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
