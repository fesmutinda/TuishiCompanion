/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snashy.swizzsoft;

import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
import com.codename1.ui.Calendar;
import com.codename1.ui.Component;
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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.util.StringUtil;
import java.util.Date;

/**
 *
 * @author Festus2032
 */
public class RegistrationForm 
{
    String str_counties_db = Storage.getInstance().readObject("GetCounties.json").toString();
   
    protected com.codename1.ui.ComboBox cbox_ge = new com.codename1.ui.ComboBox("--Select Gender--","MALE","FEMALE","Other");
    protected com.codename1.ui.ComboBox cbox_status = new com.codename1.ui.ComboBox("--Select Marital Status--","MARRIED","DIVORCED","SINGLE");
    String mobile_number = "";
    String CountryCode="";
    private TextField txt_dobirth,txt_first_name,txt_second_name,txt_surname,txt_id_number,txt_phone,txt_village,txt_address;
    
    private Dialog dlg_setDate;
    private Calendar cldr_bday;
    private Date dt_timer, dt_start, dt_selected, dt_end, dt_alert;
    private String str_saahii, str_hrs, str_min, str_ssaahii, str_sday, str_sdate, str_smonth, str_syear, str_shrs, str_smin, str_sapm, str_esaahii, str_eday, str_edate, str_emonth, str_eyear, str_ehrs, str_emin, str_eapm;
    private Container cnt_confirmORcancel_date,cnt_remember_pass,cnt_box;
    private SimpleDateFormat dateformat;
    
    private StringBuilder sb_counties;
    private Integer int_count_counties, i, j, k;
    private String str_county;
    
    private StringBuilder sb_options;
    
    private AutoCompleteTextField ac_counties;
    private Integer int_nu_counties;
    
    private String str_counties;
    
    private String str_jimbo;
    private String[] str_majimbo;
    
    private Style boxStyle2,style_first_name,style_second_name,style_surname,style_dobirth,style_gender,style_idno,style_mobile,style_maritalS,style_county,style_ac_counties,style_postadd,style_vllage;
    private Form fm_regscreen;       
    private Toolbar tb;
    private Boolean bool_username_exist;
    
    
    public void Regstrationscreen(Resources theme)
    {
        fm_regscreen = new Form("Primary Member Details");
        TableLayout tl;

         int spanButton = 2;
        if(Display.getInstance().isTablet()) 
        {
            tl = new TableLayout(7, 2);
        } 
        else 
        {
            tl = new TableLayout(14, 1);
            spanButton = 1;
        }
        
        tl.setGrowHorizontally(true);
        fm_regscreen.setLayout(tl);

        
        Image profilePic = theme.getImage("Screenshot_20220731-102041.png");
        Image mask = theme.getImage("veryhigh.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
        profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
        Label profilePicLabel = new Label("  Tuishi Companion", profilePic, "SideMenuTitle");
//        Label profilePicLabel = new Label("", "SideMenuTitle");
        profilePicLabel.setMask(mask.createMask());
        
        tb=fm_regscreen.getToolbar();
        Container sidemenuTop = BorderLayout.center(profilePicLabel);
        sidemenuTop.setUIID("SidemenuTop");
        
        tb.addComponentToSideMenu(sidemenuTop);
        tb.addMaterialCommandToSideMenu("  Dashboard", FontImage.MATERIAL_DASHBOARD,  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new RegistrationForm().Regstrationscreen(theme);
            }
        }
        );
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
//        tb.addMaterialCommandToSideMenu("  Account Settings", FontImage.MATERIAL_SETTINGS,  e -> showOtherForm(res));
        tb.addMaterialCommandToSideMenu("  Logout", FontImage.MATERIAL_EXIT_TO_APP,  new ActionListener() {
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
        }
        );
        
        
        boxStyle2 = fm_regscreen.getUnselectedStyle();
        boxStyle2.setBgTransparency(255);
        boxStyle2.setBgColor(0xeeeeee);
        boxStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setPaddingUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setMargin(1, 1, 1, 1);
        boxStyle2.setPadding(1, 1, 1, 1);

        txt_first_name = new TextField("");
        txt_first_name.setHint("First Name");
        fm_regscreen.addComponent(txt_first_name);

