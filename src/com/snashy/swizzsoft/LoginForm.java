package com.snashy.swizzsoft;

import com.codename1.components.ToastBar;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import static com.codename1.ui.CN.*;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.processing.Result;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.util.StringUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

/**
* This is the registration Form....
* 
*/
public class LoginForm 
{

    private Form current;
    private Resources theme;
     private Form logscreen;
    private Label logo, lbl_tt1, lbl_tt2, spaceLabel;
    private Image logopane, img; //=theme.getImage("round-mask.png");
    private TextField txt_userloginID_name, txt_password;
    public Style boxStyle2, passwordStyle, loginStyle;
    public Stroke borderStroke;
    private Container cnt_username, cnt_password, cnt_box, tuishlogo;
    private Button btnsignin;
    private CheckBox maskAndUnmaskCheck;
    private Hashtable hash;
    private Boolean rememberme,gender;
    
    private Boolean bool_username_exist;
    private String str_username,str_password;
    
    private Dialog dlg_setDate, dlg_progress;
    private Calendar cldr_bday;
    private Date dt_timer, dt_start, dt_selected, dt_end, dt_alert;
    private String str_saahii, str_hrs, str_min, str_ssaahii, str_sday, str_sdate, str_smonth, str_syear, str_shrs, str_smin, str_sapm, str_esaahii, str_eday, str_edate, str_emonth, str_eyear, str_ehrs, str_emin, str_eapm;
    private Container cnt_confirmORcancel_date,cnt_remember_pass;
    private SimpleDateFormat dateformat;


    public void init(Object context) 
    {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");
        try {
            img=Image.createImage("/upper.jpg");
        } catch (IOException ex) {
//            Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature

        addNetworkErrorListener(err -> 
        {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
            }
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        keeploggedin();
//        new RegistrationForm().Regstrationscreen(theme);
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() 
    {
    }
    
    public void keeploggedin()
    {
        logo=new Label();
        logo.setAlignment(CENTER);
        logo.setUIID("logo");
        int alignment = logo.getStyle().getAlignment();
        logo.setIcon(img);
        
        bool_username_exist = Storage.getInstance().exists("credential_username");
        if(bool_username_exist)
        {
            str_username = Storage.getInstance().readObject("credential_username").toString();
            str_password = Storage.getInstance().readObject("credential_password").toString();

            hash=new Hashtable();
            hash.put("UserLoginID", str_username);
            hash.put("Password", str_password);

            final Result res=Result.fromContent(hash);
            final String checkthis=res.toString();

            
            String myUrl="https://b2cmanager.co.ke/TUISHIMOBWB/Login";   
//            String myUrl="http://localhost:50111/Login";                  
            String Reply="";
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
            dlg_progress = new Dialog();
            dlg_progress.setDialogUIID("Container");
            dlg_progress.setLayout(new BorderLayout());

            dlg_progress.addComponent(BorderLayout.CENTER, FlowLayout.encloseCenterBottom(logo));
            dlg_progress.setTransitionInAnimator(CommonTransitions.createEmpty());
            dlg_progress.setTransitionOutAnimator(CommonTransitions.createEmpty());
            dlg_progress.showPacked(BorderLayout.CENTER, false);
            request.setDisposeOnCompletion(dlg_progress);

            NetworkManager.getInstance().addToQueueAndWait(request);
            request.setDisposeOnCompletion(dlg_progress);

    //        start response;
            byte[] dataa2=request.getResponseData();
            if(dataa2!=null)
            {
               Reader reader2 = null;
                try 
                {
                    reader2 = new InputStreamReader(new ByteArrayInputStream(dataa2), "UTF-8");
                } 
                catch (UnsupportedEncodingException ex) 
                {
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
                }
                response2=sb2.toString();

                JSONParser json_parser2=new JSONParser();
                Map map_response2 = null;
                try 
                {
                    map_response2 = json_parser2.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa2),"UTF-8"));
                } 
                catch (UnsupportedEncodingException ex) {
                    //Logger.getLogger(SampleLogin.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (IOException ex) {
                    //Logger.getLogger(SampleLogin.class.getName()).log(Level.SEVERE, null, ex);
                }

                Reply=map_response2.get("apireply").toString();

                if(Reply.equals("success"))
                {
                    /*-------store data first-------*/
                    Storage.getInstance().writeObject("UserName", str_username);
                    Storage.getInstance().writeObject("UserLoginID", str_password);

//                          Log.p("Going to Fetch Counties list...", 1);
                    Storage.getInstance().writeObject("screen", "registration");

                    Storage.getInstance().writeObject("parameter1", "GetCounties");
                    Storage.getInstance().writeObject("parameter2", "");
                    Storage.getInstance().writeObject("parameter3", "");

                    try 
                    {
                        Connect conn = new Connect();
                        conn.process();
                    } 
                    catch (Exception e) 
                    {
//                        Log.p("B. Error: "+e, 1);
                    }
                }
                else if(Reply.equals("WrongDetails"))
                {
                    loginscreen();
                }
                else
                {
                    ToastBar.showErrorMessage("Sorry, please check your connection and try refreshing the app....");
                    loginscreen();
                }       
            }
            else
            {
                loginscreen();
            }
        }
        else
        {
            loginscreen();
        }
    }
    
