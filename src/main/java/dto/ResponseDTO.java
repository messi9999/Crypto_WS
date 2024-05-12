package dto;

import java.util.List;

public class ResponseDTO {
    private String lastUpdateId;
    private List<String[]> bids;
    private List<String[]> asks;

    // Getters and setters
    public String getLastUpdateId() {
        return lastUpdateId;
    }

    public void setLastUpdateId(String lastUpdateId) {
        this.lastUpdateId = lastUpdateId;
    }

    public List<String[]> getBids() {
        return bids;
    }

    public void setBids(List<String[]> bids) {
        this.bids = bids;
    }

    public List<String[]> getAsks() {
        return asks;
    }

    public void setAsks(List<String[]> asks) {
        this.asks = asks;
    }

}
