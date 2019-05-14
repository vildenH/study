package es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.reindex.ReindexRequest;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wh
 * @date 2019/4/23
 */
public class esDemo {

    public static void main(String[] args) throws IOException {


    }


    @Test
    public void createIndex() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");
        jsonMap.put("sdadasdadasd", "asdasdasdasdasdsad");
        for (int i = 0; i < 100; i++) {
            IndexRequest indexRequest = new IndexRequest("test100", "doc", String.valueOf(i))
                    .source(jsonMap);
            client.index(indexRequest, RequestOptions.DEFAULT);
        }
        client.close();

    }

    //1亿
    @Test
    public void bulkTest() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");
        jsonMap.put("sdadasdadasd", "asdasdasdasdasdsad");
        int count = 1;
        BulkRequest request = new BulkRequest();
        for (int i = 0; i < 100000000; i++) {
            IndexRequest indexRequest = new IndexRequest("test1000", "doc", String.valueOf(i))
                    .source(jsonMap);
            request.add(indexRequest);
            if (count % 5000 == 0) {
                client.bulk(request, RequestOptions.DEFAULT);
                count = 0;
                request = new BulkRequest();
                System.out.println(i);
            }
            count++;

        }
    }

    @Test
    public void getDoc() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));

        GetRequest getRequest = new GetRequest(
                "posts",
                "doc",
                "1");
        GetResponse documentFields = client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(documentFields.getSourceAsString());
        client.close();
    }

    @Test
    public void updateDoc() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));
        UpdateRequest request = new UpdateRequest("posts", "doc", "1");
        String jsonString = "{" +
                "\"updated\":\"2017-01-01\"," +
                "\"reason\":\"daily update\"" +
                "}";
        request.doc(jsonString, XContentType.JSON);
        client.update(request, RequestOptions.DEFAULT);
        client.close();
    }

    @Test
    public void reindexTest() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));
        ReindexRequest request = new ReindexRequest();
        request.setSourceIndices("filebeat*", "posts");
        request.setDestIndex("dest");
        client.reindex(request, RequestOptions.DEFAULT);
        client.close();

    }

    @Test
    public void matchTest() {
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("user", "kimchy");
    }

    @Test
    public void scrollTest() throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));

        SearchRequest searchRequest = new SearchRequest("dest");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(1);
        searchRequest.source(searchSourceBuilder);
        searchRequest.scroll(TimeValue.timeValueMinutes(1L));
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        String scrollId = searchResponse.getScrollId();
        SearchHits hits = searchResponse.getHits();
        System.out.println("scrollId：" + scrollId);
        System.out.println("hits:" + hits.getTotalHits());
        client.close();
    }
}

