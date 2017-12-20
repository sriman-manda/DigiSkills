package framework;

public class CarDataStructure {
    private String registrationNumber;
    private String colour;
    private String make;

    public CarDataStructure(String registrationNumber, String colour, String make) {
        this.registrationNumber = registrationNumber;
        this.colour = colour;
        this.make = make;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public String getMake() {
        return make;
    }
}
