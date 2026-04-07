// Product class
public class House {
    private int windows;
    private int doors;
    private String roof;
    private boolean hasGarage;
    private boolean hasPool;
    private boolean hasGarden;
    
    // Private constructor - only Builder can create instances
    private House(HouseBuilder builder) {
        this.windows = builder.windows;
        this.doors = builder.doors;
        this.roof = builder.roof;
        this.hasGarage = builder.hasGarage;
        this.hasPool = builder.hasPool;
        this.hasGarden = builder.hasGarden;
    }
    
    // Static nested Builder class
    public static class HouseBuilder {
        // Required parameters
        private int windows;
        private int doors;
        
        // Optional parameters with defaults
        private String roof = "Standard";
        private boolean hasGarage = false;
        private boolean hasPool = false;
        private boolean hasGarden = false;
        
        // Constructor with required parameters
        public HouseBuilder(int windows, int doors) {
            this.windows = windows;
            this.doors = doors;
        }
        
        // Fluent methods for optional parameters
        public HouseBuilder withRoof(String roof) {
            this.roof = roof;
            return this;
        }
        
        public HouseBuilder withGarage() {
            this.hasGarage = true;
            return this;
        }
        
        public HouseBuilder withPool() {
            this.hasPool = true;
            return this;
        }
        
        public HouseBuilder withGarden() {
            this.hasGarden = true;
            return this;
        }
        
        // Build method returns the final object
        public House build() {
            return new House(this);
        }
    }
}
//=================================================
// Simple house
House basicHouse = new House.HouseBuilder(4, 2)
    .build();

// Luxury house with everything
House luxuryHouse = new House.HouseBuilder(10, 4)
    .withRoof("Slate")
    .withGarage()
    .withPool()
    .withGarden()
    .build();

// Custom combination
House customHouse = new House.HouseBuilder(6, 3)
    .withGarage()
    .withGarden()
    .build();
