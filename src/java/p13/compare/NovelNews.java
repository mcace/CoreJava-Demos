package p13.compare;

/**
 * Created by Mc on 2016/12/1.
 */
public class NovelNews implements Comparable {
    private int heat;

    public NovelNews(int heat) {
        this.heat = heat;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    @Override
    public String toString() {
        return String.valueOf(heat);
    }

    @Override
    public int compareTo(Object o) {
        NovelNews o1 = (NovelNews) o;
        return heat - o1.heat;
    }
}
