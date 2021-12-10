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

  public ArrayList<String> getList() throws RestClientResponseCheckedException
  {
    try
    {
      //Compose header
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.setContentType( MediaType.ALL );

      //compose url
      String path = UriComponentsBuilder
          .fromPath( "/path" )
          .queryParam( "name", "value" )
          .build()
          .toUriString();

      //compose body
      String body = "body";

      //Create entity
      HttpEntity<String> httpEntity = new HttpEntity<String>( body,httpHeaders );

      //Make request
      ResponseEntity<String> responseEntity = restTemplate.exchange( path, HttpMethod.POST, httpEntity, String.class );

      //Verify body is present.
      String response = responseEntity.getBody();
      if(response == null)
      {
        throw new RestClientResponseException("Received null body from rest call.",responseEntity.getStatusCodeValue(),"None.", null, null, null);
      }

      //parse response for object.
      ArrayList<String> list = new Gson().fromJson( response, ArrayList.class);

      //Return result
      return list;
    }
    catch( RestClientResponseException restClientResponseException )
    {
      throw new RestClientResponseCheckedException(restClientResponseException);
    }
  }
}
