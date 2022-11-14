package com.snashy.swizzsoft;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.BufferedInputStream;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.NetworkManager;
import com.codename1.io.Storage;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.Util;
import com.codename1.processing.Result;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.util.StringUtil;
import com.codename1.xml.Element;
import com.codename1.xml.XMLParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

//import org.littlemonkey.connectivity.Connectivity;


public class Connect
{
    
    /*
        Username:       tommy@mobitribe.co.ke
        Password:       You will receive a separate email with your password
        Your Business
        Merchant Name:  MobiTribe
        Merchant Code:  4420192739
    
        Username:       4420192739
        Password:       qA2V64QgcsrIvAfuJieOdJh6Y79e5F10G
        Basic:          Basic Q3dsYjdKMUtIM3UwM0VpOVp0V2RTcjJWa1plTElHZGw6SzdUU09vMEdBWXdOeTJDbg==
    */
    
    public static String str_apiusn = "6335445031"; //
    public static String str_apipwd = "eFJQj3ZHH47Pegk3KcIudRmUIUl0mW3t"; //
    public static String str_apikey = "Basic d1lWQzdCRGpyMnVQRHdUbkF2WkdySGpVVWVNUHNGVE46TnBUekF5d1lwWWZXbmIzdA=="; //
    public static String str_ctype = "application/x-www-form-urlencoded";
    //POST /identity-test/v2/token HTTP/1.1
    
    /*
    Username: tommy@mobitribe.co.ke
    Merchant Name: MobiTribe
    Merchant Code: 4420192739
    Your Test Password is: Tommy123!
    Test URL: https://test.jengahq.io/#!/authenticate
    */
    
    public String myUrl;
    public static String str_loginUrl = "http://138.201.27.52:8080/GenElectionKe/GeKeAPI";    //http://localhost/Alpha/mobi/login_soap.php //http://138.201.27.52:8080/GenElectionKe/GeKeAPI
    public static String str_positionsUrl = "http://138.201.27.52:8080/GenElectionKe/GeKeAPI";
    public static String str_aspirantsUrl = "http://138.201.27.52:8080/GenElectionKe/GeKeAPI"; //http://"+Commonz.host+"/mobi/aspirants.xml //http://138.201.27.52:8080/GenElectionKe/GeKeAPI
    
    //public static Storage storage = Storage.getInstance();

    private String un;
//    private int int_count_image, int_count_Cosimage, int_count_Subimage, int_count_Topimage, int_count_Pagimage;
    private Component[] btn_Cosimage;
    
    private Image img_placeholder;
    private EncodedImage encImg_placeholder;
    
    private Image img;
    private Image img_sto;
    
    private Label lbl_img;
    private Label lbl_imgSto;
    
    private Storage sto;
    private InputStream is;
    
    private int counter = 1;
    
    //private String str_response;

    String ld;
    String ap;
    String pl;
    String ua;
    String ime;
    String vr;  //App Version
    String os;  //OS Type
    String ov;  //OS Version
    String ms;  //MSISD Number
    String ud;  //UDID Number
    int kb;     //Keyboard type
    int he;     //Display Height
    int wi;     //Display Width
    int de;     //Display Density
    boolean di; //device has dialing capabilities
    boolean or; //device allows forcing the orientation
    String[] ks;//Virtual Keyboards
    boolean ss; //Screen Saver Stop
    boolean cam;//Camera Present
    boolean to; //Touch Capability
    int sms;    //SMS Suport
    boolean pb;
    

    private String sno; //Serial Number
    private String snm; //Service Number - for Support
    private String sln; //Service Lines - for PRS
    private String sur; //Service URLs
    private String spl; //Service Personel - Mentor, supervisor, recruiter
    private String sem; //Service Email
    private String spt; //Service Point - Cohorth
    private String trx; //
    
    private String str_pinpass;
    public String str_recruits;
  
    //public String str_users_adder, str_users_sosno;
    //public String str_users_title, str_users_userid, str_users_birth_date, str_users_ppno, str_users_idno, str_users_gender, str_users_country, str_users_city, str_users_industry, str_users_occupation, str_users_organisation, str_users_department, str_users_cellphone, str_users_email_address, str_users_physical_address, str_users_longitude, str_users_latitude, str_users_postal_address, str_users_approvedby, str_users_emergency_contact, str_users_emergency_contact_phone, str_users_dietary_need, str_users_food_allergies, str_users_language, str_users_adminid, str_users_admincellphone, str_users_active;
    
    public String str_roli;
    public String str_levoli;
    public String str_ward, str_wodi;
    //public String str_cellphone, str_users_phone;
    //public String str_users_level, str_users_role;
    //public String str_email, str_users_email;
    public String str_twitter;
    public String str_facebook;
    public String str_dateob;
    
    private String payload, str_engine, str_train, str_carriage, str_data;
    
    
    
    private String str_screen;
    private String str_updatedon;
    
    private boolean bool_Login_staus, bool_upload_status;
    
    //private String str_host1, str_host2;
    private String str_username, str_usernameTemp;
    private String str_password, str_passwordTemp;
    
    private String str_reciever, str_message;
    
    private String str_role;
    
    private String str_station, str_constituency, str_county;
    private String str_idnumber;
    private String str_partyname;
    private String str_door_2_door;
    private String str_civic_education;
    private String str_media_sensitisation;
    //private String str_voter_protection;
    private String str_safety_personel;
    private String str_trainer;
    private String str_other_volution;
    private String str_dateofbirth;
    private String str_hasID;
    private String str_hasOkoa;
    private String str_isVoter;
    
    private String str_number;
    private String str_language;
    private String str_question;
    private String str_answer;
    private String str_option1;
    private String str_option2;
    
    //private String str_login_status, str_upload_status, str_user_details, str_personal_details, str_server_locnes, str_voting_details, str_fileName, str_filePath, str_mimeType;
    
    //TaskCatList Status
    private String str_TaskCatList_status;
    //Tasks Count
    private String str_TaskCatscount;
    private String str_l;
    //Tasks
    private String str_TaskCatList;
    //Task Contents
    private String str_TaskCat;
     //TaskCat Contents
    private String str_lastTaskCatid, str_lastTaskCatlist, str_oldTaskCatcount, str_newTaskCatcount, str_TaskCatid, str_TaskCatname, str_TaskCatcategory,
    str_TaskCatIcon, str_TaskCatCount, str_TaskCatDescr, str_TaskCatDeprt, str_TaskCatBgcol, str_TaskCatFgcol, str_TaskCatshape, str_TaskCatBywho, str_TaskSubCats;
    
    //TaskList Status
    private String str_TaskList_status;
    //Tasks Count
    private String str_Taskscount;
    private String str_i;
    //Tasks
    private String str_TaskList;
    //Task Contents
    private String str_Task;
    //Task Details
    private String str_caseNo, str_plaintiffsName, str_defendantsName, str_dateFiled, str_currentStatus; 
     //Task Contents
    private String str_lastTaskid, str_lastTasklist, str_oldTaskcount, str_newTaskcount, str_Taskid, str_Taskname, str_Taskcategory, str_Taskbeginning, str_Taskending, str_Taskallday, str_Taskperiod, str_Taskmembers, str_Taskdepartments, str_Taskdescription, 
    str_Taskdetails, str_Taskrecurring, str_Taskrecurring_until, str_Taskexport_to, str_Taskimported_from, str_Tasklocation, str_Taskattachements, str_Taskemail_to, str_Taskmilestones, str_Taskstatus, 
    str_Taskcomments, str_Taskcreated_on, str_Taskcreated_by, str_Taskupdated_on, str_Taskupdated_by, str_Taskcompleted_on, str_Taskcompleted_by, str_Taskchecked_by, str_Taskapproved_by, str_Taskabandoned_by;
    
    private String str_volunteer_status, str_volunteer_username, str_volunteer__pass;
    
    private NetworkManager networkManager;
    
    private Dialog dialog;
    
    private TextArea txta_alert;
    
    private int int_count_tasks, int_count_Oldtasks, int_count_Newtasks;
    private int int_count_taskCats, int_count_OldtaskCats, int_count_NewtaskCats;
    
    private Slider sld_process;
    private Button btn_process;
    //private String str_param_1, str_param_2, str_param_3;
    
    private String str_agent_id, str_agent_name, str_aspirant_id, str_station_id;
    private String str_response_code, str_response_data, str_needle, str_haystack;
    
    
    public static String str_protocol = "http://";
    public static String str_host = "localhost";
    public static String str_port = ":50111/";
    public static String str_path = "";
    
//    public static String str_protocol = "https://"; //https://
//    public static String str_host = "blueheart-international.org/"; //localhost/Bluewater //40.76.216.44
//    public static String str_port = "/"; //:8119  //
//    public static String str_path = "Bluewater";
    
