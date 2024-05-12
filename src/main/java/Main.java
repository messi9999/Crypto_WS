import dto.ResponseDTO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//
        CryptoManager cryptomanager = new CryptoManager("BTC/USDT");

        executor.scheduleAtFixedRate(() -> {
            ResponseDTO response = cryptomanager.getDepthSnapshot();
            System.out.println("Total Volume Change: " + String.format("%.8f", cryptomanager.getTotalVolumeChange(response)));
        }, 0, 10, TimeUnit.SECONDS); // Initial delay 0, execute every 10 seconds
        Runtime.getRuntime().addShutdownHook(new Thread(executor::shutdown));
    }
}
