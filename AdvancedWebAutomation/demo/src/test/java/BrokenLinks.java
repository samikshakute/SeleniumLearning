import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, NoSuchAlgorithmException, KeyManagementException {
        // --- SSL Configuration (For Testing Only) ---
        // Create a TrustManager that trusts all SSL certificates to bypass SSL verification
        // WARNING: This is insecure and should only be used in a non-production environment
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                // Return null to indicate no specific trusted issuers
                public X509Certificate[] getAcceptedIssuers() { return null; }
                // Skip client certificate validation
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                // Skip server certificate validation
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };

        // Initialize an SSLContext with the trust-all configuration
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());

        // --- HTTP Client Setup ---
        // Create an HttpClient instance for sending HTTP requests
        // Configure it to use the custom SSL context (for testing) and follow redirects
        HttpClient client = HttpClient.newBuilder()
                .sslContext(sc) // Remove this line in production; use a proper trust store instead
                .followRedirects(HttpClient.Redirect.NORMAL) // Follow HTTP redirects automatically
                .build();

        // --- Selenium WebDriver Setup ---
        // Initialize ChromeDriver to interact with the Chrome browser
        WebDriver driver = new ChromeDriver();
        // Navigate to the target webpage for link extraction
        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        // --- Link Extraction ---
        // Find all anchor elements (<a>) within list items with class 'gf-li'
        // These elements contain the URLs to be checked
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        // --- Soft Assertions ---
        // Initialize SoftAssert to collect all assertion failures and report them at the end
        SoftAssert a = new SoftAssert();

        // --- Link Validation Loop ---
        // Iterate through each link element to check if the associated URL is valid
        for (WebElement link : links) {
            // Extract the 'href' attribute from the link element
            String url = link.getDomAttribute("href");
            // Log the URL being checked for debugging
            System.out.println("Checking URL: " + url);

            // --- Handle Relative URLs ---
            // Check if the URL is relative (does not start with 'http')
            if (!url.startsWith("http")) {
                // Get the base URL of the current page
                URI baseUri = new URI(driver.getCurrentUrl());
                // Resolve the relative URL against the base URL to form an absolute URL
                url = baseUri.resolve(url).toString();
            }

            // --- HTTP Request and Validation ---
            try {
                // Create a URI object from the URL string
                URI uri = new URI(url);
                // Build an HTTP HEAD request to check the URL without downloading the body
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(uri) // Set the target URI
                        .method("HEAD", HttpRequest.BodyPublishers.noBody()) // Use HEAD method
                        .build();
                // Send the request and get the response
                HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
                // Extract the HTTP status code from the response
                int respCode = response.statusCode();
                // Log the response code for debugging
                System.out.println("Response Code: " + respCode);
                // Assert that the status code is less than 400 (indicating a successful request)
                // If the status code is 400 or higher, mark the link as broken
                a.assertTrue(respCode < 400, "The link with Text " + link.getText() + " is broken with code " + respCode);
            } catch (IOException | InterruptedException e) {
                // Handle exceptions (e.g., network errors, SSL issues) during the HTTP request
                System.out.println("Error checking URL: " + url + " - " + e.getMessage());
                // Record the failure in the soft assertion
                a.assertTrue(false, "Error for " + link.getText() + ": " + e.getMessage());
            }
        }

        // --- Final Assertion Check ---
        // Execute all soft assertions and throw an exception if any failed
        a.assertAll();

        // --- Cleanup ---
        // Close the browser and release WebDriver resources
        driver.quit();
    }
}