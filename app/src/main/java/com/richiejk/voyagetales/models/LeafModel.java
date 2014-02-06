package com.richiejk.voyagetales.models;

/**
 * Created by richie on 2/6/14.
 */
public class LeafModel {
    int leafId;
    int blockId;
    int tripId;
    int leafType;
    String leafName;

    public LeafModel(int leafId, int blockId, int tripId, int leafType, String leafName) {
        this.leafId = leafId;
        this.blockId = blockId;
        this.tripId = tripId;
        this.leafType = leafType;
        this.leafName = leafName;
    }

    public int getLeafId() {
        return leafId;
    }

    public void setLeafId(int leafId) {
        this.leafId = leafId;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getLeafType() {
        return leafType;
    }

    public void setLeafType(int leafType) {
        this.leafType = leafType;
    }

    public String getLeafName() {
        return leafName;
    }

    public void setLeafName(String leafName) {
        this.leafName = leafName;
    }
}
