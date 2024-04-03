package contacts;



public abstract class Contact  {
    protected String phoneNumber;
    protected String creationTime;
    protected String revisionTime;

    public Contact(String phoneNumber, String creationTime, String revisionTime) {
        this.phoneNumber = phoneNumber;
        this.creationTime = creationTime;
        this.revisionTime = revisionTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getRevisionTime() {
        return revisionTime;
    }

    public void setRevisionTime(String revisionTime) {
        this.revisionTime = revisionTime;
    }

    abstract String info();
}
