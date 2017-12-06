import java.nio.charset.StandardCharsets

import org.apache.http.client.methods.{CloseableHttpResponse, HttpGet}
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils

/**
  * Created by Karesz on 2017.12.05..
  */
object ScalaApacheHttpClient {

  def main(args: Array[String]): Unit = {
    /**
      * Store containing the trusted parties or hosts
      */
    System.setProperty("javax.net.ssl.trustStore", "d:\\Projects\\Deloitte\\Project\\dtt\\ssl\\src\\main\\resources\\ClientTrustStore.jks")
    System.setProperty("javax.net.ssl.trustStorePassword", "storepass")
    /**
      * Store to provide the identity of the client through the SSL process
      */
    System.setProperty("javax.net.ssl.keyStore", "d:\\Projects\\Deloitte\\Project\\dtt\\ssl\\src\\main\\resources\\ClientKeyStore.jks")
    // KeyStore pwd and private key pwd must match to be able to use
    System.setProperty("javax.net.ssl.keyStorePassword", "keypass")

    // SSL sticks to host names ...
    println(getContent("https://Karesz-PC:7002/benefits/"))
  }

  def getContent(url:String): String = {

    val request = new HttpGet(url)
    // We apply the system properties that we set up earlier
    val httpClient = HttpClientBuilder.create().useSystemProperties().build()
    try {
      request.setHeader("Token", "Mytoken")

      val response = httpClient.execute(request)
      getResponse(response)
    } finally {
      httpClient.close()
    }

  }

  def getResponse(response: CloseableHttpResponse): String = {
    try {
      if (response.getStatusLine == null) {
        return ""
      }

      val status = response.getStatusLine.getStatusCode
      val body = EntityUtils.toString(response.getEntity, StandardCharsets.UTF_8)
      // Check HTTP status code
      body
    } finally {
      response.close()
    }
  }

}
