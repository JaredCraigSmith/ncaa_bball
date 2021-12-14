import com.google.gson.Gson;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.awt.*;
import java.util.ArrayList;

public class NcaaComClient
{
  protected RestTemplate restTemplate = new RestTemplate();

  private String rootUrl = "https://www.ncaa.com";

  public NcaaComClient( )
  {
    this.restTemplate = new RestTemplateBuilder().rootUri( rootUrl ).build();
  }

  //If you can't locate.
  //  public ClientTemplate(RestTemplateBuilder restTemplateBuilder,@Value( "${clientRootUrl}" ) String rootUrl)
  //  {
  //    this.restTemplate = restTemplateBuilder.rootUri( rootUrl ).build();
  //  }

  /**
   *
   * @param date ex: 2021/12/01
   * @return
   * @throws RestClientResponseCheckedException
   */
  public String getMensBasketBallPage(String date) throws RestClientResponseCheckedException
  {
    try
    {
      //Compose header
      HttpHeaders httpHeaders = new HttpHeaders();

      //compose url
      String path = UriComponentsBuilder
          .fromPath( "/scoreboard/basketball-men/d1/"+date+"/all-conf" )
          .build()
          .toUriString();



      //Create entity
      HttpEntity<String> httpEntity = new HttpEntity<String>( httpHeaders );

      //Make request
      ResponseEntity<String> responseEntity = restTemplate.exchange( path, HttpMethod.GET, httpEntity, String.class );

      //Verify body is present.
      String response = responseEntity.getBody();
      if(response == null)
      {
        throw new RestClientResponseException("Received null body from rest call.",responseEntity.getStatusCodeValue(),"None.", null, null, null);
      }

      //Return result
      return response;
    }
    catch( RestClientResponseException restClientResponseException )
    {
      throw new RestClientResponseCheckedException(restClientResponseException);
    }
  }
}
