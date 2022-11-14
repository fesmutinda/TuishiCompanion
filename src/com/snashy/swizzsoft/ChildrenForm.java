/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.snashy.swizzsoft;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.Log;
import com.codename1.io.Storage;
import com.codename1.processing.Result;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author Festus2032
 */
public class ChildrenForm 
{
    private Form fm_main;
    private SpanLabel slbl_head;
    
    private Button btn_save;
    private FloatingActionButton fab;
    
    private Container cnt_children;
    
    private String str_count_children;
    private Integer int_count_children;
    private Boolean bool_count_children;
    private StringBuilder sb_children;
    
    private String str_children, str_child;
    
    private String str_firstname, str_lastname, str_birth, str_dbirth;
    private Boolean bool_firstname, bool_lastname, bool_birth, bool_dbirth;
    
    private int i,j,k, int_max_children;
    
    private Style boxStyle2, style_name, style_lname, style_birth, style_dbth;
    private Label lbl_id;
    private TextField txtname, txtlastname, txtbirth, txtdbirth;

    public void showMainForm() 
    {
        Stroke borderStroke = new Stroke(2, Stroke.CAP_SQUARE, Stroke.JOIN_MITER, 1);
        
        fm_main = new Form("CHILDREN DETAILS :");
        fm_main.setLayout(new BorderLayout());
        
        boxStyle2 = fm_main.getUnselectedStyle();
        boxStyle2.setBgTransparency(255);
        boxStyle2.setBgColor(0xeeeeee);
        boxStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setPaddingUnit(Style.UNIT_TYPE_DIPS);
        boxStyle2.setMargin(4, 3, 3, 3);
        boxStyle2.setPadding(2, 2, 2, 2);
        
        cnt_children = new Container();
        cnt_children.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        cnt_children.setScrollableY(true);
        
        bool_count_children = Storage.getInstance().exists("count_children");
        if(bool_count_children)
        {
            str_count_children = Storage.getInstance().readObject("count_children").toString();
            int_count_children = Integer.parseInt(str_count_children);
        }
        else
        {
            int_count_children = 1;
        }
        
        for(i=0 ; i<int_count_children; i++) 
        {
            lbl_id = new Label();
            lbl_id.setName(String.valueOf(i));
            lbl_id.setUIID("lbl_id_"+i);

            slbl_head = new SpanLabel("Fill Childs Details :");
            slbl_head.setUIID("lbl1");
            cnt_children.add(slbl_head);
            

            txtname = new TextField();
            txtname.setName(String.valueOf(i));
            txtname.setHint("First Name");
            bool_firstname = Storage.getInstance().exists("txtname_"+i);
            if(bool_firstname)
            {
                
                str_firstname = Storage.getInstance().readObject("txtname_"+i).toString();
            }
            else
            {
                str_firstname = "";
            }
            txtname.setText(str_firstname);
            txtname.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    Log.p("Writing to Storage: txtname_"+lbl_id.getName()+" => "+txtname.getText(), 1);
                    Storage.getInstance().writeObject("txtname_"+lbl_id.getName(), txtname.getText());
                }
            });
            cnt_children.addComponent(txtname);
            
            style_name = txtname.getAllStyles();
            style_name.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
            style_name.setBgColor(0xffffff);
            style_name.setBgTransparency(100);

            txtlastname = new TextField(str_lastname);
            txtlastname.setName(String.valueOf(i));
            txtlastname.setHint("Surname");
            bool_lastname = Storage.getInstance().exists("txtlastname_"+i);
            if(bool_lastname)
            {
                str_lastname = Storage.getInstance().readObject("txtlastname_"+i).toString();
            }
            else
            {
                str_lastname = "";
            }
            txtlastname.setText(str_lastname);
            txtlastname.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    Log.p("Writing to Storage: txtlastname_"+lbl_id.getName()+" => "+txtlastname.getText(), 1);
                    Storage.getInstance().writeObject("txtlastname_"+lbl_id.getName(), txtlastname.getText());
                }
            });
            cnt_children.addComponent(txtlastname);
            
            style_lname = txtlastname.getAllStyles();
            style_lname.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
            style_lname.setBgColor(0xffffff);
            style_lname.setBgTransparency(100);

            txtbirth = new TextField(str_birth);
            txtbirth.setName(String.valueOf(i));
            txtbirth.setHint("Birth Certificate No:");
            bool_birth = Storage.getInstance().exists("txtbirth_"+i);
            if(bool_birth)
            {
                
                str_birth = Storage.getInstance().readObject("txtbirth_"+i).toString();
            }
            else
            {
                str_birth = "";
            }
            txtbirth.setText(str_birth);
            txtbirth.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    Log.p("Writing to Storage: txtbirth_"+lbl_id.getName()+" => "+txtbirth.getText(), 1);
                    Storage.getInstance().writeObject("txtbirth_"+lbl_id.getName(), txtbirth.getText());
                }
            });
            cnt_children.addComponent(txtbirth);
            
            style_birth = txtbirth.getAllStyles();
            style_birth.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
            style_birth.setBgColor(0xffffff);
            style_birth.setBgTransparency(100);

            txtdbirth = new TextField(str_dbirth);
            txtdbirth.setName(String.valueOf(i));
            txtdbirth.setHint("Date of Birth");
            bool_dbirth = Storage.getInstance().exists("txtdbirth_"+i);
            if(bool_dbirth)
            {
                
                str_dbirth = Storage.getInstance().readObject("txtdbirth_"+i).toString();
            }
            else
            {
                str_dbirth = "";
            }
            txtdbirth.setText(str_dbirth);
            txtdbirth.addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent evt) 
                {
                    Log.p("Writing to Storage: txtdbirth_"+lbl_id.getName()+" => "+txtdbirth.getText(), 1);
                    Storage.getInstance().writeObject("txtdbirth_"+lbl_id.getName(), txtdbirth.getText());
                }
            });
            cnt_children.addComponent(txtdbirth);
            
            style_dbth = txtdbirth.getAllStyles();
            style_dbth.setBorder(RoundRectBorder.create().strokeColor(0).strokeOpacity(120).stroke(borderStroke));
            style_dbth.setBgColor(0xffffff);
            style_dbth.setBgTransparency(100);
        }
        
        btn_save = new Button("Submit");
        btn_save.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                
                bool_count_children = Storage.getInstance().exists("count_children");
                if(bool_count_children)
                {
                    str_count_children = Storage.getInstance().readObject("count_children").toString();
                    int_count_children = Integer.parseInt(str_count_children);
                }
                else
                {
                    int_count_children = 1;
                }

                 sb_children = new StringBuilder();
                
                for(i=0 ; i<int_count_children; i++) 
                {
                    bool_firstname = Storage.getInstance().exists("txtname_"+i);
                    if(bool_firstname)
                    {
                        str_firstname = Storage.getInstance().readObject("txtname_"+i).toString();
                        Log.p("Reading from Storage: txtname_"+i+" > "+str_firstname, 1);
                    }
                    else
                    {
                        str_firstname = "";
                    }

                    bool_lastname = Storage.getInstance().exists("txtlastname_"+i);
                    if(bool_lastname)
                    {

                        str_lastname = Storage.getInstance().readObject("txtlastname_"+i).toString();
                    }
                    else
                    {
                        str_lastname = "";
                    }

                    bool_birth = Storage.getInstance().exists("txtbirth_"+i);
                    if(bool_birth)
                    {

                        str_birth = Storage.getInstance().readObject("txtbirth_"+i).toString();
                    }
                    else
                    {
                        str_birth = "";
                    }

                    bool_dbirth = Storage.getInstance().exists("txtdbirth_"+i);
                    if(bool_dbirth)
                    {

                        str_dbirth = Storage.getInstance().readObject("txtdbirth_"+i).toString();
                    }
                    else
                    {
                        str_dbirth = "";
                    }

                    if(Storage.getInstance().exists("children"))
                    {
                        str_children = Storage.getInstance().readObject("children").toString();
                    }
                    else
                    {
                        str_children = "";
                    }

                    str_child = str_firstname+"*"+str_lastname+"*"+str_birth+"*"+str_dbirth+"|";

                    sb_children.append(str_children).append(str_child);

                }

                System.out.println(i+". Writing children str to storage:... "+sb_children.toString());
                Storage.getInstance().writeObject("children", sb_children.toString());
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

                String NationalID=Storage.getInstance().readObject("NationalID").toString();
                String UserName=Storage.getInstance().readObject("UserName").toString();

                Hashtable hash=new Hashtable();
                hash.put("ChildrenData", sb_children.toString());

                hash.put("ReadIdCopy", NationalID);
                hash.put("UserName",UserName);

                final Result res=Result.fromContent(hash);
                final String checkthis=res.toString();
                    //--------check url......
                String myUrl="https://b2cmanager.co.ke/TUISHIMOBWB/AddChildren";
                String Reply="";

                requestclass c=new requestclass(); 
                    try {
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
                    bool_count_children = Storage.getInstance().exists("count_children");
                    if(bool_count_children)
                    {
                        str_count_children = Storage.getInstance().readObject("count_children").toString();
                        int_count_children = Integer.parseInt(str_count_children);
                        
                        for(i=0 ; i<int_count_children; i++)
                        {
                            Storage.getInstance().deleteStorageFile("txtname_"+i);
                            Storage.getInstance().deleteStorageFile("txtlastname_"+i);
                            Storage.getInstance().deleteStorageFile("txtbirth_"+i);
                            Storage.getInstance().deleteStorageFile("txtbirth_"+i);
                            Storage.getInstance().deleteStorageFile("txtdbirth_"+i);
                        }
                        
                        Storage.getInstance().deleteStorageFile("count_children");
                        Storage.getInstance().deleteStorageFile("children");

                        Storage.getInstance().deleteStorageFile("PackageType");
                        Storage.getInstance().deleteStorageFile("Savingscheck");
                        Storage.getInstance().deleteStorageFile("MemberShipCode");
                        Storage.getInstance().deleteStorageFile("MpesaCode");
                        Storage.getInstance().deleteStorageFile("FirstName");
                        Storage.getInstance().deleteStorageFile("MiddleName");
                        Storage.getInstance().deleteStorageFile("Surname");
                        Storage.getInstance().deleteStorageFile("DateofBirth");
                        Storage.getInstance().deleteStorageFile("Gender");
                        Storage.getInstance().deleteStorageFile("NationalID");
                        Storage.getInstance().deleteStorageFile("MaritalStatus");
                        Storage.getInstance().deleteStorageFile("County");
                        Storage.getInstance().deleteStorageFile("Village");
                        Storage.getInstance().deleteStorageFile("PostalAddress");
                        Storage.getInstance().deleteStorageFile("Contact");
                    }
                    Dialog.show("SuccesfullyRecieved", "Details Succesfuly Recieved", "OK", null);

                }
                else if(Reply.equals("sorry"))
                {
                    Dialog.show("SORRY!!!", "Seems their is a problem updating children details... try again", "OK", null);
                }
                else
                {
                    Dialog.show("Error", "Something went wrong, try checking your connection and try again later.", "OK", null);
                } 
                
            }
        });
        
        bool_count_children = Storage.getInstance().exists("count_children");
        if(bool_count_children)
        {
            str_count_children = Storage.getInstance().readObject("count_children").toString();
            int_max_children = Integer.parseInt(str_count_children);
        }
        else{
            int_max_children= 2;
        }
        fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        fab.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Log.p("no of childs is "+int_max_children, 1);
                if(int_max_children<7)
                {
                    Storage.getInstance().deleteStorageFile("children");

                    bool_count_children = Storage.getInstance().exists("count_children");
                    if(bool_count_children)
                    {
                        str_count_children = Storage.getInstance().readObject("count_children").toString();
                        int_count_children = Integer.parseInt(str_count_children);

                            if(int_count_children > 0)
                            {
                                str_count_children = String.valueOf((int_count_children+1));

                                Log.p("No of Children: "+str_count_children, 1);
                                Storage.getInstance().writeObject("count_children", str_count_children);
                            }
                            else
                            {
                                Log.p("No of Children: "+"2", 1);
                                Storage.getInstance().writeObject("count_children", "2");
                            }
                    }
                    else
                    {
                        Log.p("No of Children: 2", 1);
                        Storage.getInstance().writeObject("count_children", "2");
                    }
                    new ChildrenForm().showMainForm();
                    
                }
                else
                {
                    Dialog.show("Notice", "The Maximum Number of "
                            + "children should be 7", "OK", null);
                }
            }
        });
           
        fm_main.add(BorderLayout.NORTH, FlowLayout.encloseRight(btn_save));
        fm_main.add(BorderLayout.CENTER, cnt_children);
//        fm_main.add(BorderLayout.SOUTH, FlowLayout.encloseBottomByRow(btn_save));
        fm_main.add(BorderLayout.SOUTH, FlowLayout.encloseRightBottom(fab));
        
        fm_main.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, new ActionListener()    
        {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                new NextOfKinForm().nxtofkscreen();
            }
        });
        fm_main.getContentPane().animateLayout(500);
        fm_main.show();
    }
}
