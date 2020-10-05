package com.dbbest.entity;

/**
 * Points entity.
 *
 * @author E.Andreiko
 */
public class Points {
    private String idA;
    private String idB;

    public Points() {
    }

    public String getIdA() {
        return idA;
    }

    public void setIdA(String idA) {
        this.idA = idA;
    }

    public String getIdB() {
        return idB;
    }

    public void setIdB(String idB) {
        this.idB = idB;
    }

    @Override
    public String toString() {
        return "Points{" +
                "idA='" + idA + '\'' +
                ", idB='" + idB + '\'' +
                '}';
    }
}