    public void loginscreen()
    {
        logo=new Label();
        logo.setUIID("logo");
        logo.setIcon(logopane);
        logo.getAllStyles().getBgTransparency();
        logo.getUnselectedStyle().setBgTransparency(20);
        
        lbl_tt1=new Label("TUISHI COMPANION");
        lbl_tt1.setUIID("lbl_tt1");
        lbl_tt2=new Label("For you, We care");
        lbl_tt2.setUIID("lbl_tt2");
        
        
        // We remove the extra space for low resolution devices so things fit better
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) 
        {
            spaceLabel = new Label();
        } 
        else 
        {
            spaceLabel = new Label(" ");
        }

        txt_userloginID_name = new TextField("", " Enter your Login ID", 20, TextField.ANY);
        txt_userloginID_name.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue7fd".charAt(0), txt_userloginID_name.getUnselectedStyle()));

        loginStyle = txt_userloginID_name.getAllStyles();
        
        borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        loginStyle.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        loginStyle.setBgColor(0xffffff);
        loginStyle.setBgTransparency(255);
        loginStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
        loginStyle.setMargin(Component.BOTTOM, 3);

        cnt_username=new Container();
        cnt_username.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        cnt_username.add(txt_userloginID_name);

        txt_password = new TextField("", " Enter your Password", 20, TextField.PASSWORD);
        txt_password.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue897".charAt(0), txt_password.getUnselectedStyle()));

        passwordStyle = txt_password.getAllStyles();
        passwordStyle.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        passwordStyle.setBgColor(0xffffff);
        passwordStyle.setBgTransparency(255);

