/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snashy.swizzsoft;

import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.processing.Result;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.validation.LengthConstraint;
import com.codename1.ui.validation.RegexConstraint;
import com.codename1.ui.validation.Validator;
import com.codename1.util.StringUtil;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author Festus2032
 */
public class DependantsForm 
{
    String[] characters = { "BROTHER", "SON", "DAUGHTER", "MOTHER", "FATHER", "WIFE", "SISTER", "UNCLE","AUNTIE",
    "COUSIN","SIBLING" };
    
    protected com.codename1.ui.ComboBox cbox_status = new com.codename1.ui.ComboBox("Married","Divorced","Single");
    protected com.codename1.ui.ComboBox cbox_ge = new com.codename1.ui.ComboBox("--Select Gender--","MALE","FEMALE","Other");
    
    public Stroke borderStroke;
    public Form regscreen;
    public Style boxStyle2, style_name1,style_name2, style_name3, style_dobirth, style_gender, style_idno, style_phone, style_rel;
    public TextField txtname, txtname2, txtname3, txt_dobirth, txtidno, txtphone;
    public AutoCompleteTextField txtrelation;
    public Button submit, btnBack;
    
    public Resources theme;
    
    private Dialog dlg_setDate;
    private Calendar cldr_bday;
    private Date dt_timer, dt_start, dt_selected, dt_end, dt_alert;
    private String str_saahii, str_hrs, str_min, str_ssaahii, str_sday, str_sdate, str_smonth, str_syear, str_shrs, str_smin, str_sapm, str_esaahii, str_eday, str_edate, str_emonth, str_eyear, str_ehrs, str_emin, str_eapm;
    private Container cnt_confirmORcancel_date,cnt_remember_pass,cnt_box;
    private SimpleDateFormat dateformat;
    
