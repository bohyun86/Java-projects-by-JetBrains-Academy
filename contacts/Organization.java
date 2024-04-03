package contacts;

public class Organization extends Contact{
    private String organizationName;
    private String address;

    public Organization(String organizationName, String address, String phoneNumber
            , String creationTime, String revisionTime) {
        super(phoneNumber, creationTime, revisionTime);
        this.organizationName = organizationName;
        this.address = address;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public  String toString() {
        return "Organization name: " + this.organizationName + "\n" +
                "Address: " + this.address + "\n" +
                "Number: " + this.phoneNumber + "\n" +
                "Time created: " + this.creationTime + "\n" +
                "Time last edit: " + this.revisionTime + "\n";
    }


    @Override
    String info() {
        return String.format("%s", this.organizationName);
    }


}
