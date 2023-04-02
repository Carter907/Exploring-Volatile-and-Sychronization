package org.example.volatilepack;

public class VolatileData {
    private String str = "";

    public int getStringLength() {

        return str.length();

    }

    public void increaseString() {


        str+="x";

        //increases the value of counter by 1
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof VolatileData other) {
            return other.str.equals(this.str);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Data: " + this.str;
    }
}