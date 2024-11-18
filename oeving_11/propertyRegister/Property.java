package propertyRegister;

/**
 * Represents a property with details such as municipality number, municipality name, lot number, section number, name, area and owner.
 */
public class Property {
    private int municipalityNumber;
    private String municipalityName;
    private int lotNumber;
    private int sectionNumber;
    private String name;
    private double area;
    private String owner;

    /**
     * Constructs a property with specified details.
     * 
     * @param municipalityNumber the municipality number (has to be between 101 and 5054)
     * @param municipalityName the municipality name (non-empty string)
     * @param lotNumber the lot number (positive integer)
     * @param sectionNumber the section number (positive integer)
     * @param name the name of the property (non-empty string, can be null)
     * @param area the area of the property in square meters (positive double)
     * @param owner the owner of the property (non-empty string)
     * @throws IllegalArgumentException if any of the parameters don't meet input requirements
     */

    public Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String owner) {
        if (municipalityNumber < 101 || municipalityNumber > 5054) {
            throw new IllegalArgumentException("municipalityNumber must be between 101 and 5054");
        }
        this.municipalityNumber = municipalityNumber;

        if (municipalityName == null || municipalityName.isEmpty()) {
            throw new IllegalArgumentException("municipalityName must be a non-empty string");
        }
        this.municipalityName = municipalityName;

        if (lotNumber <= 0) {
            throw new IllegalArgumentException("lotNumber must be positive");
        }
        this.lotNumber = lotNumber;

        if (sectionNumber <= 0) {
            throw new IllegalArgumentException("sectionNumber must be positive");
        }
        this.sectionNumber = sectionNumber;

        if (name != null && name.isEmpty()) {
            this.name = null;
        }
        else this.name = name;

        if (area <= 0) {
            throw new IllegalArgumentException("area must be positive");
        }
        this.area = area;

        if (owner == null || owner.isEmpty()) {
            throw new IllegalArgumentException("owner must be a non-empty string");
        }
        this.owner = owner;
    }

    /** @return the municipality number */
    public int getMunicipalityNumber() {
        return municipalityNumber;
    }

    /** @return the municipality name. */
    public String getMunicipalityName() {
        return municipalityName;
    }

    /** @return the lot number. */
    public int getLotNumber() {
        return lotNumber;
    }

    /** @return the section number. */
    public int getSectionNumber() {
        return sectionNumber;
    }

    /** @return the name of the property. */
    public String getName() {
        return name;
    }

    /** @return the area of the property in square meters. */
    public double getArea() {
        return area;
    }

    /** @return the owner of the property. */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the name of the property (null if empty).
     * 
     * @param name new name of the property
     */
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            this.name = null;
        }
        else this.name = name;
    }

    /**
     * Sets the owner of the property.
     * 
     * @param owner new owner of the property
     */
    public void setOwner(String owner) {
        if (owner == null || owner.isEmpty()) {
            throw new IllegalArgumentException("owner must be a non-empty string");
        }
        this.owner = owner;
    }

    /**
     * Generates a unique key for a property.
     * 
     * @return a unique string
     */
    public String generateKey() {
        return municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
    }
    
    @Override
    public String toString() {
        return municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
    }

}