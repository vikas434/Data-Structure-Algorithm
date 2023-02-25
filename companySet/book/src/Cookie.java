import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
public class Cookie {
    public class MostActiveCookie {

        public static void main(String[] args) {
            String filePath = null;
            LocalDate date = null;

            // Parse command line arguments
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-f") && i < args.length - 1) {
                    filePath = args[i+1];
                } else if (args[i].equals("-d") && i < args.length - 1) {
                    date = LocalDate.parse(args[i+1]);
                }
            }

            if (filePath == null || date == null) {
                System.err.println("Usage: java MostActiveCookie -f <file_path> -d <date>");
                return;
            }

            try {
                Map<String, Integer> cookieCountMap = getCookieCountMap(filePath, date);
                int maxCount = 0;
                for (int count : cookieCountMap.values()) {
                    if (count > maxCount) {
                        maxCount = count;
                    }
                }
                for (Map.Entry<String, Integer> entry : cookieCountMap.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        System.out.println(entry.getKey());
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }

        private static Map<String, Integer> getCookieCountMap(String filePath, LocalDate date) throws IOException {
            Map<String, Integer> cookieCountMap = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String cookie = parts[0];
                    LocalDate timestamp = LocalDate.parse(parts[1].substring(0, 10));
                    if (timestamp.equals(date)) {
                        cookieCountMap.put(cookie, cookieCountMap.getOrDefault(cookie, 0) + 1);
                    }
                }
            }
            reader.close();
            return cookieCountMap;
        }

    }
}
