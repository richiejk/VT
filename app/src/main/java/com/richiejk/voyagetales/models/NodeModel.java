package com.richiejk.voyagetales.models;

/**
 * Created by Richie on 11/3/14.
 */
public class NodeModel {
    int nodeId;
    int userId;
    int tripId;
    LocationModel nodeFrom;
    LocationModel nodeTo;
    String nodeStartDate;
    String nodeEndDate;
    LocationModel nodeAt;
    String nodeDescription;
    int nodeType;
    int startPointer;
    int nextPointer;
    int status;

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public LocationModel getNodeFrom() {
        return nodeFrom;
    }

    public void setNodeFrom(LocationModel nodeFrom) {
        this.nodeFrom = nodeFrom;
    }

    public LocationModel getNodeTo() {
        return nodeTo;
    }

    public void setNodeTo(LocationModel nodeTo) {
        this.nodeTo = nodeTo;
    }

    public String getNodeStartDate() {
        return nodeStartDate;
    }

    public void setNodeStartDate(String nodeStartDate) {
        this.nodeStartDate = nodeStartDate;
    }

    public String getNodeEndDate() {
        return nodeEndDate;
    }

    public void setNodeEndDate(String nodeEndDate) {
        this.nodeEndDate = nodeEndDate;
    }

    public LocationModel getNodeAt() {
        return nodeAt;
    }

    public void setNodeAt(LocationModel nodeAt) {
        this.nodeAt = nodeAt;
    }

    public String getNodeDescription() {
        return nodeDescription;
    }

    public void setNodeDescription(String nodeDescription) {
        this.nodeDescription = nodeDescription;
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public int getStartPointer() {
        return startPointer;
    }

    public void setStartPointer(int startPointer) {
        this.startPointer = startPointer;
    }

    public int getNextPointer() {
        return nextPointer;
    }

    public void setNextPointer(int nextPointer) {
        this.nextPointer = nextPointer;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public NodeModel(int nodeId, int userId, int tripId, LocationModel nodeFrom, LocationModel nodeTo, String nodeStartDate, String nodeEndDate, LocationModel nodeAt, String nodeDescription, int nodeType, int startPointer, int nextPointer, int status) {
        this.nodeId = nodeId;
        this.userId = userId;
        this.tripId = tripId;
        this.nodeFrom = nodeFrom;
        this.nodeTo = nodeTo;
        this.nodeStartDate = nodeStartDate;
        this.nodeEndDate = nodeEndDate;
        this.nodeAt = nodeAt;
        this.nodeDescription = nodeDescription;
        this.nodeType = nodeType;
        this.startPointer = startPointer;
        this.nextPointer = nextPointer;
        this.status = status;
    }
}
