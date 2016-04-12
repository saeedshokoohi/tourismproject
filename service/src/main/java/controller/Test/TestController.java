package controller.Test;


import domain.Test.Personnel;
import domain.Test.PersonnelOverTime;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import repository.Test.TestRepository;

import util.MessageUtil;
import util.ResourcesUtil;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by saeed on 15/12/2015.
 */
@Named
public class TestController {


    @Inject
    TestRepository testRepository;
    @Inject
    ResourcesUtil resourcesUtil;

    @Inject
    MessageUtil messageUtil;
    public void save(Personnel entity)
    {

        try {
             testRepository.saveOrUpdate(entity);
            messageUtil.addInfoMessage("","saved_successfully");
        }catch (Exception ex)
        {
            ex.printStackTrace();
            messageUtil.addErrorMessage("","saved_failed",ex.getMessage());
        }
    }

    public Personnel init(Personnel entity) {
        return new Personnel();
    }
    private UploadedFile ruleFile;

    public UploadedFile getRuleFile() {
        return ruleFile;
    }

    public void setRuleFile(UploadedFile file) {
        this.ruleFile = file;
    }
    public void uploadRuleFile() {

        if(ruleFile!=null) {
            FacesMessage message = new FacesMessage("Succesful", ruleFile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public static boolean isNationalCodeValid(String code)
    {
        if(code.length()<10)
        return true;
        else
            return false;
    }







}
