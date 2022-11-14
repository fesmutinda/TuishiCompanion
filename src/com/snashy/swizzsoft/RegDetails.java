
package com.snashy.swizzsoft;

import com.codename1.io.Storage;
import com.codename1.processing.Result;
import com.codename1.ui.Dialog;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author Festus 
 */
public class RegDetails 
{
    public void sendDetails()
    {
        /*
        ---------NOW THIS CLASS SENDS ALL THE DATA......        
        */
        String Package=Storage.getInstance().readObject("PackageType").toString();
        String Savings=Storage.getInstance().readObject("Savingscheck").toString();
        String MemberShipCode=Storage.getInstance().readObject("MemberShipCode").toString();
        String MpesaCode=Storage.getInstance().readObject("MpesaCode").toString();
        
        String FirstName=Storage.getInstance().readObject("FirstName").toString();
        String MiddleName=Storage.getInstance().readObject("MiddleName").toString();
        String Surname=Storage.getInstance().readObject("Surname").toString();
        String DateofBirth=Storage.getInstance().readObject("DateofBirth").toString();
        String Gender=Storage.getInstance().readObject("Gender").toString();
        String NationalID=Storage.getInstance().readObject("NationalID").toString();
        String MaritalStatus=Storage.getInstance().readObject("MaritalStatus").toString();
        String County=Storage.getInstance().readObject("County").toString();
        String Village=Storage.getInstance().readObject("Village").toString();
        String PostalAddress=Storage.getInstance().readObject("PostalAddress").toString();
        String Contact=Storage.getInstance().readObject("Contact").toString();
        
        String UserName=Storage.getInstance().readObject("UserName").toString();

        Hashtable hash=new Hashtable();
        hash.put("FirstName", FirstName);
        hash.put("MiddleName", MiddleName);
        hash.put("Surname", Surname);
        hash.put("DateofBirth", DateofBirth);
        hash.put("Gender", Gender); 
        hash.put("NationalID", NationalID);
        hash.put("MaritalStatus", MaritalStatus);
        hash.put("County", County);
        hash.put("Village", Village);
        hash.put("PostalAddress", PostalAddress);
        hash.put("Contact", Contact); 
        hash.put("Package", Package); 
        hash.put("Savings", Savings); 
        hash.put("MemberShipCode", MemberShipCode); 
        hash.put("UserName", UserName); 
        hash.put("MpesaCode", MpesaCode); 


        final Result res=Result.fromContent(hash);
        final String checkthis=res.toString();

//        String myUrl="http://localhost:50111/Registration";
        String myUrl="https://b2cmanager.co.ke/TUISHIMOBWB/Registration";
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
           new DependantsForm().Regstrationscreen();
        }
        else if(Reply.equals("sorry"))
        {
            Dialog.show("SORRY!!!", "That National Id already exists in our Database", "OK", null);
        }
        else if(Reply.equals("number_exist"))
        {
            Dialog.show("SORRY!!!", "That Phone Number already exists in our Database", "OK", null);
        }
        else
        {
            Dialog.show("Error", "Something went wrong, try checking your connection and try again later.", "OK", null);
        } 
    }
}
