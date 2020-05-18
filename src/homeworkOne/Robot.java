package homeworkOne;

public class Robot implements Opponent {
    private String name;
    private int maxDistanceRun;
    private int maxHeightJump;
    private boolean active;

    public Robot(String name) {
        this.name = name;
        this.maxDistanceRun = 2000;
        this.maxHeightJump = 100;
        this.active = true;
    }

    @Override
    public String run(int distance) {
        if (distance <= maxDistanceRun) {
            return (name + " ran well!");
        } else {
            active = false;
            return (name + " couldn't run this distance!");
        }
    }

    @Override
    public String jump(int height) {
        if (height <= maxHeightJump) {
            return (name + " jumped well!");
        } else {
            active = false;
            return (name + " couldn't overcome this height!");
        }
    }

    @Override
    public boolean isOnDistance() { return active; }

    @Override
    public void info() { System.out.println(name + " " + active); }
}
