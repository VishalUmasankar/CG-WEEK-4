import java.util.*;
import java.util.stream.Collectors;

// PolicyHolder class
class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

// RiskAssessment class
class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return holderId + " - " + name + " | Risk Score: " + String.format("%.2f", riskScore);
    }
}

public class RiskAssessmentSystem {

    // Method to perform the risk assessment
    public static Map<String, List<RiskAssessment>> assessPolicyHolders(List<PolicyHolder> holders) {
        // Step 1: Filter - Life policyholders above age 60
        List<RiskAssessment> assessments = holders.stream()
                .filter(p -> p.policyType.equalsIgnoreCase("Life") && p.age > 60)
                // Step 2: Transform to RiskAssessment object
                .map(p -> new RiskAssessment(p.holderId, p.name, p.premiumAmount / p.age))
                // Step 3: Sort by risk score descending
                .sorted((a, b) -> Double.compare(b.riskScore, a.riskScore))
                .collect(Collectors.toList());

        // Step 4: Categorize into High Risk (> 0.5) and Low Risk (<= 0.5)
        Map<String, List<RiskAssessment>> categorized = new HashMap<>();
        categorized.put("High Risk", new ArrayList<>());
        categorized.put("Low Risk", new ArrayList<>());

        for (RiskAssessment ra : assessments) {
            if (ra.riskScore > 0.5) {
                categorized.get("High Risk").add(ra);
            } else {
                categorized.get("Low Risk").add(ra);
            }
        }

        return categorized;
    }

    // Main method to test
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H001", "Alice", 65, "Life", 40000),
                new PolicyHolder("H002", "Bob", 70, "Health", 30000),
                new PolicyHolder("H003", "Charlie", 68, "Life", 35000),
                new PolicyHolder("H004", "David", 72, "Life", 20000),
                new PolicyHolder("H005", "Eva", 75, "Life", 45000),
                new PolicyHolder("H006", "Frank", 59, "Life", 38000)
        );

        Map<String, List<RiskAssessment>> results = assessPolicyHolders(holders);

        // Display categorized results
        for (String category : results.keySet()) {
            System.out.println(category + ":");
            for (RiskAssessment ra : results.get(category)) {
                System.out.println(" - " + ra);
            }
            System.out.println();
        }
    }
}
