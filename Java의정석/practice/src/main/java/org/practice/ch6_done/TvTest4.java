package org.practice.ch6_done;


class Tv{
    String color;
    boolean power;
    int channel;

    void power() {
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }
}
public class TvTest4 {
    public static void main(String[] args) {
        Tv[] tvArr = new Tv[3]; //길이가 3인 TV객체 배열
        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i] = new Tv();
            tvArr[i].channel = i + 10;
        }

        for (int i=0; i< tvArr.length; i++){
            tvArr[i].channelUp();
            System.out.printf("tvArr[%d].channel=%d\n",i ,tvArr[i].channel);
        }

    }

}
