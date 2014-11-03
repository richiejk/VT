package com.richiejk.voyagetales.models;

/**
 * Created by Richie on 11/3/14.
 */
public class NodeDataModel {
    public int getNodeDataId() {
        return nodeDataId;
    }

    public void setNodeDataId(int nodeDataId) {
        this.nodeDataId = nodeDataId;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNodeDataName() {
        return nodeDataName;
    }

    public void setNodeDataName(String nodeDataName) {
        this.nodeDataName = nodeDataName;
    }

    public String getNodeDataDescription() {
        return nodeDataDescription;
    }

    public void setNodeDataDescription(String nodeDataDescription) {
        this.nodeDataDescription = nodeDataDescription;
    }

    public NodeDataModel(int nodeDataId, int nodeId, int userId, int tripId, int status, String nodeDataName, String nodeDataDescription) {
        this.nodeDataId = nodeDataId;
        this.nodeId = nodeId;
        this.userId = userId;
        this.tripId = tripId;
        this.status = status;
        this.nodeDataName = nodeDataName;
        this.nodeDataDescription = nodeDataDescription;
    }

    int nodeDataId;
    int nodeId;
    int userId;
    int tripId;
    int status;
    String nodeDataName;
    String nodeDataDescription;

}
