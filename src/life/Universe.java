package life;

public class Universe {
    boolean[][] state;

    public Universe(boolean[][] state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : state) {
            for (boolean b : row) {
                sb.append(b ? 'O' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
