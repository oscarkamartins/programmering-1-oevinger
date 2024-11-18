package propertyRegister;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a register of properties, that can be used to manage a list of properties.
 * Provides methods to add, delete and retreive properties.
 */
public class PropertyRegister {
    private Map<String, Property> propertyRegister;

    /**
     * Constructs an empty property register
     */
    public PropertyRegister() {
        this.propertyRegister = new HashMap<>();
    }

    /**
     * Constructs a property register using a predefined list of properties.
     * 
     * @param propertyList A list of properties 
     */
    public PropertyRegister(List<Property> propertyList) {
        this.propertyRegister = new HashMap<>(propertyList.size());
        
        if (propertyList != null) {
            for (Property property : propertyList) {
                this.propertyRegister.put(property.generateKey(), property);
            }
        }
    }

    /** @return a map of all the properties in the register. */
    public Map<String, Property> getPropertyRegister() {
        return propertyRegister;
    }

    /**
     * Adds a new property to the register.
     * 
     * @param property The property to be added to the register
     */
    public void registerProperty(Property property) {
        propertyRegister.put(property.generateKey(), property);
    }

    /**
     * Deletes a property from the register.
     * 
     * @param property The property to be deleted from the register
     */
    public void deleteProperty(Property property) {
        if (propertyRegister.remove(property.generateKey()) == null) {
            System.err.println("Property not found in register: " + property.generateKey());
        }
    }

    /**
     * Returns the number of properties in the register.
     * 
     * @return The count of properties
     */
    public int getPropertyCount() {
        return propertyRegister.size();
    }

    /**
     * Retrieves a property from the register by its unique key.
     * 
     * @param key Unique key used to identify properties
     * @return The property if found, otherwise null
     */
    public Property getPropertyByKey(String key) {
        if (propertyRegister.containsKey(key)) {
            return propertyRegister.get(key);
        }
        else {
            System.err.println("Property not found in register: " + key);
            return null;
        }
    }

    /**
     * Calculates the mean area of the properties
     * 
     * @return The mean area of the properties, or 0.0 if the register is empty.
     */
    public double meanArea() {
        if (propertyRegister.isEmpty()) {
            return 0.0;
        }
        else {
            return propertyRegister.values().stream()
            .mapToDouble(property -> property.getArea())
            .average().orElse(0.0);
        }
    }

    /**
     * Retrieves a list of all properties with a specified lot number.
     * 
     * @param lotNumber Lot number used to filter through the register
     * @return A list of all the properties with the specified lot number
     */
    public List<Property> getPropertiesByLotNumber(int lotNumber) {
        return propertyRegister.values().stream()
        .filter(property -> property.getLotNumber() == lotNumber)
        .toList();
    }

    @Override
    public String toString() {
        String string = "Properties:";

        for (Property property : propertyRegister.values()) {
            string += property.toString() + "\n";
        }
        
        return string;
    }
}
