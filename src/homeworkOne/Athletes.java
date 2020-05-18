package homeworkOne;

public class Athletes {
    private Opponent[] opponents;
    private StringBuilder results;

    public Athletes(Opponent... opponents) {
        this.opponents = opponents;
        this.results = new StringBuilder();
    }

    public void setResults(String result) { results.append(result).append("\n"); }

    public Opponent[] getOpponents() { return opponents; }

    public void showResults() {
        System.out.println("Results of athletes: ");
        System.out.println();
        System.out.println(results);
    }
}
