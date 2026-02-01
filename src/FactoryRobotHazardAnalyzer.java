import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Arm Precision (0.0 - 1.0):");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density (1 - 20):");
        int workerDensity = sc.nextInt();

        sc.nextLine();
        System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
        String machineryState = sc.nextLine();

        double machineRiskFactor = switch (machineryState.toLowerCase()) {
            case "worn" -> 1.3;
            case "faulty" -> 2.0;
            case "critical" -> 3.0;
            default -> 0;
        };

        double hazardRisk =  ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);

        System.out.println("Hazard Risk Factor: " + hazardRisk);

        sc.close();
    }
}
