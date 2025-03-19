package org.example.utils;

public class Vector<L,R> {

    private L x;

    private R y;

    public Vector(L x, R y) {
        assert x != null;
        assert y != null;

        this.x = x;
        this.y = y;
    }


    public void setX(L x) {
        this.x = x;
    }

    public void setY(R y) {
        this.y = y;
    }

    public L getX() { return x; }
    public R getY() { return y; }

    @Override
    public int hashCode() { return x.hashCode() ^ y.hashCode(); }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector)) return false;
        Vector vectorO = (Vector) o;
        return this.x.equals(vectorO.getX()) &&
                this.y.equals(vectorO.getY());
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
