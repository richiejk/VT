package com.richiejk.voyagetales.models;

/**
 * Created by richie on 2/6/14.
 */
public class BlockModel {
    int blockId;
    String blockTitle;
    String blockLatitude;
    String blockLongitude;
    String blockLocation;
    String blockDate;
    FriendModel user;
    boolean isSelf;
    int tripId;

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public int getBlockId() {
        return blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public String getBlockTitle() {
        return blockTitle;
    }

    public void setBlockTitle(String blockTitle) {
        this.blockTitle = blockTitle;
    }

    public String getBlockLatitude() {
        return blockLatitude;
    }

    public void setBlockLatitude(String blockLatitude) {
        this.blockLatitude = blockLatitude;
    }

    public String getBlockLongitude() {
        return blockLongitude;
    }

    public void setBlockLongitude(String blockLongitude) {
        this.blockLongitude = blockLongitude;
    }

    public String getBlockLocation() {
        return blockLocation;
    }

    public void setBlockLocation(String blockLocation) {
        this.blockLocation = blockLocation;
    }

    public String getBlockDate() {
        return blockDate;
    }

    public void setBlockDate(String blockDate) {
        this.blockDate = blockDate;
    }

    public FriendModel getUser() {
        return user;
    }

    public void setUser(FriendModel user) {
        this.user = user;
    }

    public boolean isSelf() {
        return isSelf;
    }

    public void setSelf(boolean isSelf) {
        this.isSelf = isSelf;
    }

    public BlockModel(int tripId,int blockId, String blockTitle, String blockLatitude, String blockLongitude, String blockLocation, String blockDate, FriendModel user, boolean isSelf) {
        this.blockId = blockId;
        this.blockTitle = blockTitle;
        this.blockLatitude = blockLatitude;
        this.blockLongitude = blockLongitude;
        this.blockLocation = blockLocation;
        this.blockDate = blockDate;
        this.user = user;
        this.isSelf = isSelf;
        this.tripId=tripId;
    }
}
