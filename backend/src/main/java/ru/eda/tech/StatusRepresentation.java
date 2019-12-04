package ru.eda.tech;

public class StatusRepresentation {
    private final int statuscode;
    private final String reasonphrase;
    private final String body;

    public StatusRepresentation(int statuscode, String reasonphrase, String body){
        this.statuscode = statuscode;
        this.reasonphrase = reasonphrase;
        this.body = body;
    }

    public int getStatuscode(){
        return statuscode;
    }
    public String getReasonphrase(){
        return reasonphrase;
    }
    public String getBody(){
        return body;
    }
}
