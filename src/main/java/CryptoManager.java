import com.google.gson.Gson;
import dto.ResponseDTO;
import dto.TradingPairDTO;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class CryptoManager {
    // determine if it is BTC/USDT or ETH/USDT
    String method;
    float prevCryptoVolume;
    String GET_BTCUSDT_DEPTH_URI = "https://api.binance.com/api/v3/depth?symbol=BNBBTC&limit=50";
    String GET_ETHUSDT_DEPTH_URI = "https://api.binance.com/api/v3/depth?symbol=ETHUSDT&limit=50";
    String cur_depth_uri = "";

    public CryptoManager() {
        prevCryptoVolume = 0;
    }

    public CryptoManager(String md) {
        method = md;
        if (md.equals("BTC/USDT")) {
            cur_depth_uri = GET_BTCUSDT_DEPTH_URI;
        } else {
            cur_depth_uri = GET_ETHUSDT_DEPTH_URI;
        }
    }

    public ResponseDTO getDepthSnapshot() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet("https://api.binance.com/api/v3/depth?symbol=BNBBTC&limit=50");
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String rawJson = EntityUtils.toString(entity);
                    Gson gson = new Gson();
                    return gson.fromJson(rawJson, ResponseDTO.class);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public float getCryptoVolume(ResponseDTO response) {
        float total = 0;

        for (String[] bid : response.getBids()) {
            TradingPairDTO tp = new TradingPairDTO(bid[0], bid[1]);
            tp.print();
            total += tp.totalPrice();
        }
        for (String[] ask : response.getAsks()) {
            TradingPairDTO tp = new TradingPairDTO(ask[0], ask[1]);
            total += tp.totalPrice();
        }
        return total;
    }

    public float getTotalVolumeChange(ResponseDTO response) {
        float curVolume = getCryptoVolume(response);
        float totalVolumeChange = curVolume - prevCryptoVolume;
        if (prevCryptoVolume == 0) {
            totalVolumeChange = 0;
        }
        prevCryptoVolume = curVolume;
        return totalVolumeChange;
    }
}
