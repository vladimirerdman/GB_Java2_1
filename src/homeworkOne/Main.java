package homeworkOne;

public class Main {

    public static void main(String[] args) {
        Track track = new Track(new RunningTrack(2000), new Wall(200));
        Athletes athletes = new Athletes(new Human("Quasimodo"), new Cat("Bob"), new Robot("Siri"));
        track.go(athletes);
        athletes.showResults();
    }
}
