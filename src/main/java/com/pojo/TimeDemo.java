package com.pojo;

public class TimeDemo {
    long d;
    long s;
    long m;
    long h;

    public long getD() {
        return d;
    }

    public void setD(long d) {
        this.d = d;
    }

    public long getS() {
        return s;
    }

    public void setS(long s) {
        this.s = s;
    }

    public long getM() {
        return m;
    }

    public void setM(long m) {
        this.m = m;
    }

    public long getH() {
        return h;
    }

    public void setH(long h) {
        this.h = h;
    }

    @Override
    public String toString() {
        return "TimeDemo{" +
                "d=" + d +
                ", s=" + s +
                ", m=" + m +
                ", h=" + h +
                '}';
    }

    public TimeDemo(long d, long s, long m, long h) {
        this.d = d;
        this.s = s;
        this.m = m;
        this.h = h;
    }
}
