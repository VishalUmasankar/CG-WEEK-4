import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    private String transactionId;
    private String policyNumber;
    private double amount;
    private Date transactionDate;
    private boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, Date transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", isFraudulent=" + isFraudulent +
                '}';
    }
}

public class FraudDetection {

    public static void detectFraud(List<Transaction> transactions) {
        // Step 1: Filter
        List<Transaction> filtered = transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
                .collect(Collectors.toList());

        // Step 2: Group by policyNumber
        Map<String, List<Transaction>> groupedByPolicy = filtered.stream()
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        // Step 3 & 4: Aggregate and Alert
        for (Map.Entry<String, List<Transaction>> entry : groupedByPolicy.entrySet()) {
            String policyNumber = entry.getKey();
            List<Transaction> fraudList = entry.getValue();

            int count = fraudList.size();
            double totalAmount = fraudList.stream().mapToDouble(Transaction::getAmount).sum();

            if (count > 5 || totalAmount > 50000) {
                System.out.println("⚠️ ALERT: Policy " + policyNumber +
                        " has " + count + " high-value fraudulent transactions " +
                        " totaling $" + totalAmount);
            }
        }
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("TXN001", "POL123", 15000, new Date(), true),
                new Transaction("TXN002", "POL123", 20000, new Date(), true),
                new Transaction("TXN003", "POL123", 12000, new Date(), true),
                new Transaction("TXN004", "POL123", 30000, new Date(), true),
                new Transaction("TXN005", "POL123", 8000, new Date(), true),   // Not selected (amount < 10,000)
                new Transaction("TXN006", "POL123", 14000, new Date(), true),
                new Transaction("TXN007", "POL123", 17000, new Date(), true),
                new Transaction("TXN008", "POL999", 55000, new Date(), true),
                new Transaction("TXN009", "POL999", 5000, new Date(), true),   // Not selected (amount < 10,000)
                new Transaction("TXN010", "POL888", 30000, new Date(), false)  // Not selected (not fraudulent)
        );

        detectFraud(transactions);
    }
}
