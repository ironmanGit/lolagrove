package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
//http://www.rgagnon.com/javadetails/java-fix-certificate-problem-in-HTTPS.html
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.log4j.Logger;
//import org.webbitserver.helpers.Base64;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
//import java.util.Base64;

public class ConnectUrlUtils {
	static Logger logger = Logger.getLogger(ConnectUrlUtils.class.getName());

	private static String getResponseString(InputStream inputStream) throws IOException {

		// InputStream inputStream = con.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		BufferedReader in = new BufferedReader(inputStreamReader);
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		String result = response.toString();
		// print result
		System.out.println(result);

		return result;
	}

	public static String getHttps(String site) throws Exception {
		/*
		 * fix for Exception in thread "main"
		 * javax.net.ssl.SSLHandshakeException:
		 * sun.security.validator.ValidatorException: PKIX path building failed:
		 * sun.security.provider.certpath.SunCertPathBuilderException: unable to
		 * find valid certification path to requested target
		 */
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}

		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		/*
		 * end of the fix
		 */

		// URL url = new URL("https://securewebsite.com");
		URL url = new URL(site);
		// URLConnection con = url.openConnection();
		// we can use URLConnection, HttpURLConnection or HttpsURLConnection
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

//		String cert = "46bbca84-4902-445c-8a7f-14b615f4e36e";
////		con.setRequestProperty("X-Auth-Token", cert);
////		con.setRequestProperty("X-Auth-Token: ", cert);
////		con.setRequestProperty("X-Auth-Token: ", Base64.encode(cert.getBytes()));
////		con.setRequestProperty("X-Auth-Token", Base64.encode(cert.getBytes()));
//		con.setRequestProperty("Authorization: ", "Basic " +  cert);
////		con.setRequestProperty("Authorization: ", "Basic " +  Base64.encode(cert.getBytes()));
////		con.setRequestProperty("Authorization", "Basic " +  Base64.encode(cert.getBytes()));
////		con.setRequestProperty("X-Authorization", "Basic " +  Base64.encode(cert.getBytes()));
////		con.setRequestProperty("X-Authorization", Base64.encode(cert.getBytes()));
		
		// add request header
		// con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		if (responseCode != 200) {
			throw new Exception("Error: invalide response code " + responseCode);
		}

		String result = getResponseString(con.getInputStream());
		// Reader reader = new InputStreamReader(con.getInputStream());
		// while (true) {
		// int ch = reader.read();
		// if (ch==-1) {
		// break;
		// }
		// System.out.print((char)ch);
		// }

		return result;
	}
	
	public static String getHttp(String site) throws Exception {
	
		// URL url = new URL("https://securewebsite.com");
		URL url = new URL(site);
		// URLConnection con = url.openConnection();
		// we can use URLConnection, HttpURLConnection or HttpsURLConnection
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

//		String cert = "46bbca84-4902-445c-8a7f-14b615f4e36e";
////		con.setRequestProperty("X-Auth-Token", cert);
////		con.setRequestProperty("X-Auth-Token: ", cert);
////		con.setRequestProperty("X-Auth-Token: ", Base64.encode(cert.getBytes()));
////		con.setRequestProperty("X-Auth-Token", Base64.encode(cert.getBytes()));
//		con.setRequestProperty("Authorization: ", "Basic " +  cert);
////		con.setRequestProperty("Authorization: ", "Basic " +  Base64.encode(cert.getBytes()));
////		con.setRequestProperty("Authorization", "Basic " +  Base64.encode(cert.getBytes()));
////		con.setRequestProperty("X-Authorization", "Basic " +  Base64.encode(cert.getBytes()));
////		con.setRequestProperty("X-Authorization", Base64.encode(cert.getBytes()));
		
		// add request header
		// con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		if (responseCode != 200) {
			throw new Exception("Error: invalide response code " + responseCode);
		}

		String result = getResponseString(con.getInputStream());
		// Reader reader = new InputStreamReader(con.getInputStream());
		// while (true) {
		// int ch = reader.read();
		// if (ch==-1) {
		// break;
		// }
		// System.out.print((char)ch);
		// }

		return result;
	}

}