        maskAndUnmaskCheck = new CheckBox();
        maskAndUnmaskCheck.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if(maskAndUnmaskCheck.isSelected())
                {
                   txt_password.setConstraint(TextField.ANY); 
                } 
                else 
                {
                    txt_password.setConstraint(TextField.PASSWORD);
                }
                if(txt_password.isEditing()) 
                {
                    txt_password.stopEditing();
                    txt_password.startEditingAsync();
                } 
                else 
                {
                    txt_password.getParent().revalidate(); 
                }
            }
        }); 

        cnt_password = LayeredLayout.encloseIn(txt_password, FlowLayout.encloseRightMiddle());

        btnsignin=new Button("SIGN IN");
        com.codename1.ui.FontImage.setMaterialIcon(btnsignin,"\ue898".charAt(0));
        btnsignin.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if(txt_userloginID_name.getText().equals("")||txt_password.getText().equals(""))
                {                    
                    Dialog.show("Error", "Please fill in all your Details", "OK", null);
                }                
                else
                {
                    Log.p("Recieved this Phone--"+txt_userloginID_name.getText()+" password-- "+txt_password.getText(), 1);

                    hash =new Hashtable();
                    hash.put("Password", txt_password.getText());
                    hash.put("UserLoginID", txt_userloginID_name.getText());

                    final Result res=Result.fromContent(hash);
                    final String checkthis=res.toString();

//                    String myUrl="http://localhost:50111/Login";  
                    String myUrl="https://b2cmanager.co.ke/TUISHIMOBWB/Login";

                    String Reply="";
                    requestclass c=new requestclass(); 
                        try 
                        {
                            Reply=c.checking(checkthis,myUrl);
                        } 
                        catch (IOException ex) 
                        {
                        } 
                        catch (requestclass.JSONException ex) 
                        {
                        }
                    if(Reply.equals("success"))
                    {
                        /*-------store data first-------*/
                        Storage.getInstance().writeObject("UserName", txt_userloginID_name.getText());
                        Storage.getInstance().writeObject("UserLoginID", txt_password.getText());
                         /*----redirect---*/

                         Log.p("Going to Fetch Counties list...", 1);
                    
                        Storage.getInstance().writeObject("screen", "registration");

                        Storage.getInstance().writeObject("parameter1", "GetCounties");
                        Storage.getInstance().writeObject("parameter2", "");
                        Storage.getInstance().writeObject("parameter3", "");

                        try 
                        {
                            Connect conn = new Connect();
                            conn.process();
                        } 
                        catch (Exception e) 
                        {
                            Log.p("B. Error: "+e, 1);
                        }
                    }
                    else if(Reply.equals("WrongDetails"))
                    {
                        Dialog.show("SORRY!!", "Wrong Username or password", "OK", null);
                    }
                    else
                    {
                        Dialog.show("Error", "Something went wrong, try checking your connection and try again later.", "OK", null);
                    }                   

                }
            }
        });

            CheckBox cb_rem = new CheckBox(" Remember Me");
            cb_rem.setOppositeSide(false);
            cb_rem.addActionListener(new ActionListener() 
            {
                 @Override
                 public void actionPerformed(ActionEvent evt) 
                 {
                     rememberme=cb_rem.isSelected();
                     
                     if(rememberme.equals(true))
                     {
                         /*-------store data first-------*/
                        Storage.getInstance().writeObject("credential_username", txt_userloginID_name.getText());
                        Storage.getInstance().writeObject("credential_password", txt_password.getText());
                     }
                     else 
                     {
                         Log.p("checkbox not selected", 1);
                         //nothing really.....
                     }
                    
                 }
             });

            tuishlogo=new Container();
            tuishlogo.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
            tuishlogo.add(spaceLabel);
            tuishlogo.add(lbl_tt1);
            tuishlogo.add(lbl_tt2);

            cnt_box = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            cnt_box.add(cnt_username);
            cnt_box.add(cnt_password);
            cnt_box.add(btnsignin);
            cnt_box.add(cb_rem);
            
            boxStyle2 = cnt_box.getUnselectedStyle();
            boxStyle2.setBgTransparency(255);
            boxStyle2.setBgColor(0xeeeeee);
            boxStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
            boxStyle2.setPaddingUnit(Style.UNIT_TYPE_DIPS);
            boxStyle2.setMargin(4, 3, 3, 3);
            boxStyle2.setPadding(2, 2, 2, 2);

            logscreen = new Form(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));
            logscreen.add(BorderLayout.NORTH, tuishlogo);
            logscreen.add(BorderLayout.CENTER, cnt_box);
            logscreen.isScrollableY();
            
            logscreen.show();
    }
    
    public void showDaySelector()
    {
        cldr_bday = new Calendar();
        cldr_bday.setChangesSelectedDateEnabled(true);
        
        dlg_setDate = new Dialog();
        dlg_setDate.setTitle("Select Date of Birth");
        dlg_setDate.add(cldr_bday);
        
        dlg_setDate.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        dlg_setDate.getStyle().setAlignment(CENTER);

        Button btn_cancelStart = new Button("Cancel");
        btn_cancelStart.setUIID("Label");
        btn_cancelStart.addActionListener(new ActionListener() 
        {
             @Override
             public void actionPerformed(ActionEvent evt) 
             {
                  dlg_setDate.dispose();
                  dlg_setDate.removeAll();
             }
        });

        Button btn_confirmStart = new Button("Confirm");
        btn_confirmStart.setUIID("Label");
        btn_confirmStart.addActionListener(new ActionListener() 
        {
         @Override
         public void actionPerformed(ActionEvent evt) 
         {
            dt_selected = new Date(cldr_bday.getSelectedDay());


            str_ssaahii = StringUtil.tokenize(StringUtil.tokenize(dt_selected.toString(), " ").get(3), ":").get(0)+":"+StringUtil.tokenize(StringUtil.tokenize(dt_selected.toString(), " ").get(3), ":").get(1);
            str_sday = StringUtil.tokenize(dt_selected.toString(), " ").get(0);
            str_sdate = StringUtil.tokenize(dt_selected.toString(), " ").get(2);
            str_smonth = StringUtil.tokenize(dt_selected.toString(), " ").get(1);
            str_syear = StringUtil.tokenize(dt_selected.toString(), " ").get(5);

            System.out.println("Day picked: " + dt_selected);

            if(str_smonth.equals("Jan")){ str_smonth = "01"; }
            if(str_smonth.equals("Feb")){ str_smonth = "02";}
            if(str_smonth.equals("Mar")){ str_smonth = "03"; }
            if(str_smonth.equals("Apr")){ str_smonth = "04"; }
            if(str_smonth.equals("May")){ str_smonth = "05"; }
            if(str_smonth.equals("Jun")){ str_smonth = "06"; }
            if(str_smonth.equals("Jul")){ str_smonth = "07"; }
            if(str_smonth.equals("Aug")){ str_smonth = "08"; }
            if(str_smonth.equals("Sep")){ str_smonth = "09"; }
            if(str_smonth.equals("Oct")){ str_smonth = "10"; }
            if(str_smonth.equals("Nov")){ str_smonth = "11"; }
            if(str_smonth.equals("Dec")){ str_smonth = "12"; }
              
              
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); //DateFormatPatterns.VERBOSE_TIMESTAMP
            Picker picker_leo = new Picker();
            picker_leo.setFormatter(sdformat);

             System.err.println("Date: "+str_sdate+"-"+str_smonth+"-"+str_syear);

            Storage.getInstance().writeObject("start_date", str_sdate+"-"+str_smonth+"-"+str_syear);
              
            dlg_setDate.dispose();
            dlg_setDate.removeAll();
         }
        });

        cnt_confirmORcancel_date = new Container(new BorderLayout());
        cnt_confirmORcancel_date.add(BorderLayout.WEST, btn_cancelStart);
        cnt_confirmORcancel_date.add(BorderLayout.EAST, btn_confirmStart);

        dlg_setDate.add(cnt_confirmORcancel_date);
        
        dlg_setDate.show();
    }

}
