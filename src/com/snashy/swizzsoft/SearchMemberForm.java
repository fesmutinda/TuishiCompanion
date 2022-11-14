
package com.snashy.swizzsoft;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.processing.Result;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author Festus2032
 */
public class SearchMemberForm 
{
    private TextField txt_Phone_number;
    private Stroke borderStroke;
    private Form fm_serach_member;
    public Style boxStyle2, sty_first_name;
    private Container cnt_box, cnt_search;
    private Button btn_search;
    private Toolbar tb;
    private Hashtable hash;
    public Resources theme;
    private Label spaceLabel, spaceLabel2;
    
    private Boolean bool_username_exist;
    
    public void searchscreen()
    {
        theme=UIManager.initFirstTheme("/theme");
        
        // We remove the extra space for low resolution devices so things fit better
        if(!Display.getInstance().isTablet() && Display.getInstance().getDeviceDensity() < Display.DENSITY_VERY_HIGH) 
        {
            spaceLabel = new Label();
            spaceLabel2 = new Label();
        } 
        else 
        {
            spaceLabel = new Label(" ");
            spaceLabel2 = new Label(" ");
        }
        
        txt_Phone_number = new TextField();
        txt_Phone_number.setHint("Enter Phone Number");
        txt_Phone_number.setConstraint(TextArea.PHONENUMBER);
        sty_first_name = txt_Phone_number.getAllStyles();
        sty_first_name.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        sty_first_name.setBgColor(0xffffff);
        sty_first_name.setBgTransparency(100);
        
        cnt_search=new Container();
        cnt_search.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        cnt_search.add(txt_Phone_number);
        
        btn_search=new Button("Search");
        com.codename1.ui.FontImage.setMaterialIcon(btn_search,"\ue898".charAt(0));
        btn_search.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if(txt_Phone_number.getText().equals(""))
                {
                    Dialog.show("Sorry", "Please Enter a valid ID Number", "ok", null);
                }
                else
                {
                    String Reply="";
                    String Member_id="";
                    String surname = "";
                    String christian_name = "";
                    String middle_name = "";
                    String national_id = "";
                    String str_national_id=txt_Phone_number.getText();
                    
                    hash = new Hashtable();
                    hash.put("Contact", txt_Phone_number.getText());
                    final Result res=Result.fromContent(hash);
                    final String checkthis=res.toString();
//                   String myUrl="http://localhost:50111/SearchMemberID";  
                    String myUrl="https://b2cmanager.co.ke/TUISHIMOBWB/SearchMemberID";

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

                    Label lbl_progress = new Label("Searching Member ...\n, Please Wait...");
                    lbl_progress.getStyle().setFgColor(0xffffff, false);
                    lbl_progress.getStyle().setBgTransparency(0);
                    dlg_progress.addComponent(BorderLayout.CENTER, FlowLayout.encloseCenterBottom(lbl_progress, inftprogress));
                    dlg_progress.setTransitionInAnimator(CommonTransitions.createEmpty());
                    dlg_progress.setTransitionOutAnimator(CommonTransitions.createEmpty());
                    dlg_progress.showPacked(BorderLayout.CENTER, false);
                    request.setDisposeOnCompletion(dlg_progress);

                    NetworkManager.getInstance().addToQueueAndWait(request);
                    request.setDisposeOnCompletion(dlg_progress);


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
                        Reply=map_response2.get("showreply").toString();
                        Member_id=map_response2.get("accno").toString();
                        surname=map_response2.get("surname").toString().toUpperCase();
                        christian_name=map_response2.get("christian_name").toString().toUpperCase();
                        middle_name=map_response2.get("middle_name").toString().toUpperCase();
                        national_id=map_response2.get("national_id").toString();
                        
                        //Log.p("Successfully Completed"+str_AppAuth, 1);
                    }
                    else
                    {
                        Storage.getInstance().writeObject("respcode",  String.valueOf(request.getResponseCode()));
                        Storage.getInstance().writeObject("resptext", "Please contact the application service provider!");
                    }

                    if(Reply.equals("exist"))
                    {
                        Dialog.show("Member Exists", ""+christian_name+" "+middle_name+" "+surname+" "
                        + "\nID Number is :"+national_id
                                +"\n The Member Number is "+ Member_id, "OK", null);
            
                    }
                    else if(Reply.equals("sorry"))
                    {
                        Dialog.show("Member Does Not Exist!!!", "That Phone Number is not registered\n"
                                + "   with Tuishi Companion", "OK", null);
                    }
                    else
                    {
                        Dialog.show("Error", "Something went wrong, try checking your connection and try again later.", "OK", null);
                    } 
                    
                }
            }
        });
        
        cnt_box = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_box.add(cnt_search);
        cnt_box.add(spaceLabel);
        cnt_box.add(spaceLabel2);
        cnt_box.add(btn_search);

        boxStyle2 = cnt_box.getUnselectedStyle();
        boxStyle2.setBgTransparency(255);
        boxStyle2.setBgColor(0xeeeeee);
        boxStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setPaddingUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setMargin(4, 3, 3, 3);
        boxStyle2.setPadding(2, 2, 2, 2);
        
        fm_serach_member = new Form(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER));

        Image profilePic = theme.getImage("Screenshot_20220731-102041.png");
        Image mask = theme.getImage("veryhigh.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label("  Tuishi Companion", profilePic, "SideMenuTitle");
        profilePicLabel.setMask(mask.createMask());
        
        tb=fm_serach_member.getToolbar();
        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
        
        tb.addComponentToSideMenu(sidemenuTop);
        tb.addMaterialCommandToSideMenu("  Dashboard", FontImage.MATERIAL_DASHBOARD,  new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new RegistrationForm().Regstrationscreen(theme);
            }
        });
        tb.addMaterialCommandToSideMenu("  Registration", FontImage.MATERIAL_PERSON_ADD,  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new RegistrationForm().Regstrationscreen(theme);
            }
        }
        );
        tb.addMaterialCommandToSideMenu("  Search Member Reg. No", FontImage.MATERIAL_SEARCH,  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new SearchMemberForm().searchscreen();
            }
        }
        );
        tb.addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP,  new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                bool_username_exist = Storage.getInstance().exists("credential_username");
                if(bool_username_exist)
                {
                    Storage.getInstance().deleteStorageFile("credential_username");
                    Storage.getInstance().deleteStorageFile("credential_password");
                }
                new LoginForm().loginscreen();
            }
        });
        
            fm_serach_member.add(BorderLayout.CENTER, cnt_box);
            fm_serach_member.isScrollableY();
            
        fm_serach_member.show();
    }
}
