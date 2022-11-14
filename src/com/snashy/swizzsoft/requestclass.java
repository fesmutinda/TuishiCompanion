
package com.snashy.swizzsoft;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;


public class requestclass 
{
    public String checking(String checkthis, String myUrl)throws IOException, JSONException
    {
        String str_AppAuth="";
        ConnectionRequest request=new ConnectionRequest()
        {
            public void buildRequestBody(OutputStream thisstream) throws IOException
            {
                Writer andika=null;
                andika=new OutputStreamWriter(thisstream,"UTF-8");
                andika.write(checkthis);
                andika.flush();
                andika.close();
            }
        };
        request.setUrl(myUrl);
        request.setContentType("application/json");                    
        request.addRequestHeader("Accept","application/json");
        request.setPost(true);
        request.setWriteRequest(true);
        
        ///----------loading......
        InfiniteProgress inftprogress = new InfiniteProgress();
        Dialog dlg_progress = new Dialog();
        dlg_progress.setDialogUIID("Container");
        dlg_progress.setLayout(new BorderLayout());

        Label lbl_progress = new Label("Connecting...\n, Please Wait...");
        lbl_progress.getStyle().setFgColor(0xffffff, false);
        lbl_progress.getStyle().setBgTransparency(0);
        dlg_progress.addComponent(BorderLayout.CENTER, FlowLayout.encloseCenterBottom(lbl_progress, inftprogress));
        dlg_progress.setTransitionInAnimator(CommonTransitions.createEmpty());
        dlg_progress.setTransitionOutAnimator(CommonTransitions.createEmpty());
        dlg_progress.showPacked(BorderLayout.CENTER, false);
        request.setDisposeOnCompletion(dlg_progress);

        NetworkManager.getInstance().addToQueueAndWait(request);
        request.setDisposeOnCompletion(dlg_progress);
        
//        start response;
//       
 //Informational 1xx
        /*
        100 => '100 Continue',
        101 => '101 Switching Protocols',
        
        //Successful 2xx
        200 => '200 OK',
        201 => '201 Created',
        202 => '202 Accepted',
        203 => '203 Non-Authoritative Information',
        204 => '204 No Content',
        205 => '205 Reset Content',
        206 => '206 Partial Content',
        
        //Redirection 3xx
        300 => '300 Multiple Choices',
        301 => '301 Moved Permanently',
        302 => '302 Found',
        303 => '303 See Other',
        304 => '304 Not Modified',
        305 => '305 Use Proxy',
        306 => '306 (Unused)',
        307 => '307 Temporary Redirect',
        
        //Client Error 4xx
        400 => '400 Bad Request',
        401 => '401 Unauthorized',
        402 => '402 Payment Required',
        403 => '403 Forbidden',
        404 => '404 Not Found',
        405 => '405 Method Not Allowed',
        406 => '406 Not Acceptable',
        407 => '407 Proxy Authentication Required',
        408 => '408 Request Timeout',
        409 => '409 Conflict',
        410 => '410 Gone',
        411 => '411 Length Required',
        412 => '412 Precondition Failed',
        413 => '413 Request Entity Too Large',
        414 => '414 Request-URI Too Long',
        415 => '415 Unsupported Media Type',
        416 => '416 Requested Range Not Satisfiable',
        417 => '417 Expectation Failed',
        418 => '418 I\'m a teapot',
        422 => '422 Unprocessable Entity',
        423 => '423 Locked',
        
        //Server Error 5xx
        500 => '500 Internal Server Error',
        501 => '501 Not Implemented',
        502 => '502 Bad Gateway',
        503 => '503 Service Unavailable',
        504 => '504 Gateway Timeout',
        505 => '505 HTTP Version Not Supported'*/
        
    byte[] dataa2=request.getResponseData();
    if(dataa2!=null)
    {
       Reader reader2 = null;
        try 
        {
            reader2 = new InputStreamReader(new ByteArrayInputStream(dataa2), "UTF-8");
        } catch (UnsupportedEncodingException ex) 
        {
            //Logger.getLogger(SampleLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        int chr2;
        StringBuffer sb2=new StringBuffer();
        String response2="";
        try 
        {
            while((chr2=reader2.read()) != -1)
            {
                sb2.append((char) chr2);
            }
        } 
        catch (IOException ex) 
        {
            //Logger.getLogger(SampleLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        response2=sb2.toString();

        JSONParser json_parser2=new JSONParser();
        Map map_response2 = null;
        try 
        {
            map_response2 = json_parser2.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa2),"UTF-8"));
        } catch (UnsupportedEncodingException ex) 
        {
            //Logger.getLogger(SampleLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) 
        {
            //Logger.getLogger(SampleLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        str_AppAuth=map_response2.get("apireply").toString();
        //Log.p("Successfully Completed"+str_AppAuth, 1);
    }
    else
    {
        //noth
    }

    return str_AppAuth;
    }
    public class JSONException extends Exception
    {
     public JSONException(String message)
     {    
     } 
      public JSONException(Throwable t)
      {    
      } 
//      public Throwable getClause()
//      {
//      }
    }
}

