/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tech.skagedal.hahabit.cli;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Properties;
import tech.skagedal.hahabit.generated.api.HahabitApi;
import tech.skagedal.hahabit.generated.invoker.ApiClient;
import tech.skagedal.hahabit.generated.invoker.ApiException;

public class App {
    public static void main(String[] args) {
        new App().run();
    }

    private final Base64.Encoder base64Encoder = Base64.getEncoder();

    private void run() {
        try {
            runWithConfig(readConfig());
        } catch (NoSuchFileException e) {
            System.err.println("Please create ~/.hahabit.properties.");
            System.exit(1);
        } catch (MissingPropertyException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to read properties for unknown reason!");
            System.exit(1);
        }
        System.exit(0);
    }

    private void runWithConfig(Config config) {
        final var encoded = base64Encoder.encodeToString((config.username() + ":" + config.password()).getBytes());
        final var apiClient = new ApiClient()
            .setRequestInterceptor(builder -> builder.header("Authorization", "Basic " + encoded));
        final var api = new HahabitApi(apiClient);

        try {
            final var habitsForDate = api.getHabitsForDate(LocalDate.now());
            habitsForDate.getHabits().forEach(habit -> {
                System.out.print(habit.getTrackingId() != null ? "✅ " : "   ");
                System.out.println(habit.getDescription());
            });
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }

    private Config readConfig() throws IOException {
        final var path = Paths.get(System.getProperty("user.home"), ".hahabit.properties");
        final var stream = Files.newInputStream(path);
        final var properties = new Properties();
        properties.load(stream);

        return new Config(
            getRequiredProperty(properties, "hahabit.username"),
            getRequiredProperty(properties, "hahabit.password")
        );
    }

    private String getRequiredProperty(Properties properties, String key) {
        final var value = properties.getProperty(key);
        if (value == null) {
            throw new MissingPropertyException("Please add a " + key + " property to ~/.hahabit.properties.");
        }
        return value;
    }

    record Config(String username, String password) { }

    class MissingPropertyException extends RuntimeException {
        public MissingPropertyException(String message) {
            super(message);
        }
    }
}
