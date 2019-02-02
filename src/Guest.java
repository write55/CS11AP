/*
Aaron Wu
1/31/19
Guest object class for GuestList, has compare method
 */

public class Guest {

    private String firstName;
    private String lastName;
    private String company;
    private String response;

    // CONSTRUCTOR
    public Guest(String firstName, String lastName, String company, String response) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.response = response;
    }

    // GETTERS
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getResponse() {
        return response;
    }

    // SETTERS
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    // TOSTRING - prints maybe for ? when given
    public String toString() {
        String response = getResponse();
        if (response.equals("?")) {
            response = "maybe";
        }
        return "\nName: " + getLastName() + ", " + getFirstName() + "\nCompany: " + getCompany() + "\nResponse: "
                + response;
    }

    // COMPARE - returns negative if referenced object is lexically lower than argument
    public int compareGuests(Guest compare) {
        int firstValue = this.getFirstName().compareTo(compare.getFirstName());
        int lastValue = this.getLastName().compareTo(compare.getLastName());
        if (lastValue != 0) {
            return lastValue;
        } else if (firstValue != 0) {
            return firstValue;
        } else {
            return 0;
        }
    }

}
