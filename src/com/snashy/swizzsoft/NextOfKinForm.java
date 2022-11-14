package com.snashy.swizzsoft;

import com.codename1.io.Storage;
import com.codename1.processing.Result;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
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
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.table.TableLayout;
import com.codename1.ui.validation.Validator;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author Festus2032
 */
public class NextOfKinForm 
{
    String[] characters = { "BROTHER", "MOTHER", "FATHER", "WIFE", "SISTER", "UNCLE","AUNTIE",
    "COUSIN","SIBLING" /* just a few relatives */
};
    
    public Stroke borderStroke;
    public Form fm_next_of_kin;
    public Style boxStyle2, sty_first_name, sty_middle_name, style_surname,style_idno, style_phone,style_rel;
    public Label lblnext1, lbsp;
    public TextField txt_first_name, txt_middle_name, txt_surname, txt_id_number, txt_phone_number;
    public AutoCompleteTextField auto_relationship;
    public Button btn_submit, btn_Back;
    public Hashtable hash;
    
    public void nxtofkscreen()
    {
        borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        fm_next_of_kin = new Form("ADD NEXT OF KIN:");
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
        fm_next_of_kin.setLayout(tl);
        boxStyle2 = fm_next_of_kin.getUnselectedStyle();
        boxStyle2.setBgTransparency(255);
        boxStyle2.setBgColor(0xeeeeee);
        boxStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setPaddingUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setMargin(4, 3, 3, 3);
        boxStyle2.setPadding(2, 2, 2, 2);

        lblnext1=new Label("Next OF Kin Details");       //__------------<<<<<<<<<<<<<<<<
        lblnext1.getStyle().setBgColor(0x00b1ff);
        lblnext1.setAlignment(CENTER);
        lblnext1.setUIID("lbl1");
        
        txt_first_name = new TextField();
        txt_first_name.setHint("First Name");
        fm_next_of_kin.addComponent(txt_first_name);
        sty_first_name = txt_first_name.getAllStyles();
        sty_first_name.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        sty_first_name.setBgColor(0xffffff);
        sty_first_name.setBgTransparency(100);
        
        txt_middle_name = new TextField();
        txt_middle_name.setHint("Middle Name");
        fm_next_of_kin.addComponent(txt_middle_name);
        sty_middle_name = txt_middle_name.getAllStyles();
        sty_middle_name.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        sty_middle_name.setBgColor(0xffffff);
        sty_middle_name.setBgTransparency(100);
    
        txt_surname = new TextField();
        txt_surname.setHint("Surname");
        fm_next_of_kin.addComponent(txt_surname);
        style_surname = txt_surname.getAllStyles();
        style_surname.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_surname.setBgColor(0xffffff);
        style_surname.setBgTransparency(100);
    
        txt_id_number = new TextField();
        txt_id_number.setHint("ID Number");
        txt_id_number.setConstraint(TextArea.NUMERIC);
        fm_next_of_kin.addComponent(txt_id_number);
        style_idno = txt_id_number.getAllStyles();
        style_idno.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_idno.setBgColor(0xffffff);
        style_idno.setBgTransparency(100);
    
        txt_phone_number = new TextField();
        txt_phone_number.setHint("Phone Number");
        txt_phone_number.setConstraint(TextArea.PHONENUMBER);
        fm_next_of_kin.addComponent(txt_phone_number);
        style_phone = txt_phone_number.getAllStyles();
        style_phone.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_phone.setBgColor(0xffffff);
        style_phone.setBgTransparency(100);
    
        auto_relationship = new AutoCompleteTextField(characters);
        fm_next_of_kin.addComponent(auto_relationship);
        auto_relationship.setHint("Relationship");
        style_rel = auto_relationship.getAllStyles();
        style_rel.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
        style_rel.setBgColor(0xffffff);
        style_rel.setBgTransparency(100);
    
        btn_submit = new Button("Submit");
        fm_next_of_kin.addComponent(btn_submit);

        Validator v = new Validator();
    //    v.addConstraint(txt_first_name, new LengthConstraint(3,"Enter Middle Name")).
    //            addConstraint(txt_middle_name, new LengthConstraint(3)).
    //            addConstraint(txt_surname, new LengthConstraint(3)).
    //            addConstraint(txt_phone_number, new LengthConstraint(10)).
    ////            addConstraint(txt_id_number, new LengthConstraint(4)).
    ////            addConstraint(txt_phone_number, new RegexConstraint(txt_phone_number.getText(), "Must be valid phone number"));
    ////            
        btn_submit.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                if(txt_surname.getText().equals("")||txt_first_name.getText().equals("")||txt_id_number.getText().equals("")||txt_phone_number.getText().equals("")||auto_relationship.getText().equals(""))
                {                    
                    Dialog.show("Error", "Please fill all clients Details", "OK", null);
                }                
                else
                {
                    String NationalID=Storage.getInstance().readObject("NationalID").toString();
                    String UserName=Storage.getInstance().readObject("UserName").toString();
                    
                    hash = new Hashtable();
                    hash.put("Surname", txt_surname.getText());
                    hash.put("MiddleName", txt_middle_name.getText());
                    hash.put("FirstName", txt_first_name.getText());
                    hash.put("IDNumber", txt_id_number.getText());
                    hash.put("Contact", txt_phone_number.getText());
                    hash.put("Relationship", auto_relationship.getText());
                    
                    hash.put("ReadIdCopy", NationalID);
                    hash.put("UserName",UserName);
                    
                    final Result res=Result.fromContent(hash);
                    final String checkthis=res.toString();
                    String myUrl="https://b2cmanager.co.ke/TUISHIMOBWB/NextofKin";
                    String Reply="";
//                    /*--------TO THE SERVER------*/
                    requestclass c=new requestclass(); 
                    try 
                    {
                        Reply=c.checking(checkthis,myUrl);
                    } catch (IOException ex) 
                    {
//                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (requestclass.JSONException ex) 
                    {
//                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(Reply.equals("SuccesfullyRecieved"))
                    {
                        Dialog.show("SuccesfullyRecieved", "Details Succesfuly Recieved", "OK", null);
                         /*----redirect---*/
                         new ChildrenForm().showMainForm();
            
                    }
                    else if(Reply.equals("sorry"))
                    {
                        Dialog.show("SORRY!!!", "Seems their is a problem updating Next of kin details... try again", "OK", null);
                    }
                    else
                    {
                        Dialog.show("Error", "Something went wrong, try checking your connection and try again later.", "OK", null);
                    } 
                }
            }
        });
        
        btn_Back = new Button("CANCEL");
        btn_Back.setUIID("CancelButton");
        btn_Back.getStyle().getAlignment();
        btn_Back.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
//                new RegistrationForm().Regstrationscreen(theme);
                new NextOfKinForm().nxtofkscreen();
            }
        });
        
        v.addSubmitButtons(btn_submit);
        fm_next_of_kin.add(btn_Back);
        
        lbsp=new Label("");
        lbsp.getStyle().setBgColor(0x00b1ff);
        lbsp.setAlignment(CENTER);
        lbsp.setUIID("lbl1");
        
        fm_next_of_kin.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, new ActionListener()    
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                //cancel the process
                new DependantsForm().Regstrationscreen();
            }
        });
        
        fm_next_of_kin.getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_FORWARD, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                new ChildrenForm().showMainForm();
            }
        });
        fm_next_of_kin.add(lbsp);
        fm_next_of_kin.show();
    
    }

}
