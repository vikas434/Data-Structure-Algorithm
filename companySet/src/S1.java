import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class S1 {
        private static final String GET_URL = "https://jsonmock.hackerrank.com/api/tvseries?page=";
        public static String bestInGenre(String genre) throws IOException {
            // Write your code here
            // data preparation
            Map<String, List<TVShows>> map = new HashMap<>();
            List<String> result = new ArrayList<>();
            double maxValue = Double.MIN_VALUE;
            for(int i = 1; i<=20; i++) {
                Root root = sendHttpGETRequest(i);
                for(TVShows tvshow : root.getData()) {
                    String[] genres = tvshow.genre.split(",");
                    for(String gen : genres) {
                        String trimmedGenre = gen.trim();
                        if(trimmedGenre.equalsIgnoreCase(genre)) {
                            if(tvshow.getImdbRating() > maxValue) {
                                result = List.of(tvshow.name);
                                maxValue = tvshow.imdbRating;
                            } else if (tvshow.getImdbRating() == maxValue) {
                                result.add(tvshow.name);
                            }
                        }

                    }
                }
            }

             Collections.sort(result);
            return result.get(0);
        }

        private static Root sendHttpGETRequest(int i) throws IOException {
            URL obj = new URL(GET_URL+i);
            HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in .readLine()) != null) {
                    response.append(inputLine);
                } in .close();
                Gson gson = new Gson();
               return gson.fromJson(response.toString(), Root.class);
        }

    //    public static void main(String[] args) throws IOException {
    //        bestInGenre("test");
    //    }

        public class TVShows {
            private String name;
            private String runtimeOfSeries;
            private String certificate;
            private String runtimeOfEpisodes;
            private String genre;
            private Double imdbRating;
            private String overview;
            private Integer noOfVotes;
            private Integer id;
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public String getRuntimeOfSeries() {
                return runtimeOfSeries;
            }
            public void setRuntimeOfSeries(String runtimeOfSeries) {
                this.runtimeOfSeries = runtimeOfSeries;
            }
            public String getCertificate() {
                return certificate;
            }
            public void setCertificate(String certificate) {
                this.certificate = certificate;
            }
            public String getRuntimeOfEpisodes() {
                return runtimeOfEpisodes;
            }
            public void setRuntimeOfEpisodes(String runtimeOfEpisodes) {
                this.runtimeOfEpisodes = runtimeOfEpisodes;
            }
            public String getGenre() {
                return genre;
            }
            public void setGenre(String genre) {
                this.genre = genre;
            }
            public Double getImdbRating() {
                return imdbRating;
            }
            public void setImdbRating(Double imdbRating) {
                this.imdbRating = imdbRating;
            }
            public String getOverview() {
                return overview;
            }
            public void setOverview(String overview) {
                this.overview = overview;
            }
            public Integer getNoOfVotes() {
                return noOfVotes;
            }
            public void setNoOfVotes(Integer noOfVotes) {
                this.noOfVotes = noOfVotes;
            }
            public Integer getId() {
                return id;
            }
            public void setId(Integer id) {
                this.id = id;
            }
        }

        public class Root {
            private Integer page;
            private Integer perPage;
            private Integer total;
            private Integer totalPages;
            private List<TVShows> data = new ArrayList<TVShows>();
            public Integer getPage() {
                return page;
            }
            public void setPage(Integer page) {
                this.page = page;
            }
            public Integer getPerPage() {
                return perPage;
            }
            public void setPerPage(Integer perPage) {
                this.perPage = perPage;
            }
            public Integer getTotal() {
                return total;
            }
            public void setTotal(Integer total) {
                this.total = total;
            }
            public Integer getTotalPages() {
                return totalPages;
            }
            public void setTotalPages(Integer totalPages) {
                this.totalPages = totalPages;
            }
            public List<TVShows> getData() {
                return data;
            }
            public void setData(List<TVShows> data) {
                this.data = data;
            }
        }


}
