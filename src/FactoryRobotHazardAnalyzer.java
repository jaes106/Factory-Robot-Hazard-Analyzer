import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            MachineryState machineryState
    ) throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0–1.0"
            );
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1–20"
            );
        }

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineryState.getRiskFactor());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryInput = sc.nextLine();

        try {
            MachineryState machineryState =
                    MachineryState.fromString(machineryInput);

            double hazardRisk =
                    calculateHazardRisk(
                            armPrecision,
                            workerDensity,
                            machineryState
                    );

            System.out.printf("Hazard Risk Factor: %.2f%n", hazardRisk );

        } catch (RobotSafetyException rse) {
            System.out.println(rse.getMessage());
        }
        sc.close();
    }
}
