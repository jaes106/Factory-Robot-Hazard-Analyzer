import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    static double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState) throws RobotSafetyException {
        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }
        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }


        double machineRiskFactor = 0;
        switch (machineryState.toLowerCase()) {
            case "worn" -> machineRiskFactor = 1.3;
            case "faulty" -> machineRiskFactor = 2.0;
            case "critical" -> machineRiskFactor = 3.0;
            default -> {
                throw new RobotSafetyException("Error: Machinery state should be worn, faulty or critical!");
            }
        };
        return ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = sc.nextLine();

        try {
            System.out.println("Hazard Risk Factor: " + calculateHazardRisk(armPrecision, workerDensity, machineryState));
        }
        catch (RobotSafetyException rse){
            System.out.println(rse.getMessage());
        }
        sc.close();
    }
}