import java.util.*;
import java.util.stream.Collectors;

// Claim class
class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    Date claimDate;
    String status;

    public Claim(String claimId, String policyNumber, double claimAmount, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

// Aggregated Result class
class PolicyClaimSummary {
    String policyNumber;
    double totalAmount;
    double averageAmount;

    public PolicyClaimSummary(String policyNumber, double totalAmount, double averageAmount) {
        this.policyNumber = policyNumber;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    @Override
    public String toString() {
        return "Policy: " + policyNumber +
                ", Total: $" + totalAmount +
                ", Average: $" + averageAmount;
    }
}

public class ClaimsAnalysis {

    // Method to analyze claims and return top 3 policies
    public static List<PolicyClaimSummary> analyzeClaims(List<Claim> claims) {
        // Step 1: Filter claims with status "Approved" and amount > 5000
        List<Claim> filteredClaims = claims.stream()
                .filter(c -> c.status.equalsIgnoreCase("Approved") && c.claimAmount > 5000)
                .collect(Collectors.toList());

        // Step 2: Group by policyNumber
        Map<String, List<Claim>> groupedByPolicy = filteredClaims.stream()
                .collect(Collectors.groupingBy(c -> c.policyNumber));

        // Step 3: Aggregate total and average claimAmount per policy
        List<PolicyClaimSummary> summaries = new ArrayList<>();
        for (Map.Entry<String, List<Claim>> entry : groupedByPolicy.entrySet()) {
            String policyNumber = entry.getKey();
            List<Claim> policyClaims = entry.getValue();
            double total = policyClaims.stream().mapToDouble(c -> c.claimAmount).sum();
            double average = total / policyClaims.size();
            summaries.add(new PolicyClaimSummary(policyNumber, total, average));
        }

        // Step 4: Sort and get top 3 by totalAmount
        return summaries.stream()
                .sorted((a, b) -> Double.compare(b.totalAmount, a.totalAmount))
                .limit(3)
                .collect(Collectors.toList());
    }

    // Helper method to create sample Date
    public static Date createDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day); // Month is 0-indexed
        return cal.getTime();
    }

    // Main method to test
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "P1001", 6000.0, createDate(2024, 1, 10), "Approved"),
                new Claim("C002", "P1002", 8000.0, createDate(2024, 2, 15), "Approved"),
                new Claim("C003", "P1001", 7000.0, createDate(2024, 3, 12), "Approved"),
                new Claim("C004", "P1003", 4000.0, createDate(2024, 4, 5), "Pending"),
                new Claim("C005", "P1002", 9500.0, createDate(2024, 5, 20), "Approved"),
                new Claim("C006", "P1004", 10000.0, createDate(2024, 6, 25), "Approved"),
                new Claim("C007", "P1001", 3000.0, createDate(2024, 7, 30), "Rejected")
        );

        List<PolicyClaimSummary> topPolicies = analyzeClaims(claims);

        // Display results
        System.out.println("Top 3 Policies by Total Claim Amount:");
        for (PolicyClaimSummary summary : topPolicies) {
            System.out.println(summary);
        }
    }
}