    public void Regstrationscreen()
    {
        theme=UIManager.initFirstTheme("/theme");
        
        borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        regscreen = new Form("ADD DEPENDANTS:");
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
        regscreen.setLayout(tl);
        
        boxStyle2 = regscreen.getUnselectedStyle();
        boxStyle2.setBgTransparency(255);
        boxStyle2.setBgColor(0xeeeeee);
        boxStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setPaddingUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setMargin(4, 3, 3, 3);
        boxStyle2.setPadding(2, 2, 2, 2);
    
        txtname = new TextField();
        txtname.setHint("First Name");
        regscreen.addComponent(txtname);
        style_name1 = txtname.getAllStyles();
        style_name1.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_name1.setBgColor(0xffffff);
        style_name1.setBgTransparency(100);

        txtname2 = new TextField();
        txtname2.setHint("Middle Name");
        regscreen.addComponent(txtname2);
        style_name2 = txtname2.getAllStyles();
        style_name2.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_name2.setBgColor(0xffffff);
        style_name2.setBgTransparency(100);
    
        txtname3 = new TextField();
        txtname3.setHint("Surname");
        regscreen.addComponent(txtname3);
        style_name3 = txtname3.getAllStyles();
        style_name3.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_name3.setBgColor(0xffffff);
        style_name3.setBgTransparency(100);
    
        txt_dobirth = new TextField();
        txt_dobirth.setHint("Date of Bith");
        regscreen.addComponent(txt_dobirth);
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
        regscreen.addComponent(cbox_ge);
        style_gender = cbox_ge.getAllStyles();
        style_gender.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_gender.setBgColor(0xffffff);
        style_gender.setBgTransparency(100);
    
        txtidno = new TextField();
        txtidno.setHint("ID Number");
        txtidno.setConstraint(TextArea.NUMERIC);
        regscreen.addComponent(txtidno);
        style_idno = txtidno.getAllStyles();
        style_idno.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_idno.setBgColor(0xffffff);
        style_idno.setBgTransparency(100);
    
        txtphone = new TextField();
        txtphone.setHint("Phone Number");
        txtphone.setConstraint(TextArea.PHONENUMBER);
        regscreen.addComponent(txtphone);
        style_phone = txtphone.getAllStyles();
        style_phone.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_phone.setBgColor(0xffffff);
        style_phone.setBgTransparency(100);
    
        txtrelation = new AutoCompleteTextField(characters);
        txtrelation.setHint("Relationship");
        regscreen.addComponent(txtrelation);
        style_rel = txtrelation.getAllStyles();
        style_rel.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_rel.setBgColor(0xffffff);
        style_rel.setBgTransparency(100);

        submit = new Button("Submit");
        regscreen.addComponent(submit);
    
        Validator v = new Validator();
        v.addConstraint(txtname, new LengthConstraint(3)).
//            addConstraint(txtname2, new LengthConstraint(3)).
            addConstraint(txtname3, new LengthConstraint(3)).
            addConstraint(txtphone, new LengthConstraint(10)).
            addConstraint(txtidno, new LengthConstraint(4)).
            addConstraint(txtphone, new RegexConstraint(txtphone.getText(), "Must be valid phone number"));
            

         v.addSubmitButtons(submit);
         submit.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                if(txtname3.getText().equals("")||txtname.getText().equals("")||txtidno.getText().equals("")||txtphone.getText().equals("")||txtrelation.getText().equals(""))
                {                    
                    Dialog.show("Error", "Please fill all the Reguired Details", "OK", null);
                }
                else if(cbox_ge.getSelectedItem().equals("--Select Gender--"))
                {
                     Dialog.show("Error!", "Please Select Gender", "OK", null);
                }                
                else
                {
                    String NationalID=Storage.getInstance().readObject("NationalID").toString();
                    String UserName=Storage.getInstance().readObject("UserName").toString();

                    Hashtable hash=new Hashtable();
                    hash.put("Surname", txtname3.getText());
                    hash.put("MiddleName", txtname2.getText());
                    hash.put("FirstName", txtname.getText());
                    hash.put("DateofBirth", txt_dobirth.getText());
                    hash.put("Gender", cbox_ge.getSelectedItem());
                    hash.put("IDNumber", txtidno.getText());
                    hash.put("Contact", txtphone.getText());
                    hash.put("Relationship", txtrelation.getText());
                    hash.put("UserName",UserName);

                    hash.put("ReadIdCopy", NationalID);
                    
//                    /*--------TO THE SERVER------*/

                    final Result res=Result.fromContent(hash);
                    final String checkthis=res.toString();
                    String myUrl="https://b2cmanager.co.ke/TUISHIMOBWB/RegisterDependant";
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
                    
                    if(Reply.equals("SuccesfullyRecieved"))
                    {
                        Dialog.show("SuccesfullyRecieved", "Details Succesfuly Recieved", "OK", null);
                         /*----redirect---*/
                        new NextOfKinForm().nxtofkscreen();
                    }
                    else if(Reply.equals("sorry"))
                    {
                        Dialog.show("SORRY!!!", "Seems their is a problem updating spouse details... try again", "OK", null);
                    }
                    else
                    {
                        Dialog.show("ERROR!!!", "Something went wrong, try checking your connection and try again later.", "OK", null);
                    } 
                }
            }
        });
        btnBack = new Button("CANCEL PROCESS");
        btnBack.setUIID("CancelButton");
        btnBack.getStyle().getAlignment();
        btnBack.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new DependantsForm().Regstrationscreen();
            }
        });
        
        regscreen.add(btnBack);
        Label lbsp=new Label("");
        lbsp.getStyle().setBgColor(0x00b1ff);
        lbsp.setAlignment(CENTER);
        lbsp.setUIID("lbl1");
        
        regscreen.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, new ActionListener()    
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new RegistrationForm().Regstrationscreen(theme);
            }
        });
        regscreen.add(lbsp);
        regscreen.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_FORWARD, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                new NextOfKinForm().nxtofkscreen();
            }
        });

        regscreen.show();
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
