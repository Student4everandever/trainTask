package model;

enum CarriagesTypes {

    LUXURY(18, 0),
    COMPARTMENT(36, 0),
    STANDARD (54, 0),
    SITTING (81, 0),
    BIG_BAGGAGE(0, 48),
    SMALL_BAGGAGE(0, 72);


    public final int peopleCount;
    private final int baggageCount;

    CarriagesTypes(int peopleCount, int baggageCount) {
        this.peopleCount = peopleCount;
        this.baggageCount = baggageCount;
    }

    public int peopleCount() { return peopleCount; }
    public int baggageCount() { return baggageCount; }
 }
