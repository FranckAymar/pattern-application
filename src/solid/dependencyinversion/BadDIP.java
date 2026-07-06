package solid.dependencyinversion;

/**
 * BAD: Dependency Inversion Principle Violation
 * High-level module (PaymentProcessor) depends on low-level module (CreditCardPayment)
 * This creates tight coupling and makes testing difficult
 */

// Low-level module: specific payment method
class CreditCardPayment {
    public void processCreditCard(String cardNumber, double amount) {
        System.out.println("Processing credit card: " + cardNumber);
        System.out.println("Amount: $" + amount);
    }
}

// Low-level module: another payment method
class PayPalPayment {
    public void processPayPal(String email, double amount) {
        System.out.println("Processing PayPal: " + email);
        System.out.println("Amount: $" + amount);
    }
}

// High-level module: depends directly on low-level modules
class BadPaymentProcessor {
    private CreditCardPayment creditCardPayment;
    private PayPalPayment paypalPayment;

    public BadPaymentProcessor() {
        this.creditCardPayment = new CreditCardPayment();
        this.paypalPayment = new PayPalPayment();
    }

    public void processPayment(String paymentMethod, String details, double amount) {
        if (paymentMethod.equals("creditcard")) {
            creditCardPayment.processCreditCard(details, amount);
        } else if (paymentMethod.equals("paypal")) {
            paypalPayment.processPayPal(details, amount);
        }
        // Hard to extend, hard to test, tight coupling!
    }
}

class BadDIP {
    public static void main(String[] args) {
        BadPaymentProcessor processor = new BadPaymentProcessor();
        processor.processPayment("creditcard", "1234-5678-9012-3456", 99.99);
        processor.processPayment("paypal", "user@example.com", 49.99);
    }
}
