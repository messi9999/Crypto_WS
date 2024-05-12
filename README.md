## Real-Time Order Book Monitor for BTC/USDT and ETH/USDT

### Author
This program was written by Akira Chen.

### Description

This Java program utilizes the Binance API to build and maintain real-time order books for the BTC/USDT and ETH/USDT trading pairs. It prints the order book and calculates the total volume change in USDT for each trading pair every 10 seconds.

### Features

-   Builds and maintains real-time order books for BTC/USDT and ETH/USDT trading pairs.
-   Utilizes Binance API for fetching order book updates with a depth of 50 price levels.
-   Calculates total volume change in USDT for each order book every 10 seconds.
-   Implements classes and methods to parse order book updates and update local order books accordingly.
-   Prints the order book in a column format and displays total volume change in USDT for each trading pair.

### Dependencies

-   Websocket client: [Java-WebSocket](https://github.com/TooTallNate/Java-WebSocket)
-   HTTP client: [Apache HttpComponents](https://hc.apache.org/)
-   JSON parsing engine: [Gson](https://github.com/google/gson)

### How to Run

1.  Clone this repository to your local machine.
2.  Ensure you have Java installed on your system.
3.  Install the required dependencies: Java-WebSocket, Apache HttpComponents, and Gson.
4.  Compile the Java program.
5.  Run the program and observe real-time order book updates and total volume change for BTC/USDT and ETH/USDT trading pairs.

### Usage

-   Upon running the program, it will continuously fetch order book updates and print the order book along with the total volume change every 10 seconds.
-   The order book is displayed in a column format, showing one pair of price and quantity per line.
-   Total volume change in USDT is calculated as the sum of all buy/bid quantities multiplied by their respective price, plus the sum of sell/ask quantities multiplied by their respective price.

### Example Output

![image-20240511235836532](C:\Users\NIKE\AppData\Roaming\Typora\typora-user-images\image-20240511235836532.png)