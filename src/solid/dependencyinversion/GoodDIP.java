package solid.dependencyinversion;

/**
 * GOOD: Dependency Inversion Principle
 * High-level module depends on abstraction (interface)
 * Low-level modules depend on the same abstraction
 * This achieves loose coupling and improves testability
 */

// Abstraction: high-level module depends on this
interface PaymentMethod {
    void pay(double amount);
}

// Low-level module: credit card
class GoodCreditCardPayment implements PaymentMethod {
    private String cardNumber;

    public GoodCreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card: " + cardNumber);
        System.out.println("Amount: $" + amount);
    }
}

// Low-level module: PayPal
class GoodPayPalPayment implements PaymentMethod {
    private String email;

    public GoodPayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal: " + email);
        System.out.println("Amount: $" + amount);
    }
}

// Low-level module: Bitcoin (new payment method - no changes to PaymentProcessor!)
class BitcoinPayment implements PaymentMethod {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Bitcoin: " + walletAddress);
        System.out.println("Amount: " + amount + " BTC");
    }
}

// High-level module: depends on abstraction, not concrete implementations
class GoodPaymentProcessor {
    private PaymentMethod paymentMethod;

    // Dependency injection via constructor
    public GoodPaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}

class GoodDIP {
    public static void main(String[] args) {
        // Easy to swap implementations
        PaymentMethod creditCard = new GoodCreditCardPayment("1234-5678-9012-3456");
        GoodPaymentProcessor processor1 = new GoodPaymentProcessor(creditCard);
        processor1.processPayment(99.99);

        PaymentMethod paypal = new GoodPayPalPayment("user@example.com");
        GoodPaymentProcessor processor2 = new GoodPaymentProcessor(paypal);
        processor2.processPayment(49.99);

        PaymentMethod bitcoin = new BitcoinPayment("1A1z7agoat2BYJU2...");
        GoodPaymentProcessor processor3 = new GoodPaymentProcessor(bitcoin);
        processor3.processPayment(0.05);

        // Easy to test: just pass a mock implementation!
    }
}
