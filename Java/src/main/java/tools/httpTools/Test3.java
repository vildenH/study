package tools.httpTools;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * @author wh
 * @date 2019/2/13
 */
public class Test3 {

  public static HttpClient httpClient;

  public static void init() {
    HttpClientParams params = new HttpClientParams();
    // 连接超时时间
    params.setConnectionManagerTimeout(2000);
    // 请求超时是时间
    params.setSoTimeout(4500);
    // 重试次数设置为0
    params.setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));

     //设置连接池参数，扩大连接池参数
     HttpConnectionManagerParams connectionManagerParams = new HttpConnectionManagerParams();
     connectionManagerParams.setMaxTotalConnections(500);
     connectionManagerParams.setDefaultMaxConnectionsPerHost(500);

     MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();
     httpConnectionManager.setParams(connectionManagerParams);

    httpClient = new HttpClient(params);
    httpClient.setHttpConnectionManager(httpConnectionManager);
//    httpClient.getState().setCredentials(
//        AuthScope.ANY,
//        new UsernamePasswordCredentials(hostConfig.getApiUserName(), hostConfig.getApiPasswd()));
    //开启HTTP先验模式
//    httpClient.getParams().setAuthenticationPreemptive(true);
  }

  public String doPutJson(String url, String jsonString) throws Exception {
    PutMethod putMethod = new PutMethod(url);
    putMethod.setDoAuthentication(true);
    StringRequestEntity entity = new StringRequestEntity(jsonString, "application/json", "UTF-8");
    putMethod.setRequestEntity(entity);
    HostConfiguration hostConfig = new HostConfiguration();
    hostConfig.setHost(url);
    String body;

    try {
//      httpClient.executeMethod(hostConfig, putMethod);
      HttpClientParams params = new HttpClientParams();
      // 连接超时时间
      params.setConnectionManagerTimeout(2000);
      // 请求超时是时间
      params.setSoTimeout(4500);
      // 重试次数设置为0
      params
          .setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));

      body = putMethod.getResponseBodyAsString();
    } catch (IOException ioe) {
      throw new Exception(ioe);
    } finally {
      putMethod.releaseConnection();
    }
    return body;
  }

  public static String doGetJson(String url) throws Exception {
    GetMethod putMethod = new GetMethod(url);
    putMethod.setDoAuthentication(true);
    HostConfiguration hostConfig = new HostConfiguration();
    hostConfig.setHost(url);
    String body;
    try {
      httpClient.executeMethod(hostConfig, putMethod);
      body = putMethod.getResponseBodyAsString();
    } catch (IOException ioe) {
      throw new Exception(ioe);
    } finally {
      putMethod.releaseConnection();
    }
    return body;
  }

  public static void main(String[] args) throws Exception {
    init();
    Integer count = 0;
    while (true) {
      System.out.println("第" + count + "次");
      count++;
      new Thread(() -> {
        try {
          URI uri = new URI("http://127.0.0.1:8080/api/monitor/alive");
          System.out.println("A:" + doGetJson(uri.toString()));
        } catch (Exception e) {
        }
      }).start();


      new Thread(() -> {
        try {
          URI uri = new URI("http://127.0.0.1:8080/api/monitor/new");
          System.out.println("B:" + doGetJson(uri.toString()));
        } catch (Exception e) {
        }
      }).start();
      TimeUnit.MILLISECONDS.sleep(10);
    }

  }
}