    //str_protocol + str_host + str_path + str_port + str_param_1
    
    public static String str_endpoint;
    public static String str_url;
    
    
    public static String str_photoUrl;
        
    public static Storage storage = Storage.getInstance();
    
    private boolean bool_screen;

    private String str_response;
    private BufferedInputStream bis;
    private InputStream in;
    private String text;
    
    private String str_respcode, str_resptext, str_respdata;
    
    private String str_process, str_payload, str_param_1, str_param_2, str_param_3, str_param_4, str_param_5, str_param_6, str_param_7, 
            str_param_8, str_param_9, str_param_10, str_param_11, str_param_12, str_param_13, str_param_14, str_param_15, 
            str_param_16, str_param_17, str_param_18, str_param_19, str_param_20, str_param_21, str_param_22, str_param_23;
    
    private Boolean bool_userid, bool_trxnid;
    private String str_userid, str_trxnid;
    
    
    private String str_login_status, str_upload_status, str_user_details, str_personal_details, str_server_locnes, str_voting_details, str_fileName, str_filePath, str_mimeType;
    
    public String str_users_id, str_users_mn, str_users_memnos, str_users_family_id, str_users_firstname, str_users_middlename, str_users_lastname, 
            str_users_nickname, str_users_title, str_users_userid, str_users_role, str_users_level, str_users_birth_date, str_users_age, 
            str_users_ppno, str_users_idno, str_users_gender, str_users_country, str_users_nationality, str_users_county, str_users_city, 
            str_users_phone, str_users_phone_alt, str_users_email_address, str_users_physical_address, 
            str_users_postal_code, str_users_gpsdata, str_users_residence, str_users_street_road, str_users_floor_court_flat_building, str_users_door_house_number, str_users_longitude, str_users_latitude, str_users_postal_address, str_users_postal_address_home, str_users_postal_code_home, str_users_postal_address_work, str_users_postal_code_work, str_users_approvedby, str_users_approvedon, 
            str_users_emergency_contact, str_users_emergency_contact_phone, str_users_dietary_need, str_users_food_allergies, str_users_medicine_allergies, 
            str_users_blood_type, str_users_heamoglobin, str_users_weight, str_users_height, str_users_bmi, str_users_blood_pressure, str_users_muscle_strength, str_users_special_medical_condition,
            str_users_language, str_users_adminid, str_users_admincellphone, str_users_status, str_users_phone_work, str_users_phone_home, str_users_email,
            str_users_email_alt, str_users_email_work, str_users_email_home, str_users_photo, str_users_marital_status, str_users_marital_time, 
            str_users_marital_date, str_users_organisation, str_users_organisation_id, str_users_spouse, str_users_children, str_users_department, str_users_department1, str_users_department2, 
            str_users_department3, str_users_department_prospects, str_users_departments, str_users_spiritual_gifts, str_users_ministry, 
            str_users_cell_church, str_users_ss_class, str_users_board_member, str_users_babtism_status, str_users_babtism_date, str_users_membership, 
            str_users_member_by, str_users_irregular, str_users_regular_at, str_users_adventist, str_users_occupation, str_users_place_of_work, str_users_industry, 
            str_users_education, str_users_experience, str_users_employment, str_users_employment_status, str_users_reminder, 
            str_otpdata, str_otptxt, str_otpcde, str_otpmsg, str_otpcode, str_otpidn, str_otpnum, str_otpcst, str_users_bottles_20litre;
    
    private int int_no_mem, int_no_itemsel, int_no_new_itemsel;
    private String str_no_mem, str_no_itemsel, str_itemsel, str_new_itemsel;
    private boolean bool_no_mem, bool_no_itemsel, bool_itemsel;
    private String [] strA_itemsel; 
    private StringBuilder sb_itemsel;
    
    private int i, j, k, l, m;
    private int int_no_main_item, int_no_new_items, int_no_total_items, int_newno_items, int_rows_items, int_rows_item, int_totals, int_new_totals, int_subtotals1, int_subtotals2, int_totalItems;
    private String str_no_main_items, str_no_new_items, str_no_total_items;
    boolean bool_no_new_items, bool_no_total_items, bool_item, bool_itemv, bool_no_main_items, bool_main_item, bool_main_itemv, bool_pay_instructions, bool_tithev, bool_offeringv, bool_buildingv, bool_budgetv, bool_payment_provider, bool_payment_method, bool_totals;
    boolean bool_buildingv_items, bool_buildingv_roof, bool_buildingv_premix, bool_buildingv_wall, bool_buildingv_elec, bool_buildingv_plumb, bool_buildingv_pulpit, bool_buildingv_window;
    boolean bool_trxno, bool_memno, bool_fname, bool_lname, bool_phone, bool_email;
    private Label lbl_removeTithe, lbl_removeOffering, lbl_removeBuilding, lbl_removeBudget, lbl_removeKitty;
    private Label lbl_items, lbl_totals;
    
    private String str_totals, str_subtotals, str_totalItems, str_tithe, str_offering, str_building, str_budget, str_tithev, str_offeringv, str_buildingv, str_building_roof, str_building_premix, str_building_walling, str_building_elec, str_building_plumb, str_building_pulpit, str_building_window, str_buildingv_roof, str_buildingv_premix, str_buildingv_wall, str_buildingv_elec, str_buildingv_plumb, str_buildingv_pulpit, str_buildingv_window, str_budgetv, str_item, str_main_item, str_itemv, str_main_itemv;
    private String str_trxno, str_memno, str_title, str_name, str_firstname, str_lastname, str_fname, str_lname, str_dob, str_idpp, str_aob, str_btn_back, str_btn_ok, str_email, str_phone, str_fnhint, str_unhint, str_pwhint, str_organization;
    
    private String str_listcontent, str_listcriteria;
    private StringBuilder sb_main_item, sb_new_item, sb_acoptions_new_item, sb_options, sb_recp_item;
    String [] str_acoptions_new_item, str_acoptions; 
    
    boolean bool_isTablet = Display.getInstance().isTablet();
    boolean bool_isDesktop = Display.getInstance().isDesktop();
    boolean bool_isSimulator = Display.getInstance().isSimulator();
    //boolean bool_isConnected = Connectivity.isConnected();
    
    private boolean bool_login, bool_settings;
    private String str_json_login, str_json_settings;
    byte[] bytes_data_login, bytes_data_settings;
    private int int_size;
    
    private boolean bool_img;
    private String str_bgimg;
    private boolean bool_response;
    
    
    public Resources theme;
    
