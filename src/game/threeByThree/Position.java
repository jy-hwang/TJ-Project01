package game.threeByThree;

public class Position {
    int vertical;
    int horizontal;

    public Position(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public int getVertical() {
        return vertical;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public void setVertical(int vertical) {
        if (vertical >= 0 && vertical <= 2) {
            this.vertical = vertical;
        } else {
            System.out.println("이동불가");
            return;
        }
    }

    public void setHorizontal(int horizontal) {
        this.horizontal = horizontal;
    }

    void setPosition(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    boolean checkPosition(Position po) {
        if (po.vertical + 1 > 2 || po.vertical - 1 < 0 || po.horizontal + 1 > 2
                || po.horizontal - 1 < 0) {
            return false;
        }
        return true;
    }

    public void showPosition() {
        System.out.println("showPosition");
        System.out.printf("[%d, %d]%n", horizontal, vertical);
    }



}
