public class Test {
    // Sensitive information hardcoded - should be detected by security scanning
    private static final String API_KEY = "AKIAIOSFODNN7EXAMPLE"; // secret
    private static final String PASSWORD = "P@ssw0rd123"; // hardcoded password

    public static void main(String[] args) {
        // Unused variable, sonar issue S1068
        int unused = 42;

        String userInput;
        if (userInput == null) { // Null pointer dereference S2259
            System.out.println("User input is null");
        }

        System.out.println("API Key: " + API_KEY); // Logging of sensitive data S5131
        System.out.println("Password: " + userInput); // Logging of sensitive data S5131

        // Poor exception handling, sonar issue S112
        try {
            riskyOperation();
        } catch (Exception e) {
            // swallow exception
        }

        // Weak cryptography usage SCS001
        String encrypted = weakEncrypt("hello");
        System.out.println(encrypted);

        // Logging of sensitive data S5131
        System.out.println("Password used: " + PASSWORD);

        // Generic catch block S2486
        try {
            anotherRisk();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static void riskyOperation() throws Exception {
        throw new Exception("Something went wrong");
    }

    private static String weakEncrypt(String data) {
        // dummy weak encryption
        return "Encrypted:" + data;
    }

    private static void anotherRisk() {
        // TODO: implement
    }
}