    public void process() throws IOException        
    {
        
        try 
        {
            connect();
        } 
        catch (Exception e) 
        {
            System.err.println("Error: "+e);
        }
    }
    
     
    public void connect() throws IOException //, JSONException        
    {
        theme=UIManager.initFirstTheme("/theme");
        
            Log.p(">>>>>>>>>>>>>>>Inside connect method.", 1);
            
            Log.p("Creating hashtable", 1);
            Hashtable hash = new Hashtable();

            Log.p("Reading data to be packed on the hashtable bus from storage.", 1);
            if(Storage.getInstance().exists("parameter1") == true){str_param_1 = (String) Storage.getInstance().readObject("parameter1");}else{str_param_1 = "null";}  //transaction //apikey
            if(Storage.getInstance().exists("parameter2") == true){str_param_2 = (String) Storage.getInstance().readObject("parameter2");}else{str_param_2 = "null";}  //username    //token
            if(Storage.getInstance().exists("parameter3") == true){str_param_3 = (String) Storage.getInstance().readObject("parameter3");}else{str_param_3 = "null";}  //password
            if(Storage.getInstance().exists("parameter4") == true){str_param_4 = (String) Storage.getInstance().readObject("parameter4");}else{str_param_4 = "null";}
            if(Storage.getInstance().exists("parameter5") == true){str_param_5 = (String) Storage.getInstance().readObject("parameter5");}else{str_param_5 = "null";}
            if(Storage.getInstance().exists("parameter6") == true){str_param_6 = (String) Storage.getInstance().readObject("parameter6");}else{str_param_6 = "null";}
            if(Storage.getInstance().exists("parameter7") == true){str_param_7 = (String) Storage.getInstance().readObject("parameter7");}else{str_param_7 = "null";}
            if(Storage.getInstance().exists("parameter8") == true){str_param_8 = (String) Storage.getInstance().readObject("parameter8");}else{str_param_8 = "null";}
            if(Storage.getInstance().exists("parameter9") == true){str_param_9 = (String) Storage.getInstance().readObject("parameter9");}else{str_param_9 = "null";}
            if(Storage.getInstance().exists("parameter10") == true){str_param_10 = (String) Storage.getInstance().readObject("parameter10");}else{str_param_10 = "null";}
            if(Storage.getInstance().exists("parameter11") == true){str_param_11 = (String) Storage.getInstance().readObject("parameter11");}else{str_param_11 = "null";}
            if(Storage.getInstance().exists("parameter12") == true){str_param_12 = (String) Storage.getInstance().readObject("parameter12");}else{str_param_12 = "null";}
            if(Storage.getInstance().exists("parameter13") == true){str_param_13 = (String) Storage.getInstance().readObject("parameter13");}else{str_param_13 = "null";}
            if(Storage.getInstance().exists("parameter14") == true){str_param_14 = (String) Storage.getInstance().readObject("parameter14");}else{str_param_14 = "null";}
            if(Storage.getInstance().exists("parameter15") == true){str_param_15 = (String) Storage.getInstance().readObject("parameter15");}else{str_param_15 = "null";}
            if(Storage.getInstance().exists("parameter16") == true){str_param_16 = (String) Storage.getInstance().readObject("parameter16");}else{str_param_16 = "null";}
            if(Storage.getInstance().exists("parameter17") == true){str_param_17 = (String) Storage.getInstance().readObject("parameter17");}else{str_param_17 = "null";}
            if(Storage.getInstance().exists("parameter18") == true){str_param_18 = (String) Storage.getInstance().readObject("parameter18");}else{str_param_18 = "null";}
            if(Storage.getInstance().exists("parameter19") == true){str_param_19 = (String) Storage.getInstance().readObject("parameter19");}else{str_param_19 = "null";}
            if(Storage.getInstance().exists("parameter20") == true){str_param_20 = (String) Storage.getInstance().readObject("parameter20");}else{str_param_20 = "null";}
            if(Storage.getInstance().exists("parameter21") == true){str_param_21 = (String) Storage.getInstance().readObject("parameter21");}else{str_param_21 = "null";}
            if(Storage.getInstance().exists("parameter22") == true){str_param_22 = (String) Storage.getInstance().readObject("parameter22");}else{str_param_22 = "null";}
            if(Storage.getInstance().exists("parameter23") == true){str_param_23 = (String) Storage.getInstance().readObject("parameter23");}else{str_param_23 = "null";}

            Log.p("Packing the data on the hashtable bus to be sent to the server.", 1);
            try
            {
                if(str_param_1.equals("sendmsg"))
                {
                  

                    hash.put("username", "tommy");
                    hash.put("to", str_param_2);
                }
                else if(str_param_1.equals("authenticate"))
                {
                    str_host = "https://api.africastalking.com/auth-token/generate";
                }
                else if(str_param_1.equals("authorisation"))
                {
                    str_host =  "https://uat.jengahq.io/identity/v2/token";
                }
                else
                {
                    str_photoUrl = str_protocol + str_host + str_path + str_port+"/upload_photo.php";
                    
                    hash.put("Password", "xx");
                }
            }
            catch(Exception e) 
            {
                    System.out.println("Error: "+e);
                    e.printStackTrace();
            }


            Log.p("Preparing to make connection request.", 1);
            final Result res = Result.fromContent(hash);

            Log.p("Creating a json string from the data.", 1);
            
            if(str_param_1.equals("authorisation"))
            {
                str_payload =  "username="+str_apiusn+"&password="+str_apipwd;//res.toString();
                System.err.println("Payload: "+str_payload);
            }
            else
            {
                str_payload =  res.toString();
                System.err.println("Payload: "+str_payload);
            }
            
            
            

            ConnectionRequest request = new ConnectionRequest() 
            {
                //Log.p("Handles a server response code that is not 200 and not a redirect", 1);
                @Override //Handles a server response code that is not 200 and not a redirect.
                protected void handleErrorResponseCode(int code, String message) 
                {

                }

                //Log.p("Handles an exception thrown when performing a network operation", l);
                @Override
                protected void handleException(Exception err) 
                {
                    //Dialog.show("Error: "+err, "A network error occured, please check your internet connection.", "Ok", null);
                }

                @Override
                protected void postResponse() 
                {
                    //// invoked on the EDT after processing is complete to allow the networking code readResponse() method to finish
                    //// The UI is updated here so as to avoid race conditions that might be triggered by modifications within readResponse.
                    //// Done on a successful response and will not be invoked in case of a failure.
                    //HomeMenu menuer = new HomeMenu();
                    //menuer.showMainScreen();
                }

                //Invoked when send body is true, by default sends the request arguments based * on "POST" conventions
                @Override
                protected void buildRequestBody(OutputStream os) throws IOException 
                {
                    Writer writer = null;
                    writer = new OutputStreamWriter(os, "UTF-8");
                    writer.write(str_payload);
                    writer.flush();
                    writer.close();
                }
            };

            Log.p("Making connection request by calling the "+str_param_1+" endpoint.", 2);//1-DEBUG, 2-INFO, 3-WARNING, 4-ERROR
            request.setReadResponseForErrors(true);

            if(str_param_1.equals("sendmsg"))
            {
                request.setUrl(str_host);

                request.setPost(true);
                request.setWriteRequest(true);
                request.addRequestHeader("Content-Type", "application/json");
                request.addRequestHeader("apikey", "2e658c456820f4ae2ae1e03bf3a14ff3094a1d38a1315f05777db03dafe92667");
                request.addRequestHeader("Accept", "application/json");
                request.setContentType("");
            }
            else
            {                  
                
                myUrl="https://b2cmanager.co.ke/TUISHIMOBWB/GetCounties";
//                String myUrl="http://localhost:50111/GetCounties";  
//                request.setUrl(str_protocol + str_host + str_port + str_path + str_param_1);       //str_protocol + str_host + str_port + str_path_authLogin
                request.setUrl(myUrl);
                request.setContentType("application/json");
                request.addRequestHeader("Accept", "application/json");
                request.setPost(true);
                request.setWriteRequest(true);
            }




            Log.p("Calling server url: "+request.getUrl(), 1); //http://cims.karengatasda.org/ChurchApp/settings
            //Log.p("Passing server params: "+request.getRequestBodyData(), 1);

            /*
            sld_process = new Slider();
            //sld_process.setPreferredSize(new Dimension(300, 50));
            //sld_process.getStyle().setPadding(15, 15, 0, 0);
            //sld_process.getStyle().setMargin(15, 25, 0, 0);
            //sld_process.setSize(new Dimension(300, 50));      
            //ToastBar.showConnectionProgress("Downloading video", request, null, null);
            SliderBridge.bindProgress(request, sld_process);
            */

            InfiniteProgress inftprogress = new InfiniteProgress();
            Dialog dlg_progress = new Dialog();
            dlg_progress.setDialogUIID("Container");
            dlg_progress.setLayout(new BorderLayout());

            if(str_param_1.equals("GetCounties"))
            {
                str_process = "counties";
            }
            
            Label lbl_progress = new Label("Loading "+str_process+"...\n, Please Wait...");
            
            lbl_progress.getStyle().setFgColor(0xffffff, false);
            lbl_progress.getStyle().setBgTransparency(0);
            dlg_progress.addComponent(BorderLayout.CENTER, FlowLayout.encloseCenterBottom(lbl_progress, inftprogress));
            dlg_progress.setTransitionInAnimator(CommonTransitions.createEmpty());
            dlg_progress.setTransitionOutAnimator(CommonTransitions.createEmpty());
            dlg_progress.showPacked(BorderLayout.CENTER, false);
            request.setDisposeOnCompletion(dlg_progress);
            
            NetworkManager.getInstance().addToQueueAndWait(request);


            Log.p("Reading response from server.", 1);

            Log.p("Processing response code: "+request.getResponseCode(), 1);
            Log.p("Processing response mesg: "+request.getResponseErrorMessage(), 1);
            //Log.p("Processing response data: "+Arrays.toString(request.getResponseData()), 1);
            Log.p("\n", 1);
            
            Storage.getInstance().writeObject("respcode", String.valueOf(request.getResponseCode()));
            Storage.getInstance().writeObject("resptext", request.getResponseErrorMessage());
            Storage.getInstance().writeObject("respdata", request.getResponseData());

            byte[] dataa = request.getResponseData();
            if (dataa != null) 
            {
                Reader reader = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8");
                int chr;
                StringBuffer sb = new StringBuffer();
                String str_server_response = "";
                while ((chr = reader.read()) != -1)
                {
                    sb.append((char) chr);
                }
                str_server_response = sb.toString(); 

                if(str_param_1.equals("collections") || str_param_1.equals("members") || str_param_1.equals("statements") || str_param_1.equals("assets"))
                {
                    str_train = StringUtil.tokenize(str_server_response, '[').get(1);
                    str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                    str_data = '['+str_carriage+']';

                    System.out.println("Data: "+str_data);

                    Log .p("A. Writing  "+str_param_1+"'s server response to storage.", 1);
                    FileSystemStorage fsto = FileSystemStorage.getInstance();
                    final String homePath = fsto.getAppHomePath();
                    final char sep = fsto.getFileSystemSeparator();

                    try 
                    {
                        FileSystemStorage.getInstance().openOutputStream(FileSystemStorage.getInstance().getAppHomePath()+str_param_1+".txt").write(str_data.getBytes("UTF-8"));
                        Storage.getInstance().writeObject("listcriteria", str_param_1);
                    }
                    catch (Exception ex) 
                    {
                        Log.p("An error occured 739", 1);
                        ex.printStackTrace();
                    }
                }
                else
                {
                    Log.p("Writing server respons to storage.", 1);
                    try 
                    {
                        Storage.getInstance().writeObject("response", str_server_response);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println("A. Error: "+e+"\n"+str_server_response);
                        e.printStackTrace();
                    }
                }
            }
            else
            {
                Storage.getInstance().writeObject("respcode",  String.valueOf(request.getResponseCode()));
                Storage.getInstance().writeObject("resptext", "Please contact the application service provider!");
            }

            if(str_param_1.equals("sync")) 
            {
                Log.p("Processing "+str_param_1+"'s json response for from server.", 1);
                if (request.getResponseCode() == 200) 
                {
                    bool_response = Storage.getInstance().exists("response");
                    if(bool_response == true){}
                    
                    try 
                    {
                        str_response = Storage.getInstance().readObject("response").toString();
                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));

                        String str_respcode = map_response.get("code").toString();
                        String str_resptext = map_response.get("message").toString();
                        String str_respdata = map_response.get("data").toString();

                        Log.p("B. Writing " + str_param_1 + "'s server response to storage.", 1);
                        Storage.getInstance().writeObject(str_param_1+".json", str_response); //str_param_1

                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_respdata);

                        String str_json_read = (String) Storage.getInstance().readObject("sync.json"); //TODO: remove this and get directly from (dataa)
                        byte[] dataa2 = str_json_read.getBytes();
                        JSONParser json = new JSONParser();
                        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa2), "UTF-8"))
                        {
                            Map<String, Object> map_content = json.parseJSON(is_content);
                            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("data");
                            System.out.println("Contents:---------> "+obj_content); 
                            System.out.println("Quantity:---------> "+obj_content.size()); 

                            i = 0;
                            for(Map<String, Object> obj : obj_content) 
                            {    
                                //String str_route_id = (String)obj.get("id");
                                String str_userstatus = (String)obj.get("status"); Storage.getInstance().writeObject("userstatus", str_userstatus); System.out.println("Status:---------> "+str_userstatus);

                                if(str_userstatus.equals("active"))
                                {
                                    bool_screen = Storage.getInstance().exists("screen");
                                    if(bool_screen == true)
                                    {
                                        str_screen = Storage.getInstance().readObject("screen").toString();
                                        if(str_screen.equals("splash"))
                                        {
                                            /*SplashMenu splashermenu = new SplashMenu();
                                            try 
                                            {
                                                splashermenu.showMainMenu();
                                            } 
                                            catch (Exception e) 
                                            {
                                                e.printStackTrace();
                                            }*/
                                        }
                                        else if(str_screen.equals("courses"))
                                        {
                                            Storage.getInstance().writeObject("updatestatus", "true");
                                            Storage.getInstance().writeObject("parameter1", "courses"); //transaction
                                            Storage.getInstance().writeObject("parameter2", "list"); //screen 
                                            Storage.getInstance().writeObject("parameter3", "557ae732f7d3e929488cea5c21d446ec");  
                                            Storage.getInstance().writeObject("parameter4", "core_course_get_courses"); 
                                            Storage.getInstance().writeObject("parameter5", "json"); 
                                            Storage.getInstance().writeObject("parameter6", "deleted"); 
                                            Storage.getInstance().writeObject("parameter7", "0"); 

                                            Log.p("Going to connect class to fetch selected bus.", 1);
                                            try 
                                            {
                                                Connect connector = new Connect();
                                                connector.process();
                                            } 
                                            catch (Exception ex) 
                                            {
                                                ex.printStackTrace();
                                            }
                                        }
                                        else
                                        {
                                            /*MainMenu mainmenu = new MainMenu();
                                            try 
                                            {
                                                mainmenu.showMainScreen();
                                            } 
                                            catch (Exception e) 
                                            {
                                                e.printStackTrace();
                                            }*/
                                        }
                                    }
                                    else
                                    {
                                        /*MainMenu mainmenu = new MainMenu();
                                        try 
                                        {
                                            mainmenu.showMainScreen();
                                        } 
                                        catch (Exception e) 
                                        {
                                            e.printStackTrace();
                                        }*/
                                    }
                                }
                                else if(str_userstatus.equals("multi"))
                                {
                                    Dialog.show("Sorry!", "User logged in on another device, to proceed click OK to logout user or Cancel to use the other device.", "Ok", null);
                                    Display.getInstance().exitApplication();
                                }
                                else
                                {
                                    Dialog.show("Oh Snap!!!: ", "Looks like your user account is "+str_userstatus+". Please contact application service provider for further assistance.", "Ok", null);
                                    Display.getInstance().exitApplication();
                                }

                            }
                        } 
                        catch(IOException err) 
                        {
                                Log.e(err);
                        }
                    } 
                    catch (IOException ioe) 
                    {   
                        Dialog.show("IO Error Occured!", "We couldn't properly write or read the server response to or from your device. Please try again or contant the application service provider.", "OK", null); //TODO: Make this unambigous.
                    }
                    
                } 
                else 
                {
                    handleError();
                }
            }
            else if(str_param_1.equals("GetCounties"))
            {
                Log.p("Processing "+str_param_1+"'s json response for from server.", 1);
                
                if(request.getResponseCode() == 200 || request.getResponseCode() == 201)
                {
                    str_response = Storage.getInstance().readObject("response").toString();
                    if(str_response.contains("["))
                    {
                        str_train = StringUtil.tokenize(str_response, '[').get(1);
                        str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                        str_data = str_carriage;
                    }
                    else
                    {
                        str_data = "null";
                    }

                    Log .p("C. Writing  "+str_param_1+"'s server response to storage.", 1);
                    Storage.getInstance().writeObject(str_param_1+".json", str_data);
                    System.out.println("Server counties data: " + str_data);

                    JSONParser json_parser = new JSONParser();
                    Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                    System.out.println("Server Response: " + map_response);

                    Log.p("Writing reply to storage.", 1);
                    String str_apireply  = map_response.get("apireply").toString();
                    System.out.println("Server apireply: " + str_apireply);
                    
                    Log.p("Going to show Registration Screen", 1);
                    new RegistrationForm().Regstrationscreen(theme);
                }
                else
                {
                    handleError();
                }
            }
            else if(str_param_1.equals("login"))
            {
                Log.p("Server response code: "+request.getResponseCode(), 1);
                if(request.getResponseCode() == 200)
                {
                    str_response = Storage.getInstance().readObject("response").toString();
                    if(str_response.contains("["))
                    {
                        str_train = StringUtil.tokenize(str_response, '[').get(1);
                        str_carriage = StringUtil.tokenize(str_train, ']').get(0);
                        str_data = '['+str_carriage+']';
                    }
                    else
                    {
                        str_data = "null";
                    }


                    //System.out.println("Train: "+str_train);
                    //System.out.println("Car: "+str_carriage);
                    //System.out.println("Data: "+str_data);

                    Log .p("Writing  "+str_param_1+"'s server response to storage.", 1);
                    //storage.writeObject("userdetails.json", dataa.toString());
                    Storage.getInstance().writeObject(str_param_1+".json", str_data);
                    //String str_json_read = (String) Storage.getInstance().readObject("userdetails.json");

                    JSONParser json_parser = new JSONParser();
                    Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                    //System.out.println("Server Response: " + map_response);

                    str_respcode = map_response.get("code").toString();  //200
                    str_resptext = map_response.get("message").toString(); //OK

                    System.out.println("CODE: "+str_respcode);
                    System.out.println("MESG: "+str_resptext);


                    //String str_respdata = map_response.get("data").toString();
                    Storage.getInstance().writeObject("respcode", str_respcode);
                    Storage.getInstance().writeObject("resptext", str_resptext);

                    if(!str_respcode.equals("200"))
                    {
                        Storage.getInstance().writeObject("loginstatus", "NOL");
                        okayDialog("Sorry!\n: ", "The username/password combination that you entered is wrong.");
                    }
                    else
                    {
                        if(str_response.contains("["))
                        {
                            str_respdata = map_response.get("data").toString(); //
                            Storage.getInstance().writeObject("respdata", str_respdata);
                        }
                        else
                        {
                            str_respdata = ""; //
                            Storage.getInstance().writeObject("respdata", str_respdata);
                        }

                        //Storage.getInstance().writeObject("respdata", map_response.get("data"));      

                        if (request.getResponseCode() == 200){} //check length or size of data, if greater than 0, write uderdetails.json to storage

                        JSONParser json = new JSONParser(); //JSONParser.setIncludeNulls(false);

                        try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"))
                        {
                            Map<String, Object> map_content = json.parseJSON(is_content); //System.out.println("login.json map_content: "+map_content);
                            java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("data"); //System.out.println("login.json obj_content: "+obj_content.get(0));

                            for(Map<String, Object> obj : obj_content) 
                            {              

                                if((String)obj.get("id")!=null){str_users_id = (String)obj.get("id");}else{str_users_id = "";}
                                if((String)obj.get("role")!=null){str_users_role = (String)obj.get("role");}else{str_users_role = "";}
                                if((String)obj.get("level")!=null){str_users_level = (String)obj.get("level");}else{str_users_level = "";}
                                if((String)obj.get("member_no")!=null){str_users_memnos = (String)obj.get("member_no");}else{str_users_memnos = "";}
                                if((String)obj.get("title")!=null){str_users_title = (String)obj.get("title");}else{str_users_title = "";}
                                if((String)obj.get("firstname")!=null){str_users_firstname = (String)obj.get("firstname");}else{str_users_firstname = "";}
                                if((String)obj.get("lastname")!=null){str_users_lastname = (String)obj.get("lastname");}else{str_users_lastname = "";}
                                if((String)obj.get("email")!=null){str_users_email = (String)obj.get("email");}else{str_users_email = "";}
                                if((String)obj.get("phone")!=null){str_users_phone = (String)obj.get("phone");}else{str_users_phone = "";}
                                if((String)obj.get("department")!=null){str_users_department = (String)obj.get("department");}else{str_users_department = "";}
                                if((String)obj.get("organisation_id")!=null){str_users_organisation = (String)obj.get("organisation_id");}else{str_users_organisation = "";}
                                if((String)obj.get("bottles_20litre")!=null){str_users_bottles_20litre = (String)obj.get("bottles_20litre");}else{str_users_bottles_20litre = "";}
                                if((String)obj.get("latitude")!=null){str_users_latitude = (String)obj.get("latitude");}else{str_users_latitude = "";}
                                if((String)obj.get("longitude")!=null){str_users_longitude = (String)obj.get("longitude");}else{str_users_longitude = "";}
                                if((String)obj.get("status")!=null){str_users_status = (String)obj.get("status");}else{str_users_status = "";}
                                
                                
                                Storage.getInstance().writeObject("userid", str_users_id);
                                Storage.getInstance().writeObject("role", str_users_role);
                                Storage.getInstance().writeObject("level", str_users_level);
                                Storage.getInstance().writeObject("member_no", str_users_memnos);
                                Storage.getInstance().writeObject("title", str_users_title);
                                Storage.getInstance().writeObject("firstname", str_users_firstname);
                                Storage.getInstance().writeObject("lastname", str_users_lastname);
                                Storage.getInstance().writeObject("email", str_users_email);
                                Storage.getInstance().writeObject("phone", str_users_phone);
                                Storage.getInstance().writeObject("department", str_users_department);
                                Storage.getInstance().writeObject("organisation_id", str_users_organisation);
                                Storage.getInstance().writeObject("bottles_20litre", str_users_bottles_20litre);
                                Storage.getInstance().writeObject("latitude", str_users_latitude);
                                Storage.getInstance().writeObject("longitude", str_users_longitude);
                                Storage.getInstance().writeObject("gpsdata", str_users_latitude+", "+str_users_longitude);
                                Storage.getInstance().writeObject("status", str_users_status);
                                
                            }
                        }
                        catch(IOException err) 
                        {
                                //Log.e(err);
                        }

                        storage.writeObject("loginstatus", "OKL");
                        str_usernameTemp = (String) storage.readObject("parameter2");
                        str_passwordTemp = (String) storage.readObject("parameter3");
                        storage.writeObject("username", str_usernameTemp);
                        storage.writeObject("password", str_passwordTemp);


                        //if(cb_rmemberme.isSelected())
                        //{
                        //    Storage.getInstance().writeObject("keepmeloggedin", "yes");
                        //}
                        //else if(cb_rmemberme.isSelected() == false)
                        //{
                        //    Storage.getInstance().writeObject("keepmeloggedin", "no");
                        //}


                        Storage.getInstance().writeObject("parameter1", "transactions");
                        Storage.getInstance().writeObject("parameter2", "wot");
                        Storage.getInstance().writeObject("parameter3", "3"); //organisation_id
                        Storage.getInstance().writeObject("parameter4", "");
                        Storage.getInstance().writeObject("parameter5", "");
                        Storage.getInstance().writeObject("parameter6", "");
                        Storage.getInstance().writeObject("parameter7", "");
                        Storage.getInstance().writeObject("parameter8", "");
                        Storage.getInstance().writeObject("parameter9", "");
                    
                        Connect connector = new Connect();
                        try 
                        {
                            connector.process();
                        } 
                        catch (Exception e) 
                        {
                            Log.p("C. Error: "+e, 1);
                        }
                    }
                }
                else
                {
                    Storage.getInstance().writeObject("respcode", String.valueOf(request.getResponseCode()));
                    handleError();
                }
            }
            else if(str_param_1.equals("settings"))
            {
                    Log.p("Processing "+str_param_1+"'s json response for from server.", 1);

                    if(request.getResponseCode() == 200)
                    {
                        str_response = Storage.getInstance().readObject("response").toString();
                        //str_train = StringUtil.tokenize(str_response, '[').get(1);
                        //str_carriage = StringUtil.tokenize(str_train, "]\"}]").get(0);
                        //str_data = '['+str_carriage+"]\"}]"; //"}]

                        JSONParser json_parser = new JSONParser();
                        Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));

                        str_respcode = map_response.get("code").toString();
                        str_resptext = map_response.get("message").toString();
                        str_respdata = map_response.get("data").toString();

                        Log .p("Writing "+str_param_1+"'s server response to storage.", 1);
                        Storage.getInstance().writeObject(str_param_1+".json", str_response);

                        Storage.getInstance().writeObject("respcode", str_respcode);
                        Storage.getInstance().writeObject("resptext", str_resptext);
                        Storage.getInstance().writeObject("respdata", str_respdata);

                        //Storage.getInstance().writeObject("updatestatus", "2018-06-25 10:35:48"); //TODO, get this from sertings.json
                        
                        if(str_respcode.equals("200"))
                        {
                            if (request.getResponseCode() == 200){} //check length or size of data, if greater than 0, write uderdetails.json to storage

                            Log.p("Reading "+str_param_1+".json from storage.", 1);
                            str_json_settings = (String) Storage.getInstance().readObject(str_param_1+".json");
                            bytes_data_settings = str_json_settings.getBytes();


                            JSONParser json_data_login = new JSONParser();
                            try(Reader is_content = new InputStreamReader(new ByteArrayInputStream(bytes_data_settings), "UTF-8"))
                            {
                                Map<String, Object> map_content = json_data_login.parseJSON(is_content);
                                java.util.List<Map<String, Object>> obj_content = (java.util.List<Map<String, Object>>)map_content.get("data");
                                System.out.println("Number of Items:---------> "+obj_content.size()); 

                                Log.p("Looping through the logins read.", 1);

                                i = 0;
                                for(Map<String, Object> obj : obj_content) 
                                {    
                                    String str_id = (String)obj.get("id");
                                    String str_name = (String)obj.get("name");
                                    String str_type = (String)obj.get("type");
                                    String str_value = (String)obj.get("value");
                                                                        
                                    if(str_type.equals("image"))
                                    {
                                        bool_img = Storage.getInstance().exists(str_value);
                                        if(bool_img == true)
                                        {
                                            //int_size = Integer.parseInt(Storage.getInstance().readObject("huhi"+".png").toString().length());
                                            //Storage.getInstance().writeObject("", "");
                                            System.out.println("Already downloaded image "+i+" "+str_value+" for "+str_firstname+" = "+int_size+" bytes.");
                                            //Storage.getInstance().deleteStorageFile(str_view+".png");
                                            //LoginMenu soaime = new LoginMenu();
                                            //soaime.showLoginScreen();
                                        }
                                        else
                                        {           //str_protocol+str_host+str_path+str_port+str_param_1
                                            str_url = str_protocol + str_host + str_path + str_port+"img/backgrounds/"+str_value; //cims.karengatasda.orgimg/backgrounds/background.jpg
                                            System.out.println("Downloading image at "+str_url);
                                            /*Util.downloadUrlToStorageInBackground(str_url, str_view+".png", new Actionloginener() 
                                            {
                                                @Override
                                                public void actionPerformed(ActionEvent evt) 
                                                {
                                                    System.out.println("Finished downloading image "+j+" "+str_view+" for "+str_road+".");str_url
                                                }
                                            });*/

                                            lbl_progress.setText("Downloading background image, Please Wait...");

                                            //Util.downloadUrlToStorage(str_url, str_value, true);
                                            Util.downloadUrlToStorage(str_url, str_value, true);  //"https://cims.karengatasda.org/img/backgrounds/"+str_value
                                            dlg_progress.dispose();
                                            
                                            if(!Storage.getInstance().exists(str_value))
                                            {
                                                Display.getInstance().vibrate(1000);
                                                Dialog.show("Connection Error", "You should have a working internet connection to continue. Thank you.","Ok",null);
                                                Display.getInstance().exitApplication();
                                            }
                                        }
                                    }
                                    else if(str_type.equals("icon"))
                                    {
                                        bool_img = Storage.getInstance().exists(str_value);
                                        if(bool_img == true)
                                        {
                                            //int_size = Integer.parseInt(Storage.getInstance().readObject("huhi"+".png").toString().length());
                                            //Storage.getInstance().writeObject("", "");
                                            System.out.println("Already downloaded image "+i+" "+str_value+" for "+str_firstname+" = "+int_size+" bytes.");
                                            //Storage.getInstance().deleteStorageFile(str_view+".png");
                                            //LoginMenu soaime = new LoginMenu();
                                            //soaime.showLoginScreen();
                                        }
                                        else
                                        {           //str_protocol+str_host+str_path+str_port+str_param_1
                                            str_url = str_protocol + str_host + str_path + str_port+"img/icons/"+str_value; //cims.karengatasda.orgimg/backgrounds/background.jpg
                                            System.out.println("Downloading image at "+str_url);
                                            /*Util.downloadUrlToStorageInBackground(str_url, str_view+".png", new Actionloginener() 
                                            {
                                                @Override
                                                public void actionPerformed(ActionEvent evt) 
                                                {
                                                    System.out.println("Finished downloading image "+j+" "+str_view+" for "+str_road+".");str_url
                                                }
                                            });*/

                                            lbl_progress.setText("Downloading background image, Please Wait...");

                                            //Util.downloadUrlToStorage(str_url, str_value, true);
                                            Util.downloadUrlToStorage(str_url, str_value, true);  //"https://cims.karengatasda.org/img/backgrounds/"+str_value
                                            dlg_progress.dispose();
                                            
                                            if(!Storage.getInstance().exists(str_value))
                                            {
                                                Display.getInstance().vibrate(1000);
                                                Dialog.show("Connection Error", "You should have a working internet connection to continue. Thank you.","Ok",null);
                                                Display.getInstance().exitApplication();
                                            }
                                        }
                                    }
                                    else if(str_type.equals("theme"))
                                    {
                                        try
                                        {
                                            if(!Storage.getInstance().exists(str_value))
                                            {
                                                //frmHome.setTitle("Getting your theme from iClips-Server...");
                                                Log.p("Going to download resource file... "+str_protocol + str_host +  str_path + str_port+"img/themes/"+str_value, 1);
                                                Util.downloadUrlToStorage(str_protocol + str_host +  str_path + str_port+"img/themes/"+str_value, str_value, true);
                                                //Util.downloadUrlToStorage("https://cims.karengatasda.org/img/themes/theme.res", "theme.res", true);
                                                

                                                if(!Storage.getInstance().exists("theme.res"))
                                                {
                                                    Display.getInstance().vibrate(1000);
                                                    Dialog.show("Connection Error", "You should have a working internet connection to continue. Thank you.","Ok",null);
                                                    Display.getInstance().exitApplication();
                                                }
                                            }
                                            else
                                            {
                                                Log.p("Theme.res resource file already downloaded.", 1);
                                            }
                                        }
                                        catch(Exception ex) 
                                        {
                                            Log.e(ex);
                                        }
                                    }
                                    else
                                    {
                                        //Log.p("Heading to login menu.", 1);
                                        //LoginMenu soaime = new LoginMenu();
                                        //soaime.showLoginScreen();
                                    }
                                    
                                    i = i+1;
                                }
                                
                                
                            }
                            catch(Exception ex) 
                            {
                                    Log.e(ex);
                            }

                            
                            Log.p("Heading to login menu.", 1);
//                            Login soaime = new Login();
//                            soaime.loginscreen();
//                            
                        }
                        else
                        {
                             handleError();
                        }
                    }
                    else
                    {
                        handleError();
                    }
                }
            else if(str_param_1.equals("passwordchange"))
            {
                if(request.getResponseCode() == 200)
                {
                    str_response = Storage.getInstance().readObject("response").toString();
                    str_train = str_response.substring(0);
                   
                    Log .p("Writing "+str_param_1+"'s server response to storage.", 1);
                    Storage.getInstance().writeObject(str_param_1+".json", str_train); //str_carriage
        
                    JSONParser json_parser = new JSONParser();
                    Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                   
                    String str_respcode = String.valueOf(request.getResponseCode());
                    Storage.getInstance().writeObject("respcode", str_respcode);
                                               
                    if(request.getResponseCode() == 200){} //check length or size of data, if greater than 0, write uderdetails.json to storage
                   
                    try 
                    {
                        String str_result = map_response.get("Result").toString();
                        String str_mesage = map_response.get("Message").toString();

                        System.out.println(">>Result: "+str_result);
                        System.out.println(">>Message: "+str_mesage);

                        
                        
                        okayDialog(str_result+"!", str_mesage);
                        
                        //Storage.getInstance().writeObject("parameter1", "prices");
                        //Storage.getInstance().writeObject("parameter2", "update");
                        //Connect conn = new Connect();
                        //conn.process();
                        
                        if(str_result.equals("Error"))
                        {
                            //MainMenu mainmenuer = new MainMenu();
                            //mainmenuer.showMainScreen();
                        }
                        else
                        {
                            //Storage.getInstance().writeObject("loginstatus", "NOL");
                            Storage.getInstance().clearStorage();
                            //LoginMenu loginer = new LoginMenu();
                            //loginer.showMainScreen();
                        }
                    }
                    catch (Exception e) 
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    handleError();
                }
            }
            else if(str_param_1.equals("finish"))
            {
                if(request.getResponseCode() == 200)
                {
                    str_response = Storage.getInstance().readObject("response").toString();
                    //str_train = StringUtil.tokenize(str_response, '[').get(1);
                    //str_carriage = StringUtil.tokenize(str_train, "]\"}]").get(0);
                    //str_data = '['+str_carriage+"]\"}]"; //"}]

                    JSONParser json_parser = new JSONParser();
                    Map map_response = json_parser.parseJSON(new InputStreamReader(new ByteArrayInputStream(dataa), "UTF-8"));
                    
                    String str_respcode = map_response.get("code").toString();
                    String str_resptext = map_response.get("message").toString();
                    String str_respdata = map_response.get("data").toString();
                    
                    Log .p("Writing "+"messages"+" server response to storage.", 1);
                    Storage.getInstance().writeObject("messages"+".json", str_response);
                    
                    Storage.getInstance().writeObject("respcode", str_respcode);
                    Storage.getInstance().writeObject("resptext", str_resptext);
                    Storage.getInstance().writeObject("respdata", str_respdata);
                    
                    Storage.getInstance().writeObject("parameter1", "finish"); //transaction
                    Storage.getInstance().writeObject("parameter2", "2017-06-25 10:35:48"); //update date
                    Storage.getInstance().writeObject("parameter3", ""); //alert message
                    
                    Storage.getInstance().writeObject("updatestatus", "2017-06-25 10:35:48"); 
                            
                    //MainMenu mainmenu = new MainMenu();
                    //mainmenu.showMainScreen();
                }
                else
                {
                    handleError();
                }
            }
            else
            {
                handleError();
            }
    }
    
    public void handleError()// throws UnsupportedEncodingException, IOException//, JSONException 
    {
        System.err.println("========= handling Error ========");
        
        String rescode = (String) Storage.getInstance().readObject("respcode");
        String resmesg = (String) Storage.getInstance().readObject("resptext");
        

        if(Double.parseDouble(rescode) == 403.0) //if (Double.parseDouble(rescode) == 3002.0) 
        {
            okayDialog("Login Failed!\n: ", "Your username/password combination may be wrong.");
            //LoginMenu loginer = new LoginMenu();
            //loginer.showMainScreen();
        } 
        else if(Double.parseDouble(rescode) == 401.0) //if (Double.parseDouble(rescode) == 3002.0) 
        {
            //okayDialog("Login Failed!\n: ", "Your username is in the wrong format.... it should be an email."); //TODO: force email as username during registration
            okayDialog("Login Failed!\n: ", "Your username/password combination may be wrong.");
            //LoginMenu loginer = new LoginMenu();
            //loginer.showMainScreen();
        }
        else if(Double.parseDouble(rescode) == 3004.0) 
        {
            okayDialog("Sorry, Session Expired!\n: ", "The Process could not complete, please login and try again later.");
            //doBackgroundLogin();
                Log.p("Deleting content of stoage.", 1);
                storage.clearStorage();

                Log.p("Writing logout status in storage.", 1);
                storage.writeObject("loginstatus", "NOL");

                Log.p("Writing current screen in storage.", 1);
                storage.writeObject("screen", "home");

                Log.p("Going to the Main Menu.", 1);
                //MainMenu menuer = new MainMenu();
               //menuer.showMainScreen();
        } 
        else if (Double.parseDouble(rescode) == 3003.0) 
        {
            okayDialog("Sorry!\n: ", "Your Account is inactive, contact support for help.");
        } 
        else if (Double.parseDouble(rescode) == 4002.0) 
        {
            okayDialog("Error!\n: ", "The email you entered is not valid, check it and try again.");
        } 
        else if (Double.parseDouble(rescode) == 4003.0) 
        {
            okayDialog("Sorry!\n: ", "The email address you entered is already in use, please choose another one.");
        } 
        else if (Double.parseDouble(rescode) == 6001.0) 
        {
            okayDialog("Sorry!\n: ", "Your cart is empty, add a beneficiary to make the order.");
        } 
        else if (Double.parseDouble(rescode) == 7004.0) 
        {
            okayDialog("Error!\n: ", "The policy's start date cannot be in the past, select a valid date to continue.");
        } else if (Double.parseDouble(rescode) == 7005.0) {
            okayDialog("Error!\n: ", "The beneficiary already exists.");
        } else if (Double.parseDouble(rescode) == 1011.0) {
            okayDialog("Error!\n: ", "There are Input values that are missing.");
        }
        else if (Double.parseDouble(rescode) == 1012.0) {
            okayDialog("Note: \n: ", "Select the Policy Start Date to Proceed.");
        }
        else if (Double.parseDouble(rescode) == 2002.0) 
        {
            okayDialog("Card Invalid!", "The card you have entered has already been used or has expired.");
            storage.writeObject("screen", "card");
            //viewCart();       
            
        }
        else if (Double.parseDouble(rescode) == 2001.0) 
        {
            okayDialog("Card Invalid!", "The card is Invalid. Check the PIN and try again");
        }
        else if (Double.parseDouble(rescode) == 2005.0) 
        {
            okayDialog("Payment Error!", "The scratch card can only be used to Pay for one individual at a time. Your Cart has more than one Item. Please delete the extra Items from the cart to continue.");
        }
        else if (Double.parseDouble(rescode) == 200.0) 
        {
            //Impossible... not handled here
        }
        else if (Double.parseDouble(rescode) == 409.0) 
        {
            str_screen = Storage.getInstance().readObject("screen").toString();
            if(str_screen.equals("registration"))
            {
                okayDialog("Sorry"+"!", "Email or phone number already used. Check that you have entered the correct ones and try again otherwise please proceed to login if you are already registered.");
            }
            else if(str_screen.equals("verification"))
            {
                okayDialog("Sorry"+"!", "Email or phone number already used. Check that you have entered the correct ones and try again otherwise please proceed to login if you are already registered.");
            }
            else
            {
                okayDialog("Sorry"+"!", "Already used or exists!\nPlease check that you have entered the data correctly and try again.");
            }
        }
        
        
        /*
        //Informational 1xx
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
        
        else 
        {
            okayDialog("Sorry!\n: ", "Something went wrong,\n Error: "+rescode+" - "+ resmesg);
            
            if(str_param_1.equals("transaction"))
            {
                /*if(rescode.equals("409"))
                {
                    //String resdata = (String) Storage.getInstance().readObject("respdata");
                    //System.err.println(">>>>>>>> "+Storage.getInstance().readObject("respdata")+" >>>>>>>>");
                    //Storage.getInstance().writeObject("temp_member_no", Storage.getInstance().readObject("respdata"));
                    
                    //Storage.getInstance().writeObject("usertype", "member");
                }
                else
                {
                    dlg_payments3.dispose();
                }
                */
                //dlg_payments3.dispose();
                
            }
            else
            {
            }
               
            //Dialog.show("Oops!!!", "A network error occured.\nError "+code+": "+message, "Ok", null);
            //HomeMenu home = new HomeMenu();
            //home.showMainScreen();
        }
    }
    
    
    /*  
        //TODO: Add logic for checking if photo was already uploaded.
        bool_upload_status = Storage.getInstance().exists("uploadstatus");
        if(bool_upload_status == true)
        {
            str_upload_status = Storage.getInstance().readObject("uploadstatus").toString();
            if(str_upload_status.equals("ok"))
            {
                System.out.println("Photo was already uploaded, please click view pic and delete the previous."); //TODO: Add provision for this.
                sendPhoto();
            }
            else
            {
                sendPhoto();
            }
        }
        else
        {
            System.out.println("Photo not yet uploaded, doing upload now.");
            sendPhoto();
        }
    */
    public void doPhotoUpload() 
    {
        System.out.println("Inside Connect.java - doPhotoUpload");
        
        MultipartRequest request = new MultipartRequest() 
        {
           protected void readResponse(InputStream input) throws IOException  
           {
              JSONParser jp = new JSONParser();
              Map<String, Object> result = jp.parseJSON(new InputStreamReader(input, "UTF-8"));
              
                Object str_stat = (String)result.get("Status");
                Object obj_resp = result.get("Response"); 
                str_response = (String)result.get("Status");
                System.out.println("JSON Response Status from server: "+str_stat);
                
                if(str_stat.equals("ok"))
                {
                    Storage.getInstance().writeObject("uploadstatus", "ok");
                    Dialog.show("Transaction Successful!!", "Thanks for supporting the work of the Lord. Please await a confirmation SMS from us.", "Ok", null);
                    //HomeScreen homer = new HomeScreen();
                        //homer.showMainForm();
                }
                else
                {
                    Storage.getInstance().writeObject("uploadstatus", "no");
                    Dialog.show("Error Occured!", "The server was unable to save your photo. It may be an invalid file, may be too large or an unknown error occured! "+str_stat, "Ok", null);
                    //HomeScreen homer = new HomeScreen();
                       // homer.showMainForm();
                }
           }
           
           protected void handleErrorResponseCode(int code, String message)
           {
                Log.p("Error Response->" + message);
           }

           protected void readHeaders(Object connection) throws IOException 
           {
                String val = getHeader(connection, "MyHeaderName");
                Log.p("Header Response->" + val);

           }

           protected void handleException(Exception err) 
           {
                Dialog.show("Connection Err!!", "Are you connected to the internet? Check your connection", "Ok", null);
           }
        };
        request.setUrl(str_photoUrl);
                
        str_userid = Storage.getInstance().readObject("userid").toString();
                
        bool_trxnid = Storage.getInstance().exists("trx_number");
        if(bool_trxnid == true)
        {
            
            if(!str_trxnid.equals(""))
            {
                str_trxnid = Storage.getInstance().readObject("trx_number").toString();
            }
            else
            {
                str_trxnid = Integer.toString(new Random().nextInt(1999));
            }
        }
        else
        {
            str_trxnid = Integer.toString(new Random().nextInt(1999));
        }
        
        System.out.println("Uploading Image: station_"+str_trxnid+".jpg");
        
        str_mimeType = "image/png";
        str_fileName = "MyImage.png";
        
        try 
        {
            is = Storage.getInstance().createInputStream(str_fileName);
                        
            str_mimeType = "image/jpeg"; //image/png
            request.addData("file", is, Storage.getInstance().entrySize(str_fileName), str_mimeType);
            //request.addData("file", picture, "image/jpeg");
            request.addArgument("userid", str_userid);
            request.setFilename("file", str_trxnid+".jpg");
            
            request.setReadResponseForErrors(true);
            request.addResponseCodeListener(new ActionListener<NetworkEvent>() 
            {
                @Override
                public void actionPerformed(NetworkEvent evt) 
                {
                    NetworkEvent event = (NetworkEvent) evt;
                    Log.p("Err Rsp Code->" + event.getResponseCode());
                    Log.p("ResponseCodeListener:");
                    Log.p(evt.toString());
                }
            });
            
            NetworkManager.getInstance().addToQueue(request);
            System.err.println("Response Data: "+Arrays.toString(request.getResponseData()));
        } 
        catch(IOException err) 
        {
            err.printStackTrace();
        }
    
}
    
    public void getUser()
    {
        Log.p("Inside Connect.java - getUser", l);
        
        str_username = Storage.getInstance().readObject("username").toString();
        str_password = Storage.getInstance().readObject("password").toString();
        
        final String InputParameter = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:gek=\"http://GeKeAPI/\">\n" +
                                                "   <soap:Header/>\n" +
                                                "   <soap:Body>\n" +
                                                "      <gek:getUser>\n" +
                                                "         <!--Optional:-->\n" +
                                                "         <phonenum>"+str_username+"</phonenum>\n" +
                                                "         <!--Optional:-->\n" +
                                                "         <appid>APX17V1506kGE</appid>\n" +
                                                "         <!--Optional:-->\n" +
                                                "         <userpin>"+str_password+"</userpin>\n" +
                                                "      </gek:getUser>\n" +
                                                "   </soap:Body>\n" +
                                                "</soap:Envelope>";
                  
                  
                  ConnectionRequest request = new ConnectionRequest()
                  {
                        @Override
                        protected void buildRequestBody(OutputStream os) throws IOException 
                        {
                            //os.write(InputParameter.getBytes("UTF-8"));
                            
                            Writer writer = null;
                            writer = new OutputStreamWriter(os, "UTF-8");
                            writer.write(InputParameter);
                            writer.flush();
                            writer.close();
                        }
                        
                        @Override
                        protected void postResponse() 
                        {
                            //super.postResponse();
                        }
                        
                        int chr;
                        StringBuffer sb = new StringBuffer();
                        String str_response;
                        @Override
                        protected void readResponse(InputStream input) throws IOException 
                        {
                            XMLParser parser = new XMLParser();
                            Element elem = parser.parse(new InputStreamReader(input));
                            str_response = elem.getChildAt(0).getChildAt(0).getChildAt(0).getChildAt(0).getText().trim();
                            
                            str_login_status = StringUtil.tokenize(str_response, "|").get(0).trim();
                            str_data = StringUtil.tokenize(str_response, "|").get(1).trim();

                            if (str_login_status.equals("OK"))  
                            {
                                str_agent_id    = StringUtil.tokenize(str_data, ";").get(0).trim();
                                str_agent_name  = StringUtil.tokenize(str_data, ";").get(1).trim();
                                str_aspirant_id = StringUtil.tokenize(str_data, ";").get(2).trim();
                                str_station_id  = StringUtil.tokenize(str_data, ";").get(3).trim();
                                
                                Storage.getInstance().writeObject("agent_id", str_agent_id);
                                Storage.getInstance().writeObject("agent_name", str_agent_name);
                                Storage.getInstance().writeObject("aspirant_id", str_aspirant_id);
                                Storage.getInstance().writeObject("station_id", str_station_id);
                                
                                Dialog.show("Login Successful!!", "Thanks for using the campaign app.", "Ok", null);
                                //HomeScreen cls_home = new HomeScreen();
                                //cls_home.showHomeScreen();
                            }
                            else
                            {
//                                Dialog.show("Login Failed!!", "Your login credentials are wrong.", "OK", null);
//                                Login loginer = new Login();
//                                loginer.loginscreen();
                            }
                        }  
                        
                        protected void handleErrorResponseCode(int code, String message)
                        {
                             Log.p("Error Response->" + message);
                        }

                        protected void readHeaders(Object connection) throws IOException 
                        {
                             String val = getHeader(connection, "MyHeaderName");
                             Log.p("Header Response->" + val);

                        }

                        protected void handleException(Exception err) 
                        {
                             Dialog.show("Yikes!!", "Connection Error!!! Are you connected to the internet?", "Ok", null);
                        }
                  };
                  request.setUrl(str_loginUrl);
                  request.setPost(true);
                  request.setContentType("application/soap+xml;charset=UTF-8");
                  request.addRequestHeader("accept", "application/soap+xml");
                  request.setReadResponseForErrors(true);
                  
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
                    
        
                  NetworkManager.getInstance().addToQueueAndWait(request);
                  request.setDisposeOnCompletion(dlg_progress);
    }
    
    public void getPortfolio()
    {
        Log.p("Inside Connect.java - getAspirants", l);
        
        Storage.getInstance().writeObject("screen", "aspirants");
         final String InputParameter = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:gek=\"http://GeKeAPI/\">\n" +
"   <soap:Header/>\n" +
"   <soap:Body>\n" +
"      <gek:getAllAspirants>\n" +
"         <!--Optional:-->\n" +
"         <userid>"+Storage.getInstance().readObject("agent_id").toString()+"</userid>\n" +
"         <!--Optional:-->\n" +
"         <appid>APX17V1506kGE</appid>\n" +
"         <!--Optional:-->\n" +
"         <position_name>"+Storage.getInstance().readObject("position")+"</position_name>\n" +
"      </gek:getAllAspirants>\n" +
"   </soap:Body>\n" +
"</soap:Envelope>";
          
                  ConnectionRequest request = new ConnectionRequest()
                  {
                        /*@Override
                        protected void handleErrorResponseCode(int code, String message)
                        {
                             Log.p("Error Response->" + message);
                        }
                        
                        @Override
                        protected void handleException(Exception err) 
                        {
                             Dialog.show("Yikes!!", "Connection Error!!! Are you connected to the internet?"+err, "Ok", null);
                        }

                        @Override
                        protected void readHeaders(Object connection) throws IOException 
                        {
                             String val = getHeader(connection, "MyHeaderName");
                             Log.p("Header Response->" + val);
                        }*/
                        
                        @Override
                        protected void buildRequestBody(OutputStream os) throws IOException 
                        {
                            Writer writer = null;
                            writer = new OutputStreamWriter(os, "UTF-8");
                            writer.write(InputParameter);
                            writer.flush();
                            writer.close();
                        }
                        
                        /*@Override
                        protected void postResponse() 
                        {
                        }*/
                        
                        int chr;
                        StringBuffer sb = new StringBuffer();
                        String str_response;
                        @Override
                        protected void readResponse(InputStream input) throws IOException 
                        {
                            XMLParser parser = new XMLParser();
                            Element elem = parser.parse(new InputStreamReader(input));
                            
                            str_response = elem.getChildAt(0).getChildAt(0).getChildAt(0).getChildAt(0).getText().trim();
                            str_response_code = StringUtil.tokenize(str_response, "|").get(0).trim(); System.out.println("Fetch Aspirants Response Data: >>"+str_response_code);//DEBUG
                            str_response_data = StringUtil.tokenize(str_response, "|").get(1).trim(); System.out.println("Fetch Aspirants Response Code: >>"+str_response_data);//DEBUG
                            
                            Storage.getInstance().writeObject("aspirants", str_response_data);
                            
                            if(str_response_code.equals("OK"))  
                            {    
                                str_needle = "^";
                                str_haystack = str_response_data;
                                int lastIndex = 0;
                                int count = 0;
                                
                                while (lastIndex != -1) 
                                {
                                    lastIndex = str_haystack.indexOf(str_needle, lastIndex);

                                    if (lastIndex != -1) 
                                    {
                                        count++;
                                        lastIndex += str_needle.length();
                                    }
                                }
                                Storage.getInstance().writeObject("no_aspirants", count); System.out.println("No. of Aspirants: >"+count);
                                //PortfolioMenu porti = new PortfolioMenu();
                                //porti.showMainScreen();
                            }
                            else//(str_response_code.equals("FAIL"))  
                            {
                                Dialog.show(str_response_code+" - Awww!!!", "Unable to fetch list of Aspirants. "+str_response_data, "OK", null);
                                //PortfolioMenu porti = new PortfolioMenu();
                                //porti.showMainScreen();
                            }
                        }
                  };
                  
                  request.setReadResponseForErrors(true);
                  request.setUrl(str_aspirantsUrl);
                  request.setContentType("application/soap+xml;charset=UTF-8");
                  request.addRequestHeader("accept", "application/soap+xml");
                  request.setPost(true);
                  request.setWriteRequest(true);
                  
                  
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
                  
                  NetworkManager.getInstance().addToQueueAndWait(request);
                  request.setDisposeOnCompletion(dlg_progress);
                  
//                    byte[] dataa = request.getResponseData();
//                    if (dataa == null) 
//                    {
//                        Dialog.show("Connection Failed", "Network Error, Check Your Internet Connection", "Ok", null); 
//                        return;
//                    }
                    
                    
                  
    }
    
    public static void okayDialog(String title, String messageToDisplay) 
    {
        final Dialog dialog = new Dialog(title);
        dialog.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Button button = new Button("Okay");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dialog.dispose();
            }
        });
        Container okayDialog = new Container();
        Container messageDialog = new Container();
        TextArea message = new TextArea(messageToDisplay);
        message.setEditable(false);
        okayDialog.setLayout(new FlowLayout(Component.CENTER));
        messageDialog.setLayout(new FlowLayout(Component.CENTER));
        messageDialog.addComponent(message);
        okayDialog.addComponent(button);
        messageDialog.addComponent(okayDialog);
        dialog.addComponent(messageDialog);
        dialog.show();
    }

}

