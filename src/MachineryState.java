public enum MachineryState {
    WORN(1.3),
    FAULTY(2.0),
    CRITICAL(3.0);

    private final double riskFactor;

    MachineryState(double riskFactor) {
        this.riskFactor = riskFactor;
    }

    public double getRiskFactor() {
        return riskFactor;
    }

    public static MachineryState fromString(String input)
            throws RobotSafetyException {
        try {
            return MachineryState.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RobotSafetyException(
                    "Error: Machinery state should be worn, faulty or critical!"
            );
        }
    }
}
