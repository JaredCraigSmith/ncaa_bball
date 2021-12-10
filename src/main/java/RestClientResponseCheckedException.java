import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientResponseException;

import java.nio.charset.Charset;

/**
 * This class serves as a wrapper class for RestClientResponseException.
 * The normal RestClientResponseException is uncheck so user are not forced to handle the error if on occurs such as 400 and 500 status.
 * Those kind of things happend all the time for DPC so it makes sense to force the handling.
 * RestClientResponseException is nice because it contains all the information to handling common network errors.
 *
 */
public class RestClientResponseCheckedException extends Exception
{
  private RestClientResponseException restClientResponseException;

  public RestClientResponseCheckedException(RestClientResponseException restClientResponseException)
  {
    super(restClientResponseException);
    this.restClientResponseException = restClientResponseException;
  }

  public int getRawStatusCode()
  {
    return restClientResponseException.getRawStatusCode();
  }

  public HttpStatus getHttpStatus()
  {
    return HttpStatus.resolve( getRawStatusCode() );
  }

  public byte[] getresponseBodyAsByteArray()
  {
    return restClientResponseException.getResponseBodyAsByteArray();
  }

  public String getResponsebodyAsString()
  {
    return restClientResponseException.getResponseBodyAsString();
  }

  public String getResponseBodyAsString( Charset fallbackCharset)
  {
    return restClientResponseException.getResponseBodyAsString(fallbackCharset);
  }

  public HttpHeaders getResponseHeaders()
  {
    return restClientResponseException.getResponseHeaders();
  }

  public String getStatusText()
  {
    return restClientResponseException.getStatusText();
  }
}