        style_first_name = txt_first_name.getAllStyles();
        Stroke borderStroke = new Stroke(2, Stroke.CAP_ROUND, Stroke.JOIN_MITER, 1);
        style_first_name.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(150).stroke(borderStroke));
        style_first_name.setBgColor(0xffffff);
        style_first_name.setBgTransparency(100);
        style_first_name.setMarginUnit(Style.UNIT_TYPE_DIPS);
        style_first_name.setMargin(Component.BOTTOM, 1);

        txt_second_name = new TextField();
        txt_second_name.setHint("Middle Name");
        fm_regscreen.addComponent(txt_second_name);

        style_second_name = txt_second_name.getAllStyles();
        style_second_name.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_second_name.setBgColor(0xffffff);
        style_second_name.setBgTransparency(100);

        txt_surname = new TextField();
        txt_surname.setHint("Surname");
        fm_regscreen.addComponent(txt_surname);
    //                                                                                                                        borderStroke = new Stroke(2, Stroke.CAP_ROUND, Stroke.JOIN_MITER, 1);
        style_surname = txt_surname.getAllStyles();
        style_surname.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_surname.setBgColor(0xffffff);
        style_surname.setBgTransparency(100);

        txt_dobirth = new TextField();
        txt_dobirth.setHint("Date of Birth");
        txt_dobirth.setConstraint(TextArea.NUMERIC);
        fm_regscreen.addComponent(txt_dobirth);
        style_dobirth = txt_dobirth.getAllStyles();
        style_dobirth.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_dobirth.setBgColor(0xffffff);
        style_dobirth.setBgTransparency(100);
        txt_dobirth.addPointerPressedListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
               showDaySelector();
            }
        });

        cbox_ge.setPreferredSizeStr("128.57143mm inherit");
        cbox_ge.setName("Combo_Box");
        fm_regscreen.addComponent(cbox_ge);
        style_gender = cbox_ge.getAllStyles();
        style_gender.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_gender.setBgColor(0xffffff);
        style_gender.setBgTransparency(100);

        txt_id_number = new TextField();
        txt_id_number.setHint("Id Number");
        txt_id_number.setConstraint(TextArea.NUMERIC);
        fm_regscreen.addComponent(txt_id_number);
        style_idno = txt_id_number.getAllStyles();
        style_idno.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_idno.setBgColor(0xffffff);
        style_idno.setBgTransparency(100);

        txt_phone = new TextField();
        txt_phone.setHint("254 Phone Number");
        txt_phone.setConstraint(TextArea.PHONENUMBER);
        fm_regscreen.addComponent(txt_phone);
        style_mobile = txt_phone.getAllStyles();
        style_mobile.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_mobile.setBgColor(0xffffff);
        style_mobile.setBgTransparency(100);

        cbox_status.setPreferredSizeStr("128.57143mm inherit");
        cbox_status.setName("Combo_Box");
        fm_regscreen.addComponent(cbox_status);
        style_maritalS = cbox_status.getAllStyles();
        style_maritalS.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_maritalS.setBgColor(0xffffff);
        style_maritalS.setBgTransparency(100);

        ac_counties = new AutoCompleteTextField();
        ac_counties.setHint("County");
        ac_counties.getUnselectedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, true)); 
        ac_counties.getUnselectedStyle().getBorder().setThickness(3);
        ac_counties.getSelectedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, true)); 
        ac_counties.getSelectedStyle().getBorder().setThickness(3);
        ac_counties.getPressedStyle().setBorder(Border.createRoundBorder(25, 25, 0x000000, true)); 
        ac_counties.getPressedStyle().getBorder().setThickness(3);

        style_ac_counties = ac_counties.getAllStyles();
        style_ac_counties.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_ac_counties.setBgColor(0xffffff);
        style_ac_counties.setBgTransparency(100);

        str_counties = Storage.getInstance().readObject("GetCounties.json").toString();
        str_counties = StringUtil.replaceAll(str_counties, "\"", "");

        int_nu_counties = 47; //str_arr_counties.length; //47

        str_majimbo = new String[int_nu_counties];

        for(i=0 ; i<int_nu_counties; i++) 
        {
            str_jimbo = StringUtil.tokenize(str_counties, ",").get(i);

            str_majimbo[i] = str_jimbo;
        }

        ac_counties.setCompletion(str_majimbo);

        fm_regscreen.addComponent(ac_counties);


        txt_village = new TextField();
        txt_village.setHint("Village/Town");
        fm_regscreen.addComponent(txt_village);
        style_vllage = txt_village.getAllStyles();
        style_vllage.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_vllage.setBgColor(0xffffff);
        style_vllage.setBgTransparency(100);

        txt_address = new TextField();
        txt_address.setHint("Postal Address");
        fm_regscreen.addComponent(txt_address);
        style_postadd = txt_address.getAllStyles();
        style_postadd.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_postadd.setBgColor(0xffffff);
        style_postadd.setBgTransparency(100);

        Button submit = new Button("Submit");
        fm_regscreen.addComponent(submit);

        Validator v = new Validator();
        v.addConstraint(txt_first_name, new LengthConstraint(3,"Enter Middle Name")).
        addConstraint(txt_second_name, new LengthConstraint(3)).
        addConstraint(txt_surname, new LengthConstraint(3)).
        addConstraint(txt_phone, new LengthConstraint(10)).
        addConstraint(txt_id_number, new LengthConstraint(4)).
        addConstraint(txt_phone, new RegexConstraint(txt_phone.getText(), "Must be valid phone number"));


         v.addSubmitButtons(submit);
         submit.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                if(txt_first_name.getText().equals("")||txt_second_name.getText().equals("")||txt_surname.getText().equals("")||txt_id_number.getText().equals("")||ac_counties.getText().equals("")||txt_village.getText().equals("")||txt_phone.getText().equals(""))    //|ac_search.getText().equals("")|
                {                    
                    Dialog.show("Error!", "Please fill all your Details", "OK", null);
                }
                 else if(cbox_ge.getSelectedItem().equals("--Select Gender--"))
                 {
                     Dialog.show("Error!", "Please Select Gender", "OK", null);
                 }
                 else if(cbox_status.getSelectedItem().equals("--Select Marital Status--"))
                 {
                     Dialog.show("Error!", "Please Select Marital Status", "OK", null);
                 }
                else
                {
                    String mobile_number = txt_phone.getText();
                    String CountryCode = mobile_number.substring(0, 3);

                    if (CountryCode.trim().equals("254"))
                    {
                        int mycount = mobile_number.length();
                        if (mycount < 12){
                            Dialog.show("SORRY!!!", "THE PHONE NUMBER FORMAT IS WRONG:", "OK", null);
                        }
                        else if (mycount > 12){
                            Dialog.show("SORRY!!!", "THE PHONE NUMBER FORMAT IS NOT SUPPORTED:", "OK", null);
                        }
                        else if (mycount == 12)
                        {
                            //here its it is...

                            Storage.getInstance().writeObject("FirstName", txt_first_name.getText().toUpperCase());
                            Storage.getInstance().writeObject("MiddleName", txt_second_name.getText().toUpperCase()); 
                            Storage.getInstance().writeObject("Surname", txt_surname.getText().toUpperCase());
                            Storage.getInstance().writeObject("DateofBirth", txt_dobirth.getText().toUpperCase());
                            Storage.getInstance().writeObject("Gender", cbox_ge.getSelectedItem());
                            Storage.getInstance().writeObject("NationalID", txt_id_number.getText().toUpperCase());
                            Storage.getInstance().writeObject("MaritalStatus", cbox_status.getSelectedItem());
                            Storage.getInstance().writeObject("County", ac_counties.getText().toUpperCase());
                            Storage.getInstance().writeObject("Village", txt_village.getText().toUpperCase());
                            Storage.getInstance().writeObject("PostalAddress", txt_address.getText().toUpperCase());
                            Storage.getInstance().writeObject("Contact", txt_phone.getText().toUpperCase());

                            new PackageForm().packagescreen();
                        }
                    }
                    else //(CountryCode.trim() != "254")
                    {
                        Dialog.show("SORRY!!!", "ENTER THE PHONE NUMBER WITH THE COUNTRY CODE:", "OK", null);
                    }
                }

            }
        });
         
        Button btnBack = new Button("CANCEL PROCESS");
        btnBack.setUIID("CancelButton");
        btnBack.getStyle().getAlignment();
        btnBack.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new RegistrationForm().Regstrationscreen(theme);
            }
        });


        fm_regscreen.add(btnBack);
        Label lbsp=new Label("");
        lbsp.getStyle().setBgColor(0x00b1ff);
        lbsp.setAlignment(CENTER);
        lbsp.setUIID("lbl1");

        fm_regscreen.add(lbsp);
//        fm_regscreen.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_MENU, new ActionListener()    
//        {
//            @Override
//            public void actionPerformed(ActionEvent evt) 
//            {
//                //cancel the process
//                tb.showToolbar();
//            }
//        });
        fm_regscreen.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_FORWARD, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                new DependantsForm().Regstrationscreen();
            }
        });
        fm_regscreen.show();
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



          Log.p("Converting date to format that server accepts.", 1);
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

            txt_dobirth.setText(str_sdate+"-"+str_smonth+"-"+str_syear);
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
