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
    String blockDescription;
    String blockStartDateTime;
    String blockEndDateTime;
    int blockType;
    String tripKey;
    String travelFrom;
    String travelTo;

    int status;
    String blockDate;
    FriendModel user;
    boolean isSelf;
    int tripId;


    public BlockModel(String blockTitle, String blockLatitude, String blockLongitude, String blockLocation, String blockDescription, String blockStartDateTime, int blockType, String tripKey, int status, int tripId) {
        this.blockTitle = blockTitle;
        this.blockLatitude = blockLatitude;
        this.blockLongitude = blockLongitude;
        this.blockLocation = blockLocation;
        this.blockDescription = blockDescription;
        this.blockStartDateTime = blockStartDateTime;
        this.blockType = blockType;
        this.tripKey = tripKey;
        this.status = status;
        this.tripId = tripId;
    }

    public BlockModel(String travelFrom, String blockLatitude, String blockLongitude,  String blockDescription, String blockStartDateTime, int blockType, String tripKey, int status,String travelTo, int tripId) {
        this.travelFrom = travelFrom;
        this.blockLatitude = blockLatitude;
        this.blockLongitude = blockLongitude;
        this.travelTo = travelTo;
        this.blockDescription = blockDescription;
        this.blockStartDateTime = blockStartDateTime;
        this.blockType = blockType;
        this.tripKey = tripKey;
        this.status = status;
        this.tripId = tripId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BlockModel(int blockId, String blockTitle, String blockLongitude, String blockLatitude, String blockLocation, String blockDescription, String blockStartDateTime, String blockEndDateTime, int blockType, String tripKey, String travelFrom, String travelTo, int tripId, int status) {
        this.blockId = blockId;
        this.blockTitle = blockTitle;
        this.blockLongitude = blockLongitude;
        this.blockLatitude = blockLatitude;
        this.blockLocation = blockLocation;
        this.blockDescription = blockDescription;
        this.blockStartDateTime = blockStartDateTime;
        this.blockEndDateTime = blockEndDateTime;
        this.blockType = blockType;
        this.tripKey = tripKey;
        this.travelFrom = travelFrom;
        this.travelTo = travelTo;
        this.tripId = tripId;
        this.status = status;
    }

    public BlockModel(int blockId, String blockTitle, String blockLatitude, String blockLongitude, String blockLocation, String blockDescription, String blockStartDateTime, String blockEndDateTime, int blockType, String tripKey, String travelFrom, String travelTo, String blockDate, FriendModel user, boolean isSelf, int tripId,int status) {
        this.blockId = blockId;
        this.blockTitle = blockTitle;
        this.blockLatitude = blockLatitude;
        this.blockLongitude = blockLongitude;
        this.blockLocation = blockLocation;
        this.blockDescription = blockDescription;
        this.blockStartDateTime = blockStartDateTime;
        this.blockEndDateTime = blockEndDateTime;
        this.blockType = blockType;
        this.tripKey = tripKey;
        this.travelFrom = travelFrom;
        this.travelTo = travelTo;
        this.blockDate = blockDate;
        this.user = user;
        this.isSelf = isSelf;
        this.tripId = tripId;
        this.status=status;
    }

    public String getTravelTo() {
        return travelTo;
    }

    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    }

    public String getTravelFrom() {
        return travelFrom;
    }

    public void setTravelFrom(String travelFrom) {
        this.travelFrom = travelFrom;
    }

    public String getBlockDescription() {
        return blockDescription;
    }

    public void setBlockDescription(String blockDescription) {
        this.blockDescription = blockDescription;
    }

    public String getBlockStartDateTime() {
        return blockStartDateTime;
    }

    public void setBlockStartDateTime(String blockStartDateTime) {
        this.blockStartDateTime = blockStartDateTime;
    }

    public String getBlockEndDateTime() {
        return blockEndDateTime;
    }

    public void setBlockEndDateTime(String blockEndDateTime) {
        this.blockEndDateTime = blockEndDateTime;
    }

    public int getBlockType() {
        return blockType;
    }

    public void setBlockType(int blockType) {
        this.blockType = blockType;
    }

    public String getTripKey() {
        return tripKey;
    }

    public void setTripKey(String tripKey) {
        this.tripKey = tripKey;
    }

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
