package Serialization;

import java.io.Serializable;
import java.util.Objects;

public class SerializingDemo implements Serializable
{
    int a;
    String b;

    public  SerializingDemo(int a, String b){
        this.a=a;
        this.b=b;
    }

    @Override
    public String toString() {
        return "SerializingDemo{" +
                "a=" + a +
                ", b='" + b + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SerializingDemo)) return false;
        SerializingDemo that = (SerializingDemo) o;
        return a == that.a &&
                b.equals(that.b);
    }

    /*@Override*/
    /*public int hashCode() {
        return Objects.hash(a, b);
    }*/
}

