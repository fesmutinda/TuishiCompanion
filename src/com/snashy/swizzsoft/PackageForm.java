/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snashy.swizzsoft;

import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Festus2032
 */
public class PackageForm 
{
        protected com.codename1.ui.ComboBox cbo_MemberShipCode = new com.codename1.ui.ComboBox("Gold","Diamond","Platinum","Alpha","Alpha Plus","Gold Extra","Diamond Extra","Extra Alpha","Extra Alpha Plus");
    private Button btnsubmit,btncancel;
    private Container cnt_rbGp,cnt_lbl,cnt_btn ,cnt_member_level;
    
    private CheckBox cbsavings;
    private Style style_maritalS ,style_rbmedical ,style_hybrid, style_rblastex ,boxStyle2, style_txtcode, style_membercode;
    private RadioButton rb_medical ,rb_lastexpense ,rb_hybrid;
    private Form fm_regscreen;
    private Label lbltite;
    private Form packs;
    
    public Resources theme;
    
     public void packagescreen()
    {
        theme=UIManager.initFirstTheme("/theme");
        
        String packagechoice="";
        String savings="";
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);

        lbltite=new Label("Select Your Package");
        lbltite.getAllStyles().getBgColor();
        lbltite.setUIID("lbl1");
        
        cnt_lbl=new Container();
        cnt_lbl.add(lbltite);
        
        btncancel=new Button();
        btncancel.setText("Cancel");
        btncancel.setUIID("CancelButton");
        btncancel.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new RegistrationForm().Regstrationscreen(theme);
            }
        });                
        
        btnsubmit=new Button();
        btnsubmit.setText("Submit");
        
        ///----------
        cbsavings = new CheckBox("Savings");
        style_maritalS = cbsavings.getAllStyles();
        style_maritalS.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_maritalS.setBgColor(0xffffff);
        style_maritalS.setBgTransparency(100);
    
        cbsavings.setOppositeSide(false);
        rb_medical = new RadioButton("Medical");
        style_rbmedical = rb_medical.getAllStyles();
        style_rbmedical.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_rbmedical.setBgColor(0xffffff);
        style_rbmedical.setBgTransparency(100);
    
        rb_lastexpense = new RadioButton("Last Expense");
        style_rblastex = rb_lastexpense.getAllStyles();
        style_rblastex.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_rblastex.setBgColor(0xffffff);
        style_rblastex.setBgTransparency(100);
        
        rb_hybrid = new RadioButton("Hybrid(Medical & Last Expense)");
        style_hybrid = rb_hybrid.getAllStyles();
        style_hybrid.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_hybrid.setBgColor(0xffffff);
        style_hybrid.setBgTransparency(100);
        
        new ButtonGroup(rb_medical, rb_lastexpense, rb_hybrid);
        
        rb_medical.setSelected(true);
        
        if(rb_medical.isSelected())
        {
            Log.p("Medical selected", 1);
            packagechoice="MEDICAL";
        }
        
        else  if(rb_lastexpense.isSelected())
        {
            Log.p("LastExpense is selected", 1);
            packagechoice="LAST EXPENSE";
        }
        
        else  if(rb_hybrid.isSelected())
        {
            packagechoice="HYBRID";
        }
        
        final String selectedpackage=packagechoice;
         if(cbsavings.isSelected())
         {
             savings="Savings";
         }
         else 
         {
             savings="NO";
         }
         final String savingtick=savings;       
        
                
        cnt_member_level=new Container();
        cnt_member_level.addComponent(new Label(" "));
        cnt_member_level.addComponent(new Label("Membership Level"));
        cbo_MemberShipCode.setPreferredSizeStr("128.57143mm inherit");
        cbo_MemberShipCode.setName("Combo_Box");
        cnt_member_level.addComponent(cbo_MemberShipCode);
        
        style_membercode = cbo_MemberShipCode.getAllStyles();
        style_membercode.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_membercode.setBgColor(0xffffff);
        style_membercode.setBgTransparency(100);
        
        cnt_member_level.addComponent(new Label("M-pesa Reference Code"));
        
        TextField txtCode = new TextField();
        cnt_member_level.addComponent(txtCode);
        style_txtcode = txtCode.getAllStyles();
        style_txtcode.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_txtcode.setBgColor(0xffffff);
        style_txtcode.setBgTransparency(100);

        Label lblps=new Label("  ");
        cnt_btn=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_btn.add(lblps);
        cnt_btn.add(GridLayout.encloseIn(2, btnsubmit, btncancel));
        
        
        cnt_rbGp=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_rbGp.add(rb_medical).add(rb_lastexpense).add(rb_hybrid);
        cnt_rbGp.add(cnt_member_level);
        
        //.....final container
        Container cnt_box = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        cnt_box.add(cnt_rbGp);
        btnsubmit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                if(txtCode.getText().equals(""))
                {
                    Dialog.show("Sorry!!", "Please Provide the M-pesa code", "OK", null);
                }
                else
                {
                    Storage.getInstance().writeObject("PackageType", selectedpackage);
                    Storage.getInstance().writeObject("Savingscheck", savingtick); 
                    Storage.getInstance().writeObject("MemberShipCode", cbo_MemberShipCode.getSelectedItem());
                    Storage.getInstance().writeObject("MpesaCode", txtCode.getText());

                    RegDetails reg=new RegDetails();
                    reg.sendDetails();
                }
            }
        });
                            

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

        boxStyle2 = fm_regscreen.getUnselectedStyle();
        boxStyle2.setBgTransparency(255);
        boxStyle2.setBgColor(0xeeeeee);
        boxStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setPaddingUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setMargin(4, 3, 3, 3);
        boxStyle2.setPadding(2, 2, 2, 2);

        fm_regscreen.addComponent(cnt_lbl);
        fm_regscreen.addComponent(cnt_box);
        fm_regscreen.addComponent(cnt_btn);
        fm_regscreen.show();
            
    }
}
